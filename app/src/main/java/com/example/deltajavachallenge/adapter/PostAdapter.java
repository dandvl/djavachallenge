package com.example.deltajavachallenge.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.deltajavachallenge.data.Post;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private AsyncListDiffer<Post> diff = new AsyncListDiffer<Post>(this, callback);

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(android.R.layout.activity_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.text1.setText(diff.getCurrentList().get(position).title);
    }

    @Override
    public int getItemCount() {
        return diff.getCurrentList().size();
    }

    class PostViewHolder extends RecyclerView.ViewHolder {
        public TextView text1;

        public PostViewHolder(View itemView){
            super(itemView);
            text1 = itemView.findViewById(android.R.id.text1);
        }
    }

    public void submitList(List<Post> posts){
        diff.submitList(posts);
    }

    private static DiffUtil.ItemCallback<Post> callback = new DiffUtil.ItemCallback<Post>() {
        @Override
        public boolean areItemsTheSame(@NonNull Post oldItem, @NonNull Post newItem) {
            return oldItem.id.equals(newItem.id);
        }

        @Override
        public boolean areContentsTheSame(@NonNull Post oldItem, @NonNull Post newItem) {
            return oldItem.title.equals(newItem.title) && oldItem.body.equals(newItem.body);
        }
    };
}
