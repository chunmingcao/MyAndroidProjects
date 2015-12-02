package com.caocm.android.lesson5;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText cupsEdit = (EditText)findViewById(R.id.cups);
                int cups = Integer.parseInt(cupsEdit.getText().toString());

                TextView teaspoons = (TextView)findViewById(R.id.teaspoonsnumber);
                teaspoons.setText(cups);
                TextView tablespoons = (TextView)findViewById(R.id.tablespoonsnumber);
                tablespoons.setText(cups/3);
            }
        });
    }

}
