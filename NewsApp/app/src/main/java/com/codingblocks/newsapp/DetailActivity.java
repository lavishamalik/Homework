package com.codingblocks.newsapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.net.URISyntaxException;

public class DetailActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if(getIntent()!=null)
        {
            TextView textView=findViewById(R.id.tvTitle);
            TextView textView1=findViewById(R.id.tvAuthor);
            TextView textView2=findViewById(R.id.tvDescription);
            ImageView textView4=findViewById(R.id.imgNews);
            TextView textView3=findViewById(R.id.tvlink);
            TextView textView5=findViewById(R.id.tvPublished);
            TextView textView7=findViewById(R.id.tvid);
            TextView textView6=findViewById(R.id.tvsource);
            String title=getIntent().getStringExtra("title");
            textView.setText(title);
            String author=getIntent().getStringExtra("author");
            textView1.setText(author);
            String description=getIntent().getStringExtra("description");

            textView2.setText(description);
            String url=getIntent().getStringExtra("url");
            Picasso.get()
                    .load(url)
                    .into(textView4);
            final String link=getIntent().getStringExtra("link");
            textView3.setText(link);
            textView3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i= null;
                    try {
                        i = Intent.getIntent(getIntent().getStringExtra("link"));
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                    i.setAction(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(link));
                    startActivity(i);
                }
            });
            String published=getIntent().getStringExtra("published");

            textView5.setText(published);
            String source=getIntent().getStringExtra("source");

            textView6.setText(source);
            String id=getIntent().getStringExtra("id");

            textView7.setText(id);
        }
    }

}
