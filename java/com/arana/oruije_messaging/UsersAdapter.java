package com.arana.oruije_messaging;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UsersAdapter extends ArrayAdapter<UsersModel> {
    protected LayoutInflater inflater;
    protected int layout;

    Session session;

    private ArrayList<UsersModel> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView name;
        TextView pos;
        TextView category;
        CircleImageView user_image;
        LinearLayout chat_row;
        ImageButton is_selected;
    }

    public UsersAdapter(ArrayList<UsersModel> data, Context context) {
        super(context, R.layout.start_chat_layout, data);
        this.dataSet = data;
        this.mContext=context;
    }

    private int lastPosition = -1;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        UsersModel UsersModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        final ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.start_chat_layout, parent, false);
            viewHolder.name = convertView.findViewById(R.id.name);
            viewHolder.pos = convertView.findViewById(R.id.position);
            viewHolder.category = convertView.findViewById(R.id.category);
            viewHolder.user_image = convertView.findViewById(R.id.user_image);

            viewHolder.chat_row = convertView.findViewById(R.id.row);
            viewHolder.is_selected = convertView.findViewById(R.id.is_selected);
            session = new Session(getContext());

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

//        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
//        result.startAnimation(animation);
//        lastPosition = position;

        viewHolder.name.setText(UsersModel.getName());
        viewHolder.pos.setText(UsersModel.getPosition());
        if (UsersModel.getCategory().equalsIgnoreCase("circle")){
            viewHolder.category.setTextColor(getContext().getResources().getColor(R.color.OruijeBlue));
            viewHolder.category.setBackground(getContext().getResources().getDrawable(R.drawable.pressed_circle));
            viewHolder.category.setPadding(10,2,10,2);
            viewHolder.category.setText(UsersModel.getCategory());
        }else if (UsersModel.getCategory().equalsIgnoreCase("Dinky")){
            viewHolder.category.setTextColor(getContext().getResources().getColor(R.color.OruijeGreen));
            viewHolder.category.setBackground(getContext().getResources().getDrawable(R.drawable.pressed_dinky));
            viewHolder.category.setPadding(10,2,10,2);
            viewHolder.category.setText(UsersModel.getCategory());
        }else if (UsersModel.getCategory().equalsIgnoreCase("Random") || UsersModel.getCategory().equalsIgnoreCase("Page")){
            viewHolder.category.setTextColor(getContext().getResources().getColor(R.color.white));
            viewHolder.category.setBackground(getContext().getResources().getDrawable(R.drawable.border));
            viewHolder.category.setPadding(10,2,10,2);
            viewHolder.category.setText(UsersModel.getCategory());
        }

        viewHolder.user_image.setImageBitmap(UsersModel.getUser_image());

        viewHolder.is_selected.setTag(position);
//        viewHolder.is_selected.setVisibility(View.VISIBLE);

        viewHolder.chat_row.setTag(position);
//        Log.i("the position","yoyo= "+position);
//
//        if (session.is_selected()){
//            ImageButton ib =(ImageButton)result.getTag(position);
//            if (ib.getVisibility() == View.VISIBLE){
////                Toast.makeText(getContext(), UsersModel.getName() + " selected "+String.valueOf(viewHolder.chat_row.getTag()), Toast.LENGTH_SHORT).show();
////                viewHolder.is_selected.setVisibility(View.INVISIBLE);
//                ib.setVisibility(View.INVISIBLE);
//            }else {
////                Toast.makeText(getContext(), UsersModel.getName() + " selected "+String.valueOf(viewHolder.chat_row.getTag()), Toast.LENGTH_SHORT).show();
////                viewHolder.is_selected.setVisibility(View.VISIBLE);
//                ib.setVisibility(View.VISIBLE);
//
//            }
//        }

//        viewHolder.is_selected.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int position=(Integer) v.getTag();
//                Object object= getItem(position);
//                UsersModel usersModel=(UsersModel)object;
//
//
//
////                switch (v.getId())
////                {
////                    case R.id.user_image:
////                        Snackbar.make(v, "Release date " + usersModel.getName(), Snackbar.LENGTH_LONG)
////                                .setAction("No action", null).show();
////                        break;
////                }
//
//            }
//        });

        // Return the completed view to render on screen
        return convertView;
    }
}
