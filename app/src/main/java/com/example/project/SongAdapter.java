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

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder>  {


    private Context context;
    private List<Datum> datums;

    public SongAdapter(Context context, List<Datum> datums) {
        this.context = context;
        this.datums = datums;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Datum datum = datums.get(position);

        Glide.with(context).load(datums.get(position).getThumbnail()).into(holder.thumbnail);

        holder.title.setText(datum.getTitle());
        holder.artist.setText(datum.getArtist());
        holder.duration.setText(datum.getDuration());

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
