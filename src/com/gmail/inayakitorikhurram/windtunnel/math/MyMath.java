package com.gmail.inayakitorikhurram.windtunnel.math;

import com.gmail.inayakitorikhurram.windtunnel.Settings;

public class MyMath {

    public static float lerp(float a,float b, float t){
        return (b-a)*t + a;
    }

    public static <V extends Vector<Float,V>> Vector<Float,V> lerp(V a, V b, float t){
        return b.clone().sub(a).mul(t).add(a);
    }

    public static float ilerp(float a, float b, float x){
        return (x-a)/(b-a);
    }

    public static <V extends Vector<Float,V>> Float ilerp(V a, V b, V x){
        return x.clone().sub(a).eDiv(b.clone().sub(a)).get(0);
    }

    public static float map(float a, float b, float c, float d, float t){
        return lerp(c, d, ilerp(a,b,t));
    }


    public static <V extends Vector<Float,V>> Vector<Float,V> map(V a, V b, V c, V d, V x){
        return lerp(c, d, MyMath.ilerp(a, b, x));
    }

    public static Vector2f pixelToPosition(Vector2i pixel, Settings settings){
        Vector2i pixels = settings.getPixels();
        float x = map(0, pixels.x, settings.bounds.start.x, settings.bounds.end.x, pixel.x);
        float y = map(0, pixels.y, settings.bounds.start.y, settings.bounds.end.y, pixel.y);
        return new Vector2f(x, y);
    }

}
