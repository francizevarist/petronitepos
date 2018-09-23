package com.ncl.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ncl.model.GasweightItem;
import com.ncl.pos.R;

import java.util.ArrayList;

public class GasweightAdapter extends RecyclerView.Adapter<GasweightAdapter.ViewHolder>{

    private ArrayList<GasweightItem> gasweightItems;
    private Context context;
    private AppCompatActivity appCompatActivity;

    public GasweightAdapter(ArrayList<GasweightItem> gasweightItems, Context context, AppCompatActivity appCompatActivity) {
        this.gasweightItems = gasweightItems;
        this.context = context;
        this.appCompatActivity = appCompatActivity;
    }

    @Override
    public GasweightAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item_weight, parent, false);
        return new GasweightAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(GasweightAdapter.ViewHolder holder, int position) {
        final GasweightItem item = gasweightItems.get(position);
        holder.text_weight.setText(item.getWeight());
        if(position%2==0) {
            holder.row.setBackgroundColor(ContextCompat.getColor(context, R.color.colorAccentprimaryDark));
        } else {
            holder.row.setBackgroundColor(ContextCompat.getColor(context,R.color.colorAccentprimary));
        };
    }

    @Override
    public int getItemCount() {
        return gasweightItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView text_weight;
        LinearLayout row;

        ViewHolder(View itemView) {
            super(itemView);
            text_weight = (TextView) itemView.findViewById(R.id.weight);
            row = (LinearLayout) itemView.findViewById(R.id.row);
        }
    }

}
