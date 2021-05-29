package com.example.travauxpratiques1.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.travauxpratiques1.R;
import com.squareup.picasso.Picasso;

public class ArticleDetailActivity extends AppCompatActivity {

    ImageView articleImage;
    TextView author;
    TextView title;
    TextView description;
    TextView content;
    TextView publishedAt;
    TextView visitWebPage;

    String articleImageLink = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);

        initViews();
        showIntentData();

    }


    void initViews(){

        if( getSupportActionBar() != null && getSupportActionBar().getTitle() != null ) {
            getSupportActionBar().setTitle("Article details");
        }

        articleImage = findViewById(R.id.articleImageView);
        author = findViewById(R.id.authorValue);
        title = findViewById(R.id.titleValue);
        description = findViewById(R.id.descriptionValue);
        content = findViewById(R.id.contentValue);
        publishedAt = findViewById(R.id.publishedAtValue);
        visitWebPage = findViewById(R.id.articleLinkText);

    }

    void showIntentData(){

        Intent intent = getIntent();
        Picasso.get().load(intent.getExtras().getString("imageUrl")).into(articleImage);
        author.setText(intent.getExtras().getString("author"));
        title.setText(intent.getExtras().getString("title"));
        description.setText(intent.getExtras().getString("description"));
        content.setText(intent.getExtras().getString("content"));
        publishedAt.setText(intent.getExtras().getString("publishedAt"));


        visitWebPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(intent.getExtras().getString("link")));
                startActivity(browserIntent);
            }
        });

    }



}