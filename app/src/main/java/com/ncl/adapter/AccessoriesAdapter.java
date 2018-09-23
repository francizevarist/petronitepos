package com.ncl.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ncl.model.AccessoriesItem;
import com.ncl.pos.R;

import java.util.ArrayList;

public class AccessoriesAdapter extends RecyclerView.Adapter<AccessoriesAdapter.ViewHolder>{
    private ArrayList<AccessoriesItem> accessoriesItems;
    private Context context;
    private AppCompatActivity appCompatActivity;

    public AccessoriesAdapter(ArrayList<AccessoriesItem> accessoriesItems,Context context,AppCompatActivity appCompatActivity) {
        this.accessoriesItems = accessoriesItems;
        this.context = context;
        this.appCompatActivity = appCompatActivity;
    }

    @Override
    public AccessoriesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item_lubricant, parent, false);
        return new AccessoriesAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AccessoriesAdapter.ViewHolder holder, int position) {

        final AccessoriesItem item = accessoriesItems.get(position);

        holder.text_stocksize.setText(item.getStocksize());
        holder.text_itemname.setText(item.getItem_name());
        holder.text_itemprice.setText(item.getItem_price());

        if(position%2==0) {
            holder.row.setCardBackgroundColor(ContextCompat.getColor(context, R.color.colorGrayLight));
        } else {
            holder.row.setCardBackgroundColor(ContextCompat.getColor(context,R.color.colorWhite));
        }

        holder.row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean numeric = true;
                try {

                }catch (NumberFormatException e){
                    numeric = false;
                }

                if(numeric) {
                    addCartDialog(item.getItem_name(), item.getStocksize());
                }else {
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return accessoriesItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView text_stocksize;
        TextView text_itemname;
        TextView text_itemprice;
        CardView row;

        ViewHolder(View itemView) {
            super(itemView);

            text_stocksize = (TextView) itemView.findViewById(R.id.text_stocksize);
            text_itemname = (TextView) itemView.findViewById(R.id.text_itemname);
            text_itemprice = (TextView) itemView.findViewById(R.id.text_itemprice);
            row = (CardView) itemView.findViewById(R.id.row_background);

        }
    }

    private void addCartDialog(String itemname, final String stocksize){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(appCompatActivity);
        // ...Irrelevant code for customizing the buttons and title
        LayoutInflater inflater = (appCompatActivity).getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.layout_dialog_addtocart, null);
        dialogBuilder.setView(dialogView);

        TextView title = (TextView) dialogView.findViewById(R.id.cart_title);
        final EditText quantity = (EditText) dialogView.findViewById(R.id.cart_quantity);
        ImageView remove = (ImageView) dialogView.findViewById(R.id.cart_remove);
        ImageView add = (ImageView) dialogView.findViewById(R.id.cart_add);
        RelativeLayout cancel = (RelativeLayout) dialogView.findViewById(R.id.cart_cancel);
        RelativeLayout save = (RelativeLayout) dialogView.findViewById(R.id.cart_save);

        //set title
        title.setText(itemname);
        //save quantity default value
        quantity.setText("1");
        quantity.setSelection(quantity.getText().length());

        if(quantity.getText().toString().equals("")){
            quantity.setText("1");
            quantity.setSelection(quantity.getText().length());
        }

        //ontype check:values
        quantity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(quantity.getText().toString().equals("")){
                    quantity.setText("1");
                    quantity.setSelection(quantity.getText().length());
                }else {
                    int current_value = Integer.parseInt(quantity.getText().toString().trim());
                    int stocksize_value = Integer.parseInt(stocksize.trim());
                    if(current_value > stocksize_value) {
                        quantity.setText(stocksize);
                        quantity.setSelection(quantity.getText().length());
                    }
                }
            }
        });


        //remove item
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int current_value = Integer.parseInt(quantity.getText().toString().trim());

                if(current_value > 1) {
                    int decreased_value = current_value - 1;
                    quantity.setText(Integer.toString(decreased_value));
                    quantity.setSelection(quantity.getText().length());
                }

            }
        });

        //add item
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int current_value = Integer.parseInt(quantity.getText().toString().trim());

                int stocksize_value = Integer.parseInt(stocksize.trim());
                if(current_value < stocksize_value) {
                    int added_value = current_value + 1;
                    quantity.setText(Integer.toString(added_value));
                    quantity.setSelection(quantity.getText().length());
                }

            }
        });

        //----------------------------------------------------------------------------------------

        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.setCancelable(false);
        alertDialog.show();

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.hide();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.hide();
            }
        });
    }

}