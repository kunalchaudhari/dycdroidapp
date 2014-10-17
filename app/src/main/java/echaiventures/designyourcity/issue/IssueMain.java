package echaiventures.designyourcity.issue;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import echaiventures.designyourcity.R;


public class IssueMain extends Activity{

    //Button ib1, ib2, ib3, ib4, ib5, ib6;
    GridView grid;
    String[] IssueType = {
            "Water Logging",
            "Potholes",
            "Pollution",
            "Traffic",
            "Dump",
            "Child Labour"
    } ;

    int[] imageId = {
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.f,
            R.drawable.g
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.issue_main);

        CustomGrid adapter = new CustomGrid(IssueMain.this, IssueType, imageId);
        grid=(GridView)findViewById(R.id.grid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id)
            {

                Intent i = new Intent(IssueMain.this, IssueCreate.class);
                i.putExtra("IssueType", IssueType[position]);
                startActivity(i);
            }
        });
    }

}