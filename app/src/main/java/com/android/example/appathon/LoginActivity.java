package com.android.example.appathon;

/**
 * Created by Vishal on 10-09-2016.
 */
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static android.util.Log.*;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String LOGIN_URL = "http://rajukoushik.pythonanywhere.com/api/login";
    public String UserName = "";
    public static final String KEY_USERNAME="user_name";
    public static final String KEY_PASSWORD="password";
    public String[] posttext=new String[1000];
    public String[] postitle=new String[1000];
    public String[] username=new String[1000];
    public String message;
    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;

    private String user_name;
    private String password;
    public int code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                userLogin();
            }
        });


    }


    private void userLogin() {
        user_name = editTextUsername.getText().toString().trim();
        password = editTextPassword.getText().toString().trim();
        UserName = user_name;
        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jobj = new JSONObject(response);
                            code = jobj.getInt("code");
                            String message = jobj.getString("message");
                            if(code == 404)
                            {
                                Toast.makeText(LoginActivity.this,message,Toast.LENGTH_LONG).show();
                                Log.e("tag", response);
                            }
                            else
                            {
                                Toast.makeText(LoginActivity.this,"Yo bro !!",Toast.LENGTH_LONG).show();
                                Log.e("tag", response);

                                ArrayList<PostModel> arr = new ArrayList<>();

                                JSONArray jr = jobj.getJSONArray("posttext");
                                JSONArray jr1 = jobj.getJSONArray("posttitles");
                                JSONArray jr2 = jobj.getJSONArray("username");

                                for(int i=0;i<posttext.length;i++)
                                {


                                    posttext[i] = jr.getJSONObject(i).toString();
                                    postitle[i] = jr1.getJSONObject(i).toString();
                                    username[i] = jr2.getJSONObject(i).toString();
                                    arr.add(new PostModel(username[i],posttext[i],username[i]));

                                }


                                Adapter.getbInstance(LoginActivity.this).setPostsList(arr);

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        Toast.makeText(LoginActivity.this, response, Toast.LENGTH_LONG).show();
                        if(code == 200){
                            openProfile();
                        }else{
                            Toast.makeText(LoginActivity.this,response,Toast.LENGTH_LONG).show();
                            Log.e("tag", response);

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LoginActivity.this,error.toString(),Toast.LENGTH_LONG ).show();


                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<String,String>();
                map.put(KEY_USERNAME,user_name);
                map.put(KEY_PASSWORD,password);
                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void openProfile(){
        Intent intent = new Intent(this, ActivityUserProfile.class);
        intent.putExtra(KEY_USERNAME, user_name);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        userLogin();
    }

    public void login_click(View view) {

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

}