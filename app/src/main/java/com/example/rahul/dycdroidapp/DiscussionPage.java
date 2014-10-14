package com.example.rahul.dycdroidapp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class DiscussionPage extends Activity implements OnClickListener{

    MyAdapter adapter;
    ArrayList<RowItem> item = new ArrayList<RowItem>();

    ListView listView;
    TextView tvTitle, tvDescription, tvStartedBy, tvStartedOn;
    Button btnLike, btnShare, btnComment, btnPost;
    EditText etComment;

    int likeCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discussion_page);


        listView = (ListView) findViewById(R.id.listView1);

        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvDescription = (TextView) findViewById(R.id.tvDescription);
        tvStartedOn = (TextView) findViewById(R.id.tvStartedOn);
        tvStartedBy = (TextView) findViewById(R.id.tvStartedBy);

        btnLike = (Button) findViewById(R.id.btnLike);
        btnShare = (Button) findViewById(R.id.btnShare);
        btnPost = (Button) findViewById(R.id.btnPost);
        etComment = (EditText)findViewById(R.id.etComment);

        likeCounter = 0;
        getDiscussionTopic();

        adapter = new MyAdapter(this, item);

        btnPost.setOnClickListener(this);
        btnLike.setOnClickListener(this);

    }



    private void getDiscussionTopic() {
        Intent i = getIntent();
        String startedBy = i.getStringExtra("username");
        String title = i.getStringExtra("title");
        String description = i.getStringExtra("description");
        String startedOn = i.getStringExtra("date");

        tvTitle.setText(title);
        tvTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        tvTitle.setTextColor(Color.BLACK);
        tvTitle.setTypeface(null, Typeface.BOLD);

        tvDescription.setText(description);
        tvDescription.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);
        tvDescription.setTextColor(Color.BLACK);
        tvDescription.setTypeface(null, Typeface.NORMAL);

        tvStartedBy.setText("Started By : "+startedBy);
        tvStartedBy.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
        tvStartedBy.setTextColor(Color.BLACK);
        tvStartedBy.setTypeface(null, Typeface.BOLD_ITALIC);
        //getActionBar().setTitle("By : "+startedBy);

        tvStartedOn.setText("On : "+startedOn);
        tvStartedOn.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
        tvStartedOn.setTextColor(Color.BLACK);
        tvStartedOn.setTypeface(null, Typeface.BOLD_ITALIC);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLike:
                likeCounter++;
                btnLike.setText("Likes # "+likeCounter);
                btnLike.setTextColor(Color.BLUE);
                break;

            case R.id.btnPost:
                listView.setAdapter(adapter);
                listCommentInListView();
                etComment.setText("");
                break;

            default:
                break;
        }
    }

    private void listCommentInListView() {
        String date = getCurrentDateAndTime();
        item.add(new RowItem(etComment.getText().toString(), date));
        adapter.notifyDataSetChanged();
    }

    private String getCurrentDateAndTime() {
        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm:ss");
        String date = df.format(Calendar.getInstance().getTime());
        return date;
    }

}