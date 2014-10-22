package echaiventures.designyourcity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import echaiventures.designyourcity.issue.IssueMain;


public class HomePage extends Activity {

    Button btnDiscussion, btnIssue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        changeActionBar();

        btnDiscussion =(Button)findViewById(R.id.button1);
        btnIssue = (Button)findViewById(R.id.button2);

        btnDiscussion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(HomePage.this, MyActivity.class);
                startActivity(myIntent);
            }
        });

        btnIssue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(HomePage.this, IssueMain.class);
                startActivity(myIntent);
            }
        });
    }

    private void changeActionBar() {
        ActionBar myActionBar = getActionBar();
        myActionBar.setDisplayShowHomeEnabled(false);
        myActionBar.setDisplayShowTitleEnabled(false);

        LayoutInflater myInflater = LayoutInflater.from(this);
        View myCustomView = myInflater.inflate(R.layout.custom_main_title_bar, null);

        TextView myTitleText = (TextView) myCustomView.findViewById(R.id.tvTitleText);
        myTitleText.setText("Design Your City");

        myActionBar.setCustomView(myCustomView);
        myActionBar.setDisplayShowCustomEnabled(true);
    }

}
