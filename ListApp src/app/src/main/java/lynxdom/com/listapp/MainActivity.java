package lynxdom.com.listapp;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    String[] items;
    String[] prices;
    String[] descs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        lv = (ListView) findViewById(R.id.myListView);
        items = res.getStringArray(R.array.items);
        prices = res.getStringArray(R.array.prices);
        descs = res.getStringArray(R.array.descriptions);

        itemAdapter itemAdt = new itemAdapter(this, items, prices, descs);

        lv.setAdapter(itemAdt);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent showPic = new Intent(getApplicationContext(), pictureDetail.class);
                showPic.putExtra("lynxdom.com.picIndex", position);
                startActivity(showPic);
            }
        });



    }
}
