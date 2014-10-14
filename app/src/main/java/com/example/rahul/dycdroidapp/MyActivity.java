package com.example.rahul.dycdroidapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MyActivity extends Activity {

    Button btnNewDiscussion;
    EditText etUsername, etDTitle, etDDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etDTitle = (EditText) findViewById(R.id.etDiscussionTitle);
        etDDescription = (EditText) findViewById(R.id.etDiscussionDescription);

        btnNewDiscussion = (Button) findViewById(R.id.btnCreateNewDiscussion);
        btnNewDiscussion.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(MyActivity.this, DiscussionPage.class);
                i.putExtra("username", etUsername.getText().toString());
                i.putExtra("title", etDTitle.getText().toString());
                i.putExtra("description", etDDescription.getText().toString());
                i.putExtra("date", getCurrentDateAndTime());
                startActivity(i);
            }
        });
    }

    private String getCurrentDateAndTime() {
        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm:ss");
        String date = df.format(Calendar.getInstance().getTime());
        return date;
    }
}