package com.gmail.inayakitorikhurram.windtunnel;

import com.gmail.inayakitorikhurram.windtunnel.math.*;
import com.gmail.inayakitorikhurram.windtunnel.math.fields.RealNumber;
import com.gmail.inayakitorikhurram.windtunnel.math.fields.Vector2f;
import com.gmail.inayakitorikhurram.windtunnel.math.fields.Vector2i;
import com.gmail.inayakitorikhurram.windtunnel.rendering.Renderer;
import com.gmail.inayakitorikhurram.windtunnel.simulating.Simulator;

import java.awt.*;

public class Settings {

    private static Settings settings;

    public float resolution;
    public Rectf bounds;
    private Vector2i pixels;
    public Color backgroundColor;
    public int msPerFrame;
    public int msPerTick;
    public Renderer renderer;
    public Simulator simulator;
    public Vector2f initFlow;
    public RealNumber initPressure;
    public Airfoil airfoil;
    private Settings(){
    }

    public static Settings getInstance(){
        if(settings == null){
            settings = new Settings();
        }
        return settings;
    }

    public Vector2i getPixels(){
        if(pixels == null){
            Vector2f dims = bounds.end.clone().sub(settings.bounds.start);
            pixels = dims.udiv(settings.resolution).getFloor();
        }
        return pixels;
    }


}
