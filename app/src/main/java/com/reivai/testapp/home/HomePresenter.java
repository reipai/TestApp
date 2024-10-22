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
    private List<DataItem> allDataItems;

    public HomePresenter(Context context, HomeView view) {
        this.context = context;
        this.view = view;
        this.allDataItems = new ArrayList<>();
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
                allDataItems = dataItems;
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

    @Override
    public void searchList(String query) {
        if (allDataItems == null || allDataItems.isEmpty()) {
            view.error("Data belum dimuat. Silangkan coba lagi");
            return;
        }

        List<DataItem> filteredList = new ArrayList<>();
        for (DataItem item : allDataItems) {
            if (item.getTitle().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(item);
            }
        }

        view.success(filteredList);
    }
}
