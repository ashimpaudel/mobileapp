package com.example.ashim.mobileappfinalproject;

/**
 * Created by Ashim on 11/24/2016.
 */

public final class ProductContract {
    ProductContract(){}


    public static abstract class ProductEntry
    {
        public static final String NAME = "event_name";
        public static final String DEPARTMENT = "event_department";
        public static final String DATE = "event_date";
        public static final String TIME = "event_time";

        public static final String TABLE_NAME = "product_table";
    }
}
