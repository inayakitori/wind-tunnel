package com.gmail.inayakitorikhurram.windtunnel.math;

import com.gmail.inayakitorikhurram.windtunnel.Settings;

public class Fieldv implements Field<Vector2f, Fieldv>{
    private Vector2f[][] vals;
    private Vector2i pixels;
    private Settings settings;

    public Fieldv(Fieldv other){
        settings = Settings.getInstance();
        Vector2f dims = settings.bounds.start.clone().sub(settings.bounds.end);
        pixels = other.pixels.clone();
        vals = new Vector2f[pixels.getX()][pixels.getY()];

        //for every pixel
        for(int i = 0; i < pixels.getX(); i++){ for(int j = 0; j < pixels.getY(); j++){
            vals[i][j] = other.vals[i][j].clone();
        }}
    }

    public Fieldv(Vector2f v0){
        settings = Settings.getInstance();
        Vector2f dims = settings.bounds.start.clone().sub(settings.bounds.end);
        pixels = dims.div(settings.resolution).getFloor();
        vals = new Vector2f[pixels.getX()][pixels.getY()];

        //for every pixel
        for(int i = 0; i < pixels.getX(); i++){ for(int j = 0; j < pixels.getY(); j++){
            vals[i][j] = new Vector2f(v0);
        }}
    }

    public Fieldv(){
        this(Vector2f.zero());
    }

    //NOTE: NO CHECK FOR DIMENSION MISMATCH.
    // It should be fine cause in settings the resolution
    // and everything should only be defined once
    @Override
    public Fieldv add(Vector2f element) {
        //for every pixel
        for(int i = 0; i < pixels.getX(); i++){ for(int j = 0; j < pixels.getY(); j++){
            vals[i][j].add(element);
        }}
        return this;
    }

    @Override
    public Fieldv add(Fieldv other) {
        for(int i = 0; i < pixels.getX(); i++){ for(int j = 0; j < pixels.getY(); j++){
            vals[i][j].add(other.vals[i][j]);
        }}
        return this;
    }

    @Override
    public Fieldv sub(Vector2f element) {
        //for every pixel
        for(int i = 0; i < pixels.getX(); i++){ for(int j = 0; j < pixels.getY(); j++){
            vals[i][j].sub(element);
        }}
        return this;
    }

    @Override
    public Fieldv sub(Fieldv other) {
        for(int i = 0; i < pixels.getX(); i++){ for(int j = 0; j < pixels.getY(); j++){
            vals[i][j].sub(other.vals[i][j]);
        }}
        return this;
    }

    @Override //element-wise
    public Fieldv mul(Vector2f element) {
        for(int i = 0; i < pixels.getX(); i++){ for(int j = 0; j < pixels.getY(); j++){
            vals[i][j].eMul(element);
        }}
        return this;
    }

    @Override
    public Fieldv mul(Fieldv other) {
        for(int i = 0; i < pixels.getX(); i++){ for(int j = 0; j < pixels.getY(); j++){
            vals[i][j].eMul(other.vals[i][j]);
        }}
        return this;
    }

    @Override
    public Vector2f integrate(Fieldv mask) {
        Fieldv maskedValues= mask.clone().mul(this);
        Vector2f sum = Vector2f.zero();
        float da = settings.resolution * settings.resolution;
        for(int i = 0; i < pixels.getX(); i++){ for(int j = 0; j < pixels.getY(); j++){
                sum.add(maskedValues.vals[i][j]);
        }}
        sum.mul(da);
        return sum;
    }

    @Override
    public Fieldv clone() {
        return new Fieldv(this);
    }
}
