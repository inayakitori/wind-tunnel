package com.gmail.inayakitorikhurram.windtunnel.math;

import com.gmail.inayakitorikhurram.windtunnel.Settings;

public class Fieldf implements Field<Float, Fieldf>{
    private float[][] vals;
    private Vector2i pixels;
    private Settings settings;
    public Fieldf(){
        settings = Settings.getInstance();
        Vector2f dims = settings.bounds.start.sub(settings.bounds.end);
        pixels = dims.div(settings.resolution).getFloor();
        vals = new float[pixels.getX()][pixels.getY()];
    }


}
