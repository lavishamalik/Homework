package com.codingblocks.planetfragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
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
public class Detail extends Fragment {

    String name,description,url;

    @SuppressLint("ValidFragment")
    public Detail(String name, String description, String url) {
        this.name = name;
        this.description = description;
        this.url = url;
    }

    public Detail() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
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

            TextView textView=view.findViewById(R.id.tvPlanetName);
            TextView textView1=view.findViewById(R.id.tvPlanetDes);
            ImageView imgPlanet=view.findViewById(R.id.imgPlanet2);

            textView.setText(name);
            textView1.setText(des);
            Picasso.get()
                    .load(url)
                    .into(imgPlanet);
        }
    }
}
