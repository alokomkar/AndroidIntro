package com.alokomkar.androidintro;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alokomkar.androidintro.model.Data;

import java.util.ArrayList;

/**
 * Created by Alok on 02/06/17.
 */

public class DataListFragment extends Fragment implements DataRecyclerViewAdapter.OnItemClickListener {

    //1. Create a Fragment with basic list display of data [Display list of data using recyclerview]
    private RecyclerView itemsRecyclerView;
    private DataRecyclerViewAdapter dataAdapter;

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
        ArrayList<Data> dataArrayList = Data.getDataList();
        setupRecyclerView( dataArrayList );
    }

    //Setup recyclerview
    private void setupRecyclerView(ArrayList<Data> dataArrayList) {
        dataAdapter = new DataRecyclerViewAdapter( dataArrayList, this );
        itemsRecyclerView.setAdapter( dataAdapter );
    }

    //Display toast with details of the data item clicked
    @Override
    public void onItemClick(int position) {
        Data data = dataAdapter.getItemAtPosition(position);
        Toast.makeText(getContext(), data.toString(), Toast.LENGTH_SHORT).show();
    }
}
