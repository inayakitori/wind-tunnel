package com.gmail.inayakitorikhurram.windtunnel.math.fields;

import com.gmail.inayakitorikhurram.windtunnel.Settings;

public class VectorFactory {

    private static Settings settings;

    public static <E extends VectorSpaceElement<?,E>> E zero(VectorSpaceElement e) {
        VectorSpaceElement zeroVal = null;
        if (e.getClass().equals(RealNumber.class)) {
            zeroVal = new RealNumber(0);
        } else if (e.getClass().equals(Vector2f.class)) {
            zeroVal = new Vector2f(0, 0);
        } else if (e.getClass().equals(Vector2i.class)) {
            zeroVal = new Vector2i(0, 0);
        }
        return (E) zeroVal;
    }

    public static
    <F extends FieldElement<F>, E extends VectorSpaceElement<F,E>>
    VectorSpace<F,E>
    vectorSpace(VectorSpaceElement<F,E> e){
        if (e.getClass().equals(RealNumber.class)) {
            return vectorSpace(e, (VectorSpaceElement<F, E>) new RealNumber(0));
        } else if(e.getClass().equals(Vector2f.class)){
            return vectorSpace(e, (VectorSpaceElement<F, E>) new Vector2f(0, 0));
        }else if(e.getClass().equals(Vector2i.class)){
            return vectorSpace(e, (VectorSpaceElement<F, E>) new Vector2i(0, 0));
        } else{
            throw new IllegalArgumentException("Invalid vector space");
        }
    }

    public static
    <FIELD extends FieldElement<FIELD>, VECTOR extends VectorSpaceElement<FIELD, VECTOR>>
    VectorSpace<FIELD, VECTOR>
    vectorSpace(
            VectorSpaceElement<FIELD, VECTOR> e,
            VectorSpaceElement<FIELD, VECTOR> v0
    ){
        getSettings();

        VectorSpace<FIELD, VECTOR> vs = new VectorSpace<>();
        Vector2f dims = settings.bounds.start.clone().sub(settings.bounds.end);
        vs.pixels = dims.div(new RealNumber(settings.resolution)).getFloor();
        vs.vals = array(e, vs.pixels);

        for(int i = 0; i < vs.pixels.x.unwrap(); i++){ for(int j = 0; j < vs.pixels.y.unwrap(); j++){
            vs.vals[i][j].copyFrom((VECTOR) v0);
        }}

        return vs;
    }

    public static
    <FIELD extends FieldElement<FIELD>, VECTOR extends VectorSpaceElement<FIELD, VECTOR>>
    VectorSpace<FIELD, VECTOR>
    vectorSpace(
            VectorSpaceElement<FIELD, VECTOR> e,
            VectorSpace<FIELD, VECTOR> other
    ){
        getSettings();

        VectorSpace<FIELD, VECTOR> vs = new VectorSpace<>();
        Vector2f dims = settings.bounds.start.clone().sub(settings.bounds.end);
        vs.pixels = dims.div(new RealNumber(settings.resolution)).getFloor();
        vs.vals = array(e, vs.pixels);

        for(int i = 0; i < vs.pixels.x.unwrap(); i++){ for(int j = 0; j < vs.pixels.y.unwrap(); j++){
            vs.vals[i][j] = other.vals[i][j].clone();
        }}

        return vs;
    }

    public static
    <FIELD extends  FieldElement<FIELD>, VECTOR extends VectorSpaceElement<FIELD, VECTOR>>
    VECTOR[][]
    array(VectorSpaceElement<FIELD, VECTOR> e, Vector2i dims){
        if (e.getClass().equals(RealNumber.class)) {
            return (VECTOR[][]) new RealNumber[dims.x.unwrap()][dims.y.unwrap()];
        }else if(e.getClass().equals(Vector2f.class)){
            return (VECTOR[][]) new Vector2f[dims.x.unwrap()][dims.y.unwrap()];
        }else if(e.getClass().equals(Vector2i.class)){
            return (VECTOR[][]) new Vector2i[dims.x.unwrap()][dims.y.unwrap()];
        } else{
            throw new IllegalArgumentException("Invalid vector space");
        }
    }

    private static void getSettings(){
        if(settings == null){
            settings = Settings.getInstance();
        }
    }

}
