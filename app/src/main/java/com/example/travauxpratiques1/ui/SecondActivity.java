package com.example.travauxpratiques1.ui;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.travauxpratiques1.R;

public class SecondActivity extends AppCompatActivity {

    private Button firstFragmentButton;
    private Button secondFragmentButton;
    private TextView textView;
    private int position;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
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

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void initViews(){

        getSupportActionBar().setTitle("Second Activity");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.arrow_back);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Hide Action bar
        //getSupportActionBar().hide();

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
                sendFinishIntent("Finished From First Button");
            }
        });

        secondFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentsContainer, new SecondFragment()).commit();
                sendFinishIntent("Finished From Second Button");

            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        finish();
        return super.onOptionsItemSelected(item);
    }

    private void sendFinishIntent(String source){
        Intent intent = new Intent();
        intent.putExtra("source", source);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}