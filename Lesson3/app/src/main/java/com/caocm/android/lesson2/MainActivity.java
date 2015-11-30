package com.caocm.android.lesson2;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by caocm_000 on 11/24/2015.
 */
public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setGravity(Gravity.TOP);
        layout.setOrientation(LinearLayout.VERTICAL);

        TextView cupsLabel = new TextView(this);
        cupsLabel.setText("Cups:");
        cupsLabel.setTextSize(30);
        cupsLabel.setTextColor(Color.BLUE);
        layout.addView(cupsLabel);

        final EditText cupsInput = new EditText(this);
        layout.addView(cupsInput);

        TextView teaspoonsLabel = new TextView(this);
        teaspoonsLabel.setText("Teaspoons:");
        teaspoonsLabel.setTextSize(30);
        teaspoonsLabel.setTextColor(Color.GREEN);
        layout.addView(teaspoonsLabel);

        final TextView teaspoons = new TextView(this);
        teaspoons.setTextSize(30);
        layout.addView(teaspoons);

        TextView tablespoosLabel = new TextView(this);
        tablespoosLabel.setText("Tablespoons:");
        tablespoosLabel.setTextSize(30);
        tablespoosLabel.setTextColor(Color.GREEN);
        layout.addView(tablespoosLabel);

        final TextView tablespoons = new TextView(this);
        tablespoons.setTextSize(30);
        layout.addView(tablespoons);

        Button button = new Button(this);
        button.setText("Submit");
        layout.addView(button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cups = Integer.parseInt(cupsInput.getText().toString());
                teaspoons.setText(cups);
                tablespoons.setText(cups/3);
            }
        });

        setContentView(layout);
    }
}
