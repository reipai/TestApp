package com.reivai.testapp.home;

import android.content.Context;
import android.util.Log;

import com.reivai.testapp.model.DataItem;
import com.reivai.testapp.network.ClientNetwork;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class HomePresenter implements HomePresenterImp{

    private Context context;
    private HomeView view;

    public HomePresenter(Context context, HomeView view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getList() {
        final Observable<List<DataItem>> api = ClientNetwork.getNetworkClient(context)
                .getItem()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        DisposableObserver<List<DataItem>> as = api.subscribeWith(new DisposableObserver<List<DataItem>>() {
            @Override
            public void onNext(List<DataItem> dataItems) {
                Log.d("API Response", "Received data: " + dataItems.toString());
                view.success(dataItems);
            }

            @Override
            public void onError(Throwable e) {
                view.error(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
