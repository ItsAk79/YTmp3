package com.example.project;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder>  {


    private Context context;
    private List<Datum> datums;

    //imagelistener define
    private OnImageClickListener onImageClickListener;

    //3rd argument is listener
    public SongAdapter(Context context, List<Datum> datums, OnImageClickListener onImageClickListener) {
        this.context = context;
        this.datums = datums;
        this.onImageClickListener = onImageClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Datum datum = datums.get(position);

        Glide.with(context).load(datums.get(position).getThumbnail()).into(holder.thumbnail);

        holder.title.setText(datum.getTitle());
        holder.artist.setText(datum.getArtist());
       // holder.duration.setText(datum.getDuration());
        holder.duration.setText(Integer.toString(datum.getDuration()));

        //imageview interface pass
        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onImageClickListener.onImageClick(datum.getUrl());
                onImageClickListener.onImageClick(datum.getThumbnail());

            }
        });
    }

    @Override
    public int getItemCount() {
        return datums.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView thumbnail;
        TextView title;
        TextView artist;
        TextView duration;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
            title = (TextView) itemView.findViewById(R.id.title);
            artist = (TextView) itemView.findViewById(R.id.artist);
            duration = (TextView) itemView.findViewById(R.id.duration);
        }
    }
}

