package com.alokomkar.androidintro.listeners;

import com.alokomkar.androidintro.model.Data;

import java.util.ArrayList;

/**
 * Created by Alok on 02/06/17.
 */

public interface OnDataReadListener {
    void onDataReadComplete(ArrayList<Data> dataArrayList );
}
