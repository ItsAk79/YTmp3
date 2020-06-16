package com.example.project;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class SongAPI {

    private static final String url = "https://ytmp3web.herokuapp.com/";

    public static GetResult getResult = null;

    public static GetResult getResult(){

        if(getResult == null)
        {
            OkHttpClient.Builder client = new OkHttpClient.Builder();
            client.connectTimeout(40, TimeUnit.SECONDS);
            client.readTimeout(40, TimeUnit.SECONDS);
            client.writeTimeout(40, TimeUnit.SECONDS);


            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client.build())
                    .build();

            getResult = retrofit.create(GetResult.class);
        }
        return getResult;
    }

    public interface GetResult{

        @GET("/")
        Call<SongList> getSongList(@Query("query") String query, @Query("count") Integer count);

    }



}
