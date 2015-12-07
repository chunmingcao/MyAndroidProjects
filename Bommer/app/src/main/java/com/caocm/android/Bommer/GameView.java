package com.caocm.android.Bommer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.caocm.android.lesson6.R;

import java.util.Random;

/**
 * Created by caocm_000 on 12/2/2015.
 */
public class GameView extends SurfaceView {

    private SurfaceHolder holder;
    private Bitmap[] bluebirds = new Bitmap[10];
    private GameThread gthread = null;

    private int score = 0;
    private Paint scorePaint;

    private float[] birdX = new float[10];//]-205.0f;
    private float[] birdY = new float[10];// 100.0f; // vertical position

    public GameView(Context context) {
        super(context);
        for(int i = 0; i < 10; i ++){
            birdX[i] = -205.0f + i *10;
            birdY[i] = (1+i)*800/3;
        }
        holder = getHolder();
        holder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {

                scorePaint = new Paint();
                scorePaint.setColor(Color.BLACK);
                scorePaint.setTextSize(50.0f);

                Bitmap bluebird = BitmapFactory.decodeResource(getResources(), R.drawable.bluebird);
                bluebird = Bitmap.createScaledBitmap(bluebird, bluebird.getWidth()/4, bluebird.getHeight()/4, false);

                Bitmap duck = BitmapFactory.decodeResource(getResources(), R.drawable.duck);
                duck = Bitmap.createScaledBitmap(duck, duck.getWidth()/8, duck.getHeight()/8, false);

                for(int i = 0; i < 2; i ++){
                    bluebirds[i] = duck.copy(duck.getConfig(), true);
                }
                for(int i = 2; i < 10; i ++){
                    bluebirds[i] = bluebird.copy(bluebird.getConfig(), true);
                    //bluebirds[i] =  BitmapFactory.decodeResource(getResources(), R.drawable.bluebird);
                }
                makeThread();

                gthread.setRunning(true);
                gthread.start();
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });
    }
    public void onDestroy()
    {
        for(Bitmap bp: bluebirds) {
            bp.recycle();
            bp = null;
        }
        System.gc();
    }

    public void makeThread()
    {
        gthread = new GameThread(this);

    }

    public void killThread()
    {
        boolean retry = true;
        gthread.setRunning(false);
        while(retry)
        {
            try
            {
                gthread.join();
                retry = false;
            }
            catch (InterruptedException e)
            {
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas){
        canvas.drawColor(Color.WHITE);

        canvas.drawText("Score: " + String.valueOf(score), 10.0f, 50.0f, scorePaint);

        Random random = new Random();
        for(int i = 0; i < 2; i ++) {
            birdX[i] += 3;
            if(birdX[i] > getWidth()) birdX[i] = -205.0f * i;
            //birdY[i] = getHeight()/2;
            canvas.drawBitmap(bluebirds[i], birdX[i], birdY[i], null);
        }
        for(int i = 4; i < 8; i ++) {
            //birdX[i] -=  random.nextInt(4);
            birdY[i] += 5;
            if(birdY[i] > getHeight()) {
                birdY[i] = -200.0f;
                birdX[i] =  random.nextInt(getWidth() - bluebirds[i].getWidth());
            }
            canvas.drawBitmap(bluebirds[i], birdX[i], birdY[i], null);
        }
        for(int i = 9; i < 10; i ++) {
            birdX[i] += 2;
            birdY[i] += 5;
            if(birdY[i] > getHeight()) {
                birdY[i] = -50.0f;
                birdX[i] = 0;
            }
            canvas.drawBitmap(bluebirds[i], birdX[i], birdY[i], null);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {

        // MotionEvent reports input details from the touch screen
        // and other input controls. In this case, you are only
        // interested in events where the touch position changed.

        float x = e.getX();
        float y = e.getY();

        switch (e.getAction()) {
            case MotionEvent.ACTION_MOVE:
                for(int i = 0; i < 10; i ++) {
                    if(x > birdX[i] && x < birdX[i] + bluebirds[i].getWidth() &&
                            y > birdY[i] && y < birdY[i] + bluebirds[i].getHeight() ){
                        if(i < 2){
                            birdX[i] = -205.0f * (i+1);
                            score -= 50;
                        }else {
                            birdY[i] = -getHeight();
                            score += 10;
                        }
                    }
                }
        }

        return true;
    }
}
