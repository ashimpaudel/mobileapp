package com.example.ashim.mobileappfinalproject;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Ashim on 11/24/2016.
 */

public class BackgroundTask extends AsyncTask<String, Product, String> {
    Context ctx;
    ProductAdapter productAdapter;
    Activity activity;
    ListView listView;


    BackgroundTask(Context ctx) {
        this.ctx = ctx;
        activity = (Activity) ctx;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        String method = params[0];
        DbOperations dbOperations = new DbOperations(ctx);
        if (method.equals("add_info")) {
            String event = params[1];
            String department = params[2];
            String date = params[3];
            String time = params[4];
            SQLiteDatabase db = dbOperations.getWritableDatabase();
            dbOperations.addInformations(db, event, department, date, time);
            return "One Row inserted";

        } else if (method.equals("get_info")) {
            listView = (ListView) activity.findViewById(R.id.display_listview);
            SQLiteDatabase db = dbOperations.getReadableDatabase();
            Cursor cursor = dbOperations.getInformations(db);
            productAdapter = new ProductAdapter(ctx, R.layout.display_product_row);
            String event, department, date, time;
            while (cursor.moveToNext()) {
                event = cursor.getString(cursor.getColumnIndex(ProductContract.ProductEntry.NAME));
                department = cursor.getString(cursor.getColumnIndex(ProductContract.ProductEntry.DEPARTMENT));
                date = cursor.getString(cursor.getColumnIndex(ProductContract.ProductEntry.DATE));
                time = cursor.getString(cursor.getColumnIndex(ProductContract.ProductEntry.TIME));
                Product product = new Product(event, department, date, time);
                publishProgress(product);

            }
            return "get_info";


        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Product... values) {
        productAdapter.add(values[0]);

    }

    @Override
    protected void onPostExecute(String result) {

        if (result.equals("get_info")) {
            listView.setAdapter(productAdapter);
        } else {
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();

        }
    }
}