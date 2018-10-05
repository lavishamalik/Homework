package com.codingblocks.planets;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
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

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.viewHolder>{
    ArrayList<Object>arraylist;
    private AppCompatActivity appCompatActivity;
    private Context ctx;

    public PlanetAdapter(ArrayList<Object> arrayList, AppCompatActivity activity,Context ctx) {
        this.arraylist = arrayList;
        this.appCompatActivity = activity;
        this.ctx=ctx;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.planets_layout,parent,false);
        return new viewHolder(v);
    }

    @NonNull
    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, final int position) {
        Planets planet= (Planets) arraylist.get(position);
        holder.tvtitle.setText(planet.getTitle());
        holder.tvsubtitle.setText(planet.getSubtitle());
        Picasso.get()
                .load(planet.url)
                /*.placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher_round)*/
                .into(holder.imgPlanet);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ctx,  ((Planets) arraylist.get(position)).getTitle()+" is clicked",Toast.LENGTH_LONG).show();
                Log.e("TAG",""+((Planets) arraylist.get(position)).getTitle());
                if(appCompatActivity.findViewById(R.id.container)==null) {
                    Intent intent = new Intent(ctx, DetailActivity.class);
                    intent.putExtra("PlanetName", ((Planets) arraylist.get(position)).getTitle());
                    intent.putExtra("PlanetDesc", ((Planets) arraylist.get(position)).getSubtitle());
                    intent.putExtra("ImgUrl", ((Planets) arraylist.get(position)).getUrl());
                    ctx.startActivity(intent);
                }
                else{
                    android.support.v4.app.FragmentManager fm = appCompatActivity.getSupportFragmentManager();
                    fm.beginTransaction()
                            .add(R.id.container, new DetailActivityFragment(((Planets) arraylist.get(position)).getTitle(),((Planets) arraylist.get(position)).getSubtitle(),((Planets) arraylist.get(position)).getUrl()))
                            .commit();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return arraylist.size();
    }


    class viewHolder extends RecyclerView.ViewHolder {
        TextView tvtitle, tvsubtitle;
        ImageView imgPlanet;
        LinearLayout linearLayout;

        public viewHolder(View itemView) {
            super(itemView);
            tvtitle = itemView.findViewById(R.id.tvTitle);
            tvsubtitle = itemView.findViewById(R.id.tvSubTitle);
            imgPlanet = itemView.findViewById(R.id.imgPlanet);
            linearLayout=itemView.findViewById(R.id.parentLayout);
        }
    }
}