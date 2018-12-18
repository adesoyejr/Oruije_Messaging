package com.eunoia.oruije;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.*;

import com.sun.mail.iap.ByteArray;


/**
 * Created by collins on 2017-07-09.
 */
public class Database extends SQLiteOpenHelper{
    public static final String DN = "account_local.db";
    SQLiteDatabase db = getWritableDatabase();
    public Database(Context context) {
        super(context, DN, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //////////////////////////////////////////////////////// CHAT DATABASE //////////////////////////////////////////////////////////////////////////
        db.execSQL("create table m_test_users (ID INTEGER PRIMARY KEY AUTOINCREMENT,FULL_NAME TEXT,TEST_USER_ID TEXT,POSITION TEXT,USER_IMAGE BLOB,CATEGORY TEXT)");
        db.execSQL("create table chat_list (ID INTEGER PRIMARY KEY AUTOINCREMENT,USER_ID TEXT,FRIEND_ID TEXT,POSITION TEXT,TIME TEXT,CATEGORY TEXT,LAST_MESSAGE TEXT,HAS_IMAGE TEXT)");
        db.execSQL("create table chat (ID INTEGER PRIMARY KEY AUTOINCREMENT,SENDER_ID TEXT,RECEIVER_ID TEXT,MESSAGE TEXT,AUTHOR_ID TEXT,DATE_POSTED TEXT,TIME_POSTED TEXT,SEEN TEXT,IMAGE_MESSAGE TEXT, HAS_IMAGE TEXT)");
        //////////////////////////////////////////////////////// CHAT DATABASE ENDS HERE //////////////////////////////////////////////////////////////////////////

        db.execSQL("create table account_info (ID INTEGER PRIMARY KEY AUTOINCREMENT,FIRST_NAME TEXT, LAST_NAME TEXT, EMAIL TEXT,PASSWORD TEXT,BIO TEXT,DOB TEXT,GENDER TEXT,COUNTRY TEXT,PHONE TEXT,IMAGE BLOB,CNO INTEGER,BIMAGE BLOB,IMAGE_STATUS TEXT,BIMAGE_STATUS TEXT,GNO INTEGER,LOCATION TEXT,LOCATION_SWITCH TEXT,EMAIL_VISIBILITY TEXT,PROFILE_MAIL TEXT,WEBSITE TEXT,LOCATION_EXISTENCE TEXT,NICK_NAME TEXT,DELIVERER TEXT, RATINGS DOUBLE,CARD_STATE INTEGER,CARD_NUMBER DOUBLE,CORRECT_LOCATION TEXT,TOTAL_DELIVERIES DOUBLE,SUCCESSFUL_DELIVERIES DOUBLE,FAILED_DELIVERIES DOUBLE,DELIVERY_PERCENTAGE DOUBLE,CURRENT_LONGITUDE TEXT,CURRENT_LATITUDE TEXT,VERIFIED TEXT,PAGE TEXT,PAGE_ID TEXT,DATE_CREATED TEXT,CONTACT_ACCESS TEXT,RANKABLE TEXT,DELIVERY_LOCATION,DELIVERY_LONGITUDE TEXT,DELIVERY_LATITUDE TEXT,SELLER TEXT)");
        db.execSQL("create table education_tab (EMAIL TEXT,PASSWORD TEXT,SCHOOL_NAME TEXT,START_MONTH TEXT,START_MONTH_ID INTEGER,START_YEAR TEXT,START_YEAR_ID INTEGER,END_MONTH TEXT,END_MONTH_ID INTEGER,END_YEAR TEXT,END_YEAR_ID INTEGER,SCHOOL_ID TEXT)");
        db.execSQL("create table tertiary_education (EMAIL TEXT,PASSWORD TEXT,SCHOOL_NAME TEXT,COURSE_NAME TEXT,DEGREE_NAME TEXT,START_MONTH TEXT,START_MONTH_ID INTEGER,START_YEAR TEXT,START_YEAR_ID INTEGER,END_MONTH TEXT,END_MONTH_ID INTEGER,END_YEAR TEXT,END_YEAR_ID INTEGER,SCHOOL_ID TEXT)");
        db.execSQL("create table data_info (ID INTEGER, EMAIL TEXT, PASSWORD TEXT)");
        db.execSQL("create table your_page (EMAIL TEXT, PAGE_NAME TEXT, PAGE_ID TEXT)");
        db.execSQL("create table profile_info (ID INTEGER PRIMARY KEY AUTOINCREMENT, EMAIL TEXT, PASSWORD TEXT)");
        db.execSQL("create table comm_reply_info (ID INTEGER PRIMARY KEY AUTOINCREMENT, EMAIL TEXT, PASSWORD TEXT,TYPE TEXT,POST_ID INTEGER)");
        db.execSQL("create table page_info (ID INTEGER PRIMARY KEY AUTOINCREMENT,ADMIN TEXT,PAGE_ID TEXT)");
        db.execSQL("create table page_associates (EMAIL TEXT,PAGE_ID TEXT)");
        db.execSQL("create table page_review (REVIEWER_NICKNAME TEXT,PAGE_NAME TEXT,PAGE_TYPE TEXT, RATINGS DOUBLE,PROS TEXT,CONS TEXT,COUNT TEXT,PAGE_ID INTEGER,COMMENT TEXT,TIME TEXT,DATE TEXT,COMMENT_TIME TEXT,COMMENT_DATE TEXT)");
        db.execSQL("create table delivery_review (REVIEWER_NICKNAME TEXT,DELIVERER_EMAIL TEXT,RATINGS DOUBLE,PROS TEXT,CONS TEXT,COUNT TEXT,COMMENT TEXT,TIME TEXT,DATE TEXT,COMMENT_TIME TEXT,COMMENT_DATE TEXT,TYPE TEXT)");
        db.execSQL("create table followers (ACCOUNT TEXT,FOLLOWING_CAMO TEXT,FOLLOWER_DINKY TEXT,FOLLOWING_PAGE_ID TEXT)");
        db.execSQL("create table organized_school (PAGE_NAME TEXT,INDUSTRY TEXT,RATINGS DOUBLE, IMAGE BLOB,CORRECT_LOCATION TEXT,CATEGORY TEXT,PAGE_ID INTEGER)");
        db.execSQL("create table organized_company(PAGE_NAME TEXT,INDUSTRY TEXT,RATINGS DOUBLE, IMAGE BLOB,CORRECT_LOCATION TEXT,CATEGORY TEXT,PAGE_ID INTEGER)");
        db.execSQL("create table organized_top_deliverers(PAGE_NAME TEXT,EMAIL TEXT,INDUSTRY TEXT,RATINGS DOUBLE, IMAGE BLOB,CORRECT_LOCATION TEXT,CATEGORY TEXT,PAGE_ID INTEGER)");
        db.execSQL("create table all_locations (LOCATION TEXT)");
        db.execSQL("create table all_industries (INDUSTRY TEXT)");
        db.execSQL("create table all_languages (LANGUAGE TEXT)");
        db.execSQL("create table temporary_admin (FULLNAME TEXT, EMAIL TEXT, PASSWORD TEXT, IMAGE BLOB, STATUS TEXT)");
        db.execSQL("create table page_admins (ADMIN TEXT, PAGE_NAME TEXT ,PAGE_TYPE TEXT, PASSWORD TEXT,PAGE_ID TEXT)");
        db.execSQL("create table pages(PAGE_NAME TEXT, PAGE_TYPE TEXT, IMAGE BLOB,BIMAGE BLOB,INDUSTRY TEXT,INO INTEGER,LOCATION TEXT,LOCATION_EXISTENCE TEXT,WEBSITE TEXT, RATINGS DOUBLE, HEADQUARTER TEXT,IMAGE_STATUS TEXT,BIMAGE_STATUS TEXT,COUNTRY TEXT,CNO INTEGER,PROFILE_MAIL TEXT,PHONE TEXT,ABOUT TEXT,WHAT TEXT,VISION TEXT,CORE TEXT,INFO TEXT, CATEGORY TEXT,LOCATION_SWITCH TEXT,FOUNDED TEXT,CATNO INTEGER,HEADQUARTER_EXISTENCE TEXT,CORRECT_LOCATION TEXT,CORRECT_HEADQUARTER TEXT,RANKABLE TEXT,DELIVERY_SERVICE TEXT,TOTAL_DELIVERIES DOUBLE,SUCCESSFUL_DELIVERIES DOUBLE,FAILED_DELIVERIES DOUBLE,PAGE_ID INTEGER PRIMARY KEY AUTOINCREMENT,MAIN_COMPANY TEXT,DELIVERY_PERCENTAGE DOUBLE,DELIVERY_SERVICE_ID TEXT,MAIN_COMPANY_ID TEXT,DCODE TEXT,VERIFIED TEXT,DATE_CREATED TEXT,OFFERS_DELIVERY TEXT)");
        db.execSQL("create table account (ID INTEGER PRIMARY KEY AUTOINCREMENT,FULLNAME TEXT, EMAIL TEXT, PASSWORD TEXT, IMAGE BLOB)");
        db.execSQL("create table delivery_info_ter (PAGE_ID TEXT, TERRITORY TEXT,EXISTENCE TEXT,CORRECT TEXT)");

        db.execSQL("create table posts (POST_ID INTEGER PRIMARY KEY AUTOINCREMENT, POSTER_EMAIL TEXT,PAGE_ID TEXT,POST TEXT,LOCATION TEXT,CURRENT_LONGITUDE TEXT,CURRENT_LATITUDE TEXT,TIME TEXT,POST_TYPE TEXT,REPOST_ID TEXT,PREVIEW TEXT,PREVIEW_TITLE TEXT,PREVIEW_URL TEXT,PREVIEW_CAN_URL TEXT, PREVIEW_IMAGE BLOB,LIKERS TEXT,COMMENTERS TEXT,LNO INTEGER,CNO INTEGER,VIEWS TEXT)");
        db.execSQL("create table images_videos_audio (POST_ID TEXT, TYPE TEXT, IMAGE BLOB,VIDEO TEXT, AUDIO BLOB,ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT)");

        db.execSQL("create table media_holder(TYPE TEXT, IMAGE BLOB,VIDEO TEXT, AUDIO BLOB)");
        db.execSQL("create table media_holder_all(POST_ID TEXT,TYPE TEXT, IMAGE BLOB,VIDEO TEXT, AUDIO BLOB)");
        db.execSQL("create table comments(POST_ID TEXT, COMMENTER_EMAIL TEXT,COMMENT TEXT,COMMENT_ID INTEGER PRIMARY KEY AUTOINCREMENT,LOCATION TEXT,CURRENT_LONGITUDE TEXT,CURRENT_LATITUDE TEXT,TIME TEXT,PREVIEW TEXT,PREVIEW_TITLE TEXT,PREVIEW_URL TEXT,PREVIEW_CAN_URL TEXT, PREVIEW_IMAGE BLOB)");
        db.execSQL("create table likes(POST_ID TEXT, LIKER_EMAIL TEXT)");
        db.execSQL("create table comm_reply_likes (POST_ID TEXT, LIKER_EMAIL TEXT, TYPE TEXT)");
        db.execSQL("create table reply (REPLY_ID INTEGER PRIMARY KEY AUTOINCREMENT,COMMENT_ID TEXT,REPLY TEXT, REPLYER_EMAIL TEXT,LOCATION TEXT,CURRENT_LONGITUDE TEXT,CURRENT_LATITUDE TEXT,TIME TEXT,TO_ TEXT,PREVIEW TEXT,PREVIEW_TITLE TEXT,PREVIEW_URL TEXT,PREVIEW_CAN_URL TEXT, PREVIEW_IMAGE BLOB)");

        db.execSQL("create table reply_media(COMMENT_ID TEXT,TO_ TEXT,TYPE TEXT, IMAGE BLOB,VIDEO TEXT, AUDIO BLOB)");
        db.execSQL("create table comment_media(POST_ID TEXT,TYPE TEXT, IMAGE BLOB,VIDEO TEXT, AUDIO BLOB)");

        db.execSQL("create table talents(POST_ID INTEGER PRIMARY KEY AUTOINCREMENT, POSTER_EMAIL TEXT,DESCRIPTION TEXT,LOCATION TEXT,CURRENT_LONGITUDE TEXT,CURRENT_LATITUDE TEXT,TIME TEXT,REPOST_ID TEXT,CATEGORY TEXT,LIKERS TEXT,COMMENTERS TEXT,LNO INTEGER,CNO INTEGER,VIEWS TEXT)");
        db.execSQL("create table talents_media (POST_ID TEXT, TYPE TEXT, IMAGE BLOB,VIDEO TEXT, AUDIO BLOB,ID INTEGER PRIMARY KEY AUTOINCREMENT)");
        db.execSQL("create table talents_comments (POST_ID TEXT, COMMENTER_EMAIL TEXT,COMMENT TEXT,COMMENT_ID INTEGER PRIMARY KEY AUTOINCREMENT,LOCATION TEXT,CURRENT_LONGITUDE TEXT,CURRENT_LATITUDE TEXT,TIME TEXT,PREVIEW TEXT,PREVIEW_TITLE TEXT,PREVIEW_URL TEXT,PREVIEW_CAN_URL TEXT, PREVIEW_IMAGE BLOB)");
        db.execSQL("create table talents_nominate (POST_ID TEXT, NOMINATOR_EMAIL TEXT)");
        db.execSQL("create table talents_reply (REPLY_ID INTEGER PRIMARY KEY AUTOINCREMENT,COMMENT_ID TEXT,REPLY TEXT, REPLYER_EMAIL TEXT,LOCATION TEXT,CURRENT_LONGITUDE TEXT,CURRENT_LATITUDE TEXT,TIME TEXT,TO_ TEXT,PREVIEW TEXT,PREVIEW_TITLE TEXT,PREVIEW_URL TEXT,PREVIEW_CAN_URL TEXT, PREVIEW_IMAGE BLOB)");
        db.execSQL("create table talents_reply_media(COMMENT_ID TEXT,TO_ TEXT,TYPE TEXT, IMAGE BLOB,VIDEO TEXT, AUDIO BLOB)");
        db.execSQL("create table talents_comment_media(POST_ID TEXT,TYPE TEXT, IMAGE BLOB,VIDEO TEXT, AUDIO BLOB)");
        db.execSQL("create table talents_comm_reply_likes (POST_ID TEXT, LIKER_EMAIL TEXT, TYPE TEXT)");
        db.execSQL("create table talents_saved (POST_ID TEXT, SAVER_EMAIL TEXT)");
        db.execSQL("create table talents_likes (POST_ID TEXT, LIKER_EMAIL TEXT)");
        db.execSQL("create table talents_share (POST_ID TEXT, SHARER_EMAIL TEXT)");
        db.execSQL("create table talents_comm_reply_shares(POST_ID TEXT, SHARER_EMAIL TEXT, TYPE TEXT)");

        db.execSQL("create table saved (POST_ID TEXT, SAVER_EMAIL TEXT)");
        db.execSQL("create table share (POST_ID TEXT, SHARER_EMAIL TEXT)");
        db.execSQL("create table comm_reply_shares(POST_ID TEXT, SHARER_EMAIL TEXT, TYPE TEXT)");
        db.execSQL("create table deliverers (PAGE_ID TEXT, DELIVERER TEXT, STATE TEXT)");
       ////////////
        db.execSQL("create table verification (ID INTEGER PRIMARY KEY AUTOINCREMENT,PAGE_ID TEXT, DELIVERER TEXT, STATE TEXT, LOCATION TEXT)");
        db.execSQL("create table government_id (ID TEXT, FOR_WHOM TEXT, IMAGE BLOB)");
        db.execSQL("create table utility_bill (ID TEXT, FOR_WHOM TEXT, IMAGE BLOB)");
        db.execSQL("create table incorporation (ID TEXT, FOR_WHOM TEXT, IMAGE BLOB)");
        db.execSQL("create table business_cert (ID TEXT, FOR_WHOM TEXT, IMAGE BLOB)");

        db.execSQL("create table post_views (POST_ID TEXT, COUNT TEXT,VIEWER TEXT)");
        db.execSQL("create table talent_views (POST_ID TEXT, COUNT TEXT,VIEWER TEXT)");
        db.execSQL("create table post_settings (EMAIL TEXT, LIKES TEXT,LNO INTEGER,COMMENTS TEXT,CNO INTEGER,VIEWS TEXT,VNO INTEGER)");

        db.execSQL("create table job_post (POST_ID INTEGER PRIMARY KEY AUTOINCREMENT, PAGE_ID TEXT,STATE TEXT,TITLE TEXT,CATEGORY TEXT, CNO INTEGER,LEVEL TEXT, LNO INTEGER,LOCATION TEXT,DESCRIPTION TEXT,REQUIREMENT TEXT,SKILL TEXT,BENEFIT TEXT,SALARY TEXT,DATE TEXT,EMAIL TEXT,WEBSITE TEXT,POST_LOCATION TEXT,CURRENT_LONGITUDE TEXT,CURRENT_LATITUDE TEXT,TIME TEXT,INDUSTRY TEXT)");
        db.execSQL("create table job_post_temp (PAGE_ID TEXT,TITLE TEXT,CATEGORY TEXT, CNO INTEGER,LEVEL TEXT, LNO INTEGER,LOCATION TEXT,DESCRIPTION TEXT,REQUIREMENT TEXT,SKILL TEXT,BENEFIT TEXT,SALARY TEXT,DATE TEXT,EMAIL TEXT,WEBSITE TEXT,INDUSTRY TEXT)");
        db.execSQL("create table job_post_draft (DRAFT_ID TEXT, PAGE_ID TEXT,TITLE TEXT,CATEGORY TEXT, CNO INTEGER,LEVEL TEXT, LNO INTEGER,LOCATION TEXT,DESCRIPTION TEXT,REQUIREMENT TEXT,SKILL TEXT,BENEFIT TEXT,SALARY TEXT,DATE TEXT,EMAIL TEXT,WEBSITE TEXT,INDUSTRY TEXT)");
        db.execSQL("create table job_saved (POST_ID TEXT, SAVER_EMAIL TEXT)");
        db.execSQL("create table job_applied (POST_ID TEXT, APPLYER_EMAIL TEXT)");

        db.execSQL("create table board_post(POST_ID INTEGER PRIMARY KEY AUTOINCREMENT, PAGE_ID TEXT,TITLE TEXT,START_DATE TEXT,END_DATE TEXT,VENUE TEXT,CORRECT_VENUE TEXT,DESCRIPTION TEXT, IMAGE BLOB,START_HOUR TEXT,START_HOUR_NO TEXT,START_MINUTE TEXT,START_MINUTE_NO TEXT,END_HOUR TEXT,END_HOUR_NO TEXT,END_MINUTE TEXT,END_MINUTE_NO TEXT,IMAGE_STATUS TEXT,POST_LOCATION TEXT,CURRENT_LONGITUDE TEXT,CURRENT_LATITUDE TEXT,TIME TEXT)");
        db.execSQL("create table board_post_temp (PAGE_ID TEXT,TITLE TEXT,START_DATE TEXT,END_DATE TEXT,VENUE TEXT,CORRECT_VENUE TEXT,DESCRIPTION TEXT, IMAGE BLOB,START_HOUR TEXT,START_HOUR_NO TEXT,START_MINUTE TEXT,START_MINUTE_NO TEXT,END_HOUR TEXT,END_HOUR_NO TEXT,END_MINUTE TEXT,END_MINUTE_NO TEXT,IMAGE_STATUS TEXT)");
        db.execSQL("create table board_post_draft (DRAFT_ID TEXT, PAGE_ID TEXT,TITLE TEXT,START_DATE TEXT,END_DATE TEXT,VENUE TEXT,CORRECT_VENUE TEXT,DESCRIPTION TEXT, IMAGE BLOB,START_HOUR TEXT,START_HOUR_NO TEXT,START_MINUTE TEXT,START_MINUTE_NO TEXT,END_HOUR TEXT,END_HOUR_NO TEXT,END_MINUTE TEXT,END_MINUTE_NO TEXT,IMAGE_STATUS TEXT)");

        db.execSQL("create table board_guest(POST_ID TEXT, GUEST TEXT)");
        db.execSQL("create table board_guest_temp (PAGE_ID TEXT,GUEST TEXT)");
        db.execSQL("create table board_guest_draft (DRAFT_ID TEXT,GUEST TEXT)");


        db.execSQL("create table draft_main (DRAFT_ID INTEGER PRIMARY KEY AUTOINCREMENT, TYPE TEXT, CONTENT TEXT,EMAIL TEXT,PAGE_ID TEXT, IMAGE BLOB,VIDEO TEXT, AUDIO BLOB,MEDIA_TYPE TEXT)");
        db.execSQL("create table draft_one (DRAFT_ID TEXT, TYPE TEXT, CONTENT TEXT,CATEGORY TEXT,EMAIL TEXT,PAGE_ID TEXT)");
        db.execSQL("create table draft_one_media(DRAFT_ID TEXT,TYPE TEXT, IMAGE BLOB,VIDEO TEXT, AUDIO BLOB,NAME TEXT)");

        db.execSQL("create table popular_rank_holder(POST_ID INTEGER, TOTAL INTEGER)");
        db.execSQL("create table talent_rank_holder(POST_ID INTEGER, TOTAL INTEGER)");
        db.execSQL("create table quick_post_temp(Account Text, PAGE_ID TEXT, POST TEXT)");
        db.execSQL("create table talent_post_temp(Account Text, CATEGORY TEXT, DESCRIPTION TEXT)");
        db.execSQL("create table quick_post_media_temp(Account Text,PAGE_ID TEXT, TYPE TEXT, IMAGE BLOB,VIDEO TEXT, AUDIO BLOB,CATEGORY Text,NAME Text)");

        db.execSQL("create table delivery_info_lead (PAGE_ID TEXT,LOCATION TEXT,LEAD_TIME TEXT,EXISTENCE TEXT,CORRECT TEXT)");
        db.execSQL("create table delivery_data (PAGE_ID TEXT, FREIGHT_MODE TEXT, FREIGHT_MODE_ID TEXT,VALUE TEXT,SHIPPING_COST TEXT,SHIPPING_COST_LINK TEXT,REFUND_POLICY TEXT,REFUND_POLICY_LINK TEXT,LIFE_TRACKING TEXT,LIFE_TRACKING_ID TEXT,LIFE_TRACKING_INFO TEXT,LICENSE TEXT)");

        db.execSQL("create table tech_skills (EMAIL TEXT, PASSWORD TEXT,SKILL TEXT,CAPABILITY TEXT,CAPABILITY_ID INTEGER)");
        db.execSQL("create table personal_skills (EMAIL TEXT, PASSWORD TEXT,SKILL TEXT,CAPABILITY TEXT,CAPABILITY_ID INTEGER)");
        db.execSQL("create table interests (EMAIL TEXT, PASSWORD TEXT,INTEREST TEXT,INTEREST_LEVEL TEXT,INTEREST_ID INTEGER)");
        db.execSQL("create table industries (EMAIL TEXT,PASSWORD TEXT,INDUSTRY_NAME TEXT,INDUSTRY_ID INTEGER,INVOLVEMENT TEXT,INVOLVEMENT_ID INTEGER)");
        db.execSQL("create table state (EMAIL TEXT, PASSWORD TEXT,STATE TEXT)");
        db.execSQL("create table company_filter (EMAIL TEXT, PASSWORD TEXT, LOCATION TEXT, LNO INTEGER, INDUSTRY TEXT,INO INTEGER)");
        db.execSQL("create table explore_filter (EMAIL TEXT, PASSWORD TEXT, LOCATION TEXT, LNO INTEGER, INDUSTRY TEXT,INO INTEGER)");
        db.execSQL("create table popular_filter (EMAIL TEXT, PASSWORD TEXT, LOCATION TEXT, LNO INTEGER, INDUSTRY TEXT,INO INTEGER)");
        db.execSQL("create table job_filter (EMAIL TEXT, PASSWORD TEXT, LOCATION TEXT, LNO INTEGER, INDUSTRY TEXT,INO INTEGER, CATEGORY TEXT,CNO INTEGER)");
        db.execSQL("create table talents_filter (EMAIL TEXT, PASSWORD TEXT, LOCATION TEXT, LNO INTEGER, INDUSTRY TEXT,INO INTEGER)");
        db.execSQL("create table top_deliverer_filter (EMAIL TEXT, PASSWORD TEXT, LOCATION TEXT, LNO INTEGER, DELIVERER TEXT,DNO INTEGER)");
        db.execSQL("create table school_filter (EMAIL TEXT, PASSWORD TEXT, LOCATION TEXT,LNO INTEGER, INSTITUTION TEXT,INO INTEGER)");
        db.execSQL("create table profile_filter (EMAIL TEXT, PASSWORD TEXT, HEADING TEXT,HNO INTEGER,PERSON TEXT)");
        db.execSQL("create table pages_filter (EMAIL TEXT, PAGE_ID TEXT, HEADING TEXT,HNO INTEGER)");
        db.execSQL("create table delivery_review_filter (EMAIL TEXT, DELIVERER TEXT, CATEGORY TEXT,CNO INTEGER)");
        db.execSQL("create table tech_cert (EMAIL TEXT,PASSWORD TEXT,CERTIFICATE_NAME TEXT,CERTIFICATE_BODY TEXT,CERTIFICATE_ID TEXT,CERTIFICATE_URL TEXT,START_MONTH TEXT,START_MONTH_ID INTEGER,START_YEAR TEXT,START_YEAR_ID INTEGER,END_MONTH TEXT,END_MONTH_ID INTEGER,END_YEAR TEXT,END_YEAR_ID INTEGER,CERTIFICATE_BODY_ID TEXT)");
        db.execSQL("create table language (EMAIL TEXT,PASSWORD TEXT,LANGUAGE_NAME TEXT,LANGUAGE_ID INTEGER,PROFICIENCY TEXT,PROFICIENCY_ID INTEGER)");
        db.execSQL("create table work (EMAIL TEXT,PASSWORD TEXT,WORKED_AT TEXT,WORKED_AS TEXT,LOCATION TEXT,DESCRIPTION TEXT,START_MONTH TEXT,START_MONTH_ID INTEGER,START_YEAR TEXT,START_YEAR_ID INTEGER,END_MONTH TEXT,END_MONTH_ID INTEGER,END_YEAR TEXT,END_YEAR_ID INTEGER,LOCATION_EXISTENCE TEXT,CORRECT_LOCATION TEXT,WORKED_AT_ID TEXT)");
        db.execSQL("create table volunteer (EMAIL TEXT,PASSWORD TEXT,ACTIVITY TEXT,START_MONTH TEXT,START_MONTH_ID INTEGER,START_YEAR TEXT,START_YEAR_ID INTEGER,END_MONTH TEXT,END_MONTH_ID INTEGER,END_YEAR TEXT,END_YEAR_ID INTEGER)");
        db.execSQL("create table extra (EMAIL TEXT,PASSWORD TEXT,ACTIVITY TEXT,START_MONTH TEXT,START_MONTH_ID INTEGER,START_YEAR TEXT,START_YEAR_ID INTEGER,END_MONTH TEXT,END_MONTH_ID INTEGER,END_YEAR TEXT,END_YEAR_ID INTEGER)");

        db.execSQL("create table article_authors (POST_ID TEXT, AUTHOR_EMAIL TEXT)");
        db.execSQL("create table article(POST_ID TEXT, TITLE TEXT, INDUSTRY TEXT, IMAGE BLOB,IMAGE_STATUS TEXT,CONTENT TEXT)");
        db.execSQL("create table article_temp(PAGE_ID TEXT, EMAIL TEXT, TITLE TEXT, INDUSTRY TEXT, IMAGE BLOB,IMAGE_STATUS TEXT,CONTENT TEXT)");
        db.execSQL("create table article_authors_temp (PAGE_ID TEXT, EMAIL TEXT, AUTHOR_EMAIL TEXT)");
        db.execSQL("create table article_draft(DRAFT_ID TEXT,PAGE_ID TEXT, EMAIL TEXT , TITLE TEXT,INDUSTRY TEXT, IMAGE BLOB,IMAGE_STATUS TEXT,CONTENT TEXT)");
        db.execSQL("create table article_authors_draft (DRAFT_ID TEXT,POST_ID TEXT, AUTHOR_EMAIL TEXT)");


        //////////////////////////////////////////////////////// BRAND DATABASE /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        db.execSQL("create table brand (BRAND_ID INTEGER PRIMARY KEY AUTOINCREMENT,PAGE_ID TEXT,NAME TEXT,TRADEMARK_NO TEXT,REGISTERED_AT TEXT,UPC TEXT,CATEGORY TEXT,SUB_CATEGORY TEXT,COUNTRY TEXT,PHONE TEXT,WEBSITE TEXT,EMAIL TEXT, VERIFIED TEXT)");
        db.execSQL("create table brand_temp (PAGE_ID TEXT,NAME TEXT,TRADEMARK_NO TEXT,REGISTERED_AT TEXT,UPC TEXT,CATEGORY TEXT,SUB_CATEGORY TEXT,COUNTRY TEXT,PHONE TEXT,WEBSITE TEXT,EMAIL TEXT)");

        db.execSQL("create table logo_pic (BRAND_ID TEXT,PAGE_ID TEXT,IMAGE BLOB)");
        db.execSQL("create table logo_pic_temp (PAGE_ID TEXT,IMAGE BLOB)");

        db.execSQL("create table brand_pic (BRAND_ID TEXT,PAGE_ID TEXT,IMAGE BLOB)");
        db.execSQL("create table brand_pic_temp (PAGE_ID TEXT,IMAGE BLOB)");

        db.execSQL("create table reseller (BRAND_ID TEXT,PAGE_ID TEXT, RESELLER_EMAIL TEXT)");
        db.execSQL("create table reseller_temp (PAGE_ID TEXT, RESELLER_EMAIL TEXT)");

        db.execSQL("create table brand_partner (BRAND_ID TEXT,PAGE_ID TEXT, COMPANY TEXT, CONTRIBUTIONS TEXT, COMPANY_ID TEXT)");
        db.execSQL("create table brand_partner_temp (PAGE_ID TEXT, COMPANY TEXT, CONTRIBUTIONS TEXT, COMPANY_ID TEXT)");

        db.execSQL("create table brand_manufacturer (BRAND_ID TEXT,PAGE_ID TEXT, COMPANY TEXT, COUNTRY TEXT, COMPANY_ID TEXT)");
        db.execSQL("create table brand_manufacturer_temp (PAGE_ID TEXT, COMPANY TEXT, COUNTRY TEXT, COMPANY_ID TEXT)");

        db.execSQL("create table brand_distributor (BRAND_ID TEXT,PAGE_ID TEXT, COMPANY TEXT, COUNTRY TEXT, COMPANY_ID TEXT)");
        db.execSQL("create table brand_distributor_temp (PAGE_ID TEXT, COMPANY TEXT, COUNTRY TEXT, COMPANY_ID TEXT)");

        //////////////////////////////////////////////////////// BRAND DATABASE /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        db.execSQL("create table blocked (ID INTEGER PRIMARY KEY AUTOINCREMENT,EMAIL TEXT,BLOCKED_PAGE_ID TEXT,BLOCKED_EMAIL TEXT)");
        db.execSQL("create table reports (ID INTEGER PRIMARY KEY AUTOINCREMENT,EMAIL TEXT,TYPE TEXT,REPORTED_PAGE_ID TEXT,REPORTED_EMAIL TEXT,REPORTED_POST_ID TEXT,REPORT TEXT)");

    }

    public Long brand_insert(String page_id,String name,String trademark,String registered,String upc,String category,String sub_category,String country,String phone,String website,String email,String verified){
        ContentValues cv = new ContentValues();
        cv.put("PAGE_ID",page_id);
        cv.put("NAME",name);
        cv.put("TRADEMARK_NO",trademark);
        cv.put("REGISTERED_AT",registered);
        cv.put("UPC",upc);
        cv.put("CATEGORY",category);
        cv.put("SUB_CATEGORY",sub_category);
        cv.put("COUNTRY",country);
        cv.put("PHONE",phone);
        cv.put("WEBSITE",website);
        cv.put("EMAIL",email);
        cv.put("VERIFIED",verified);
        Long check = db.insert("brand",null,cv);
        return check;
    }
    //add some test users
    public Long test_users_insert(String name, String user_id, String position, byte[] user_image, String category){
        ContentValues cv = new ContentValues();
        cv.put("FULL_NAME",name);
        cv.put("TEST_USER_ID",user_id);
        cv.put("POSITION",position);
        cv.put("USER_IMAGE",user_image);
        cv.put("CATEGORY",category);
        Long check = db.insert("m_test_users",null,cv);
        return check;
    }

    public Long create_chat_lists(String user_id, String friend_id, String position, String time, String category,String last_message,String has_image){
        ContentValues cv = new ContentValues();
        cv.put("USER_ID",user_id);
        cv.put("FRIEND_ID",friend_id);
        cv.put("POSITION",position);
        cv.put("TIME",time);
        cv.put("CATEGORY",category);
        cv.put("LAST_MESSAGE",last_message);
        cv.put("HAS_IMAGE",has_image);

        Long list = db.insert("chat_list",null,cv);
        return list;
    }


    public Long create_chat(String sender_id, String receiver_id, String message, String author_id, String date_posted, String time_posted,String seen,String image_message,String has_image){
        ContentValues cv = new ContentValues();
        cv.put("SENDER_ID",sender_id);
        cv.put("RECEIVER_ID",receiver_id);
        cv.put("MESSAGE",message);
        cv.put("AUTHOR_ID",author_id);
        cv.put("DATE_POSTED",date_posted);
        cv.put("TIME_POSTED",time_posted);
        cv.put("SEEN",seen);
        cv.put("IMAGE_MESSAGE",image_message);
        cv.put("HAS_IMAGE",has_image);

        Long check = db.insert("chat",null,cv);
        return check;
    }


    public int brand_delete(String page_id,int brand_id){
        int del =  db.delete("brand","PAGE_ID = ? and BRAND_ID = ?",new String[]{page_id,Integer.toString(brand_id)});
        return del;
    }

    public int logol_pic_delete(String page_id,String brand_id){
        int del =  db.delete("logo_pic","PAGE_ID = ? and BRAND_ID = ?",new String[]{page_id,brand_id});
        return del;
    }


    public Long article_insert(String post_id,String content,String title,String industry ,byte[] image,String image_status){
        ContentValues cv = new ContentValues();
        cv.put("POST_ID",post_id);
        cv.put("TITLE",title);
        cv.put("INDUSTRY",industry);
        cv.put("IMAGE",image);
        cv.put("IMAGE_STATUS",image_status);
        cv.put("CONTENT",content);
        Long check = db.insert("article",null,cv);
        return check;
    }


    public Long governmentid_insert(String id,String for_whom,byte[] image){
        ContentValues cv = new ContentValues();
        cv.put("ID",id);
        cv.put("FOR_WHOM",for_whom);
        cv.put("IMAGE",image);
        Long check = db.insert("government_id",null,cv);
        return check;
    }


    public Long utility_bill_insert(String id,String for_whom,byte[] image){
        ContentValues cv = new ContentValues();
        cv.put("ID",id);
        cv.put("FOR_WHOM",for_whom);
        cv.put("IMAGE",image);
        Long check = db.insert("utility_bill",null,cv);
        return check;
    }


    public Long incorporation_insert(String id,String for_whom,byte[] image){
        ContentValues cv = new ContentValues();
        cv.put("ID",id);
        cv.put("FOR_WHOM",for_whom);
        cv.put("IMAGE",image);
        Long check = db.insert("incorporation",null,cv);
        return check;
    }


    public Long business_cert_insert(String id,String for_whom,byte[] image){
        ContentValues cv = new ContentValues();
        cv.put("ID",id);
        cv.put("FOR_WHOM",for_whom);
        cv.put("IMAGE",image);
        Long check = db.insert("business_cert",null,cv);
        return check;
    }

    public Long article_draft_insert(String draft_id,String email,String page_id,String content,String title,String industry,byte[] image){
        ContentValues cv = new ContentValues();
        cv.put("DRAFT_ID",draft_id);
        cv.put("CONTENT",content);
        cv.put("TITLE",title);
        cv.put("INDUSTRY",industry);
        cv.put("EMAIL",email);
        cv.put("PAGE_ID",page_id);
        cv.put("IMAGE_STATUS","");
        cv.put("IMAGE", image);
        Long check = db.insert("article_draft",null,cv);
        return check;
    }

    public Long article_authors_draft_insert(String draft_id,String email){
        ContentValues cv = new ContentValues();
        cv.put("DRAFT_ID",draft_id);
        cv.put("AUTHOR_EMAIL",email);
        cv.put("POST_ID","");
        Long check = db.insert("article_authors_draft",null,cv);
        return check;
    }

    public Long board_guest_temp_insert(String page_id,String guest){
        ContentValues cv = new ContentValues();
        cv.put("PAGE_ID",page_id);
        cv.put("GUEST",guest);
        Long check = db.insert("board_guest_temp",null,cv);
        return check;
    }

    public Long board_guest_draft_insert(String draft_id,String guest){
        ContentValues cv = new ContentValues();
        cv.put("DRAFT_ID",draft_id);
        cv.put("GUEST",guest);
        Long check = db.insert("board_guest_draft",null,cv);
        return check;
    }

    public Long board_guest_insert(String post_id,String guest){
        ContentValues cv = new ContentValues();
        cv.put("POST_ID",post_id);
        cv.put("GUEST",guest);
        Long check = db.insert("board_guest",null,cv);
        return check;
    }

    public Long verification_insert(String page_id,String deliverer,String location){
        ContentValues cv = new ContentValues();
        cv.put("PAGE_ID",page_id);
        cv.put("DELIVERER",deliverer);
        cv.put("STATE","pending");
        cv.put("LOCATION",location);
        Long check = db.insert("verification",null,cv);
        return check;
    }

    public Boolean email_update_article1(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("AUTHOR_EMAIL",EMAIL);
        db.update("article_authors",cv,"AUTHOR_EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_board_guest(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("GUEST",EMAIL);
        db.update("board_guest",cv,"GUEST = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_board_guest_temp(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("GUEST",EMAIL);
        db.update("board_guest_temp",cv,"GUEST = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_board_guest_draft(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("GUEST",EMAIL);
        db.update("board_guest_draft",cv,"GUEST = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_article2(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        db.update("article_temp",cv,"EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_article3(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        db.update("article_draft",cv,"EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_article4(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("AUTHOR_EMAIL",EMAIL);
        db.update("article_authors_draft",cv,"AUTHOR_EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_article5(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("AUTHOR_EMAIL",EMAIL);
        db.update("article_authors_temp",cv,"AUTHOR_EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_deliverers(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("DELIVERER",EMAIL);
        db.update("deliverers",cv,"DELIVERER = ?",new String[]{old_email});
        return true;
    }

    public Long comments_insert(String post_id,String comment,String commenter_email,String location,String current_longitude ,String current_latitude,String time,String preview,String preview_title,String preview_url,String preview_can_url,byte[] preview_image){
        ContentValues cv = new ContentValues();
        cv.put("COMMENT",comment);
        cv.put("POST_ID",post_id);
        cv.put("COMMENTER_EMAIL",commenter_email);
        cv.put("LOCATION",location);
        cv.put("CURRENT_LONGITUDE",current_longitude);
        cv.put("CURRENT_LATITUDE",current_latitude);
        cv.put("TIME",time);
        cv.put("PREVIEW",preview);
        cv.put("PREVIEW_TITLE",preview_title);
        cv.put("PREVIEW_URL",preview_url);
        cv.put("PREVIEW_CAN_URL",preview_can_url);
        cv.put("PREVIEW_IMAGE",preview_image);
        Long check = db.insert("comments",null,cv);
        return check;
    }

    public Long tcomments_insert(String post_id,String comment,String commenter_email,String location,String current_longitude ,String current_latitude,String time,String preview,String preview_title,String preview_url,String preview_can_url,byte[] preview_image){
        ContentValues cv = new ContentValues();
        cv.put("COMMENT",comment);
        cv.put("POST_ID",post_id);
        cv.put("COMMENTER_EMAIL",commenter_email);
        cv.put("LOCATION",location);
        cv.put("CURRENT_LONGITUDE",current_longitude);
        cv.put("CURRENT_LATITUDE",current_latitude);
        cv.put("TIME",time);
        cv.put("PREVIEW",preview);
        cv.put("PREVIEW_TITLE",preview_title);
        cv.put("PREVIEW_URL",preview_url);
        cv.put("PREVIEW_CAN_URL",preview_can_url);
        cv.put("PREVIEW_IMAGE",preview_image);
        Long check = db.insert("talents_comments",null,cv);
        return check;
    }

    public Long job_post_insert(String page_id,String title,String category,int cno ,String level,int lno,String location,String description,String requirement,String skill,String benefit,String salary,String date,String email,String website,String post_location,String current_longitude,String current_latitude,String time,String industry){
        ContentValues cv = new ContentValues();
        cv.put("PAGE_ID",page_id);
        cv.put("STATE","Available");
        cv.put("TITLE",title);
        cv.put("CATEGORY",category);
        cv.put("CNO",cno);
        cv.put("LEVEL",level);
        cv.put("LNO",lno);
        cv.put("LOCATION",location);
        cv.put("DESCRIPTION",description);
        cv.put("REQUIREMENT",requirement);
        cv.put("SKILL",skill);
        cv.put("BENEFIT",benefit);
        cv.put("SALARY",salary);
        cv.put("DATE",date);
        cv.put("EMAIL",email);
        cv.put("WEBSITE",website);
        cv.put("POST_LOCATION",post_location);
        cv.put("CURRENT_LONGITUDE",current_longitude);
        cv.put("CURRENT_LATITUDE",current_latitude);
        cv.put("TIME",time);
        cv.put("INDUSTRY",industry);
        Long check = db.insert("job_post",null,cv);
        return check;
    }

    public Long board_post_insert(String page_id,String title,String start_date,String end_date ,String venue
            ,String correct_venue,String description,byte[] image,String start_hour,String start_hour_no,String start_minute,String start_minute_no,String end_hour,String end_hour_no,String end_minute,String end_minute_no,String post_location,String current_longitude,String current_latitude,String time,String image_status){
        ContentValues cv = new ContentValues();
        cv.put("PAGE_ID",page_id);
        cv.put("TITLE",title);
        cv.put("START_DATE",start_date);
        cv.put("END_DATE",end_date);
        cv.put("VENUE",venue);
        cv.put("CORRECT_VENUE",correct_venue);
        cv.put("IMAGE",image);
        cv.put("DESCRIPTION",description);
        cv.put("START_HOUR",start_hour);
        cv.put("START_HOUR_NO",start_hour_no);
        cv.put("START_MINUTE",start_minute);
        cv.put("START_MINUTE_NO",start_minute_no);
        cv.put("END_HOUR",end_hour);
        cv.put("END_HOUR_NO",end_hour_no);
        cv.put("END_MINUTE",end_minute);
        cv.put("END_MINUTE_NO",end_minute_no);
        cv.put("POST_LOCATION",post_location);
        cv.put("CURRENT_LONGITUDE",current_longitude);
        cv.put("CURRENT_LATITUDE",current_latitude);
        cv.put("TIME",time);
        cv.put("IMAGE_STATUS",image_status);
        Long check = db.insert("board_post",null,cv);
        return check;
    }


    public Long job_post_temp_insert(String page_id,String title,String category,int cno,String level ,int lno,String location,String description,String requirement,String skill,String benefit,String salary,String date,String email,String website,String industry){
        ContentValues cv = new ContentValues();
        cv.put("PAGE_ID",page_id);
        cv.put("TITLE",title);
        cv.put("CATEGORY",category);
        cv.put("CNO",cno);
        cv.put("LEVEL",level);
        cv.put("LNO",lno);
        cv.put("LOCATION",location);
        cv.put("DESCRIPTION",description);
        cv.put("REQUIREMENT",requirement);
        cv.put("SKILL",skill);
        cv.put("BENEFIT",benefit);
        cv.put("SALARY",salary);
        cv.put("DATE",date);
        cv.put("EMAIL",email);
        cv.put("WEBSITE",website);
        cv.put("INDUSTRY",industry);
        Long check = db.insert("job_post_temp",null,cv);
        return check;
    }

    public Long job_post_draft_insert(String draft_id,String page_id,String title,String category,int cno,String level ,int lno,String location,String description,String requirement,String skill,String benefit,String salary,String date,String email,String website,String industry){
        ContentValues cv = new ContentValues();
        cv.put("DRAFT_ID",draft_id);
        cv.put("PAGE_ID",page_id);
        cv.put("TITLE",title);
        cv.put("CATEGORY",category);
        cv.put("CNO",cno);
        cv.put("LEVEL",level);
        cv.put("LNO",lno);
        cv.put("LOCATION",location);
        cv.put("DESCRIPTION",description);
        cv.put("REQUIREMENT",requirement);
        cv.put("SKILL",skill);
        cv.put("BENEFIT",benefit);
        cv.put("SALARY",salary);
        cv.put("DATE",date);
        cv.put("EMAIL",email);
        cv.put("WEBSITE",website);
        cv.put("INDUSTRY",industry);
        Long check = db.insert("job_post_draft",null,cv);
        return check;
    }

    public Long board_post_draft_insert(String draft_id,String page_id,String title,String start_date,String end_date,String venue ,String correct_venue,String description,byte[] image,String start_hour,String start_hour_no,String start_minute,String start_minute_no,String end_hour,String end_hour_no,String end_minute,String end_minute_no,String image_status){
        ContentValues cv = new ContentValues();
        cv.put("DRAFT_ID",draft_id);
        cv.put("PAGE_ID",page_id);
        cv.put("TITLE",title);
        cv.put("START_DATE",start_date);
        cv.put("END_DATE",end_date);
        cv.put("VENUE",venue);
        cv.put("CORRECT_VENUE",correct_venue);
        cv.put("DESCRIPTION",description);
        cv.put("IMAGE",image);
        cv.put("START_HOUR",start_hour);
        cv.put("START_HOUR_NO",start_hour_no);
        cv.put("START_MINUTE",start_minute);
        cv.put("START_MINUTE_NO",start_minute_no);
        cv.put("END_HOUR",end_hour);
        cv.put("END_HOUR_NO",end_hour_no);
        cv.put("END_MINUTE",end_minute);
        cv.put("END_MINUTE_NO",end_minute_no);
        cv.put("IMAGE_STATUS",image_status);
        Long check = db.insert("board_post_draft",null,cv);
        return check;
    }

    public Long board_post_temp_insert(String page_id,String title,String start_date,String end_date,String venue ,String correct_venue,String description,byte[] image,String start_hour,String start_hour_no,String start_minute,String start_minute_no,String end_hour,String end_hour_no,String end_minute,String end_minute_no,String image_status){
        ContentValues cv = new ContentValues();
        cv.put("PAGE_ID",page_id);
        cv.put("TITLE",title);
        cv.put("START_DATE",start_date);
        cv.put("END_DATE",end_date);
        cv.put("VENUE",venue);
        cv.put("CORRECT_VENUE",correct_venue);
        cv.put("DESCRIPTION",description);
        cv.put("IMAGE",image);
        cv.put("START_HOUR",start_hour);
        cv.put("START_HOUR_NO",start_hour_no);
        cv.put("START_MINUTE",start_minute);
        cv.put("START_MINUTE_NO",start_minute_no);
        cv.put("END_HOUR",end_hour);
        cv.put("END_HOUR_NO",end_hour_no);
        cv.put("END_MINUTE",end_minute);
        cv.put("END_MINUTE_NO",end_minute_no);
        cv.put("IMAGE_STATUS",image_status);
        Long check = db.insert("board_post_temp",null,cv);
        return check;
    }

    public Cursor job_post_temp_request(String page_id){
        Cursor see = db.rawQuery("select * from job_post_temp where PAGE_ID = '"+page_id+"'",null);
        return see;
    }

    public Cursor board_post_temp_request(String page_id){
        Cursor see = db.rawQuery("select * from board_post_temp where PAGE_ID = '"+page_id+"'",null);
        return see;
    }

    public Cursor job_post_request(String page_id){
        Cursor see = db.rawQuery("select * from job_post where PAGE_ID = '"+page_id+"'",null);
        return see;
    }

    public Cursor job_post_request_all(){
        Cursor see = db.rawQuery("select * from job_post",null);
        return see;
    }

    public Cursor job_post_request2(int job_id){
        Cursor see = db.rawQuery("select * from job_post where POST_ID = '"+job_id+"'",null);
        return see;
    }

    public Cursor post_settings_request(String email){
        Cursor see = db.rawQuery("select * from post_settings where EMAIL = '"+email+"'",null);
        return see;
    }

    public Cursor board_post_request(int board_id){
        Cursor see = db.rawQuery("select * from board_post where POST_ID = '"+board_id+"'",null);
        return see;
    }

    public Cursor brand_request_all(){
        Cursor see = db.rawQuery("select * from brand",null);
        return see;
    }

    public Cursor brand_request2(String page_id){
        Cursor see = db.rawQuery("select * from brand where PAGE_ID = '"+page_id+"'",null);
        return see;
    }

    public Cursor brand_request4(int brand_id,String page_id){
        Cursor see = db.rawQuery("select * from brand where BRAND_ID = '"+brand_id+"' and PAGE_ID = '"+page_id+"'",null);
        return see;
    }

    public Cursor brand_request3(String page_id){
        String verified = "YES";
        Cursor see = db.rawQuery("select * from brand where PAGE_ID = '"+page_id+"' and VERIFIED = '"+verified+"'",null);
        return see;
    }

    public Cursor board_post_request2(String page_id){
        Cursor see = db.rawQuery("select * from board_post where PAGE_ID = '"+page_id+"'",null);
        return see;
    }

    public Cursor job_post_request3(int job_id,String industry){
        Cursor see = db.rawQuery("select * from job_post where POST_ID = '"+job_id+"' and INDUSTRY = '"+industry+"'",null);
        return see;
    }

    public Cursor job_post_request4(int job_id,String category){
        Cursor see = db.rawQuery("select * from job_post where POST_ID = '"+job_id+"' and CATEGORY = '"+category+"'",null);
        return see;
    }

    public Cursor job_post_draft_request(String draft_id){
        Cursor see = db.rawQuery("select * from job_post_draft where DRAFT_ID = '"+draft_id+"'",null);
        return see;
    }

    public Long reply_insert(String comment_id,String reply,String replyer_email,String location,String current_longitude ,String current_latitude,String time,String to_,String preview,String preview_title,String preview_url,String preview_can_url,byte[] preview_image){
        ContentValues cv = new ContentValues();
        cv.put("REPLY",reply);
        cv.put("COMMENT_ID",comment_id);
        cv.put("REPLYER_EMAIL",replyer_email);
        cv.put("LOCATION",location);
        cv.put("CURRENT_LONGITUDE",current_longitude);
        cv.put("CURRENT_LATITUDE",current_latitude);
        cv.put("TIME",time);
        cv.put("TO_",to_);
        cv.put("PREVIEW",preview);
        cv.put("PREVIEW_TITLE",preview_title);
        cv.put("PREVIEW_URL",preview_url);
        cv.put("PREVIEW_CAN_URL",preview_can_url);
        cv.put("PREVIEW_IMAGE",preview_image);
        Long check = db.insert("reply",null,cv);
        return check;
    }

    public Long treply_insert(String comment_id,String reply,String replyer_email,String location,String current_longitude ,String current_latitude,String time,String to_,String preview,String preview_title,String preview_url,String preview_can_url,byte[] preview_image){
        ContentValues cv = new ContentValues();
        cv.put("REPLY",reply);
        cv.put("COMMENT_ID",comment_id);
        cv.put("REPLYER_EMAIL",replyer_email);
        cv.put("LOCATION",location);
        cv.put("CURRENT_LONGITUDE",current_longitude);
        cv.put("CURRENT_LATITUDE",current_latitude);
        cv.put("TIME",time);
        cv.put("TO_",to_);
        cv.put("PREVIEW",preview);
        cv.put("PREVIEW_TITLE",preview_title);
        cv.put("PREVIEW_URL",preview_url);
        cv.put("PREVIEW_CAN_URL",preview_can_url);
        cv.put("PREVIEW_IMAGE",preview_image);
        Long check = db.insert("talents_reply",null,cv);
        return check;
    }

    public Cursor follow_check(String account,String person){
        Cursor see = db.rawQuery("select * from followers where ACCOUNT = '"+account+"' and FOLLOWER_DINKY = '"+person+"'",null);
        return see;
    }

    public int draft_main_delete(int draft_id){
        int del =  db.delete("draft_main","DRAFT_ID = ?",new String[]{Integer.toString(draft_id)});
        return del;
    }

    public int draft_one_delete(String draft_id){
        int del =  db.delete("draft_one","DRAFT_ID = ?",new String[]{draft_id});
        return del;
    }

    public int article_draft_delete(String draft_id){
        int del =  db.delete("article_draft","DRAFT_ID = ?",new String[]{draft_id});
        return del;
    }

    public int article_author_draft_delete(String draft_id){
        int del =  db.delete("article_authors_draft","DRAFT_ID = ?",new String[]{draft_id});
        return del;
    }

    public int board_post_draft_delete(String draft_id){
        int del =  db.delete("board_post_draft","DRAFT_ID = ?",new String[]{draft_id});
        return del;
    }

    public int board_post_guest_draft_delete(String draft_id){
        int del =  db.delete("board_guest_draft","DRAFT_ID = ?",new String[]{draft_id});
        return del;
    }

    public int article_authors_delete(String post_id){
        int del =  db.delete("article_authors","POST_ID = ?",new String[]{post_id});
        return del;
    }

    public int article_delete(String post_id){
        int del =  db.delete("article","POST_ID = ?",new String[]{post_id});
        return del;
    }

    public int article_authors_temp_delete(String email){
        int del =  db.delete("article_authors_temp","EMAIL = ?",new String[]{email});
        return del;
    }

    public int article_authors_temp_delete2(String page_id){
        int del =  db.delete("article_authors_temp","PAGE_ID = ?",new String[]{page_id});
        return del;
    }

    public int article_authors_temp_delete3(String email,String author){
        int del =  db.delete("article_authors_temp","EMAIL = ? and AUTHOR_EMAIL = ?",new String[]{email,author});
        return del;
    }

    public int article_authors_temp_delete4(String page_id,String author){
        int del =  db.delete("article_authors_temp","PAGE_ID = ? and AUTHOR_EMAIL = ?",new String[]{page_id,author});
        return del;
    }

    public int job_post_draft_delete(String draft_id){
        int del =  db.delete("job_post_draft","DRAFT_ID = ?",new String[]{draft_id});
        return del;
    }

    public Cursor draft_one_check(String draft_id){
        Cursor see = db.rawQuery("select * from draft_one where DRAFT_ID = '"+draft_id+"'",null);
        return see;
    }

    public Cursor article_draft_check(String draft_id){
        Cursor see = db.rawQuery("select * from article_draft where DRAFT_ID = '"+draft_id+"'",null);
        return see;
    }

    public Cursor draft_one_media_check(String draft_id){
        Cursor see = db.rawQuery("select * from draft_one_media where DRAFT_ID = '"+draft_id+"'",null);
        return see;
    }

    public Cursor article_authors_draft_check(String draft_id){
        Cursor see = db.rawQuery("select * from article_authors_draft where DRAFT_ID = '"+draft_id+"'",null);
        return see;
    }

    public Cursor board_guest_draft_check(String draft_id){
        Cursor see = db.rawQuery("select * from board_guest_draft where DRAFT_ID = '"+draft_id+"'",null);
        return see;
    }

    public Cursor board_guest_check(String post_id){
        Cursor see = db.rawQuery("select * from board_guest where POST_ID = '"+post_id+"'",null);
        return see;
    }

    public int draft_one_media_delete(String draft_id){
        int del =  db.delete("draft_one_media","DRAFT_ID = ?",new String[]{draft_id});
        return del;
    }

    public Cursor following_check(String account){
        Cursor see = db.rawQuery("select * from followers where FOLLOWER_DINKY = '"+account+"'",null);
        return see;
    }

    public Cursor comments_request1(int comm_id){
        Cursor see = db.rawQuery("select * from comments where COMMENT_ID = '"+comm_id+"'",null);
        return see;
    }

    public Cursor tcomments_request1(int comm_id){
        Cursor see = db.rawQuery("select * from talents_comments where COMMENT_ID = '"+comm_id+"'",null);
        return see;
    }

    public int comments_delete1(int comm_id){
        int del =  db.delete("comments","COMMENT_ID = ?",new String[]{Integer.toString(comm_id)});
        return del;
    }

    public int tcomments_delete1(int comm_id){
        int del =  db.delete("talents_comments","COMMENT_ID = ?",new String[]{Integer.toString(comm_id)});
        return del;
    }

    public int reply_likes_delete(String comm_id,String type){
        int del =  db.delete("comm_reply_likes","POST_ID = ? and TYPE = ?",new String[]{comm_id,type});
        return del;
    }

    public int treply_likes_delete(String comm_id,String type){
        int del =  db.delete("talents_comm_reply_likes","POST_ID = ? and TYPE = ?",new String[]{comm_id,type});
        return del;
    }

    public int reply_media_delete(String comm_id,String to_){
        int del =  db.delete("reply_media","COMMENT_ID = ? and TO_ = ?",new String[]{comm_id,to_});
        return del;
    }

    public int treply_media_delete(String comm_id,String to_){
        int del =  db.delete("talents_reply_media","COMMENT_ID = ? and TO_ = ?",new String[]{comm_id,to_});
        return del;
    }

    public int reply_media_delete2(String comm_id){
        int del =  db.delete("reply_media","COMMENT_ID = ?",new String[]{comm_id});
        return del;
    }

    public int treply_media_delete2(String comm_id){
        int del =  db.delete("talents_reply_media","COMMENT_ID = ?",new String[]{comm_id});
        return del;
    }

    public int reply_delete(String comm_id,String to_){
        int del =  db.delete("reply","COMMENT_ID = ? and TO_ = ?",new String[]{comm_id,to_});
        return del;
    }

    public int treply_delete(String comm_id,String to_){
        int del =  db.delete("talents_reply","COMMENT_ID = ? and TO_ = ?",new String[]{comm_id,to_});
        return del;
    }

    public int reply_delete2(int reply_id){
        int del =  db.delete("reply","REPLY_ID = ?",new String[]{Integer.toString(reply_id)});
        return del;
    }

    public int treply_delete2(int reply_id){
        int del =  db.delete("talents_reply","REPLY_ID = ?",new String[]{Integer.toString(reply_id)});
        return del;
    }

    public int comment_media_delete(String post_id){
        int del =  db.delete("comment_media","POST_ID = ?",new String[]{post_id});
        return del;
    }

    public int tcomment_media_delete(String post_id){
        int del =  db.delete("talents_comment_media","POST_ID = ?",new String[]{post_id});
        return del;
    }

    public Cursor reply_request1(String comm_id,String to_){
        Cursor see = db.rawQuery("select * from reply where COMMENT_ID = '"+comm_id+"' and TO_ = '"+to_+"'",null);
        return see;
    }

    public Cursor treply_request1(String comm_id,String to_){
        Cursor see = db.rawQuery("select * from talents_reply where COMMENT_ID = '"+comm_id+"' and TO_ = '"+to_+"'",null);
        return see;
    }

    public Cursor reply_request3(String comm_id,String to_,String replyer_email){
        Cursor see = db.rawQuery("select * from reply where COMMENT_ID = '"+comm_id+"' and TO_ = '"+to_+"' and REPLYER_EMAIL = '"+replyer_email+"'",null);
        return see;
    }

    public Cursor treply_request3(String comm_id,String to_,String replyer_email){
        Cursor see = db.rawQuery("select * from talents_reply where COMMENT_ID = '"+comm_id+"' and TO_ = '"+to_+"' and REPLYER_EMAIL = '"+replyer_email+"'",null);
        return see;
    }

    public Cursor reply_request2(int reply_id){
        Cursor see = db.rawQuery("select * from reply where REPLY_ID = '"+reply_id+"'",null);
        return see;
    }

    public Cursor treply_request2(int reply_id){
        Cursor see = db.rawQuery("select * from talents_reply where REPLY_ID = '"+reply_id+"'",null);
        return see;
    }

    public Cursor reply_request_all(){
        Cursor see = db.rawQuery("select * from reply",null);
        return see;
    }

    public Cursor treply_request_all(){
        Cursor see = db.rawQuery("select * from talents_reply",null);
        return see;
    }

    public Cursor following_check2(String account){
        Cursor see = db.rawQuery("select * from followers where ACCOUNT = '"+account+"'",null);
        return see;
    }

    public Cursor draft_email_check(String email){
        Cursor see = db.rawQuery("select * from draft_main where EMAIL = '"+email+"'",null);
        return see;
    }

    public Cursor draft_page_id_check(String page_id){
        Cursor see = db.rawQuery("select * from draft_main where PAGE_ID = '"+page_id+"'",null);
        return see;
    }

    public Cursor draft_id_check(int draft_id){
        Cursor see = db.rawQuery("select * from draft_main where DRAFT_ID = '"+draft_id+"'",null);
        return see;
    }

    public Cursor draft_one_media_id_check(String draft_id){
        Cursor see = db.rawQuery("select * from draft_one_media where DRAFT_ID = '"+draft_id+"'",null);
        return see;
    }

    public Cursor board_post_draft_request(String draft_id){
        Cursor see = db.rawQuery("select * from board_post_draft where DRAFT_ID = '"+draft_id+"'",null);
        return see;
    }

    public Cursor brand_name_request(String name,String page_id){
        Cursor see = db.rawQuery("select * from brand where NAME = '"+name+"' and PAGE_ID = '"+page_id+"'",null);
        return see;
    }

    public Cursor draft_check_all(){
        Cursor see = db.rawQuery("select * from draft_main",null);
        return see;
    }

    public Cursor board_check_all(){
        Cursor see = db.rawQuery("select * from board_post",null);
        return see;
    }

    public Cursor post_view_request(String post_id,String viewer){
        Cursor see = db.rawQuery("select * from post_views where POST_ID = '"+post_id+"' and VIEWER = '"+viewer+"'",null);
        return see;
    }

    public Cursor talent_view_request(String post_id,String viewer){
        Cursor see = db.rawQuery("select * from talent_views where POST_ID = '"+post_id+"' and VIEWER = '"+viewer+"'",null);
        return see;
    }

    public Cursor post_view_request_all(String post_id){
        Cursor see = db.rawQuery("select * from post_views where POST_ID = '"+post_id+"'",null);
        return see;
    }

    public Cursor talent_view_request_all(String post_id){
        Cursor see = db.rawQuery("select * from talent_views where POST_ID = '"+post_id+"'",null);
        return see;
    }

    public Cursor follow_check2(String account,String person){
        Cursor see = db.rawQuery("select * from followers where ACCOUNT = '"+account+"' and FOLLOWING_CAMO = '"+person+"'",null);
        return see;
    }

    public Cursor images_videos_request(int post_id){
        Cursor see = db.rawQuery("select * from images_videos_audio where POST_ID = '"+post_id+"'",null);
        return see;
    }

    public Cursor page_follow_check(String account,String page_id){
        Cursor see = db.rawQuery("select * from followers where ACCOUNT = '"+account+"' and FOLLOWING_PAGE_ID = '"+page_id+"'",null);
        return see;
    }

    public Long follower_insert(String account,String camo,String dinky,String page_id){
        ContentValues cv = new ContentValues();
        cv.put("ACCOUNT",account);
        cv.put("FOLLOWING_CAMO",camo);
        cv.put("FOLLOWER_DINKY",dinky);
        cv.put("FOLLOWING_PAGE_ID",page_id);
        Long check = db.insert("followers",null,cv);
        return check;
    }

    public Long draft_main_insert(String content,String type,String email,String page_id,byte[] image,String video,byte[] audio,String media_type){
        ContentValues cv = new ContentValues();
        cv.put("CONTENT",content);
        cv.put("TYPE",type);
        cv.put("EMAIL",email);
        cv.put("PAGE_ID",page_id);
        cv.put("IMAGE",image);
        cv.put("VIDEO",video);
        cv.put("AUDIO",audio);
        cv.put("MEDIA_TYPE",media_type);
        Long check = db.insert("draft_main",null,cv);
        return check;
    }


    public Long draft_one_insert(String draft_id,String content,String category,String type,String email,String page_id){
        ContentValues cv = new ContentValues();
        cv.put("DRAFT_ID",draft_id);
        cv.put("CONTENT",content);
        cv.put("CATEGORY",category);
        cv.put("TYPE",type);
        cv.put("EMAIL",email);
        cv.put("PAGE_ID",page_id);
        Long check = db.insert("draft_one",null,cv);
        return check;
    }

    public Long draft_one_media_insert(String draft_id,String type,byte[] image,String video,byte[] audio,String name){
        ContentValues cv = new ContentValues();
        cv.put("DRAFT_ID",draft_id);
        cv.put("IMAGE",image);
        cv.put("VIDEO",video);
        cv.put("TYPE",type);
        cv.put("AUDIO",audio);
        cv.put("NAME",name);
        Long check = db.insert("draft_one_media",null,cv);
        return check;
    }

    public boolean contact_update(String email,String status){
        ContentValues cv = new ContentValues();
        cv.put("CONTACT_ACCESS",status);
        db.update("account_info",cv,"EMAIL = ?",new String[]{email});
        return true;
    }

    public boolean job_state_update(int job_id){
        ContentValues cv = new ContentValues();
        cv.put("STATE","EXPIRED");
        db.update("job_post",cv,"POST_ID = ?",new String[]{Integer.toString(job_id)});
        return true;
    }

    public Long popular_rank_holder_insert(int post_id,int total){
        ContentValues cv = new ContentValues();
        cv.put("POST_ID",post_id);
        cv.put("TOTAL",total);
        Long check = db.insert("popular_rank_holder",null,cv);
        return check;
    }

    public Cursor popular_rank_holder_check(){
        Cursor see = db.rawQuery("select * from popular_rank_holder",null);
        return see;
    }

    public Cursor popular_rank_holder_check2(int total){
        Cursor see = db.rawQuery("select * from popular_rank_holder where TOTAL = '"+total+"'",null);
        return see;
    }

    public int popular_rank_holder_delete_all(){
        int del =  db.delete("popular_rank_holder",null,null);
        return del;
    }

    public Long talent_rank_holder_insert(int post_id,int total){
        ContentValues cv = new ContentValues();
        cv.put("POST_ID",post_id);
        cv.put("TOTAL",total);
        Long check = db.insert("talent_rank_holder",null,cv);
        return check;
    }

    public Long post_views_insert(String post_id,String count,String viewer){
        ContentValues cv = new ContentValues();
        cv.put("POST_ID",post_id);
        cv.put("COUNT",count);
        cv.put("VIEWER",viewer);
        Long check = db.insert("post_views",null,cv);
        return check;
    }

    public Long talent_views_insert(String post_id,String count,String viewer){
        ContentValues cv = new ContentValues();
        cv.put("POST_ID",post_id);
        cv.put("COUNT",count);
        cv.put("VIEWER",viewer);
        Long check = db.insert("talent_views",null,cv);
        return check;
    }

    public Cursor talent_rank_holder_check(){
        Cursor see = db.rawQuery("select * from talent_rank_holder",null);
        return see;
    }

    public Cursor talent_rank_holder_check2(int total){
        Cursor see = db.rawQuery("select * from talent_rank_holder where TOTAL = '"+total+"'",null);
        return see;
    }

    public int talent_rank_holder_delete_all(){
        int del =  db.delete("talent_rank_holder",null,null);
        return del;
    }

    public Long likes_insert(String post_id,String liker_email){
        ContentValues cv = new ContentValues();
        cv.put("POST_ID",post_id);
        cv.put("LIKER_EMAIL",liker_email);
        Long check = db.insert("likes",null,cv);
        return check;
    }

    public Long tlikes_insert(String post_id,String liker_email){
        ContentValues cv = new ContentValues();
        cv.put("POST_ID",post_id);
        cv.put("LIKER_EMAIL",liker_email);
        Long check = db.insert("talents_likes",null,cv);
        return check;
    }

    public Long tnom_insert(String post_id,String nominator){
        ContentValues cv = new ContentValues();
        cv.put("POST_ID",post_id);
        cv.put("NOMINATOR_EMAIL",nominator);
        Long check = db.insert("talents_nominate",null,cv);
        return check;
    }

    public Long reply_likes_insert(String post_id,String liker_email,String type){
        ContentValues cv = new ContentValues();
        cv.put("POST_ID",post_id);
        cv.put("LIKER_EMAIL",liker_email);
        cv.put("TYPE",type);
        Long check = db.insert("comm_reply_likes",null,cv);
        return check;
    }

    public Long treply_likes_insert(String post_id,String liker_email,String type){
        ContentValues cv = new ContentValues();
        cv.put("POST_ID",post_id);
        cv.put("LIKER_EMAIL",liker_email);
        cv.put("TYPE",type);
        Long check = db.insert("talents_comm_reply_likes",null,cv);
        return check;
    }

    public Cursor likes_check(String post_id,String liker_email){
        Cursor see = db.rawQuery("select * from likes where POST_ID = '"+post_id+"' and LIKER_EMAIL = '"+liker_email+"'",null);
        return see;
    }

    public Cursor tlikes_check(String post_id,String liker_email){
        Cursor see = db.rawQuery("select * from talents_likes where POST_ID = '"+post_id+"' and LIKER_EMAIL = '"+liker_email+"'",null);
        return see;
    }

    public Cursor tnom_check(String post_id,String nominator){
        Cursor see = db.rawQuery("select * from talents_nominate where POST_ID = '"+post_id+"' and NOMINATOR_EMAIL = '"+nominator+"'",null);
        return see;
    }

    public Cursor likes_check2(String post_id){
        Cursor see = db.rawQuery("select * from likes where POST_ID = '"+post_id+"'",null);
        return see;
    }

    public Cursor tlikes_check2(String post_id){
        Cursor see = db.rawQuery("select * from talents_likes where POST_ID = '"+post_id+"'",null);
        return see;
    }

    public Cursor reply_likes_check(String post_id,String liker_email){
        Cursor see = db.rawQuery("select * from comm_reply_likes where POST_ID = '"+post_id+"' and LIKER_EMAIL = '"+liker_email+"'",null);
        return see;
    }

    public Cursor reply_likes_check_all(){
        Cursor see = db.rawQuery("select * from comm_reply_likes",null);
        return see;
    }

    public Cursor treply_likes_check_all(){
        Cursor see = db.rawQuery("select * from talents_comm_reply_likes",null);
        return see;
    }

    public Cursor reply_likes_check4(String post_id,String liker_email,String type){
        Cursor see = db.rawQuery("select * from comm_reply_likes where POST_ID = '"+post_id+"' and LIKER_EMAIL = '"+liker_email+"' and TYPE = '"+type+"'",null);
        return see;
    }

    public Cursor treply_likes_check4(String post_id,String liker_email,String type){
        Cursor see = db.rawQuery("select * from talents_comm_reply_likes where POST_ID = '"+post_id+"' and LIKER_EMAIL = '"+liker_email+"' and TYPE = '"+type+"'",null);
        return see;
    }

    public Cursor reply_likes_check2(String post_id){
        Cursor see = db.rawQuery("select * from comm_reply_likes where POST_ID = '"+post_id+"'",null);
        return see;
    }

    public Cursor reply_likes_check3(String post_id,String type){
        Cursor see = db.rawQuery("select * from comm_reply_likes where POST_ID = '"+post_id+"' and TYPE = '"+type+"'",null);
        return see;
    }

    public Cursor treply_likes_check3(String post_id,String type){
        Cursor see = db.rawQuery("select * from talents_comm_reply_likes where POST_ID = '"+post_id+"' and TYPE = '"+type+"'",null);
        return see;
    }


    public Cursor reply_shares_check_all(){
        Cursor see = db.rawQuery("select * from comm_reply_shares ",null);
        return see;
    }

    public Cursor treply_shares_check_all(){
        Cursor see = db.rawQuery("select * from talents_comm_reply_shares ",null);
        return see;
    }

    public Cursor reply_shares_check2(String post_id){
        Cursor see = db.rawQuery("select * from comm_reply_shares where POST_ID = '"+post_id+"'",null);
        return see;
    }

    public Cursor reply_shares_check3(String post_id,String type){
        Cursor see = db.rawQuery("select * from comm_reply_shares where POST_ID = '"+post_id+"' and TYPE = '"+type+"'",null);
        return see;
    }

    public Cursor treply_shares_check3(String post_id,String type){
        Cursor see = db.rawQuery("select * from talents_comm_reply_shares where POST_ID = '"+post_id+"' and TYPE = '"+type+"'",null);
        return see;
    }

    public int likes_delete(String post_id,String liker_email){
        int del =  db.delete("likes","POST_ID = ? and LIKER_EMAIL = ?",new String[]{post_id,liker_email});
        return del;
    }

    public int tlikes_delete(String post_id,String liker_email){
        int del =  db.delete("talents_likes","POST_ID = ? and LIKER_EMAIL = ?",new String[]{post_id,liker_email});
        return del;
    }

    public int tnom_delete(String post_id,String nominator){
        int del =  db.delete("talents_nominate","POST_ID = ? and NOMINATOR_EMAIL = ?",new String[]{post_id,nominator});
        return del;
    }

    public int reply_likes_delete(String post_id,String liker_email,String type){
        int del =  db.delete("comm_reply_likes","POST_ID = ? and LIKER_EMAIL = ? and TYPE = ?",new String[]{post_id,liker_email,type});
        return del;
    }

    public int treply_likes_delete(String post_id,String liker_email,String type){
        int del =  db.delete("talents_comm_reply_likes","POST_ID = ? and LIKER_EMAIL = ? and TYPE = ?",new String[]{post_id,liker_email,type});
        return del;
    }

    public int reply_shares_delete(String post_id,String sharer_email,String type){
        int del =  db.delete("comm_reply_shares","POST_ID = ? and SHARER_EMAIL = ? and TYPE = ?",new String[]{post_id,sharer_email,type});
        return del;
    }

    public int treply_shares_delete(String post_id,String sharer_email,String type){
        int del =  db.delete("talents_comm_reply_shares","POST_ID = ? and SHARER_EMAIL = ? and TYPE = ?",new String[]{post_id,sharer_email,type});
        return del;
    }

    public int reply_shares_delete2(String post_id,String type){
        int del =  db.delete("comm_reply_shares","POST_ID = ? and TYPE = ?",new String[]{post_id,type});
        return del;
    }

    public int treply_shares_delete2(String post_id,String type){
        int del =  db.delete("talents_comm_reply_shares","POST_ID = ? and TYPE = ?",new String[]{post_id,type});
        return del;
    }




    public Long nominate_insert(String post_id,String nominator_email){
        ContentValues cv = new ContentValues();
        cv.put("POST_ID",post_id);
        cv.put("NOMINATOR_EMAIL",nominator_email);
        Long check = db.insert("talents_nominate",null,cv);
        return check;
    }

    public Cursor nominate_check(String post_id,String nominator_email){
        Cursor see = db.rawQuery("select * from talents_nominate where POST_ID = '"+post_id+"' and NOMINATOR_EMAIL = '"+nominator_email+"'",null);
        return see;
    }

    public Cursor nominate_check2(String post_id){
        Cursor see = db.rawQuery("select * from talents_nominate where POST_ID = '"+post_id+"'",null);
        return see;
    }

    public int nominate_delete(String post_id,String nominator_email){
        int del =  db.delete("talents_nominate","POST_ID = ? and NOMINATOR_EMAIL = ?",new String[]{post_id,nominator_email});
        return del;
    }

    public Long saved_insert(String post_id,String saver_email){
        ContentValues cv = new ContentValues();
        cv.put("POST_ID",post_id);
        cv.put("SAVER_EMAIL",saver_email);
        Long check = db.insert("saved",null,cv);
        return check;
    }

    public Long tsaved_insert(String post_id,String saver_email){
        ContentValues cv = new ContentValues();
        cv.put("POST_ID",post_id);
        cv.put("SAVER_EMAIL",saver_email);
        Long check = db.insert("talents_saved",null,cv);
        return check;
    }

    public Long job_saved_insert(String post_id,String saver_email){
        ContentValues cv = new ContentValues();
        cv.put("POST_ID",post_id);
        cv.put("SAVER_EMAIL",saver_email);
        Long check = db.insert("job_saved",null,cv);
        return check;
    }

    public Long job_applied_insert(String post_id,String applyer_email){
        ContentValues cv = new ContentValues();
        cv.put("POST_ID",post_id);
        cv.put("APPLYER_EMAIL",applyer_email);
        Long check = db.insert("job_applied",null,cv);
        return check;
    }

    public Cursor saved_check(String post_id,String saver_email){
        Cursor see = db.rawQuery("select * from saved where POST_ID = '"+post_id+"' and SAVER_EMAIL = '"+saver_email+"'",null);
        return see;
    }

    public Cursor tsaved_check(String post_id,String saver_email){
        Cursor see = db.rawQuery("select * from talents_saved where POST_ID = '"+post_id+"' and SAVER_EMAIL = '"+saver_email+"'",null);
        return see;
    }

    public Cursor job_saved_check(String post_id,String saver_email){
        Cursor see = db.rawQuery("select * from job_saved where POST_ID = '"+post_id+"' and SAVER_EMAIL = '"+saver_email+"'",null);
        return see;
    }

    public Cursor job_applied_check(String post_id,String applyer_email){
        Cursor see = db.rawQuery("select * from job_applied where POST_ID = '"+post_id+"' and APPLYER_EMAIL = '"+applyer_email+"'",null);
        return see;
    }

    public Cursor comments_check(String post_id,String commenter_email){
        Cursor see = db.rawQuery("select * from comments where POST_ID = '"+post_id+"' and COMMENTER_EMAIL = '"+commenter_email+"'",null);
        return see;
    }

    public Cursor tcomments_check(String post_id,String commenter_email){
        Cursor see = db.rawQuery("select * from talents_comments where POST_ID = '"+post_id+"' and COMMENTER_EMAIL = '"+commenter_email+"'",null);
        return see;
    }

    public Cursor saved_check2(String post_id){
        Cursor see = db.rawQuery("select * from saved where POST_ID = '"+post_id+"'",null);
        return see;
    }

    public Cursor tsaved_check2(String post_id){
        Cursor see = db.rawQuery("select * from talents_saved where POST_ID = '"+post_id+"'",null);
        return see;
    }

    public Cursor share_check2(String post_id){
        Cursor see = db.rawQuery("select * from share where POST_ID = '"+post_id+"'",null);
        return see;
    }

    public Cursor tshare_check2(String post_id){
        Cursor see = db.rawQuery("select * from talents_share where POST_ID = '"+post_id+"'",null);
        return see;
    }

    public Cursor tnominate_check2(String post_id){
        Cursor see = db.rawQuery("select * from talents_nominate where POST_ID = '"+post_id+"'",null);
        return see;
    }

    public Cursor comments_check2(String post_id){
        Cursor see = db.rawQuery("select * from comments where POST_ID = '"+post_id+"'",null);
        return see;
    }

    public Cursor tcomments_check2(String post_id){
        Cursor see = db.rawQuery("select * from talents_comments where POST_ID = '"+post_id+"'",null);
        return see;
    }

    public Cursor reply_check2(String comment_id){
        Cursor see = db.rawQuery("select * from reply where COMMENT_ID = '"+comment_id+"'",null);
        return see;
    }

    public int saved_delete(String post_id,String saver_email){
        int del =  db.delete("saved","POST_ID = ? and SAVER_EMAIL = ?",new String[]{post_id,saver_email});
        return del;
    }

    public int tsaved_delete(String post_id,String saver_email){
        int del =  db.delete("talents_saved","POST_ID = ? and SAVER_EMAIL = ?",new String[]{post_id,saver_email});
        return del;
    }

    public int job_saved_delete(String post_id,String saver_email){
        int del =  db.delete("job_saved","POST_ID = ? and SAVER_EMAIL = ?",new String[]{post_id,saver_email});
        return del;
    }

    public int job_saved_delete2(String post_id){
        int del =  db.delete("job_saved","POST_ID = ?",new String[]{post_id});
        return del;
    }

    public int job_applied_delete(String post_id,String applyer_email){
        int del =  db.delete("job_applied","POST_ID = ? and APPLYER_EMAIL = ?",new String[]{post_id,applyer_email});
        return del;
    }

    public int job_applied_delete2(String post_id){
        int del =  db.delete("job_applied","POST_ID = ?",new String[]{post_id});
        return del;
    }

    public int job_post_delete(int post_id){
        int del =  db.delete("job_post","POST_ID = ?",new String[]{Integer.toString(post_id)});
        return del;
    }

    public int board_post_delete(int post_id){
        int del =  db.delete("board_post","POST_ID = ?",new String[]{Integer.toString(post_id)});
        return del;
    }

    public int board_guest_delete(String post_id){
        int del =  db.delete("board_guest","POST_ID = ?",new String[]{post_id});
        return del;
    }

    public Cursor quick_post_temp_request(String account){
        Cursor see = db.rawQuery("select * from quick_post_temp where ACCOUNT = '"+account+"'",null);
        return see;
    }

    public Cursor article_authors_temp_request(String email){
        Cursor see = db.rawQuery("select * from article_authors_temp where EMAIL = '"+email+"'",null);
        return see;
    }

    public Cursor article_authors_temp_request2(String page_id){
        Cursor see = db.rawQuery("select * from article_authors_temp where PAGE_ID = '"+page_id+"'",null);
        return see;
    }

    public Cursor board_guest_temp_request(String page_id){
        Cursor see = db.rawQuery("select * from board_guest_temp where PAGE_ID = '"+page_id+"'",null);
        return see;
    }

    public Cursor article_authors_request(String post_id){
        Cursor see = db.rawQuery("select * from article_authors where POST_ID = '"+post_id+"'",null);
        return see;
    }

    public Cursor article_authors_temp_request3(String page_id,String author){
        Cursor see = db.rawQuery("select * from article_authors_temp where PAGE_ID = '"+page_id+"' and AUTHOR_EMAIL = '"+author+"'",null);
        return see;
    }

    public Cursor board_guest_temp_request2(String page_id,String guest){
        Cursor see = db.rawQuery("select * from board_guest_temp where PAGE_ID = '"+page_id+"' and GUEST = '"+guest+"'",null);
        return see;
    }

    public Cursor article_authors_temp_request4(String email,String author){
        Cursor see = db.rawQuery("select * from article_authors_temp where EMAIL = '"+email+"' and AUTHOR_EMAIL = '"+author+"'",null);
        return see;
    }

    public Cursor reseller_temp_request(String page_id,String reseller){
        Cursor see = db.rawQuery("select * from reseller_temp where RESELLER_EMAIL = '"+reseller+"' and PAGE_ID = '"+page_id+"'",null);
        return see;
    }

    public Cursor reseller_temp_request2(String page_id){
        Cursor see = db.rawQuery("select * from reseller_temp where PAGE_ID = '"+page_id+"'",null);
        return see;
    }

    public Cursor reseller_request(String page_id,String reseller,String brand_id){
        Cursor see = db.rawQuery("select * from reseller where RESELLER_EMAIL = '"+reseller+"' and PAGE_ID = '"+page_id+"' and BRAND_ID = '"+brand_id+"'",null);
        return see;
    }

    public Cursor reseller_request2(String page_id,String brand_id){
        Cursor see = db.rawQuery("select * from reseller where PAGE_ID = '"+page_id+"' and BRAND_ID = '"+brand_id+"'",null);
        return see;
    }

    public Cursor talent_post_temp_request(String account){
        Cursor see = db.rawQuery("select * from talent_post_temp where Account = '"+account+"'",null);
        return see;
    }

    public Cursor article_post_temp_request(String account){
        Cursor see = db.rawQuery("select * from article_temp where EMAIL = '"+account+"'",null);
        return see;
    }

    public Cursor brand_pic_temp_request(String page_id){
        Cursor see = db.rawQuery("select * from brand_pic_temp where PAGE_ID = '"+page_id+"'",null);
        return see;
    }

    public Cursor brand_pic_request(String page_id,String brand_id){
        Cursor see = db.rawQuery("select * from brand_pic where PAGE_ID = '"+page_id+"' and BRAND_ID = '"+brand_id+"'",null);
        return see;
    }

    public Cursor brand_temp_request(String page_id){
        Cursor see = db.rawQuery("select * from brand_temp where PAGE_ID = '"+page_id+"'",null);
        return see;
    }

    public Cursor brand_request(String page_id,int brand_id){
        Cursor see = db.rawQuery("select * from brand where PAGE_ID = '"+page_id+"' and BRAND_ID = '"+brand_id+"'",null);
        return see;
    }

    public Cursor brand_partner_temp_request(String page_id,String company){
        Cursor see = db.rawQuery("select * from brand_partner_temp where PAGE_ID = '"+page_id+"' and COMPANY = '"+company+"'",null);
        return see;
    }

    public Cursor brand_partner_request(String page_id,String company,String brand_id){
        Cursor see = db.rawQuery("select * from brand_partner where PAGE_ID = '"+page_id+"' and COMPANY = '"+company+"' and BRAND_ID = '"+brand_id+"'",null);
        return see;
    }

    public Cursor brand_manufacturer_request(String page_id,String company,String brand_id){
        Cursor see = db.rawQuery("select * from brand_manufacturer where PAGE_ID = '"+page_id+"' and COMPANY = '"+company+"' and BRAND_ID = '"+brand_id+"'",null);
        return see;
    }

    public Cursor brand_distributor_request(String page_id,String company,String brand_id){
        Cursor see = db.rawQuery("select * from brand_distributor where PAGE_ID = '"+page_id+"' and COMPANY = '"+company+"' and BRAND_ID = '"+brand_id+"'",null);
        return see;
    }

    public Cursor brand_partner_temp_request2(String page_id){
        Cursor see = db.rawQuery("select * from brand_partner_temp where PAGE_ID = '"+page_id+"'",null);
        return see;
    }

    public Cursor brand_manufacturer_temp_request2(String page_id){
        Cursor see = db.rawQuery("select * from brand_manufacturer_temp where PAGE_ID = '"+page_id+"'",null);
        return see;
    }

    public Cursor brand_distributor_temp_request2(String page_id){
        Cursor see = db.rawQuery("select * from brand_distributor_temp where PAGE_ID = '"+page_id+"'",null);
        return see;
    }

    public Cursor brand_partner_request2(String page_id,String brand_id){
        Cursor see = db.rawQuery("select * from brand_partner where PAGE_ID = '"+page_id+"' and BRAND_ID = '"+brand_id+"'",null);
        return see;
    }

    public Cursor brand_manufacturer_request2(String page_id,String brand_id){
        Cursor see = db.rawQuery("select * from brand_manufacturer where PAGE_ID = '"+page_id+"' and BRAND_ID = '"+brand_id+"'",null);
        return see;
    }

    public Cursor brand_distributor_request2(String page_id,String brand_id){
        Cursor see = db.rawQuery("select * from brand_distributor where PAGE_ID = '"+page_id+"' and BRAND_ID = '"+brand_id+"'",null);
        return see;
    }

    public Cursor brand_manufacturer_temp_request(String page_id,String company){
        Cursor see = db.rawQuery("select * from brand_manufacturer_temp where PAGE_ID = '"+page_id+"' and COMPANY = '"+company+"'",null);
        return see;
    }

    public Cursor brand_distributor_temp_request(String page_id,String company){
        Cursor see = db.rawQuery("select * from brand_distributor_temp where PAGE_ID = '"+page_id+"' and COMPANY = '"+company+"'",null);
        return see;
    }

    public Cursor logo_pic_temp_request(String page_id){
        Cursor see = db.rawQuery("select * from logo_pic_temp where PAGE_ID = '"+page_id+"'",null);
        return see;
    }

    public Cursor logo_pic_request(String page_id,String brand_id){
        Cursor see = db.rawQuery("select * from logo_pic where PAGE_ID = '"+page_id+"' and BRAND_ID = '"+brand_id+"'",null);
        return see;
    }

    public Cursor article_post_temp_request2(String page_id){
        Cursor see = db.rawQuery("select * from article_temp where PAGE_ID = '"+page_id+"'",null);
        return see;
    }

    public Cursor article_post_request(String post_id){
        Cursor see = db.rawQuery("select * from article where POST_ID = '"+post_id+"'",null);
        return see;
    }

    public Cursor quick_post_media_temp_request(String account,String cat) {
        Cursor see = db.rawQuery("select * from quick_post_media_temp where Account = '" + account + "' and CATEGORY = '" + cat + "'", null);
        return see;
    }

    public Cursor quick_post_media_temp_request3(String account,String cat,String name) {
        Cursor see = db.rawQuery("select * from quick_post_media_temp where Account = '" + account + "' and CATEGORY = '" + cat + "' and NAME = '" + name + "'", null);
        return see;
    }

    public Cursor quick_post_media_temp_request4(String page_id,String cat,String name) {
        Cursor see = db.rawQuery("select * from quick_post_media_temp where PAGE_ID = '" + page_id + "' and CATEGORY = '" + cat + "' and NAME = '" + name + "'", null);
        return see;
    }

    public Cursor quick_post_temp_request2(String page_id){
        Cursor see = db.rawQuery("select * from quick_post_temp where PAGE_ID = '"+page_id+"'",null);
        return see;
    }

    public Cursor quick_post_media_temp_request2(String page_id,String cat) {
        Cursor see = db.rawQuery("select * from quick_post_media_temp where PAGE_ID = '" + page_id + "' and CATEGORY = '" + cat + "'", null);
        return see;
    }

    public int quick_post_temp_delete(String account){
        int del =  db.delete("quick_post_temp","Account = ?",new String[]{account});
        return del;
    }

    public int job_post_temp_delete(String page_id){
        int del =  db.delete("job_post_temp","PAGE_ID = ?",new String[]{page_id});
        return del;
    }

    public int board_post_temp_delete(String page_id){
        int del =  db.delete("board_post_temp","PAGE_ID = ?",new String[]{page_id});
        return del;
    }

    public int board_guest_temp_delete(String page_id){
        int del =  db.delete("board_guest_temp","PAGE_ID = ?",new String[]{page_id});
        return del;
    }

    public int board_guest_temp_delete2(String page_id,String email){
        int del =  db.delete("board_guest_temp","PAGE_ID = ? and GUEST = ?",new String[]{page_id,email});
        return del;
    }

    public int deliverers_delete(String page_id,String email){
        int del =  db.delete("deliverers","PAGE_ID = ? and DELIVERER = ?",new String[]{page_id,email});
        return del;
    }

    public int reseller_delete(String page_id,String email,String brand_id){
        int del =  db.delete("reseller","PAGE_ID = ? and RESELLER_EMAIL = ? and BRAND_ID = ?",new String[]{page_id,email,brand_id});
        return del;
    }

    public int reseller_delete(String page_id,String brand_id){
        int del =  db.delete("reseller","PAGE_ID = ? and BRAND_ID = ?",new String[]{page_id,brand_id});
        return del;
    }

    public int reseller_temp_delete(String page_id,String email){
        int del =  db.delete("reseller_temp","PAGE_ID = ? and RESELLER_EMAIL = ?",new String[]{page_id,email});
        return del;
    }

    public int talent_post_temp_delete(String account){
        int del =  db.delete("talent_post_temp","Account = ?",new String[]{account});
        return del;
    }

    public int article_post_temp_delete(String account){
        int del =  db.delete("article_temp","EMAIL = ?",new String[]{account});
        return del;
    }

    public int article_post_temp_delete2(String page_id){
        int del =  db.delete("article_temp","PAGE_ID = ?",new String[]{page_id});
        return del;
    }

    public int brand_temp_delete(String page_id){
        int del =  db.delete("brand_temp","PAGE_ID = ?",new String[]{page_id});
        return del;
    }


    public int brand_pic_temp_delete(String page_id){
        int del =  db.delete("brand_pic_temp","PAGE_ID = ?",new String[]{page_id});
        return del;
    }

    public int brand_pic_delete(String page_id,String brand_id){
        int del =  db.delete("brand_pic","PAGE_ID = ? and BRAND_ID = ?",new String[]{page_id,brand_id});
        return del;
    }


    public int logo_pic_temp_delete(String page_id){
        int del =  db.delete("logo_pic_temp","PAGE_ID = ?",new String[]{page_id});
        return del;
    }

    public int logo_pic_delete(String page_id,String brand_id){
        int del =  db.delete("logo_pic","PAGE_ID = ? and BRAND_ID = ?",new String[]{page_id,brand_id});
        return del;
    }

    public int quick_post_media_temp_delete(String account,String cat){
        int del =  db.delete("quick_post_media_temp","Account = ? and CATEGORY = ?",new String[]{account,cat});
        return del;
    }

    public int quick_post_media_temp_delete3(String account,String cat,String name){
        int del =  db.delete("quick_post_media_temp","Account = ? and CATEGORY = ? and NAME = ?",new String[]{account,cat,name});
        return del;
    }

    public int quick_post_temp_delete2(String page_id){
        int del =  db.delete("quick_post_temp","PAGE_ID = ?",new String[]{page_id});
        return del;
    }

    public int quick_post_media_temp_delete2(String page_id,String cat){
        int del =  db.delete("quick_post_media_temp","PAGE_ID = ? and CATEGORY = ?",new String[]{page_id,cat});
        return del;
    }

    public int quick_post_media_temp_delete4(String page_id,String cat,String name){
        int del =  db.delete("quick_post_media_temp","PAGE_ID = ? and CATEGORY = ? and NAME = ?",new String[]{page_id,cat,name});
        return del;
    }

    public Long quick_post_temp_insert(String account,String page_id,String post){
        ContentValues cv = new ContentValues();
        cv.put("Account",account);
        cv.put("PAGE_ID",page_id);
        cv.put("POST",post);
        Long check = db.insert("quick_post_temp",null,cv);
        return check;
    }

    public Long article_author_temp_insert(String email,String page_id,String author){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",email);
        cv.put("PAGE_ID",page_id);
        cv.put("AUTHOR_EMAIL",author);
        Long check = db.insert("article_authors_temp",null,cv);
        return check;
    }


    public Long reseller_temp_insert(String page_id,String reseller){
        ContentValues cv = new ContentValues();
        cv.put("PAGE_ID",page_id);
        cv.put("RESELLER_EMAIL",reseller);
        Long check = db.insert("reseller_temp",null,cv);
        return check;
    }

    public Long reseller_insert(String brand_id,String page_id,String reseller){
        ContentValues cv = new ContentValues();
        cv.put("BRAND_ID",brand_id);
        cv.put("PAGE_ID",page_id);
        cv.put("RESELLER_EMAIL",reseller);
        Long check = db.insert("reseller",null,cv);
        return check;
    }

    public Long article_author_insert(String post_id,String author){
        ContentValues cv = new ContentValues();
        cv.put("POST_ID",post_id);
        cv.put("AUTHOR_EMAIL",author);
        Long check = db.insert("article_authors",null,cv);
        return check;
    }

    public Long talent_post_temp_insert(String account,String cat,String des){
        ContentValues cv = new ContentValues();
        cv.put("Account",account);
        cv.put("CATEGORY",cat);
        cv.put("DESCRIPTION",des);
        Long check = db.insert("talent_post_temp",null,cv);
        return check;
    }

    public Long article_post_temp_insert(String page_id,String email,String title,String industry,byte[] image,String image_status,String content){
        ContentValues cv = new ContentValues();
        cv.put("PAGE_ID",page_id);
        cv.put("EMAIL",email);
        cv.put("TITLE",title);
        cv.put("INDUSTRY",industry);
        cv.put("IMAGE",image);
        cv.put("IMAGE_STATUS",image_status);
        cv.put("CONTENT",content);
        Long check = db.insert("article_temp",null,cv);
        return check;
    }


    public Long brand_temp_insert(String page_id,String brand_name,String trademark_no,String registered,String upc,String category,String sub_category,String country,String phone,String website,String email){
        ContentValues cv = new ContentValues();
        cv.put("PAGE_ID",page_id);
        cv.put("NAME",brand_name);
        cv.put("TRADEMARK_NO",trademark_no);
        cv.put("REGISTERED_AT",registered);
        cv.put("UPC",upc);
        cv.put("CATEGORY",category);
        cv.put("SUB_CATEGORY",sub_category);
        cv.put("COUNTRY",country);
        cv.put("PHONE",phone);
        cv.put("WEBSITE",website);
        cv.put("EMAIL",email);
        Long check = db.insert("brand_temp",null,cv);
        return check;
    }

    public Long brand_pic_temp_insert(String page_id,byte[]image){
        ContentValues cv = new ContentValues();
        cv.put("PAGE_ID",page_id);
        cv.put("IMAGE",image);
        Long check = db.insert("brand_pic_temp",null,cv);
        return check;
    }

    public Long brand_pic_insert(String brand_id,String page_id,byte[]image){
        ContentValues cv = new ContentValues();
        cv.put("BRAND_ID",brand_id);
        cv.put("PAGE_ID",page_id);
        cv.put("IMAGE",image);
        Long check = db.insert("brand_pic",null,cv);
        return check;
    }

    public Long logo_pic_temp_insert(String page_id,byte[]image){
        ContentValues cv = new ContentValues();
        cv.put("PAGE_ID",page_id);
        cv.put("IMAGE",image);
        Long check = db.insert("logo_pic_temp",null,cv);
        return check;
    }

    public Long logo_pic_insert(String brand_id,String page_id,byte[]image){
        ContentValues cv = new ContentValues();
        cv.put("BRAND_ID",brand_id);
        cv.put("PAGE_ID",page_id);
        cv.put("IMAGE",image);
        Long check = db.insert("logo_pic",null,cv);
        return check;
    }

    public Long quick_post_media_temp_insert(String account,String page_id,String type,byte[] image,String video,byte[] audio,String cat,String name){
        ContentValues cv = new ContentValues();
        cv.put("Account",account);
        cv.put("PAGE_ID",page_id);
        cv.put("TYPE",type);
        cv.put("IMAGE",image);
        cv.put("VIDEO",video);
        cv.put("AUDIO",audio);
        cv.put("CATEGORY",cat);
        cv.put("NAME",name);
        Long check = db.insert("quick_post_media_temp",null,cv);
        return check;
    }

    public Long images_videos_audio_insert(String post_id,String type,byte[] image,String video,byte[] audio,String name){
        ContentValues cv = new ContentValues();
        cv.put("POST_ID",post_id);
        cv.put("TYPE",type);
        cv.put("IMAGE",image);
        cv.put("VIDEO",video);
        cv.put("AUDIO",audio);
        cv.put("NAME",name);
        Long check = db.insert("images_videos_audio",null,cv);
        return check;
    }

    public Long comment_media_insert(String post_id,String type,byte[] image,String video,byte[] audio){
        ContentValues cv = new ContentValues();
        cv.put("POST_ID",post_id);
        cv.put("TYPE",type);
        cv.put("IMAGE",image);
        cv.put("VIDEO",video);
        cv.put("AUDIO",audio);
        Long check = db.insert("comment_media",null,cv);
        return check;
    }

    public Long tcomment_media_insert(String post_id,String type,byte[] image,String video,byte[] audio){
        ContentValues cv = new ContentValues();
        cv.put("POST_ID",post_id);
        cv.put("TYPE",type);
        cv.put("IMAGE",image);
        cv.put("VIDEO",video);
        cv.put("AUDIO",audio);
        Long check = db.insert("talents_comment_media",null,cv);
        return check;
    }

    public Long reply_media_insert(String comment_id,String to_,String type,byte[] image,String video,byte[] audio){
        ContentValues cv = new ContentValues();
        cv.put("COMMENT_ID",comment_id);
        cv.put("TO_",to_);
        cv.put("TYPE",type);
        cv.put("IMAGE",image);
        cv.put("VIDEO",video);
        cv.put("AUDIO",audio);
        Long check = db.insert("reply_media",null,cv);
        return check;
    }

    public Long treply_media_insert(String comment_id,String to_,String type,byte[] image,String video,byte[] audio){
        ContentValues cv = new ContentValues();
        cv.put("COMMENT_ID",comment_id);
        cv.put("TO_",to_);
        cv.put("TYPE",type);
        cv.put("IMAGE",image);
        cv.put("VIDEO",video);
        cv.put("AUDIO",audio);
        Long check = db.insert("talents_reply_media",null,cv);
        return check;
    }

    public Long talents_media_insert(String post_id,String type,byte[] image,String video,byte[] audio){
        ContentValues cv = new ContentValues();
        cv.put("POST_ID",post_id);
        cv.put("TYPE",type);
        cv.put("IMAGE",image);
        cv.put("VIDEO",video);
        cv.put("AUDIO",audio);
        Long check = db.insert("talents_media",null,cv);
        return check;
    }

    public Cursor images_videos_audio_request(String post_id){
        Cursor see = db.rawQuery("select * from images_videos_audio where POST_ID = '"+post_id+"'",null);
        return see;
    }

    public Cursor comment_media_request(String post_id){
        Cursor see = db.rawQuery("select * from comment_media where POST_ID = '"+post_id+"'",null);
        return see;
    }

    public Cursor tcomment_media_request(String post_id){
        Cursor see = db.rawQuery("select * from talents_comment_media where POST_ID = '"+post_id+"'",null);
        return see;
    }

    public Cursor comment_media_request_all(){
        Cursor see = db.rawQuery("select * from comment_media",null);
        return see;
    }

    public Cursor tcomment_media_request_all(){
        Cursor see = db.rawQuery("select * from talents_comment_media",null);
        return see;
    }

    public Cursor reply_media_request(String comment_id){
        Cursor see = db.rawQuery("select * from reply_media where COMMENT_ID = '"+comment_id+"'",null);
        return see;
    }

    public Cursor treply_media_request(String comment_id){
        Cursor see = db.rawQuery("select * from talents_reply_media where COMMENT_ID = '"+comment_id+"'",null);
        return see;
    }

    public Cursor reply_media_request_all(){
        Cursor see = db.rawQuery("select * from reply_media",null);
        return see;
    }

    public Cursor treply_media_request_all(){
        Cursor see = db.rawQuery("select * from talents_reply_media",null);
        return see;
    }

    public Cursor talents_media_request(String post_id){
        Cursor see = db.rawQuery("select * from talents_media where POST_ID = '"+post_id+"'",null);
        return see;
    }

    public Cursor images_videos_audio_request2(String post_id,int id){
        Cursor see = db.rawQuery("select * from images_videos_audio where POST_ID = '"+post_id+"' and ID = '"+id+"'",null);
        return see;
    }

    public Cursor talents_media_request2(String post_id,int id){
        Cursor see = db.rawQuery("select * from talents_media where POST_ID = '"+post_id+"' and ID = '"+id+"'",null);
        return see;
    }

    public Cursor images_videos_audio_request_all(){
        Cursor see = db.rawQuery("select * from images_videos_audio ",null);
        return see;
    }

    public Long media_holder_insert(String type,byte[]image,String video,byte[]audio){
        ContentValues cv = new ContentValues();
        cv.put("TYPE",type);
        cv.put("IMAGE",image);
        cv.put("VIDEO",video);
        cv.put("AUDIO",audio);
        Long check = db.insert("media_holder",null,cv);
        return check;
    }

    public Long media_holder_all_insert(String post_id, String type,byte[]image,String video,byte[]audio){
        ContentValues cv = new ContentValues();
        cv.put("POST_ID",post_id);
        cv.put("TYPE",type);
        cv.put("IMAGE",image);
        cv.put("VIDEO",video);
        cv.put("AUDIO",audio);
        Long check = db.insert("media_holder_all",null,cv);
        return check;
    }

    public Cursor media_holder_request(){
        Cursor see = db.rawQuery("select * from media_holder",null);
        return see;
    }

    public Cursor media_holder_all_request(){
        Cursor see = db.rawQuery("select * from media_holder_all",null);
        return see;
    }

    public int media_holder_delete_all(){
        int del =  db.delete("media_holder",null,null);
        return del;
    }

    public int media_holder_all_delete_all(){
        int del =  db.delete("media_holder_all",null,null);
        return del;
    }

    public boolean follower_update2(String account,String dinky,String old_dinky){
        ContentValues cv = new ContentValues();
        cv.put("ACCOUNT",account);
        cv.put("FOLLOWER_DINKY",dinky);
        db.update("followers",cv,"ACCOUNT = ? and FOLLOWER_DINKY = ?",new String[]{account,old_dinky});
        return true;
    }

    public boolean follower_update3(String account,String camo,String old_camo){
        ContentValues cv = new ContentValues();
        cv.put("ACCOUNT",account);
        cv.put("FOLLOWING_CAMO",camo);
        db.update("followers",cv,"ACCOUNT = ? and FOLLOWING_CAMO = ?",new String[]{account,old_camo});
        return true;
    }

    public int page_follower_delete(String account,String page_id){
        int del =  db.delete("followers","ACCOUNT = ? and FOLLOWING_PAGE_ID = ?",new String[]{account,page_id});
        return del;
    }

    public int follower_delete(String account,String user){
        int del =  db.delete("followers","ACCOUNT = ? and FOLLOWER_DINKY = ?",new String[]{account,user});
        return del;
    }

    public int post_delete(int post_id){
        int del =  db.delete("posts","POST_ID = ?",new String[]{Integer.toString(post_id)});
        return del;
    }

    public int talent_delete(int post_id){
        int del =  db.delete("talents","POST_ID = ?",new String[]{Integer.toString(post_id)});
        return del;
    }
    public int images_videos_audio_delete2(String post_id){
        int del =  db.delete("images_videos_audio","POST_ID = ?",new String[]{post_id});
        return del;
    }

    public int media_holder_all_delete_all2(String post_id){
        int del =  db.delete("media_holder_all","POST_ID = ?",new String[]{post_id});
        return del;
    }

    public int talents_media_delete(String post_id){
        int del =  db.delete("talents_media","POST_ID = ?",new String[]{post_id});
        return del;
    }

    public int talents_media_delete2(String post_id,int id){
        int del =  db.delete("talents_media","POST_ID = ? and ID = ?",new String[]{post_id,Integer.toString(id)});
        return del;
    }

    public int images_videos_audio_delete(String post_id,int id){
        int del =  db.delete("images_videos_audio","POST_ID = ? and ID = ?",new String[]{post_id,Integer.toString(id)});
        return del;
    }

    public int saved_delete2(String post_id){
        int del =  db.delete("saved","POST_ID = ?",new String[]{post_id});
        return del;
    }
    public int share_delete2(String post_id){
        int del =  db.delete("share","POST_ID = ?",new String[]{post_id});
        return del;
    }
    public int clicks_delete2(String post_id){
        int del =  db.delete("post_views","POST_ID = ?",new String[]{post_id});
        return del;
    }
    public int likes_delete2(String post_id){
        int del =  db.delete("likes","POST_ID = ?",new String[]{post_id});
        return del;
    }

    public int comment_delete2(String post_id){
        int del =  db.delete("comments","POST_ID = ?",new String[]{post_id});
        return del;
    }


    public int tsaved_delete2(String post_id){
        int del =  db.delete("talents_saved","POST_ID = ?",new String[]{post_id});
        return del;
    }
    public int tshare_delete2(String post_id){
        int del =  db.delete("talents_share","POST_ID = ?",new String[]{post_id});
        return del;
    }
    public int tclicks_delete2(String post_id){
        int del =  db.delete("talent_views","POST_ID = ?",new String[]{post_id});
        return del;
    }
    public int tlikes_delete2(String post_id){
        int del =  db.delete("talents_likes","POST_ID = ?",new String[]{post_id});
        return del;
    }

    public int tcomment_delete2(String post_id){
        int del =  db.delete("talents_comments","POST_ID = ?",new String[]{post_id});
        return del;
    }

    public int nominate_delete2(String post_id){
        int del =  db.delete("talents_nominate","POST_ID = ?",new String[]{post_id});
        return del;
    }

    public int delivery_review_filter_delete(String email){
        int del =  db.delete("delivery_review_filter","EMAIL = ?",new String[]{email});
        return del;
    }

    public int delivery_review_filter_delete2(String deliverer){
        int del =  db.delete("delivery_review_filter","DELIVERER = ?",new String[]{deliverer});
        return del;
    }

    public Long post_insert(String poster_email,String post_text,String location,String current_longitude ,String current_latitude,String time,String page_id,String post_type,String repost_id,String preview,String preview_title,String preview_url,String preview_can_url,byte[] preview_image,String likers,String commenters,int lno,int cno,String view){
        ContentValues cv = new ContentValues();
        cv.put("POSTER_EMAIL",poster_email);
        cv.put("LOCATION",location);
        cv.put("CURRENT_LONGITUDE",current_longitude);
        cv.put("CURRENT_LATITUDE",current_latitude);
        cv.put("TIME",time);
        cv.put("POST",post_text);
        cv.put("POST_TYPE",post_type);
        cv.put("PAGE_ID",page_id);
        cv.put("REPOST_ID",repost_id);
        cv.put("PREVIEW",preview);
        cv.put("PREVIEW_TITLE",preview_title);
        cv.put("PREVIEW_URL",preview_url);
        cv.put("PREVIEW_CAN_URL",preview_can_url);
        cv.put("PREVIEW_IMAGE",preview_image);
        cv.put("LIKERS",likers);
        cv.put("COMMENTERS",commenters);
        cv.put("VIEWS",view);
        cv.put("LNO",lno);
        cv.put("CNO",cno);
        Long check = db.insert("posts",null,cv);
        return check;
    }

    public Long talent_insert(String poster_email,String description,String location,String current_longitude ,String current_latitude,String time,String repost_id,String category,String likers,String commenters,int lno,int cno,String view){
        ContentValues cv = new ContentValues();
        cv.put("POSTER_EMAIL",poster_email);
        cv.put("LOCATION",location);
        cv.put("CURRENT_LONGITUDE",current_longitude);
        cv.put("CURRENT_LATITUDE",current_latitude);
        cv.put("TIME",time);
        cv.put("DESCRIPTION",description);
        cv.put("REPOST_ID",repost_id);
        cv.put("CATEGORY",category);
        cv.put("LIKERS",likers);
        cv.put("COMMENTERS",commenters);
        cv.put("VIEWS",view);
        cv.put("LNO",lno);
        cv.put("CNO",cno);
        Long check = db.insert("talents",null,cv);
        return check;
    }

    public Boolean email_update_education(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        db.update("education_tab",cv,"EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_proffilt(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        db.update("profile_filter",cv,"EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_pagfilt(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        db.update("pages_filter",cv,"EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_ter(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        db.update("tertiary_education",cv,"EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_yourpage(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        db.update("your_page",cv,"EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_delivery_review_filter(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        db.update("delivery_review_filter",cv,"EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_delivery_review_filter_deliverer(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("DELIVERER",EMAIL);
        db.update("delivery_review_filter",cv,"DELIVERER = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_profileinfo(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        db.update("profile_info",cv,"EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_comm_reply_info(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        db.update("comm_reply_info",cv,"EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_pageassoc(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        db.update("page_associates",cv,"EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_quick_post_temp(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("Account",EMAIL);
        db.update("quick_post_temp",cv,"Account = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_talent_post_temp(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("Account",EMAIL);
        db.update("talent_post_temp",cv,"Account = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_post_viewer(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("VIEWER",EMAIL);
        db.update("post_views",cv,"VIEWER = ?",new String[]{old_email});
        return true;
    }
    public Boolean email_update_talent_viewer(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("VIEWER",EMAIL);
        db.update("talent_views",cv,"VIEWER = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_quick_post_media_temp(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("Account",EMAIL);
        db.update("quick_post_media_temp",cv,"Account = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_deliveryreview(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("DELIVERER_EMAIL",EMAIL);
        db.update("delivery_review",cv,"DELIVERER_EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_job_saved(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("SAVER_EMAIL",EMAIL);
        db.update("job_saved",cv,"SAVER_EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_job_applied(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("APPLYER_EMAIL",EMAIL);
        db.update("job_applied",cv,"APPLYER_EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_following_account(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("ACCOUNT",EMAIL);
        db.update("followers",cv,"ACCOUNT = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_draft_one_email(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        db.update("draft_one",cv,"EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_following_camo(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("FOLLOWING_CAMO",EMAIL);
        db.update("followers",cv,"FOLLOWING_CAMO = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_verification(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("DELIVERER",EMAIL);
        db.update("verification",cv,"DELIVERER = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_following_dinky(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("FOLLOWER_DINKY",EMAIL);
        db.update("followers",cv,"FOLLOWER_DINKY = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_org_topdel(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        db.update("organized_top_deliverers",cv,"EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_tempadmin(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        db.update("temporary_admin",cv,"EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_techskill(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        db.update("tech_skills",cv,"EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_perskill(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        db.update("personal_skills",cv,"EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_interests(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        db.update("interests",cv,"EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_industries(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        db.update("industries",cv,"EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_state(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        db.update("state",cv,"EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_comfilt(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        db.update("company_filter",cv,"EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_expfilt(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        db.update("explore_filter",cv,"EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_popfilt(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        db.update("popular_filter",cv,"EMAIL = ?",new String[]{old_email});
        return true;
    }


    public Boolean email_update_jobfilt(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        db.update("job_filter",cv,"EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_draft_main_email(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        db.update("draft_main",cv,"EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_talfilt(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        db.update("talents_filter",cv,"EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_topdelfilt(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        db.update("top_deliverer_filter",cv,"EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_schfilt(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        db.update("school_filter",cv,"EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_work(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        db.update("work",cv,"EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_post_settings(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        db.update("post_settings",cv,"EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_reseller(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("RESELLER_EMAIL",EMAIL);
        db.update("reseller",cv,"RESELLER_EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_reseller_temp(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("RESELLER_EMAIL",EMAIL);
        db.update("reseller_temp",cv,"RESELLER_EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_blocked1(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        db.update("blocked",cv,"EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_blocked2(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("BLOCKED_EMAIL",EMAIL);
        db.update("blocked",cv,"BLOCKED_EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_report1(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        db.update("reports",cv,"EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_report2(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("REPORTED_EMAIL",EMAIL);
        db.update("reports",cv,"REPORTED_EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_lang(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        db.update("language",cv,"EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_extra(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        db.update("extra",cv,"EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_techcert(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        db.update("tech_cert",cv,"EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_comments(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("COMMENTER_EMAIL",EMAIL);
        db.update("comments",cv,"COMMENTER_EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_posteremail(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("POSTER_EMAIL",EMAIL);
        db.update("posts",cv,"POSTER_EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_comments_talents(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("COMMENTER_EMAIL",EMAIL);
        db.update("talents_comments",cv,"COMMENTER_EMAIL = ?",new String[]{old_email});
        return true;
    }


    public Boolean email_update_posteremail_talents(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("POSTER_EMAIL",EMAIL);
        db.update("talents",cv,"POSTER_EMAIL = ?",new String[]{old_email});
        return true;
    }


    public Boolean email_update_nominate(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("NOMINATOR_EMAIL",EMAIL);
        db.update("talents_nominate",cv,"NOMINATOR_EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_saved(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("SAVER_EMAIL",EMAIL);
        db.update("saved",cv,"SAVER_EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_likes(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("LIKER_EMAIL",EMAIL);
        db.update("likes",cv,"LIKER_EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_treply(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("REPLYER_EMAIL",EMAIL);
        db.update("talents_reply",cv,"REPLYER_EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_tsaved(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("SAVER_EMAIL",EMAIL);
        db.update("talents_saved",cv,"SAVER_EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_tlikes(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("LIKER_EMAIL",EMAIL);
        db.update("talents_likes",cv,"LIKER_EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_tcomm_reply_likes(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("LIKER_EMAIL",EMAIL);
        db.update("talents_comm_reply_likes",cv,"LIKER_EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_tcomm_reply_shares(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("SHARER_EMAIL",EMAIL);
        db.update("talents_comm_reply_shares",cv,"SHARER_EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_tshare(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("SHARER_EMAIL",EMAIL);
        db.update("talents_share",cv,"SHARER_EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_comm_reply_likes(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("LIKER_EMAIL",EMAIL);
        db.update("comm_reply_likes",cv,"LIKER_EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_comm_reply_shares(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("SHARER_EMAIL",EMAIL);
        db.update("comm_reply_shares",cv,"SHARER_EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_share(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("SHARER_EMAIL",EMAIL);
        db.update("share",cv,"SHARER_EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean email_update_vol(String EMAIL,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        db.update("volunteer",cv,"EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean account_date_created_update(String EMAIL,String date){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        cv.put("DATE_CREATED",date);
        db.update("account_info",cv,"EMAIL = ?",new String[]{EMAIL});
        return true;
    }

    public Boolean page_date_created_update(int page_id,String date){
        ContentValues cv = new ContentValues();
        cv.put("PAGE_ID",page_id);
        cv.put("DATE_CREATED",date);
        db.update("pages",cv,"PAGE_ID = ?",new String[]{Integer.toString(page_id)});
        return true;
    }


    public Cursor chat_list(String user_id){ //GROUP BY FRIEND_ID
        Cursor see = db.rawQuery("SELECT * FROM chat_list WHERE USER_ID = '"+user_id+"'GROUP BY FRIEND_ID ORDER BY TIME DESC",null);
        return see;
    }

    public Cursor allChatLists(){
        Cursor see = db.rawQuery("SELECT * FROM chat_list",null);
        return see;
    }

    public Cursor allChats(){
        Cursor see = db.rawQuery("SELECT * FROM chat",null);
        return see;
    }

    public Boolean update_chat_list(String userid,String friend_id,String position,String time,String category,String last_message,String has_image){
        ContentValues cv = new ContentValues();
        cv.put("POSITION",position);
        cv.put("TIME",time);
        cv.put("CATEGORY",category);
        cv.put("LAST_MESSAGE",last_message);
        cv.put("HAS_IMAGE",has_image);

        db.update("chat_list",cv,"USER_ID = ? AND FRIEND_ID = ?",new String[]{userid,friend_id});
        return true;
    }

    public Cursor get_a_user(String user_id){
        Cursor see = db.rawQuery("SELECT * FROM m_test_users WHERE TEST_USER_ID = '"+user_id+"'",null);
        return see;
    }

    public Cursor search_users(String user_id, String text){
        Cursor see = db.rawQuery("SELECT * FROM m_test_users WHERE TEST_USER_ID = '"+user_id+"' AND FULL_NAME LIKE '%"+text+"%'",null);
        return see;
    }

    public Cursor check_chat(String user_id,String friend_id){
        Cursor see = db.rawQuery("SELECT * FROM chat_list WHERE USER_ID = '"+user_id+"' AND FRIEND_ID = '"+friend_id+"'",null);
        return see;
    }

    public Cursor get_users(){
        Cursor see = db.rawQuery("SELECT * FROM m_test_users",null);
        return see;

    }

    public Cursor displayChats(String user_id,String friend_id){
        Cursor see = db.rawQuery("SELECT * FROM chat WHERE SENDER_ID = '"+user_id+"' AND RECEIVER_ID = '"+friend_id+"'",null);
        return see;
    }

    public Cursor search_users(String name){
        Cursor search= db.rawQuery("SELECT * FROM m_test_users WHERE "+name+" LIKE %FULL_NAME%",null);
        return search;
    }


    public Cursor post_request(String email){
        Cursor see = db.rawQuery("select * from posts where POSTER_EMAIL = '"+email+"'",null);
        return see;
    }

    public Cursor talent_request(String email){
        Cursor see = db.rawQuery("select * from talents where POSTER_EMAIL = '"+email+"'",null);
        return see;
    }

    public Cursor post_request_person(String email,int id){
        Cursor see = db.rawQuery("select * from posts where POSTER_EMAIL = '"+email+"' and POST_ID = '"+id+"'",null);
        return see;
    }

    public Cursor post_request_page(String page_id,int id){
        Cursor see = db.rawQuery("select * from posts where PAGE_ID = '"+page_id+"' and POST_ID = '"+id+"'",null);
        return see;
    }

    public Cursor saved_request(String email){
        Cursor see = db.rawQuery("select * from saved where SAVER_EMAIL = '"+email+"'",null);
        return see;
    }

    public Cursor post_request_all(){
        Cursor see = db.rawQuery("select * from posts",null);
        return see;
    }

    public Cursor talent_request_all(){
        Cursor see = db.rawQuery("select * from talents",null);
        return see;
    }

    public Cursor post_request2(int post_id){
        Cursor see = db.rawQuery("select * from posts where POST_ID = '"+post_id+"'",null);
        return see;
    }

    public Cursor talent_request2(int post_id){
        Cursor see = db.rawQuery("select * from talents where POST_ID = '"+post_id+"'",null);
        return see;
    }

    public Cursor talent_request5(int post_id,String email,String location){
        Cursor see = db.rawQuery("select * from talents where POST_ID = '"+post_id+"' and POSTER_EMAIL = '"+email+"' and LOCATION = '"+location+"'",null);
        return see;
    }

    public Cursor talent_request6(int post_id,String email){
        Cursor see = db.rawQuery("select * from talents where POST_ID = '"+post_id+"' and POSTER_EMAIL = '"+email+"'",null);
        return see;
    }

    public Cursor talent_request7(int post_id,String category){
        Cursor see = db.rawQuery("select * from talents where POST_ID = '"+post_id+"' and CATEGORY = '"+category+"'",null);
        return see;
    }

    public Cursor talent_saved_request(String saver_email){
        Cursor see = db.rawQuery("select * from talents_saved where SAVER_EMAIL = '"+saver_email+"'",null);
        return see;
    }

    public Cursor talent_saved_request2(String post_id,String saver_email){
        Cursor see = db.rawQuery("select * from talents_saved where SAVER_EMAIL = '"+saver_email+"' and POST_ID = '"+post_id+"'",null);
        return see;
    }

    public Cursor post_request3(String page_id){
        Cursor see = db.rawQuery("select * from posts where PAGE_ID = '"+page_id+"'",null);
        return see;
    }

    public Cursor post_request5(String location){
        Cursor see = db.rawQuery("select * from posts where LOCATION = '"+location+"'",null);
        return see;
    }

    public Cursor post_request4(int post_id,String location){
        Cursor see = db.rawQuery("select * from posts where POST_ID = '"+post_id+"' and LOCATION = '"+location+"'",null);
        return see;
    }

    public Cursor post_request6(String email,String post_type){
        Cursor see = db.rawQuery("select * from posts where POSTER_EMAIL = '"+email+"' and POST_TYPE = '"+post_type+"'",null);
        return see;
    }

    public Cursor post_request7(String page_id,String post_type){
        Cursor see = db.rawQuery("select * from posts where PAGE_ID = '"+page_id+"' and POST_TYPE = '"+post_type+"'",null);
        return see;
    }

    public Cursor talent_request4(int post_id,String location){
        Cursor see = db.rawQuery("select * from talents where POST_ID = '"+post_id+"' and LOCATION = '"+location+"'",null);
        return see;
    }

    public Long delivery_info_lead_insert(String page_id,String location,String lead_time,String existence,String correct){
        ContentValues cv = new ContentValues();
        cv.put("PAGE_ID",page_id);
        cv.put("LOCATION",location);
        cv.put("LEAD_TIME",lead_time);
        cv.put("EXISTENCE",existence);
        cv.put("CORRECT",correct);
        Long check = db.insert("delivery_info_lead",null,cv);
        return check;
    }

    public int delivery_info_lead_delete(String page_id,String location,String lead_time,String existence,String correct){
        int del =  db.delete("delivery_info_lead","PAGE_ID = ? and LOCATION = ? and LEAD_TIME = ? and EXISTENCE = ? and CORRECT = ?",new String[]{page_id,location,lead_time,existence,correct});
        return del;
    }

    public Boolean delivery_info_lead_update(String page_id,String location,String lead_time,String existence,String correct,String opage_id,String olocation,String olead_time,String oexistence,String ocorrect){
        ContentValues cv = new ContentValues();
        cv.put("PAGE_ID",page_id);
        cv.put("LOCATION",location);
        cv.put("LEAD_TIME",lead_time);
        cv.put("EXISTENCE",existence);
        cv.put("CORRECT",correct);
        db.update("delivery_info_lead",cv,"PAGE_ID = ? and LOCATION = ? and LEAD_TIME = ? and EXISTENCE = ? and CORRECT = ?",new String[]{opage_id,olocation,olead_time,oexistence,ocorrect});
        return true;
    }

    public Long delivery_info_ter_insert(String page_id, String territory,String existence,String correct){
        ContentValues cv = new ContentValues();
        cv.put("PAGE_ID",page_id);
        cv.put("TERRITORY",territory);
        cv.put("EXISTENCE",existence);
        cv.put("CORRECT",correct);
        Long check = db.insert("delivery_info_ter",null,cv);
        return check;
    }

    public Long delivery_data_insert(String page_id, String freight_mode,String freight_mode_id,String value, String shipping_cost,String shipping_cost_link,String refund_policy, String refund_policy_link,String life_tracking,String life_tracking_id,String life_tracking_info,String license){
        ContentValues cv = new ContentValues();
        cv.put("PAGE_ID",page_id);
        cv.put("FREIGHT_MODE",freight_mode);
        cv.put("FREIGHT_MODE_ID",freight_mode_id);
        cv.put("VALUE",value);
        cv.put("SHIPPING_COST",shipping_cost);
        cv.put("SHIPPING_COST_LINK",shipping_cost_link);
        cv.put("REFUND_POLICY",refund_policy);
        cv.put("REFUND_POLICY_LINK",refund_policy_link);
        cv.put("LIFE_TRACKING",life_tracking);
        cv.put("LIFE_TRACKING_ID",life_tracking_id);
        cv.put("LIFE_TRACKING_INFO",life_tracking_info);
        cv.put("LICENSE",license);
        Long check = db.insert("delivery_data",null,cv);
        return check;
    }

    public Boolean delivery_data_update(String page_id, String freight_mode,String freight_mode_id,String value, String shipping_cost,String shipping_cost_link,String refund_policy, String refund_policy_link,String life_tracking,String life_tracking_id,String life_tracking_info,String license){
        ContentValues cv = new ContentValues();
        cv.put("PAGE_ID",page_id);
        cv.put("FREIGHT_MODE",freight_mode);
        cv.put("FREIGHT_MODE_ID",freight_mode_id);
        cv.put("VALUE",value);
        cv.put("SHIPPING_COST",shipping_cost);
        cv.put("SHIPPING_COST_LINK",shipping_cost_link);
        cv.put("REFUND_POLICY",refund_policy);
        cv.put("REFUND_POLICY_LINK",refund_policy_link);
        cv.put("LIFE_TRACKING",life_tracking);
        cv.put("LIFE_TRACKING_ID",life_tracking_id);
        cv.put("LIFE_TRACKING_INFO",life_tracking_info);
        cv.put("LICENSE",license);
        db.update("delivery_data",cv,"PAGE_ID = ?",new String[]{page_id});
        return true;
    }

    public Boolean delivery_coordinates_update(String email, String location,String latitude,String longitude){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",email);
        cv.put("DELIVERY_LOCATION",location);
        cv.put("DELIVERY_LONGITUDE",longitude);
        cv.put("DELIVERY_LATITUDE",latitude);
        db.update("account_info",cv,"EMAIL = ?",new String[]{email});
        return true;
    }

    public Long pages_insert(String page_name, String page_type, int ino, String industry, String headquarter,String website,byte[]image, byte[]bimage,String image_status,String bimage_status,int catno,String category,String headquarter_existence,String correct_headquarter,String main_company,String dcode,String main_company_id,String date_created){
        ContentValues cv = new ContentValues();
        cv.put("PAGE_NAME",page_name);
        cv.put("PAGE_TYPE",page_type);
        cv.put("INO",ino);
        cv.put("INDUSTRY",industry);
        cv.put("HEADQUARTER",headquarter);
        cv.put("CORRECT_HEADQUARTER",correct_headquarter);
        cv.put("WEBSITE",website);
        cv.put("IMAGE",image);
        cv.put("BIMAGE",bimage);
        cv.put("COUNTRY","");
        cv.put("CATEGORY",category);
        cv.put("CATNO",catno);
        cv.put("IMAGE_STATUS",image_status);
        cv.put("BIMAGE_STATUS",bimage_status);
        cv.put("LOCATION","");
        cv.put("CORRECT_LOCATION","");
        cv.put("PROFILE_MAIL","");
        cv.put("RATINGS",0.0);
        cv.put("PHONE","");
        cv.put("ABOUT","");
        cv.put("WHAT","");
        cv.put("VISION","");
        cv.put("CORE","");
        cv.put("INFO","");
        cv.put("FOUNDED","");
        cv.put("LOCATION_SWITCH","OFF");
        cv.put("LOCATION_EXISTENCE","");
        cv.put("HEADQUARTER_EXISTENCE",headquarter_existence);
        cv.put("CNO",0);
        cv.put("DELIVERY_SERVICE","");
        cv.put("DELIVERY_SERVICE_ID","");
        cv.put("RANKABLE","NO");
        cv.put("TOTAL_DELIVERIES",0.0);
        cv.put("SUCCESSFUL_DELIVERIES",0.0);
        cv.put("FAILED_DELIVERIES",0.0);
        cv.put("DELIVERY_PERCENTAGE",0.0);
        cv.put("MAIN_COMPANY",main_company);
        cv.put("MAIN_COMPANY_ID",main_company_id);
        cv.put("DCODE",dcode);
        if(page_type.equals("Delivery Service")){
            cv.put("VERIFIED","");
        }
        else{
            cv.put("VERIFIED","verified");
        }
        cv.put("DATE_CREATED",date_created);
        cv.put("OFFERS_DELIVERY","NO");
        Long check = db.insert("pages",null,cv);
        return check;
    }

    public Boolean account_verified(String verified,String email){
        ContentValues cv = new ContentValues();
        cv.put("VERIFIED",verified);
        db.update("account_info",cv,"EMAIL = ?",new String[]{email});
        return true;
    }

    public Boolean page_verified(String verified,int page_id){
        ContentValues cv = new ContentValues();
        cv.put("VERIFIED",verified);
        db.update("pages",cv,"PAGE_ID = ?",new String[]{Integer.toString(page_id)});
        return true;
    }

    public Boolean deliverer_status_update(String status,String email){
        ContentValues cv = new ContentValues();
        cv.put("DELIVERER",status);
        db.update("account_info",cv,"EMAIL = ?",new String[]{email});
        return true;
    }

    public Boolean update_dcode(String dcode,int page_id){
        ContentValues cv = new ContentValues();
        cv.put("DCODE",dcode);
        db.update("pages",cv,"PAGE_ID = ?",new String[]{Integer.toString(page_id)});
        return true;
    }

    public Long orgschool_insert(String page_name,String industry,Double review, byte[]image,String category,String correct_location,int page_id){
        ContentValues cv = new ContentValues();
        cv.put("PAGE_NAME",page_name);
        cv.put("INDUSTRY",industry);
        cv.put("IMAGE",image);
        cv.put("CATEGORY",category);
        cv.put("CORRECT_LOCATION",correct_location);
        cv.put("RATINGS",review);
        cv.put("PAGE_ID",page_id);
        Long check = db.insert("organized_school",null,cv);
        return check;
    }

    public Long orgcompany_insert(String page_name,String industry,Double review, byte[]image,String category,String correct_location,int page_id){
        ContentValues cv = new ContentValues();
        cv.put("PAGE_NAME",page_name);
        cv.put("INDUSTRY",industry);
        cv.put("IMAGE",image);
        cv.put("CATEGORY",category);
        cv.put("CORRECT_LOCATION",correct_location);
        cv.put("RATINGS",review);
        cv.put("PAGE_ID",page_id);
        Long check = db.insert("organized_company",null,cv);
        return check;
    }

    public Long orgtopdel_insert(String page_name,String email,String industry,Double review, byte[]image,String category,String correct_location,int page_id){
        ContentValues cv = new ContentValues();
        cv.put("PAGE_NAME",page_name);
        cv.put("EMAIL",email);
        cv.put("INDUSTRY",industry);
        cv.put("IMAGE",image);
        cv.put("CATEGORY",category);
        cv.put("CORRECT_LOCATION",correct_location);
        cv.put("RATINGS",review);
        cv.put("PAGE_ID",page_id);
        Long check = db.insert("organized_top_deliverers",null,cv);
        return check;
    }

    public Long your_page_insert(String email,String page_name,String page_id){
        ContentValues cv = new ContentValues();
        cv.put("PAGE_NAME",page_name);
        cv.put("EMAIL",email);
        cv.put("PAGE_ID",page_id);
        Long check = db.insert("your_page",null,cv);
        return check;
    }

    public Boolean pages_rankable_update(int page_id,String rankable){
        ContentValues cv = new ContentValues();
        cv.put("RANKABLE",rankable);
        db.update("pages",cv,"PAGE_ID = ?",new String[]{Integer.toString(page_id)});
        return true;
    }

    public Boolean account_rankable_update(String email,String rankable){
        ContentValues cv = new ContentValues();
        cv.put("RANKABLE",rankable);
        db.update("account_info",cv,"EMAIL = ?",new String[]{email});
        return true;
    }

    public Cursor school_intable(String email,String page_id){
        Cursor see = db.rawQuery("select * from education_tab where EMAIL = '"+email+"' and SCHOOL_ID = '"+page_id+"'",null);
        return see;
    }

    public Cursor dcode_check(String dcode){
        Cursor see = db.rawQuery("select * from pages where DCODE = '"+dcode+"'",null);
        return see;
    }

    public Cursor pages_check_deliver_service(String delivery_service,String delivery_service_id){
        Cursor see = db.rawQuery("select * from pages where DELIVERY_SERVICE = '"+delivery_service+"' and DELIVERY_SERVICE_ID = '"+delivery_service_id+"'",null);
        return see;
    }

    public Cursor ter_school_intable(String email,String page_id){
        Cursor see = db.rawQuery("select * from tertiary_education where EMAIL = '"+email+"' and SCHOOL_ID = '"+page_id+"'",null);
        return see;
    }

    public Cursor company_intable(String email,String page_id){
        Cursor see = db.rawQuery("select * from work where EMAIL = '"+email+"' and WORKED_AT_ID = '"+page_id+"'",null);
        return see;
    }

    public Long page_admins_insert(String admin, String page_name, String page_type,String page_id){
        ContentValues cv = new ContentValues();
        cv.put("ADMIN",admin);
        cv.put("PAGE_NAME",page_name);
        cv.put("PAGE_TYPE",page_type);
        cv.put("PASSWORD","");
        cv.put("PAGE_ID",page_id);
        Long check = db.insert("page_admins",null,cv);
        return check;
    }

   /* public Long correct_schloc_insert(String page_name,String page_type,String correct_location){
        ContentValues cv = new ContentValues();
        cv.put("PAGE_NAME",page_name);
        cv.put("PAGE_TYPE",page_type);
        cv.put("CORRECT_LOCATION",correct_location);
        Long check = db.insert("pages",null,cv);
        return check;
    }*/

    public Long page_associates_insert(String email, String page_id){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",email);
        cv.put("PAGE_ID",page_id);
        Long check = db.insert("page_associates",null,cv);
        return check;
    }

    public int page_delete(int page_id){
        int del =  db.delete("pages","PAGE_ID = ?",new String[]{Integer.toString(page_id)});
        return del;
    }

    public int verification_delete(String page_id){
        int del =  db.delete("verification","PAGE_ID = ?",new String[]{page_id});
        return del;
    }

    public int page_admin_delete(String page_id){
        int del =  db.delete("page_admins","PAGE_ID = ?",new String[]{page_id});
        return del;
    }

    public int edu_page_delete(String page_id){
        int del =  db.delete("education_tab","SCHOOL_ID = ?",new String[]{page_id});
        return del;
    }

    public int ter_edu_page_delete(String page_id){
        int del =  db.delete("tertiary_education","SCHOOL_ID = ?",new String[]{page_id});
        return del;
    }

    public int your_page_page_id_delete(String page_id){
        int del =  db.delete("your_page","PAGE_ID = ?",new String[]{page_id});
        return del;
    }

    public int page_associates_delete(String email,String page_id){
        int del =  db.delete("page_associates","PAGE_ID = ? and EMAIL = ?",new String[]{page_id,email});
        return del;
    }


    public int page_delete_admin(String admin,String page_id){
        int del =  db.delete("page_admins","ADMIN = ? and PAGE_ID = ?",new String[]{admin,page_id});
        return del;
    }
///////////////////////////






    //////////////////
    public Cursor page_review_num(String page_type){
        Cursor see = db.rawQuery("select PAGE_ID, COUNT(*) from page_review where PAGE_TYPE = '"+page_type+"' GROUP BY PAGE_ID HAVING COUNT(*) > 0",null);
        return see;
    }

    public Cursor delivery_review_num(String type){
        Cursor see = db.rawQuery("select DELIVERER_EMAIL, COUNT(*) from delivery_review where TYPE = '"+type+"' GROUP BY DELIVERER_EMAIL HAVING COUNT(*) > 0",null);
        return see;
    }

    public Cursor brand_register(){
        Cursor see = db.rawQuery("select REGISTERED_AT, COUNT(*) from brand GROUP BY REGISTERED_AT HAVING COUNT(*) > 0",null);
        return see;
    }



    public Cursor pagename_review_num(int page_id){
        Cursor see = db.rawQuery("select * from page_review where PAGE_ID = '"+page_id+"'",null);
        return see;
    }

    public Cursor page_rankable_check(String rankable,Double ratings){
        Cursor see = db.rawQuery("select * from pages where RANKABLE = '"+rankable+"' and RATINGS = '"+ratings+"'",null);
        return see;
    }

    public Cursor your_page_check(String email){
        Cursor see = db.rawQuery("select * from your_page where EMAIL = '"+email+"'",null);
        return see;
    }

    public Cursor your_page_check2(String email,String page_id){
        Cursor see = db.rawQuery("select * from your_page where EMAIL = '"+email+"' and PAGE_ID = '"+page_id+"'",null);
        return see;
    }

    public Cursor page_rankable_percent_check(String rankable,Double percent){
        Cursor see = db.rawQuery("select * from pages where RANKABLE = '"+rankable+"' and DELIVERY_PERCENTAGE = '"+percent+"'",null);
        return see;
    }

    public Cursor account_rankable_percent_check(String rankable,Double percent){
        Cursor see = db.rawQuery("select * from account_info where RANKABLE = '"+rankable+"' and DELIVERY_PERCENTAGE = '"+percent+"'",null);
        return see;
    }

    public Cursor pages_review_num(int page_id){
        Cursor see = db.rawQuery("select * from pages where PAGE_ID = '"+page_id+"'",null);
        return see;
    }

    public Cursor page_reviewer_num(String reviewer_nick, int page_id){
        Cursor see = db.rawQuery("select * from page_review where REVIEWER_NICKNAME = '"+reviewer_nick+"' and PAGE_ID = '"+page_id+"'",null);
        return see;
    }

    public Cursor page_reviewers(){
        Cursor see = db.rawQuery("select REVIEWER_NICKNAME from page_review",null);
        return see;
    }

    public Cursor page_review_total(int page_id,String page_type){
        Cursor see = db.rawQuery("select * from page_review where PAGE_ID = '"+page_id+"' and PAGE_TYPE = '"+page_type+"'",null);
        return see;
    }

    public Cursor delivery_reviewer_num(String reviewer_nick, String email){
        Cursor see = db.rawQuery("select * from delivery_review where REVIEWER_NICKNAME = '"+reviewer_nick+"' and DELIVERER_EMAIL = '"+email+"'",null);
        return see;
    }

    public Cursor delivery_reviewer_numm(String email){
        Cursor see = db.rawQuery("select * from delivery_review where DELIVERER_EMAIL = '"+email+"'",null);
        return see;
    }

    public Cursor delivery_reviewer_numm2(String email,String type){
        Cursor see = db.rawQuery("select * from delivery_review where DELIVERER_EMAIL = '"+email+"' and TYPE = '"+type+"'",null);
        return see;
    }

    public Cursor tech_suggestion_request(){
        Cursor see = db.rawQuery("select SKILL, COUNT(*) from tech_skills GROUP BY SKILL HAVING COUNT(*) > 3",null);
        return see;
    }

    public Cursor per_suggestion_request(){
        Cursor see = db.rawQuery("select SKILL, COUNT(*) from personal_skills GROUP BY SKILL HAVING COUNT(*) > 3",null);
        return see;
    }

    public Cursor int_suggestion_request(){
        Cursor see = db.rawQuery("select INTEREST, COUNT(*) from interests GROUP BY INTEREST HAVING COUNT(*) > 3",null);
        return see;
    }

    public Cursor course_suggestion_request(){
        Cursor see = db.rawQuery("select COURSE_NAME, COUNT(*) from tertiary_education GROUP BY COURSE_NAME HAVING COUNT(*) > 3",null);
        return see;
    }

    public Cursor degree_suggestion_request(){
        Cursor see = db.rawQuery("select DEGREE_NAME, COUNT(*) from tertiary_education GROUP BY DEGREE_NAME HAVING COUNT(*) > 3",null);
        return see;
    }

    public Cursor cert_suggestion_request(){
        Cursor see = db.rawQuery("select CERTIFICATE_NAME, COUNT(*) from tech_cert GROUP BY CERTIFICATE_NAME HAVING COUNT(*) > 3",null);
        return see;
    }

    public Cursor job_title_suggestion_request(){
        Cursor see = db.rawQuery("select TITLE, COUNT(*) from job_post GROUP BY TITLE HAVING COUNT(*) > 0",null);
        return see;
    }

    public Cursor worked_as_suggestion_request(){
        Cursor see = db.rawQuery("select WORKED_AS, COUNT(*) from work GROUP BY WORKED_AS HAVING COUNT(*) > 3",null);
        return see;
    }

    public Cursor voluntary_suggestion_request(){
        Cursor see = db.rawQuery("select ACTIVITY, COUNT(*) from volunteer GROUP BY ACTIVITY HAVING COUNT(*) > 3",null);
        return see;
    }

    public Cursor organization_suggestion_request(){
        Cursor see = db.rawQuery("select CERTIFICATE_BODY, COUNT(*) from tech_cert GROUP BY CERTIFICATE_BODY HAVING COUNT(*) > 3",null);
        return see;
    }

    public Cursor extra_suggestion_request(){
        Cursor see = db.rawQuery("select ACTIVITY, COUNT(*) from extra GROUP BY ACTIVITY HAVING COUNT(*) > 3",null);
        return see;
    }

    public Cursor all_locations_request(){
        Cursor see = db.rawQuery("select * from all_locations",null);
        return see;
    }

    public Cursor all_locations_check(String location){
        Cursor see = db.rawQuery("select * from all_locations where LOCATION = '"+location+"'",null);
        return see;
    }

    public Cursor all_industries_request(){
        Cursor see = db.rawQuery("select * from all_industries",null);
        return see;
    }

    public Cursor all_industries_check(String industry){
        Cursor see = db.rawQuery("select * from all_industries where INDUSTRY = '"+industry+"'",null);
        return see;
    }

    public Cursor all_languages_request(){
        Cursor see = db.rawQuery("select * from all_languages",null);
        return see;
    }

    public Cursor all_languages_check(String language){
        Cursor see = db.rawQuery("select * from all_languages where LANGUAGE = '"+language+"'",null);
        return see;
    }

    public Cursor page_associates_request(String email,String page_id){
        Cursor see = db.rawQuery("select * from page_associates where EMAIL = '"+email+"' and PAGE_ID = '"+page_id+"'",null);
        return see;
    }

    public Cursor page_associates_request_page_id(String page_id){
        Cursor see = db.rawQuery("select * from page_associates where PAGE_ID = '"+page_id+"'",null);
        return see;
    }

    public Cursor nickname_request(String email){
        Cursor see = db.rawQuery("select NICK_NAME from account_info where EMAIL = '"+email+"'",null);
        return see;
    }

    public Cursor nickname_email_request(String nick_name){
        Cursor see = db.rawQuery("select EMAIL from account_info where NICK_NAME = '"+nick_name+"'",null);
        return see;
    }

    public Cursor page_followers_request(String page_id){
        Cursor see = db.rawQuery("select * from followers where FOLLOWING_PAGE_ID = '"+page_id+"'",null);
        return see;
    }

    public Cursor followers_request(String account){
        Cursor see = db.rawQuery("select * from followers where ACCOUNT = '"+account+"'",null);
        return see;
    }

    public Cursor followers_request2(String account){
        Cursor see = db.rawQuery("select * from followers where FOLLOWER_DINKY = '"+account+"' or ACCOUNT = '"+account+"'",null);
        return see;
    }

    public Cursor following_request(String account,String user){
        Cursor see = db.rawQuery("select * from followers where FOLLOWER_DINKY = '"+user+"' and ACCOUNT = '"+account+"'",null);
        return see;
    }


    public Long follow_insert(String account,String camo, String dinky, String page_id){
        ContentValues cv = new ContentValues();
        cv.put("ACCOUNT",account);
        cv.put("FOLLOWING_CAMO",camo);
        cv.put("FOLLOWER_DINKY",dinky);
        cv.put("FOLLOWING_PAGE_ID",page_id);
        Long check = db.insert("followers",null,cv);
        return check;
    }

    public Cursor company_associates_email(String page_name){
        Cursor see = db.rawQuery("select EMAIL from work where WORKED_AT = '"+page_name+"'",null);
        return see;
    }

    public Cursor company_check_associates_(String email, String page_name){
        Cursor see = db.rawQuery("select * from work where WORKED_AT = '"+page_name+"' and EMAIL = '"+email+"'",null);
        return see;
    }

    public Cursor sec_school_associates_email(String page_name){
        Cursor see = db.rawQuery("select EMAIL from education_tab where SCHOOL_NAME = '"+page_name+"'",null);
        return see;
    }

    public Cursor sec_check_associates_(String email, String page_name){
        Cursor see = db.rawQuery("select * from education_tab where SCHOOL_NAME = '"+page_name+"' and EMAIL = '"+email+"'",null);
        return see;
    }

    public Cursor ter_school_associates_email(String page_name){
        Cursor see = db.rawQuery("select EMAIL from tertiary_education where SCHOOL_NAME = '"+page_name+"'",null);
        return see;
    }

    public Cursor ter_check_associates_(String email, String page_name){
        Cursor see = db.rawQuery("select * from tertiary_education where SCHOOL_NAME = '"+page_name+"' and EMAIL = '"+email+"'",null);
        return see;
    }

    public Cursor company_suggestion_request(){
        Cursor see = db.rawQuery("select * from pages where PAGE_TYPE = 'Company'",null);
        return see;
    }

    public Cursor secondary_suggestion_request(){
        Cursor see = db.rawQuery("select * from pages where CATEGORY = 'Secondary'",null);
        return see;
    }

    public Cursor tertiary_suggestion_request(){
        Cursor see = db.rawQuery("select * from pages where CATEGORY = 'Tertiary'",null);
        return see;
    }
///////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////
    //////////////////////////////////////////////////
    public Cursor pages_name_request(int id){
        Cursor see = db.rawQuery("select * from pages where PAGE_ID = '"+id+"'",null);
        return see;
    }

    public Long insert(String first_name, String last_name, String email, String password,String bio, String dob, String gender, String country, String phone,byte[]image, int cno, byte[]bimage,String image_status,String bimage_status, int gno,String date_created){
        ContentValues cv = new ContentValues();
        cv.put("FIRST_NAME",first_name);
        cv.put("LAST_NAME",last_name);
        cv.put("EMAIL",email);
        cv.put("PASSWORD",password);
        cv.put("BIO",bio);
        cv.put("DOB",dob);
        cv.put("GENDER",gender);
        cv.put("COUNTRY",country);
        cv.put("PHONE",phone);
        cv.put("LOCATION","");
        cv.put("CORRECT_LOCATION","");
        cv.put("PROFILE_MAIL","");
        cv.put("WEBSITE","");
        cv.put("LOCATION_SWITCH","OFF");
        cv.put("EMAIL_VISIBILITY","");
        cv.put("LOCATION_EXISTENCE","");
        cv.put("NICK_NAME","");
        cv.put("IMAGE",image);
        cv.put("RATINGS",0.0);
        cv.put("CARD_STATE",1);
        cv.put("CARD_NUMBER",0.0);
        cv.put("CNO",cno);
        cv.put("BIMAGE",bimage);
        cv.put("IMAGE_STATUS",image_status);
        cv.put("BIMAGE_STATUS",bimage_status);
        cv.put("GNO",gno);
        cv.put("DELIVERER","NO");
        cv.put("SELLER","NO");
        cv.put("RANKABLE","NO");
        cv.put("TOTAL_DELIVERIES",0.0);
        cv.put("SUCCESSFUL_DELIVERIES",0.0);
        cv.put("FAILED_DELIVERIES",0.0);
        cv.put("DELIVERY_PERCENTAGE",0.0);
        cv.put("CURRENT_LONGITUDE","");
        cv.put("CURRENT_LATITUDE","");
        cv.put("VERIFIED","");
        cv.put("PAGE","");
        cv.put("PAGE_ID","");
        cv.put("DELIVERY_LOCATION","");
        cv.put("DELIVERY_LONGITUDE","");
        cv.put("DELIVERY_LATITUDE","");
        cv.put("DATE_CREATED",date_created);
        cv.put("CONTACT_ACCESS","ON");
        Long check = db.insert("account_info",null,cv);
        return check;
    }

    public Long education_insert(String email, String password,String school_name,String start_month, int start_month_id,String start_year, int start_year_id,String end_month, int end_month_id,String end_year, int end_year_id,String school_id){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",email);
        cv.put("PASSWORD",password);
        cv.put("SCHOOL_NAME",school_name);
        cv.put("START_MONTH",start_month);
        cv.put("START_MONTH_ID",start_month_id);
        cv.put("START_YEAR",start_year);
        cv.put("START_YEAR_ID",start_year_id);
        cv.put("END_MONTH",end_month);
        cv.put("END_MONTH_ID",end_month_id);
        cv.put("END_YEAR",end_year);
        cv.put("END_YEAR_ID",end_year_id);
        cv.put("SCHOOL_ID",school_id);
        Long check = db.insert("education_tab",null,cv);
        return check;
    }

    public Long tertiary_education_insert(String email, String password,String school_name,String course_name,String degree_name,String start_month, int start_month_id,String start_year, int start_year_id,String end_month, int end_month_id,String end_year, int end_year_id,String school_id){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",email);
        cv.put("PASSWORD",password);
        cv.put("SCHOOL_NAME",school_name);
        cv.put("COURSE_NAME",course_name);
        cv.put("DEGREE_NAME",degree_name);
        cv.put("START_MONTH",start_month);
        cv.put("START_MONTH_ID",start_month_id);
        cv.put("START_YEAR",start_year);
        cv.put("START_YEAR_ID",start_year_id);
        cv.put("END_MONTH",end_month);
        cv.put("END_MONTH_ID",end_month_id);
        cv.put("END_YEAR",end_year);
        cv.put("END_YEAR_ID",end_year_id);
        cv.put("SCHOOL_ID",school_id);
        Long check = db.insert("tertiary_education",null,cv);
        return check;
    }


    public Long tech_cert_insert(String email, String password,String certificate_name,String certificate_body,String certificate_id,String certificate_url,String start_month, int start_month_id,String start_year, int start_year_id,String end_month, int end_month_id,String end_year, int end_year_id,String certificate_body_id){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",email);
        cv.put("PASSWORD",password);
        cv.put("CERTIFICATE_NAME",certificate_name);
        cv.put("CERTIFICATE_BODY",certificate_body);
        cv.put("CERTIFICATE_ID",certificate_id);
        cv.put("CERTIFICATE_URL",certificate_url);
        cv.put("START_MONTH",start_month);
        cv.put("START_MONTH_ID",start_month_id);
        cv.put("START_YEAR",start_year);
        cv.put("START_YEAR_ID",start_year_id);
        cv.put("END_MONTH",end_month);
        cv.put("END_MONTH_ID",end_month_id);
        cv.put("END_YEAR",end_year);
        cv.put("END_YEAR_ID",end_year_id);
        cv.put("CERTIFICATE_BODY_ID",certificate_body_id);
        Long check = db.insert("tech_cert",null,cv);
        return check;
    }

    public Long all_locations_insert(String location){
        ContentValues cv = new ContentValues();
        cv.put("LOCATION",location);
        Long check = db.insert("all_locations",null,cv);
        return check;
    }

    public Long all_industries_insert(String industry){
        ContentValues cv = new ContentValues();
        cv.put("INDUSTRY",industry);
        Long check = db.insert("all_industries",null,cv);
        return check;
    }

    public Long all_languages_insert(String language){
        ContentValues cv = new ContentValues();
        cv.put("LANGUAGE",language);
        Long check = db.insert("all_languages",null,cv);
        return check;
    }

    public Long state_insert(String email, String password,String state){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",email);
        cv.put("PASSWORD",password);
        cv.put("STATE",state);
        Long check = db.insert("state",null,cv);
        return check;
    }

    public Long company_filter_insert(String email, String password,String location,int lno,String industry, int ino){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",email);
        cv.put("PASSWORD",password);
        cv.put("INDUSTRY",industry);
        cv.put("INO",ino);
        cv.put("LOCATION",location);
        cv.put("LNO",lno);
        Long check = db.insert("company_filter",null,cv);
        return check;
    }

    public Long delivery_review_filter_insert(String email, String deliverer,String category, int cno){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",email);
        cv.put("DELIVERER",deliverer);
        cv.put("CATEGORY",category);
        cv.put("CNO",cno);
        Long check = db.insert("delivery_review_filter",null,cv);
        return check;
    }


    public Long post_settings_insert(String email,String like,int lno,String comment, int cno,String view, int vno){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",email);
        cv.put("LIKES",like);
        cv.put("COMMENTS",comment);
        cv.put("CNO",cno);
        cv.put("VIEWS",view);
        cv.put("VNO",vno);
        cv.put("LNO",lno);
        Long check = db.insert("post_settings",null,cv);
        return check;
    }

    public Long talents_filter_insert(String email, String password,String location,int lno,String industry, int ino){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",email);
        cv.put("PASSWORD",password);
        cv.put("INDUSTRY",industry);
        cv.put("INO",ino);
        cv.put("LOCATION",location);
        cv.put("LNO",lno);
        Long check = db.insert("talents_filter",null,cv);
        return check;
    }

    public Long popular_filter_insert(String email, String password,String location,int lno,String industry, int ino){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",email);
        cv.put("PASSWORD",password);
        cv.put("INDUSTRY",industry);
        cv.put("INO",ino);
        cv.put("LOCATION",location);
        cv.put("LNO",lno);
        Long check = db.insert("popular_filter",null,cv);
        return check;
    }

    public Long job_filter_insert(String email, String password,String location,int lno,String industry, int ino,String category, int cno){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",email);
        cv.put("PASSWORD",password);
        cv.put("INDUSTRY",industry);
        cv.put("INO",ino);
        cv.put("LOCATION",location);
        cv.put("LNO",lno);
        cv.put("CATEGORY",category);
        cv.put("CNO",cno);
        Long check = db.insert("job_filter",null,cv);
        return check;
    }

    public Long explore_filter_insert(String email, String password,String location,int lno,String industry, int ino){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",email);
        cv.put("PASSWORD",password);
        cv.put("INDUSTRY",industry);
        cv.put("INO",ino);
        cv.put("LOCATION",location);
        cv.put("LNO",lno);
        Long check = db.insert("explore_filter",null,cv);
        return check;
    }


    public Long top_deliverer_filter_insert(String email, String password,String location,int lno,String deliverer, int dno){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",email);
        cv.put("PASSWORD",password);
        cv.put("DELIVERER",deliverer);
        cv.put("DNO",dno);
        cv.put("LOCATION",location);
        cv.put("LNO",lno);
        Long check = db.insert("top_deliverer_filter",null,cv);
        return check;
    }

    public Long school_filter_insert(String email, String password,String location,int lno,String institution, int ino){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",email);
        cv.put("PASSWORD",password);
        cv.put("INSTITUTION",institution);
        cv.put("INO",ino);
        cv.put("LOCATION",location);
        cv.put("LNO",lno);
        Long check = db.insert("school_filter",null,cv);
        return check;
    }

    public Long profile_filter_insert(String email,String heading,int hno,String person){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",email);
        cv.put("PASSWORD","");
        cv.put("HEADING",heading);
        cv.put("HNO",hno);
        cv.put("PERSON",person);
        Long check = db.insert("profile_filter",null,cv);
        return check;
    }

    public Long pages_filter_insert(String email, String page_id,String heading,int hno){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",email);
        cv.put("PAGE_ID",page_id);
        cv.put("HEADING",heading);
        cv.put("HNO",hno);
        Long check = db.insert("pages_filter",null,cv);
        return check;
    }

    public Long deliverers_insert(String email, String page_id){
        ContentValues cv = new ContentValues();
        cv.put("DELIVERER",email);
        cv.put("PAGE_ID",page_id);
        cv.put("STATE","NO");
        Long check = db.insert("deliverers",null,cv);
        return check;
    }


    public Long brand_partner_temp_insert(String page_id,String company,String contributions,String company_id){
        ContentValues cv = new ContentValues();
        cv.put("COMPANY",company);
        cv.put("PAGE_ID",page_id);
        cv.put("CONTRIBUTIONS",contributions);
        cv.put("COMPANY_ID",company_id);
        Long check = db.insert("brand_partner_temp",null,cv);
        return check;
    }

    public Long brand_partner_insert(String page_id,String company,String contributions,String company_id,String brand_id){
        ContentValues cv = new ContentValues();
        cv.put("COMPANY",company);
        cv.put("PAGE_ID",page_id);
        cv.put("CONTRIBUTIONS",contributions);
        cv.put("COMPANY_ID",company_id);
        cv.put("BRAND_ID",brand_id);
        Long check = db.insert("brand_partner",null,cv);
        return check;
    }

    public Long brand_manufacturer_temp_insert(String page_id,String company,String country,String company_id){
        ContentValues cv = new ContentValues();
        cv.put("COMPANY",company);
        cv.put("PAGE_ID",page_id);
        cv.put("COUNTRY",country);
        cv.put("COMPANY_ID",company_id);
        Long check = db.insert("brand_manufacturer_temp",null,cv);
        return check;
    }


    public Long brand_manufacturer_insert(String page_id,String company,String country,String company_id,String brand_id){
        ContentValues cv = new ContentValues();
        cv.put("COMPANY",company);
        cv.put("PAGE_ID",page_id);
        cv.put("COUNTRY",country);
        cv.put("COMPANY_ID",company_id);
        cv.put("BRAND_ID",brand_id);
        Long check = db.insert("brand_manufacturer",null,cv);
        return check;
    }

    public Long brand_distributor_temp_insert(String page_id,String company,String country,String company_id){
        ContentValues cv = new ContentValues();
        cv.put("COMPANY",company);
        cv.put("PAGE_ID",page_id);
        cv.put("COUNTRY",country);
        cv.put("COMPANY_ID",company_id);
        Long check = db.insert("brand_distributor_temp",null,cv);
        return check;
    }

    public Long brand_distributor_insert(String page_id,String company,String country,String company_id,String brand_id){
        ContentValues cv = new ContentValues();
        cv.put("COMPANY",company);
        cv.put("PAGE_ID",page_id);
        cv.put("COUNTRY",country);
        cv.put("COMPANY_ID",company_id);
        cv.put("BRAND_ID",brand_id);
        Long check = db.insert("brand_distributor",null,cv);
        return check;
    }


    public Long work_insert(String email, String password,String worked_at,String worked_as,String location,String description,String start_month, int start_month_id,String start_year, int start_year_id,String end_month, int end_month_id,String end_year, int end_year_id,String location_existence,String correct_location,String worked_at_id){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",email);
        cv.put("PASSWORD",password);
        cv.put("WORKED_AT",worked_at);
        cv.put("WORKED_AS",worked_as);
        cv.put("LOCATION",location);
        cv.put("DESCRIPTION",description);
        cv.put("START_MONTH",start_month);
        cv.put("START_MONTH_ID",start_month_id);
        cv.put("START_YEAR",start_year);
        cv.put("START_YEAR_ID",start_year_id);
        cv.put("END_MONTH",end_month);
        cv.put("END_MONTH_ID",end_month_id);
        cv.put("LOCATION_EXISTENCE",location_existence);
        cv.put("CORRECT_LOCATION",correct_location);
        cv.put("END_YEAR",end_year);
        cv.put("END_YEAR_ID",end_year_id);
        cv.put("WORKED_AT_ID",worked_at_id);
        Long check = db.insert("work",null,cv);
        return check;
    }

    public Long volunteer_insert(String email, String password,String activity,String start_month, int start_month_id,String start_year, int start_year_id,String end_month, int end_month_id,String end_year, int end_year_id){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",email);
        cv.put("PASSWORD",password);
        cv.put("ACTIVITY",activity);
        cv.put("START_MONTH",start_month);
        cv.put("START_MONTH_ID",start_month_id);
        cv.put("START_YEAR",start_year);
        cv.put("START_YEAR_ID",start_year_id);
        cv.put("END_MONTH",end_month);
        cv.put("END_MONTH_ID",end_month_id);
        cv.put("END_YEAR",end_year);
        cv.put("END_YEAR_ID",end_year_id);
        Long check = db.insert("volunteer",null,cv);
        return check;
    }


    public Long tech_skills_insert(String email, String password,String skill,String capability,int capability_id){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",email);
        cv.put("PASSWORD",password);
        cv.put("SKILL",skill);
        cv.put("CAPABILITY",capability);
        cv.put("CAPABILITY_ID",capability_id);
        Long check = db.insert("tech_skills",null,cv);
        return check;
    }

    public Long language_insert(String email, String password,String language_name,int language_id,String proficiency,int proficiency_id){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",email);
        cv.put("PASSWORD",password);
        cv.put("LANGUAGE_NAME",language_name);
        cv.put("LANGUAGE_ID",language_id);
        cv.put("PROFICIENCY",proficiency);
        cv.put("PROFICIENCY_ID",proficiency_id);
        Long check = db.insert("language",null,cv);
        return check;
    }


    public Long extra_insert(String email, String password,String activity,String start_month, int start_month_id,String start_year, int start_year_id,String end_month, int end_month_id,String end_year, int end_year_id){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",email);
        cv.put("PASSWORD",password);
        cv.put("ACTIVITY",activity);
        cv.put("START_MONTH",start_month);
        cv.put("START_MONTH_ID",start_month_id);
        cv.put("START_YEAR",start_year);
        cv.put("START_YEAR_ID",start_year_id);
        cv.put("END_MONTH",end_month);
        cv.put("END_MONTH_ID",end_month_id);
        cv.put("END_YEAR",end_year);
        cv.put("END_YEAR_ID",end_year_id);
        Long check = db.insert("extra",null,cv);
        return check;
    }


    public Long personal_skills_insert(String email, String password,String skill,String capability,int capability_id){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",email);
        cv.put("PASSWORD",password);
        cv.put("SKILL",skill);
        cv.put("CAPABILITY",capability);
        cv.put("CAPABILITY_ID",capability_id);
        Long check = db.insert("personal_skills",null,cv);
        return check;
    }


    public Long interests_insert(String email, String password,String interest,String interest_level,int interest_id){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",email);
        cv.put("PASSWORD",password);
        cv.put("INTEREST",interest);
        cv.put("INTEREST_LEVEL",interest_level);
        cv.put("INTEREST_ID",interest_id);
        Long check = db.insert("interests",null,cv);
        return check;
    }

    public Long page_review_insert(String reviewer_nickname, String page_name, String page_type,Double ratings,String pros,String cons,String count,int page_id,String time,String date){
        ContentValues cv = new ContentValues();
        cv.put("REVIEWER_NICKNAME",reviewer_nickname);
        cv.put("PAGE_NAME",page_name);
        cv.put("PAGE_TYPE",page_type);
        cv.put("RATINGS",ratings);
        cv.put("PROS",pros);
        cv.put("CONS",cons);
        cv.put("COUNT",count);
        cv.put("PAGE_ID",page_id);
        cv.put("TIME",time);
        cv.put("DATE",date);
        cv.put("COMMENT","");
        cv.put("COMMENT_TIME","");
        cv.put("COMMENT_DATE","");
        Long check = db.insert("page_review",null,cv);
        return check;
    }

    public int page_review_delete(String nick_name,int page_id){
        int del =  db.delete("page_review","REVIEWER_NICKNAME = ? and PAGE_ID = ?",new String[]{nick_name,Integer.toString(page_id)});
        return del;
    }

    public Cursor page_review_ratings_request(int page_id){
        Cursor see = db.rawQuery("select RATINGS from page_review where PAGE_ID = '"+page_id+"'",null);
        return see;
    }

    public Cursor delivery_review_ratings_request(String email){
        Cursor see = db.rawQuery("select RATINGS from delivery_review where DELIVERER_EMAIL = '"+email+"'",null);
        return see;
    }

    public Boolean page_review_update(int page_id,Double ratings){
        ContentValues cv = new ContentValues();
        cv.put("RATINGS",ratings);
        db.update("pages",cv,"PAGE_ID = ? ",new String[]{Integer.toString(page_id)});
        return true;
    }

    public Boolean page_review_percent_update(int page_id,Double percent){
        ContentValues cv = new ContentValues();
        cv.put("DELIVERY_PERCENTAGE",percent);
        db.update("pages",cv,"PAGE_ID = ? ",new String[]{Integer.toString(page_id)});
        return true;
    }

    public Boolean page_review_update_review(String reviewer_nickname, String page_name, String page_type,Double ratings,String pros,String cons,String count,int page_id,String time,String date){
        ContentValues cv = new ContentValues();
        cv.put("REVIEWER_NICKNAME",reviewer_nickname);
        cv.put("PAGE_NAME",page_name);
        cv.put("PAGE_TYPE",page_type);
        cv.put("RATINGS",ratings);
        cv.put("PROS",pros);
        cv.put("CONS",cons);
        cv.put("COUNT",count);
        cv.put("TIME",time);
        cv.put("DATE",date);
        cv.put("PAGE_ID",page_id);
        db.update("page_review",cv,"PAGE_ID = ? and REVIEWER_NICKNAME = ?",new String[]{Integer.toString(page_id),reviewer_nickname});
        return true;
    }



    public int page_review_delete_review(String nickname,int page_id){
        int del =  db.delete("page_review","PAGE_ID = ? and REVIEWER_NICKNAME = ?",new String[]{Integer.toString(page_id),nickname});
        return del;
    }

    public Cursor page_review_request(String nickname,int page_id){
        Cursor see = db.rawQuery("select * from page_review where REVIEWER_NICKNAME = '"+nickname+"' and PAGE_ID = '"+page_id+"'",null);
        return see;
    }

    public int delivery_review_delete_review(String nickname,String email){
        int del =  db.delete("delivery_review","DELIVERER_EMAIL = ? and REVIEWER_NICKNAME = ?",new String[]{email,nickname});
        return del;
    }

    public Cursor delivery_review_request(String nickname,String email){
        Cursor see = db.rawQuery("select * from delivery_review where REVIEWER_NICKNAME = '"+nickname+"' and DELIVERER_EMAIL = '"+email+"'",null);
        return see;
    }
/*
    public Boolean delivery_review_update_review(String reviewer_nickname, String email,Double ratings,String pros,String cons,String count,String time,String date){
        ContentValues cv = new ContentValues();
        cv.put("REVIEWER_NICKNAME",reviewer_nickname);
        cv.put("DELIVERER_EMAIL",email);
        cv.put("RATINGS",ratings);
        cv.put("PROS",pros);
        cv.put("CONS",cons);
        cv.put("COUNT",count);
        cv.put("TIME",time);
        cv.put("DATE",date);
        db.update("delivery_review",cv,"DELIVERER_EMAIL = ? and REVIEWER_NICKNAME = ?",new String[]{email,reviewer_nickname});
        return true;
    }
*/
    public Long delivery_review_insert(String reviewer_nickname, String deliverer_email,Double ratings,String pros,String cons,String count,String time,String date,String type){
        ContentValues cv = new ContentValues();
        cv.put("REVIEWER_NICKNAME",reviewer_nickname);
        cv.put("DELIVERER_EMAIL",deliverer_email);
        cv.put("RATINGS",ratings);
        cv.put("PROS",pros);
        cv.put("CONS",cons);
        cv.put("COUNT",count);
        cv.put("COMMENT","");
        cv.put("TIME",time);
        cv.put("DATE",date);
        cv.put("COMMENT_TIME","");
        cv.put("COMMENT_DATE","");
        cv.put("TYPE",type);
        Long check = db.insert("delivery_review",null,cv);
        return check;
    }

    public Cursor delivery_review_request(String deliverer_email){
        Cursor see = db.rawQuery("select * from delivery_review where DELIVERER_EMAIL = '"+deliverer_email+"'",null);
        return see;
    }

    public Boolean delivery_review_update(String email,Double review){
        ContentValues cv = new ContentValues();
        cv.put("RATINGS",review);
        db.update("account_info",cv,"EMAIL = ? ",new String[]{email});
        return true;
    }

    public Boolean delivery_review_comment_update(String comment,String nick_name,String email,String comment_time,String comment_date){
        ContentValues cv = new ContentValues();
        cv.put("COMMENT",comment);
        cv.put("COMMENT_TIME",comment_time);
        cv.put("COMMENT_DATE",comment_date);
        db.update("delivery_review",cv,"REVIEWER_NICKNAME = ? and DELIVERER_EMAIL = ?",new String[]{nick_name,email});
        return true;
    }

    public Boolean page_review_comment_update(String comment,String nick_name,int page_id,String comment_time,String comment_date){
        ContentValues cv = new ContentValues();
        cv.put("COMMENT",comment);
        cv.put("COMMENT_TIME",comment_time);
        cv.put("COMMENT_DATE",comment_date);
        db.update("page_review",cv,"REVIEWER_NICKNAME = ? and PAGE_ID = ?",new String[]{nick_name,Integer.toString(page_id)});
        return true;
    }

    public Boolean delivery_percentage_update(String email,Double review){
        ContentValues cv = new ContentValues();
        cv.put("DELIVERY_PERCENTAGE",review);
        db.update("account_info",cv,"EMAIL = ? ",new String[]{email});
        return true;
    }

    public Boolean update_delivery_service(int page_id,String delivery_service,String delivery_service_id){
        ContentValues cv = new ContentValues();
        cv.put("DELIVERY_SERVICE",delivery_service);
        cv.put("DELIVERY_SERVICE_ID",delivery_service_id);
        db.update("pages",cv,"PAGE_ID = ? ",new String[]{Integer.toString(page_id)});
        return true;
    }

    public Boolean clear_delivery_service(String delivery_service_id){
        ContentValues cv = new ContentValues();
        cv.put("DELIVERY_SERVICE","");
        cv.put("DELIVERY_SERVICE_ID","");
        db.update("pages",cv,"DELIVERY_SERVICE_ID = ? ",new String[]{delivery_service_id});
        return true;
    }

    public Boolean update_main_company(int page_id,String main_company,String main_company_id){
        ContentValues cv = new ContentValues();
        cv.put("MAIN_COMPANY",main_company);
        cv.put("MAIN_COMPANY_ID",main_company_id);
        db.update("pages",cv,"PAGE_ID = ? ",new String[]{Integer.toString(page_id)});
        return true;
    }

    public Boolean clear_main_company(String main_company_id){
        ContentValues cv = new ContentValues();
        cv.put("MAIN_COMPANY","");
        cv.put("MAIN_COMPANY_ID","");
        db.update("pages",cv,"MAIN_COMPANY_ID = ? ",new String[]{main_company_id});
        return true;
    }

    public Cursor main_company_requestid(String admin,String page_name,String page_type){
        Cursor see = db.rawQuery("select * from page_admins where ADMIN = '"+admin+"' and PAGE_NAME = '"+page_name+"' and PAGE_TYPE = '"+page_type+"'",null);
        return see;
    }

    public Cursor delivery_service_requestid(String admin,String page_name,String page_type){
        Cursor see = db.rawQuery("select * from page_admins where ADMIN = '"+admin+"' and PAGE_NAME = '"+page_name+"' and PAGE_TYPE = '"+page_type+"'",null);
        return see;
    }

    public Long industries_insert(String email, String password,String industry_name,int industry_id,String involvement,int involvement_id){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",email);
        cv.put("PASSWORD",password);
        cv.put("INDUSTRY_NAME",industry_name);
        cv.put("INDUSTRY_ID",industry_id);
        cv.put("INVOLVEMENT",involvement);
        cv.put("INVOLVEMENT_ID",involvement_id);
        Long check = db.insert("industries",null,cv);
        return check;
    }
    /** itsdygsymgnjfnjgnkfgkfmkfmkmfk**/

    public Cursor education_request(String EMAIL, String PASSWORD){
        Cursor see = db.rawQuery("select * from education_tab where EMAIL = '"+EMAIL+"' and PASSWORD = '"+PASSWORD+"'",null);
        return see;
    }

    public Cursor tech_cert_request(String EMAIL, String PASSWORD){
        Cursor see = db.rawQuery("select * from tech_cert where EMAIL = '"+EMAIL+"' and PASSWORD = '"+PASSWORD+"'",null);
        return see;
    }

    public Cursor language_request(String EMAIL, String PASSWORD){
        Cursor see = db.rawQuery("select * from language where EMAIL = '"+EMAIL+"' and PASSWORD = '"+PASSWORD+"'",null);
        return see;
    }

    public Cursor all_emails(){
        Cursor see = db.rawQuery("select EMAIL from account_info",null);
        return see;
    }



    public Cursor work_request(String EMAIL, String PASSWORD){
        Cursor see = db.rawQuery("select * from work where EMAIL = '"+EMAIL+"' and PASSWORD = '"+PASSWORD+"'",null);
        return see;
    }

    public Cursor present_work_request(String EMAIL, String PASSWORD){
        Cursor see = db.rawQuery("select * from work where EMAIL = '"+EMAIL+"' and PASSWORD = '"+PASSWORD+"' and END_MONTH = 'Present' and END_YEAR = 'Present'",null);
        return see;
    }

    public Cursor present_work_request2(String EMAIL, String PAGE_ID){
        Cursor see = db.rawQuery("select * from work where EMAIL = '"+EMAIL+"' and WORKED_AT_ID = '"+PAGE_ID+"'",null);
        return see;
    }

    public Cursor present_sec_sch_request(String EMAIL, String PASSWORD){
        Cursor see = db.rawQuery("select * from education_tab where EMAIL = '"+EMAIL+"' and PASSWORD = '"+PASSWORD+"' and END_MONTH = 'Present' and END_YEAR = 'Present'",null);
        return see;
    }

    public Cursor present_sec_sch_request2(String EMAIL, String PAGE_ID){
        Cursor see = db.rawQuery("select * from education_tab where EMAIL = '"+EMAIL+"' and SCHOOL_ID = '"+PAGE_ID+"'",null);
        return see;
    }

    public Cursor present_ter_sch_request(String EMAIL, String PASSWORD){
        Cursor see = db.rawQuery("select * from tertiary_education where EMAIL = '"+EMAIL+"' and PASSWORD = '"+PASSWORD+"' and END_MONTH = 'Present' and END_YEAR = 'Present'",null);
        return see;
    }

    public Cursor present_ter_sch_request2(String EMAIL, String PAGE_ID){
        Cursor see = db.rawQuery("select * from tertiary_education where EMAIL = '"+EMAIL+"' and SCHOOL_ID = '"+PAGE_ID+"'",null);
        return see;
    }

    public Cursor nick_name_request(String nick_name){
        Cursor see = db.rawQuery("select * from account_info where NICK_NAME = '"+nick_name+"'",null);
        return see;
    }

    public Cursor volunteer_request(String EMAIL, String PASSWORD){
        Cursor see = db.rawQuery("select * from volunteer where EMAIL = '"+EMAIL+"' and PASSWORD = '"+PASSWORD+"'",null);
        return see;
    }

    public Cursor extra_request(String EMAIL, String PASSWORD){
        Cursor see = db.rawQuery("select * from extra where EMAIL = '"+EMAIL+"' and PASSWORD = '"+PASSWORD+"'",null);
        return see;
    }

    public Cursor state_request(String EMAIL, String PASSWORD){
        Cursor see = db.rawQuery("select * from state where EMAIL = '"+EMAIL+"' and PASSWORD = '"+PASSWORD+"'",null);
        return see;
    }

    public Cursor school_filter_request0(String EMAIL,String PASSWORD){
        Cursor see = db.rawQuery("select * from school_filter where EMAIL = '"+EMAIL+"' and PASSWORD = '"+PASSWORD+"'",null);
        return see;
    }

    public Cursor delivery_review_filter_request0(String EMAIL,String DELIVERER){
        Cursor see = db.rawQuery("select * from delivery_review_filter where EMAIL = '"+EMAIL+"' and DELIVERER = '"+DELIVERER+"'",null);
        return see;
    }

    public Cursor profile_filter_request0(String EMAIL,String PERSON){
        Cursor see = db.rawQuery("select * from profile_filter where EMAIL = '"+EMAIL+"' and PERSON = '"+PERSON+"'",null);
        return see;
    }

    public Cursor pages_filter_request0(String EMAIL,String PAGE_ID){
        Cursor see = db.rawQuery("select * from pages_filter where EMAIL = '"+EMAIL+"' and PAGE_ID = '"+PAGE_ID+"'",null);
        return see;
    }


    public Cursor orgschool_check(int page_id,Double ratings){
        Cursor see = db.rawQuery("select * from organized_school where PAGE_ID = '"+page_id+"' and RATINGS = '"+ratings+"'",null);
        return see;
    }

    public Cursor schoolpages_filter_location(String LOCATION){
        Cursor see = db.rawQuery("select * from organized_school where CORRECT_LOCATION = '"+LOCATION+"'",null);
        return see;
    }

    public Cursor schoolpages_filter_overall(){
        Cursor see = db.rawQuery("select * from organized_school",null);
        return see;
    }

    public Cursor top_deliverers_filter_location(String LOCATION){
        Cursor see = db.rawQuery("select * from organized_top_deliverers where CORRECT_LOCATION = '"+LOCATION+"'",null);
        return see;
    }

    public Cursor top_deliverers_filter_overall(){
        Cursor see = db.rawQuery("select * from organized_top_deliverers",null);
        return see;
    }

    public Cursor schoolpages_filter_institution(String institution){
        Cursor see = db.rawQuery("select * from organized_school where CATEGORY = '"+institution+"'",null);
        return see;
    }

    public Cursor schoolpages_filter_locandins(String LOCATION, String institution){
        Cursor see = db.rawQuery("select * from organized_school where CATEGORY = '"+institution+"' and CORRECT_LOCATION = '"+LOCATION+"'",null);
        return see;
    }

    public Cursor top_deliverers_filter_deliverer(String deliverer){
        Cursor see = db.rawQuery("select * from organized_top_deliverers where CATEGORY = '"+deliverer+"'",null);
        return see;
    }

    public Cursor top_deliverers_filter_email(String email){
        Cursor see = db.rawQuery("select * from organized_top_deliverers where EMAIL = '"+email+"'",null);
        return see;
    }

    public Cursor top_deliverers_filter_page_id(int page_id){
        Cursor see = db.rawQuery("select * from organized_top_deliverers where PAGE_ID = '"+page_id+"'",null);
        return see;
    }

    public Cursor top_deliverers_filter_locanddel(String LOCATION, String deliverer){
        Cursor see = db.rawQuery("select * from organized_top_deliverers where CATEGORY = '"+deliverer+"' and CORRECT_LOCATION = '"+LOCATION+"'",null);
        return see;
    }

    public Cursor company_filter_request0(String EMAIL,String PASSWORD){
        Cursor see = db.rawQuery("select * from company_filter where EMAIL = '"+EMAIL+"' and PASSWORD = '"+PASSWORD+"'",null);
        return see;
    }

    public Cursor popular_filter_request0(String EMAIL,String PASSWORD){
        Cursor see = db.rawQuery("select * from popular_filter where EMAIL = '"+EMAIL+"' and PASSWORD = '"+PASSWORD+"'",null);
        return see;
    }

    public Cursor job_filter_request0(String EMAIL,String PASSWORD){
        Cursor see = db.rawQuery("select * from job_filter where EMAIL = '"+EMAIL+"' and PASSWORD = '"+PASSWORD+"'",null);
        return see;
    }

    public Cursor explore_filter_request0(String EMAIL,String PASSWORD){
        Cursor see = db.rawQuery("select * from explore_filter where EMAIL = '"+EMAIL+"' and PASSWORD = '"+PASSWORD+"'",null);
        return see;
    }

    public Cursor talents_filter_request0(String EMAIL,String PASSWORD){
        Cursor see = db.rawQuery("select * from talents_filter where EMAIL = '"+EMAIL+"' and PASSWORD = '"+PASSWORD+"'",null);
        return see;
    }

    public Cursor top_deliverer_filter_request0(String EMAIL,String PASSWORD){
        Cursor see = db.rawQuery("select * from top_deliverer_filter where EMAIL = '"+EMAIL+"' and PASSWORD = '"+PASSWORD+"'",null);
        return see;
    }

    public Cursor orgcompany_check(int page_id,Double ratings){
        Cursor see = db.rawQuery("select * from organized_company where PAGE_ID = '"+page_id+"' and RATINGS = '"+ratings+"'",null);
        return see;
    }

    public Cursor orgtopdel_check(int page_id,String email,Double ratings){
        Cursor see = db.rawQuery("select * from organized_top_deliverers where PAGE_ID = '"+page_id+"' and EMAIL = '"+email+"' and RATINGS = '"+ratings+"'",null);
        return see;
    }

    public Cursor companypages_filter_location(String LOCATION){
        Cursor see = db.rawQuery("select * from organized_company where CORRECT_LOCATION = '"+LOCATION+"'",null);
        return see;
    }

    public Cursor companypages_filter_overall(){
        Cursor see = db.rawQuery("select * from organized_company",null);
        return see;
    }

    public Cursor companypages_filter_industry(String INDUSTRY){
        Cursor see = db.rawQuery("select * from organized_company where INDUSTRY = '"+INDUSTRY+"'",null);
        return see;
    }

    public Cursor companypages_filter_locandind(String LOCATION, String INDUSTRY){
        Cursor see = db.rawQuery("select * from organized_company where INDUSTRY = '"+INDUSTRY+"' and CORRECT_LOCATION = '"+LOCATION+"'",null);
        return see;
    }

    public Cursor tech_skills_request(String EMAIL, String PASSWORD){
        Cursor see = db.rawQuery("select * from tech_skills where EMAIL = '"+EMAIL+"' and PASSWORD = '"+PASSWORD+"'",null);
        return see;
    }

    public Cursor personal_skills_request(String EMAIL, String PASSWORD){
        Cursor see = db.rawQuery("select * from personal_skills where EMAIL = '"+EMAIL+"' and PASSWORD = '"+PASSWORD+"'",null);
        return see;
    }

    public Cursor interests_request(String EMAIL, String PASSWORD){
        Cursor see = db.rawQuery("select * from interests where EMAIL = '"+EMAIL+"' and PASSWORD = '"+PASSWORD+"'",null);
        return see;
    }

    public Cursor industries_request(String EMAIL, String INDUSTRY){
        Cursor see = db.rawQuery("select * from industries where EMAIL = '"+EMAIL+"' and INDUSTRY_NAME = '"+INDUSTRY+"'",null);
        return see;
    }

    public Cursor industries_request3(String EMAIL){
        Cursor see = db.rawQuery("select * from industries where EMAIL = '"+EMAIL+"'",null);
        return see;
    }

    public Cursor industries_request4(String EMAIL){
        String involve = "Very Involved";
        Cursor see = db.rawQuery("select * from industries where EMAIL = '"+EMAIL+"' and INVOLVEMENT = '"+involve+"'",null);
        return see;
    }

    public Cursor industries_requestt(String EMAIL, String PASSWORD){
        Cursor see = db.rawQuery("select * from industries where EMAIL = '"+EMAIL+"' and PASSWORD = '"+PASSWORD+"'",null);
        return see;
    }

    public Cursor industries_request2(String EMAIL, String INDUSTRY){
        Cursor see = db.rawQuery("select * from industries where EMAIL = '"+EMAIL+"' and INDUSTRY_NAME = '"+INDUSTRY+"'",null);
        return see;
    }

    public Cursor tertiary_education_request(String EMAIL, String PASSWORD){
        Cursor see = db.rawQuery("select * from tertiary_education where EMAIL = '"+EMAIL+"' and PASSWORD = '"+PASSWORD+"'",null);
        return see;
    }

    public Cursor request(String EMAIL, String PASSWORD){
        Cursor see = db.rawQuery("select * from account_info where EMAIL = '"+EMAIL+"' and PASSWORD = '"+PASSWORD+"'",null);
        return see;
    }

    public Cursor verification_request1(String DELIVERER){
        Cursor see = db.rawQuery("select * from verification where DELIVERER = '"+DELIVERER+"'",null);
        return see;
    }

    public Cursor verification_request2(String PAGE_ID){
        Cursor see = db.rawQuery("select * from verification where PAGE_ID = '"+PAGE_ID+"'",null);
        return see;
    }

    public Cursor request_suggest(){
        Cursor see = db.rawQuery("select * from account_info ",null);
        return see;
    }


    public Cursor request_password(String EMAIL){
        Cursor see = db.rawQuery("select PASSWORD from account_info where EMAIL = '"+EMAIL+"'",null);
        return see;
    }
    public Cursor request_image(String EMAIL,String PASSWORD){
        Cursor see = db.rawQuery("select IMAGE from account_info where EMAIL = '"+EMAIL+"' and PASSWORD = '"+PASSWORD+"'",null);
        return see;
    }

    public Cursor request_bimage(String EMAIL,String PASSWORD){
        Cursor see = db.rawQuery("select BIMAGE from account_info where EMAIL = '"+EMAIL+"' and PASSWORD = '"+PASSWORD+"'",null);
        return see;
    }
    public Cursor request_email(String EMAIL){
        Cursor see = db.rawQuery("select * from account_info where EMAIL = '"+EMAIL+"'",null);
        return see;
    }
    public Cursor request_review(Double RATINGS){
        Cursor see = db.rawQuery("select * from account_info where RATINGS = '"+RATINGS+"'",null);
        return see;
    }

    public Cursor request_percent_review(Double percent){
        Cursor see = db.rawQuery("select * from account_info where DELIVERY_PERCENTAGE = '"+percent+"'",null);
        return see;
    }

    public Cursor request_data(){
        Cursor see = db.rawQuery("select * from account_info",null);
        return see;
    }

    public Cursor pages_request_data(){
        Cursor see = db.rawQuery("select * from pages",null);
        return see;
    }

    public Cursor pages_request_admins(String email){
        Cursor see = db.rawQuery("select * from page_admins where ADMIN = '"+email+"'",null);
        return see;
    }

   public Cursor pages_request_name(int page_id){
        Cursor see = db.rawQuery("select * from pages where PAGE_ID = '"+page_id+"'",null);
        return see;
    }

    public Cursor sch_pages_request_namee(String page_name,String category){
        Cursor see = db.rawQuery("select * from pages where PAGE_NAME = '"+page_name+"' and CATEGORY = '"+category+"'",null);
        return see;
    }

    public Cursor pages_request_namee(String page_name){
        Cursor see = db.rawQuery("select * from pages where PAGE_NAME = '"+page_name+"'",null);
        return see;
    }

    public Cursor com_pages_request_namee(String page_name,String page_type){
        Cursor see = db.rawQuery("select * from pages where PAGE_NAME = '"+page_name+"' and PAGE_TYPE = '"+page_type+"'",null);
        return see;
    }

    public Cursor page_id_request(int page_id){
        Cursor see = db.rawQuery("select * from pages where PAGE_ID = '"+page_id+"'",null);
        return see;
    }

    public Cursor sch_page_check_id(int page_id,String page_name,String category){
        Cursor see = db.rawQuery("select * from pages where PAGE_ID = '"+page_id+"' and PAGE_NAME = '"+page_name+"' and CATEGORY = '"+category+"'",null);
        return see;
    }

    public Cursor com_page_check_id(int page_id,String page_name,String page_type){
        Cursor see = db.rawQuery("select * from pages where PAGE_ID = '"+page_id+"' and PAGE_NAME = '"+page_name+"' and PAGE_TYPE = '"+page_type+"'",null);
        return see;
    }

    public Cursor page_check_id(int page_id,String page_name){
        Cursor see = db.rawQuery("select * from pages where PAGE_ID = '"+page_id+"' and PAGE_NAME = '"+page_name+"'",null);
        return see;
    }

    public Cursor services_request(){
        Cursor see = db.rawQuery("select * from pages where PAGE_TYPE = 'Delivery Service'",null);
        return see;
    }

    public Cursor delivery_data_request(String page_id){
        Cursor see = db.rawQuery("select * from delivery_data where PAGE_ID = '"+page_id+"'",null);
        return see;
    }

    public Cursor delivery_info_lead_request(String page_id){
        Cursor see = db.rawQuery("select * from delivery_info_lead where PAGE_ID = '"+page_id+"'",null);
        return see;
    }

    public Cursor delivery_info_ter_request2(String page_id,String territory){
        Cursor see = db.rawQuery("select * from delivery_info_ter where PAGE_ID = '"+page_id+"' and TERRITORY = '"+territory+"'",null);
        return see;
    }

    public Cursor delivery_info_lead_request2(String page_id,String location,String lead_time){
        Cursor see = db.rawQuery("select * from delivery_info_lead where PAGE_ID = '"+page_id+"' and LOCATION = '"+location+"' and LEAD_TIME = '"+lead_time+"'",null);
        return see;
    }

    public Cursor delivery_info_ter_request(String page_id){
        Cursor see = db.rawQuery("select * from delivery_info_ter where PAGE_ID = '"+page_id+"'",null);
        return see;
    }

    public Cursor page_admins_check_admin(String page_id,String admin){
        Cursor see = db.rawQuery("select * from page_admins where PAGE_ID = '"+page_id+"' and ADMIN = '"+admin+"'",null);
        return see;
    }

    public Cursor page_admins_request_name(String admin,String name){
        Cursor see = db.rawQuery("select * from page_admins where PAGE_NAME = '"+name+"' and ADMIN = '"+admin+"'",null);
        return see;
    }

    public Cursor page_admins_link_request(String admin,String page_type){
        Cursor see = db.rawQuery("select * from page_admins where ADMIN = '"+admin+"' and PAGE_TYPE = '"+page_type+"'",null);
        return see;
    }

    public Cursor page_admins_link_requestt(String admin,String page_type,String page_name,String page_id){
        Cursor see = db.rawQuery("select * from page_admins where ADMIN = '"+admin+"' and PAGE_TYPE = '"+page_type+"' and PAGE_NAME = '"+page_name+"' and PAGE_ID = '"+page_id+"'",null);
        return see;
    }

    public Cursor page_admins_request_id(String id){
        Cursor see = db.rawQuery("select * from page_admins where PAGE_ID = '"+id+"'",null);
        return see;
    }

    public Cursor check_existing_page(String page_name,String admin,String page_type){
        Cursor see = db.rawQuery("select * from page_admins where PAGE_NAME = '"+page_name+"' and ADMIN = '"+admin+"' and PAGE_TYPE = '"+page_type+"'",null);
        return see;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists account_info");
        db.execSQL("drop table if exists education_tab");
        db.execSQL("drop table if exists tertiary_education");
        db.execSQL("drop table if exists data_info");
        db.execSQL("drop table if exists account");
        db.execSQL("drop table if exists tech_skills");
        db.execSQL("drop table if exists tech_cert");
        db.execSQL("drop table if exists work");
        db.execSQL("drop table if exists volunteer");
        db.execSQL("drop table if exists personal_skills");
        db.execSQL("drop table if exists interests");
        db.execSQL("drop table if exists industries");
        db.execSQL("drop table if exists extra");
        db.execSQL("drop table if exists state");
        db.execSQL("drop table if exists pages");
        db.execSQL("drop table if exists temporary_admin");
        db.execSQL("drop table if exists company_filter");
        db.execSQL("drop table if exists explore_filter");
        db.execSQL("drop table if exists talents_filter");
        db.execSQL("drop table if exists popular_filter");
        db.execSQL("drop table if exists school_filter");
        db.execSQL("drop table if exists profile_info");
        db.execSQL("drop table if exists comm_reply_info");
        db.execSQL("drop table if exists follower");
        db.execSQL("drop table if exists page_info");
        db.execSQL("drop table if exists page_review");
        db.execSQL("drop table if exists delivery_review");
        db.execSQL("drop table if exists page_associates");
        db.execSQL("drop table if exists all_locations");
        db.execSQL("drop table if exists all_industries");
        db.execSQL("drop table if exists all_languages");
        db.execSQL("drop table if exists page_admins");
        db.execSQL("drop table if exists organized_school");
        db.execSQL("drop table if exists organized_company");
        db.execSQL("drop table if exists top_deliverer_filter");
        db.execSQL("drop table if exists organized_top_deliverers");
        db.execSQL("drop table if exists your_page");
        db.execSQL("drop table if exists delivery_info_ter");
        db.execSQL("drop table if exists delivery_info_lead");
        db.execSQL("drop table if exists delivery_data");
        db.execSQL("drop table if exists posts");
        db.execSQL("drop table if exists images_videos_audio");
        db.execSQL("drop table if exists comments");
        db.execSQL("drop table if exists likes");
        db.execSQL("drop table if exists saved");
        db.execSQL("drop table if exists job_saved");
        db.execSQL("drop table if exists job_applied");
        db.execSQL("drop table if exists profile_filter");
        db.execSQL("drop table if exists job_filter");
        db.execSQL("drop table if exists pages_filter");
        db.execSQL("drop table if exists media_holder");
        db.execSQL("drop table if exists quick_post_temp");
        db.execSQL("drop table if exists talent_post_temp");
        db.execSQL("drop table if exists quick_post_media_temp");
        db.execSQL("drop table if exists share");
        db.execSQL("drop table if exists popular_rank_holder");
        db.execSQL("drop table if exists talent_rank_holder");
        db.execSQL("drop table if exists media_holder_all");

        db.execSQL("drop table if exists talents");
        db.execSQL("drop table if exists talents_media");
        db.execSQL("drop table if exists talents_comments");
        db.execSQL("drop table if exists talents_nominate");
        db.execSQL("drop table if exists post_views");
        db.execSQL("drop table if exists talent_views");
        db.execSQL("drop table if exists draft_main");
        db.execSQL("drop table if exists draft_one");
        db.execSQL("drop table if exists draft_one_media");
        db.execSQL("drop table if exists reply");
        db.execSQL("drop table if exists reply_media");
        db.execSQL("drop table if exists comment_media");
        db.execSQL("drop table if exists comm_reply_likes");
        db.execSQL("drop table if exists comm_reply_shares");

        db.execSQL("drop table if exists job_post");
        db.execSQL("drop table if exists job_post_temp");
        db.execSQL("drop table if exists Job_post_draft");

        db.execSQL("drop table if exists talents_reply");
        db.execSQL("drop table if exists talents_reply_media");
        db.execSQL("drop table if exists talents_comment_media");
        db.execSQL("drop table if exists talents_comm_reply_likes");
        db.execSQL("drop table if exists talents_saved");
        db.execSQL("drop table if exists talents_likes");
        db.execSQL("drop table if exists talents_share");

        db.execSQL("drop table if exists article_authors");
        db.execSQL("drop table if exists article");
        db.execSQL("drop table if exists article_temp");
        db.execSQL("drop table if exists article_draft");
        db.execSQL("drop table if exists article_author_draft");
        db.execSQL("drop table if exists article_author_temp");
        db.execSQL("drop table if exists talents_comm_reply_shares");

        db.execSQL("drop table if exists board_post");
        db.execSQL("drop table if exists board_post_temp");
        db.execSQL("drop table if exists board_post_draft");

        db.execSQL("drop table if exists board_guest");
        db.execSQL("drop table if exists board_guest_temp");
        db.execSQL("drop table if exists board_guest_draft");
        db.execSQL("drop table if exists post_settings");
        db.execSQL("drop table if exists delivery_review_filter");
        db.execSQL("drop table if exists deliverers");
        db.execSQL("drop table if exists verification");
        db.execSQL("drop table if exists government_id");
        db.execSQL("drop table if exists utility_bill");
        db.execSQL("drop table if exists incorporation");
        db.execSQL("drop table if exists business_cert");

        db.execSQL("drop table if exists brand");
        db.execSQL("drop table if exists brand_temp");
        db.execSQL("drop table if exists logo_pic");
        db.execSQL("drop table if exists logo_pic_temp");
        db.execSQL("drop table if exists brand_pic");
        db.execSQL("drop table if exists brand_pic_temp");
        db.execSQL("drop table if exists reseller");
        db.execSQL("drop table if exists reseller_temp");
        db.execSQL("drop table if exists brand_partner");
        db.execSQL("drop table if exists brand_partner_temp");
        db.execSQL("drop table if exists brand_manufacturer");
        db.execSQL("drop table if exists brand_manufacturer_temp");
        db.execSQL("drop table if exists brand_distributor");
        db.execSQL("drop table if exists brand_distributor_temp");

        db.execSQL("drop table if exists blocked");
        db.execSQL("drop table if exists reports");
        db.execSQL("drop table if exists m_test_users");
        db.execSQL("drop table if exists chat");
        db.execSQL("drop table if exists chat_list");
        onCreate(db);

    }
    public Boolean update(String EMAIL,String PASSWORD){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        cv.put("PASSWORD",PASSWORD);
        db.update("account_info",cv,"EMAIL = ?",new String[]{EMAIL});
        return true;
    }


    public Boolean brand_update(String page_id,String name,String trademark,String registered,String upc,String category,String sub_category,String country,String phone,String website,String email,int brand_id){
        ContentValues cv = new ContentValues();
        cv.put("PAGE_ID",page_id);
        cv.put("NAME",name);
        cv.put("TRADEMARK_NO",trademark);
        cv.put("REGISTERED_AT",registered);
        cv.put("UPC",upc);
        cv.put("CATEGORY",category);
        cv.put("SUB_CATEGORY",sub_category);
        cv.put("COUNTRY",country);
        cv.put("PHONE",phone);
        cv.put("WEBSITE",website);
        cv.put("EMAIL",email);
        db.update("brand",cv,"BRAND_ID = ? and PAGE_ID = ?",new String[]{Integer.toString(brand_id),page_id});
        return true;
    }

    public Boolean card_state_update(String EMAIL,String PASSWORD,int card_state){
        ContentValues cv = new ContentValues();
        cv.put("CARD_STATE",card_state);
        db.update("account_info",cv,"EMAIL = ? and PASSWORD = ?",new String[]{EMAIL,PASSWORD});
        return true;
    }

    public Boolean card_num_update(String EMAIL,String PASSWORD,double card_num){
        ContentValues cv = new ContentValues();
        cv.put("CARD_NUMBER",card_num);
        db.update("account_info",cv,"EMAIL = ? and PASSWORD = ?",new String[]{EMAIL,PASSWORD});
        return true;
    }

    public Boolean update_company_deleted_delivery_service(int id){
        ContentValues cv = new ContentValues();
        cv.put("DELIVERY_SERVICE","");
        cv.put("DELIVERY_SERVICE_ID","");
        db.update("pages",cv,"PAGE_ID = ?",new String[]{Integer.toString(id)});
        return true;
    }

    public Boolean update_delivery_service_deleted_company(int id){
        ContentValues cv = new ContentValues();
        cv.put("MAIN_COMPANY","");
        cv.put("MAIN_COMPANY_ID","");
        db.update("pages",cv,"PAGE_ID = ?",new String[]{Integer.toString(id)});
        return true;
    }

    public Boolean update_deliverer(String EMAIL,String password,String Deliverer_status){
        ContentValues cv = new ContentValues();
        cv.put("DELIVERER",Deliverer_status);
        db.update("account_info",cv,"EMAIL = ? and PASSWORD = ?",new String[]{EMAIL,password});
        return true;
    }

    public Boolean deliverer_update(String deliverer,String state){
        ContentValues cv = new ContentValues();
        cv.put("STATE",state);
        db.update("deliverers",cv,"DELIVERER = ?",new String[]{deliverer});
        return true;
    }

    public Boolean company_filter_update(String email, String password,String location,int lno,String industry, int ino){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",email);
        cv.put("PASSWORD",password);
        cv.put("INDUSTRY",industry);
        cv.put("INO",ino);
        cv.put("LOCATION",location);
        cv.put("LNO",lno);
        db.update("company_filter",cv,"EMAIL = ? and PASSWORD = ?",new String[]{email,password});
        return true;
    }

    public Boolean popular_filter_update(String email, String password,String location,int lno,String industry, int ino){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",email);
        cv.put("PASSWORD",password);
        cv.put("INDUSTRY",industry);
        cv.put("INO",ino);
        cv.put("LOCATION",location);
        cv.put("LNO",lno);
        db.update("popular_filter",cv,"EMAIL = ? and PASSWORD = ?",new String[]{email,password});
        return true;
    }

    public Boolean job_filter_update(String email, String password,String location,int lno,String industry, int ino,String category, int cno){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",email);
        cv.put("PASSWORD",password);
        cv.put("INDUSTRY",industry);
        cv.put("INO",ino);
        cv.put("LOCATION",location);
        cv.put("LNO",lno);
        cv.put("CATEGORY",category);
        cv.put("CNO",cno);
        db.update("job_filter",cv,"EMAIL = ? and PASSWORD = ?",new String[]{email,password});
        return true;
    }

    public Boolean explore_filter_update(String email, String password,String location,int lno,String industry, int ino){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",email);
        cv.put("PASSWORD",password);
        cv.put("INDUSTRY",industry);
        cv.put("INO",ino);
        cv.put("LOCATION",location);
        cv.put("LNO",lno);
        db.update("explore_filter",cv,"EMAIL = ? and PASSWORD = ?",new String[]{email,password});
        return true;
    }

    public Boolean talents_filter_update(String email, String password,String location,int lno,String industry, int ino){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",email);
        cv.put("PASSWORD",password);
        cv.put("INDUSTRY",industry);
        cv.put("INO",ino);
        cv.put("LOCATION",location);
        cv.put("LNO",lno);
        db.update("talents_filter",cv,"EMAIL = ? and PASSWORD = ?",new String[]{email,password});
        return true;
    }

    public Boolean top_deliverer_filter_update(String email, String password,String location,int lno,String deliverer, int dno){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",email);
        cv.put("PASSWORD",password);
        cv.put("DELIVERER",deliverer);
        cv.put("DNO",dno);
        cv.put("LOCATION",location);
        cv.put("LNO",lno);
        db.update("top_deliverer_filter",cv,"EMAIL = ? and PASSWORD = ?",new String[]{email,password});
        return true;
    }

    public Boolean school_filter_update(String email, String password,String location,int lno,String institution, int ino){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",email);
        cv.put("PASSWORD",password);
        cv.put("INSTITUTION",institution);
        cv.put("INO",ino);
        cv.put("LOCATION",location);
        cv.put("LNO",lno);
        db.update("school_filter",cv,"EMAIL = ? and PASSWORD = ?",new String[]{email,password});
        return true;
    }

    public Boolean post_settings_update(String email,String like,int lno,String comment, int cno,String view, int vno){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",email);
        cv.put("LIKES",like);
        cv.put("COMMENTS",comment);
        cv.put("VIEWS",view);
        cv.put("CNO",cno);
        cv.put("LNO",lno);
        cv.put("VNO",vno);
        db.update("post_settings",cv,"EMAIL = ?",new String[]{email});
        return true;
    }

    public Boolean post_update1(int post_id,String like,int lno,String comment, int cno){
        ContentValues cv = new ContentValues();
        cv.put("POST_ID",post_id);
        cv.put("LIKERS",like);
        cv.put("COMMENTERS",comment);
        cv.put("CNO",cno);
        cv.put("LNO",lno);
        db.update("posts",cv,"POST_ID = ?",new String[]{Integer.toString(post_id)});
        return true;
    }

    public Boolean talent_update1(int post_id,String like,int lno,String comment, int cno){
        ContentValues cv = new ContentValues();
        cv.put("POST_ID",post_id);
        cv.put("LIKERS",like);
        cv.put("COMMENTERS",comment);
        cv.put("CNO",cno);
        cv.put("LNO",lno);
        db.update("talents",cv,"POST_ID = ?",new String[]{Integer.toString(post_id)});
        return true;
    }

    public Boolean profile_filter_update(String email,String heading,int hno,String person){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",email);
        cv.put("HEADING",heading);
        cv.put("HNO",hno);
        cv.put("PERSON",person);
        db.update("profile_filter",cv,"EMAIL = ? and PERSON = ?",new String[]{email,person});
        return true;
    }

    public Boolean pages_filter_update(String email, String page_id,String heading,int hno){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",email);
        cv.put("PAGE_ID",page_id);
        cv.put("HEADING",heading);
        cv.put("HNO",hno);
        db.update("pages_filter",cv,"EMAIL = ? and PAGE_ID = ?",new String[]{email,page_id});
        return true;
    }

    public Boolean
    update2(String EMAIL,String PASSWORD,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        cv.put("PASSWORD",PASSWORD);
        db.update("account_info",cv,"EMAIL = ?",new String[]{old_email});
        return true;
    }

    public Boolean page_associates_update(String EMAIL,String PAGE_ID,String old_email ,String old_page_id){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        cv.put("PAGE_ID",PAGE_ID);
        db.update("page_associates",cv,"EMAIL = ? and PAGE_ID = ?",new String[]{old_email,old_page_id});
        return true;
    }

    public Boolean brand_partner_temp_update(String PAGE_ID,String company ,String contribution,String old_company){
        ContentValues cv = new ContentValues();
        cv.put("CONTRIBUTIONS",contribution);
        cv.put("COMPANY",company);
        cv.put("PAGE_ID",PAGE_ID);
        db.update("brand_partner_temp",cv,"COMPANY = ? and PAGE_ID = ?",new String[]{old_company,PAGE_ID});
        return true;
    }

    public Boolean brand_partner_update(String PAGE_ID,String company ,String contribution,String old_company,String brand_id){
        ContentValues cv = new ContentValues();
        cv.put("CONTRIBUTIONS",contribution);
        cv.put("COMPANY",company);
        cv.put("PAGE_ID",PAGE_ID);
        db.update("brand_partner",cv,"COMPANY = ? and PAGE_ID = ? and BRAND_ID = ?",new String[]{old_company,PAGE_ID,brand_id});
        return true;
    }

    public Boolean brand_manufacturer_update(String PAGE_ID,String company ,String country,String old_company,String brand_id){
        ContentValues cv = new ContentValues();
        cv.put("COUNTRY",country);
        cv.put("COMPANY",company);
        cv.put("PAGE_ID",PAGE_ID);
        db.update("brand_manufacturer",cv,"COMPANY = ? and PAGE_ID = ? and BRAND_ID = ?",new String[]{old_company,PAGE_ID,brand_id});
        return true;
    }

    public Boolean brand_distributor_update(String PAGE_ID,String company ,String country,String old_company,String brand_id){
        ContentValues cv = new ContentValues();
        cv.put("COUNTRY",country);
        cv.put("COMPANY",company);
        cv.put("PAGE_ID",PAGE_ID);
        db.update("brand_distributor",cv,"COMPANY = ? and PAGE_ID = ? and BRAND_ID = ?",new String[]{old_company,PAGE_ID,brand_id});
        return true;
    }


    public Boolean brand_manufacturer_temp_update(String PAGE_ID,String company ,String country,String old_company){
        ContentValues cv = new ContentValues();
        cv.put("COUNTRY",country);
        cv.put("COMPANY",company);
        cv.put("PAGE_ID",PAGE_ID);
        db.update("brand_manufacturer_temp",cv,"COMPANY = ? and PAGE_ID = ?",new String[]{old_company,PAGE_ID});
        return true;
    }

    public Boolean brand_distributor_temp_update(String PAGE_ID,String company ,String country,String old_company){
        ContentValues cv = new ContentValues();
        cv.put("COUNTRY",country);
        cv.put("COMPANY",company);
        cv.put("PAGE_ID",PAGE_ID);
        db.update("brand_distributor_temp",cv,"COMPANY = ? and PAGE_ID = ?",new String[]{old_company,PAGE_ID});
        return true;
    }

    public Boolean tertiary_education_update(String EMAIL,String PASSWORD,String school_name,String course_name,String degree_name,String start_month, int start_month_id,String start_year, int start_year_id,String end_month, int end_month_id,String end_year, int end_year_id,String school_id,String oschool_name,String ocourse_name,String odegree_name,String ostart_month, int ostart_month_id,String ostart_year, int ostart_year_id,String oend_month, int oend_month_id,String oend_year, int oend_year_id,String oschool_id){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        cv.put("PASSWORD",PASSWORD);
        cv.put("SCHOOL_NAME",school_name);
        cv.put("COURSE_NAME",course_name);
        cv.put("DEGREE_NAME",degree_name);
        cv.put("START_MONTH",start_month);
        cv.put("START_MONTH_ID",start_month_id);
        cv.put("START_YEAR",start_year);
        cv.put("START_YEAR_ID",start_year_id);
        cv.put("END_MONTH",end_month);
        cv.put("END_MONTH_ID",end_month_id);
        cv.put("END_YEAR",end_year);
        cv.put("END_YEAR_ID",end_year_id);
        cv.put("SCHOOL_ID",school_id);
        db.update("tertiary_education",cv,"EMAIL = ? and PASSWORD = ? and SCHOOL_NAME = ? and COURSE_NAME = ? and DEGREE_NAME = ? and START_MONTH = ? and START_MONTH_ID = ? and START_YEAR = ? and START_YEAR_ID = ? and END_MONTH = ? and END_MONTH_ID = ? and END_YEAR = ? and END_YEAR_ID = ? and SCHOOL_ID = ?",new String[]{EMAIL,PASSWORD,oschool_name,ocourse_name,odegree_name,ostart_month,Integer.toString(ostart_month_id),ostart_year,Integer.toString(ostart_year_id),oend_month,Integer.toString(oend_month_id),oend_year,Integer.toString(oend_year_id),oschool_id});
        return true;
    }

    public Boolean state_update(String EMAIL,String PASSWORD,String state){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        cv.put("PASSWORD",PASSWORD);
        cv.put("STATE",state);
        db.update("state",cv,"EMAIL = ? and PASSWORD = ?",new String[]{EMAIL,PASSWORD});
        return true;
    }

    public Boolean industries_update(String EMAIL,String PASSWORD,String industry_name,int industry_id,String involvement,int involvement_id,String oindustry_name,int oindustry_id,String oinvolvement,int oinvolvement_id){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        cv.put("PASSWORD",PASSWORD);
        cv.put("INDUSTRY_NAME",industry_name);
        cv.put("INDUSTRY_ID",industry_id);
        cv.put("INVOLVEMENT",involvement);
        cv.put("INVOLVEMENT_ID",involvement_id);
        db.update("industries",cv,"EMAIL = ? and PASSWORD = ? and INDUSTRY_NAME = ?  and INDUSTRY_ID = ? and INVOLVEMENT = ?  and INVOLVEMENT_ID = ?",new String[]{EMAIL,PASSWORD,oindustry_name,Integer.toString(oindustry_id),oinvolvement,Integer.toString(oinvolvement_id)});
        return true;
    }

    public Boolean education_update(String EMAIL,String PASSWORD,String school_name,String start_month, int start_month_id,String start_year, int start_year_id,String end_month, int end_month_id,String end_year, int end_year_id,String school_id,String oschool_name,String ostart_month, int ostart_month_id,String ostart_year, int ostart_year_id,String oend_month, int oend_month_id,String oend_year, int oend_year_id,String oschool_id){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        cv.put("PASSWORD",PASSWORD);
        cv.put("SCHOOL_NAME",school_name);
        cv.put("START_MONTH",start_month);
        cv.put("START_MONTH_ID",start_month_id);
        cv.put("START_YEAR",start_year);
        cv.put("START_YEAR_ID",start_year_id);
        cv.put("END_MONTH",end_month);
        cv.put("END_MONTH_ID",end_month_id);
        cv.put("END_YEAR",end_year);
        cv.put("END_YEAR_ID",end_year_id);
        cv.put("SCHOOL_ID",school_id);

        db.update("education_tab",cv,"EMAIL = ? and PASSWORD = ? and SCHOOL_NAME = ? and START_MONTH = ? and START_MONTH_ID = ? and START_YEAR = ? and START_YEAR_ID = ? and END_MONTH = ? and END_MONTH_ID = ? and END_YEAR = ? and END_YEAR_ID = ? and SCHOOL_ID = ?",new String[]{EMAIL,PASSWORD,oschool_name,ostart_month,Integer.toString(ostart_month_id),ostart_year,Integer.toString(ostart_year_id),oend_month,Integer.toString(oend_month_id),oend_year,Integer.toString(oend_year_id),oschool_id});
        return true;
    }

    public Boolean tech_cert_update(String EMAIL,String PASSWORD,String certificate_name,String certificate_body,String certificate_id,String certificate_url,String start_month, int start_month_id,String start_year, int start_year_id,String end_month, int end_month_id,String end_year, int end_year_id,String certificate_body_id,String ocertificate_name,String ocertificate_body,String ocertificate_id,String ocertificate_url,String ostart_month, int ostart_month_id,String ostart_year, int ostart_year_id,String oend_month, int oend_month_id,String oend_year, int oend_year_id,String ocertificate_body_id){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        cv.put("PASSWORD",PASSWORD);
        cv.put("CERTIFICATE_NAME",certificate_name);
        cv.put("CERTIFICATE_BODY",certificate_body);
        cv.put("CERTIFICATE_ID",certificate_id);
        cv.put("CERTIFICATE_URL",certificate_url);
        cv.put("START_MONTH",start_month);
        cv.put("START_MONTH_ID",start_month_id);
        cv.put("START_YEAR",start_year);
        cv.put("START_YEAR_ID",start_year_id);
        cv.put("END_MONTH",end_month);
        cv.put("END_MONTH_ID",end_month_id);
        cv.put("END_YEAR",end_year);
        cv.put("END_YEAR_ID",end_year_id);
        cv.put("CERTIFICATE_BODY_ID",certificate_body_id);
        db.update("tech_cert",cv,"EMAIL = ? and PASSWORD = ? and CERTIFICATE_NAME = ? and CERTIFICATE_BODY = ?and CERTIFICATE_ID = ?and CERTIFICATE_URL = ? and START_MONTH = ? and START_MONTH_ID = ? and START_YEAR = ? and START_YEAR_ID = ? and END_MONTH = ? and END_MONTH_ID = ? and END_YEAR = ? and END_YEAR_ID = ? and CERTIFICATE_BODY_ID = ?",new String[]{EMAIL,PASSWORD,ocertificate_name,ocertificate_body,ocertificate_id,ocertificate_url,ostart_month,Integer.toString(ostart_month_id),ostart_year,Integer.toString(ostart_year_id),oend_month,Integer.toString(oend_month_id),oend_year,Integer.toString(oend_year_id),ocertificate_body_id});
        return true;
    }

    public Boolean language_update(String EMAIL,String PASSWORD,String language_name,int language_id,String proficiency,int proficiency_id,String olanguage_name,int olanguage_id,String oproficiency,int oproficiency_id){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        cv.put("PASSWORD",PASSWORD);
        cv.put("LANGUAGE_NAME",language_name);
        cv.put("LANGUAGE_ID",language_id);
        cv.put("PROFICIENCY",proficiency);
        cv.put("PROFICIENCY_ID",proficiency_id);
        db.update("language",cv,"EMAIL = ? and PASSWORD = ? and LANGUAGE_NAME = ?  and LANGUAGE_ID = ? and PROFICIENCY = ?  and PROFICIENCY_ID = ?",new String[]{EMAIL,PASSWORD,olanguage_name,Integer.toString(olanguage_id),oproficiency,Integer.toString(oproficiency_id)});
        return true;
    }


    public Boolean work_update(String EMAIL,String PASSWORD,String worked_at,String worked_as,String location,String description,String start_month, int start_month_id,String start_year, int start_year_id,String end_month, int end_month_id,String end_year, int end_year_id,String location_existence,String correct_location,String worked_at_id, String oworked_at,String oworked_as,String olocation,String odescription,String ostart_month, int ostart_month_id,String ostart_year, int ostart_year_id,String oend_month, int oend_month_id,String oend_year, int oend_year_id,String olocation_existence,String ocorrect_location,String oworked_at_id){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        cv.put("PASSWORD",PASSWORD);
        cv.put("WORKED_AT",worked_at);
        cv.put("WORKED_AS",worked_as);
        cv.put("LOCATION",location);
        cv.put("DESCRIPTION",description);
        cv.put("START_MONTH",start_month);
        cv.put("START_MONTH_ID",start_month_id);
        cv.put("START_YEAR",start_year);
        cv.put("START_YEAR_ID",start_year_id);
        cv.put("END_MONTH",end_month);
        cv.put("END_MONTH_ID",end_month_id);
        cv.put("LOCATION_EXISTENCE",location_existence);
        cv.put("CORRECT_LOCATION",correct_location);
        cv.put("END_YEAR",end_year);
        cv.put("END_YEAR_ID",end_year_id);
        cv.put("WORKED_AT_ID",worked_at_id);
        db.update("work",cv,"EMAIL = ? and PASSWORD = ? and WORKED_AT = ? and WORKED_AS = ? and LOCATION = ? and DESCRIPTION = ? and START_MONTH = ? and START_MONTH_ID = ? and START_YEAR = ? and START_YEAR_ID = ? and END_MONTH = ? and END_MONTH_ID = ? and END_YEAR = ? and END_YEAR_ID = ? and LOCATION_EXISTENCE = ? and CORRECT_LOCATION = ? and WORKED_AT_ID = ?",new String[]{EMAIL,PASSWORD,oworked_at,oworked_as,olocation,odescription,ostart_month,Integer.toString(ostart_month_id),ostart_year,Integer.toString(ostart_year_id),oend_month,Integer.toString(oend_month_id),oend_year,Integer.toString(oend_year_id),olocation_existence,ocorrect_location,oworked_at_id});
        return true;
    }


    public Boolean tech_skills_update(String EMAIL,String PASSWORD,String skill,String capability,int capability_id,String oskill,String ocapability,int ocapability_id){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        cv.put("PASSWORD",PASSWORD);
        cv.put("SKILL",skill);
        cv.put("CAPABILITY",capability);
        cv.put("CAPABILITY_ID",capability_id);
        db.update("tech_skills",cv,"EMAIL = ? and PASSWORD = ? and SKILL = ? and CAPABILITY = ? and CAPABILITY_ID = ?",new String[]{EMAIL,PASSWORD,oskill,ocapability,Integer.toString(ocapability_id)});
        return true;
    }

    public Boolean personal_skills_update(String EMAIL,String PASSWORD,String skill,String capability,int capability_id,String oskill,String ocapability,int ocapability_id){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        cv.put("PASSWORD",PASSWORD);
        cv.put("SKILL",skill);
        cv.put("CAPABILITY",capability);
        cv.put("CAPABILITY_ID",capability_id);
        db.update("personal_skills",cv,"EMAIL = ? and PASSWORD = ? and SKILL = ? and CAPABILITY = ? and CAPABILITY_ID = ?",new String[]{EMAIL,PASSWORD,oskill,ocapability,Integer.toString(ocapability_id)});
        return true;
    }

    public Boolean interests_update(String EMAIL,String PASSWORD,String interest,String interest_level,int interest_id,String ointerest,String ointerest_level,int ointerest_id){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        cv.put("PASSWORD",PASSWORD);
        cv.put("INTEREST",interest);
        cv.put("INTEREST_LEVEL",interest_level);
        cv.put("INTEREST_ID",interest_id);
        db.update("interests",cv,"EMAIL = ? and PASSWORD = ? and INTEREST = ? and INTEREST_LEVEL = ? and INTEREST_ID = ?",new String[]{EMAIL,PASSWORD,ointerest,ointerest_level,Integer.toString(ointerest_id)});
        return true;
    }



    public Boolean volunteer_update(String EMAIL,String PASSWORD,String activity,String start_month, int start_month_id,String start_year, int start_year_id,String end_month, int end_month_id,String end_year, int end_year_id,String oactivity,String ostart_month, int ostart_month_id,String ostart_year, int ostart_year_id,String oend_month, int oend_month_id,String oend_year, int oend_year_id){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        cv.put("PASSWORD",PASSWORD);
        cv.put("ACTIVITY",activity);
        cv.put("START_MONTH",start_month);
        cv.put("START_MONTH_ID",start_month_id);
        cv.put("START_YEAR",start_year);
        cv.put("START_YEAR_ID",start_year_id);
        cv.put("END_MONTH",end_month);
        cv.put("END_MONTH_ID",end_month_id);
        cv.put("END_YEAR",end_year);
        cv.put("END_YEAR_ID",end_year_id);

        db.update("volunteer",cv,"EMAIL = ? and PASSWORD = ? and ACTIVITY = ? and START_MONTH = ? and START_MONTH_ID = ? and START_YEAR = ? and START_YEAR_ID = ? and END_MONTH = ? and END_MONTH_ID = ? and END_YEAR = ? and END_YEAR_ID = ?",new String[]{EMAIL,PASSWORD,oactivity,ostart_month,Integer.toString(ostart_month_id),ostart_year,Integer.toString(ostart_year_id),oend_month,Integer.toString(oend_month_id),oend_year,Integer.toString(oend_year_id)});
        return true;
    }

    public Boolean extra_update(String EMAIL,String PASSWORD,String activity,String start_month, int start_month_id,String start_year, int start_year_id,String end_month, int end_month_id,String end_year, int end_year_id,String oactivity,String ostart_month, int ostart_month_id,String ostart_year, int ostart_year_id,String oend_month, int oend_month_id,String oend_year, int oend_year_id){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        cv.put("PASSWORD",PASSWORD);
        cv.put("ACTIVITY",activity);
        cv.put("START_MONTH",start_month);
        cv.put("START_MONTH_ID",start_month_id);
        cv.put("START_YEAR",start_year);
        cv.put("START_YEAR_ID",start_year_id);
        cv.put("END_MONTH",end_month);
        cv.put("END_MONTH_ID",end_month_id);
        cv.put("END_YEAR",end_year);
        cv.put("END_YEAR_ID",end_year_id);

        db.update("extra",cv,"EMAIL = ? and PASSWORD = ? and ACTIVITY = ? and START_MONTH = ? and START_MONTH_ID = ? and START_YEAR = ? and START_YEAR_ID = ? and END_MONTH = ? and END_MONTH_ID = ? and END_YEAR = ? and END_YEAR_ID = ?",new String[]{EMAIL,PASSWORD,oactivity,ostart_month,Integer.toString(ostart_month_id),ostart_year,Integer.toString(ostart_year_id),oend_month,Integer.toString(oend_month_id),oend_year,Integer.toString(oend_year_id)});
        return true;
    }

    public Boolean update_profile(String first_name, String last_name, String email,String bio, String dob, String country, String phone,byte[]image,int cno, byte[]bimage,String image_status,String bimage_status, String gender,int gno,String location, String location_switch,String profile_mail,String website,String location_existence,String correct_location,String current_longitude, String current_latitude, String page, String page_id){
        ContentValues cv = new ContentValues();
        cv.put("FIRST_NAME",first_name);
        cv.put("LAST_NAME",last_name);
        cv.put("EMAIL",email);
        cv.put("BIO",bio);
        cv.put("DOB",dob);
        cv.put("COUNTRY",country);
        cv.put("PHONE",phone);
        cv.put("LOCATION",location);
        cv.put("CORRECT_LOCATION",correct_location);
        cv.put("LOCATION_SWITCH",location_switch);
        cv.put("IMAGE",image);
        cv.put("CNO",cno);
        cv.put("BIMAGE",bimage);
        cv.put("LOCATION_EXISTENCE",location_existence);
        cv.put("IMAGE_STATUS",image_status);
        cv.put("BIMAGE_STATUS",bimage_status);
        cv.put("GENDER",gender);
        cv.put("PROFILE_MAIL",profile_mail);
        cv.put("WEBSITE",website);
        cv.put("GNO",gno);
        cv.put("CURRENT_LONGITUDE",current_longitude);
        cv.put("CURRENT_LATITUDE",current_latitude);
        cv.put("PAGE",page);
        cv.put("PAGE_ID",page_id);
        db.update("account_info",cv,"EMAIL = ?",new String[]{email});
        return true;
    }

    public Boolean pages_update(int page_id, String page_name, int ino, String industry, String headquarter,String location_existence, String website,String mail, int cno, String country,String number,String founded, byte[]image, byte[]bimage,String image_status,String bimage_status,String category,String about,String core,String info,String vision,String what,int catno,String headquarter_existence,String location,String correct_headquarter,String correct_location,String delivery_services,String delivery_services_id,String main_company,String main_company_id,String offers_delivery){
        ContentValues cv = new ContentValues();
        cv.put("PAGE_NAME",page_name);
        cv.put("INO",ino);
        cv.put("INDUSTRY",industry);
        cv.put("HEADQUARTER",headquarter);
        cv.put("CORRECT_HEADQUARTER",correct_headquarter);
        cv.put("LOCATION",location);
        cv.put("CORRECT_LOCATION",correct_location);
        cv.put("WEBSITE",website);
        cv.put("IMAGE",image);
        cv.put("BIMAGE",bimage);
        cv.put("COUNTRY",country);
        cv.put("CATEGORY",category);
        cv.put("CATNO",catno);
        cv.put("IMAGE_STATUS",image_status);
        cv.put("BIMAGE_STATUS",bimage_status);
        cv.put("PROFILE_MAIL",mail);
        cv.put("PHONE",number);
        cv.put("ABOUT",about);
        cv.put("WHAT",what);
        cv.put("VISION",vision);
        cv.put("CORE",core);
        cv.put("INFO",info);
        cv.put("FOUNDED",founded);
        cv.put("LOCATION_EXISTENCE",location_existence);
        cv.put("HEADQUARTER_EXISTENCE",headquarter_existence);
        cv.put("CNO",cno);
        cv.put("DELIVERY_SERVICE",delivery_services);
        cv.put("DELIVERY_SERVICE_ID",delivery_services_id);
        cv.put("MAIN_COMPANY",main_company);
        cv.put("MAIN_COMPANY_ID",main_company_id);
        cv.put("OFFERS_DELIVERY",offers_delivery);
        db.update("pages",cv,"PAGE_ID = ?",new String[]{Integer.toString(page_id)});
        return true;
    }

    public int delete(String email){
        int del =  db.delete("account_info","EMAIL = ?",new String[]{email});
        return del;
    }




    public int tech_skills_delete_all(String email){
        int del =  db.delete("tech_skills","EMAIL = ?",new String[]{email});
        return del;
    }


    public int interests_delete(String email,String password,String interest, String interest_level, int interest_id){
        int del =  db.delete("interests","EMAIL = ? and PASSWORD = ? and INTEREST = ? and INTEREST_LEVEL = ? and INTEREST_ID = ?",new String[]{email,password,interest,interest_level,Integer.toString(interest_id)});
        return del;
    }

    public int interests_delete_all(String email){
        int del =  db.delete("interests","EMAIL = ?",new String[]{email});
        return del;
    }



    public int industries_delete(String email,String password,String industry_name, int industry_id, String involvement, int involvement_id){
        int del =  db.delete("industries","EMAIL = ? and PASSWORD = ? and INDUSTRY_NAME = ? and INDUSTRY_ID = ? and INVOLVEMENT = ? and INVOLVEMENT_ID = ?",new String[]{email,password,industry_name,Integer.toString(industry_id),involvement,Integer.toString(involvement_id)});
        return del;
    }

    public int industries_delete_all(String email){
        int del =  db.delete("industries","EMAIL = ?",new String[]{email});
        return del;
    }

    public int posts_delete_all(String email){
        int del =  db.delete("posts","POSTER_EMAIL = ?",new String[]{email});
        return del;
    }

    public int posts_delete_all2(String page_id){
        int del =  db.delete("posts","PAGE_ID = ?",new String[]{page_id});
        return del;
    }

    public int job_post_temp_delete_all(String page_id){
        int del =  db.delete("job_post_temp","PAGE_ID = ?",new String[]{page_id});
        return del;
    }

    public int job_post_draft_delete_all(String page_id){
        int del =  db.delete("job_post_draft","PAGE_ID = ?",new String[]{page_id});
        return del;
    }

    public int job_post_delete_all(String page_id){
        int del =  db.delete("job_post","PAGE_ID = ?",new String[]{page_id});
        return del;
    }

    public int board_post_temp_delete_all(String page_id){
        int del =  db.delete("board_post_temp","PAGE_ID = ?",new String[]{page_id});
        return del;
    }

    public int board_guest_temp_delete_all2(String page_id){
        int del =  db.delete("board_guest_temp","PAGE_ID = ?",new String[]{page_id});
        return del;
    }

    public int board_post_draft_delete_all(String page_id){
        int del =  db.delete("board_post_draft","PAGE_ID = ?",new String[]{page_id});
        return del;
    }

    public int board_post_delete_all(String page_id){
        int del =  db.delete("board_post","PAGE_ID = ?",new String[]{page_id});
        return del;
    }

    public int post_views_delete_all(String email){
        int del =  db.delete("post_views","VIEWER = ?",new String[]{email});
        return del;
    }

    public int post_settings_delete_all(String email){
        int del =  db.delete("post_settings","EMAIL = ?",new String[]{email});
        return del;
    }

    public int draft_main_delete_all(String email){
        int del =  db.delete("draft_main","EMAIL = ?",new String[]{email});
        return del;
    }

    public int draft_main_delete_all2(String page_id){
        int del =  db.delete("draft_main","PAGE_ID = ?",new String[]{page_id});
        return del;
    }

    public int draft_one_delete_all(String email){
        int del =  db.delete("draft_one","EMAIL = ?",new String[]{email});
        return del;
    }

    public int quick_post_temp_delete_all(String email){
        int del =  db.delete("quick_post_temp","Account = ?",new String[]{email});
        return del;
    }

    public int quick_post_temp_delete_all2(String page_id){
        int del =  db.delete("quick_post_temp","PAGE_ID = ?",new String[]{page_id});
        return del;
    }

    public int delivery_info_lead_delete_all(String page_id){
        int del =  db.delete("delivery_info_lead","PAGE_ID = ?",new String[]{page_id});
        return del;
    }

    public int delivery_data_delete_all(String page_id){
        int del =  db.delete("delivery_data","PAGE_ID = ?",new String[]{page_id});
        return del;
    }

    public int talent_post_temp_delete_all(String email){
        int del =  db.delete("talent_post_temp","Account = ?",new String[]{email});
        return del;
    }

    public int company_filter_delete_all(String email){
        int del =  db.delete("company_filter","EMAIL = ?",new String[]{email});
        return del;
    }

    public int explore_filter_delete_all(String email){
        int del =  db.delete("explore_filter","EMAIL = ?",new String[]{email});
        return del;
    }

    public int popular_filter_delete_all(String email){
        int del =  db.delete("popular_filter","EMAIL = ?",new String[]{email});
        return del;
    }

    public int job_filter_delete_all(String email){
        int del =  db.delete("job_filter","EMAIL = ?",new String[]{email});
        return del;
    }

    public int talent_filter_delete_all(String email){
        int del =  db.delete("talents_filter","EMAIL = ?",new String[]{email});
        return del;
    }

    public int top_deliverer_filter_delete_all(String email){
        int del =  db.delete("top_deliverer_filter","EMAIL = ?",new String[]{email});
        return del;
    }

    public int school_filter_delete_all(String email){
        int del =  db.delete("school_filter","EMAIL = ?",new String[]{email});
        return del;
    }

    public int profile_filter_delete_all(String email){
        int del =  db.delete("profile_filter","EMAIL = ?",new String[]{email});
        return del;
    }

    public int pages_filter_delete_all(String email){
        int del =  db.delete("pages_filter","EMAIL = ?",new String[]{email});
        return del;
    }

    public int pages_filter_delete_all2(String page_id){
        int del =  db.delete("pages_filter","PAGE_ID = ?",new String[]{page_id});
        return del;
    }

    /////
    public int article_author_delete_all(String email){
        int del =  db.delete("article_authors","AUTHOR_EMAIL = ?",new String[]{email});
        return del;
    }

    public int article_temp_delete_all(String email){
        int del =  db.delete("article_temp","EMAIL = ?",new String[]{email});
        return del;
    }

    public int article_authors_temp_delete_all(String email){
        int del =  db.delete("article_authors_temp","EMAIL = ?",new String[]{email});
        return del;
    }

    public int article_draft_delete_all(String email){
        int del =  db.delete("article_draft","EMAIL = ?",new String[]{email});
        return del;
    }

    public int board_guest_delete_all(String guest){
        int del =  db.delete("board_guest","GUEST = ?",new String[]{guest});
        return del;
    }

    public int board_guest_temp_delete_all(String guest){
        int del =  db.delete("board_guest_temp","GUEST = ?",new String[]{guest});
        return del;
    }

    public int board_guest_draft_delete_all(String guest){
        int del =  db.delete("board_guest_draft","GUEST = ?",new String[]{guest});
        return del;
    }

    public int quick_post_media_temp_delete_all(String email){
        int del =  db.delete("quick_post_media_temp","Account = ?",new String[]{email});
        return del;
    }

    public int quick_post_media_temp_delete_all2(String page_id){
        int del =  db.delete("quick_post_media_temp","PAGE_ID = ?",new String[]{page_id});
        return del;
    }

    public int talent_views_delete_all(String email){
        int del =  db.delete("talent_views","VIEWER = ?",new String[]{email});
        return del;
    }

    public int talents_delete_all(String email){
        int del =  db.delete("talents","POSTER_EMAIL = ?",new String[]{email});
        return del;
    }

    public int comments_delete_all(String email){
        int del =  db.delete("comments","COMMENTER_EMAIL = ?",new String[]{email});
        return del;
    }

    public int talent_comments_delete_all(String email){
        int del =  db.delete("talents_comments","COMMENTER_EMAIL = ?",new String[]{email});
        return del;
    }

    public int talent_nominate_delete_all(String email){
        int del =  db.delete("talents_nominate","NOMINATOR_EMAIL = ?",new String[]{email});
        return del;
    }

    public int talent_reply_delete_all(String email){
        int del =  db.delete("talents_reply","REPLYER_EMAIL = ?",new String[]{email});
        return del;
    }

    public int likes_delete_all(String email){
        int del =  db.delete("likes","LIKER_EMAIL = ?",new String[]{email});
        return del;
    }

    public int saved_delete_all(String email){
        int del =  db.delete("saved","SAVER_EMAIL = ?",new String[]{email});
        return del;
    }

    public int share_delete_all(String email){
        int del =  db.delete("share","SHARER_EMAIL = ?",new String[]{email});
        return del;
    }

    public int job_applied_delete_all(String email){
        int del =  db.delete("job_applied","APPLYER_EMAIL = ?",new String[]{email});
        return del;
    }

    public int job_saved_delete_all(String email){
        int del =  db.delete("job_saved","SAVER_EMAIL = ?",new String[]{email});
        return del;
    }

    public int talents_likes_delete_all(String email){
        int del =  db.delete("talents_likes","LIKER_EMAIL = ?",new String[]{email});
        return del;
    }

    public int talents_saved_delete_all(String email){
        int del =  db.delete("talents_saved","SAVER_EMAIL = ?",new String[]{email});
        return del;
    }

    public int talents_share_delete_all(String email){
        int del =  db.delete("talents_share","SHARER_EMAIL = ?",new String[]{email});
        return del;
    }

    public int comm_reply_likes_delete_all(String email){
        int del =  db.delete("comm_reply_likes","LIKER_EMAIL = ?",new String[]{email});
        return del;
    }

    public int comm_reply_shares_delete_all(String email){
        int del =  db.delete("comm_reply_shares","SHARER_EMAIL = ?",new String[]{email});
        return del;
    }

    public int talent_comm_reply_likes_delete_all(String email){
        int del =  db.delete("talents_comm_reply_likes","LIKER_EMAIL = ?",new String[]{email});
        return del;
    }

    public int talent_comm_reply_share_delete_all(String email){
        int del =  db.delete("talents_comm_reply_shares","SHARER_EMAIL = ?",new String[]{email});
        return del;
    }

    public int reply_delete_all(String email){
        int del =  db.delete("reply","REPLYER_EMAIL = ?",new String[]{email});
        return del;
    }

    public int company_filter_delete(String email,String password){
        int del =  db.delete("company_filter","EMAIL = ? and PASSWORD = ?",new String[]{email,password});
        return del;
    }

    public int school_filter_delete(String email,String password){
        int del =  db.delete("school_filter","EMAIL = ? and PASSWORD = ?",new String[]{email,password});
        return del;
    }

    public int personal_skills_delete(String email,String password,String skill, String capability, int capability_id){
        int del =  db.delete("personal_skills","EMAIL = ? and PASSWORD = ? and SKILL = ? and CAPABILITY = ? and CAPABILITY_ID = ?",new String[]{email,password,skill,capability,Integer.toString(capability_id)});
        return del;
    }

    public int personal_skills_delete_all(String email){
        int del =  db.delete("personal_skills","EMAIL = ?",new String[]{email});
        return del;
    }


    public int education_delete(String email,String password,String Schoolname,String start_month, int start_month_id,String start_year, int start_year_id,String end_month, int end_month_id,String end_year, int end_year_id,String school_id){
        int del =  db.delete("education_tab","EMAIL = ? and PASSWORD = ? and SCHOOL_NAME = ? and START_MONTH = ? and START_MONTH_ID = ? and START_YEAR = ? and START_YEAR_ID = ? and END_MONTH = ? and END_MONTH_ID = ? and END_YEAR = ? and END_YEAR_ID = ? and SCHOOL_ID = ?",new String[]{email,password,Schoolname,start_month,Integer.toString(start_month_id),start_year,Integer.toString(start_year_id),end_month,Integer.toString(end_month_id),end_year,Integer.toString(end_year_id),school_id});
        return del;
    }

    public int brand_partner_temp_delete(String page_id,String company){
        int del =  db.delete("brand_partner_temp","PAGE_ID = ? and COMPANY = ?",new String[]{page_id,company});
        return del;
    }

    public int brand_partner_delete(String page_id,String company,String brand_id){
        int del =  db.delete("brand_partner","PAGE_ID = ? and COMPANY = ? and BRAND_ID = ?",new String[]{page_id,company,brand_id});
        return del;
    }

    public int brand_partner_delete(String page_id,String brand_id){
        int del =  db.delete("brand_partner","PAGE_ID = ? and BRAND_ID = ?",new String[]{page_id,brand_id});
        return del;
    }

    public int brand_manufacturer_delete(String page_id,String company,String brand_id){
        int del =  db.delete("brand_manufacturer","PAGE_ID = ? and COMPANY = ? and BRAND_ID = ?",new String[]{page_id,company,brand_id});
        return del;
    }

    public int brand_manufacturer_delete(String page_id,String brand_id){
        int del =  db.delete("brand_manufacturer","PAGE_ID = ? and BRAND_ID = ?",new String[]{page_id,brand_id});
        return del;
    }

    public int brand_distributor_delete(String page_id,String company,String brand_id){
        int del =  db.delete("brand_distributor","PAGE_ID = ? and COMPANY = ? and BRAND_ID = ?",new String[]{page_id,company,brand_id});
        return del;
    }

    public int brand_distributor_delete(String page_id,String brand_id){
        int del =  db.delete("brand_distributor","PAGE_ID = ? and BRAND_ID = ?",new String[]{page_id,brand_id});
        return del;
    }

    public int brand_manufacturer_temp_delete(String page_id,String company){
        int del =  db.delete("brand_manufacturer_temp","PAGE_ID = ? and COMPANY = ?",new String[]{page_id,company});
        return del;
    }

    public int brand_distributor_temp_delete(String page_id,String company){
        int del =  db.delete("brand_distributor_temp","PAGE_ID = ? and COMPANY = ?",new String[]{page_id,company});
        return del;
    }

    public int education_delete_all(String email){
        int del =  db.delete("education_tab","EMAIL = ?",new String[]{email});
        return del;
    }

    public int reseller_delete_all(String email){
        int del =  db.delete("reseller","RESELLER_EMAIL = ?",new String[]{email});
        return del;
    }

    public int reseller_temp_delete_all(String email){
        int del =  db.delete("reseller_temp","RESELLER_EMAIL = ?",new String[]{email});
        return del;
    }

    public int verification_delete_all(String email){
        int del =  db.delete("verification","DELIVERER = ?",new String[]{email});
        return del;
    }

    public int tertiary_education_delete(String email,String password,String Schoolname,String course_name,String degree_name,String start_month, int start_month_id,String start_year, int start_year_id,String end_month, int end_month_id,String end_year, int end_year_id,String school_id){
        int del =  db.delete("tertiary_education","EMAIL = ? and PASSWORD = ? and SCHOOL_NAME = ? and COURSE_NAME = ? and DEGREE_NAME = ? and START_MONTH = ? and START_MONTH_ID = ? and START_YEAR = ? and START_YEAR_ID = ? and END_MONTH = ? and END_MONTH_ID = ? and END_YEAR = ? and END_YEAR_ID = ? and SCHOOL_ID = ?",new String[]{email,password,Schoolname,course_name,degree_name,start_month,Integer.toString(start_month_id),start_year,Integer.toString(start_year_id),end_month,Integer.toString(end_month_id),end_year,Integer.toString(end_year_id),school_id});
        return del;
    }
    public int tertiary_education_delete_all(String email){
        int del =  db.delete("tertiary_education","EMAIL = ?",new String[]{email});
        return del;
    }

    public int tech_cert_delete(String email,String password,String certificate_name,String certificate_body,String certificate_id,String certificate_url,String start_month, int start_month_id,String start_year, int start_year_id,String end_month, int end_month_id,String end_year, int end_year_id,String cert_body_id){
        int del =  db.delete("tech_cert","EMAIL = ? and PASSWORD = ? and CERTIFICATE_NAME = ? and CERTIFICATE_BODY = ? and CERTIFICATE_ID = ? and CERTIFICATE_URL = ? and START_MONTH = ? and START_MONTH_ID = ? and START_YEAR = ? and START_YEAR_ID = ? and END_MONTH = ? and END_MONTH_ID = ? and END_YEAR = ? and END_YEAR_ID = ? and CERTIFICATE_BODY_ID = ?",new String[]{email,password,certificate_name,certificate_body,certificate_id,certificate_url,start_month,Integer.toString(start_month_id),start_year,Integer.toString(start_year_id),end_month,Integer.toString(end_month_id),end_year,Integer.toString(end_year_id),cert_body_id});
        return del;
    }

    public int language_delete(String email,String password,String language_name, int language_id, String proficiency, int proficiency_id){
        int del =  db.delete("language","EMAIL = ? and PASSWORD = ? and LANGUAGE_NAME = ? and LANGUAGE_ID = ? and PROFICIENCY = ? and PROFICIENCY_ID = ?",new String[]{email,password,language_name,Integer.toString(language_id),proficiency,Integer.toString(proficiency_id)});
        return del;
    }


    public int tech_cert_delete_all(String email){
        int del =  db.delete("tech_cert","EMAIL = ?",new String[]{email});
        return del;
    }

    public int language_delete_all(String email){
        int del =  db.delete("language","EMAIL = ?",new String[]{email});
        return del;
    }

    public int state_delete_all(String email){
        int del =  db.delete("state","EMAIL = ?",new String[]{email});
        return del;
    }

    public int your_page_delete_all(String email){
        int del =  db.delete("your_page","EMAIL = ?",new String[]{email});
        return del;
    }

    public int profile_info_delete_all(String email){
        int del =  db.delete("profile_info","EMAIL = ?",new String[]{email});
        return del;
    }

    public int deliverers_delete_all(String email){
        int del =  db.delete("deliverers","DELIVERER = ?",new String[]{email});
        return del;
    }

    public int deliverers_delete_all2(String PAGE_ID){
        int del =  db.delete("deliverers","PAGE_ID = ?",new String[]{PAGE_ID});
        return del;
    }

    public int comm_reply_info_delete_all(String email){
        int del =  db.delete("comm_reply_info","EMAIL = ?",new String[]{email});
        return del;
    }

    public int page_info_delete_all(String email){
        int del =  db.delete("page_info","ADMIN = ?",new String[]{email});
        return del;
    }

    public int page_associates_delete_all(String email){
        int del =  db.delete("page_associates","EMAIL = ?",new String[]{email});
        return del;
    }

    public int delivery_review_delete_all(String email){
        int del =  db.delete("delivery_review","DELIVERER_EMAIL = ?",new String[]{email});
        return del;
    }

    public int followers_delete_all1(String email){
        int del =  db.delete("followers","ACCOUNT = ?",new String[]{email});
        return del;
    }

    public int followers_delete_all2(String email){
        int del =  db.delete("followers","FOLLOWING_CAMO = ?",new String[]{email});
        return del;
    }

    public int followers_delete_all3(String email){
        int del =  db.delete("followers","FOLLOWER_DINKY = ?",new String[]{email});
        return del;
    }

    public int followers_delete_all4(String page_id){
        int del =  db.delete("followers","FOLLOWING_PAGE_ID = ?",new String[]{page_id});
        return del;
    }

    public int organized_comp_delete_all(int page_id){
        int del =  db.delete("organized_company","PAGE_ID = ?",new String[]{Integer.toString(page_id)});
        return del;
    }

    public int organized_sch_delete_all(int page_id){
        int del =  db.delete("organized_school","PAGE_ID = ?",new String[]{Integer.toString(page_id)});
        return del;
    }

    public int organized_topdel_delete_all(int page_id){
        int del =  db.delete("organized_top_deliverers","PAGE_ID = ?",new String[]{Integer.toString(page_id)});
        return del;
    }

    public int orgtopdel_delete_all(String email){
        int del =  db.delete("organized_top_deliverers","EMAIL = ?",new String[]{email});
        return del;
    }

    public int temp_admin_delete_all(String email){
        int del =  db.delete("temporary_admin","EMAIL = ?",new String[]{email});
        return del;
    }

    public int page_admins_delete_all(String email){
        int del =  db.delete("page_admins","ADMIN = ?",new String[]{email});
        return del;
    }

    public int work_delete(String email,String password,String worked_at,String worked_as,String location,String description,String start_month, int start_month_id,String start_year, int start_year_id,String end_month, int end_month_id,String end_year, int end_year_id,String location_existence,String correct_location,String worked_at_id){
        int del =  db.delete("work","EMAIL = ? and PASSWORD = ? and WORKED_AT = ? and WORKED_AS = ? and LOCATION = ? and DESCRIPTION = ? and START_MONTH = ? and START_MONTH_ID = ? and START_YEAR = ? and START_YEAR_ID = ? and END_MONTH = ? and END_MONTH_ID = ? and END_YEAR = ? and END_YEAR_ID = ? and LOCATION_EXISTENCE = ? and CORRECT_LOCATION = ? and WORKED_AT_ID = ?",new String[]{email,password,worked_at,worked_as,location,description,start_month,Integer.toString(start_month_id),start_year,Integer.toString(start_year_id),end_month,Integer.toString(end_month_id),end_year,Integer.toString(end_year_id),location_existence,correct_location,worked_at_id});
        return del;
    }
    public int tech_skills_delete(String email,String password,String skill, String capability, int capability_id){
        int del =  db.delete("tech_skills","EMAIL = ? and PASSWORD = ? and SKILL = ? and CAPABILITY = ? and CAPABILITY_ID = ?",new String[]{email,password,skill,capability,Integer.toString(capability_id)});
        return del;
    }

    public int work_delete_all(String email){
        int del =  db.delete("work","EMAIL = ?",new String[]{email});
        return del;
    }

    public int volunteer_delete(String email,String password,String activity,String start_month, int start_month_id,String start_year, int start_year_id,String end_month, int end_month_id,String end_year, int end_year_id){
        int del =  db.delete("volunteer","EMAIL = ? and PASSWORD = ? and ACTIVITY = ? and START_MONTH = ? and START_MONTH_ID = ? and START_YEAR = ? and START_YEAR_ID = ? and END_MONTH = ? and END_MONTH_ID = ? and END_YEAR = ? and END_YEAR_ID = ?",new String[]{email,password,activity,start_month,Integer.toString(start_month_id),start_year,Integer.toString(start_year_id),end_month,Integer.toString(end_month_id),end_year,Integer.toString(end_year_id)});
        return del;
    }

    public int volunteer_delete_all(String email){
        int del =  db.delete("volunteer","EMAIL = ?",new String[]{email});
        return del;
    }

    public int extra_delete(String email,String password,String activity,String start_month, int start_month_id,String start_year, int start_year_id,String end_month, int end_month_id,String end_year, int end_year_id){
        int del =  db.delete("extra","EMAIL = ? and PASSWORD = ? and ACTIVITY = ? and START_MONTH = ? and START_MONTH_ID = ? and START_YEAR = ? and START_YEAR_ID = ? and END_MONTH = ? and END_MONTH_ID = ? and END_YEAR = ? and END_YEAR_ID = ?",new String[]{email,password,activity,start_month,Integer.toString(start_month_id),start_year,Integer.toString(start_year_id),end_month,Integer.toString(end_month_id),end_year,Integer.toString(end_year_id)});
        return del;
    }


    public int extra_delete_all(String email){
        int del =  db.delete("extra","EMAIL = ?",new String[]{email});
        return del;
    }

    public int blocked_delete_all1(String email){
        int del =  db.delete("blocked","EMAIL = ?",new String[]{email});
        return del;
    }

    public int blocked_delete_all2(String email){
        int del =  db.delete("blocked","BLOCKED_EMAIL = ?",new String[]{email});
        return del;
    }


    public int report_delete_all1(String email){
        int del =  db.delete("reports","EMAIL = ?",new String[]{email});
        return del;
    }

    public int report_delete_all2(String email){
        int del =  db.delete("reports","REPORTED_EMAIL = ?",new String[]{email});
        return del;
    }

    public Long data_insert(int id, String email, String password){
        ContentValues cv = new ContentValues();
        cv.put("ID",id);
        cv.put("EMAIL",email);
        cv.put("PASSWORD",password);

        Long check = db.insert("data_info",null,cv);
        return check;
    }
    public Cursor profile_request_last_id(){
        Cursor req = db.rawQuery("select ID from profile_info order by ID desc limit 1",null);
        return req;
    }
    public Cursor page_info_request_last_id(){
        Cursor req = db.rawQuery("select ID from page_info order by ID desc limit 1",null);
        return req;
    }
    public Cursor comm_reply_request_last_id(){
        Cursor req = db.rawQuery("select ID from comm_reply_info order by ID desc limit 1",null);
        return req;
    }


    public Long profile_insert(String email, String password){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",email);
        cv.put("PASSWORD",password);
        Long check = db.insert("profile_info",null,cv);
        return check;
    }

    public Long comm_reply_insert(String email, String password, String type,int post_id){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",email);
        cv.put("PASSWORD",password);
        cv.put("TYPE",type);
        cv.put("POST_ID",post_id);
        Long check = db.insert("comm_reply_info",null,cv);
        return check;
    }

    public Cursor profile_request(){
        Cursor req = db.rawQuery("select * from profile_info",null);
        return req;
    }
    public Cursor comm_reply_request(){
        Cursor req = db.rawQuery("select * from comm_reply_info",null);
        return req;
    }
    public Boolean profile_update(String EMAIL,String PASSWORD){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        cv.put("PASSWORD",PASSWORD);
        db.update("profile_info",cv,"EMAIL = ?",new String[]{EMAIL});
        return true;
    }
    public int profile_delete_all(){
        int del =  db.delete("profile_info",null,null);
        return del;
    }

   public int profile_info_delete(){
       int id = 1;
       Cursor check = profile_request_last_id();
       if(check.getCount()>0){
           check.moveToFirst();
           id = check.getInt(0);
       }
       int del =  db.delete("profile_info","ID = ?",new String[]{Integer.toString(id)});
       return del;
   }

    public int comm_reply_info_delete(){
        int id = 1;
        Cursor check = comm_reply_request_last_id();
        if(check.getCount()>0){
            check.moveToFirst();
            id = check.getInt(0);
        }
        int del =  db.delete("comm_reply_info","ID = ?",new String[]{Integer.toString(id)});
        return del;
    }

    public Long page_info_insert(String admin, String page_id){
        ContentValues cv = new ContentValues();
        cv.put("ADMIN",admin);
        cv.put("PAGE_ID",page_id);
        Long check = db.insert("page_info",null,cv);
        return check;
    }

   public Cursor page_info_request(){
        Cursor req = db.rawQuery("select * from page_info",null);
        return req;
    }


    public Boolean page_info_update(String admin,String page_id){
        ContentValues cv = new ContentValues();
        cv.put("ADMIN",admin);
        cv.put("PAGE_ID",page_id);
        db.update("page_info",cv,"ADMIN = ?",new String[]{admin});
        return true;
    }

    public int page_info_delete_all(){
        int del =  db.delete("page_info",null,null);
        return del;
    }

    public int all_locations_delete_all(){
        int del =  db.delete("all_locations",null,null);
        return del;
    }


    public int page_info_delete(){
        int id = 1;
        Cursor check = page_info_request_last_id();
        if(check.getCount()>0){
            check.moveToFirst();
            id = check.getInt(0);
        }
        int del =  db.delete("page_info","ID = ?",new String[]{Integer.toString(id)});
        return del;
    }

    public Boolean nick_name_update(String email,String nick_name){
        ContentValues cv = new ContentValues();
        cv.put("NICK_NAME",nick_name);
        db.update("account_info",cv,"EMAIL = ?",new String[]{email});
        return true;
    }

    public Boolean pages_update_admins(String page_name,String page_id,String page_type){
        ContentValues cv = new ContentValues();
        cv.put("PAGE_NAME",page_name);
        cv.put("PAGE_ID",page_id);
        cv.put("PAGE_TYPE",page_type);
        db.update("page_admins",cv,"PAGE_ID = ?",new String[]{page_id});
        return true;
    }

    public int data_delete(String id){
        int del =  db.delete("data_info","ID = ?",new String[]{id});
        return del;
    }
    public Cursor data_request(){
        Cursor req = db.rawQuery("select * from data_info",null);
        return req;
    }

    public Boolean data_update(String EMAIL,String PASSWORD){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        cv.put("PASSWORD",PASSWORD);
        db.update("data_info",cv,"EMAIL = ?",new String[]{EMAIL});
        return true;
    }

    public Boolean edu_update(String EMAIL,String PASSWORD){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        cv.put("PASSWORD",PASSWORD);
        db.update("education_tab",cv,"EMAIL = ?",new String[]{EMAIL});
        return true;
    }

    public Boolean ter_edu_update(String EMAIL,String PASSWORD){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        cv.put("PASSWORD",PASSWORD);
        db.update("tertiary_education",cv,"EMAIL = ?",new String[]{EMAIL});
        return true;
    }

    public Boolean profile_info_update(String EMAIL,String PASSWORD){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        cv.put("PASSWORD",PASSWORD);
        db.update("profile_info",cv,"EMAIL = ?",new String[]{EMAIL});
        return true;
    }

    public Boolean tech_skills_update(String EMAIL,String PASSWORD){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        cv.put("PASSWORD",PASSWORD);
        db.update("tech_skills",cv,"EMAIL = ?",new String[]{EMAIL});
        return true;
    }

    public Boolean personal_skills_update(String EMAIL,String PASSWORD){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        cv.put("PASSWORD",PASSWORD);
        db.update("personal_skills",cv,"EMAIL = ?",new String[]{EMAIL});
        return true;
    }
    public Boolean interests_update(String EMAIL,String PASSWORD){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        cv.put("PASSWORD",PASSWORD);
        db.update("interests",cv,"EMAIL = ?",new String[]{EMAIL});
        return true;
    }
    public Boolean industries_update(String EMAIL,String PASSWORD){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        cv.put("PASSWORD",PASSWORD);
        db.update("industries",cv,"EMAIL = ?",new String[]{EMAIL});
        return true;
    }
    public Boolean state_update(String EMAIL,String PASSWORD){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        cv.put("PASSWORD",PASSWORD);
        db.update("state",cv,"EMAIL = ?",new String[]{EMAIL});
        return true;
    }
    public Boolean company_filter_update(String EMAIL,String PASSWORD){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        cv.put("PASSWORD",PASSWORD);
        db.update("company_filter",cv,"EMAIL = ?",new String[]{EMAIL});
        return true;
    }
    public Boolean explore_filter_update(String EMAIL,String PASSWORD){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        cv.put("PASSWORD",PASSWORD);
        db.update("explore_filter",cv,"EMAIL = ?",new String[]{EMAIL});
        return true;
    }
    public Boolean popular_filter_update(String EMAIL,String PASSWORD){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        cv.put("PASSWORD",PASSWORD);
        db.update("popular_filter",cv,"EMAIL = ?",new String[]{EMAIL});
        return true;
    }
    public Boolean job_filter_update(String EMAIL,String PASSWORD){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        cv.put("PASSWORD",PASSWORD);
        db.update("job_filter",cv,"EMAIL = ?",new String[]{EMAIL});
        return true;
    }
    public Boolean talents_filter_update(String EMAIL,String PASSWORD){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        cv.put("PASSWORD",PASSWORD);
        db.update("talents_filter",cv,"EMAIL = ?",new String[]{EMAIL});
        return true;
    }
    public Boolean top_deliverer_filter_update(String EMAIL,String PASSWORD){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        cv.put("PASSWORD",PASSWORD);
        db.update("top_deliverer_filter",cv,"EMAIL = ?",new String[]{EMAIL});
        return true;
    }

    public Boolean school_filter_update(String EMAIL,String PASSWORD){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        cv.put("PASSWORD",PASSWORD);
        db.update("school_filter",cv,"EMAIL = ?",new String[]{EMAIL});
        return true;
    }
    public Boolean delivery_review_filter_update(String EMAIL,String DELIVERER,String category,int cno){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        cv.put("DELIVERER",DELIVERER);
        cv.put("CATEGORY",category);
        cv.put("CNO",cno);
        db.update("delivery_review_filter",cv,"EMAIL = ? and DELIVERER = ?",new String[]{EMAIL,DELIVERER});
        return true;
    }
    public Boolean profile_filter_update(String EMAIL,String PASSWORD){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        cv.put("PASSWORD",PASSWORD);
        db.update("profile_filter",cv,"EMAIL = ?",new String[]{EMAIL});
        return true;
    }
    public Boolean tech_cert_update(String EMAIL,String PASSWORD){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        cv.put("PASSWORD",PASSWORD);
        db.update("tech_cert",cv,"EMAIL = ?",new String[]{EMAIL});
        return true;
    }
    public Boolean language_update(String EMAIL,String PASSWORD){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        cv.put("PASSWORD",PASSWORD);
        db.update("language",cv,"EMAIL = ?",new String[]{EMAIL});
        return true;
    }
    public Boolean work_update(String EMAIL,String PASSWORD){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        cv.put("PASSWORD",PASSWORD);
        db.update("work",cv,"EMAIL = ?",new String[]{EMAIL});
        return true;
    }
    public Boolean volunteer_update(String EMAIL,String PASSWORD){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        cv.put("PASSWORD",PASSWORD);
        db.update("volunteer",cv,"EMAIL = ?",new String[]{EMAIL});
        return true;
    }
    public Boolean extra_update(String EMAIL,String PASSWORD){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        cv.put("PASSWORD",PASSWORD);
        db.update("extra",cv,"EMAIL = ?",new String[]{EMAIL});
        return true;
    }

    public Boolean comm_reply_info_update(String EMAIL,String PASSWORD){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        cv.put("PASSWORD",PASSWORD);
        db.update("comm_reply_info",cv,"EMAIL = ?",new String[]{EMAIL});
        return true;
    }

    public Boolean temporary_admin_update(String EMAIL,String PASSWORD){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        cv.put("PASSWORD",PASSWORD);
        db.update("temporary_admin",cv,"EMAIL = ?",new String[]{EMAIL});
        return true;
    }

    public Boolean page_admins_update(String EMAIL,String PASSWORD){
        ContentValues cv = new ContentValues();
        cv.put("ADMIN",EMAIL);
        cv.put("PASSWORD",PASSWORD);
        db.update("page_admins",cv,"ADMIN = ?",new String[]{EMAIL});
        return true;
    }

    public Boolean data_update2(String EMAIL,String PASSWORD,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        cv.put("PASSWORD",PASSWORD);
        db.update("data_info",cv,"EMAIL = ?",new String[]{old_email});
        return true;
    }
    public Boolean data_updatee(String email,String EMAIL,String PASSWORD){
        ContentValues cv = new ContentValues();
        cv.put("EMAIL",EMAIL);
        cv.put("PASSWORD",PASSWORD);
        db.update("data_info",cv,"EMAIL = ?",new String[]{email});
        return true;
    }

    public Long account_insert( String fullname,String email, String password,byte[]image){
        ContentValues cv = new ContentValues();
        cv.put("FULLNAME",fullname);
        cv.put("EMAIL",email);
        cv.put("PASSWORD",password);
        cv.put("IMAGE",image);
        Long check = db.insert("account",null,cv);
        return check;
    }

    public Long temp_admin_insert( String fullname,String email, String password,byte[]image){
        ContentValues cv = new ContentValues();
        cv.put("FULLNAME",fullname);
        cv.put("EMAIL",email);
        cv.put("PASSWORD",password);
        cv.put("IMAGE",image);
        cv.put("STATUS","unsaved");
        Long check = db.insert("temporary_admin",null,cv);
        return check;
    }

    public int temp_admin_delete_all(){
        int del =  db.delete("temporary_admin",null,null);
        return del;
    }

    public int temp_admin_delete(String email){
        int del =  db.delete("temporary_admin","EMAIL = ?",new String[]{email});
        return del;
    }

    public Cursor temp_admin_request(){
        Cursor req = db.rawQuery("select * from temporary_admin",null);
        return req;
    }

    public Cursor temp_admin_request_email(String EMAIL){
        Cursor see = db.rawQuery("select * from temporary_admin where EMAIL = '"+EMAIL+"'",null);
        return see;
    }

    public Cursor deliverers_request_email(String EMAIL,String PAGE_ID){
        Cursor see = db.rawQuery("select * from deliverers where DELIVERER = '"+EMAIL+"' and PAGE_ID = '"+PAGE_ID+"'",null);
        return see;
    }

    public Cursor deliverers_request_all(String PAGE_ID){
        Cursor see = db.rawQuery("select * from deliverers where PAGE_ID = '"+PAGE_ID+"'",null);
        return see;
    }

    public Cursor temp_admin_request_status(String STATUS){
        Cursor see = db.rawQuery("select * from temporary_admin where STATUS = '"+STATUS+"'",null);
        return see;
    }

    public Cursor account_request(){
        Cursor req = db.rawQuery("select * from account",null);
        return req;
    }

    public int account_delete_all(){
        int del =  db.delete("account",null,null);
        return del;
    }


    public int orgschool_delete_all(){
        int del =  db.delete("organized_school",null,null);
        return del;
    }

    public int orgcompany_delete_all(){
        int del =  db.delete("organized_company",null,null);
        return del;
    }

    public int orgtopdel_delete_all(){
        int del =  db.delete("organized_top_deliverers",null,null);
        return del;
    }

    public Cursor account_request_account(String EMAIL,String PASSWORD){
        Cursor see = db.rawQuery("select * from account where EMAIL = '"+EMAIL+"' and PASSWORD = '"+PASSWORD+"'",null);
        return see;
    }

    public Cursor account_request_email(String EMAIL){
        Cursor see = db.rawQuery("select * from account where EMAIL = '"+EMAIL+"'",null);
        return see;
    }

    public int account_delete(String email){
        int del =  db.delete("account","EMAIL = ?",new String[]{email});
        return del;
    }

    public int your_page_delete(String email,String page_id){
        int del =  db.delete("your_page","EMAIL = ? and PAGE_ID = ?",new String[]{email,page_id});
        return del;
    }

    public int page_info_delete_all2(String page_id){
        int del =  db.delete("page_info","PAGE_ID = ?",new String[]{page_id});
        return del;
    }

    public int page_admins_delete_all2(String page_id){
        int del =  db.delete("page_admins","PAGE_ID = ?",new String[]{page_id});
        return del;
    }

    public int delivery_info_delete_all(String page_id){
        int del =  db.delete("delivery_info_ter","PAGE_ID = ?",new String[]{page_id});
        return del;
    }

    public int brand_delete_all(String page_id){
        int del =  db.delete("brand","PAGE_ID = ?",new String[]{page_id});
        return del;
    }


    public int blocked_delete_all3(String page_id){
        int del =  db.delete("blocked","BLOCKED_PAGE_ID = ?",new String[]{page_id});
        return del;
    }


    public int report_delete_all3(String page_id){
        int del =  db.delete("reports","REPORTED_PAGE_ID = ?",new String[]{page_id});
        return del;
    }


    public int brand_temp_delete_all(String page_id){
        int del =  db.delete("brand_temp","PAGE_ID = ?",new String[]{page_id});
        return del;
    }
    public int logo_pic_delete_all(String page_id){
        int del =  db.delete("logo_pic","PAGE_ID = ?",new String[]{page_id});
        return del;
    }
    public int logo_pic_temp_delete_all(String page_id){
        int del =  db.delete("logo_pic_temp","PAGE_ID = ?",new String[]{page_id});
        return del;
    }
    public int brand_pic_delete_all(String page_id){
        int del =  db.delete("brand_pic","PAGE_ID = ?",new String[]{page_id});
        return del;
    }
    public int brand_pic_temp_delete_all(String page_id){
        int del =  db.delete("brand_pic_temp","PAGE_ID = ?",new String[]{page_id});
        return del;
    }
    public int reseller_delete_all2(String page_id){
        int del =  db.delete("reseller","PAGE_ID = ?",new String[]{page_id});
        return del;
    }
    public int reseller_temp_delete_all2(String page_id){
        int del =  db.delete("reseller_temp","PAGE_ID = ?",new String[]{page_id});
        return del;
    }
    public int brand_partner_delete_all(String page_id){
        int del =  db.delete("brand_partner","PAGE_ID = ?",new String[]{page_id});
        return del;
    }
    public int brand_partner_temp_delete_all(String page_id){
        int del =  db.delete("brand_partner_temp","PAGE_ID = ?",new String[]{page_id});
        return del;
    }
    public int brand_manufacturer_delete_all(String page_id){
        int del =  db.delete("brand_manufacturer","PAGE_ID = ?",new String[]{page_id});
        return del;
    }
    public int brand_manufacturer_temp_delete_all(String page_id){
        int del =  db.delete("brand_manufacturer_temp","PAGE_ID = ?",new String[]{page_id});
        return del;
    }
    public int brand_distributor_delete_all(String page_id){
        int del =  db.delete("brand_distributor","PAGE_ID = ?",new String[]{page_id});
        return del;
    }
    public int brand_distributor_temp_delete_all(String page_id){
        int del =  db.delete("brand_distributor_temp","PAGE_ID = ?",new String[]{page_id});
        return del;
    }

    public int page_associates_delete_all2(String page_id){
        int del =  db.delete("page_associates","PAGE_ID = ?",new String[]{page_id});
        return del;
    }

    public int page_review_delete_all(int page_id){
        int del =  db.delete("page_review","PAGE_ID = ?",new String[]{Integer.toString(page_id)});
        return del;
    }

    public int your_page_delete2(String page_id){
        int del =  db.delete("your_page","PAGE_ID = ?",new String[]{page_id});
        return del;
    }

    public int delivery_info_ter_del(String territory,String page_id){
        int del =  db.delete("delivery_info_ter","TERRITORY = ? and PAGE_ID = ?",new String[]{territory,page_id});
        return del;
    }

   /* public int your_page_delete(String email,String page_id){
        int del =  db.delete("your_page","EMAIL = ? and PAGE_ID = ?",new String[]{email,page_id});
        return del;
    }
*/
    public Boolean account_update_profile(String fullname,byte[]image, String email){
        ContentValues cv = new ContentValues();
        cv.put("FULLNAME",fullname);
        cv.put("IMAGE",image);
        cv.put("EMAIL",email);
        db.update("account",cv,"EMAIL = ?",new String[]{email});
        return true;
    }

    public Boolean account_update_password(String password, String email){
        ContentValues cv = new ContentValues();
        cv.put("PASSWORD",password);
        cv.put("EMAIL",email);
        db.update("account",cv,"EMAIL = ?",new String[]{email});
        return true;
    }

    public Boolean account_update_email(String password, String email,String old_email){
        ContentValues cv = new ContentValues();
        cv.put("PASSWORD",password);
        cv.put("EMAIL",email);
        db.update("account",cv,"EMAIL = ?",new String[]{old_email});
        return true;
    }

}
