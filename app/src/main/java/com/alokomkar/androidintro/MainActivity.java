package com.alokomkar.androidintro;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private FragmentTransaction mFragmentTransaction;
    private DataListFragment dataListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadListFragment();
    }

    //Use framelayout container to dynamically display fragment at run time
    //code to replace fragment dynamically at run time.
    public void loadListFragment() {
        mFragmentTransaction = getSupportFragmentManager().beginTransaction();
        dataListFragment = (DataListFragment) getSupportFragmentManager().findFragmentByTag(DataListFragment.class.getSimpleName());
        if( dataListFragment == null ) {
            dataListFragment = new DataListFragment();
        }
        mFragmentTransaction.replace(R.id.container, dataListFragment, DataListFragment.class.getSimpleName());
        mFragmentTransaction.commit();
    }


}
