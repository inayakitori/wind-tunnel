package com.gmail.inayakitorikhurram.windtunnel.math.fields;

import com.gmail.inayakitorikhurram.windtunnel.Settings;

public class FieldOperations {

    private static Settings settings;

    //not generalised yet cause I can't be bothered
    //TODO boundary conditions, take forward/backward derivative if on edge

    public static VectorSpace<RealNumber, RealNumber> laplacian(VectorSpace<RealNumber, RealNumber> f){

        VectorSpace<RealNumber, RealNumber> L = VectorFactory.vectorSpace(new RealNumber(0f), new FieldFunction<RealNumber>() {
            @Override
            public RealNumber apply(Vector2i p) {
                RealNumber fplusdx  = f.get(p.clone().add(new Vector2i(1, 0))).get(0);
                RealNumber fx = f.get(p).get(0);
                RealNumber fminusdx = f.get(p.clone().add(new Vector2i(1, 0))).get(0);

                //2nd derivative

                RealNumber ddfx = fplusdx.sub(fx.umul(2f)).add(fminusdx);

                return ddfx.udiv(settings.resolution * settings.resolution); //
            }
        });
        return L;
    }

    public static VectorSpace<RealNumber, Vector2f> vectorLaplacian(VectorSpace<RealNumber, Vector2f> f){

        VectorSpace<RealNumber, Vector2f> vL = VectorFactory.vectorSpace(new Vector2f(0, 0), new FieldFunction<Vector2f>() {
            @Override
            public Vector2f apply(Vector2i p) {
                RealNumber fplusdx  = f.get(p.clone().add(new Vector2i(1, 0))).get(0);
                RealNumber fplusdy  = f.get(p.clone().add(new Vector2i(0, 1))).get(1);
                RealNumber fx = f.get(p).get(0);
                RealNumber fy = f.get(p).get(0);
                RealNumber fminusdx = f.get(p.clone().add(new Vector2i(1, 0))).get(0);
                RealNumber fminusdy = f.get(p.clone().add(new Vector2i(0, 1))).get(1);

                //2nd derivative

                RealNumber ddfx = fplusdx.sub(fx.umul(2f)).add(fminusdx);
                RealNumber ddfy = fplusdy.sub(fy.umul(2f)).add(fminusdy);

                return new Vector2f(ddfx, ddfy).udiv(settings.resolution * settings.resolution); //
            }
        });
        return vL;
    }

    //jacobian: (N^2->R^2) -> (N^2->)
    public static VectorSpace<RealNumber, Matrix2x2f> jacobian(VectorSpace<RealNumber, Vector2f> f){
        settings = Settings.getInstance();

        VectorSpace<RealNumber, Matrix2x2f> J = VectorFactory.vectorSpace(new Matrix2x2f(0f, 0f, 0f, 0f), new FieldFunction<Matrix2x2f>() {
            @Override
            public Matrix2x2f apply(Vector2i p) {
                Vector2i plusdx = p.clone().add(new Vector2i(1, 0));
                Vector2i plusdy = p.clone().add(new Vector2i(0, 1));

                Vector2f dfx = f.get(plusdx).clone().sub(f.get(p));
                Vector2f dfy = f.get(plusdy).clone().sub(f.get(p));

                return new Matrix2x2f(dfx, dfy).div(new RealNumber(settings.resolution)); //
            }
        });

        return J;
    }

    public static VectorSpace<RealNumber, RealNumber> divergence(VectorSpace<RealNumber, Vector2f> f){
        settings = Settings.getInstance();

        VectorSpace<RealNumber, RealNumber> div = VectorFactory.vectorSpace(new RealNumber(0f), new FieldFunction<RealNumber>() {
            @Override
            public RealNumber apply(Vector2i p) {
                Vector2i plusdx = p.clone().add(new Vector2i(1, 0));
                Vector2i plusdy = p.clone().add(new Vector2i(0, 1));

                RealNumber dfxdx = f.get(plusdx).get(0).clone().sub(f.get(p).get(0));
                RealNumber dfydy = f.get(plusdy).get(0).clone().sub(f.get(p).get(0));

                return dfxdx.add(dfydy).div(new RealNumber(settings.resolution)); //
            }
        });

        return div;
    }


    public static VectorSpace<RealNumber, Vector2f> gradient(VectorSpace<RealNumber, RealNumber> f){
        settings = Settings.getInstance();

        VectorSpace<RealNumber, Vector2f> grad = VectorFactory.vectorSpace(new Vector2f(0f, 0f), new FieldFunction<Vector2f>() {
            @Override
            public Vector2f apply(Vector2i p) {
                Vector2i plusdx = p.clone().add(new Vector2i(1, 0));
                Vector2i plusdy = p.clone().add(new Vector2i(0, 1));

                RealNumber dfdx = f.get(plusdx).clone().sub(f.get(p));
                RealNumber dfdy = f.get(plusdy).clone().sub(f.get(p));

                return new Vector2f(dfdx, dfdy); //
            }
        });

        return grad;
    }


}
