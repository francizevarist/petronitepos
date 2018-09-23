package com.ncl.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ncl.adapter.AdapterItemList;
import com.ncl.adapter.LubricantAdapter;
import com.ncl.model.ItemList;
import com.ncl.model.LubricantItem;
import com.ncl.pos.R;

import java.util.ArrayList;

public class FragmentAddcodes extends DialogFragment {


    private String TAG = FragmentAddcodes.class.getSimpleName();
    RecyclerView recyclerView;
    EditText editTextSearch;
    ArrayList<ItemList> itemLists;
    ArrayList<ItemList> temp_itemLists;
    AdapterItemList adapter;
    ImageView searchbutton;
    private static String selectedcode;

    private static FragmentAddcodes dialogFragment;
    static FragmentAddcodes newInstance(String codes) {
        selectedcode = codes;
        FragmentAddcodes f = new FragmentAddcodes();
        dialogFragment = f;
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_addcodes, container, false);

        searchbutton = (ImageView) view.findViewById(R.id.searchbutton);

        itemLists = new ArrayList<>();
        temp_itemLists = new ArrayList<>();

        ItemList item1 = new ItemList("OIL");
        itemLists.add(item1);

        ItemList item2 = new ItemList("OIL BLUE");
        itemLists.add(item1);

        ItemList item3 = new ItemList("GOLD LUBES");
        itemLists.add(item3);

        ItemList item4 = new ItemList("PETRONITE LB");
        itemLists.add(item4);

        ItemList item5 = new ItemList("SUPER OIL");
        itemLists.add(item5);

        ItemList item6 = new ItemList("GEAR");
        itemLists.add(item6);

        ItemList item7 = new ItemList("LAKE OIL");
        itemLists.add(item7);

        ItemList item8 = new ItemList("NITRO");
        itemLists.add(item8);

        ItemList item9 = new ItemList("LUQID CRYSTAL");
        itemLists.add(item9);

        ItemList item10 = new ItemList("CASTOL");
        itemLists.add(item10);

        ItemList item11 = new ItemList("MOTOR OLI");
        itemLists.add(item11);

        ItemList item12 = new ItemList("MECHANICS");
        itemLists.add(item12);

        ItemList item13 = new ItemList("WHITE POWER");
        itemLists.add(item13);
        temp_itemLists.addAll(itemLists);


        /**
         * ui
         */
        Button cancel = (Button) view.findViewById(R.id.cancel);
        Button addcode = (Button) view.findViewById(R.id.addcode);
        TextView scannedcode = (TextView) view.findViewById(R.id.scannedcode);
        final TextView selecteditem = (TextView) view.findViewById(R.id.itemselected);
        scannedcode.setText(selectedcode);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        editTextSearch = (EditText) view.findViewById(R.id.editTextSearch);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new AdapterItemList(itemLists,getContext(),getActivity());
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new LubricantAdapter.RecyclerTouchListener(getContext(), recyclerView, new LubricantAdapter.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                final ItemList item = itemLists.get(position);
                boolean numeric = true;
                try {
                }catch (NumberFormatException e){
                    numeric = false;
                }

                if(numeric) {
                    selecteditem.setText(item.getItem_name());
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
                    itemLists.clear();
                    itemLists.addAll(temp_itemLists);
                    adapter.notifyDataSetChanged();
                }else {
                    searchbutton.setImageResource(R.drawable.ic_cancel);
                }
            }
        });

        searchbutton.setOnClickListener(click_search);
        cancel.setOnClickListener(click_cancelcode);
        addcode.setOnClickListener(click_addcode);

        return view;
    }



    private void filter(String text) {
        //new array list that will hold the filtered data
        ArrayList<ItemList> filteredList = new ArrayList<>();

        for(int i=0; i<itemLists.size(); i++){
            ItemList row = itemLists.get(i);

            if (row.getItem_name().toLowerCase().contains(text)) {
                ItemList newitem = new ItemList();
                newitem.setItem_name(row.getItem_name());
                filteredList.add(newitem);
            }

        }

        itemLists = filteredList;
        //calling a method of the adapter class and passing the filtered list
        adapter.filterList(itemLists);
    }

    View.OnClickListener click_search = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            editTextSearch.getText().clear();
            itemLists.clear();
            itemLists.addAll(temp_itemLists);
            adapter.notifyDataSetChanged();
        }
    };

    View.OnClickListener click_cancelcode = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dialogFragment.dismiss();
        }
    };


    View.OnClickListener click_addcode = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dialogFragment.dismiss();
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar_MinWidth);
    }


}
