package com.codingblocks.planets;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

@SuppressLint("ValidFragment")
public class DetailActivityFragment extends Fragment {
    String name,subtitle,url;
    public DetailActivityFragment(String subtitle,String url,String title) {
        this.subtitle=subtitle;
        this.url=url;
        this.name=title;

    }

    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.detail_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getActivity().getIntent().hasExtra("PlanetName")&&getActivity().getIntent().hasExtra("PlanetDesc")&&getActivity().getIntent().hasExtra("ImgUrl"))
        {
            Log.e("TAG2",""+getActivity().getIntent().getStringExtra("PlanetName"));
            String name=getActivity().getIntent().getStringExtra("PlanetName");
            String des=getActivity().getIntent().getStringExtra("PlanetDesc");
            String url=getActivity().getIntent().getStringExtra("ImgUrl");

            TextView textView=view.findViewById(R.id.tvhead);
            TextView textView1=view.findViewById(R.id.tvdet);
            ImageView imgPlanet=view.findViewById(R.id.imgp);

            textView.setText(name);
            textView1.setText(des);
            Picasso.get()
                    .load(url)
                    .into(imgPlanet);
        }
    }
}
