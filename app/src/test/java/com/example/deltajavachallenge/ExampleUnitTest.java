package com.example.deltajavachallenge;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;

import com.example.deltajavachallenge.data.Post;
import com.example.deltajavachallenge.repository.PostRepository;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Rule
    public TestRule rule = new InstantTaskExecutorRule();


    @Test
    public void testApiCall() {

        PostRepository posts = mock(PostRepository.class);

        MutableLiveData<List<Post>> fakePostList = new MutableLiveData<>();

        List<Post> list = new ArrayList<>();
        list.add(new Post(1,2,"title", "body"));
        list.add(new Post(1,2,"title2", "body 2"));

        fakePostList.setValue(list);

        when(posts.all()).thenReturn(fakePostList);

        assertEquals(posts.all().getValue().size(),2);
    }
}