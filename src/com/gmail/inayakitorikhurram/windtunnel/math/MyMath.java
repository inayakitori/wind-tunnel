package com.gmail.inayakitorikhurram.windtunnel.math;

import com.gmail.inayakitorikhurram.windtunnel.Settings;
import com.gmail.inayakitorikhurram.windtunnel.math.fields.Matrix;
import com.gmail.inayakitorikhurram.windtunnel.math.fields.Vector2f;
import com.gmail.inayakitorikhurram.windtunnel.math.fields.Vector2i;

public class MyMath {

    public static float lerp(float a,float b, float t){
        return (b-a)*t + a;
    }

    public static <V extends Matrix<Float,V>> Matrix<Float,V> lerp(V a, V b, float t){
        return b.clone().sub(a).mul(t).add(a);
    }

    public static float ilerp(float a, float b, float x){
        return (x-a)/(b-a);
    }

    public static <V extends Matrix<Float,V>> Float ilerp(V a, V b, V x){
        return x.clone().sub(a).eDiv(b.clone().sub(a)).get(0);
    }

    public static float map(float a, float b, float c, float d, float t){
        return lerp(c, d, ilerp(a,b,t));
    }


    public static <V extends Matrix<Float,V>> Matrix<Float,V> map(V a, V b, V c, V d, V x){
        return lerp(c, d, MyMath.ilerp(a, b, x));
    }

    public static Vector2f pixelToPosition(Vector2i pixel, Settings settings){
        Vector2i pixels = settings.getPixels();
        float x = map(0, pixels.uget(0), settings.bounds.start.uget(0), settings.bounds.end.uget(0), pixel.uget(0));
        float y = map(0, pixels.uget(1), settings.bounds.start.uget(1), settings.bounds.end.uget(1), pixel.uget(1));
        return new Vector2f(x, y);
    }

}
