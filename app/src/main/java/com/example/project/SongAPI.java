package com.example.project;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class SongAPI {

    private static final String url = "http://192.168.1.5:57621/";

    public static GetResult getResult = null;

    public static GetResult getResult(){

        if(getResult == null)
        {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            getResult = retrofit.create(GetResult.class);
        }
        return getResult;
    }

    public interface GetResult{

        @GET("/")
        Call<SongList> getSongList();

    }



}
