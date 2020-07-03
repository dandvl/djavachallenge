package com.example.deltajavachallenge.network;

import com.example.deltajavachallenge.data.Post;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PostService {

    @GET("posts")
    Call<List<Post>> all();
}
