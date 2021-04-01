package com.example.travauxpratiques1.model;

import android.media.tv.TvView;

public class TpObject {

    String imageUrl;
    String title;


    public TpObject(String imageUrl, String title) {
        this.imageUrl = imageUrl;
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
