package com.techpark.dzzajk.fragments;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.techpark.dzzajk.R;


public class TableViewHolder extends RecyclerView.ViewHolder {

        private TextView number;

        public TableViewHolder(View view) {
            super(view);
            number = view.findViewById(R.id.number);

        }

        public void bind(int value) {
            if (value % 2 == 0) {
                number.setTextColor(Color.RED);
            }
            else {
                number.setTextColor(Color.BLUE);
            }
            number.setText(String.valueOf(value));
         }

         public TextView getNum(){
            return number;
         }
}

