package com.codingblocks.planets;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GalaxyAdapter extends RecyclerView.Adapter<GalaxyAdapter.ViewHolder>{
    ArrayList<Galaxy> arrayList;

    public GalaxyAdapter(ArrayList<Galaxy> arrayList, FragmentActivity activity) {
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.galaxy_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Galaxy galaxy= (Galaxy) arrayList.get(position);
        holder.namegalaxy.setText(galaxy.getName());
        holder.nameconst.setText(galaxy.getConstellation());
        Picasso.get()
                .load(galaxy.getUrl())
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        TextView namegalaxy,nameconst;
        ImageView img;
        public ViewHolder(View itemView) {
            super(itemView);
            namegalaxy=itemView.findViewById(R.id.tvnameg);
            nameconst=itemView.findViewById(R.id.tvconst);
            img=itemView.findViewById(R.id.imgGalaxy);
        }
    }
}
