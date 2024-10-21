package com.reivai.testapp.network;

import com.reivai.testapp.model.DataItem;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiNetwork {
    @GET("posts")
    Observable<DataItem> getItem();
}
