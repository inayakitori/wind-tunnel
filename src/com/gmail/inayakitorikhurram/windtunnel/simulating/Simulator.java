package com.gmail.inayakitorikhurram.windtunnel.simulating;

import com.gmail.inayakitorikhurram.windtunnel.Settings;
import com.gmail.inayakitorikhurram.windtunnel.math.MyMath;
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
            public Vector2f apply(Vector2i x) {
                return MyMath.pixelToPosition(x, settings).clone()
                        .eMul(settings.airfoil.vector2fMask.apply(x));
            }
        });
        p = VectorFactory.vectorSpace(settings.initPressure);
    }

    public void tick(){
        u.add(calculateChangeInFlow());
        int x = 1;
    }


    public VectorSpace<RealNumber, Vector2f> calculateChangeInFlow(){
        VectorSpace<RealNumber, RealNumber> divu = FieldOperations.divergence(VectorFactory.vectorSpace(u.get(0, 0), u));
        VectorSpace<RealNumber, Vector2f> convection = VectorFactory.vectorSpace(new Vector2f(0, 0), new FieldFunction<Vector2f>() {
            @Override
            public Vector2f apply(Vector2i x) {
                return u.get(x).clone().mul(divu.get(x));
            }
        });

        VectorSpace<RealNumber, Vector2f> diffusion = FieldOperations.vectorLaplacian(VectorFactory.vectorSpace(u.get(0, 0), u)).mul(settings.getKinematicViscosity());


        VectorSpace<RealNumber, Vector2f> pressureForce = FieldOperations.gradient(VectorFactory.vectorSpace(p.get(0, 0), p));

        VectorSpace<RealNumber, Vector2f> bodyForce = VectorFactory.vectorSpace(u.get(0, 0), settings.bodyForce);

        return bodyForce.add(diffusion).sub(convection).sub(pressureForce);
    }

    public VectorSpace<RealNumber, Vector2f> getFlow(){
        return u;
    }
}
