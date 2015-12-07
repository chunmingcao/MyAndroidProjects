package com.caocm.android.Bommer;

/**
 * Created by caocm_000 on 12/6/2015.
 */
public class Devil implements Plot{
    int x;
    int y;
    Land land;

    public Devil(Land land){
        this.land = land;
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
        this.land.setPlot(x, y, this);
    }
    public void move(){

    }
}
