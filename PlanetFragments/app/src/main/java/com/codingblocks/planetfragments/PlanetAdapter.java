package com.codingblocks.planetfragments;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.ViewHolder> {

    ArrayList<Object> arrayList;
    Context ctx;
    AppCompatActivity appCompatActivity;
    public PlanetAdapter(ArrayList<Object> arrayList, Context ctx,AppCompatActivity activity) {
        this.arrayList = arrayList;
        this.ctx = ctx;
        appCompatActivity=activity;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final Planets planets= (Planets) arrayList.get(position);
        holder.name.setText(planets.getName());
        holder.description.setText(planets.getDescription());
        Picasso.get()
                .load(planets.url)
                .into(holder.imgurl);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ctx,  ((Planets) arrayList.get(position)).getName()+" is clicked",Toast.LENGTH_LONG).show();
                Log.e("TAG",""+((Planets) arrayList.get(position)).getName());
                if(appCompatActivity.findViewById(R.id.container)==null) {
                    Intent intent = new Intent(ctx, DetailActivity.class);
                    intent.putExtra("PlanetName", ((Planets) arrayList.get(position)).getName());
                    intent.putExtra("PlanetDesc", ((Planets) arrayList.get(position)).getDescription());
                    intent.putExtra("ImgUrl", ((Planets) arrayList.get(position)).getUrl());
                    ctx.startActivity(intent);
                }
                else{
                   android.support.v4.app.FragmentManager fm = appCompatActivity.getSupportFragmentManager();
                    fm.beginTransaction()
                            .add(R.id.container, new Detail(((Planets) arrayList.get(position)).getName(),((Planets) arrayList.get(position)).getDescription(),((Planets) arrayList.get(position)).getUrl()))
                            .commit();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView description;
        ImageView imgurl;
        LinearLayout linearLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.tvName);
            description=itemView.findViewById(R.id.tvDes);
            imgurl=itemView.findViewById(R.id.imgPlanet);
            linearLayout=itemView.findViewById(R.id.parentlayout);
        }
    }
}
