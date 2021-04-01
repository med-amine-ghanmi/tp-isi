package com.example.travauxpratiques1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.travauxpratiques1.R;
import com.example.travauxpratiques1.model.TpObject;
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
    }

    @Override
    public int getItemCount() {
        return tpObjectsList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{


    ImageView imageView;
    TextView textView;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.imageView);
        textView = itemView.findViewById(R.id.textView);


    }

}


}
