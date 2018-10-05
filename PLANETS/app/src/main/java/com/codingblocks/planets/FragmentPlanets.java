package com.codingblocks.planets;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPlanets extends Fragment {

    ArrayList<Object> arrayList=new ArrayList<>();
    public FragmentPlanets() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_planets, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        arrayList.add(new Planets("MERCURY","The Swiftest Planet","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQifcTjfDfQJAR0QsAaIImbxUTPNAnpvcV27Q0dn_IXjMOfm2dh"));
        arrayList.add(new Planets("VENUS","Planetary Hot Spot","https://upload.wikimedia.org/wikipedia/commons/thumb/e/e5/Venus-real_color.jpg/260px-Venus-real_color.jpg"));
        arrayList.add(new Planets("EARTH","Our Home Planet","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTCSYoFwp5gohA2HbobrjP1Ye9FGg0228jJ9sVU9gXqikp0Ss04"));
        arrayList.add(new Planets("MARS","The Red Planet","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcST4CBqF7aXhzKSYs4GWeXY8tPZAio8wVRU0HIlVOv4DSUUT70v"));
        arrayList.add(new Planets("JUPITER","Twice as massive as other planets combined","https://upload.wikimedia.org/wikipedia/commons/thumb/2/2b/Jupiter_and_its_shrunken_Great_Red_Spot.jpg/330px-Jupiter_and_its_shrunken_Great_Red_Spot.jpg"));
        arrayList.add(new Planets("SATURN","Jewel of Our Solar System","https://solarsystem.nasa.gov/system/stellar_items/image_files/38_saturn_1600x900.jpg"));
        arrayList.add(new Planets("URANUS","The Sideways Planet","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSeI_5kmQFkoKukOSjH_I-0ppCiaP33l3sApjWssWX1ljtLjwRCqQ"));
        arrayList.add(new Planets("NEPTUNE","The Windiest Planet","https://upload.wikimedia.org/wikipedia/commons/thumb/5/56/Neptune_Full.jpg/275px-Neptune_Full.jpg"));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView=view.findViewById(R.id.rvplanets);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        PlanetAdapter planetAdapter=new PlanetAdapter(arrayList, (AppCompatActivity) getActivity(),getContext());
        recyclerView.setAdapter(planetAdapter);
    }
}
