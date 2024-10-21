package com.reivai.testapp.home;

import com.reivai.testapp.model.DataItem;

import java.util.List;

public interface HomeView {

    void success(List<DataItem> dataItem);

    void error(String message);
}
