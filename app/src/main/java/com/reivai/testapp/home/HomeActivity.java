package com.reivai.testapp.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.reivai.testapp.adapter.ItemAdapter;
import com.reivai.testapp.databinding.ActivityHomeBinding;
import com.reivai.testapp.detail.DetailActivity;
import com.reivai.testapp.model.DataItem;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements HomeView{

    private ActivityHomeBinding binding;
    private HomePresenter presenter;
    private ItemAdapter adapter;
    List<DataItem> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        binding.rvList.setLayoutManager(new LinearLayoutManager(this));
        binding.rvList.setHasFixedSize(true);

        adapter = new ItemAdapter(this, items);
        binding.rvList.setAdapter(adapter);

        presenter = new HomePresenter(this, this);
        presenter.getList();

    }

    public void moveDetail(DataItem item) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("id", item.getId());
        intent.putExtra("title", item.getTitle());
        intent.putExtra("userId", item.getUserId());
        intent.putExtra("body", item.getBody());
        startActivity(intent);
    }

    @Override
    public void success(List<DataItem> dataItem) {
        Log.d("wakacaw", "success: " + dataItem.size());
        items.addAll(dataItem);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void error(String message) {
        Log.d("wakacaw", "error: " + message);
        Toast.makeText(this, "Data Error", Toast.LENGTH_SHORT).show();
    }
}