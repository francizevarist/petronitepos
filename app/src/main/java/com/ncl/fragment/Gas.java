package com.ncl.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ncl.adapter.GasAdapter;
import com.ncl.model.GasItem;
import com.ncl.pos.CartList;
import com.ncl.pos.R;

import java.util.ArrayList;

@SuppressLint("ValidFragment")
public class Gas extends Fragment {

    RecyclerView recyclerView;
    ArrayList<GasItem> gasItems;
    GasAdapter adapter;

    Context context;
    AppCompatActivity appCompatActivity;

    TextView textCartItemCount;
    int mCartItemCount = 10;

    @SuppressLint("ValidFragment")
    public Gas(Context context, AppCompatActivity appCompatActivity) {
        // Required empty public constructor
        this.context = context;
        this.appCompatActivity = appCompatActivity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gas, container, false);

        gasItems = new ArrayList<>();

        GasItem item0 = new GasItem("LAKE");
        gasItems.add(item0);

        GasItem item1 = new GasItem("AFROIL GAS");
        gasItems.add(item1);

        GasItem item2 = new GasItem("ORYXX");
        gasItems.add(item2);

        GasItem item3 = new GasItem("NCL GAS");
        gasItems.add(item3);

        GasItem item4 = new GasItem("SONGAS");
        gasItems.add(item4);

        GasItem item5 = new GasItem("DANGOTE GAS");
        gasItems.add(item5);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        adapter = new GasAdapter(gasItems,context,appCompatActivity);
        recyclerView.setAdapter(adapter);

        return view;
    }


    //Menu :Option menu
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        // TODO Add your menu entries here
        inflater.inflate(R.menu.menu_gas, menu);
        super.onCreateOptionsMenu(menu, inflater);

        final MenuItem menuItem = menu.findItem(R.id.action_cart);

        View actionView = MenuItemCompat.getActionView(menuItem);
        textCartItemCount = (TextView) actionView.findViewById(R.id.cart_badge);

        setupBadge();

        actionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOptionsItemSelected(menuItem);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_cart:
                Intent intent2 = new Intent(context, CartList.class);
                startActivity(intent2);
                break;
        }
        return true;

    }

    private void setupBadge() {

        if (textCartItemCount != null) {
            if (mCartItemCount == 0) {
                if (textCartItemCount.getVisibility() != View.GONE) {
                    textCartItemCount.setVisibility(View.GONE);
                }
            } else {
                textCartItemCount.setText(String.valueOf(Math.min(mCartItemCount, 99)));
                if (textCartItemCount.getVisibility() != View.VISIBLE) {
                    textCartItemCount.setVisibility(View.VISIBLE);
                }
            }
        }
    }



}