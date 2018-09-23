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
import com.ncl.adapter.CollectionAdapter;
import com.ncl.model.CollectionItem;
import com.ncl.pos.R;

import java.util.ArrayList;

@SuppressLint("ValidFragment")
public class Collections extends Fragment {

    RecyclerView recyclerViewtop;
    ArrayList<CollectionItem> collectionItems;
    CollectionAdapter collectionAdapter;
    Context context;
    AppCompatActivity appCompatActivity;

    @SuppressLint("ValidFragment")
    public Collections(Context context, AppCompatActivity appCompatActivity) {
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
        View view =  inflater.inflate(R.layout.fragment_collection, container, false);
        collectionItems = new ArrayList<>();

        //top
        CollectionItem itemtop = new CollectionItem("AGO","1000","2000","7000","400","3000","100,000","700,000","300");
        collectionItems.add(itemtop);

        CollectionItem itemtop1 = new CollectionItem("AGO","1000","2000","7000","400","3000","100,000","700,000","300");
        collectionItems.add(itemtop1);

        CollectionItem itemtop2 = new CollectionItem("AGO","1000","2000","7000","400","3000","100,000","700,000","300");
        collectionItems.add(itemtop2);

        CollectionItem itemtop3 = new CollectionItem("AGO","1000","2000","7000","400","3000","100,000","700,000","300");
        collectionItems.add(itemtop3);

        CollectionItem itemtop4 = new CollectionItem("AGO","1000","2000","7000","400","3000","100,000","700,000","300");
        collectionItems.add(itemtop4);

        CollectionItem itemtop5 = new CollectionItem("AGO","1000","2000","7000","400","3000","100,000","700,000","300");
        collectionItems.add(itemtop5);

        CollectionItem itemtop6 = new CollectionItem("AGO","1000","2000","7000","400","3000","100,000","700,000","300");
        collectionItems.add(itemtop6);

        CollectionItem itemtop7 = new CollectionItem("AGO","1000","2000","7000","400","3000","100,000","700,000","300");
        collectionItems.add(itemtop7);

        CollectionItem itemtop8 = new CollectionItem("AGO","1000","2000","7000","400","3000","100,000","700,000","300");
        collectionItems.add(itemtop8);

        recyclerViewtop = (RecyclerView) view.findViewById(R.id.recyclerViewtop);
        recyclerViewtop.setHasFixedSize(true);
        recyclerViewtop.setLayoutManager(new LinearLayoutManager(context));
        collectionAdapter = new CollectionAdapter(collectionItems,context,appCompatActivity);
        recyclerViewtop.setAdapter(collectionAdapter);

        return view;
    }


}
