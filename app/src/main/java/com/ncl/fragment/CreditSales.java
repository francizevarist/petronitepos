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
import com.ncl.adapter.CreditSalesAdapter;
import com.ncl.model.CreditSalesItem;
import com.ncl.pos.R;
import java.util.ArrayList;

@SuppressLint("ValidFragment")
public class CreditSales extends Fragment {

    RecyclerView recyclerViewdown;
    ArrayList<CreditSalesItem> creditSalesItems;
    CreditSalesAdapter creditSalesAdapter;

    Context context;
    AppCompatActivity appCompatActivity;

    @SuppressLint("ValidFragment")
    public CreditSales(Context context, AppCompatActivity appCompatActivity) {
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
        View view =  inflater.inflate(R.layout.fragment_creditsales, container, false);

        creditSalesItems = new ArrayList<>();

        CreditSalesItem itemdown = new CreditSalesItem("NMB","Disel","20,000","40,000","700,000");
        creditSalesItems.add(itemdown);

        CreditSalesItem itemdown1 = new CreditSalesItem("CRDB","Disel","20,000","40,000","700,000");
        creditSalesItems.add(itemdown1);

        CreditSalesItem itemdown2 = new CreditSalesItem("TOYOTA","Disel","20,000","40,000","700,000");
        creditSalesItems.add(itemdown2);

        CreditSalesItem itemdown3 = new CreditSalesItem("NASA","Disel","20,000","40,000","700,000");
        creditSalesItems.add(itemdown3);

        CreditSalesItem itemdown4 = new CreditSalesItem("NMB","Disel","20,000","40,000","700,000");
        creditSalesItems.add(itemdown4);

        CreditSalesItem itemdown5 = new CreditSalesItem("NMB","Disel","20,000","40,000","700,000");
        creditSalesItems.add(itemdown5);

        CreditSalesItem itemdown6 = new CreditSalesItem("NMB","Disel","20,000","40,000","700,000");
        creditSalesItems.add(itemdown6);

        CreditSalesItem itemdown7 = new CreditSalesItem("NMB","Disel","20,000","40,000","700,000");
        creditSalesItems.add(itemdown7);

        recyclerViewdown = (RecyclerView) view.findViewById(R.id.recyclerViewdown);
        recyclerViewdown.setHasFixedSize(true);
        recyclerViewdown.setLayoutManager(new LinearLayoutManager(context));
        creditSalesAdapter = new CreditSalesAdapter(creditSalesItems,context,appCompatActivity);
        recyclerViewdown.setAdapter(creditSalesAdapter);

        return view;
    }

}
