package com.arana.oruije_messaging;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.arana.oruije_messaging.R;
import com.eunoia.oruije.Database;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.os.Environment.DIRECTORY_PICTURES;

public class Chat extends AppCompatActivity implements BottomSheet.BottomSheetListener{

    Session session;
    com.eunoia.oruije.Database db;
    ImageView gallery,go_back;
    EditText message;
    ImageButton send_message;
    
    TextView user_name,user_position;
    ListView chats;
    ArrayList<ChatListModel> chatListModels;
    private static ChatListAdapter chatListAdapter;
    String get_username,get_user_position,get_user_category,author_id,get_friend_id;
    Bitmap bt;
    CircleImageView user_image_recipient;
    ImageView pick_from_camera_or_gallery;
    public static final int REQUEST_IMAGE_CAPTURE = 101;
    public static final int REQUEST_IMAGE_FROM_GALLERY = 201;
    private Bitmap imageBitmap;
    public Boolean IS_NEW =true;

    String pictureFilePath;
    RelativeLayout single, multiple;
    ListView multiple_listview;
    LinearLayout initials;
    
    Cursor chat_lists;
    ArrayList<String> array;
    String intent_type;
    Uri imageUri;
    BottomSheet bottomSheet;
    LinearLayout chat_toolbar;
    Toolbar toolbar;
    TextView choose_image_text;
    boolean fromChooseImage = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        session = new Session(this);
        db = new Database(this);

        session.post_message(true);


        get_friend_id = getIntent().getStringExtra("user_id"); //from previous intent

        intent_type = getIntent().getStringExtra("intent_type"); //from previous intent

        user_name = findViewById(R.id.user_name);
        user_position = findViewById(R.id.user_position);
        user_image_recipient = findViewById(R.id.user_image_recipient);
        go_back = findViewById(R.id.go_back);
        pick_from_camera_or_gallery = findViewById(R.id.pick_from_camera_or_gallery);
        chat_toolbar = findViewById(R.id.chat_toolbar);
        chat_toolbar.setVisibility(View.VISIBLE);

        single = findViewById(R.id.single);
        multiple = findViewById(R.id.multiple);
        multiple_listview = findViewById(R.id.multi_post_listview);
        initials = findViewById(R.id.initials);
        choose_image_text = findViewById(R.id.choose_image_text);

        chats = findViewById(R.id.chats);
        chatListModels = new ArrayList<>();

//        gallery = (ImageView) findViewById(R.id.gallery);
        message = findViewById(R.id.message);
        send_message = findViewById(R.id.send_message);


        if (intent_type.equalsIgnoreCase("single")) {

            single.setVisibility(View.VISIBLE);
            multiple.setVisibility(View.INVISIBLE);
            user_image_recipient.setVisibility(View.VISIBLE);

            pick_from_camera_or_gallery.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    bottomSheet = new BottomSheet();
                    bottomSheet.show(getSupportFragmentManager(), "Bottom sheet");
                }
            });

            Cursor get_a_user = db.get_a_user(get_friend_id);
            if (get_a_user.getCount() > 0) {
                get_a_user.moveToFirst();
                get_username = get_a_user.getString(1);
                get_user_position = get_a_user.getString(3);
                get_user_category = get_a_user.getString(5);
                byte[] get_user_image = get_a_user.getBlob(4);
                bt = BitmapFactory.decodeByteArray(get_user_image, 0, get_user_image.length);

                user_image_recipient.setImageBitmap(bt);
            }

            user_name.setText(get_username);
            user_position.setText(get_user_position);

            chat_lists = db.displayChats(session.getUserId(), get_friend_id);
            chat_lists.moveToFirst();

            if (chat_lists.getCount() > 0) {
                do{  //loading previously initiated chats
//                    byte[] bytt = chat_lists.getBlob(8);
//                    Bitmap bmp = BitmapFactory.decodeByteArray(bytt, 0, bytt.length);
                    chatListModels.add(new ChatListModel(chat_lists.getString(3), chat_lists.getString(5), chat_lists.getString(6), chat_lists.getString(4), chat_lists.getString(1), chat_lists.getString(9),chat_lists.getString(8)));
                }while(chat_lists.moveToNext());

                chatListAdapter = new ChatListAdapter(chatListModels, Chat.this);
                chats.setAdapter(chatListAdapter);

                send_message.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        populateList(message.getText().toString().trim(), false);
                        Toast.makeText(getApplicationContext(), "CHATS AVAILABLE", Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                send_message.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        populateList(message.getText().toString().trim(), IS_NEW);
                        Toast.makeText(getApplicationContext(), "NOT AVAILABLE", Toast.LENGTH_SHORT).show();
                    }
                });
            }

        }else if (intent_type.equalsIgnoreCase("multiple")){
            Bundle bundle = getIntent().getExtras();
            array = bundle.getStringArrayList("user_ids");

            single.setVisibility(View.INVISIBLE);
            user_image_recipient.setVisibility(View.GONE);
            multiple.setVisibility(View.VISIBLE);

            StringBuilder names = new StringBuilder();


            Cursor get_a_user;
            for (int y=0; y < array.size(); y++){ //get the names of the selected users
                get_a_user = db.get_a_user(array.get(y));
                if (get_a_user.getCount() > 0) {
                    TextView init = new TextView(Chat.this);
//                    initials.removeAllViews();
                    LinearLayout.LayoutParams layoutParams =
                            new LinearLayout.LayoutParams(
                                    50,
                                    50);
                    get_a_user.moveToFirst();
                    names.append(get_a_user.getString(1)).append(", ");

                    init.setText(get_a_user.getString(1).substring(0,1));
                    init.setBackgroundResource(R.drawable.blue_circle);
//                    init.setPadding(10, 5, 17, 5);
                    init.setTextColor(Color.WHITE);
//            init.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.cancel_white, 0);
//            init.setCompoundDrawablePadding(10);
                    init.setId(y);
                    init.setGravity(Gravity.CENTER);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                        init.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    }
                    init.setTag(y);
                    init.setLayoutParams(layoutParams);

                    initials.addView(init,y);
                }
            }

//                byte[] get_user_image = get_a_user.getBlob(4);
//                bt = BitmapFactory.decodeByteArray(get_user_image, 0, get_user_image.length);
//
//                user_image_recipient.setImageBitmap(bt);


            user_name.setText(array.size()+" recipients");
            user_position.setText(names);

            send_message.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Date date = new Date();
                    SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat timeformat = new SimpleDateFormat("h:mm:ss a");
                    String getDate = dateformat.format(date);
                    String getTime = timeformat.format(date);
                    String getText = message.getText().toString().trim();

                    long ccl;

                    if (!TextUtils.isEmpty(getText)) {
                        Cursor users;
                        for (int y=0; y<array.size(); y++){ //get the names of the selected users
                            users = db.get_a_user(array.get(y));
                            users.moveToFirst();
                            if (users.getCount() > 0) {
                                ccl = db.create_chat_lists(session.getUserId(),array.get(y), users.getString(3), getTime, users.getString(5), getText,"false");
                                if (ccl != -1){
                                    db.create_chat(session.getUserId(), array.get(y), getText, session.getUserId(), getDate, getTime,"unseen", "","false");
                                }
                            }
                        }
                        chatListModels.add(new ChatListModel(getText, getDate, getTime, session.getUserId(), session.getUserId(),"false",null)); //populate the listview


                        chatListAdapter = new ChatListAdapter(chatListModels, Chat.this);
                        multiple_listview.setAdapter(chatListAdapter);

                        message.setText("");
                        chats.smoothScrollToPosition(chatListAdapter.getCount() - 1);
                    }
                }
            });

        }

        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fromChooseImage){
                    getSupportFragmentManager().popBackStack();
                    chat_toolbar.setVisibility(View.VISIBLE);
                    user_image_recipient.setVisibility(View.VISIBLE);
                    choose_image_text.setVisibility(View.GONE);

                    fromChooseImage = false;
                }else{
                    finish();
                }
                hideKeys();
            }
        });
    }


    public void populateList(String getText,Boolean newchat){
        Date date = new Date();
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat timeformat = new SimpleDateFormat("h:mm:ss");
        String getDate = dateformat.format(date);
        String getTime = timeformat.format(date);

        if (!TextUtils.isEmpty(getText)) {
            Cursor check_chat = db.check_chat(session.getUserId(), get_friend_id);
            if (check_chat.getCount() > 0) {
                check_chat.moveToFirst();
                Boolean up = db.update_chat_list(session.getUserId(), get_friend_id, get_user_position, getTime, get_user_category, getText,"false");
                if (up){
                    Toast.makeText(getApplicationContext(), "chatlist updated", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "chatlist failed", Toast.LENGTH_SHORT).show();
                }
            } else {
                //this is the first time chatting with this individual
                long ccl = db.create_chat_lists(session.getUserId(), get_friend_id, get_user_position, getTime, get_user_category, getText,"false");
                if (ccl !=1){
                    Toast.makeText(getApplicationContext(), "new chat created", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "new chat not created", Toast.LENGTH_SHORT).show();
                }
            }

            long cc = db.create_chat(session.getUserId(), get_friend_id, getText, session.getUserId(), getDate, getTime,"unseen", "","false");

            if (cc !=1){
                Toast.makeText(getApplicationContext(), "new chat created", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(), "new chat not created", Toast.LENGTH_SHORT).show();
            }

            chatListModels.add(new ChatListModel(getText, getDate, getTime, session.getUserId(), session.getUserId(),"false",null)); //populate the listview

            if (newchat){
                Toast.makeText(getApplicationContext(), "new chat", Toast.LENGTH_SHORT).show();
                chatListAdapter = new ChatListAdapter(chatListModels, Chat.this);
                chats.setAdapter(chatListAdapter);
                IS_NEW = false;
            }else {
                Toast.makeText(getApplicationContext(), "old chat", Toast.LENGTH_SHORT).show();
                chatListAdapter.notifyDataSetChanged();
            }
            message.setText("");

            chats.smoothScrollToPosition(chatListAdapter.getCount() - 1);
            Toast.makeText(getApplicationContext(), "sent", Toast.LENGTH_SHORT).show();


            Cursor dis = db.allChatLists();
            dis.moveToFirst();
            do{
                Log.i("the chatlist","user_id "+dis.getString(1)+" time "+dis.getString(4)+" lastmessage "+dis.getString(6)+" OVERALL COUNT"+dis.getCount());
            }while(dis.moveToNext());
        }
    }


    @Override
    public void onBackPressed() {
        hideKeys();
        finish();
    }

    @Override
    public void onButtonClicked(String text) {
        choose(text);
    }

    public void choose(String type){
        if (type.equalsIgnoreCase("camera")){
            try {
                takePicture();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if (type.equalsIgnoreCase("gallery")){
            pickFromGallery();
        }
        bottomSheet.dismiss();
    }

    public void pickFromGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("scale", true);
        intent.putExtra("outputX", 256);
        intent.putExtra("outputY", 256);
        intent.putExtra("aspectX", 16);
        intent.putExtra("aspectY", 9);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, REQUEST_IMAGE_FROM_GALLERY);

//        Intent intent = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//        intent.setType("image/*");
//        startActivityForResult(intent.createChooser(intent,"Select Image"), REQUEST_IMAGE_FROM_GALLERY);
    }

    public void takePicture() throws IOException {
//        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
//            File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
//                    Environment.DIRECTORY_PICTURES),"Oruije");
//            try{
//                if (!mediaStorageDir.exists()){
//                    if (!mediaStorageDir.mkdirs()){}
//                        //return null;
//                }
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//            int rand = (int) (Math.random() * 1000);
//            imageUri = Uri.fromFile(new File(mediaStorageDir.getPath()+File.separator+"oruije_images"+rand+".jpg"));
//            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
//            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
//        }

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {

            File pictureFile = null;
            pictureFile = saveFile();
            if (pictureFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.arana.oruije.messaging",
                        pictureFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK && data != null) {
//            Bundle extras = data.getExtras();
//            imageBitmap = (Bitmap) extras.get("data");
//            if (imageBitmap != null) {
//                updateUi(imageBitmap);
//            }

            File imgFile = new  File(pictureFilePath);
            if(imgFile.exists()){ // image has been created
//                image.setImageURI(Uri.fromFile(imgFile));
                updateUi(Uri.fromFile(imgFile).toString());
            }

        }else if (requestCode == REQUEST_IMAGE_FROM_GALLERY && resultCode == RESULT_OK && data != null){

            Uri image_uri = data.getData();
            String path = getPath(image_uri);
            updateUi(path);
            
//            Bundle extras = data.getExtras();
//            imageBitmap = extras.getParcelable("data");
//            if (imageBitmap != null) {
//                updateUi(imageBitmap);
//            }
        }
    }

    private String getPath(Uri image_uri) {
        if (image_uri == null){
            return  null;
        }else{
            String[] projections = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(image_uri,projections,null,null,null);

            if (cursor!=null){
                int col_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                cursor.moveToFirst();

                return cursor.getString(col_index);
            }
        }
        return image_uri.getPath();
    }

    public File saveFile(){
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String pictureFile = "ORUIJE_" + timeStamp;
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = null;
        try {
            image = File.createTempFile(pictureFile,  ".jpg", storageDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
        pictureFilePath = image.getAbsolutePath();
        return image;
    }

    private void updateUi(String imageUri) {
        Date date = new Date();
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat timeformat = new SimpleDateFormat("H:mm:ss a");
        String getDate = dateformat.format(date);
        String getTime = timeformat.format(date);

//        ByteArrayOutputStream stream = new ByteArrayOutputStream();
//        imageBitmap.compress(Bitmap.CompressFormat.JPEG,100,stream);
//        byte[] btdata = stream.toByteArray();
        long ccl;
        long ins;

        Cursor check_chat = db.check_chat(session.getUserId(), get_friend_id);
        if (check_chat.getCount() > 0) {
            check_chat.moveToFirst();Boolean up = db.update_chat_list(session.getUserId(), get_friend_id, get_user_position, getTime, get_user_category, "","true");
            if (up){
                Toast.makeText(getApplicationContext(), "chatlist updated", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(), "chatlist failed", Toast.LENGTH_SHORT).show();
            }
        } else {
            //this is the first time chatting with this individual
            long ccl1 = db.create_chat_lists(session.getUserId(), get_friend_id, get_user_position, getTime, get_user_category, "","true");
            if (ccl1 !=1){
                Toast.makeText(getApplicationContext(), "new chat created", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(), "new chat not created", Toast.LENGTH_SHORT).show();
            }
        }
        db.create_chat(session.getUserId(), get_friend_id, "", session.getUserId(), getDate, getTime,"unseen",imageUri,"true"); //
        chatListModels.add(new ChatListModel("", getDate, getTime, session.getUserId(), session.getUserId(),"true",imageUri)); //populate the listview
        chatListAdapter.notifyDataSetChanged();
    }

//    private String getRealPathFromUri(Uri imageUri) {
//        try{
//            Cursor c = getContentResolver().query(imageUri, null, null, null, null);
//            c.moveToFirst();
//            int index = c.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
//            return c.getString(index);
//        }catch (Exception e){
//            e.printStackTrace();
//            return null;
//        }
//    }

    public void hideKeys(){
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        View vw = this.getCurrentFocus();
        if(vw!=null){

            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(vw.getWindowToken(),0);
        }
    }

    public void loadSingle(){

    }

    public void loadMultiple(){

    }
}
