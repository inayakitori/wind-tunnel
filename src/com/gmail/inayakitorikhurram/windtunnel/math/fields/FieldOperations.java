package com.gmail.inayakitorikhurram.windtunnel.math.fields;

import com.gmail.inayakitorikhurram.windtunnel.Settings;

public class FieldOperations {

    private static Settings settings;

    //not generalised yet cause I can't be bothered
    public static VectorSpace<RealNumber, Matrix2x2f> dfdx(VectorSpace<RealNumber, Vector2f> fx, int dir){
        settings = Settings.getInstance();

        VectorSpace<RealNumber, Vector2f> dfx = VectorFactory.vectorSpace(new Vector2f(0, 0), new FieldFunction<Vector2f>() {
            @Override
            public Vector2f f(Vector2i x0) {
                Vector2i x1 = x0.clone().add(dir == 0? new Vector2i(1, 0) : new Vector2i(0, 1));
                return fx.get(x1).sub(fx.get(x0)).udiv(settings.resolution); //df/dx
            }
        });

        return null;
    }

    public static VectorSpace<RealNumber, Vector2f> d2fdx2(VectorSpace<RealNumber, Vector2f> fx, int dir){
        return null;
    }



}
