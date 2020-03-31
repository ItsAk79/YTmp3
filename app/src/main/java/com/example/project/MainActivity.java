package com.example.project;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private EditText mQueryEt;

    private List<Listsong> listsongs;

    private List<Datum> datumList;

    private SongAdapter mSongAdapter;

    private List<Datum> mDatumList;

    private final String TAG = "MainActivityTag";


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatumList = new ArrayList<>();
        mQueryEt = findViewById(R.id.query_et);


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

        mSongAdapter = new SongAdapter(MainActivity.this, mDatumList);
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
                Toast.makeText(getApplicationContext(),"SUCCESS",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<SongList> call, Throwable t) {
                //Hide loader/progress
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                Log.e(TAG,t.getMessage(),t);
            }
        });
    }
}
