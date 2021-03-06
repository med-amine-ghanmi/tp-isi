package com.example.travauxpratiques1.adapter;

import android.app.Activity;
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

import com.example.travauxpratiques1.R;
import com.example.travauxpratiques1.model.Article;
import com.example.travauxpratiques1.ui.ArticleDetailActivity;
import com.example.travauxpratiques1.ui.SecondActivity;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context context;
     ArrayList<Article> articlesList;
    Activity activity;

    public RecyclerViewAdapter(Context context, ArrayList<Article> articlesList, Activity activity) {

        this.context = context;
        this.articlesList = articlesList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view =  LayoutInflater.from(context).inflate(R.layout.item_tp_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Picasso.get().load(articlesList.get(position).urlToImage).into(holder.imageView);
        holder.newsTitle.setText(articlesList.get(position).getTitle());
        holder.newsDescription.setText(articlesList.get(position).getAuthor());
        holder.newsDate.setText(articlesList.get(position).getPublishedAt().toString());

        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent articleDetailIntent = new Intent(context, ArticleDetailActivity.class);

                articleDetailIntent.putExtra("imageUrl", articlesList.get(position).urlToImage);
                articleDetailIntent.putExtra("author", articlesList.get(position).author);
                articleDetailIntent.putExtra("title", articlesList.get(position).title);
                articleDetailIntent.putExtra("description", articlesList.get(position).description);
                articleDetailIntent.putExtra("content", articlesList.get(position).content);
                articleDetailIntent.putExtra("publishedAt", convertLongToStringDate(articlesList.get(position).publishedAt));
                articleDetailIntent.putExtra("link", articlesList.get(position).url);

                activity.startActivityForResult(articleDetailIntent, 0);
            }
        });

    }
    String convertLongToStringDate(Date date){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

        return sdf.format(date);
    }

    @Override
    public int getItemCount() {
        return articlesList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{


        ConstraintLayout container;
        ImageView imageView;
        TextView newsTitle;
        TextView newsDescription;
        TextView newsDate;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        container = itemView.findViewById(R.id.viewHolderContainer);
        imageView = itemView.findViewById(R.id.newsImage);
        newsTitle = itemView.findViewById(R.id.newsTitle);
        newsDescription = itemView.findViewById(R.id.newsDescription);
        newsDate = itemView.findViewById(R.id.newsDate);


    }

}


}
