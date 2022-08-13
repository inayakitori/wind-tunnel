package com.gmail.inayakitorikhurram.windtunnel.math;

import com.gmail.inayakitorikhurram.windtunnel.math.fields.Vector2f;

public class Rectf {
    public Vector2f start;
    public Vector2f end;

    public Rectf(Vector2f start, Vector2f end){
        this.start = new Vector2f(start);
        this.end = new Vector2f(end);
    }
    
    public Rectf(float x0, float y0, float x1, float y1){
        start = new Vector2f(x0, y0);
        end = new Vector2f(x1, y1);
    }

}
