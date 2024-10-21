package com.reivai.testapp.network;

import com.reivai.testapp.model.DataItem;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiNetwork {
    @GET("posts")
    Observable<List<DataItem>> getItem();
}
