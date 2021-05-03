package com.example.travauxpratiques1.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.travauxpratiques1.R;
import com.example.travauxpratiques1.adapter.RecyclerViewAdapter;
import com.example.travauxpratiques1.model.Article;
import com.example.travauxpratiques1.model.NewsResponse;
import com.example.travauxpratiques1.model.TpObject;
import com.example.travauxpratiques1.remote.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        getNews();
    }


    private void initViews(){

        getSupportActionBar().setTitle("First Activity");
        recyclerView = findViewById(R.id.recyclerView);
    }


    private void getNews(){

        RetrofitClient retro = new RetrofitClient();

        retro.getRetrofitClient().getNews().enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                initRecyclerView(response.body().articles);
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {

            }
        });

    }

    private void initRecyclerView(ArrayList<Article> articleList){

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getApplicationContext(), articleList, this);
        GridLayoutManager linearLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);
    }


    ArrayList<TpObject> getRecyclerViewList(){

        ArrayList<TpObject> list = new ArrayList();

        for (int i =0; i<15;i++){

            list.add(new TpObject("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTBCqTzsVlnO6Z6W4ExNR1K0_zp8Db5hZUcyA&usqp=CAU", "Tunisia"));

        }
        return list;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == Activity.RESULT_OK){
            Toast.makeText(this, data.getExtras().getString("source"), Toast.LENGTH_LONG).show();
        }

    }
}