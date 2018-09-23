package com.ncl.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cloudpos.scanserver.aidl.IScanService;
import com.cloudpos.scanserver.aidl.ScanParameter;
import com.cloudpos.scanserver.aidl.ScanResult;
import com.ncl.adapter.LubricantAdapter;
import com.ncl.control.AidlController;
import com.ncl.control.IAIDLListener;
import com.ncl.model.LubricantItem;
import com.ncl.pos.CartList;
import com.ncl.pos.R;
import com.ncl.pos.Scanner;
import java.util.ArrayList;

@SuppressLint("ValidFragment")
public class Lubricants extends Fragment implements IAIDLListener {

    RecyclerView recyclerView;
    EditText editTextSearch;
    ArrayList<LubricantItem> lubricantItems;
    LubricantAdapter adapter;
    ImageView searchbutton;
    Context context;
    AppCompatActivity appCompatActivity;
    private IAIDLListener listener;

    TextView textCartItemCount;
    int mCartItemCount = 10;

    private IScanService scanService; //扫码服务
    private ServiceConnection scanConn;

    public Lubricants(Context context, AppCompatActivity appCompatActivity) {
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
        View view =  inflater.inflate(R.layout.fragment_lubricants, container, false);
        searchbutton = (ImageView) view.findViewById(R.id.searchbutton);

        lubricantItems = new ArrayList<>();

        LubricantItem item1 = new LubricantItem("900","OIL","1900 tzs");
        lubricantItems.add(item1);

        LubricantItem item2 = new LubricantItem("70","OIL BLUE","500 tzs");
        lubricantItems.add(item1);

        LubricantItem item3 = new LubricantItem("100","GOLD LUBES","1700 tzs");
        lubricantItems.add(item3);

        LubricantItem item4 = new LubricantItem("9","PETRONITE LB","800 tzs");
        lubricantItems.add(item4);

        LubricantItem item5 = new LubricantItem("960","SUPER OIL","100 tzs");
        lubricantItems.add(item5);

        LubricantItem item6 = new LubricantItem("80","GEAR","45000 tzs");
        lubricantItems.add(item6);

        LubricantItem item7 = new LubricantItem("940","LAKE OIL","1000 tzs");
        lubricantItems.add(item7);

        LubricantItem item8 = new LubricantItem("40","NITRO","1200 tzs");
        lubricantItems.add(item8);

        LubricantItem item9 = new LubricantItem("50","LUQID CRYSTAL","3900 tzs");
        lubricantItems.add(item9);

        LubricantItem item10 = new LubricantItem("700","CASTOL","4500 tzs");
        lubricantItems.add(item10);

        LubricantItem item11 = new LubricantItem("906","MOTOR OLI","1500 tzs");
        lubricantItems.add(item11);

        LubricantItem item12 = new LubricantItem("10","MECHANICS","4000 tzs");
        lubricantItems.add(item12);

        LubricantItem item13 = new LubricantItem("70","WHITE POWER","1400 tzs");
        lubricantItems.add(item13);


        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        editTextSearch = (EditText) view.findViewById(R.id.editTextSearch);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        adapter = new LubricantAdapter(lubricantItems,context,appCompatActivity);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new LubricantAdapter.RecyclerTouchListener(context, recyclerView, new LubricantAdapter.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                final LubricantItem item = lubricantItems.get(position);
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

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                searchbutton.setImageResource(R.drawable.ic_cancel);
                if(charSequence.toString().length()==0){
                    searchbutton.setImageResource(R.drawable.ic_search);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //after the change calling the method and passing the search input
                filter(editable.toString());
                if(editable.toString().equals("")){
                    searchbutton.setImageResource(R.drawable.ic_search);
                }else {
                    searchbutton.setImageResource(R.drawable.ic_cancel);
                }
            }
        });

        searchbutton.setOnClickListener(click_search);

        return view;
    }

    private void filter(String text) {
        //new array list that will hold the filtered data
        ArrayList<LubricantItem> filteredList = new ArrayList<>();

        for(int i=0; i<lubricantItems.size(); i++){
            LubricantItem row = lubricantItems.get(i);

            if (row.getItem_name().toLowerCase().contains(text)) {
                LubricantItem newitem = new LubricantItem();
                newitem.setStocksize(row.getStocksize());
                newitem.setItem_name(row.getItem_name());
                newitem.setItem_price(row.getItem_price());
                filteredList.add(newitem);
            }

        }
        //calling a method of the adapter class and passing the filtered list
        adapter.filterList(filteredList);
    }

    View.OnClickListener click_search = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            editTextSearch.getText().clear();
        }
    };

    //Menu :Option menu
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        // TODO Add your menu entries here
        inflater.inflate(R.menu.menu_lubricants, menu);
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
                ScanParameter parameter = new ScanParameter();
                try {
                    ScanResult result = scanService.scanBarcode(parameter);
                    Log.e("WAAATTT=",String.valueOf(result));
                   if(result.getResultCode()==0) {
                        Toast.makeText(context, "No information Scanned", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(context, result.getText().toString(), Toast.LENGTH_LONG).show();
                        addCartDialog("Item name", "10");
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
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

    @Override
    public void serviceConnected(Object objService, ServiceConnection connection) {
        if(objService instanceof IScanService){
            scanService = (IScanService) objService;
            scanConn = connection;
        }
    }


    /**
     * Add to cart item: updated 07-sep-2018
     */
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
                    quantity.getText().clear();
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
                }else if(current_value < 1){
                    quantity.getText().clear();
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
                if(quantity.getText().toString().equals("")){
                    quantity.setError("Add Quantity");
                }else {
                    alertDialog.hide();
                }
            }
        });
    }


}