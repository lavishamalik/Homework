package com.codingblocks.weather;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {
    ArrayList<Solution>solutions=new ArrayList<>();
    Context ctx;

    public WeatherAdapter(ArrayList<Solution> solutions, Context ctx) {
        this.solutions = solutions;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(ctx).inflate(R.layout.row_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Solution solution=solutions.get(position);
        // ArrayList<result>arrayListofres=weather.getList();

        holder.date.setText(solution.getDt_txt());
        //reusableclass values=arrayListofres.get(i).getMain();
        holder.temp.setText(String.valueOf(solution.getTemp()));
        holder.tempmin.setText(String.valueOf(solution.getTemp_min()));
        holder.tempmax.setText(String.valueOf(solution.getTemp_max()));
        holder.humidity.setText(String.valueOf(solution.getHumidity()));
    }

    @Override
    public int getItemCount() {
        return solutions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView temp,tempmax,tempmin,humidity,date;

        public ViewHolder(View itemView) {
            super(itemView);
            temp=itemView.findViewById(R.id.tvtemp);
            tempmax=itemView.findViewById(R.id.tvtempmax);
            tempmin=itemView.findViewById(R.id.tvmin);
            humidity=itemView.findViewById(R.id.tvhumidity);
            date=itemView.findViewById(R.id.tvdate);

        }
    }
}
