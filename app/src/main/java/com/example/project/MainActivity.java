package com.example.project;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements OnImageClickListener{

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private EditText mQueryEt;

    private List<Listsong> listsongs;

    private SongAdapter mSongAdapter;

    private List<Datum> mDatumList;

    private final String TAG = "MainActivityTag";

    private ProgressDialog progress;

    //exoplayer variable declaration
    //private PlayerView playerView;
   // private SimpleExoPlayer simpleExoPlayer;
   // private String url = "https://r1---sn-p5qs7nel.googlevideo.com/videoplayback?expire=1587568127&ei=nwmgXq7OI4ekhwayt7qgBA&ip=34.234.97.230&id=o-AEJvoY2enz1G5oujktqiJnlIa2od54JOR6SJkuoxeNAD&itag=251&source=youtube&requiressl=yes&mh=3a&mm=31%2C29&mn=sn-p5qs7nel%2Csn-p5qlsnd6&ms=au%2Crdu&mv=m&mvi=0&pl=18&initcwndbps=702500&vprv=1&mime=audio%2Fwebm&gir=yes&clen=2738928&dur=177.201&lmt=1550692681169900&mt=1587546458&fvip=1&keepalive=yes&fexp=23882514&c=WEB&txp=5511222&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cgir%2Cclen%2Cdur%2Clmt&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=ALrAebAwRAIgUoBg4RWahAM1k_gHyWWd4kIVTkQLq7Yl-AnfUYgqXt0CICxNPeKouefjg06eUPKXHAFAQN7yIkPvEyeBfuOn2LNk&sig=AJpPlLswRQIgMLGo7bWvYDaXEhQlC2iyGeOoF6KuEEmDIBC_6GlEFXcCIQD7rOtgLW2vuo3WP32pslCb77GoXpk4gNd7TjUcF0HiaA%3D%3D&ratebypass=yes";


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mDatumList = new ArrayList<>();
        mQueryEt = findViewById(R.id.query_et);

        //exoplayer init method called
        //initializeplayer();


        mQueryEt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if(event.getAction() == MotionEvent.ACTION_UP) {
                    if(event.getRawX() >= (mQueryEt.getRight() - mQueryEt.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        // Show loader/progress
                        progress = new ProgressDialog(MainActivity.this);
                        progress.setMessage("Wait a Moment....");
                        progress.show();

                        getData(mQueryEt.getText().toString(),10);
                        return true;
                    }
                }
                return false;
            }
        });


        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mSongAdapter = new SongAdapter(MainActivity.this, mDatumList,this);//3rd argument is listener
        recyclerView.setAdapter(mSongAdapter);


    }

    void getData(String query, Integer count)
    {
        final Call<SongList> songlist = SongAPI.getResult().getSongList(query,count);
        songlist.enqueue(new Callback<SongList>() {
            @Override
            public void onResponse(Call<SongList> call, Response<SongList> response) {
                SongList songList = response.body();

                for(Datum mdat: songList.getData()){
                    Log.d(TAG,mdat.getTitle());
                }

                mDatumList.removeAll(mDatumList);
                mDatumList.addAll(songList.getData());
                mSongAdapter.notifyDataSetChanged();
                // Hide loader/progress
                progress.dismiss();
                Toast.makeText(getApplicationContext(),"SUCCESS",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<SongList> call, Throwable t) {
                //Hide loader/progress
                progress.dismiss();
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                Log.e(TAG,t.getMessage(),t);
            }
        });
    }

    //exoplayer methods from here
    /*public void initializeplayer(){


        playerView = findViewById(R.id.exo);
        simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(this);
        playerView.setPlayer(simpleExoPlayer);
        DataSource.Factory datasourcefactory = new DefaultDataSourceFactory(this,
                Util.getUserAgent(this, "appname"));

        MediaSource mediaSource = new ExtractorMediaSource.Factory(datasourcefactory)
                .createMediaSource(Uri.parse(url));
        simpleExoPlayer.prepare(mediaSource);
        simpleExoPlayer.setPlayWhenReady(true);
    }

    @Override
    protected void onStop() {
        super.onStop();
        simpleExoPlayer.release();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        initializeplayer();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        simpleExoPlayer.release();
    }*/


    //imageclick listener
    @Override
    public void onImageClick(String imageData) {

        Intent i = new Intent(MainActivity.this,exoplayer.class);
        i.putExtra("image", imageData);
        i.putExtra("url", imageData);
        startActivity(i);

    }
}