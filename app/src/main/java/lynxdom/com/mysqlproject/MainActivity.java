package lynxdom.com.mysqlproject;

import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.util.LinkedHashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    itemAdapter itemAdpt;
    Context thisContext;
    ListView fruitListView;
    TextView progressResults;
    Map<String, Double> fruitMap = new LinkedHashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        fruitListView = (ListView) findViewById(R.id.dbListView);
        progressResults = (TextView) findViewById(R.id.progressTextView);
        thisContext = this;

        progressResults.setText("");
        Button btn = (Button) findViewById(R.id.getDataButn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetData retrieveData = new GetData();
                retrieveData.execute("");
            }
        });
    }

    private class GetData extends AsyncTask {
        String msg = "";

        static final String DB_URL = "jdbc:h2:tcp://" + dbHelper.DATABASE_URL +
                "/" + dbHelper.DATABASE_NAME + "";


        @Override
        protected void onPreExecute() {
            progressResults.setText("Connecting to database....");
            //super.onPreExecute();
        }

        @Override
        protected Object doInBackground(Object[] objects) {
            Connection conn = null;
            Statement stmt = null;

            try {
                Class.forName(dbHelper.JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL,dbHelper.USERNAME, dbHelper.PASSWORD);
                stmt = conn.createStatement();
                String sql = "SELECT * FROM FRUITS";
                ResultSet rs = stmt.executeQuery(sql);
                int xcount = 0;
                while (rs.next()) {
                    String name = rs.getString("fruit_name");
                    Double price = rs.getDouble("fruit_price");

                    fruitMap.put(name,price);
                    xcount++;
                }

                msg = "Finish loading " + xcount + " records";
                rs.close();
                stmt.close();
                conn.close();

            } catch (SQLException se) {
                msg = "Error find information from DB";
                se.printStackTrace();
            } catch (ClassNotFoundException cnf) {
                msg = "Unable to load to database drivers";
                cnf.printStackTrace();
            } finally {
                try {
                    if (stmt!=null) {
                        stmt.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    if (conn!=null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            progressResults.setText(msg);
            if (fruitMap.size()>0) {
                itemAdpt = new itemAdapter(thisContext, fruitMap);
                fruitListView.setAdapter(itemAdpt);
            }
            super.onPostExecute(o);
        }
    }

} //end of main activity



