package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class exoplayer extends AppCompatActivity {

    private PlayerView playerView;
    private SimpleExoPlayer simpleExoPlayer;
    String url1="";

    ImageView thumb;
    TextView link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exoplayer);

        thumb = findViewById(R.id.thumb);
        link = findViewById(R.id.link);

        String image = getIntent().getStringExtra("image");
        String url = getIntent().getStringExtra("url");

        link.setText(url);
        Glide.with(this).asBitmap().load(image).into(thumb);
        initializeplayer();
    }

    public void initializeplayer(){

        playerView = findViewById(R.id.exo);
        simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(this);
        playerView.setPlayer(simpleExoPlayer);

        DataSource.Factory datasourcefactory = new DefaultDataSourceFactory(this,
                Util.getUserAgent(this, "appname"));

        MediaSource mediaSource = new ExtractorMediaSource.Factory(datasourcefactory)
                .createMediaSource(Uri.parse(url1));
        simpleExoPlayer.prepare(mediaSource);
        simpleExoPlayer.setPlayWhenReady(true);
    }

}
