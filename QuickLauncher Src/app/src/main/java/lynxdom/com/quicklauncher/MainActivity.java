package lynxdom.com.quicklauncher;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button cmdFirstActivity = (Button) findViewById(R.id.firstActivity);
        cmdFirstActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), firstActivity.class);
                startIntent.putExtra("com.lynxdom.quicklauncher.var1", "Hello World");
                startActivity(startIntent);
            }
        });

        Button cmdSecondActivity = (Button) findViewById(R.id.googleStart);
        cmdSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String googleAddress = "www.google.com";
                Uri webaddress = Uri.parse(googleAddress);
                Intent startIntent2 = new Intent(Intent.ACTION_VIEW, webaddress);
                if (startIntent2.resolveActivity(getPackageManager())!=null)
                    startActivity(startIntent2);
         ‹   }
        });
    }
}
