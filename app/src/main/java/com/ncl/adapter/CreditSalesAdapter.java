package com.ncl.adapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ncl.model.CreditSalesItem;
import com.ncl.pos.R;

import java.util.ArrayList;

public class CreditSalesAdapter extends RecyclerView.Adapter<CreditSalesAdapter.ViewHolder>{

    private ArrayList<CreditSalesItem> creditSalesItems;
    private Context context;
    private AppCompatActivity appCompatActivity;

    public CreditSalesAdapter(ArrayList<CreditSalesItem> creditSalesItems, Context context, AppCompatActivity appCompatActivity) {
        this.creditSalesItems = creditSalesItems;
        this.context = context;
        this.appCompatActivity = appCompatActivity;
    }

    @Override
    public CreditSalesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item_creditsales, parent, false);
        return new CreditSalesAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CreditSalesAdapter.ViewHolder holder, int position) {

        final CreditSalesItem item = creditSalesItems.get(position);
        holder.text_customername.setText(item.getCustomername());
        holder.text_product.setText(item.getProduct());
        holder.text_volume.setText(item.getVolume());
        holder.text_pump.setText(item.getPump());
        holder.text_amount.setText(item.getAmount());

    }

    @Override
    public int getItemCount() {
        return creditSalesItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView text_customername;
        TextView text_product;
        TextView text_volume;
        TextView text_pump;
        TextView text_amount;

        ViewHolder(View itemView) {
            super(itemView);

            text_customername = (TextView) itemView.findViewById(R.id.customername);
            text_product = (TextView) itemView.findViewById(R.id.productname);
            text_volume = (TextView) itemView.findViewById(R.id.volume);
            text_pump = (TextView) itemView.findViewById(R.id.pumpname);
            text_amount = (TextView) itemView.findViewById(R.id.amount);

        }
    }

}
