package com.ncl.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ncl.model.LubricantItem;
import com.ncl.pos.R;
import java.util.ArrayList;

public class LubricantAdapter extends RecyclerView.Adapter<LubricantAdapter.ViewHolder>{
    private ArrayList<LubricantItem> lubricantItems;
    private Context context;
    private AppCompatActivity appCompatActivity;

    public LubricantAdapter(ArrayList<LubricantItem> lubricantItems,Context context,AppCompatActivity appCompatActivity) {
        this.lubricantItems = lubricantItems;
        this.context = context;
        this.appCompatActivity = appCompatActivity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item_lubricant, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final LubricantItem item = lubricantItems.get(position);

        holder.text_stocksize.setText(item.getStocksize());
        holder.text_itemname.setText(item.getItem_name());
        holder.text_itemprice.setText(item.getItem_price());

        if(position%2==0) {
            holder.row.setCardBackgroundColor(ContextCompat.getColor(context, R.color.colorGrayLight));
        } else {
            holder.row.setCardBackgroundColor(ContextCompat.getColor(context,R.color.colorWhite));
        }

        /*holder.row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
    }

    @Override
    public int getItemCount() {
        return lubricantItems.size();
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

    public void filterList(ArrayList<LubricantItem> filterdNames) {
        this.lubricantItems = filterdNames;
        notifyDataSetChanged();
    }




    //-------------------------------------- click interface ---------------------------------------
    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private LubricantAdapter.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final LubricantAdapter.ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }

}
