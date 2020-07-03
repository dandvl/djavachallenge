package com.example.deltajavachallenge.mvvm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.deltajavachallenge.data.Post;
import com.example.deltajavachallenge.repository.PostRepository;

import java.util.List;

public class PostViewModel extends ViewModel {

    public LiveData<List<Post>> postLD;
    private PostRepository repository;

    public PostViewModel() {
        this.repository = new PostRepository();
        loadPosts();
    }

    private void loadPosts() {
        postLD = repository.all();
    }


}
