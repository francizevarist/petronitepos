package com.ncl.pos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.ncl.adapter.CartAdapter;
import com.ncl.model.CartItem;
import java.util.ArrayList;

public class CartList extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<CartItem> cartItems;
    CartAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartlist);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        //add items
        cartItems = new ArrayList<>();
        CartItem item0 = new CartItem("OIL","20000 TZS","10","90,000 TZS","30,000 TZS");
        cartItems.add(item0);

        CartItem item1 = new CartItem("OIL","20000 TZS","10","90,000 TZS","30,000 TZS");
        cartItems.add(item1);

        CartItem item2 = new CartItem("OIL","20000 TZS","10","90,000 TZS","30,000 TZS");
        cartItems.add(item2);

        CartItem item3 = new CartItem("OIL","20000 TZS","10","90,000 TZS","30,000 TZS");
        cartItems.add(item3);

        CartItem item4 = new CartItem("OIL","20000 TZS","10","90,000 TZS","30,000 TZS");
        cartItems.add(item4);

        CartItem item5 = new CartItem("OIL","20000 TZS","10","90,000 TZS","30,000 TZS");
        cartItems.add(item5);

        CartItem item6 = new CartItem("OIL","20000 TZS","10","90,000 TZS","30,000 TZS");
        cartItems.add(item6);

        CartItem item7 = new CartItem("OIL","20000 TZS","10","90,000 TZS","30,000 TZS");
        cartItems.add(item7);

        CartItem item8 = new CartItem("OIL","20000 TZS","10","90,000 TZS","30,000 TZS");
        cartItems.add(item8);

        CartItem item9 = new CartItem("OIL","20000 TZS","10","90,000 TZS","30,000 TZS");
        cartItems.add(item9);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter = new CartAdapter(cartItems,getApplicationContext(),CartList.this);
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
