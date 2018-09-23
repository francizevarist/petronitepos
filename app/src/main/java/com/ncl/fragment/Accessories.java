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
import com.ncl.adapter.AccessoriesAdapter;
import com.ncl.model.AccessoriesItem;
import com.ncl.pos.CartList;
import com.ncl.pos.R;
import com.ncl.pos.Scanner;

import java.util.ArrayList;

@SuppressLint("ValidFragment")
public class Accessories extends Fragment {

    RecyclerView recyclerView;
    ArrayList<AccessoriesItem> accessoriesItems;

    AccessoriesAdapter adapter;

    Context context;
    AppCompatActivity appCompatActivity;

    TextView textCartItemCount;
    int mCartItemCount = 10;

    @SuppressLint("ValidFragment")
    public Accessories(Context context, AppCompatActivity appCompatActivity) {
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
        View view = inflater.inflate(R.layout.fragment_accessories, container, false);

        accessoriesItems = new ArrayList<>();

        AccessoriesItem item0 = new AccessoriesItem("100","GAS BURNER","150,000 TZS");
        accessoriesItems.add(item0);

        AccessoriesItem item1 = new AccessoriesItem("100","GAS BURNER","150,000 TZS");
        accessoriesItems.add(item1);

        AccessoriesItem item2 = new AccessoriesItem("100","GAS BURNER","150,000 TZS");
        accessoriesItems.add(item2);

        AccessoriesItem item3 = new AccessoriesItem("100","GAS BURNER","150,000 TZS");
        accessoriesItems.add(item3);

        AccessoriesItem item4 = new AccessoriesItem("100","GAS BURNER","150,000 TZS");
        accessoriesItems.add(item4);

        AccessoriesItem item5 = new AccessoriesItem("100","GAS BURNER","150,000 TZS");
        accessoriesItems.add(item5);

        AccessoriesItem item6 = new AccessoriesItem("100","GAS BURNER","150,000 TZS");
        accessoriesItems.add(item6);

        AccessoriesItem item7 = new AccessoriesItem("100","GAS BURNER","150,000 TZS");
        accessoriesItems.add(item7);

        AccessoriesItem item8 = new AccessoriesItem("100","GAS BURNER","150,000 TZS");
        accessoriesItems.add(item8);

        AccessoriesItem item9 = new AccessoriesItem("100","GAS BURNER","150,000 TZS");
        accessoriesItems.add(item9);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        adapter = new AccessoriesAdapter(accessoriesItems,context,appCompatActivity);

        recyclerView.setAdapter(adapter);

        return view;
    }


    //Menu :Option menu
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        // TODO Add your menu entries here
        inflater.inflate(R.menu.menu_accessories, menu);
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
            case R.id.action_barcode:
                Intent intent1 = new Intent(context, Scanner.class);
                startActivity(intent1);
                break;

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