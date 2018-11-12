package lynxdom.com.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button doAdd = (Button) findViewById(R.id.addBtn);
        doAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText xnum1 = (EditText) findViewById(R.id.num1Text);
                EditText xnum2 = (EditText) findViewById(R.id.num2Text);
                TextView resultView = (TextView)findViewById(R.id.resultView);

                int num1 = Integer.parseInt(xnum1.getText().toString());
                int num2 = Integer.parseInt(xnum2.getText().toString());

                int resultHolder = num1 + num2;
                resultView.setText(resultHolder+"");

            }
        });


    }
}
