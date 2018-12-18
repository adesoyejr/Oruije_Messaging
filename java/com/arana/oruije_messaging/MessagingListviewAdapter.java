package com.arana.oruije_messaging;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MessagingListviewAdapter extends ArrayAdapter<MessagingDataModel> implements View.OnClickListener {
    protected LayoutInflater inflater;
    protected int layout;

    private ArrayList<MessagingDataModel> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView name;
        TextView pos;
        TextView time;
        TextView super_button;
        TextView message;
        CircleImageView user_image;
    }

    public MessagingListviewAdapter(ArrayList<MessagingDataModel> data, Context context) {
        super(context, R.layout.messaging_listview_layout, data);
        this.dataSet = data;
        this.mContext=context;
    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        MessagingDataModel messagingDataModel=(MessagingDataModel)object;

        switch (v.getId())
        {
            case R.id.user_image:
                Snackbar.make(v, "Release date " + messagingDataModel.getName(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
                break;
        }
    }

    private int lastPosition = -1;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        MessagingDataModel MessagingDataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.messaging_listview_layout, parent, false);
            viewHolder.name = convertView.findViewById(R.id.name);
            viewHolder.pos = convertView.findViewById(R.id.position);
            viewHolder.time = convertView.findViewById(R.id.time);
            viewHolder.super_button = convertView.findViewById(R.id.super_button);
            viewHolder.message = convertView.findViewById(R.id.message);
            viewHolder.user_image = convertView.findViewById(R.id.user_image);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

//        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
//        result.startAnimation(animation);
//        lastPosition = position;

        viewHolder.name.setText(MessagingDataModel.getName());
        viewHolder.pos.setText(MessagingDataModel.getPosition());

//        String time = MessagingDataModel.getTime().substring(0,5);
//        String pm = MessagingDataModel.getTime().substring(8);
        viewHolder.time.setText(MessagingDataModel.getTime());

        if (MessagingDataModel.getSuper_button().equalsIgnoreCase("circle")){
            viewHolder.super_button.setTextColor(getContext().getResources().getColor(R.color.OruijeBlue));
            viewHolder.super_button.setBackground(getContext().getResources().getDrawable(R.drawable.pressed_circle));
            viewHolder.super_button.setPadding(10,2,10,2);
            viewHolder.super_button.setText(MessagingDataModel.getSuper_button());
        }else if (MessagingDataModel.getSuper_button().equalsIgnoreCase("Dinky")){
            viewHolder.super_button.setTextColor(getContext().getResources().getColor(R.color.OruijeGreen));
            viewHolder.super_button.setBackground(getContext().getResources().getDrawable(R.drawable.pressed_dinky));
            viewHolder.super_button.setPadding(10,2,10,2);
            viewHolder.super_button.setText(MessagingDataModel.getSuper_button());
        }else if (MessagingDataModel.getSuper_button().equalsIgnoreCase("Random") ||MessagingDataModel.getSuper_button().equalsIgnoreCase("Page")){
            viewHolder.super_button.setTextColor(getContext().getResources().getColor(R.color.white));
            viewHolder.super_button.setBackground(getContext().getResources().getDrawable(R.drawable.border));
            viewHolder.super_button.setPadding(10,2,10,2);
            viewHolder.super_button.setText(MessagingDataModel.getSuper_button());
        }
//        viewHolder.super_button.setText(MessagingDataModel.getSuper_button());
        viewHolder.message.setText(MessagingDataModel.getMessage());

        viewHolder.user_image.setImageBitmap(MessagingDataModel.getUser_image());


        viewHolder.message.setOnClickListener(this);
        viewHolder.message.setTag(position);
        // Return the completed view to render on screen
        return convertView;
    }
}
