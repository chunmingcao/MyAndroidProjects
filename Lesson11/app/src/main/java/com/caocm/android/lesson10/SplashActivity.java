package com.caocm.android.lesson10;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import com.caocm.android.lesson10.R;

public class SplashActivity extends Activity {

    private MediaPlayer song1;
    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 5000;
    private Handler handler; //new Handler()
    ImageView splashScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splashScreen = (ImageView)findViewById(R.id.splashscreen);
        splashScreen.setBackgroundResource(R.drawable.splash);
        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
                SplashActivity.this.startActivity(mainIntent);
                SplashActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }

    public void allocateSong1()
    {
        if(song1 == null)
            song1 = MediaPlayer.create(this.getBaseContext(), R.raw.lapaloma);
        song1.setOnPreparedListener(song1PListener);
        song1.setOnCompletionListener(song1CListener);
    }

    private MediaPlayer.OnPreparedListener song1PListener = new MediaPlayer.OnPreparedListener(){
        @Override
        public void onPrepared(MediaPlayer mp){
            playSong1();
        }
    };

    private MediaPlayer.OnCompletionListener song1CListener = new MediaPlayer.OnCompletionListener(){
        @Override
        public void onCompletion(MediaPlayer mp){
            playSong1();
        }
    };

    private void playSong1(){
        if(song1.isPlaying()){
            song1.pause();
        }
        if(song1.getCurrentPosition() != 1){
            song1.seekTo(1);
        }
        song1.start();
    }

    @Override
    protected void onResume(){
        super.onResume();
        allocateSong1();
    }

    @Override
    protected void onPause(){
        deallocateSong1();
        super.onPause();
    }

    private void deallocateSong1(){
        if(song1.isPlaying())
            song1.stop();
        if(song1 != null) {
            song1.release();
            song1 = null;
        }
        song1PListener = null;
        song1PListener = null;
    }
}
