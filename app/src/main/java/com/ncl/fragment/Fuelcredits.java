package com.ncl.fragment;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.ncl.adapter.FuelSalesAdapter;
import com.ncl.model.FuelSalesItem;
import com.ncl.pos.CollectionDetails;
import com.ncl.pos.R;

import java.util.ArrayList;

@SuppressLint("ValidFragment")
public class Fuelcredits extends Fragment {

    RecyclerView recyclerView;
    ArrayList<FuelSalesItem> fuelSalesItems;

    FuelSalesAdapter adapter;
    Context context;
    AppCompatActivity appCompatActivity;
    RelativeLayout collectiondetails;
    private SearchView searchView;

    public Fuelcredits(Context context,AppCompatActivity appCompatActivity) {
        // Required empty public constructor
        this.context = context;
        this.appCompatActivity = appCompatActivity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fuelcredits, container, false);
        collectiondetails = (RelativeLayout) view.findViewById(R.id.collectiondetails);

        fuelSalesItems = new ArrayList<>();
        FuelSalesItem item = new FuelSalesItem("AGO1","Day","In progress","10000 tzs","1000","5000");
        fuelSalesItems.add(item);

        FuelSalesItem item0 = new FuelSalesItem("AGO1","Morning","In progress","10000 tzs","1000","5000");
        fuelSalesItems.add(item0);

        FuelSalesItem item1 = new FuelSalesItem("AGO2","Night","In progress","10000 tzs","1000","5000");
        fuelSalesItems.add(item1);

        FuelSalesItem item2 = new FuelSalesItem("K","Morning","In progress","10000 tzs","1000","5000");
        fuelSalesItems.add(item0);

        FuelSalesItem item3 = new FuelSalesItem("AGO1","Morning","In progress","10000 tzs","1000","5000");
        fuelSalesItems.add(item3);

        FuelSalesItem item4 = new FuelSalesItem("SAMPLE","Morning","In progress","10000 tzs","1000","5000");
        fuelSalesItems.add(item4);

        FuelSalesItem item5 = new FuelSalesItem("AGO1","Night","In progress","10000 tzs","1000","5000");
        fuelSalesItems.add(item5);

        FuelSalesItem item6 = new FuelSalesItem("AGO2","Morning","In progress","10000 tzs","1000","5000");
        fuelSalesItems.add(item6);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        adapter = new FuelSalesAdapter(fuelSalesItems,context,appCompatActivity);
        recyclerView.setAdapter(adapter);

        collectiondetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CollectionDetails.class);
                startActivity(intent);
            }
        });

        return view;

    }

    //Menu :Option menu
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        // TODO Add your menu entries here
        inflater.inflate(R.menu.menu_fuelsales, menu);
        super.onCreateOptionsMenu(menu, inflater);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) appCompatActivity.getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search)
                .getActionView();
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(appCompatActivity.getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        // listening to search query text change
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // filter recycler view when query submitted
                filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                // filter recycler view when text is changed
                filter(query);
                return false;
            }
        });
    }

    private void filter(String text) {
        //new array list that will hold the filtered data
        ArrayList<FuelSalesItem> filteredList = new ArrayList<>();

        for(int i=0; i<fuelSalesItems.size(); i++){
            FuelSalesItem row = fuelSalesItems.get(i);

            if (row.getPumpname().toLowerCase().contains(text)) {
                FuelSalesItem newitem = new FuelSalesItem();
                newitem.setPumpname(row.getPumpname());
                newitem.setShift(row.getShift());
                newitem.setShiftstatus(row.getShiftstatus());
                newitem.setAmount(row.getAmount());
                newitem.setOpening(row.getOpening());
                newitem.setClosing(row.getClosing());

                filteredList.add(newitem);
            }

        }

        //calling a method of the adapter class and passing the filtered list
        adapter.filterList(filteredList);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void whiteNotificationBar(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int flags = view.getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            view.setSystemUiVisibility(flags);
            appCompatActivity.getWindow().setStatusBarColor(Color.WHITE);
        }
    }

}