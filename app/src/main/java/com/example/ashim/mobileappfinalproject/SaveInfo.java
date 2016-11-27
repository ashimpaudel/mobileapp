package com.example.ashim.mobileappfinalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SaveInfo extends AppCompatActivity {
    EditText e_event, e_department, e_date, e_time;
    String event, department, date, time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.save_info_layout);
        e_event = (EditText) findViewById(R.id.event_name);
        e_department = (EditText) findViewById(R.id.department_name);
        e_date = (EditText) findViewById(R.id.event_date);
        e_time = (EditText) findViewById(R.id.event_time);
    }

    public void saveData(View view)
    {
        event = e_event.getText().toString();
        department = e_department.getText().toString();
        date = e_date.getText().toString();
        time = e_time.getText().toString();
        BackgroundTask backgroundTask = new BackgroundTask(this);

        backgroundTask.execute("add_info", event, department, date, time);
        finish();


    }
}
