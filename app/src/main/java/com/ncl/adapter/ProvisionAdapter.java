package com.ncl.adapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ncl.model.ProvisionItem;
import com.ncl.pos.R;

import java.util.ArrayList;

public class ProvisionAdapter extends RecyclerView.Adapter<ProvisionAdapter.ViewHolder>{

    private ArrayList<ProvisionItem> provisionItems;
    private Context context;
    private AppCompatActivity appCompatActivity;

    public ProvisionAdapter(ArrayList<ProvisionItem> provisionItems, Context context, AppCompatActivity appCompatActivity) {
        this.provisionItems = provisionItems;
        this.context = context;
        this.appCompatActivity = appCompatActivity;
    }

    @Override
    public ProvisionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row_provision, parent, false);
        return new ProvisionAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ProvisionAdapter.ViewHolder holder, int position) {

        final ProvisionItem item = provisionItems.get(position);
        holder.text_orderby.setText("ORDERED BY : "+item.getOrderby());
        holder.text_date.setText(item.getDate());
        holder.text_amount.setText(item.getAmount());
        holder.text_notes.setText(item.getNotes());

    }

    @Override
    public int getItemCount() {
        return provisionItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView text_orderby;
        TextView text_date;
        TextView text_amount;
        TextView text_notes;

        ViewHolder(View itemView) {
            super(itemView);

            text_orderby = (TextView) itemView.findViewById(R.id.orderby);
            text_date = (TextView) itemView.findViewById(R.id.date);
            text_amount = (TextView) itemView.findViewById(R.id.amount);
            text_notes = (TextView) itemView.findViewById(R.id.notes);

        }
    }

}
