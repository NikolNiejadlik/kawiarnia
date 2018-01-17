package com.example.nicol.kawiarnia;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Nicol on 2018-01-17.
 */

public class CoffeeAdapter extends RecyclerView.Adapter<CoffeeAdapter.ViewHolder> {

    private ArrayList<Coffee> list = new ArrayList<>();

    CoffeeAdapter(ArrayList<Coffee> coffees) {
        this.list = coffees;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, null);
        return new ViewHolder(itemLayoutView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setName(list.get(position).getName());
        holder.setPrice(list.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.latte)
        TextView Latte;

        @BindView(R.id.cena)
        TextView Cena;

        @BindView(R.id.check)
        ImageView Wybrane;

        @OnClick(R.id.button_wybierz)
        void onNameClick(){
            if(Wybrane.getVisibility()==View.INVISIBLE){
                Wybrane.setVisibility(View.VISIBLE);
            }
            else{
                Wybrane.setVisibility(View.INVISIBLE);
            }
        }

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            Wybrane.setVisibility(View.INVISIBLE);
        }

        private void setName(String name) {
            Latte.setText(name);
        }
        private void setPrice(String price) {
            Cena.setText(price);
        }
    }

}