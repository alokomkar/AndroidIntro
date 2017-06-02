package com.alokomkar.androidintro.model;

import java.util.ArrayList;

/**
 * Created by Alok on 02/06/17.
 */

public class Data {

    private String itemName;
    private int itemNumber;

    public Data(String itemName, int itemNumber) {
        this.itemName = itemName;
        this.itemNumber = itemNumber;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    @Override
    public String toString() {
        return "Data{" +
                "itemName='" + itemName + '\'' +
                ", itemNumber=" + itemNumber +
                '}';
    }

    //Create and return dummy data list
    public static ArrayList<Data> getDataList() {
        ArrayList<Data> dataArrayList = new ArrayList<>();
        for( int i = 0; i < 20; i++ ) {
            dataArrayList.add( new Data("Data : " + (i + 1), i+1) );
        }
        return dataArrayList;
    }
}
