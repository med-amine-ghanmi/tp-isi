package com.example.travauxpratiques1.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.travauxpratiques1.R;
import com.example.travauxpratiques1.adapter.RecyclerViewAdapter;
import com.example.travauxpratiques1.model.TpObject;

import java.util.ArrayList;

import static androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initRecyclerView();

    }


    private void initViews(){

        recyclerView = findViewById(R.id.recyclerView);
    }

    private void initRecyclerView(){

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getApplicationContext(), getRecyclerViewList());
        GridLayoutManager linearLayoutManager = new GridLayoutManager(this, 3);
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


}