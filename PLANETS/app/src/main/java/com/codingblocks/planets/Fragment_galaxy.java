package com.codingblocks.planets;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_galaxy extends Fragment {

    ArrayList<Galaxy>arrayList=new ArrayList<>();

    public Fragment_galaxy() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_galaxy, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        arrayList.add(new Galaxy("Andromeda","Andromeda","https://upload.wikimedia.org/wikipedia/commons/thumb/9/98/Andromeda_Galaxy_%28with_h-alpha%29.jpg/1024px-Andromeda_Galaxy_%28with_h-alpha%29.jpg"));
        arrayList.add(new Galaxy("Milky Way","Sagitarius","https://upload.wikimedia.org/wikipedia/commons/thumb/c/c6/Milky_Way_Night_Sky_Black_Rock_Desert_Nevada.jpg/220px-Milky_Way_Night_Sky_Black_Rock_Desert_Nevada.jpg"));
        arrayList.add(new Galaxy("Cosmet galaxy","Sculptor","https://upload.wikimedia.org/wikipedia/commons/thumb/0/0f/CometGalaxy.jpg/800px-CometGalaxy.jpg"));
        arrayList.add(new Galaxy("Tadpole galaxy","Draco","https://upload.wikimedia.org/wikipedia/commons/thumb/f/f9/UGC_10214HST.jpg/800px-UGC_10214HST.jpg"));
        arrayList.add(new Galaxy("Whirlpool Galaxy","Canes Venatici","https://upload.wikimedia.org/wikipedia/commons/thumb/d/db/Messier51_sRGB.jpg/1024px-Messier51_sRGB.jpg"));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView=view.findViewById(R.id.rvgalaxy);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        GalaxyAdapter galaxyAdapter=new GalaxyAdapter(arrayList,getActivity());
        recyclerView.setAdapter(galaxyAdapter);
    }
}
