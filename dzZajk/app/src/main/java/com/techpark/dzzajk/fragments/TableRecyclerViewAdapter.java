package com.techpark.dzzajk.fragments;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.techpark.dzzajk.R;

import java.util.List;

public class TableRecyclerViewAdapter extends RecyclerView.Adapter<TableViewHolder> {

    private List<Integer> data;
    private OnItemClicked click;

    public TableRecyclerViewAdapter(List<Integer> numbers, OnItemClicked clicked) {
        this.data = numbers;
        this.click = clicked;
    }

    @NonNull
    @Override
    public TableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_table, parent, false);
        return new TableViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TableViewHolder holder, int position) {
        Integer cur = data.get(position);
        holder.bind(cur);
        holder.getNum().setOnClickListener(v -> click.onItemClick(cur));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


}