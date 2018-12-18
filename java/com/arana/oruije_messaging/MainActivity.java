package com.arana.oruije_messaging;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.ActionMode;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.bumptech.glide.Glide;
import com.tooltip.Tooltip;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    ImageView hom,posts,jobs,chats,notif,quick_img,talent_img,gallery,camera,video,tgallery,tcamera,tvideo;
    BottomNavigationView br;
    TextView name,num5,num4,post_location,tpost_location;
    LinearLayout post_location_con,home_search,mess_search,tpost_location_con,job_search;
    FrameLayout media_frame,tmedia_frame;
    Context context;
    LinearLayout job_rel;
    SwipeRefreshLayout swipe1,swipe2,swipe3,swipe4;
    CircleImageView ci;
    String location_source = "";
    RelativeLayout hom_rel;
    ArrayList<Bitmap> all_img,tall_img;
    String state;
    RecyclerView media_rv,tmedia_rv;
    ProgressBar progressBar,barr;
    int RequestCode = 1;
    String location = "",post_longitude = "",post_latitude = "";
    String tlocation = "",tpost_longitude = "",tpost_latitude = "";
    int[] post_drop = {R.mipmap.add_white, R.mipmap.close_white};
    int[] post_location_imgg = {R.mipmap.post_location_off, R.mipmap.post_location_on};
    ImageView post_location_img;
    LayoutInflater inflater;
    TextView text,top_text;
    AlertDialog dialogg;
    RelativeLayout none_lay,quick_back,talent_back,job_none_lay;
    Resources r;
    // ArrayList<job_adapter_class>job_sugg;
    android.support.v7.widget.RecyclerView rv,job_list;
    NestedScrollView main_scroll,noti_scroll,jobs_scroll,mess_scroll;
    //posts_adapter ra;
    private static String TAG = "com.eunoia.oruije_messaging";
    Tooltip tp;
    Session session;
    Toolbar TB;
    ArrayList<Integer>post_id,job_id;
    ImageView sear,img,background;
    int ii =1;
    //job_adapter job_adapter;
    String email,password;
    DrawerLayout dr;
    Handler h;
    NavigationView nav;
    RelativeLayout r2,r4,r5,message_none_lay;
    ProgressDialog log,log2,log3;
    com.eunoia.oruije.Database db;
    CheckBox checkBox;
    Button post_button,tpost_button;
    LinearLayout quick_list,quick_but,talent_list,talent_but;
    LocationManager locationManager;
    String[] select = {"Camera", "Photo Library", "Remove picture"}, selectt = {"Camera", "Photo Library"};
    int[] icons2 = {R.mipmap.camera, R.mipmap.photo_library};
    //posts_adapter pa;
//    ArrayList<post_adapter_class> post_sugg;
//

    //        initializing the messaging listview
    ArrayList<MessagingDataModel> dataModels;
    SwipeMenuListView  listView;
    private static MessagingListviewAdapter adapter;

    Bitmap bt,bt2;
    Drawable d;
    ByteArrayOutputStream stream;

    ListView users_list,search_layout;

    LinearLayout search_container;
    EditText search_content;
    ImageButton cancel_search;

    ArrayList<UsersModel> usersModels;
    private static UsersAdapter usersAdapter;
    Toolbar message_toolbar;
    ImageView message_add;
    Boolean is_message_add_pressed = false;
    TextView message_text;
    Boolean item_selected;
    boolean isSearchState = false;


    HorizontalScrollView selected_chats;
    LinearLayout selected_items;

    List selections;
    int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        session = new Session(this);
        db = new com.eunoia.oruije.Database(this);

        session.setUserId("ORUIJE-123"); //sets a dummy user_id
        session.setUserName("Cassanova"); //sets a dummy username


        listView = findViewById(R.id.message_list);
        dataModels= new ArrayList<>();

//        for users_list
        users_list = findViewById(R.id.start_new_chat);
        usersModels= new ArrayList<>();
        selections = new ArrayList<>();

        search_layout = findViewById(R.id.search_layout);

        message_toolbar= findViewById(R.id.message_toolbar);
        selected_chats = findViewById(R.id.selected_chats);
        selected_items = findViewById(R.id.selected_items);
        message_add = findViewById(R.id.message_add);
        message_text = findViewById(R.id.message_text);

        search_container = findViewById(R.id.search_container);
        search_content = findViewById(R.id.search_content);
        cancel_search = findViewById(R.id.cancel_search);


        message_none_lay = findViewById(R.id.message_none_lay);



//        some dummy users
//        String[] name = {"Timi", "Joel", "Quadroli", "Bendozer", "Ibe"};
//        String[] position = {"Manager", "CTO", "Secretary", "Security", "Clerk"};
//        int[] u_image = {R.drawable.deliveryy, R.drawable.first, R.drawable.first, R.drawable.fourth, R.drawable.deliveryy};
//        String[] category = {"Camo", "Dinky", "Circle", "Random", "Page"};
//        Resources res = getResources();
//        for (int i=0; i<name.length;i++) {
//            d = res.getDrawable(u_image[i]);  //converts the images to bytes
//            bt = ((BitmapDrawable)d).getBitmap();
//            stream = new ByteArrayOutputStream();
//            bt.compress(Bitmap.CompressFormat.JPEG,100,stream);
//            byte[] btdata = stream.toByteArray();
//            db.test_users_insert(name[i],id_generator(),position[i],btdata,category[i]);
//        }

//        Cursor req_users = db.get_users();
//        req_users.moveToFirst();
//        while(req_users.moveToNext()) {
//            if (req_users.getCount() > 0) {
//                Log.i("users_info", "here---> " +
//                        req_users.getString(1) + req_users.getString(2) + req_users.getString(3)
//                        + Arrays.toString(req_users.getBlob(4)) + req_users.getString(5));
//                req_users.moveToNext();
//            } else {
//                Log.i("nothing", "no value");
//            }
//        }


        View vw = this.getCurrentFocus();
        if(vw!=null){

            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(vw.getWindowToken(),0);
        }

        progressBar = findViewById(R.id.bar);
        barr = findViewById(R.id.barr);
        db.page_info_delete_all();
        db.profile_delete_all();
        // db.all_locations_delete_all();
        Cursor reqst = db.data_request();
        if (reqst.getCount() > 0) {
            reqst.moveToFirst();
            email = reqst.getString(1);
            password = reqst.getString(2);
        }
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        text = findViewById(R.id.text);
        main_scroll = findViewById(R.id.main_scroll);
        noti_scroll = findViewById(R.id.noti_scroll);
        jobs_scroll = findViewById(R.id.jobs_scroll);
        mess_scroll = findViewById(R.id.mess_scroll);
        top_text = findViewById(R.id.top_text);


        /*home_search = (LinearLayout) findViewById(R.id.home_search);
        home_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(new Intent(UserPage.this,search.class));
                // i.putExtra("check","job");
                startActivity(i);
            }
        });

        job_search = (LinearLayout) findViewById(R.id.job_search);
        job_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(new Intent(UserPage.this,search.class));
                i.putExtra("from","jobs");
                startActivity(i);
            }
        });*/

        mess_search = findViewById(R.id.message_search);
        mess_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_container.setVisibility(View.VISIBLE);
                mess_search.setVisibility(View.GONE);
                message_add.setImageResource(R.drawable.go_back);
                search_layout.setVisibility(View.VISIBLE);
                isSearchState = true;

//                populate the search listview so that it can be searched/filtered
                Cursor req_users = db.get_users();
                req_users.moveToFirst();
                try {
                    if (req_users.getCount() > 0) { //if at least one user exists
                        while (req_users.moveToNext()) {
                            byte[] u_image = req_users.getBlob(4);
                            bt = BitmapFactory.decodeByteArray(u_image, 0, u_image.length);

                            usersModels.add(new UsersModel(req_users.getString(1), req_users.getString(2), req_users.getString(3), bt, req_users.getString(5)));

                        }
                        usersAdapter = new UsersAdapter(usersModels, MainActivity.this);

                        search_layout.setAdapter(usersAdapter);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }


                getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.up_from_bottom,R.anim.down_from_top).addToBackStack(null).add(R.id.search_layout, new Search(), "Search layout").commit();
//                Intent i = new Intent(new Intent(MainActivity.this,message_search.class));
//                // i.putExtra("check","job");
//                startActivity(i);
            }
        });

        search_content.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                usersAdapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        cancel_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search_content.setText(""); //clears the search content input
            }
        });

        text.setText("Welcome to Oruije", TextView.BufferType.SPANNABLE);
        text.setText("Try adding friends from our suggestions to see their feeds on your timeline.", TextView.BufferType.SPANNABLE);


        nav = findViewById(R.id.nav);
        View headerview = nav.getHeaderView(0);
        img = headerview.findViewById(R.id.pp);
        background = headerview.findViewById(R.id.background);

        hom = findViewById(R.id.home);
        jobs = findViewById(R.id.job);
        posts = findViewById(R.id.post);
        chats = findViewById(R.id.message);
        notif = findViewById(R.id.notification);

        num4 = findViewById(R.id.Num4);
        num5 = findViewById(R.id.num5);

        hom.setImageResource(R.mipmap.white_home);
        hom.setTag(R.mipmap.white_home);
        jobs.setImageResource(R.mipmap.gray_job);
        posts.setImageResource(R.mipmap.gray_posts);
        chats.setImageResource(R.mipmap.gray_messages);
        notif.setImageResource(R.mipmap.gray_noti);
        jobs.setTag(R.mipmap.white_home);
        chats.setTag(R.mipmap.white_home);
        notif.setTag(R.mipmap.white_home);


        dr = findViewById(R.id.drawer);
        r2 = findViewById(R.id.second);
        r4 = findViewById(R.id.fourth);
        r5 = findViewById(R.id.fifth);


        Spannable spannable = (Spannable)text.getText();
        ClickableSpan span = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                /*Intent i = new Intent(UserPage.this,Suggestions.class);
                i.putExtra("source","home");
                startActivity(i);*/
                dr.closeDrawer(Gravity.LEFT);
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                ds.setColor(getResources().getColor(R.color.OruijeBlue));
                ds.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                ds.setUnderlineText(false);
            }
        };
        spannable.setSpan(span,28,39,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        text.setMovementMethod(LinkMovementMethod.getInstance());



        /*inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.popip,null,false);
        checkBox = (CheckBox)view.findViewById(R.id.checkbox);


        TB = (Toolbar)findViewById(R.id.toolbar);
        TB.setTitle("");


        hom_rel = (RelativeLayout)findViewById(R.id.home_rel);
        rv = (android.support.v7.widget.RecyclerView)findViewById(R.id.recycler);
        none_lay = (RelativeLayout)findViewById(R.id.none_lay);
        rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        post_id = new ArrayList<Integer>();
        //post_sugg = new ArrayList<>();
        // ra = new posts_adapter(this,post_id,emails,page_id);
        // rv.setAdapter(ra);
        db = new com.eunoia.oruije.Database(this);

        log = new ProgressDialog(this);
        log.setTitle("Please wait");
        log.setCancelable(false);
        log.setMessage("Logging out");

        log3 = new ProgressDialog(this);
        log3.setTitle("Please wait");
        log3.setCancelable(false);
        log3.setMessage("Logging out all accounts");


        // nav.getMenu().getItem(1).setChecked(true);
        dr = (DrawerLayout)findViewById(R.id.drawer);

        ci = (CircleImageView)findViewById(R.id.prof);
        // CircleImageView arana_talk = (CircleImageView)findViewById(R.id.arana_talk);
        Cursor req = db.data_request();
        if(req.getCount()>0){
            req.moveToFirst();
            email = req.getString(1);
            password = req.getString(2);
            Bitmap bmp;
            Cursor cs = db.request_image(email,password);
            Cursor css = db.request_bimage(email,password);
            if(cs.getCount()>0){
                cs.moveToFirst();
                byte[] bytt = cs.getBlob(0);
                bmp = BitmapFactory.decodeByteArray(bytt, 0, bytt.length);
                ci.setImageBitmap(bmp);
                //img.setImageBitmap(bmp);
                Glide.with(UserPage.this).load(bmp).into(img);
                // Glide.with(UserPage.this).load(bmp).into(ci);
            }
            if(css.getCount()>0){
                css.moveToFirst();
                byte[] bytt = css.getBlob(0);
                bmp = BitmapFactory.decodeByteArray(bytt, 0, bytt.length);
                Glide.with(UserPage.this).load(bmp).into(background);
            }

            else {
                Toast.makeText(UserPage.this,"Error occurred",Toast.LENGTH_LONG).show();
            }
        }


        img.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        db.profile_insert(email,password);
                        Intent i = new Intent(UserPage.this,Profile.class);
                        startActivity(i);
                        dr.closeDrawer(Gravity.LEFT);

                    }
                }
        );
        background.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        db.profile_insert(email,password);
                        Intent i = new Intent(UserPage.this,Profile.class);
                        startActivity(i);
                        dr.closeDrawer(Gravity.LEFT);

                    }
                }
        );

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.log) {
                    dr.closeDrawer(Gravity.LEFT);
                    Cursor caccount = db.account_request();
                    if(caccount.getCount()==1){
                        AlertDialog.Builder alt = new AlertDialog.Builder(UserPage.this);
                        alt.setTitle("Log out confirmation");
                        alt.setMessage("Are you sure you want to log out?");
                        alt.setCancelable(true);
                        alt.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                h = new Handler(){
                                    @Override
                                    public void handleMessage(android.os.Message msg) {
                                        log.show();
                                    }
                                };
                                Runnable r = new Runnable() {
                                    @Override
                                    public void run() {
                                        h.sendEmptyMessage(0);
                                        Long delay = System.currentTimeMillis() + 5000;
                                        while(System.currentTimeMillis()<=delay){
                                            if(System.currentTimeMillis() >= delay){

                                                session.loggedin(false);
                                                Cursor req = db.data_request();
                                                if (req.getCount() > 0) {
                                                    req.moveToFirst();
                                                    String emaill = req.getString(1);

                                                    db.account_delete(emaill);

                                                }
                                                String one = "1";
                                                int check = db.data_delete(one);
                                                if (check > 0) {
                                                    log.dismiss();
                                                    Intent in = new Intent(UserPage.this, SignIn.class);
                                                    startActivity(in);
                                                }

                                            }
                                        }
                                    }
                                };
                                Thread t = new Thread(r);
                                t.start();



                            }
                        });
                        alt.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface di, int i) {
                                di.dismiss();
                            }
                        });
                        alt.show();
                    }
                    if(caccount.getCount()>1){
                        Cursor req = db.data_request();
                        req.moveToFirst();
                        String emaill = req.getString(1);
                        String password = req.getString(2);
                        Cursor reqq = db.account_request_account(emaill,password);
                        reqq.moveToFirst();
                        String current_fullname = reqq.getString(1);
                        final String current_email = reqq.getString(2);
                        AlertDialog.Builder alt = new AlertDialog.Builder(UserPage.this);
                        alt.setTitle("Log out confirmation");
                        alt.setMessage("log out "+current_email+"?");
                        alt.setCancelable(true);
                        alt.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                log2 = new ProgressDialog(UserPage.this);
                                log2.setTitle("Please wait");
                                log2.setCancelable(false);
                                log2.setMessage("Logging out "+current_email);

                                h = new Handler(){
                                    @Override
                                    public void handleMessage(android.os.Message msg) {
                                        log2.show();
                                    }
                                };
                                Runnable r = new Runnable() {
                                    @Override
                                    public void run() {
                                        h.sendEmptyMessage(0);
                                        Long delay = System.currentTimeMillis() + 5000;
                                        while(System.currentTimeMillis()<=delay){
                                            if(System.currentTimeMillis() >= delay){
                                                Cursor req = db.data_request();
                                                if (req.getCount() > 0) {
                                                    req.moveToFirst();
                                                    String emaill = req.getString(1);
                                                    db.account_delete(emaill);

                                                }
                                                String one = "1";
                                                int check = db.data_delete(one);
                                                if (check > 0) {
                                                    Cursor reqq = db.account_request();
                                                    reqq.moveToFirst();
                                                    final String aemail,apassword,current_fullname;
                                                    current_fullname = reqq.getString(1);
                                                    aemail = reqq.getString(2);
                                                    apassword = reqq.getString(3);
                                                    db.data_insert(1,aemail,apassword);
                                                    log2.dismiss();
                                                    Intent intt = new Intent(UserPage.this, UserPage.class);
                                                    startActivity(intt);
                                                    UserPage.this.runOnUiThread(new Runnable() {
                                                        @Override
                                                        public void run() {
                                                            Toast.makeText(UserPage.this, "Switched to "+current_fullname, Toast.LENGTH_LONG).show();

                                                        }
                                                    });
                                                }

                                                else {
                                                    UserPage.this.runOnUiThread(new Runnable() {
                                                        @Override
                                                        public void run() {

                                                            Toast.makeText(UserPage.this, "Error logging out", Toast.LENGTH_LONG).show();
                                                        }
                                                    });

                                                }

                                            }
                                        }
                                    }
                                };
                                Thread t = new Thread(r);
                                t.start();



                            }
                        });
                        alt.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface di, int i) {
                                di.dismiss();
                            }
                        });

                        alt.setNeutralButton("Log out all accounts ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface di, int i) {
                                h = new Handler(){
                                    @Override
                                    public void handleMessage(android.os.Message msg) {
                                        log3.show();
                                    }
                                };
                                Runnable r = new Runnable() {
                                    @Override
                                    public void run() {
                                        h.sendEmptyMessage(0);
                                        Long delay = System.currentTimeMillis() + 5000;
                                        while(System.currentTimeMillis()<=delay){
                                            if(System.currentTimeMillis() >= delay){
                                                session.loggedin(false);
                                                db.account_delete_all();
                                                String one = "1";
                                                int check = db.data_delete(one);
                                                if (check > 0) {
                                                    log3.dismiss();
                                                    Intent in = new Intent(UserPage.this, SignIn.class);
                                                    startActivity(in);
                                                }
                                                else {

                                                    UserPage.this.runOnUiThread(new Runnable() {
                                                        @Override
                                                        public void run() {

                                                            Toast.makeText(UserPage.this, "Error logging out", Toast.LENGTH_LONG).show();
                                                        }
                                                    });
                                                }


                                            }
                                        }
                                    }
                                };
                                Thread t = new Thread(r);
                                t.start();




                            }
                        });
                        alt.show();
                    }
                }
                if(item.getItemId()==R.id.account){

                    Intent i = new Intent(UserPage.this,ManageAccount.class);
                    startActivity(i);
                    dr.closeDrawer(Gravity.LEFT);
                }

                if(item.getItemId()==R.id.verification){

                    Intent i = new Intent(UserPage.this,Progress.class);
                    i.putExtra("email",email);
                    i.putExtra("password",password);
                    startActivity(i);
                    dr.closeDrawer(Gravity.LEFT);
                }

                if(item.getItemId()==R.id.education){
                    startActivity(new Intent(UserPage.this,Education.class));
                    dr.closeDrawer(Gravity.LEFT);
                }

                if(item.getItemId()==R.id.company){
                    startActivity(new Intent(UserPage.this,company.class));
                    dr.closeDrawer(Gravity.LEFT);
                }

                if(item.getItemId()==R.id.commerce){
                    //startActivity(new Intent(UserPage.this,company.class));
                    dr.closeDrawer(Gravity.LEFT);
                }

                if(item.getItemId()==R.id.popular){
                    startActivity(new Intent(UserPage.this,Popular.class));
                    dr.closeDrawer(Gravity.LEFT);
                }

                if(item.getItemId()==R.id.talents){
                    startActivity(new Intent(UserPage.this,talents.class));
                    dr.closeDrawer(Gravity.LEFT);
                }

                if(item.getItemId()==R.id.help){
                    startActivity(new Intent(UserPage.this,help.class));
                    dr.closeDrawer(Gravity.LEFT);
                }

                if(item.getItemId()==R.id.settings){
                    startActivity(new Intent(UserPage.this,settings_privacy.class));
                    dr.closeDrawer(Gravity.LEFT);
                }

               /* if(item.getItemId()==R.id.ads){
                    startActivity(new Intent(UserPage.this,Ads.class));
                    dr.closeDrawer(Gravity.LEFT);
                }*/

                /*if(item.getItemId()==R.id.explore){
                    startActivity(new Intent(UserPage.this,Articles.class));
                    dr.closeDrawer(Gravity.LEFT);
                }

                if(item.getItemId()==R.id.delivery){
                    startActivity(new Intent(UserPage.this,Oruije_delivery.class));
                    dr.closeDrawer(Gravity.LEFT);
                }

               /* if(item.getItemId()==R.id.recruit){
                    startActivity(new Intent(UserPage.this,Recruiting_solutions.class));
                    dr.closeDrawer(Gravity.LEFT);
                }*/

                /*if(item.getItemId()==R.id.top_deliverers){
                    startActivity(new Intent(UserPage.this,top_deliverers.class));
                    dr.closeDrawer(Gravity.LEFT);
                }

                /*if(item.getItemId()==R.id.arana_pay){
                    startActivity(new Intent(UserPage.this,aranaPay.class));
                    dr.closeDrawer(Gravity.LEFT);
                }

                if(item.getItemId()==R.id.pages){
                   /*
                    TextView tv = (TextView)nav.getMenu().findItem(R.id.pages).getActionView().findViewById(R.id.zero);
                    tv.setText("2");
                    startActivity(new Intent(UserPage.this,Pages.class));
                    dr.closeDrawer(Gravity.LEFT);
                }
                return true;

            }
        });


        Cursor sec_education,ter_education,tech_skills,tech_certificate,per_skills,interests,industry,work,volunteer,extra,language;
        sec_education = db.education_request(email,password);
        ter_education = db.tertiary_education_request(email,password);
        tech_skills = db.tech_skills_request(email,password);
        tech_certificate = db.tech_cert_request(email,password);
        language = db.language_request(email,password);
        per_skills = db.personal_skills_request(email,password);
        interests = db.interests_request(email,password);
        industry = db.industries_requestt(email,password);
        work = db.work_request(email,password);
        volunteer = db.volunteer_request(email,password);
        extra = db.extra_request(email,password);

        Cursor check = db.state_request(email,password);
        String state = "";
        if(check.getCount()>0){
            check.moveToFirst();
            state = check.getString(2);
        }
        Log.i(TAG,state);
        if(state.equals("show")){

            if(sec_education.getCount()==0 || ter_education.getCount()==0 || tech_skills.getCount()==0 || tech_certificate.getCount()==0 || per_skills.getCount()==0 || interests.getCount()==0 || industry.getCount()==0 || work.getCount()==0 || volunteer.getCount()==0 || extra.getCount()==0 || language.getCount()==0){
                AlertDialog.Builder dialog = new AlertDialog.Builder(UserPage.this);
                dialog.setCancelable(false);
                ImageView pop_image = (ImageView)view.findViewById(R.id.img);
                TextView content = (TextView)view.findViewById(R.id.content);
                String name = "";
                Cursor see = db.request(email,password);
                if(see.getCount()>0){
                    see.moveToFirst();
                    name = see.getString(1);
                }

                content.setText("Hey there "+name+", would you like to complete your profile to get the best of Oruije?");
                pop_image.setImageDrawable(ci.getDrawable());
                dialog.setView(view);
                dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(checkBox.isChecked()){
                            db.state_update(email,password,"close");
                        }
                        else {
                            db.state_update(email, password, "hide");
                        }
                        startActivity(new Intent(UserPage.this,More_settings.class));
                    }
                });
                dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(checkBox.isChecked()){
                            db.state_update(email,password,"close");
                        }
                        else {
                            db.state_update(email, password, "hide");
                        }
                        dialogInterface.dismiss();
                    }
                });

                dialog.show();
            }
        }

        ci.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                final AlertDialog.Builder select = new AlertDialog.Builder(UserPage.this);
                select.setCancelable(true);
                //select.setTitle("Select Account");
                ArrayList<String> af = new ArrayList<String>();
                ArrayList<String> ae = new ArrayList<String>();
                ArrayList<Bitmap> imgg = new ArrayList<Bitmap>();
                Cursor acs = db.account_request();
                acs.moveToFirst();
                do {


                    af.add(acs.getString(1));
                    ae.add(acs.getString(2));
                    byte[] bytt = acs.getBlob(4);
                    Bitmap bmp = BitmapFactory.decodeByteArray(bytt, 0, bytt.length);
                    imgg.add(bmp);
                    ii++;
                }
                while (acs.moveToNext());
                LayoutInflater inflater1 = LayoutInflater.from(UserPage.this);
                View vview  = inflater1.inflate(R.layout.manage_account2,null,false);
                final ListView listView = (ListView)vview.findViewById(R.id.list);
                listView.setAdapter(new ManageAccount2(UserPage.this, af, ae, imgg));
                //View fv =inflater1.inflate(R.layout.manageaccount2_footer,null);
                //  View hv =inflater1.inflate(R.layout.manageaccount2_header,null);
                //listView.addFooterView(fv);
                // listView.addHeaderView(hv);
                dialogg = select.create();
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        Cursor acct = db.account_request();
                        acct.moveToPosition(i);
                        String cfname = acct.getString(1);
                        String cemail = acct.getString(2);
                        String cpass = acct.getString(3);

                        Cursor old = db.data_request();
                        old.moveToFirst();
                        String old_email = old.getString(1);
                        Boolean update = db.data_updatee(old_email, cemail, cpass);

                        if (!cemail.equals(old_email)) {

                            Cursor check = db.state_request(cemail,cpass);
                            String state = "";
                            if(check.getCount()>0){
                                check.moveToFirst();
                                state = check.getString(2);
                            }
                            if(check.getCount()==0){
                                db.state_insert(cemail,cpass,"show");
                            }
                            if(state.equals("hide")){
                                db.state_update(cemail,cpass,"show");
                            }
                            if(state.equals("close")){
                                db.state_update(cemail,cpass,"close");
                            }
                            UserPage.this.finish();
                            UserPage.this.overridePendingTransition(0,0);
                            startActivity(UserPage.this.getIntent());
                            UserPage.this.overridePendingTransition(0,0);
                            Toast.makeText(UserPage.this, "Switched to "+cfname, Toast.LENGTH_LONG).show();
                            session.seen_tooltip("unseen");

                        }
                        else{
                            dialogg.dismiss();
                        }

                    }
                });

                /* select.setAdapter(new ManageAccount2(getActivity(), af, ae, imgg), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Cursor acct = db.account_request();
                        acct.moveToPosition(i);
                        String cfname = acct.getString(1);
                        String cemail = acct.getString(2);
                        String cpass = acct.getString(3);

                        Cursor old = db.data_request();
                        old.moveToFirst();
                        String old_email = old.getString(1);
                        Boolean update = db.data_updatee(old_email, cemail, cpass);

                        if (!cemail.equals(old_email)) {

                            Cursor check = db.state_request(cemail,cpass);
                            String state = "";
                            if(check.getCount()>0){
                                check.moveToFirst();
                                state = check.getString(2);
                            }
                            if(check.getCount()==0){
                                db.state_insert(cemail,cpass,"show");
                            }
                            if(state.equals("hide")){
                                db.state_update(cemail,cpass,"show");
                            }
                            if(state.equals("close")){
                                db.state_update(cemail,cpass,"close");
                            }
                            getActivity().finish();
                            getActivity().overridePendingTransition(0,0);
                            startActivity(getActivity().getIntent());
                            getActivity().overridePendingTransition(0,0);
                            Toast.makeText(getActivity(), "Switched to "+cfname, Toast.LENGTH_LONG).show();

                        }

                    }
                });

                dialogg.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialogg.setContentView(vview);
                View v = getWindow().getDecorView();
                v.setBackgroundResource(android.R.color.transparent);
                dialogg.setView(vview);
                dialogg.show();
                //select.show();
                return true;
            }
        });
        ci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap bmp;
                Cursor cs = db.request_image(email,password);
                Cursor css = db.request_bimage(email,password);
                if(cs.getCount()>0){
                    cs.moveToFirst();
                    byte[] bytt = cs.getBlob(0);
                    bmp = BitmapFactory.decodeByteArray(bytt, 0, bytt.length);
                    //img.setImageBitmap(bmp);
                    Glide.with(UserPage.this).load(bmp).into(img);
                }
                if(css.getCount()>0){
                    css.moveToFirst();
                    byte[] bytt = css.getBlob(0);
                    bmp = BitmapFactory.decodeByteArray(bytt, 0, bytt.length);
                    // background.setImageBitmap(bmp);
                    Glide.with(UserPage.this).load(bmp).into(background);
                }

                else {
                    Toast.makeText(UserPage.this,"Error occurred",Toast.LENGTH_LONG).show();
                }
                View v = UserPage.this.getCurrentFocus();
                if(v!=null){

                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(),0);
                }
                dr.openDrawer(Gravity.LEFT);
            }


        });

        Cursor loop = db.account_request();
        if(loop.getCount()>1){
            if(session.unseen_tooltip().equals("seen")){

                tp = new Tooltip.Builder(ci).setCancelable(true)
                        .setText("Press hold to switch between accounts")
                        .setBackgroundColor(Color.parseColor("#007fe4"))
                        .setTextColor(Color.WHITE)
                        .setPadding(R.dimen.padding)
                        .setMargin(R.dimen.padding)
                        .setArrowHeight(R.dimen.arrow_height)
                        .setCornerRadius(R.dimen.radius)
                        .setGravity(Gravity.BOTTOM)
                        .show();

                session.seen_tooltip("unseen");
            }

        }




        /*arana_talk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  dr.openDrawer(Gravity.RIGHT);
                View view1 = UserPage.this.getCurrentFocus();
                if(view1!=null){

                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view1.getWindowToken(),0);
                }
                AlertDialog.Builder alert = new AlertDialog.Builder(UserPage.this);
                alert.setCancelable(true);
                LayoutInflater inflater1 = LayoutInflater.from(UserPage.this);
                final View v = inflater1.inflate(R.layout.arana_ai,null);
                // code = (EditText)v.findViewById(R.id.edittext);
                Switch aSwitch = (Switch)v.findViewById(R.id.Switch);
                final TextView how = (TextView)v.findViewById(R.id.how);
                final TextView explain = (TextView)v.findViewById(R.id.explain);
                aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if(b){

                            how.setText("Deactivate Arana Converse");

                            RelativeLayout.LayoutParams lay = new RelativeLayout.LayoutParams(
                                    RelativeLayout.LayoutParams.MATCH_PARENT,
                                    RelativeLayout.LayoutParams.WRAP_CONTENT
                            );
                            lay.addRule(RelativeLayout.BELOW,R.id.how);
                            lay.setMargins(0,10,0,0);
                            explain.setLayoutParams(lay);
                            explain.setText("You have now activated Arana Converse, you can simply say \"Arana\" to start interacting with Arana anywhere on Oruije");

                        }
                        else{
                            how.setText("Activate Arana Converse");
                            RelativeLayout.LayoutParams lay = new RelativeLayout.LayoutParams(
                                    RelativeLayout.LayoutParams.MATCH_PARENT,0
                            );
                            explain.setLayoutParams(lay);
                        }
                    }
                });

                alert.setView(v);
                alert.show();
            }
        });*/

       /*

        String share_intent = "NO";
        Bundle bun = getIntent().getExtras();
        if(bun!=null){
             share_intent = bun.getString("share_intent");
            if(share_intent!=null){
                if(share_intent.equals("YES")){
                    hom.setImageResource(R.mipmap.gray_home);
                    jobs.setImageResource(R.mipmap.gray_job);
                    posts.setImageResource(R.mipmap.gray_posts);
                    chats.setImageResource(R.mipmap.white_messages);
                    hom.setTag(R.mipmap.white_messages);
                    notif.setImageResource(R.mipmap.gray_noti);

                    r4.setVisibility(View.VISIBLE);
                    FrameLayout.LayoutParams lay = new FrameLayout.LayoutParams(
                            FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT
                    );
                    r4.setLayoutParams(lay);

                    r2.setVisibility(View.INVISIBLE);
                    FrameLayout.LayoutParams lay2 = new FrameLayout.LayoutParams(
                            0, 0
                    );
                    r2.setLayoutParams(lay2);

                    r3.setVisibility(View.INVISIBLE);
                    FrameLayout.LayoutParams lay3 = new FrameLayout.LayoutParams(
                            0, 0
                    );
                    r3.setLayoutParams(lay3);

                    dr.setVisibility(View.INVISIBLE);
                    FrameLayout.LayoutParams lay4 = new FrameLayout.LayoutParams(
                            0, 0
                    );
                    dr.setLayoutParams(lay4);

                    r5.setVisibility(View.INVISIBLE);
                    FrameLayout.LayoutParams lay5 = new FrameLayout.LayoutParams(
                            0, 0
                    );
                    r5.setLayoutParams(lay5);

                }
               }
            else{
                Intent intent = getIntent();
                String textt = intent.getStringExtra(Intent.EXTRA_TEXT);

                if(textt!=null){

                   hom.setImageResource(R.mipmap.gray_home);
                    jobs.setImageResource(R.mipmap.gray_job);
                    posts.setImageResource(R.mipmap.white_posts);
                    posts.setTag(R.mipmap.white_posts);
                    chats.setImageResource(R.mipmap.gray_messages);
                    notif.setImageResource(R.mipmap.gray_noti);

                    r3.setVisibility(View.VISIBLE);
                    FrameLayout.LayoutParams lay = new FrameLayout.LayoutParams(
                            FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT
                    );
                    r3.setLayoutParams(lay);

                    r2.setVisibility(View.INVISIBLE);
                    FrameLayout.LayoutParams lay2 = new FrameLayout.LayoutParams(
                            0, 0
                    );
                    r2.setLayoutParams(lay2);

                    dr.setVisibility(View.INVISIBLE);
                    FrameLayout.LayoutParams lay3 = new FrameLayout.LayoutParams(
                            0, 0
                    );
                    dr.setLayoutParams(lay3);

                    r4.setVisibility(View.INVISIBLE);
                    FrameLayout.LayoutParams lay4 = new FrameLayout.LayoutParams(
                            0, 0
                    );
                    r4.setLayoutParams(lay4);

                    r5.setVisibility(View.INVISIBLE);
                    FrameLayout.LayoutParams lay5 = new FrameLayout.LayoutParams(
                            0, 0
                    );
                    r5.setLayoutParams(lay5);

                  //  this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);

                    post_box.setText(textt);
                    post_box.requestFocus();
                    post_box.setSelection(post_box.getText().length());
                    quick_img.setImageResource(post_drop[1]);
                    quick_img.setTag(post_drop[1]);
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    );
                    quick_back.setBackgroundResource(R.drawable.blue_up);
                    //quick_list.setBackgroundResource(R.color.OruijeBlue);
                    params.setMargins((int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,10,getResources().getDisplayMetrics()),0,
                            (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,10,getResources().getDisplayMetrics()),0);
                    quick_list.setLayoutParams(params);
                    quick_but.setLayoutParams(params);

                    if(media_type.size()!=0) {
                        LinearLayout.LayoutParams paramss = new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.MATCH_PARENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT
                        );
                        media_frame.setLayoutParams(paramss);
                        media_rv.setAdapter(new post_media_adapter(UserPage.this,media_type,all_img));
                    }
                    UserPage.this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.showSoftInput(post_box,InputMethodManager.SHOW_IMPLICIT);


                    talent_img.setImageResource(post_drop[0]);
                    talent_img.setTag(post_drop[0]);
                    LinearLayout.LayoutParams paramss = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT, 0
                    );
                    talent_back.setBackgroundResource(R.drawable.blue_normal);
                    talent_list.setLayoutParams(paramss);
                    talent_but.setLayoutParams(paramss);
                    //media_frame.setLayoutParams(params);

                    UserPage.this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
                    InputMethodManager immm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    immm.hideSoftInputFromWindow(talent_box.getWindowToken(),0);

                }



            }
        }

        ////////////Badge Count/////////////////

       /* TextView jobs,content,profile,products;
        jobs = (TextView)findViewById(R.id.jobs_num);
        content = (TextView)findViewById(R.id.content_num);
        profile = (TextView)findViewById(R.id.profile_num);
        products = (TextView) findViewById(R.id.prod_num);
        int num = Integer.parseInt(jobs.getText().toString()) + Integer.parseInt(content.getText().toString()) + Integer.parseInt(profile.getText().toString()) + Integer.parseInt(products.getText().toString());
        if(num > 9){
            num5.setText("9+");
        }
        else{
            num5.setText(Integer.toString(num));
        }


        TextView friends,others,official,groups;
        friends = (TextView)findViewById(R.id.friends_num);
        others = (TextView)findViewById(R.id.others_num);
        official = (TextView)findViewById(R.id.official_num);
        groups = (TextView)findViewById(R.id.group_num);
        int numm = Integer.parseInt(friends.getText().toString()) + Integer.parseInt(others.getText().toString()) + Integer.parseInt(official.getText().toString()) + Integer.parseInt(groups.getText().toString());
        if(numm > 9){
            num4.setText("9+");
        }
        else{
            num4.setText(Integer.toString(numm));
        }


        try {
            Badges.setBadge(this, num + numm);
            //Badges.removeBadge(context);
            //Badges.setBadge(context, 0);
        } catch (BadgesNotSupportedException badgesNotSupportedException) {
            Log.d(TAG, badgesNotSupportedException.getMessage());
        }*/

        hom.setImageResource(R.mipmap.white_home);
        jobs.setImageResource(R.mipmap.gray_job);
        posts.setImageResource(R.mipmap.gray_posts);
        chats.setImageResource(R.mipmap.gray_messages);
        notif.setImageResource(R.mipmap.gray_noti);


        dr.setVisibility(View.VISIBLE);
        FrameLayout.LayoutParams lay = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT
        );
        dr.setLayoutParams(lay);

        r2.setVisibility(View.INVISIBLE);
        FrameLayout.LayoutParams lay2 = new FrameLayout.LayoutParams(
                0, 0
        );
        r2.setLayoutParams(lay2);

        r4.setVisibility(View.INVISIBLE);
        FrameLayout.LayoutParams lay4 = new FrameLayout.LayoutParams(
                0, 0
        );
        r4.setLayoutParams(lay4);

        r5.setVisibility(View.INVISIBLE);
        FrameLayout.LayoutParams lay5 = new FrameLayout.LayoutParams(
                0, 0
        );
        r5.setLayoutParams(lay5);

        if(hom.getTag().equals(R.mipmap.white_home)){
            main_scroll.smoothScrollTo(0,0);
        }

        hom.setTag(R.mipmap.white_home);
        jobs.setTag(R.mipmap.white_home);
        chats.setTag(R.mipmap.white_home);
        notif.setTag(R.mipmap.white_home);

        /*post_sugg = new ArrayList<>();
        post_id = new ArrayList<Integer>();

        post_sugg.add(new post_adapter_class(0,"",0,"","","","",""));

        ArrayList<String> all = new ArrayList<>();
        ArrayList<Integer> p_id = new ArrayList<>();
        all.add(email);
        p_id.add(0);

        Cursor ar = db.pages_request_admins(email);
        if(ar.getCount()>0){
            ar.moveToFirst();
            do{
                if(!p_id.contains(Integer.parseInt(ar.getString(4)))){
                    p_id.add(Integer.parseInt(ar.getString(4)));
                    all.add("");
                }

            }
            while(ar.moveToNext());
        }

        Cursor ac = db.followers_request2(email);
        if (ac.getCount()>0) {
            ac.moveToFirst();
            do {

                if (ac.getString(2).equals(email)) {
                    all.add(ac.getString(0));
                    p_id.add(0);
                }
                if (!ac.getString(3).equals("") && ac.getString(2).equals("")) {
                    p_id.add(Integer.parseInt(ac.getString(3)));
                    all.add("");
                }

            }
            while (ac.moveToNext());

        }

        Cursor see_all = db.post_request_all();
        if(see_all.getCount()>0){
            see_all.moveToLast();
            do{

                if(!see_all.getString(1).equals("")){

                    if(see_all.getString(19).equals("Every one")){
                        if(all.contains(see_all.getString(1))){
                            post_sugg.add(new post_adapter_class(see_all.getInt(0),see_all.getString(1),0,"","","","",""));
                        }
                    }
                    else if(see_all.getString(19).equals("Circle")){
                        Cursor reqtt = db.data_request();
                        String emaill = "";
                        if (reqtt.getCount() > 0) {
                            reqtt.moveToFirst();
                            emaill = reqtt.getString(1);
                        }
                        ArrayList<String>em = new ArrayList<>();
                        Cursor acc = db.followers_request2(see_all.getString(1));
                        if (acc.getCount()>0) {
                            acc.moveToFirst();
                            do {

                                if (acc.getString(0).equals(see_all.getString(1)) && !acc.getString(2).equals("")) {
                                    Cursor seee = db.follow_check(acc.getString(2), see_all.getString(1));
                                    if (seee.getCount() > 0) {
                                        seee.moveToFirst();
                                        Cursor c = db.request_email(seee.getString(0));
                                        c.moveToFirst();
                                        if (!em.contains(c.getString(3))) {
                                            em.add(c.getString(3));
                                        }
                                        c.close();
                                    }
                                    seee.close();

                                }
                            }
                            while (acc.moveToNext());
                            acc.close();
                        }
                        if(see_all.getString(1).equals(emaill) || em.contains(emaill)){
                            post_sugg.add(new post_adapter_class(see_all.getInt(0),see_all.getString(1),0,"","","","",""));
                        }

                    }
                }
                if(!see_all.getString(2).equals("")){
                    if(p_id.contains(Integer.parseInt(see_all.getString(2)))){
                        post_sugg.add(new post_adapter_class(see_all.getInt(0),"",Integer.parseInt(see_all.getString(2)),"","","","",""));
                    }

                }



            }
            while(see_all.moveToPrevious());
        }

        post_sugg.add(new post_adapter_class(0,"",0,"","","","",""));

        if(post_sugg.size()>2){
            rv = (android.support.v7.widget.RecyclerView)findViewById(R.id.recycler);
            rv.setNestedScrollingEnabled(false);
            none_lay = (RelativeLayout)findViewById(R.id.none_lay);
            none_lay.setVisibility(View.INVISIBLE);
            rv.setVisibility(View.VISIBLE);
            rv.setLayoutManager(new LinearLayoutManager(UserPage.this,LinearLayoutManager.VERTICAL,false));
            pa = new posts_adapter(this,post_sugg);
            rv.setAdapter(pa);

        }*/

        swipe1 = findViewById(R.id.swipe1);
        swipe1.setColorSchemeResources(R.color.OruijeBlue);
        swipe1.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                /*post_sugg = new ArrayList<>();
                post_id = new ArrayList<Integer>();

                post_sugg.add(new post_adapter_class(0,"",0,"","","","",""));

                ArrayList<String> all = new ArrayList<>();
                ArrayList<Integer> p_id = new ArrayList<>();
                all.add(email);
                p_id.add(0);

                Cursor ar = db.pages_request_admins(email);
                if(ar.getCount()>0){
                    ar.moveToFirst();
                    do{
                        if(!p_id.contains(Integer.parseInt(ar.getString(4)))){
                            p_id.add(Integer.parseInt(ar.getString(4)));
                            all.add("");
                        }

                    }
                    while(ar.moveToNext());
                }

                Cursor ac = db.followers_request2(email);
                if (ac.getCount()>0) {
                    ac.moveToFirst();
                    do {

                        if (ac.getString(2).equals(email)) {
                            all.add(ac.getString(0));
                            p_id.add(0);
                        }
                        if (!ac.getString(3).equals("") && ac.getString(2).equals("")) {
                            p_id.add(Integer.parseInt(ac.getString(3)));
                            all.add("");
                        }

                    }
                    while (ac.moveToNext());

                }

                Cursor see_all = db.post_request_all();
                if(see_all.getCount()>0){
                    see_all.moveToLast();
                    do{

                        if(!see_all.getString(1).equals("")){

                            if(see_all.getString(19).equals("Every one")){
                                if(all.contains(see_all.getString(1))){
                                    post_sugg.add(new post_adapter_class(see_all.getInt(0),see_all.getString(1),0,"","","","",""));
                                }
                            }
                            else if(see_all.getString(19).equals("Circle")){
                                Cursor reqst = db.data_request();
                                String emaill = "";
                                if (reqst.getCount() > 0) {
                                    reqst.moveToFirst();
                                    emaill = reqst.getString(1);
                                }
                                ArrayList<String>em = new ArrayList<>();
                                Cursor acc = db.followers_request2(see_all.getString(1));
                                if (acc.getCount()>0) {
                                    acc.moveToFirst();
                                    do {

                                        if (acc.getString(0).equals(see_all.getString(1)) && !acc.getString(2).equals("")) {
                                            Cursor seee = db.follow_check(acc.getString(2), see_all.getString(1));
                                            if (seee.getCount() > 0) {
                                                seee.moveToFirst();
                                                Cursor c = db.request_email(seee.getString(0));
                                                c.moveToFirst();
                                                if (!em.contains(c.getString(3))) {
                                                    em.add(c.getString(3));
                                                }
                                                c.close();
                                            }
                                            seee.close();

                                        }
                                    }
                                    while (acc.moveToNext());
                                    acc.close();
                                }
                                if(see_all.getString(1).equals(emaill) || em.contains(emaill)){
                                    post_sugg.add(new post_adapter_class(see_all.getInt(0),see_all.getString(1),0,"","","","",""));
                                }

                            }
                        }
                        if(!see_all.getString(2).equals("")){
                            if(p_id.contains(Integer.parseInt(see_all.getString(2)))){
                                post_sugg.add(new post_adapter_class(see_all.getInt(0),"",Integer.parseInt(see_all.getString(2)),"","","","",""));
                            }

                        }



                    }
                    while(see_all.moveToPrevious());
                }

                post_sugg.add(new post_adapter_class(0,"",0,"","","","",""));


                rv = (android.support.v7.widget.RecyclerView)findViewById(R.id.recycler);
                rv.setNestedScrollingEnabled(false);
                none_lay = (RelativeLayout)findViewById(R.id.none_lay);
                if(post_sugg.size() == 2){
                    none_lay.setVisibility(View.VISIBLE);
                    rv.setVisibility(View.INVISIBLE);
                }
                else {
                    none_lay.setVisibility(View.INVISIBLE);
                    rv.setVisibility(View.VISIBLE);
                }

                rv.setLayoutManager(new LinearLayoutManager(UserPage.this,LinearLayoutManager.VERTICAL,false));
                pa = new posts_adapter(UserPage.this,post_sugg);
                rv.setAdapter(pa);*/

                swipe1.setRefreshing(false);
            }
        });

        swipe2 = findViewById(R.id.swipe2);
        swipe2.setColorSchemeResources(R.color.OruijeBlue);
        swipe2.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                /*job_none_lay = (RelativeLayout)findViewById(R.id.job_none_lay);
                job_list = (android.support.v7.widget.RecyclerView)findViewById(R.id.job_list);
                job_list.setNestedScrollingEnabled(false);
                job_id = new ArrayList<Integer>();
                job_sugg = new ArrayList<>();
                job_rel = (LinearLayout)findViewById(R.id.job_rel);

                Cursor ccheck = db.job_filter_request0(email,password);
                if(ccheck.getCount()>0) {
                    ArrayList<Integer> temp1,temp2,temp3;
                    temp1 = new ArrayList<Integer>();
                    temp2 = new ArrayList<Integer>();
                    temp3 = new ArrayList<Integer>();
                    ccheck.moveToFirst();
                    String location = ccheck.getString(2);
                    String industry = ccheck.getString(4);
                    String category = ccheck.getString(6);

                    Cursor jr = db.job_post_request_all();
                    if(jr.getCount()>0){
                        jr.moveToLast();
                        do{

                            if(!location.equals("")){

                                if(jr.getString(8).equals(location)){
                                    temp1.add(jr.getInt(0));
                                }

                            }
                            else if(location.equals("")){
                                temp1.add(jr.getInt(0));
                            }

                        }
                        while(jr.moveToPrevious());

                        if(!industry.equals("")){

                            for(int i = 0; i<temp1.size();i++){
                                Cursor ck2 = db.job_post_request3(temp1.get(i),industry);
                                if(ck2.getCount()>0){
                                    ck2.moveToFirst();
                                    temp2.add(ck2.getInt(0));
                                }
                            }
                        }
                        else if(industry.equals("")){

                            for(int i = 0; i<temp1.size();i++){
                                Cursor ck2 = db.job_post_request2(temp1.get(i));
                                if(ck2.getCount()>0){
                                    ck2.moveToFirst();
                                    temp2.add(ck2.getInt(0));
                                }
                            }


                        }

                        if(!category.equals("")){
                            if(category.equals("Saved Jobs")){
                                for(int i = 0; i<temp2.size();i++){
                                    Cursor ck2 = db.job_saved_check(Integer.toString(temp2.get(i)),email);
                                    if(ck2.getCount()>0){
                                        ck2.moveToFirst();
                                        temp3.add(Integer.parseInt(ck2.getString(0)));
                                    }
                                }
                            }
                            else if(category.equals("Applied Jobs")){
                                for(int i = 0; i<temp2.size();i++){
                                    Cursor ck2 = db.job_applied_check(Integer.toString(temp2.get(i)),email);
                                    if(ck2.getCount()>0){
                                        ck2.moveToFirst();
                                        temp3.add(Integer.parseInt(ck2.getString(0)));
                                    }
                                }
                            }
                            else {
                                for (int i = 0; i < temp2.size(); i++) {
                                    Cursor ck2 = db.job_post_request4(temp2.get(i), category);
                                    if (ck2.getCount() > 0) {
                                        ck2.moveToFirst();
                                        temp3.add(ck2.getInt(0));
                                    }
                                }
                            }

                        }
                        else if(category.equals("")){

                            for(int i = 0; i<temp2.size();i++){
                                Cursor ck2 = db.job_post_request2(temp2.get(i));
                                if(ck2.getCount()>0){
                                    ck2.moveToFirst();
                                    temp3.add(ck2.getInt(0));
                                }
                            }


                        }
                        for(int i = 0; i<temp3.size(); i++){
                            job_id.add(temp3.get(i));
                        }

                        for(int i = 0 ; i<job_id.size();i++){
                            Cursor chk = db.job_post_request2(job_id.get(i));
                            if(chk.getCount()>0){
                                chk.moveToFirst();
                                String name = "";
                                Cursor chk2 = db.page_id_request(Integer.parseInt(chk.getString(1)));
                                if(chk2.getCount()>0){
                                    chk2.moveToFirst();
                                    name = chk2.getString(0);
                                }
                                job_sugg.add(new job_adapter_class(name,chk.getString(21),chk.getString(3),chk.getString(6),chk.getString(4),chk.getString(8),chk.getInt(0)));
                            }
                        }

                    }

                    job_adapter = new job_adapter(UserPage.this,job_sugg);

                    if(job_id.size() > 0){
                        job_list.setVisibility(View.VISIBLE);
                        job_none_lay.setVisibility(View.INVISIBLE);
                        job_list.setLayoutManager(new LinearLayoutManager(UserPage.this,LinearLayoutManager.VERTICAL,false));
                        job_list.setAdapter(job_adapter);
                    }
                    else{
                        job_list.setVisibility(View.INVISIBLE);
                        job_none_lay.setVisibility(View.VISIBLE);
                    }

                }*/


                swipe2.setRefreshing(false);
            }
        });

        swipe3 = findViewById(R.id.swipe3);
        swipe3.setColorSchemeResources(R.color.OruijeBlue);
        swipe3.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                Toast.makeText(MainActivity.this, "done", Toast.LENGTH_SHORT).show();
                swipe3.setRefreshing(false);
            }
        });

        swipe4 = findViewById(R.id.swipe4);
        swipe4.setColorSchemeResources(R.color.OruijeBlue);
        swipe4.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                Toast.makeText(MainActivity.this, "done", Toast.LENGTH_SHORT).show();
                swipe4.setRefreshing(false);
            }
        });
    }

    public String id_generator(){
        int id = (int) (Math.random() * 1000);
        String s = "ORUIJE-";
        return s+id;
    }

    public void home(View v){
        hom.setImageResource(R.mipmap.white_home);
        jobs.setImageResource(R.mipmap.gray_job);
        posts.setImageResource(R.mipmap.gray_posts);
        chats.setImageResource(R.mipmap.gray_messages);
        notif.setImageResource(R.mipmap.gray_noti);

        is_message_add_pressed = false;
        message_add.setImageResource(R.mipmap.add_plain_white);
        dataModels.clear();

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        View vw = this.getCurrentFocus();
        if(vw!=null){

            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(vw.getWindowToken(),0);
        }

        dr.setVisibility(View.VISIBLE);
        FrameLayout.LayoutParams lay = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT
        );
        dr.setLayoutParams(lay);

        r2.setVisibility(View.INVISIBLE);
        FrameLayout.LayoutParams lay2 = new FrameLayout.LayoutParams(
                0, 0
        );
        r2.setLayoutParams(lay2);

        r4.setVisibility(View.INVISIBLE);
        FrameLayout.LayoutParams lay4 = new FrameLayout.LayoutParams(
                0, 0
        );
        r4.setLayoutParams(lay4);

        r5.setVisibility(View.INVISIBLE);
        FrameLayout.LayoutParams lay5 = new FrameLayout.LayoutParams(
                0, 0
        );
        r5.setLayoutParams(lay5);

        if(hom.getTag().equals(R.mipmap.white_home)){
            main_scroll.smoothScrollTo(0,0);
        }

        hom.setTag(R.mipmap.white_home);
        jobs.setTag(R.mipmap.white_home);
        chats.setTag(R.mipmap.white_home);
        notif.setTag(R.mipmap.white_home);

    }

    public void job(View v){
        hom.setImageResource(R.mipmap.gray_home);
        jobs.setImageResource(R.mipmap.white_job);
        posts.setImageResource(R.mipmap.gray_posts);
        chats.setImageResource(R.mipmap.gray_messages);
        notif.setImageResource(R.mipmap.gray_noti);

        is_message_add_pressed = false;
        message_add.setImageResource(R.mipmap.add_plain_white);
        dataModels.clear();

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        View vw = this.getCurrentFocus();
        if(vw!=null){

            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(vw.getWindowToken(),0);
        }

        r2.setVisibility(View.VISIBLE);
        FrameLayout.LayoutParams lay = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT
        );
        r2.setLayoutParams(lay);

        dr.setVisibility(View.INVISIBLE);
        FrameLayout.LayoutParams lay2 = new FrameLayout.LayoutParams(
                0, 0
        );
        dr.setLayoutParams(lay2);

        r4.setVisibility(View.INVISIBLE);
        FrameLayout.LayoutParams lay4 = new FrameLayout.LayoutParams(
                0, 0
        );
        r4.setLayoutParams(lay4);

        r5.setVisibility(View.INVISIBLE);
        FrameLayout.LayoutParams lay5 = new FrameLayout.LayoutParams(
                0, 0
        );
        r5.setLayoutParams(lay5);

        if(jobs.getTag().equals(R.mipmap.white_job)){
            jobs_scroll.smoothScrollTo(0,0);
        }

        jobs.setTag(R.mipmap.white_job);
        hom.setTag(R.mipmap.white_job);
        chats.setTag(R.mipmap.white_job);
        notif.setTag(R.mipmap.white_job);
    }

    public void post(View v){
        is_message_add_pressed = false;
        message_add.setImageResource(R.mipmap.add_plain_white);
        dataModels.clear();
        //Intent i = new Intent(this,all_posts.class);
        //startActivity(i);

    }

    public void chat(View v){
        hom.setImageResource(R.mipmap.gray_home);
        jobs.setImageResource(R.mipmap.gray_job);
        posts.setImageResource(R.mipmap.gray_posts);
        chats.setImageResource(R.mipmap.white_messages);
        notif.setImageResource(R.mipmap.gray_noti);

        is_message_add_pressed = false;
        message_add.setImageResource(R.mipmap.add_plain_white);

//        message_none_lay.setVisibility(View.INVISIBLE);
        listView.setVisibility(View.VISIBLE);
        users_list.setVisibility(View.INVISIBLE);
        swipe3.setVisibility(View.INVISIBLE);

        usersModels.clear();
        dataModels.clear(); //in case the chat button is multipressed on the bottom bar

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        View vw = this.getCurrentFocus();
        if(vw!=null){

            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(vw.getWindowToken(),0);
        }

        //        chatlist
        Cursor chatList = db.chat_list(session.getUserId());
        Cursor getPerson;

        if (chatList.getCount() > 0) { //if at least one chat exists
            chatList.moveToFirst();
            do{
                getPerson = db.get_a_user(chatList.getString(2));

                getPerson.moveToFirst();
                byte[] im = getPerson.getBlob(4);

                bt2 = BitmapFactory.decodeByteArray(im, 0, im.length);
                dataModels.add(new MessagingDataModel(getPerson.getString(1), getPerson.getString(3), chatList.getString(4),chatList.getString(6),chatList.getString(5),bt2,getPerson.getString(2)));
//                Log.i("from main--","user_id ="+chatList.getString(1)+" time ="+chatList.getString(4)+" lastmessage ="+chatList.getString(6));

            }while(chatList.moveToNext());

            adapter = new MessagingListviewAdapter(dataModels,getApplicationContext());
            listView.setAdapter(adapter);
//            Toast.makeText(getApplicationContext(), "what is the value of ispostewhatever"+session.is_post_message(), Toast.LENGTH_SHORT).show();
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    MessagingDataModel dataModel= dataModels.get(i);

                    Intent intent = new Intent(getApplicationContext(), Chat.class);
                    intent.putExtra("user_id", dataModel.getFriend_id());
                    intent.putExtra("intent_type", "single");

                    startActivity(intent);
                }

            });

        } else { //NO CHAT HAS BEEN STARTED YET
            message_none_lay.setVisibility(View.VISIBLE);
            message_text.setText("You have not initiated any chats yet. Press the plus button to get started",TextView.BufferType.SPANNABLE);
            users_list.setVisibility(View.INVISIBLE);
            listView.setVisibility(View.INVISIBLE);
            swipe3.setVisibility(View.VISIBLE);
        }


//        populateChatList(false); //populate the chat list
//        Cursor chatList = db.chat_list(session.getUserId());
//        chatList.moveToFirst();
//        View v = new View(getApplicationContext());


//        if (chatList.getCount() > 0) { //if at least one chat exists
//            while(chatList.moveToNext()) {
//                Cursor getPerson = db.get_a_user(chatList.getString(2));
//
//                getPerson.moveToFirst();
//                byte[] im = getPerson.getBlob(4);
//                bt2 = BitmapFactory.decodeByteArray(im, 0, im.length);
////                new MessagingDataModel("","","","","","","");
//                dataModels.add(new MessagingDataModel(getPerson.getString(1), getPerson.getString(3), chatList.getString(4),chatList.getString(6),chatList.getString(5),bt2,getPerson.getString(2)));
//            }
//
////            if (!onresume){
//                adapter = new MessagingListviewAdapter(dataModels,getApplicationContext());
//                listView.setAdapter(adapter);
//                Toast.makeText(getApplicationContext(), "what is the value of ispostewhatever"+session.is_post_message(), Toast.LENGTH_SHORT).show();
////            }else {
////                //todo coming
//////                Cursor ccs = db.get_a_user(session.getMessagePrefs("user_id"));
//////
//////                dataModels.add(new MessagingDataModel(ccs.getString(1), ccs.getString(3), chatList.getString(4),chatList.getString(6),chatList.getString(5),bt2,getPerson.getString(2)));
////                Toast.makeText(getApplicationContext(),"retunning chat",Toast.LENGTH_SHORT).show();
////                chat(v);
////                session.post_message(false);
////            }
//
//            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                    MessagingDataModel dataModel= dataModels.get(i);
//
//                    Intent intent = new Intent(getApplicationContext(), Chat.class);
//                    intent.putExtra("user_id", dataModel.getFriend_id());
//                    intent.putExtra("intent_type", "single");
//
//                    startActivity(intent);
//                }
//
//            });
////
////            session.post_message(false);
//
//        } else { //NO CHAT HAS BEEN STARTED YET
//            message_none_lay.setVisibility(View.VISIBLE);
//            message_text.setText("You have not initiated any chats yet. Press the plus button to get started",TextView.BufferType.SPANNABLE);
//            users_list.setVisibility(View.INVISIBLE);
//            listView.setVisibility(View.INVISIBLE);
//            swipe3.setVisibility(View.VISIBLE);
//        }

        r4.setVisibility(View.VISIBLE);
        FrameLayout.LayoutParams lay = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT
        );
        r4.setLayoutParams(lay);

        r2.setVisibility(View.INVISIBLE);
        FrameLayout.LayoutParams lay2 = new FrameLayout.LayoutParams(
                0, 0
        );
        r2.setLayoutParams(lay2);

        dr.setVisibility(View.INVISIBLE);
        FrameLayout.LayoutParams lay4 = new FrameLayout.LayoutParams(
                0, 0
        );
        dr.setLayoutParams(lay4);

        r5.setVisibility(View.INVISIBLE);
        FrameLayout.LayoutParams lay5 = new FrameLayout.LayoutParams(
                0, 0
        );
        r5.setLayoutParams(lay5);

        if(chats.getTag().equals(R.mipmap.white_messages)){
            mess_scroll.smoothScrollTo(0,0);
        }

        chats.setTag(R.mipmap.white_messages);
        hom.setTag(R.mipmap.white_messages);
        jobs.setTag(R.mipmap.white_messages);
        notif.setTag(R.mipmap.white_messages);
    }

    public void noti(View v){
        hom.setImageResource(R.mipmap.gray_home);
        jobs.setImageResource(R.mipmap.gray_job);
        posts.setImageResource(R.mipmap.gray_posts);
        chats.setImageResource(R.mipmap.gray_messages);
        notif.setImageResource(R.mipmap.white_noti);

        is_message_add_pressed = false;
        message_add.setImageResource(R.mipmap.add_plain_white);
        dataModels.clear();

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        View vw = this.getCurrentFocus();
        if(vw!=null){

            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(vw.getWindowToken(),0);
        }

        r5.setVisibility(View.VISIBLE);
        FrameLayout.LayoutParams lay = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT
        );
        r5.setLayoutParams(lay);

        r2.setVisibility(View.INVISIBLE);
        FrameLayout.LayoutParams lay2 = new FrameLayout.LayoutParams(
                0, 0
        );
        r2.setLayoutParams(lay2);

        r4.setVisibility(View.INVISIBLE);
        FrameLayout.LayoutParams lay4 = new FrameLayout.LayoutParams(
                0, 0
        );
        r4.setLayoutParams(lay4);

        dr.setVisibility(View.INVISIBLE);
        FrameLayout.LayoutParams lay5 = new FrameLayout.LayoutParams(
                0, 0
        );
        dr.setLayoutParams(lay5);


        if(notif.getTag().equals(R.mipmap.white_noti)){
            noti_scroll.smoothScrollTo(0,0);
        }

        chats.setTag(R.mipmap.white_noti);
        hom.setTag(R.mipmap.white_noti);
        jobs.setTag(R.mipmap.white_noti);
        notif.setTag(R.mipmap.white_noti);
    }



    @Override
    public void onBackPressed() {
        this.moveTaskToBack(true);
    }

    public void add_user_to_chat(View v){

//        Intent i = new Intent(new Intent(this, message_search.class));
//        //i.putExtra("source","job");
//        startActivity(i);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        View vw = this.getCurrentFocus();
        if(vw!=null){

            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(vw.getWindowToken(),0);
        }

        if (isSearchState){
            message_add.setImageResource(R.mipmap.add_plain_white);
            search_container.setVisibility(View.GONE);
            mess_search.setVisibility(View.VISIBLE);
            getSupportFragmentManager().popBackStack(); //closes the search fragment
            isSearchState = false;
        }else {
            if (!is_message_add_pressed) {
                users_list.setVisibility(View.VISIBLE);
                swipe3.setVisibility(View.INVISIBLE);
                listView.setVisibility(View.INVISIBLE);
                message_add.setImageResource(R.drawable.go_back);

                dataModels.clear();
                populateUsersList();

            } else {
                users_list.setVisibility(View.INVISIBLE);
                swipe3.setVisibility(View.INVISIBLE);
                listView.setVisibility(View.VISIBLE);
                message_add.setImageResource(R.mipmap.add_plain_white);

                chat(v);
                adapter.notifyDataSetChanged();


                is_message_add_pressed = false;
            }
        }
    }

    @Override
    protected void onResume() {
        View v = new View(getApplicationContext());
        if (session.is_post_message()) {
            chat(v);
            session.post_message(false);
        }
        super.onResume();
    }

    public void populateUsersList(){
        //inflates the users_listview when the plus button is pressed
        Cursor req_users = db.get_users();
        req_users.moveToFirst();
        try {
            if (req_users.getCount() > 0) { //if at least one user exists
                is_message_add_pressed = true;
                while (req_users.moveToNext()) {
                    byte[] u_image = req_users.getBlob(4);
                    bt = BitmapFactory.decodeByteArray(u_image, 0, u_image.length);

                    usersModels.add(new UsersModel(req_users.getString(1), req_users.getString(2), req_users.getString(3), bt, req_users.getString(5)));

                }
                usersAdapter = new UsersAdapter(usersModels, MainActivity.this);

                users_list.setAdapter(usersAdapter);
                users_list.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);
                users_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        //adds the chat to the chat_table
                        UsersModel model = usersModels.get(i);
                        Intent intent = new Intent(getApplicationContext(), Chat.class);
                        intent.putExtra("user_id", model.getId());
                        intent.putExtra("intent_type", "single");


                        startActivity(intent);
                    }
                });
                users_list.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                    @Override
                    public void onItemCheckedStateChanged(final ActionMode actionMode, final int i, long l, boolean b) {
                        final UsersModel model = usersModels.get(i);
                        TextView mTextView = new TextView(MainActivity.this);

                        LinearLayout.LayoutParams layoutParams =
                                new LinearLayout.LayoutParams(
                                        LinearLayout.LayoutParams.WRAP_CONTENT,
                                        LinearLayout.LayoutParams.WRAP_CONTENT);

                        item_selected = b;
                        if (b) {
                            selections.add(model.getId());
                            count++;

                            mTextView.setText(String.valueOf(model.getName()));
                            mTextView.setBackgroundResource(R.drawable.border);
                            mTextView.setPadding(10, 5, 17, 5);
                            mTextView.setTextColor(Color.WHITE);
                            mTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.cancel_white, 0);
                            mTextView.setCompoundDrawablePadding(10);
                            mTextView.setId(i);
                            mTextView.setTag(i);
                            mTextView.setLayoutParams(layoutParams);
                            selected_items.addView(mTextView);

                            mTextView.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    selections.remove(model.getId());
                                    item_selected=false;
                                    users_list.setItemChecked(i,false);
                                    actionMode.setTitle(count + " selected");
                                }
                            });

                            actionMode.setTitle(count + " selected");
                        } else {
                            selections.remove(model.getId());
                            count--;
                            actionMode.setTitle(count + " selected");
                            selected_items.removeView(findViewById(i));
                            Toast.makeText(getApplicationContext(), "removed", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                        MenuInflater menuInflater = getMenuInflater();
                        menuInflater.inflate(R.menu.start_chat, menu);

                        session.is_chat_selected(true);

                        message_toolbar.setVisibility(View.GONE); //hides the default toolbar
                        selected_chats.setVisibility(View.VISIBLE); //shows contextual bar
                        return true;
                    }

                    @Override
                    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                        return false;
                    }

                    @Override
                    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                        //do something when the next button is clicked
                        if (menuItem.getItemId() ==  R.id.next) {
                            if (selections.size()>1) {
                                Intent intent = new Intent(getApplicationContext(), Chat.class);
                                ArrayList<String> array = new ArrayList<>();
                                for (int x = 0; x < selections.size(); x++)
                                    array.add(String.valueOf(selections.get(x)));
                                intent.putExtra("user_ids", array);
                                intent.putExtra("intent_type", "multiple");
                                startActivity(intent);
                                actionMode.finish();
                                return true;
                            }else{
                                Intent intent = new Intent(getApplicationContext(), Chat.class);
                                intent.putExtra("user_id", String.valueOf(selections.get(0)));
                                intent.putExtra("intent_type", "single");

                                startActivity(intent);
                                actionMode.finish();
                                return true;
                            }
                        }
                        return false;
                    }

                    @Override
                    public void onDestroyActionMode(ActionMode actionMode) {
                        message_toolbar.setVisibility(View.VISIBLE); //hides the default toolbar
                        selected_chats.setVisibility(View.GONE); //shows contextual bar

                        session.is_chat_selected(false);
                        count = 0;
                        selections.clear();
                        selected_items.removeAllViews();
                    }
                });


            } else { //NO CHAT HAS BEEN STARTED YET
                is_message_add_pressed = false;
                swipe3.setVisibility(View.VISIBLE);
                message_none_lay.setVisibility(View.VISIBLE);
                users_list.setVisibility(View.INVISIBLE);
                listView.setVisibility(View.INVISIBLE);
                message_text.setText(R.string.no_friends,TextView.BufferType.SPANNABLE);
                message_add.setImageResource(R.mipmap.add_plain_white);
            }
        } catch (Exception e) {
            Log.e("error==>", e.getMessage());
        }
    }

//    public void populateChatList(Boolean onresume){
//        Cursor chatList = db.chat_list(session.getUserId());
//        chatList.moveToFirst();
//        Cursor getPerson;
//        View v = new View(getApplicationContext());
//
//
//        if (chatList.getCount() > 0) { //if at least one chat exists
//            while(chatList.moveToNext()) {
//                getPerson = db.get_a_user(chatList.getString(2));
//
//                getPerson.moveToFirst();
//                byte[] im = getPerson.getBlob(4);
//                bt2 = BitmapFactory.decodeByteArray(im, 0, im.length);
////                new MessagingDataModel("","","","","","","");
//                dataModels.add(new MessagingDataModel(getPerson.getString(1), getPerson.getString(3), chatList.getString(4),chatList.getString(6),chatList.getString(5),bt2,getPerson.getString(2)));
//            }
//
//            if (!onresume){
//                adapter = new MessagingListviewAdapter(dataModels,getApplicationContext());
//                listView.setAdapter(adapter);
//                Toast.makeText(getApplicationContext(), "what is the value of ispostewhatever"+session.is_post_message(), Toast.LENGTH_SHORT).show();
//            }else {
//                //todo coming
////                Cursor ccs = db.get_a_user(session.getMessagePrefs("user_id"));
////
////                dataModels.add(new MessagingDataModel(ccs.getString(1), ccs.getString(3), chatList.getString(4),chatList.getString(6),chatList.getString(5),bt2,getPerson.getString(2)));
//                Toast.makeText(getApplicationContext(),"retunning chat",Toast.LENGTH_SHORT).show();
//                chat(v);
//                session.post_message(false);
//            }
//
//            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                    MessagingDataModel dataModel= dataModels.get(i);
//
//                    Intent intent = new Intent(getApplicationContext(), Chat.class);
//                    intent.putExtra("user_id", dataModel.getFriend_id());
//                    intent.putExtra("intent_type", "single");
//
//                    startActivity(intent);
//                }
//
//            });
////
////            session.post_message(false);
//
//        } else { //NO CHAT HAS BEEN STARTED YET
//            message_none_lay.setVisibility(View.VISIBLE);
//            message_text.setText("You have not initiated any chats yet. Press the plus button to get started",TextView.BufferType.SPANNABLE);
//            users_list.setVisibility(View.INVISIBLE);
//            listView.setVisibility(View.INVISIBLE);
//            swipe3.setVisibility(View.VISIBLE);
//        }
//    }
}
