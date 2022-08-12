package com.gmail.inayakitorikhurram.windtunnel.math;

import com.gmail.inayakitorikhurram.windtunnel.Settings;


public class Curve {
    private float[] yVals;
    private Settings settings;
    public Curve(Vector2f[] points){
        settings = Settings.getInstance();
        float width = settings.bounds.start.x - settings.bounds.end.x;
        int pixels = (int)Math.floor(width/settings.resolution);
        yVals = new float[pixels];

        int p0 = 0;
        int p1 = 0;
        for(int i = 0; i < yVals.length; i++){
            float x = i * settings.resolution;
            if(x < points[0].x || x > points[points.length-1].x){
                yVals[i] = 0;
            } else {
                while (points[p0].x < x) {//go up to p0 is before/on x
                    p0++;
                }
                p0 = Math.max(0, p0-1);
                p1 = p0;
                while (x > points[p1].x) {//then move p1 until past/on x
                    p1++;
                }
                //p1 = Math.max(0, p1-1);

                //now p0.x < x < p1.x;

                yVals[i] = MyMath.map(points[p0].x, points[p1].x, points[p1].y, points[p1].y, x);
            }
        }
    }

    public Curve(float[] yVals){
        settings = Settings.getInstance();
        this.yVals = new float[yVals.length];
        System.arraycopy(yVals, 0, this.yVals, 0, yVals.length);
    }

    public Curve(Curve other){
        this(other.yVals);
    }

    public Curve clone(){
        return new Curve(this);
    }

    public float getY(int px){
        if(0 <= px && px < yVals.length) {
            return yVals[px];
        } else{
            return 0;
        }
    }

}
