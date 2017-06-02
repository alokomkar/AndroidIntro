package com.alokomkar.androidintro.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alokomkar.androidintro.R;
import com.alokomkar.androidintro.model.Data;

/**
 * Created by Alok on 02/06/17.
 */

public class DetailsFragment extends Fragment {

    private TextView detailsTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        detailsTextView = (TextView) view.findViewById(R.id.detailsTextView);
        Bundle bundle = getArguments();
        if( bundle != null ) {
            Data data = bundle.getParcelable(Data.class.getSimpleName());
            detailsTextView.setText(data.toString());
        }
        return view;
    }

}
