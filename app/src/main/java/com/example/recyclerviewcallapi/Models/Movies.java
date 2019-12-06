package com.example.recyclerviewcallapi.Models;

import java.util.List;

public class Movies {
    private String id;
    private String imgTitle;
    private String imgUrl;

    public String getId() {
        return id;
    }

    public String getImgTitle() {
        return imgTitle;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setImgTitle(String imgTitle) {
        this.imgTitle = imgTitle;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Movies() {
    }
}
