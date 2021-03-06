package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHolder> {


    private List<Listsong> listsongs;
    private Context context;

    public Myadapter(List<Listsong> listsongs, Context context) {
        this.listsongs = listsongs;
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

        //Listitem listitem = listitems.get(position);
        Listsong listsong = listsongs.get(position);//this is from listsong java file


        Glide.with(context).load(listsongs.get(position).getThumbnail()).into(holder.thumbnail);

        holder.title.setText(listsong.getTitle());
        holder.artist.setText(listsong.getArtist());
        holder.duration.setText(listsong.getDuration());
    }

    @Override
    public int getItemCount() {

        return listsongs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        public ImageView thumbnail;
        public TextView title;
        public TextView artist;
        public TextView duration;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
            title = (TextView) itemView.findViewById(R.id.title);
            artist = (TextView) itemView.findViewById(R.id.artist);
            duration = (TextView) itemView.findViewById(R.id.duration);
        }
    }
}
