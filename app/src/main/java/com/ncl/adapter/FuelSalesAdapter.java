package com.ncl.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ncl.model.FuelSalesItem;
import com.ncl.pos.AddCredit;
import com.ncl.pos.R;

import java.util.ArrayList;

public class FuelSalesAdapter extends RecyclerView.Adapter<FuelSalesAdapter.ViewHolder>{

    private ArrayList<FuelSalesItem> fuelSalesItems;
    private Context context;
    private AppCompatActivity appCompatActivity;

    public FuelSalesAdapter(ArrayList<FuelSalesItem> fuelSalesItems,Context context,AppCompatActivity appCompatActivity) {
        this.fuelSalesItems = fuelSalesItems;
        this.context = context;
        this.appCompatActivity = appCompatActivity;
    }

    @Override
    public FuelSalesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item_fuelsales, parent, false);
        return new FuelSalesAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FuelSalesAdapter.ViewHolder holder, int position) {

        final FuelSalesItem item = fuelSalesItems.get(position);
        holder.text_pumpname.setText("PUMP : "+item.getPumpname());
        holder.text_shift.setText(item.getShift());
        holder.text_shiftstatus.setText(item.getShiftstatus());
        holder.text_amount.setText(item.getAmount());
        holder.text_opening.setText(item.getOpening());
        holder.text_closing.setText(item.getClosing());

        holder.addcredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AddCredit.class);
                appCompatActivity.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return fuelSalesItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView text_pumpname;
        TextView text_shift;
        TextView text_shiftstatus;
        TextView text_amount;
        TextView text_opening;
        TextView text_closing;
        RelativeLayout addcredit;
        RelativeLayout closesfhift;

        ViewHolder(View itemView) {
            super(itemView);

            text_pumpname = (TextView) itemView.findViewById(R.id.pumpname);
            text_shift = (TextView) itemView.findViewById(R.id.shift);
            text_shiftstatus = (TextView) itemView.findViewById(R.id.shiftstatus);
            text_amount = (TextView) itemView.findViewById(R.id.amount);
            text_opening = (TextView) itemView.findViewById(R.id.opening);
            text_closing = (TextView) itemView.findViewById(R.id.closing);
            addcredit = (RelativeLayout) itemView.findViewById(R.id.addcredit);
            closesfhift = (RelativeLayout) itemView.findViewById(R.id.closeshift);

        }
    }

    public void filterList(ArrayList<FuelSalesItem> fuelSalesItems) {
        this.fuelSalesItems = fuelSalesItems;
        notifyDataSetChanged();
    }

    public interface ItemAdapterListener {
        void onContactSelected(FuelSalesItem contact);
    }

}
