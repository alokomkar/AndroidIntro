package com.alokomkar.androidintro.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alokomkar.androidintro.R;
import com.alokomkar.androidintro.adapters.DataRecyclerViewAdapter;
import com.alokomkar.androidintro.asynctasks.FileReaderTask;
import com.alokomkar.androidintro.listeners.AppNavigationListener;
import com.alokomkar.androidintro.listeners.OnDataReadListener;
import com.alokomkar.androidintro.model.Data;

import java.util.ArrayList;

/**
 * Created by Alok on 02/06/17.
 */

public class DataListFragment extends Fragment implements DataRecyclerViewAdapter.OnItemClickListener, OnDataReadListener {

    // Create a Fragment with basic list display of data [Display list of data using recyclerview]
    private RecyclerView itemsRecyclerView;
    private DataRecyclerViewAdapter dataAdapter;

    // Access communication interface created
    private AppNavigationListener appNavigationListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_data_list, container, false);
        //initialize Recyclerview
        itemsRecyclerView = (RecyclerView) view.findViewById(R.id.itemsRecyclerView);
        //its very important to set layout manager to recyclerview :
        //if not set you won't see the data in the list
        itemsRecyclerView.setLayoutManager( new LinearLayoutManager(getContext()) );
        fetchData();
        return view;
    }

    //Fetch data from List
    private void fetchData() {
        new FileReaderTask(getContext(), this).execute();
    }

    //Setup recyclerview
    private void setupRecyclerView(ArrayList<Data> dataArrayList) {
        dataAdapter = new DataRecyclerViewAdapter( dataArrayList, this );
        itemsRecyclerView.setAdapter( dataAdapter );
    }

    @Override
    public void onItemClick(int position) {
        Data data = dataAdapter.getItemAtPosition(position);
        appNavigationListener.loadDetailsFragment(data);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if( context instanceof AppNavigationListener ) {
            appNavigationListener = (AppNavigationListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        appNavigationListener = null;
    }

    @Override
    public void onDataReadComplete(ArrayList<Data> dataArrayList) {
        setupRecyclerView(dataArrayList);
    }
}
