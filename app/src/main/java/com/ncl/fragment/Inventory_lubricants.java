package com.ncl.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.cloudpos.scanserver.aidl.IScanService;
import com.cloudpos.scanserver.aidl.ScanParameter;
import com.cloudpos.scanserver.aidl.ScanResult;
import com.ncl.adapter.InventoryAdapter;
import com.ncl.control.AidlController;
import com.ncl.control.IAIDLListener;
import com.ncl.model.InventoryItem;
import com.ncl.pos.R;

import java.util.ArrayList;

@SuppressLint("ValidFragment")
public class Inventory_lubricants extends Fragment implements IAIDLListener{

    RecyclerView recyclerView;
    ArrayList<InventoryItem> inventoryItems;
    InventoryAdapter adapter;
    Context context;
    AppCompatActivity appCompatActivity;

    //scanner
    private IAIDLListener listener;
    private IScanService scanService; //扫码服务
    private ServiceConnection scanConn;


    @SuppressLint("ValidFragment")
    public Inventory_lubricants(Context context, AppCompatActivity appCompatActivity) {
        // Required empty public constructor
        this.context = context;
        this.appCompatActivity = appCompatActivity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listener = this;
        setHasOptionsMenu(true);
        AidlController.getInstance().startScanService(context,listener);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inventory_lubricants, container, false);

        inventoryItems = new ArrayList<>();
        InventoryItem item = new InventoryItem("Title 1","1000","2500","5","2","7000","1","3");
        inventoryItems.add(item);

        InventoryItem item1 = new InventoryItem("Title 1","1000","2500","5","2","7000","1","3");
        inventoryItems.add(item1);

        InventoryItem item2 = new InventoryItem("Title 1","1000","2500","5","2","7000","1","3");
        inventoryItems.add(item2);

        InventoryItem item3 = new InventoryItem("Title 1","1000","2500","5","2","7000","1","3");
        inventoryItems.add(item3);

        InventoryItem item4 = new InventoryItem("Title 1","1000","2500","5","2","7000","1","3");
        inventoryItems.add(item4);

        InventoryItem item5 = new InventoryItem("Title 1","1000","2500","5","2","7000","1","3");
        inventoryItems.add(item5);

        InventoryItem item6 = new InventoryItem("Title 1","1000","2500","5","2","7000","1","3");
        inventoryItems.add(item6);

        InventoryItem item7 = new InventoryItem("Title 1","1000","2500","5","2","7000","1","3");
        inventoryItems.add(item7);

        InventoryItem item8 = new InventoryItem("Title 1","1000","2500","5","2","7000","1","3");
        inventoryItems.add(item8);

        InventoryItem item9 = new InventoryItem("Title 1","1000","2500","5","2","7000","1","3");
        inventoryItems.add(item9);

        InventoryItem item10 = new InventoryItem("Title 1","1000","2500","5","2","7000","1","3");
        inventoryItems.add(item10);

        InventoryItem item11 = new InventoryItem("Title 1","1000","2500","5","2","7000","1","3");
        inventoryItems.add(item11);

        InventoryItem item12 = new InventoryItem("Title 1","1000","2500","5","2","7000","1","3");
        inventoryItems.add(item12);

        InventoryItem item13 = new InventoryItem("Title 1","1000","2500","5","2","7000","1","3");
        inventoryItems.add(item13);

        InventoryItem item14 = new InventoryItem("Title 1","1000","2500","5","2","7000","1","3");
        inventoryItems.add(item14);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        adapter = new InventoryAdapter(inventoryItems,context,appCompatActivity);
        recyclerView.setAdapter(adapter);

        return view;
    }

    //Menu :Option menu
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        // TODO Add your menu entries here
        inflater.inflate(R.menu.menu_inventory, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_cart:
                break;
            case R.id.action_addbarcode:
                ScanParameter parameter = new ScanParameter();
                try {
                    ScanResult result = scanService.scanBarcode(parameter);
                    if(result.getResultCode()==0) {
                        Toast.makeText(context, "No information Scanned", Toast.LENGTH_SHORT).show();
                    }else {
                        FragmentTransaction ft = appCompatActivity.getSupportFragmentManager().beginTransaction();
                        FragmentAddcodes newFragment = FragmentAddcodes.newInstance(result.getText().toString());
                        newFragment.show(ft, "add");
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
        }
        return true;

    }

    @Override
    public void serviceConnected(Object objService, ServiceConnection connection) {
        if(objService instanceof IScanService){
            scanService = (IScanService) objService;
            scanConn = connection;
        }
    }
}
