package com.android.example.appathon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vishal on 11-09-2016.
 */
public  class EditPostActivity extends AppCompatActivity{

    private static final String REGISTER_URL = "http://rajukoushik.pythonanywhere.com/api/addpost";

    private static final String[]categories = {"Women rights", "Safety & Security", "Health","Gende equality","Education"};
    private static final String[]choices = {"Issue", "Aid"};

    public static final String KEY_POSTTITLE = "post_title";
    public static final String KEY_CATEGORY = "post_catid";
    public static final String KEY_CHOICE = "post_tag";
    public static final String KEY_POSTTEXT = "post_text";
    public static final String KEY_USERNAME = "user_name";

    private EditText editPostTitle;
    private EditText editTextPost;
    private Spinner spinner;
    private Spinner spinnerCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_edit_post);

        editPostTitle = (EditText) findViewById(R.id.editPostTitle);
        editTextPost = (EditText) findViewById(R.id.editTextPost);


        spinner = (Spinner)findViewById(R.id.spinner);
        spinnerCategory = (Spinner)findViewById(R.id.spinnerCategory);




        ArrayAdapter<String> adapter = new ArrayAdapter<String>(EditPostActivity.this,
                android.R.layout.simple_spinner_item,categories);


        spinner.setAdapter(adapter);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(EditPostActivity.this,
                android.R.layout.simple_spinner_item,choices);


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

    private void submitPost(){

        LoginActivity la = new LoginActivity();

        final String post_title = editPostTitle.getText().toString().trim();
        final String post_text = editTextPost.getText().toString().trim();
        final String post_catid = spinner.getSelectedItemPosition()+ "";
        final String post_tag = spinnerCategory.getSelectedItemPosition()+" ";
        final String user_name = la.UserName;



        StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(EditPostActivity.this, response, Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(EditPostActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put(KEY_POSTTITLE,post_title);
                params.put(KEY_POSTTEXT,post_text);
                params.put(KEY_CATEGORY, post_catid);
                params.put(KEY_CHOICE, post_tag);
                params.put(KEY_USERNAME,user_name);
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }





    public void addPost(View view) {
        submitPost();
    }
}