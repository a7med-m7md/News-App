package com.earthquake.newsapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsAdapter extends ArrayAdapter<Items> {
    public NewsAdapter(@NonNull Context context, ArrayList data) {
        super(context,0, data);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;


        if(view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.news,parent,false);
        }

        Items items = getItem(position);
        ImageView img_new = (ImageView)view.findViewById(R.id.new_img);
        Picasso.get().load(items.getImage()).into(img_new);

        TextView txt_new_title = (TextView)view.findViewById(R.id.new_title);
        txt_new_title.setText(items.getTitle());

        TextView txt_new_time = (TextView)view.findViewById(R.id.new_time);
        txt_new_time.setText(items.getTime());
        return view;
    }
}
