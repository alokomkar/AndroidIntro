package com.alokomkar.androidintro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.alokomkar.androidintro.model.Data;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DataRecyclerViewAdapter.OnItemClickListener {

    //1. Create an Activity with basic list display of data [Display list of data using recyclerview]
    private RecyclerView itemsRecyclerView;
    private DataRecyclerViewAdapter dataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialize Recyclerview
        itemsRecyclerView = (RecyclerView) findViewById(R.id.itemsRecyclerView);
        //its very important to set layout manager to recyclerview :
        //if not set you won't see the data in the list
        itemsRecyclerView.setLayoutManager( new LinearLayoutManager(MainActivity.this) );
        fetchData();
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
        Toast.makeText(MainActivity.this, data.toString(), Toast.LENGTH_SHORT).show();
    }
}
