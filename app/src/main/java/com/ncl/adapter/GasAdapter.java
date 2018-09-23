package com.ncl.adapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ncl.model.GasItem;
import com.ncl.pos.R;

import java.util.ArrayList;

public class GasAdapter extends RecyclerView.Adapter<GasAdapter.ViewHolder>{
    GasweightAdapter adapter;
    private ArrayList<GasItem> gasItems;
    private Context context;
    private AppCompatActivity appCompatActivity;

    public GasAdapter(ArrayList<GasItem> gasItems, Context context, AppCompatActivity appCompatActivity) {
        this.gasItems = gasItems;
        this.context = context;
        this.appCompatActivity = appCompatActivity;
    }

    @Override
    public GasAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item_gas, parent, false);
        return new GasAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(GasAdapter.ViewHolder holder, int position) {
        final GasItem item = gasItems.get(position);
        holder.text_brandname.setText(item.getBrandname());
    }

    @Override
    public int getItemCount() {
        return gasItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView text_brandname;
        View view;

        ViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
            text_brandname = (TextView) itemView.findViewById(R.id.brandname);
        }
    }

}
