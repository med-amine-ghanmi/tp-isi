package com.example.travauxpratiques1.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.travauxpratiques1.R;
import com.example.travauxpratiques1.model.TpObject;
import com.example.travauxpratiques1.ui.SecondActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context context;
     ArrayList<TpObject> tpObjectsList;

    public RecyclerViewAdapter(Context context, ArrayList<TpObject> tpObjectsList) {

        this.context = context;
        this.tpObjectsList = tpObjectsList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view =  LayoutInflater.from(context).inflate(R.layout.item_tp_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Picasso.get().load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTBCqTzsVlnO6Z6W4ExNR1K0_zp8Db5hZUcyA&usqp=CAU").into(holder.imageView);
        holder.textView.setText(tpObjectsList.get(position).getTitle());

        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondActivityIntent = new Intent(context, SecondActivity.class);
                secondActivityIntent.putExtra("position", position);
                secondActivityIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(secondActivityIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return tpObjectsList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{


        ConstraintLayout container;
        ImageView imageView;
        TextView textView;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        container = itemView.findViewById(R.id.viewHolderContainer);
        imageView = itemView.findViewById(R.id.imageView);
        textView = itemView.findViewById(R.id.textView);


    }

}


}
