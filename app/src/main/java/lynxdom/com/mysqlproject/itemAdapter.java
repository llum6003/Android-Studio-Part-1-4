package lynxdom.com.mysqlproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class itemAdapter extends BaseAdapter {
    LayoutInflater mInflator;
    Map<String, Double> datamap;
    List<String> fruit_names;
    List<Double> fruit_prices;

    public itemAdapter(Context c, Map m) {
        mInflator = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        datamap = m;
        fruit_names = new ArrayList<String>(datamap.keySet());
        fruit_prices = new ArrayList<Double>(datamap.values());
    }

    @Override
    public int getCount() {
        return fruit_names.size();
    }

    @Override
    public Object getItem(int position) {
        return fruit_names.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = mInflator.inflate(R.layout.item_view, null);
        TextView fruitNameTextView = (TextView) v.findViewById(R.id.dbName);
        TextView fruitPriceTextView = (TextView) v.findViewById(R.id.dbPrice);

        fruitNameTextView.setText(fruit_names.get(position));
        fruitPriceTextView.setText(fruit_prices.get(position).toString());

        return v;
    }
}
