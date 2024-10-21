package com.reivai.testapp.home;

import android.content.Context;

import com.reivai.testapp.model.DataItem;
import com.reivai.testapp.network.ClientNetwork;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class HomePresenter implements HomePresenterImp{

    Context context;
    HomeView view;

    public HomePresenter(Context context, HomeView view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getList() {
        final Observable<DataItem> api = ClientNetwork.getNetworkClient(context)
                .getItem()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        DisposableObserver<DataItem> as = api.subscribeWith(new DisposableObserver<DataItem>() {
            @Override
            public void onNext(DataItem dataItem) {
                view.success(dataItem);
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
