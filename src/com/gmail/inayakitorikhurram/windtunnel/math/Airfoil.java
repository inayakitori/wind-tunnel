package com.gmail.inayakitorikhurram.windtunnel.math;

import com.gmail.inayakitorikhurram.windtunnel.Settings;
import com.gmail.inayakitorikhurram.windtunnel.math.fields.*;

public class Airfoil {
    Curve top;
    Curve bottom;
    Settings settings;
    Vector2i pixels;
    //public final FieldFunction<RealNumber, RealNumber> scalarMask;
    public final FieldFunction<Vector2f> vector2fMask;
    //public final FieldFunction<IntegerNumber, Vector2i> vector2iMask;

    public Airfoil(Curve top, Curve bottom){
        settings = Settings.getInstance();
        pixels = settings.getPixels();
        this.top = top.clone();
        this.bottom = bottom.clone();
        //scalarMask = x -> isInAeroFoil(x) ? new RealNumber(0) : new RealNumber(1);
        vector2fMask = new FieldFunction<Vector2f>() {
            @Override
            public Vector2f apply(Vector2i x) {
                return isInAeroFoil(x) ? new Vector2f(0, 0) : new Vector2f(1, 1);
            }
        };
        //vector2iMask = x -> isInAeroFoil(x) ?  new Vector2i(0, 0) : new Vector2i(1, 1);

    }

    public boolean isInAeroFoil(Vector2i pixel){
        Vector2f position = MyMath.pixelToPosition(pixel, settings);
        return bottom.getY(pixel.uget(0)) < position.uget(1) && position.uget(1) < top.getY(pixel.uget(0));
    }
    public boolean isInAeroFoil(Vector2f position){
        Vector2i pixel = MyMath.positionToPixel(position, settings);
        return bottom.getY(pixel.uget(0)) < position.uget(1) && position.uget(1) < top.getY(pixel.uget(0));
    }


}
