package com.codingblocks.newsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    ArrayList<News>arrayList;
    String url="https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=56aecdc2401d4e49b17230b0cadf06e7";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* Button btnfetch=findViewById(R.id.btnfetch);
        btnfetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {*/
                makeNetworkCall(url);
          /*  }
        });*/
    }

    private void makeNetworkCall(String url) {
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                call.enqueue(this);
                Toast.makeText(MainActivity.this,"Sorry the request failed, Please retry",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result =response.body().string();

                //I cant modify text here as this is a different thread than my UI thread

                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        arrayList=JSONParse(result);
                        RecyclerView recyclerView=findViewById(R.id.recyclerView);
                        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        NewsAdapter newsAdapter=new NewsAdapter(arrayList);
                        recyclerView.setAdapter(newsAdapter);
                    }
                });
            }
        });
    }

    public ArrayList<News> JSONParse(String json)
    {
        ArrayList<News>result=new ArrayList<>();

        try {
            JSONObject jsonObject=new JSONObject(json);
            JSONArray jsonArray=jsonObject.getJSONArray("articles");

                    for(int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject currObj=jsonArray.getJSONObject(i);
                        String author=currObj.optString("author");
                        String title=currObj.optString("title");
                        String description=currObj.optString("description");
                        String url=currObj.optString("url");
                        String urlToImage=currObj.optString("urlToImage");
                        String publishedAt=currObj.optString("publishedAt");
                        String content=currObj.optString("content");
                        JSONObject sourceJson=currObj.getJSONObject("source");
                        String id=sourceJson.optString("id");
                        String name=sourceJson.optString("name");

                        Source source=new Source(id,name);
                        News curr=new News(author,title,description,url,urlToImage,publishedAt,content,source);

                        result.add(curr);
                    }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.e("TAG","parse Json"+result.size());
        return result;
    }
}
