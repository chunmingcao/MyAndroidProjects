package com.caocm.android.lesson10;

import android.app.Activity;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;


public class MainActivity extends Activity {

    GameView gv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("MainActivity", "onCreate");
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        gv = new GameView(this);
        setContentView(gv);
    }
    @Override
    protected void onResume(){
        super.onResume();
        SharedPreferences preferences = getSharedPreferences("BIRD", MODE_PRIVATE);
        String score = preferences.getString("SCORE", "0");
        gv.setScore(Integer.parseInt(score));
    }
    @Override
    protected void onPause()
    {
        SharedPreferences preferences = getSharedPreferences("BIRD", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        String temp = Integer.toString(gv.getScore());
        editor.putString("SCORE", temp);
        editor.commit();

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
