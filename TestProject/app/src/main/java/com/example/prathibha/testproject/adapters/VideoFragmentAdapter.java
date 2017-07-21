package com.example.prathibha.testproject.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prathibha.testproject.R;
import com.example.prathibha.testproject.model.Actor;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;



public class VideoFragmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    public List<Actor> actorsList;
    private Context context;

    public VideoFragmentAdapter(Context context, List<Actor> activitiesList) {

        actorsList = activitiesList;
        this.context = context;


    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.actor_list_item, parent, false);
            return new ItemViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
       ItemViewHolder itemHolder = (ItemViewHolder) holder;
        Actor actor = actorsList.get(position);
        itemHolder.titleTextView.setText(actor.title);
        Picasso.with(context).load(actor.imageId).resize(100, 100).into(itemHolder.imageView);
        itemHolder.dateTextView.setText(actor.duration);

    }



    @Override
    public int getItemCount() {

        return actorsList.size();
    }

    // inner class to hold a reference to each item of RecyclerView
    private class ItemViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView titleTextView;
        public TextView descriptionTextView;
        public TextView dateTextView;


        public ItemViewHolder(View itemLayoutView) {
            super(itemLayoutView);

            dateTextView = (TextView)itemLayoutView.findViewById(R.id.time_text);
            imageView = (ImageView)itemLayoutView.findViewById(R.id.actor_image_view);
            titleTextView = (TextView)itemLayoutView.findViewById(R.id.title_text);

        }

    }





}
