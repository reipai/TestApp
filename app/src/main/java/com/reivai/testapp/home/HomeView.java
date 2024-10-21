package com.reivai.testapp.home;

import com.reivai.testapp.model.DataItem;

public interface HomeView {

    void success(DataItem dataItem);

    void error(String message);
}
