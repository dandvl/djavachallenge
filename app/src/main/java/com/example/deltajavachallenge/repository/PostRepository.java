package com.example.deltajavachallenge.repository;


import androidx.lifecycle.LiveData;

import com.example.deltajavachallenge.data.Post;
import com.example.deltajavachallenge.network.WebService;
import java.util.List;

public class PostRepository {

    public LiveData<List<Post>> all(){
        return WebService.getInstance().allPosts();
    }

}
