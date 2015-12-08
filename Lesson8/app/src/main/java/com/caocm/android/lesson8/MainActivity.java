package com.caocm.android.lesson8;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;


public class MainActivity extends Activity {

    GameView gv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        gv = new GameView(this);
        setContentView(gv);
    }
    @Override
    protected void onPause()
    {
        super.onPause();
        gv.killThread(); //Notice this reaches into the GameView object and runs the killThread mehtod.
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        gv.onDestroy();
    }
}
