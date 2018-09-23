package com.ncl.adapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ncl.model.CartItem;
import com.ncl.pos.R;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder>{
    private ArrayList<CartItem> cartItems;
    private Context context;
    private AppCompatActivity appCompatActivity;

    public CartAdapter(ArrayList<CartItem> cartItems,Context context,AppCompatActivity appCompatActivity) {
        this.cartItems = cartItems;
        this.context = context;
        this.appCompatActivity = appCompatActivity;
    }

    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item_cart, parent, false);
        return new CartAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CartAdapter.ViewHolder holder, int position) {

        final CartItem item = cartItems.get(position);
        holder.name.setText(item.getName());
        holder.price.setText(item.getPrice());
        holder.quantity.setText(item.getQuantity());
        holder.totalamount.setText(item.getTotalamount());
        holder.discount.setText(item.getDiscount());

    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView price;
        TextView quantity;
        TextView totalamount;
        TextView discount;
        CardView row;

        ViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);
            price = (TextView) itemView.findViewById(R.id.price);
            quantity = (TextView) itemView.findViewById(R.id.quantity);
            totalamount = (TextView) itemView.findViewById(R.id.amount);
            discount = (TextView) itemView.findViewById(R.id.discount);
            row = (CardView) itemView.findViewById(R.id.row_background);

        }
    }

}
