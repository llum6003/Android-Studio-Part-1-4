package lynxdom.com.listapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import lynxdom.com.listapp.R;

public class itemAdapter extends BaseAdapter {
    LayoutInflater mInflater;
    String[] items;
    String[] prices;
    String[] descs;

    public itemAdapter (Context c,String[] xitems, String[] xprices, String[] xdesc) {
        items = xitems;
        prices = xprices;
        descs = xdesc;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = mInflater.inflate(R.layout.mylistviewdetail, null);
        TextView nameTextView = (TextView) v.findViewById(R.id.nameTextView);
        TextView descTextView = (TextView) v.findViewById(R.id.descTextView);
        TextView priceTextView = (TextView) v.findViewById(R.id.priceTextView);

        String tmpName = items[position];
        String tmpDesc = descs[position];
        String tmpPrice = prices[position];

        nameTextView.setText(tmpName);
        descTextView.setText(tmpDesc);
        priceTextView.setText(tmpPrice);
        return v;
    }
}
