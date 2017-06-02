package com.alokomkar.androidintro.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Alok on 02/06/17.
 */

public class Data implements Parcelable {

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.itemName);
        dest.writeInt(this.itemNumber);
    }

    protected Data(Parcel in) {
        this.itemName = in.readString();
        this.itemNumber = in.readInt();
    }

    public static final Parcelable.Creator<Data> CREATOR = new Parcelable.Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel source) {
            return new Data(source);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };
}
