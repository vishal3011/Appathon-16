package com.android.example.appathon;

/**
 * Created by Vishal on 10-09-2016.
 */
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityUserProfile extends AppCompatActivity {
    private TextView textView;
    private FloatingActionButton buttonFabPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        textView = (TextView) findViewById(R.id.textViewUsername);

        Intent intent = getIntent();

        textView.setText("Welcome User " + intent.getStringExtra(LoginActivity.KEY_USERNAME));

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
