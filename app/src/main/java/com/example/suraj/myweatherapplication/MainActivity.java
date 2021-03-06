package com.example.suraj.myweatherapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtnWeatherInfoClick(View v) {
        Intent i = new Intent(MainActivity.this, WeatherInfoActivity.class);

        TextView txtZipCode = (TextView) findViewById(R.id.txtZipCode);
        String ZipCode = txtZipCode.getText().toString();

        //Create bundle to send zipcode to the next activity
        Bundle bundle = new Bundle();

        bundle.putString("zip", ZipCode);           //put value of zipcode in bundle

        i.putExtras(bundle);
        startActivity(i);                           //Start the nxt activity
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
