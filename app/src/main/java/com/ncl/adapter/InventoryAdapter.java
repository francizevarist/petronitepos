package com.ncl.adapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ncl.model.InventoryItem;
import com.ncl.pos.R;

import java.util.ArrayList;

public class InventoryAdapter extends RecyclerView.Adapter<InventoryAdapter.ViewHolder> {

    private ArrayList<InventoryItem> inventoryItems;
    private Context context;
    private AppCompatActivity appCompatActivity;

    public InventoryAdapter(ArrayList<InventoryItem> inventoryItems, Context context, AppCompatActivity appCompatActivity) {
        this.inventoryItems = inventoryItems;
        this.context = context;
        this.appCompatActivity = appCompatActivity;
    }

    @Override
    public InventoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item_inventory, parent, false);
        return new InventoryAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(InventoryAdapter.ViewHolder holder, int position) {

        final InventoryItem item = inventoryItems.get(position);
        holder.text_particular.setText(item.getParticular());
        holder.text_openingstock.setText(item.getOpeningstock());
        holder.text_price.setText(item.getPrice());
        holder.text_addstock.setText(item.getAddstock());
        holder.text_lessstock.setText(item.getLessstock());
        holder.text_totalamount.setText(item.getTotalamount());
        holder.text_stockbalance.setText(item.getStockbalance());
        holder.text_variance.setText(item.getVariance());

    }

    @Override
    public int getItemCount() {
        return inventoryItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView text_particular;
        TextView text_openingstock;
        TextView text_price;
        TextView text_addstock;
        TextView text_lessstock;
        TextView text_totalamount;
        TextView text_stockbalance;
        TextView text_variance;

        ViewHolder(View itemView) {
            super(itemView);
            text_particular = (TextView) itemView.findViewById(R.id.particular);
            text_openingstock = (TextView) itemView.findViewById(R.id.openingstock);
            text_price = (TextView) itemView.findViewById(R.id.price);
            text_addstock = (TextView) itemView.findViewById(R.id.addstock);
            text_lessstock = (TextView) itemView.findViewById(R.id.lessstock);
            text_totalamount = (TextView) itemView.findViewById(R.id.totalamount);
            text_stockbalance = (TextView) itemView.findViewById(R.id.stockbalance);
            text_variance = (TextView) itemView.findViewById(R.id.variance);
        }

    }

}