package echaiventures.designyourcity.issue;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import echaiventures.designyourcity.R;

public class IssueCreate extends Activity {

    TextView tvIssueType;
    EditText etUsername, etTitle, etDescription;
    Button btnCreateIssue;

    String issueType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.issue_create);

        tvIssueType = (TextView) findViewById(R.id.tvIssueType);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etTitle = (EditText) findViewById(R.id.etIssueTitle);
        etDescription = (EditText) findViewById(R.id.etIssueDescription);
        btnCreateIssue = (Button) findViewById(R.id.btnCreateNewIssue);

        getIssueType();

        btnCreateIssue.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(IssueCreate.this, IssueDiscuss.class);
                i.putExtra("username", etUsername.getText().toString());
                i.putExtra("date", getCurrentDate());
                i.putExtra("title", etTitle.getText().toString());
                i.putExtra("description", etDescription.getText().toString());
                startActivity(i);
            }

            private String getCurrentDate() {
                DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm:ss");
                String date = df.format(Calendar.getInstance().getTime());
                return date;
            }
        });
    }

    private void getIssueType() {
        Intent i = getIntent();
        issueType = i.getStringExtra("IssueType").toString();
        tvIssueType.setText("Issue Type : "+issueType);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.issue_create, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
