package com.example.asm_and2_ntd_fa24;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.asm_and2_ntd_fa24.adapter.ProductAdapter;
import com.example.asm_and2_ntd_fa24.model.Product;

import java.util.ArrayList;


public class ProducFragment extends Fragment {

    ListView lv_product;

    public ProducFragment() {
        // Required empty public constructor
    }


    public static ProducFragment newInstance() {
        ProducFragment fragment = new ProducFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_produc, container, false);

        RecyclerView rcvProcduct = view.findViewById(R.id.rcvProcduct);
        rcvProcduct.setLayoutManager(new LinearLayoutManager(getContext()));

        ArrayList<Product> list = new ArrayList<>();
        list.add(new Product("Banh ngot", "Price: 10000 VNĐ"));
        list.add(new Product("Banh mi", "Price: 15000 VNĐ"));
        list.add(new Product("Banh cuon", "Price: 30000 VNĐ"));

        ProductAdapter adapter = new ProductAdapter(list);
        rcvProcduct.setAdapter(adapter);

        return view;
    }
}