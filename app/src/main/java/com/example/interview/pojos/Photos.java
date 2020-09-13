package com.example.interview.pojos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Photos {
    @SerializedName("title")
    String tvtitle;
    @SerializedName("url")
    String fullurl;
    @SerializedName("id")
    String id;
    @SerializedName("albumId")
    String albumid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlbumid() {
        return albumid;
    }

    public void setAlbumid(String albumid) {
        this.albumid = albumid;
    }

    public String getTvtitle() {
        return tvtitle;
    }

    public void setTvtitle(String tvtitle) {
        this.tvtitle = tvtitle;
    }

    public String getFullurl() {
        return fullurl;
    }

    public void setFullurl(String fullurl) {
        this.fullurl = fullurl;
    }
}
