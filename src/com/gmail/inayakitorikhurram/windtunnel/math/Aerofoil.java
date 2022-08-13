package com.gmail.inayakitorikhurram.windtunnel.math;

import com.gmail.inayakitorikhurram.windtunnel.Settings;
import com.gmail.inayakitorikhurram.windtunnel.math.fields.Vector2f;
import com.gmail.inayakitorikhurram.windtunnel.math.fields.Vector2i;

public class Aerofoil {
    Curve top;
    Curve bottom;
    Settings settings;
    Vector2i pixels;

    public Aerofoil(Curve top, Curve bottom){
        settings = Settings.getInstance();
        pixels = settings.getPixels();
        this.top = top.clone();
        this.bottom = bottom.clone();
    }

    public boolean isInAeroFoil(Vector2i pixel){
        Vector2f position = MyMath.pixelToPosition(pixel, settings);
        return bottom.getY(pixel.uget(0)) < position.uget(1) && position.uget(1) < top.getY(pixel.uget(0));
    }

}
