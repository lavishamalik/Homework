package com.codingblocks.newsapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.Viewholder> {

    ArrayList<News>arrayList= new ArrayList<>();
    Context ctx;

    public NewsAdapter(ArrayList<News> arrayList) {
        this.arrayList = arrayList;

    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_row,parent,false);
        ctx=parent.getContext();
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, final int position) {
        News item=arrayList.get(position);
        holder.title.setText(item.getTitle());
        holder.author.setText(item.getAuthor());
        Picasso.get()
                .load(item.getUrlToImage())
                .into(holder.url);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ctx,DetailActivity.class);
                intent.putExtra("title",arrayList.get(position).getTitle());
                intent.putExtra("author",arrayList.get(position).getAuthor());
                intent.putExtra("description",arrayList.get(position).getDescription());
                intent.putExtra("url",arrayList.get(position).getUrlToImage());
                intent.putExtra("link",arrayList.get(position).getUrl());
                intent.putExtra("published",arrayList.get(position).getPublishedAt());
                intent.putExtra("source",arrayList.get(position).getSource().getName());
                intent.putExtra("id",arrayList.get(position).getSource().getId());
                ctx.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView title,author;
        ImageView url;
        LinearLayout layout;
        public Viewholder(final View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.tvtitle);
            author=itemView.findViewById(R.id.tvauthor);
            url=itemView.findViewById(R.id.img);
            layout=itemView.findViewById(R.id.parentlayout);
        }
    }
}
