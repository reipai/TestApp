package com.reivai.testapp.detail;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.reivai.testapp.R;
import com.reivai.testapp.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    private ActivityDetailBinding binding;
    String userId, id, title, body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        if (intent != null) {
            userId = String.valueOf(intent.getIntExtra("userId" , 0));
            id = String.valueOf(intent.getIntExtra("id", 0));
            title = intent.getStringExtra("title");
            body = intent.getStringExtra("body");

            binding.tvUserId.setText(userId);
            binding.tvId.setText(id);
            binding.tvTitle.setText(title);
            binding.tvBody.setText(body);
        } else {
            Toast.makeText(this, "Data Tidak Ada", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}