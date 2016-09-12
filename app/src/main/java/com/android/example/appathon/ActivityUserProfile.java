package com.android.example.appathon;

/**
 * Created by Vishal on 10-09-2016.
 */
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Map;

public class ActivityUserProfile extends AppCompatActivity {
    private TextView textView;
    private FloatingActionButton buttonFabPost;
    private ArrayAdapter mAdapter;
    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapterRecycler;
    private RecyclerView.LayoutManager mLayoutManager;
    private ActionBarDrawerToggle mDrawerToggle;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);



        buttonFabPost = (FloatingActionButton) findViewById(R.id.fab_post);

        buttonFabPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(ActivityUserProfile.this,EditPostActivity.class);
                startActivity(i);
            }
        });
    }






}
