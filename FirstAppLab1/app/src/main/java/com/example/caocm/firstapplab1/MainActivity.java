package com.example.caocm.firstapplab1;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setGravity(Gravity.BOTTOM | Gravity.CENTER);
        layout.setOrientation(LinearLayout.VERTICAL);

        TextView title = new TextView(this);
        title.setText("Title: Hello");
        title.setTextSize(50);

        TextView body = new TextView(this);
        body.setText("Welcome to MUM. Rest and go farther.");

        TextView remark = new TextView(this);
        remark.setText("Thank you!");

        TextView label1 = new TextView(this);
        label1.setTextSize(50);
        label1.setWidth(300);
        label1.setHeight(300);
        label1.setText("Hello ...");
        label1.setBackgroundColor(Color.GREEN);
        layout.addView(label1);

        EditText input1 = new EditText(this);
        input1.setBackgroundColor(Color.GRAY);
        input1.setInputType(InputType.TYPE_CLASS_NUMBER);
        layout.addView(input1);

        setContentView(layout);
        //setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d("State", "onStart");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("State", "onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("State", "onPause");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d("State", "onRestart");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d("State", "onStop");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("State", "onDestroy");
    }
}
