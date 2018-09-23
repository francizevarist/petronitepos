package com.ncl.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ncl.model.ItemList;
import com.ncl.model.LubricantItem;
import com.ncl.pos.R;

import java.util.ArrayList;

public class AdapterItemList extends RecyclerView.Adapter<AdapterItemList.ViewHolder> {
    private ArrayList<ItemList> itemLists;
    private Context context;
    private Activity appCompatActivity;

    public AdapterItemList(ArrayList<ItemList> itemLists, Context context, Activity appCompatActivity) {
        this.itemLists = itemLists;
        this.context = context;
        this.appCompatActivity = appCompatActivity;
    }

    @Override
    public AdapterItemList.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_itemlist, parent, false);
        return new AdapterItemList.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AdapterItemList.ViewHolder holder, int position) {

        final ItemList item = itemLists.get(position);
        holder.text_itemname.setText(item.getItem_name());

        if (position % 2 == 0) {
            holder.row.setCardBackgroundColor(ContextCompat.getColor(context, R.color.colorGrayLight));
        } else {
            holder.row.setCardBackgroundColor(ContextCompat.getColor(context, R.color.colorWhite));
        }
    }

    @Override
    public int getItemCount() {
        return itemLists.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView text_itemname;
        CardView row;

        ViewHolder(View itemView) {
            super(itemView);
            text_itemname = (TextView) itemView.findViewById(R.id.text_itemname);
            row = (CardView) itemView.findViewById(R.id.row_background);

        }
    }

    public void filterList(ArrayList<ItemList> filterdNames) {
        this.itemLists = filterdNames;
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