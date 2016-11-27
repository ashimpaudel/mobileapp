package com.example.ashim.mobileappfinalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Ashim on 11/24/2016.
 */

public class DbOperations extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "product_info.db";
    private static final String CREATE_QUERY = "create table "+ProductContract.ProductEntry.TABLE_NAME+
            "(" + ProductContract.ProductEntry.NAME + " text, " + ProductContract.ProductEntry.DEPARTMENT+ " text, "+
            ProductContract.ProductEntry.DATE+ " text, "+ ProductContract.ProductEntry.TIME+ " text);";
    DbOperations(Context ctx){
        super(ctx, DB_NAME, null, DB_VERSION);
        Log.d("Database operation", "Database created...");

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.d("Database operations", "Table created...");


    }
    public void addInformations(SQLiteDatabase db, String event_name, String department_name, String event_date, String event_time)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ProductContract.ProductEntry.NAME, event_name);
        contentValues.put(ProductContract.ProductEntry.DEPARTMENT, department_name);
        contentValues.put(ProductContract.ProductEntry.DATE, event_date);
        contentValues.put(ProductContract.ProductEntry.TIME, event_time);
        db.insert(ProductContract.ProductEntry.TABLE_NAME, null, contentValues);
        Log.d("Database operations", "One row inserted.....");

    }
    public Cursor getInformations(SQLiteDatabase db)
    {
        String[] projections = {ProductContract.ProductEntry.NAME, ProductContract.ProductEntry.DEPARTMENT, ProductContract.ProductEntry.DATE,ProductContract.ProductEntry.TIME};
        Cursor cursor = db.query(ProductContract.ProductEntry.TABLE_NAME,projections,
                null, null, null, null, null);

        return cursor;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
