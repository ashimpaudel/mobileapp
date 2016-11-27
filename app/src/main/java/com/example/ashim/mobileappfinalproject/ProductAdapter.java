package com.example.ashim.mobileappfinalproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashim on 11/25/2016.
 */

public class ProductAdapter extends ArrayAdapter {
    List list = new ArrayList();

    public ProductAdapter(Context context, int resource) {
        super(context, resource);
    }


    public void add(Product object) {
        list.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }


    @Override
    public Object getItem(int position) {
        return list.get(position);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ProductHolder productHolder;
        if(row == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.display_product_row, parent, false);
            productHolder = new ProductHolder();
            productHolder.tx_name =(TextView) row.findViewById(R.id.t_event);
            productHolder.tx_department =(TextView) row.findViewById(R.id.t_department);
            productHolder.tx_date =(TextView) row.findViewById(R.id.t_date);
            productHolder.tx_time=(TextView) row.findViewById(R.id.t_time);
            row.setTag(productHolder);


        }
        else{
            productHolder = (ProductHolder) row.getTag();
        }
        Product product = (Product) getItem(position);
        productHolder.tx_name.setText(product.getEvent().toString());
        productHolder.tx_department.setText(product.getDepartment().toString());
        productHolder.tx_date.setText(product.getDate().toString());
        productHolder.tx_time.setText(product.getTime().toString());
        return row;
    }

    static class ProductHolder
    {
        TextView tx_name, tx_department, tx_date, tx_time;
    }
}
