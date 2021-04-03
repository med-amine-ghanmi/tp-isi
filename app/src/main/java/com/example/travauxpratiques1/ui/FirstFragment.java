package com.example.travauxpratiques1.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.travauxpratiques1.R;


public class FirstFragment extends Fragment {

    View rootView;
    TextView textView;
    String textValue = "no arguments";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        if(getArguments() != null){
            textValue = getArguments().getString("source");
        }

        return inflater.inflate(R.layout.fragment_first, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rootView = view;
        initViews();
    }


    private void initViews(){
        textView = rootView.findViewById(R.id.firstFragmentTextView);
        textView.setText(textValue);
    }


}