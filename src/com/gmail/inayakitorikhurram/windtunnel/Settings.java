package com.gmail.inayakitorikhurram.windtunnel;

import com.gmail.inayakitorikhurram.windtunnel.math.*;
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
    public Aerofoil aerofoil;
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
            Vector2f dims = bounds.start.clone().sub(settings.bounds.end);
            pixels = dims.div(settings.resolution).getFloor();
        }
        return pixels;
    }


}
