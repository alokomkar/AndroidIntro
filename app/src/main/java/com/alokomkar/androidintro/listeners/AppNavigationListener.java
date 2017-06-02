package com.alokomkar.androidintro.listeners;

import com.alokomkar.androidintro.model.Data;

/**
 * Created by Alok on 02/06/17.
 */
//Interface to navigate between fragments
public interface AppNavigationListener {

    void loadListFragment();
    void loadDetailsFragment(Data data);

}
