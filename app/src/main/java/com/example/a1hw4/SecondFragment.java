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

public class SecondFragment extends Fragment implements onClick {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    private ArrayList<Model> data;
    private CountryAdapter adapter;
    private RecyclerView recyclerView;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadData();
        recyclerView = view.findViewById(R.id.recycler_second);
        adapter = new CountryAdapter(data, this::onClick);
        recyclerView.setAdapter(adapter);
    }

    private void loadData() {
        data = new ArrayList<>();
        Bundle bundle = getArguments();
        Integer val = bundle.getInt("key");
        switch (val) {
            case 1:
                data.add(new Model("Canada", R.drawable.ca));
                data.add(new Model("Cuba", R.drawable.cu));
                data.add(new Model("Bahamas", R.drawable.bs));
                data.add(new Model("Mexico", R.drawable.mx));
                data.add(new Model("USA", R.drawable.us));
                break;

            case 2:
                data.add(new Model("Brazil", R.drawable.br));
                data.add(new Model("Argentina", R.drawable.ar));
                data.add(new Model("Uruguay", R.drawable.uy));
                data.add(new Model("Peru", R.drawable.pe));
                data.add(new Model("Bolivia", R.drawable.bo));
                break;

            case 3:
                data.add(new Model("Australia", R.drawable.au));
                break;

            case 4:
                data.add(new Model("Egypt", R.drawable.eg));
                data.add(new Model("Sudan", R.drawable.sd));
                data.add(new Model("Kenya", R.drawable.ke));
                data.add(new Model("Nigeria", R.drawable.ng));
                data.add(new Model("Angelo", R.drawable.ao));
                break;

            case 5:
                data.add(new Model("Kyrgyzstan", R.drawable.kg));
                data.add(new Model("Kazakhstan", R.drawable.kz));
                data.add(new Model("Tajikistan", R.drawable.tj));
                data.add(new Model("Russia", R.drawable.ru));
                data.add(new Model("Japan", R.drawable.jp));
                break;

            case 6:
                data.add(new Model("Turkey", R.drawable.tr));
                data.add(new Model("Ukraine", R.drawable.ua));
                data.add(new Model("France", R.drawable.fr));
                data.add(new Model("Croatia", R.drawable.hr));
                data.add(new Model("Russia", R.drawable.ru));
                break;

        }

    }

    @Override
    public void onClick(Model model) {

    }
}
