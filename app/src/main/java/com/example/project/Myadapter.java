package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHolder> {


    private List<Listitem> listitems;
    private Context context;

    public Myadapter(List<Listitem> listitems, Context context) {
        this.listitems = listitems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Listitem listitem = listitems.get(position);

        holder.url.setText(listitem.getUrl());
        holder.title.setText(listitem.getTitle());
        holder.thumbnail.setText(listitem.getThumbnail());
        holder.artist.setText(listitem.getArtist());
        holder.duration.setText(listitem.getDuration());
    }

    @Override
    public int getItemCount() {
        return listitems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        public TextView url;
        public TextView title;
        public TextView thumbnail;
        public TextView artist;
        public TextView duration;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            url = (TextView) itemView.findViewById(R.id.url);
            title = (TextView) itemView.findViewById(R.id.title);
            thumbnail = (TextView) itemView.findViewById(R.id.thumbnail);
            artist = (TextView) itemView.findViewById(R.id.artist);
            duration = (TextView) itemView.findViewById(R.id.duration);
        }
    }
}
