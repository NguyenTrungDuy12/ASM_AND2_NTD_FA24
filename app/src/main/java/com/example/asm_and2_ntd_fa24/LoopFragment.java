package com.example.asm_and2_ntd_fa24;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LoopFragment extends Fragment {


    public LoopFragment() {
        // Required empty public constructor
    }


    public static LoopFragment newInstance() {
        LoopFragment fragment = new LoopFragment();
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
        return inflater.inflate(R.layout.fragment_loop, container, false);
    }
}