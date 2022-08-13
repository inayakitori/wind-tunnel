package com.gmail.inayakitorikhurram.windtunnel.simulating;

import com.gmail.inayakitorikhurram.windtunnel.Settings;
import com.gmail.inayakitorikhurram.windtunnel.math.fields.*;

public class Simulator {

    private final Settings settings;
    private VectorSpace<RealNumber, Vector2f> dudt;
    private VectorSpace<RealNumber, Vector2f> u; //flow vel
    private VectorSpace<RealNumber, RealNumber> p; //pressure

    public Simulator(){
        settings = Settings.getInstance();

        u = VectorFactory.vectorSpace(new Vector2f(0, 0), new FieldFunction<Vector2f>() {
            @Override
            public Vector2f f(Vector2i x) {
                return null;
            }
        });
        p = VectorFactory.vectorSpace(settings.initPressure);
    }

    public void tick(){

    }


    public VectorSpace<RealNumber, Vector2f> calculateChangeInFlow(){
        VectorSpace<RealNumber, Vector2f> dudx = FieldOperations.dfdx(u);
    }

    public VectorSpace<RealNumber, Vector2f> getFlow(){
        return u;
    }
}
