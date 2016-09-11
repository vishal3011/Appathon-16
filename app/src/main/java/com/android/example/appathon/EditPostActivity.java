package com.android.example.appathon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by Vishal on 11-09-2016.
 */
public class EditPostActivity extends AppCompatActivity {

    private Spinner spinner;
    private Spinner spinnerCategory;
    private static final String[]categories = {"item 1", "item 2", "item 3"};
    private static final String[]choice = {"Issue", "Aid"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_edit_post);

        spinner = (Spinner)findViewById(R.id.spinner);
        spinnerCategory = (Spinner)findViewById(R.id.spinnerCategory);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(EditPostActivity.this,
                android.R.layout.simple_spinner_item,categories);


        spinner.setAdapter(adapter);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(EditPostActivity.this,
                android.R.layout.simple_spinner_item,choice);


        spinnerCategory.setAdapter(adapter2);




    }

    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                // Whatever you want to happen when the first item gets selected
                break;
            case 1:
                // Whatever you want to happen when the second item gets selected
                break;
            case 2:
                // Whatever you want to happen when the thrid item gets selected
                break;

        }
    }

}