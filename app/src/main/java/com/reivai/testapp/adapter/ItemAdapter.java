package com.reivai.testapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.reivai.testapp.R;
import com.reivai.testapp.home.HomeActivity;
import com.reivai.testapp.model.DataItem;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private Context context;
    private List<DataItem> itemList;

    public ItemAdapter(Context context, List<DataItem> items) {
        this.context = context;
        this.itemList = items;
    }

    @NonNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ViewHolder holder, int position) {
        DataItem items = itemList.get(position);
        holder.itemId.setText(String.valueOf(items.getId()));
        holder.itemTitle.setText(items.getTitle());

        holder.itemView.setOnClickListener(view -> ((HomeActivity)context).moveDetail(items));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemId, itemTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemId = itemView.findViewById(R.id.tvIdMain);
            itemTitle = itemView.findViewById(R.id.tvTitleMain);
        }
    }
}
