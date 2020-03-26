package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private List<Listsong> listsongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setLayoutManager(new GridLayoutManager(this,2, GridLayoutManager.VERTICAL, false));

        /*listsongs = new ArrayList<>();

        listsongs.add(new Listsong("https://i.ytimg.com/vi/m_SSr-tbY_M/maxresdefault.jpg",
                "talobrothers - Summer Air",
                "ItaloBrothers",
                "191"
        ));

        listsongs.add(new Listsong("https://i.ytimg.com/vi/m_SSr-tbY_M/maxresdefault.jpg",
                "Italobrothers - Summer Air (Official Video) [Ultra Music]",
                "ItaloBrothers",
                "191"
                ));
        listsongs.add(new Listsong("https://i.ytimg.com/vi/3nLA-X54o0c/hqdefault.jpg",
                "ItaloBrothers - Summer Air (DJ Gollum feat. DJ Cap UK Remix Video Edit)",
                "ItaloBrothers",
                "208"
                ));
        listsongs.add(new Listsong("https://i.ytimg.com/vi/3nLA-X54o0c/hqdefault.jpg",
                "ItaloBrothers - Summer Air (DJ Gollum feat. DJ Cap UK Remix Video Edit)",
                "ItaloBrothers",
                "208"
                ));
        listsongs.add(new Listsong("https://i.ytimg.com/vi/ivCQvpaCmI4/hqdefault.jpg",
                "Italobrothers - Summer Air [ Lyrics ]",
                "ItaloBrothers",
                "190"
                ));



        adapter = new Myadapter(listsongs,this);
        recyclerView.setAdapter(adapter);*/

      getData();

    }

    void getData()
    {
        Call<SongList> songlist = SongAPI.getResult().getSongList();
        songlist.enqueue(new Callback<SongList>() {
            @Override
            public void onResponse(Call<SongList> call, Response<SongList> response) {

                SongList list = response.body();
                recyclerView.setAdapter(new SongAdapter(MainActivity.this, list.getData()));
                Toast.makeText(getApplicationContext(),"SUCCESS",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<SongList> call, Throwable t) {

                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
