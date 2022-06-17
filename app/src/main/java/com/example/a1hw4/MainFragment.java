package com.example.a1hw4;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MainFragment extends Fragment implements onClick {
    private ArrayList<Model> data;
    private CountryAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadData();
        recyclerView = view.findViewById(R.id.recycler);
        adapter = new CountryAdapter(data,
                this::onClick);
        recyclerView.setAdapter(adapter);
    }

    private void loadData() {
        data = new ArrayList<>();
        data.add(new Model("South America", R.drawable.cna, 1));
        data.add(new Model("North America", R.drawable.csa, 2));
        data.add(new Model("Australia", R.drawable.coc, 3));
        data.add(new Model("Africa", R.drawable.caf, 4));
        data.add(new Model("Asia", R.drawable.cas, 5));
        data.add(new Model("Europe", R.drawable.ceu, 6));
    }

    @Override
    public void onClick(Model model) {
        Bundle bundle = new Bundle();
        bundle.putInt("key", model.getKeyId());
        Fragment fragment = new SecondFragment();
        fragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction().
                replace(R.id.container, fragment).addToBackStack(null).commit();

    }
}
