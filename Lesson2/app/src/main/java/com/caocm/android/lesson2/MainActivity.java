package com.caocm.android.lesson2;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
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

        TextView title = new TextView(this);
        title.setText("App Components");
        title.setTextSize(50);
        title.setTextColor(Color.BLUE);
        layout.addView(title);

        TextView body = new TextView(this);
        body.setText("App components are the essential building blocks of an Android app. " +
                "Each component is a different point through which the system can enter your app. " +
                "Not all components are actual entry points for the user and some depend on each other, " +
                "but each one exists as its own entity and plays a specific role—each one is a unique building " +
                "block that helps define your app's overall behavior.");
        body.setTextSize(30);
        body.setTextColor(Color.GREEN);
        layout.addView(body);

        TextView remark = new TextView(this);
        remark.setText("-- Chunming");
        remark.setTextSize(10);
        remark.setTextColor(Color.YELLOW);
        layout.addView(remark);

        setContentView(layout);
    }
}
