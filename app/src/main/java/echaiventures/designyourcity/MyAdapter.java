package echaiventures.designyourcity;

/**
 * Created by Rahul on 15-10-2014.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<RowItem>{
    private final Context context;
    private final ArrayList<RowItem> items;

    public MyAdapter(Context context, ArrayList<RowItem> items) {
        super(context, R.layout.comment_row, items);
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.comment_row, parent, false);

        TextView tvComment = (TextView) row.findViewById(R.id.tvComment);
        TextView tvTime = (TextView) row.findViewById(R.id.tvTime);

        tvComment.setText(items.get(position).getComment());
        tvTime.setText(items.get(position).getCurrentDate());

        return row;
    }
}
