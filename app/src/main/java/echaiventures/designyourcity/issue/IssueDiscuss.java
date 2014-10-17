package echaiventures.designyourcity.issue;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import echaiventures.designyourcity.MyAdapter;
import echaiventures.designyourcity.R;
import echaiventures.designyourcity.RowItem;

public class IssueDiscuss extends Activity implements View.OnClickListener{
        MyAdapter adapter;
        ArrayList<RowItem> items;

        TextView tvUsername, tvDate, tvIssueTitle, tvIssueDescription;
        Button btnLike, btnShare, btnComment;
        EditText etComment;
        ListView listView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.issue_discuss);

            tvUsername = (TextView) findViewById(R.id.tvUsername);
            tvDate = (TextView) findViewById(R.id.tvDate);
            tvIssueTitle = (TextView) findViewById(R.id.tvIssueTitle);
            tvIssueDescription = (TextView) findViewById(R.id.tvIssueDescription);

            etComment = (EditText) findViewById(R.id.etComment);
            listView = (ListView) findViewById(R.id.listView1);

            btnComment = (Button) findViewById(R.id.btnComment);
            btnLike = (Button) findViewById(R.id.btnLike);
            btnShare = (Button) findViewById(R.id.btnShare);

            getIntentValues();

            items = new ArrayList<RowItem>();
            adapter = new MyAdapter(this, items);
            btnComment.setOnClickListener(this);

        }

        private void getIntentValues() {
            Intent in = getIntent();
            String username = in.getStringExtra("username");
            tvUsername.setText(username);

            String date = in.getStringExtra("date");
            tvDate.setText(date);

            String title = in.getStringExtra("title");
            tvIssueTitle.setText(title);

            String description = in.getStringExtra("description");
            tvIssueDescription.setText(description);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnComment:
                    listView.setAdapter(adapter);
                    String date = getCurrentDateAndTime();
                    items.add(new RowItem(etComment.getText().toString(), date));
                    adapter.notifyDataSetChanged();
                    //listCommentInListView();
                    etComment.setText("");
                    break;

                default:
                    break;
            }
        }

	/*private void listCommentInListView() {
		String date = getCurrentDateAndTime();
		items.add(new RowItem(etComment.getText().toString(), date));
		adapter.notifyDataSetChanged();
	}*/

        private String getCurrentDateAndTime() {
            DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm:ss");
            String date = df.format(Calendar.getInstance().getTime());
            return date;
        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.issue_discuss, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
