package com.alokomkar.androidintro;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alokomkar.androidintro.model.Data;

import java.util.ArrayList;

/**
 * Created by Alok on 02/06/17.
 */

public class DataRecyclerViewAdapter extends RecyclerView.Adapter<DataRecyclerViewAdapter.ViewHolder> {

    private ArrayList<Data> dataArrayList;
    private OnItemClickListener onItemClickListener;

    //Custom item click listener to return position of item clicked in recyclerview
    public interface OnItemClickListener {
        void onItemClick( int position );
    }

    public DataRecyclerViewAdapter( ArrayList<Data> dataArrayList, OnItemClickListener onItemClickListener ) {
        this.dataArrayList = dataArrayList;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public DataRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data, parent, false));
    }

    @Override
    public void onBindViewHolder(DataRecyclerViewAdapter.ViewHolder holder, int position) {
        Data data = getItemAtPosition(position);
        holder.itemTextView.setText(data.toString());
    }

    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }

    public Data getItemAtPosition( int position ) {
        return dataArrayList.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView itemTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            itemTextView = (TextView) itemView.findViewById(R.id.itemTextView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            if( position != RecyclerView.NO_POSITION ) {
                onItemClickListener.onItemClick( position );
            }
        }
    }
}
