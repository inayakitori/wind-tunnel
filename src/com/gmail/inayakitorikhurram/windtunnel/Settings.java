package com.gmail.inayakitorikhurram.windtunnel;

import com.gmail.inayakitorikhurram.windtunnel.math.*;
import com.gmail.inayakitorikhurram.windtunnel.math.fields.RealNumber;
import com.gmail.inayakitorikhurram.windtunnel.math.fields.Vector2f;
import com.gmail.inayakitorikhurram.windtunnel.math.fields.Vector2i;
import com.gmail.inayakitorikhurram.windtunnel.rendering.Renderer;
import com.gmail.inayakitorikhurram.windtunnel.simulating.Simulator;

import java.awt.*;

public class Settings {


    //ISA values from https://onlinelibrary.wiley.com/doi/pdf/10.1002/9781118534786.app1
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
    public Vector2f bodyForce = new Vector2f(0, -9.81f);
    public RealNumber altitude = new RealNumber(13137); //43,100 ft
    private RealNumber temp = new RealNumber(216.65f);
    //public RealNumber temp0 = new RealNumber(288f);
    private RealNumber dynamicViscocity = new RealNumber(0.00002636f);// from https://www.engineeringtoolbox.com/air-absolute-kinematic-viscosity-d_601.html
    private RealNumber density = new RealNumber(0.2611f);// decreases by 0.00004098/m up

    public RealNumber initPressure = new RealNumber(16236); //decreases by -2.56Pa/m up
    private RealNumber kinematicViscosity = dynamicViscocity.clone().div(density);
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

    public RealNumber getTemperature() {
        if(temp == null){
            //temp = temp0.clone().sub(altitude.clone().umul(0.0065f));
        }
        return temp;
    }

    public RealNumber getDynamicViscocity(){
        if(dynamicViscocity == null){
            return null;//???
        }
        return dynamicViscocity;
    }

    public RealNumber getKinematicViscosity() {
        if(kinematicViscosity == null){
            kinematicViscosity = getDynamicViscocity().clone().div(getDensity());
        }
        return kinematicViscosity;
    }

    public RealNumber getDensity() {
        if(density == null){
            //density = null;

        }
        return density;
    }


}
