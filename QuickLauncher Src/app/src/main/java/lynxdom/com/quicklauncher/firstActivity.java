package lynxdom.com.quicklauncher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class firstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        if (getIntent().hasExtra("com.lynxdom.quicklauncher.var1")) {
            TextView tv = (TextView) findViewById(R.id.textView);
            String xinfo = getIntent().getStringExtra("com.lynxdom.quicklauncher.var1");
            tv.setText(xinfo);
        }
    }
}
