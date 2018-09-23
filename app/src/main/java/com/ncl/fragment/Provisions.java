package com.ncl.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ncl.adapter.ProvisionAdapter;
import com.ncl.model.ProvisionItem;
import com.ncl.pos.R;
import java.util.ArrayList;

@SuppressLint("ValidFragment")
public class Provisions extends Fragment {

    RecyclerView recyclerViewtop;
    ArrayList<ProvisionItem> provisionItems;
    ProvisionAdapter provisionAdapter;
    Context context;
    AppCompatActivity appCompatActivity;

    @SuppressLint("ValidFragment")
    public Provisions(Context context, AppCompatActivity appCompatActivity) {
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
        View view =  inflater.inflate(R.layout.fragment_provisions, container, false);
        provisionItems = new ArrayList<>();

        ProvisionItem item1 = new ProvisionItem("FRANCIS","20-07-2018","10,000","Discount ya ndinga ya NCL");
        provisionItems.add(item1);

        ProvisionItem item2 = new ProvisionItem("FRANCIS","20-07-2018","10,000","Discount ya ndinga ya NCL");
        provisionItems.add(item2);

        ProvisionItem item3 = new ProvisionItem("FRANCIS","20-07-2018","10,000","Discount ya ndinga ya NCL");
        provisionItems.add(item3);

        ProvisionItem item4 = new ProvisionItem("FRANCIS","20-07-2018","10,000","Discount ya ndinga ya NCL");
        provisionItems.add(item4);

        ProvisionItem item5 = new ProvisionItem("FRANCIS","20-07-2018","10,000","Discount ya ndinga ya NCL");
        provisionItems.add(item5);

        ProvisionItem item6 = new ProvisionItem("FRANCIS","20-07-2018","10,000","Discount ya ndinga ya NCL");
        provisionItems.add(item6);

        ProvisionItem item7 = new ProvisionItem("FRANCIS","20-07-2018","10,000","Discount ya ndinga ya NCL");
        provisionItems.add(item7);

        ProvisionItem item8 = new ProvisionItem("FRANCIS","20-07-2018","10,000","Discount ya ndinga ya NCL");
        provisionItems.add(item8);

        ProvisionItem item9 = new ProvisionItem("FRANCIS","20-07-2018","10,000","Discount ya ndinga ya NCL");
        provisionItems.add(item1);

        ProvisionItem item10 = new ProvisionItem("FRANCIS","20-07-2018","10,000","Discount ya ndinga ya NCL");
        provisionItems.add(item10);

        recyclerViewtop = (RecyclerView) view.findViewById(R.id.recyclerViewtop);
        recyclerViewtop.setHasFixedSize(true);
        recyclerViewtop.setLayoutManager(new LinearLayoutManager(context));
        provisionAdapter = new ProvisionAdapter(provisionItems,context,appCompatActivity);
        recyclerViewtop.setAdapter(provisionAdapter);
        return view;
    }

}
