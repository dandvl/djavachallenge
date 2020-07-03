package com.example.deltajavachallenge.data;

public class Post {

    public Integer userId;
    public Integer id;
    public String title;
    public String body;

    public Post(Integer userId, Integer id, String title, String body){
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

}
