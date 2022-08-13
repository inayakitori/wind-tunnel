package com.gmail.inayakitorikhurram.windtunnel.math.fields;

import com.gmail.inayakitorikhurram.windtunnel.Settings;

public class VectorSpace
        <
                FIELD extends FieldElement<FIELD>,
                VECTOR extends VectorSpaceElement<FIELD, VECTOR>
                >{
    protected VECTOR[][] vals;
    protected Vector2i pixels;
    protected Settings settings;


    protected VectorSpace(){
        settings = Settings.getInstance();
    }

    //NOTE: NO CHECK FOR DIMENSION MISMATCH.
    // It should be fine cause in settings the resolution
    // and everything should only be defined once
    
    public VectorSpace<FIELD, VECTOR> add(FIELD scalar) {
        //for every pixel
        for(int i = 0; i < pixels.x.unwrap(); i++){ for(int j = 0; j < pixels.y.unwrap(); j++){
            vals[i][j].add(scalar);
        }}
        return this;
    }


    public VectorSpace<FIELD, VECTOR> add(VectorSpace<FIELD, FIELD> scalarField) {
        for(int i = 0; i < pixels.x.unwrap(); i++){ for(int j = 0; j < pixels.y.unwrap(); j++){
            vals[i][j].add(scalarField.vals[i][j]);
        }}
        return this;
    }

    //TODO maybe combine vector and element addition?
    public VectorSpace<FIELD, VECTOR> sub(FIELD element) {
        //for every pixel
        for(int i = 0; i < pixels.x.unwrap(); i++){ for(int j = 0; j < pixels.y.unwrap(); j++){
            vals[i][j].sub(element);
        }}
        return this;
    }

    public VectorSpace<FIELD, VECTOR> sub(VECTOR element) {
        //for every pixel
        for(int i = 0; i < pixels.x.unwrap(); i++){ for(int j = 0; j < pixels.y.unwrap(); j++){
            vals[i][j].sub(element);
        }}
        return this;
    }



    public VectorSpace<FIELD, VECTOR> sub(VectorSpace<FIELD, VECTOR> other) {
        for(int i = 0; i < pixels.x.unwrap(); i++){ for(int j = 0; j < pixels.y.unwrap(); j++){
            vals[i][j].sub(other.vals[i][j]);
        }}
        return this;
    }

    public VectorSpace<FIELD, VECTOR> mul(FIELD element) {
        for(int i = 0; i < pixels.x.unwrap(); i++){ for(int j = 0; j < pixels.y.unwrap(); j++){
            vals[i][j].mul(element);
        }}
        return this;
    }


    public VectorSpace<FIELD, VECTOR> mul(VectorSpace<FIELD, FIELD> other) {
        for(int i = 0; i < pixels.x.unwrap(); i++){ for(int j = 0; j < pixels.y.unwrap(); j++){
            vals[i][j].mul(other.vals[i][j]);
        }}
        return this;
    }

    
    public VECTOR integrate(VectorSpace<FIELD, FIELD> mask) {
        VectorSpace<FIELD, VECTOR> maskedValues= VectorFactory.vectorSpace(vals[0][0], this).mul(mask);
        VECTOR sum = VectorFactory.zero(vals[0][0]);
        //TODO assumes scalar float field, but will break if it's a different field
        RealNumber da = new RealNumber(settings.resolution * settings.resolution);
        for(int i = 0; i < pixels.x.unwrap(); i++){ for(int j = 0; j < pixels.y.unwrap(); j++){
                sum.add(maskedValues.vals[i][j]);
        }}
        sum.mul((FIELD)da);
        return sum;
    }

    public VECTOR get(int i, int j){
        return vals[i][j].clone();
    }

    public VECTOR get(Vector2i x){
        return vals[x.uget(0)][x.uget(1)].clone();
    }

}
