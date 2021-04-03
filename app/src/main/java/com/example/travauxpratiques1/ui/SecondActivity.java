package com.example.travauxpratiques1.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.travauxpratiques1.R;

public class SecondActivity extends AppCompatActivity {

    private Button firstFragmentButton;
    private Button secondFragmentButton;
    private TextView textView;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        position = getIntent().getExtras().getInt("position");

        initFragments();
        initViews();
        initEvents();
    }





    private void initFragments() {

        Bundle bundle = new Bundle();
        bundle.putString("source", "Came from Activity ==> ADD mode");
        FirstFragment firstFragment = new FirstFragment();
        firstFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().add(R.id.fragmentsContainer, firstFragment).commit();

    }

    private void initViews(){

        firstFragmentButton = findViewById(R.id.firstFragmentButton);
        secondFragmentButton = findViewById(R.id.secondFragmentButton);
        textView = findViewById(R.id.textView2);
        String textValue = "Came from position " + String.valueOf(position);
        textView.setText(textValue);

    }

    private void initEvents(){

        firstFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("source", "Came from Button ==> REPLACE mode");
                FirstFragment firstFragment = new FirstFragment();
                firstFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentsContainer, firstFragment).commit();
            }
        });

        secondFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentsContainer, new SecondFragment()).commit();
            }
        });


    }

}