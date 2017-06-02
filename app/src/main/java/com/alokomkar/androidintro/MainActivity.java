package com.alokomkar.androidintro;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.alokomkar.androidintro.fragments.DataListFragment;
import com.alokomkar.androidintro.fragments.DetailsFragment;
import com.alokomkar.androidintro.listeners.AppNavigationListener;
import com.alokomkar.androidintro.model.Data;

public class MainActivity extends AppCompatActivity implements AppNavigationListener {

    private FragmentTransaction mFragmentTransaction;
    private DataListFragment dataListFragment;
    private DetailsFragment detailsListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadListFragment();
    }

    //Use framelayout container to dynamically display fragment at run time
    //code to replace fragment dynamically at run time.
    @Override
    public void loadListFragment() {
        setTitle("Item List");
        mFragmentTransaction = getSupportFragmentManager().beginTransaction();
        dataListFragment = (DataListFragment) getSupportFragmentManager().findFragmentByTag(DataListFragment.class.getSimpleName());
        if( dataListFragment == null ) {
            dataListFragment = new DataListFragment();
        }
        mFragmentTransaction.replace(R.id.container, dataListFragment, DataListFragment.class.getSimpleName());
        mFragmentTransaction.commit();
    }

    //Communicate the data to DetailsFragment from ListFragment
    @Override
    public void loadDetailsFragment(Data data) {
        setTitle( data.getItemName() );
        mFragmentTransaction = getSupportFragmentManager().beginTransaction();
        detailsListFragment = new DetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(Data.class.getSimpleName(), data);
        detailsListFragment.setArguments(bundle);
        mFragmentTransaction.replace(R.id.container, detailsListFragment, DetailsFragment.class.getSimpleName());
        mFragmentTransaction.commit();
    }

    //To handle navigation between fragments
    @Override
    public void onBackPressed() {
        String title = getTitle().toString();
        if( !title.equals("Item List") ) {
            loadListFragment();
        }
        else super.onBackPressed();
    }
}
