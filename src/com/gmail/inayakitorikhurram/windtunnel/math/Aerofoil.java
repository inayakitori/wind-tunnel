package com.gmail.inayakitorikhurram.windtunnel.math;

import com.gmail.inayakitorikhurram.windtunnel.Settings;

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
        return bottom.getY(pixel.x) < position.y && position.y < top.getY(pixel.x);
    }

}
