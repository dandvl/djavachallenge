package com.example.deltajavachallenge.network;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.deltajavachallenge.data.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebService {

    private static WebService instance;
    private PostService postService;

    public synchronized static WebService getInstance(){
        if(instance == null){
            instance = new WebService();
        }
        return instance;
    }

    public WebService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        postService  = retrofit.create(PostService.class);
    }


    public LiveData<List<Post>> allPosts(){
        final MutableLiveData<List<Post>> posts = new MutableLiveData<>();
        postService.all().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                posts.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                posts.setValue(null);
            }
        });
        return posts;
    }

}
