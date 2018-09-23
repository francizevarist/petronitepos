package com.ncl.adapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ncl.model.LogItem;
import com.ncl.pos.R;
import java.util.ArrayList;

public class LogsAdapter extends RecyclerView.Adapter<LogsAdapter.ViewHolder> {

    private ArrayList<LogItem> logItems;
    private Context context;
    private AppCompatActivity appCompatActivity;

    public LogsAdapter(ArrayList<LogItem> logItems, Context context, AppCompatActivity appCompatActivity) {
        this.logItems = logItems;
        this.context = context;
        this.appCompatActivity = appCompatActivity;
    }

    @Override
    public LogsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item_activitylog, parent, false);
        return new LogsAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(LogsAdapter.ViewHolder holder, int position) {

        final LogItem item = logItems.get(position);
        holder.text_title.setText(item.getTitle());
        holder.text_time.setText(item.getTime());
        holder.text_description.setText(item.getDescription());

    }

    @Override
    public int getItemCount() {
        return logItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView text_title;
        TextView text_time;
        TextView text_description;

        ViewHolder(View itemView) {
            super(itemView);
            text_title = (TextView) itemView.findViewById(R.id.title);
            text_time = (TextView) itemView.findViewById(R.id.time);
            text_description = (TextView) itemView.findViewById(R.id.description);
        }

    }

}