package com.ncl.pos;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.ncl.adapter.LogsAdapter;
import com.ncl.model.LogItem;
import java.util.ArrayList;

public class Logs extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<LogItem> logItems;
    LogsAdapter adapter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logs);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        logItems = new ArrayList<>();
        LogItem item = new LogItem("Title 1","00:00:00  1-january-0000","Short description");
        logItems.add(item);

        LogItem item1 = new LogItem("Title 1","00:00:00  1-january-0000","Short description");
        logItems.add(item1);

        LogItem item2 = new LogItem("Title 1","00:00:00  1-january-0000","Short description");
        logItems.add(item2);

        LogItem item3 = new LogItem("Title 1","00:00:00  1-january-0000","Short description");
        logItems.add(item3);

        LogItem item4 = new LogItem("Title 1","00:00:00  1-january-0000","Short description");
        logItems.add(item4);

        LogItem item5 = new LogItem("Title 1","00:00:00  1-january-0000","Short description");
        logItems.add(item5);

        LogItem item6 = new LogItem("Title 1","00:00:00  1-january-0000","Short description");
        logItems.add(item6);

        LogItem item7 = new LogItem("Title 1","00:00:00  1-january-0000","Short description");
        logItems.add(item7);

        LogItem item8 = new LogItem("Title 1","00:00:00  1-january-0000","Short description");
        logItems.add(item8);

        LogItem item9 = new LogItem("Title 1","00:00:00  1-january-0000","Short description");
        logItems.add(item9);

        LogItem item10 = new LogItem("Title 1","00:00:00  1-january-0000","Short description");
        logItems.add(item10);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        adapter = new LogsAdapter(logItems,getApplicationContext(),Logs.this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id){
            case android.R.id.home:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
