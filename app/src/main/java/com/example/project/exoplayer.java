package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.offline.DownloadService;
import com.google.android.exoplayer2.offline.ProgressiveDownloadAction;
import com.google.android.exoplayer2.source.ConcatenatingMediaSource;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.dash.DefaultDashChunkSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheDataSourceFactory;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class exoplayer extends AppCompatActivity {

    private PlayerView playerView;
    private SimpleExoPlayer simpleExoPlayer;
    String url;

    ImageView thumb;
    TextView head;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exoplayer);

        thumb = findViewById(R.id.thumb);
        head = findViewById(R.id.head);

        String image = getIntent().getStringExtra("image");
         url = getIntent().getStringExtra("url");
        String title = getIntent().getStringExtra("title");


        head.setText(title);
        Glide.with(this).asBitmap().load(image).into(thumb);

        //download
        head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressiveDownloadAction progressiveDownloadAction = new ProgressiveDownloadAction(Uri.parse(url),false,null, null);

                DownloadService.startWithAction(exoplayer.this, AudioDownloadService.class, progressiveDownloadAction,false);

                Toast.makeText(getApplicationContext(),"Downloading Started",Toast.LENGTH_SHORT).show();
            }
        });


        initializeplayer();

        //from file code


    }

    public void initializeplayer(){

        playerView = findViewById(R.id.exo);
        simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(this);
        playerView.setPlayer(simpleExoPlayer);

        /*
        String playerInfo = Util.getUserAgent(this, "ExoPlayerInfo");
        DefaultDataSourceFactory dataSourceFactory = new DefaultDataSourceFactory(
                this, playerInfo
        );
        MediaSource mediaSource = new ExtractorMediaSource.Factory(dataSourceFactory)
                .setExtractorsFactory(new DefaultExtractorsFactory())
                .createMediaSource(Uri.parse(url));
        simpleExoPlayer.prepare(mediaSource);*/



        DataSource.Factory datasourcefactory = new DefaultDataSourceFactory(this,
                Util.getUserAgent(this, "appname"));

       CacheDataSourceFactory cacheDataSourceFactory =  new CacheDataSourceFactory(DownloadUtil.getCache(this),datasourcefactory);


        ConcatenatingMediaSource concatenatingMediaSource = new ConcatenatingMediaSource();//

        MediaSource mediaSource = new ExtractorMediaSource.Factory(cacheDataSourceFactory )
                .setExtractorsFactory(new DefaultExtractorsFactory())
                .createMediaSource(Uri.parse(url));


        concatenatingMediaSource.addMediaSource(mediaSource);//

        simpleExoPlayer.prepare(mediaSource);
        simpleExoPlayer.setPlayWhenReady(true);




    }




    @Override
    protected void onPause() {
        super.onPause();
        simpleExoPlayer.setPlayWhenReady(false);
        simpleExoPlayer.getPlaybackState();
    }

    @Override
    protected void onResume() {
        super.onResume();
        simpleExoPlayer.setPlayWhenReady(true);
        simpleExoPlayer.getPlaybackState();
    }

    @Override
    protected void onStop() {
        super.onStop();
        simpleExoPlayer.release();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        simpleExoPlayer.release();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //simpleExoPlayer.setPlayWhenReady(true);
        //simpleExoPlayer.getPlaybackState();
        initializeplayer();
    }
}
