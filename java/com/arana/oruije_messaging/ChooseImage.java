package com.arana.oruije_messaging;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.arana.oruije_messaging.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ChooseImage.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ChooseImage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChooseImage extends Fragment {
    private static final String IMAGE = "Image";
    private static final String FRIEND_ID = "Friend_id";
    private static final String USER_POSITION = "User_position";
    private static final String USER_CATECORY = "User_category";


    private byte[] getImage;
    private String get_friend_id;
    private String get_user_position;
    private String get_user_category;


    public static final int REQUEST_IMAGE_CAPTURE = 100;
    EditText caption;
    ArrayList<ChatListModel> chatListModels;
    Session session;
    com.eunoia.oruije.Database db;
    Bitmap bt;
    ByteArrayOutputStream stream;


    private OnFragmentInteractionListener mListener;

    public ChooseImage() {
        // Required empty public constructor
    }

    public static ChooseImage newInstance(byte[] imageUri,String friend_id,String user_position, String user_category) {
        ChooseImage fragment = new ChooseImage();
        Bundle args = new Bundle();
        args.putByteArray(IMAGE, imageUri);
        args.putString(FRIEND_ID,friend_id);
        args.putString(USER_POSITION,user_position);
        args.putString(USER_CATECORY,user_category);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            getImage = getArguments().getByteArray(IMAGE);
            get_friend_id = getArguments().getString(FRIEND_ID);
            get_user_category = getArguments().getString(USER_CATECORY);
            get_user_position = getArguments().getString(USER_POSITION);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_choose_image, container, false);
//        Bitmap bitmap = BitmapFactory.decodeFile(String.valueOf(new File(getImage)));

        bt = BitmapFactory.decodeByteArray(getImage, 0, getImage.length);
        ImageView image_preview = v.findViewById(R.id.image_preview);

        ImageView select_another_image = v.findViewById(R.id.select_another_image);
        ImageButton upload_image = v.findViewById(R.id.upload_image);
        caption = v.findViewById(R.id.caption);

        session = new Session(getActivity());
        db = new com.eunoia.oruije.Database(getActivity());

        chatListModels = new ArrayList<>();

        select_another_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
            }
        });

        upload_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getCaption = caption.getText().toString().trim();
                Date date = new Date();
                SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat timeformat = new SimpleDateFormat("H:mm:ss a");
                String getDate = dateformat.format(date);
                String getTime = timeformat.format(date);

                stream = new ByteArrayOutputStream();
                bt.compress(Bitmap.CompressFormat.JPEG,100,stream);
                byte[] btdata = stream.toByteArray();
                long ccl;
                long ins;

                if (TextUtils.isEmpty(getCaption)) {
                    Cursor check_chat = db.check_chat(session.getUserId(), get_friend_id);
                    if (check_chat.getCount() > 0) {
                        check_chat.moveToFirst();Boolean up = db.update_chat_list(session.getUserId(), get_friend_id, get_user_position, getTime, get_user_category, "","true");
                        if (up){
                            Toast.makeText(getActivity(), "chatlist updated", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getActivity(), "chatlist failed", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        //this is the first time chatting with this individual
                        long ccl1 = db.create_chat_lists(session.getUserId(), get_friend_id, get_user_position, getTime, get_user_category, "","true");
                        if (ccl1 !=1){
                            Toast.makeText(getActivity(), "new chat created", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getActivity(), "new chat not created", Toast.LENGTH_SHORT).show();
                        }
                    }

//                    chatListModels.add(new ChatListModel("", getDate, getTime, session.getUserId(), session.getUserId())); //populate the listview
//                    ccl = db.create_chat_lists(session.getUserId(), get_friend_id, get_user_position, getTime, get_user_category, "","true"); //
//                    ins = db.create_chat(session.getUserId(), get_friend_id, "", session.getUserId(), getDate, getTime,"unseen",btdata,"true"); //
                }else{
                    Cursor check_chat = db.check_chat(session.getUserId(), get_friend_id);
                    if (check_chat.getCount() > 0) {
                        check_chat.moveToFirst();
                        Boolean up = db.update_chat_list(session.getUserId(), get_friend_id, get_user_position, getTime, get_user_category, getCaption,"true");
                        if (up){
                            Toast.makeText(getActivity(), "chatlist updated", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getActivity(), "chatlist failed", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        //this is the first time chatting with this individual
                        long ccl1 = db.create_chat_lists(session.getUserId(), get_friend_id, get_user_position, getTime, get_user_category, getCaption,"true");
                        if (ccl1 !=1){
                            Toast.makeText(getActivity(), "new chat created", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getActivity(), "new chat not created", Toast.LENGTH_SHORT).show();
                        }
                    }

                    ccl = db.create_chat_lists(session.getUserId(), get_friend_id, get_user_position, getTime, get_user_category, getCaption,"true"); //"true"
//                    chatListModels.add(new ChatListModel(getCaption, getDate, getTime, session.getUserId(), session.getUserId())); //populate the listview
//                    ins = db.create_chat(session.getUserId(), get_friend_id, getCaption, session.getUserId(), getDate, getTime,"unseen",btdata,"true"); //btdata
                }

//                if (ins != -1){
//                    getActivity().getSupportFragmentManager().popBackStack();
//                }
            }
        });


        image_preview.setImageBitmap(bt);
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void returnImage(String stringUri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(stringUri );
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }
//        else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String stringUri);
    }
}


