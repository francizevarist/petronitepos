package com.ncl.adapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ncl.model.CollectionItem;
import com.ncl.pos.R;
import java.util.ArrayList;

public class CollectionAdapter extends RecyclerView.Adapter<CollectionAdapter.ViewHolder>{

    private ArrayList<CollectionItem> collectionItems;
    private Context context;
    private AppCompatActivity appCompatActivity;

    public CollectionAdapter(ArrayList<CollectionItem> collectionItems, Context context, AppCompatActivity appCompatActivity) {
        this.collectionItems = collectionItems;
        this.context = context;
        this.appCompatActivity = appCompatActivity;
    }

    @Override
    public CollectionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item_collection, parent, false);
        return new CollectionAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CollectionAdapter.ViewHolder holder, int position) {

        final CollectionItem item = collectionItems.get(position);
        holder.text_pumpname.setText(item.getPumpname());
        holder.text_opening.setText(item.getOpening());
        holder.text_closing.setText(item.getClosing());
        holder.text_cash.setText(item.getCash());
        holder.text_credit.setText(item.getCredit());
        holder.text_amount.setText(item.getAmount());
        holder.text_opening.setText(item.getOpening());
        holder.text_closing.setText(item.getClosing());

    }

    @Override
    public int getItemCount() {
        return collectionItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView text_pumpname;
        TextView text_opening;
        TextView text_closing;
        TextView text_cash;
        TextView text_credit;
        TextView text_amount;
        TextView text_shortexcess;

        ViewHolder(View itemView) {
            super(itemView);

            text_pumpname = (TextView) itemView.findViewById(R.id.pumpname);
            text_opening = (TextView) itemView.findViewById(R.id.opening);
            text_closing = (TextView) itemView.findViewById(R.id.closing);
            text_cash = (TextView) itemView.findViewById(R.id.cash);
            text_credit = (TextView) itemView.findViewById(R.id.credit);
            text_amount = (TextView) itemView.findViewById(R.id.amount);
            text_shortexcess = (TextView) itemView.findViewById(R.id.shortexcess);

        }
    }

}
