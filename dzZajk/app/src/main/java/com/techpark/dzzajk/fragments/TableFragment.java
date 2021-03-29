package com.techpark.dzzajk.fragments;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.techpark.dzzajk.R;

import java.util.ArrayList;
import java.util.List;
import static com.techpark.dzzajk.fragments.NumFragment.newNumFragment;

public class TableFragment extends Fragment implements OnItemClicked{

    private List<Integer> data;
   // private static final String VALUE_TAG = "value_tag";

   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_table_list, container, false);
        return (view);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){

       super.onViewCreated(view, savedInstanceState);
       RecyclerView recyclerView;
       recyclerView = view.findViewById(R.id.list);

        if (data == null && savedInstanceState == null) {
            data = new ArrayList<>();
            insert(data);
        } else {
            data = savedInstanceState.getIntegerArrayList(null);
        }

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), requireContext().getResources().getInteger(R.integer.portrait)));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), requireContext().getResources().getInteger(R.integer.landscape)));
        }


        TableRecyclerViewAdapter adapter = new TableRecyclerViewAdapter(data, this);
        recyclerView.setAdapter(adapter);

        Button addNumber = view.findViewById(R.id.buttonAddNumber);
         addNumber.setOnClickListener(v -> {
            data.add(data.get(data.size() - 1) + 1);
            adapter.notifyItemInserted(data.size() - 1);
            Toast.makeText(requireContext(), "Number was added!", Toast.LENGTH_SHORT).show();
        });
    }

    public void insert(@NonNull List<Integer> data) {
        for (int i = 1; i <= 100; i++) {
            data.add(i);
        }
    }

    @Override
    public void onSaveInstanceState(@Nullable Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        if (savedInstanceState == null) {
            savedInstanceState = new Bundle();
        }
        savedInstanceState.putIntegerArrayList(null, (ArrayList<Integer>)data);
    }

    @Override
    public void onItemClick(int value) {
            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            Fragment fragment= newNumFragment(value);
             fragmentTransaction.add(R.id.fragment, fragment, "NUM_FRAGMENT").addToBackStack(null);
             fragmentTransaction.commit();
    }

}