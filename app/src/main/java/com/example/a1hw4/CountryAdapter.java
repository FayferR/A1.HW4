package com.example.a1hw4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {
    private ArrayList<Model> data;
    private onClick onClick;

    public CountryAdapter(ArrayList<Model> data, onClick onClick) {
        this.data = data;
        this.onClick = onClick;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CountryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class CountryViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private ImageView imageView;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);
            imageView = itemView.findViewById(R.id.item_iv);

        }

        public void bind(Model model) {
            name.setText(model.getName());
            imageView.setImageResource(model.getImage());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClick.onClick(data.get(getLayoutPosition()));
                }
            });
        }
    }
}



















