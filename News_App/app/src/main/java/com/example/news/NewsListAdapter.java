package com.example.news;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import com.bumptech.glide.Glide;

public class NewsListAdapter extends RecyclerView.Adapter<NewsViewHolder> {

    public ArrayList<Data> items = new ArrayList<>();
    private NewsItemClicked listener;

    public NewsListAdapter(NewsItemClicked listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news , parent , false);
        final NewsViewHolder viewHolder = new NewsViewHolder(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClicked(items.get(viewHolder.getAdapterPosition()));
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {

        Data currentItem = items.get(position);
        holder.titleView.setText(currentItem.getmTitle());
        holder.description.setText(currentItem.getmDescription());
        Glide.with(holder.itemView.getContext()).load(currentItem.getmImageurl()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void updateNews(ArrayList<Data> updatedNews){
        items.clear();
        items.addAll(updatedNews);

        notifyDataSetChanged();
    }
}

class NewsViewHolder extends RecyclerView.ViewHolder{

    public TextView titleView, description;
    public ImageView image;

    public NewsViewHolder(@NonNull View itemView) {
        super(itemView);
        titleView = itemView.findViewById(R.id.title);
        description = itemView.findViewById(R.id.description);
        image = itemView.findViewById(R.id.image);
    }
}

interface NewsItemClicked{
    void onItemClicked(Data item);
}