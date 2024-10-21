package com.reivai.testapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public abstract class DataItem {
    @Expose
    @SerializedName("body")
    public String body;

    @Expose
    @SerializedName("title")
    public String title;

    @Expose
    @SerializedName("id")
    public int id;

    @Expose
    @SerializedName("userId")
    public int userId;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
