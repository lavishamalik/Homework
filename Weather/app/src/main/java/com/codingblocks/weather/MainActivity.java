package com.codingblocks.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    ArrayList<Solution>anslist=new ArrayList<>();
   String url="http://api.openweathermap.org/data/2.5/forecast?id=1269750&APPID=8a625a625cf1dcca963f9588c964dc11";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        makeNetworkCall(url);
    }

    private void makeNetworkCall(String url) {
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder()
                .url(url)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                call.enqueue(this);
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String res=response.body().string();
                Gson gson=new Gson();
                finalclass ans=gson.fromJson(res,finalclass.class);
                ArrayList<result>list=ans.getList();
                for (int i = 0; i < list.size(); i++) {

                    anslist.add(new Solution(list.get(i).getMain().getTemp(),
                                    list.get(i).getMain().getTemp_max(),
                                    list.get(i).getMain().getTemp_min(),
                                    list.get(i).getMain().getHumidity(),
                                    list.get(i).getDt_txt()
                                    //  list.get(i).getWeather().get(i)getIcon()
                            )
                    );


                }
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        RecyclerView recyclerView=findViewById(R.id.recyclerView);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                        WeatherAdapter weatherAdapter=new WeatherAdapter(anslist,getBaseContext());
                        recyclerView.setAdapter(weatherAdapter);
                    }
                });
            }
        });
    }




}
