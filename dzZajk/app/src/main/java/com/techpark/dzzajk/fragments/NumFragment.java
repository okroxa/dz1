package com.techpark.dzzajk.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.techpark.dzzajk.R;

public class NumFragment extends Fragment {

    private int value;

    public static @NonNull NumFragment newNumFragment(@NonNull Integer value) {
        NumFragment fragment = new NumFragment();
        Bundle args = new Bundle();
        args.putInt(null, value);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            value = getArguments().getInt(null, 0);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView textView = view.findViewById(R.id.selected_text);

        if (value % 2 == 0) {
            textView.setTextColor(Color.RED);
        } else {
            textView.setTextColor(Color.BLUE);
        }
        textView.setText(String.valueOf(value));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_num, container, false);
    }

}