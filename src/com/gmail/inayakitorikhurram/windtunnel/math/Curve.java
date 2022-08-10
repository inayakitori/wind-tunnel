package com.gmail.inayakitorikhurram.windtunnel.math;

import com.gmail.inayakitorikhurram.windtunnel.Settings;


public class Curve {
    public float[] yVals;
    Settings settings;
    public Curve(Vector2f[] points){
        settings = Settings.getInstance();
        width = settings.bounds.start.x - settings.bounds.end.x;
    }

}
