package com.alokomkar.androidintro.asynctasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.alokomkar.androidintro.R;
import com.alokomkar.androidintro.listeners.OnDataReadListener;
import com.alokomkar.androidintro.model.Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Created by Alok on 02/06/17.
 */

public class FileReaderTask extends AsyncTask<Void, Void, Void> {

    private Context context;
    private ArrayList<Data> dataArrayList;

    //To display progress Dialog
    private ProgressDialog progressDialog;

    //Interface to communicate back the response to UI
    private OnDataReadListener onDataReadListener;

    public FileReaderTask(Context context, OnDataReadListener onDataReadListener) {
        this.context = context;
        this.onDataReadListener = onDataReadListener;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        readFileAsList(context);
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading");
        progressDialog.show();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if( progressDialog != null ) {
            progressDialog.dismiss();
        }
        if( onDataReadListener != null ) {
            onDataReadListener.onDataReadComplete( dataArrayList );
        }
    }

    private void readFileAsList(Context context) {
        String line;
        try {

            InputStream inputStream = context.getResources().openRawResource(R.raw.data_list);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            int index = 1;
            dataArrayList = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                if( line.trim().length() != 0 ) {
                    String[] textArray = line.split(",");
                    Data data = new Data(textArray[0], index++);
                    dataArrayList.add(data);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
