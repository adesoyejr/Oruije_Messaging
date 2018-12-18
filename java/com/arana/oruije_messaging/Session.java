package com.arana.oruije_messaging;

import android.content.Context;
import android.content.*;

public class Session {
  SharedPreferences sp;
  SharedPreferences.Editor editor;
  Context context;

  public Session(Context context) {
    this.context = context;
    sp = context.getSharedPreferences("oruije",Context.MODE_PRIVATE);
    editor = sp.edit();
  }
  public void loggedin(Boolean state){
    editor.putBoolean("loggedinmode",state);
    editor.commit();
  }

  public void is_chat_selected(Boolean state){
    editor.putBoolean("chat_selected",state);
    editor.commit();
  }

  public Boolean is_selected(){
    return sp.getBoolean("chat_selected",false);
  }

  public Boolean notloggedin(){
    return sp.getBoolean("loggedinmode",false);
  }

  public void seen_tooltip(String seen){
    editor.putString("tooltipmode",seen);
    editor.commit();
  }

  public String unseen_tooltip(){
    return sp.getString("tooltipmode","");
  }
  public void setUserName(String uname){
    editor.putString("username",uname);
    editor.commit();
  }

  public String getUserName(){
    return sp.getString("usename","");
  }

  public void post_message(Boolean message_posted){
    editor.putBoolean("message_posted",message_posted);
    editor.commit();
  }

  public Boolean is_post_message(){
    return sp.getBoolean("message_posted",false);
  }

//    public void setMessagePrefs(String prefname, String value){
//        editor.putString(prefname,value);
//        editor.commit();
//    }
//
//    public String getMessagePrefs(String prefname){
//        return sp.getString(prefname,"");
//    }

  public void setUserId(String uid){
    editor.putString("user_id",uid);
    editor.commit();
  }

  public String getUserId(){
    return sp.getString("user_id","");
  }

  public void focus(String list){
    editor.putString("focusmode",list);
    editor.commit();
  }

  public void post_location(String status){
    editor.putString("post_location",status);
    editor.commit();
  }

  public String get_post_location(){
    return sp.getString("post_location","OFF");
  }

  public void comm_location(String status){
    editor.putString("comm_location",status);
    editor.commit();
  }

  public String get_comm_location(){
    return sp.getString("comm_location","OFF");
  }

  public void talent_location(String status){
    editor.putString("talent_location",status);
    editor.commit();
  }

  public String get_talent_location(){
    return sp.getString("talent_location","OFF");
  }

  public void talent_delete(String status){
    editor.putString("talent_delete",status);
    editor.commit();
  }

  public String get_talent_delete(){
    return sp.getString("talent_delete","NO");
  }

  public void send_post(String send){
    editor.putString("send_post",send);
    editor.commit();
  }

  public void refresh_clicked_post(String send){
    editor.putString("refresh",send);
    editor.commit();
  }

  public void refresh_position(int send){
    editor.putInt("position",send);
    editor.commit();
  }

  public void refresh_image(String status){
    editor.putString("status",status);
    editor.commit();
  }

  public String get_refresh_clicked_post(){
    return sp.getString("refresh","");
  }
  public String get_refresh_image(){
    return sp.getString("status","");
  }

  public int get_refresh_position(){
    return sp.getInt("position",-1);
  }

  public String get_send_post(){
    return sp.getString("send_post","");
  }

  public void send_page_post(String send){
    editor.putString("send_page_post",send);
    editor.commit();
  }

  public String get_send_page_post(){
    return sp.getString("send_page_post","");
  }

  public void focus2(String list){
    editor.putString("focusmode2",list);
    editor.commit();
  }

  public void delete(String text){
    editor.putString("status",text);
    editor.commit();
  }

  public String check_focus(){
    return sp.getString("focusmode",null);
  }

  public String check_focus2(){
    return sp.getString("focusmode2",null);
  }

  public String deleted(){
    return sp.getString("status",null);
  }



}
