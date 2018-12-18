package com.arana.oruije_messaging;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatListAdapter extends ArrayAdapter<ChatListModel> {
    protected LayoutInflater inflater;
    protected int layout;

    public static final int BY_ME = 1;
    public static final int NOT_BY_ME = 0;
    public static final int IMAGE_BY_ME = 11;
    public static final int IMAGE_NOT_BY_ME = 10;

    Session session;

    private ArrayList<ChatListModel> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView content, section_header, time_posted, image_caption;
//        RoundedImageView image_message;
        ImageView image_message;

        RelativeLayout date_header;
    }

    public ChatListAdapter(ArrayList<ChatListModel> data, Context context) {
        super(context, R.layout.chat_layout, data);
        this.dataSet = data;
        this.mContext=context;
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        ChatListModel ChatListModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder = null; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());

            if (getItemViewType(position) == BY_ME){  //posts by me
                convertView = inflater.inflate(R.layout.chat_layout, parent, false);
            }else if(getItemViewType(position) == NOT_BY_ME){ //posts by the other person
                convertView = inflater.inflate(R.layout.chat_layout_recipient, parent, false);
            }else if (getItemViewType(position) == IMAGE_BY_ME){ //image posts by me
                convertView = inflater.inflate(R.layout.image_chat_layout, parent, false);
            }else{  //image posts by the other person
                convertView = inflater.inflate(R.layout.image_chat_layout_recipient, parent, false);
            }


            if (getItemViewType(position) == BY_ME){
                viewHolder.content = convertView.findViewById(R.id.content_me);
                viewHolder.time_posted = convertView.findViewById(R.id.time_posted_me);
            }else if(getItemViewType(position) == NOT_BY_ME){
                viewHolder.content = convertView.findViewById(R.id.content_recipient);
                viewHolder.time_posted = convertView.findViewById(R.id.time_posted_recipient);
            }else if (getItemViewType(position) == IMAGE_BY_ME){ //image posts by me
                viewHolder.image_message = (ImageView) convertView.findViewById(R.id.image_message);
//                viewHolder.image_caption = convertView.findViewById(R.id.image_caption);
                viewHolder.time_posted = convertView.findViewById(R.id.time_posted_me);
            }else{  //image posts by the other person
                viewHolder.image_message = (ImageView) convertView.findViewById(R.id.image_message_recipient);
//                viewHolder.image_caption = convertView.findViewById(R.id.image_caption_recipient);
                viewHolder.time_posted = convertView.findViewById(R.id.time_posted_recipient);
            }

            viewHolder.date_header = (RelativeLayout) convertView.findViewById(R.id.date_header); //is included in all the layouts
            viewHolder.section_header = (TextView) convertView.findViewById(R.id.section_header); //is included in all the layouts

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        viewHolder = (ViewHolder)convertView.getTag();

        if (getItemViewType(position) == BY_ME || getItemViewType(position) ==  NOT_BY_ME) {
            viewHolder.content.setText(ChatListModel.getMessage());
            viewHolder.time_posted.setText(ChatListModel.getTime_posted());
        }else{
            if (ChatListModel.getImage_message() != null) { //check if image is not null
                initImageLoader();
                UniversalImageLoader.setImage(ChatListModel.getImage_message(),viewHolder.image_message,null,"");
//                viewHolder.image_message.setImageBitmap(ChatListModel.getImage_message());
            }

//            ChatListModel chatListModel = getItem(position);
            if (position>0) {
                if (dataSet.get(position).getDate_posted().equals(dataSet.get(position - 1).getDate_posted())) {
                    viewHolder.section_header.setText(ChatListModel.getDate_posted()); //sets the section date
                    viewHolder.date_header.setVisibility(View.VISIBLE);// makes the container visible
                }
            }
            viewHolder.time_posted.setText(ChatListModel.getTime_posted());
        }


        // Return the completed view to render on screen
        return convertView;
    }

    @Override
    public int getViewTypeCount() {
        return 4;
    }

    private void initImageLoader(){
        UniversalImageLoader universalImageLoader = new UniversalImageLoader(mContext);
        ImageLoader.getInstance().init(universalImageLoader.getConfig());
    }


    @Override
    public int getItemViewType(int position) {
        ChatListModel chatListModel = getItem(position);
        if (chatListModel.isHas_image().equalsIgnoreCase("true")){
            if (chatListModel.getAuthor_id().equalsIgnoreCase(chatListModel.getUser_id())){
                return IMAGE_BY_ME;
            }else{
                return IMAGE_NOT_BY_ME;
            }
        }else if(chatListModel.getAuthor_id().equalsIgnoreCase(chatListModel.getUser_id())){
            return BY_ME;
        }else{
            return  NOT_BY_ME;
        }
    }

//    async class
//    private static class ImageLoaderTask extends AsyncTask<ViewHolder, Void, Bitmap>{
//        private final ImageLoader imageLoader;
//        private int position;
//        private ViewHolder v;
//
//        private ImageLoaderTask(Ima)
//
//    @Override
//    protected Bitmap doInBackground(ViewHolder... viewHolders) {
//        return null;
//    }
//}
}
