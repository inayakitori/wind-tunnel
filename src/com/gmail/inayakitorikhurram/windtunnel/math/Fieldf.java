package com.gmail.inayakitorikhurram.windtunnel.math;

import com.gmail.inayakitorikhurram.windtunnel.Settings;

public class Fieldf implements Field<Float, Fieldf>{
    private float[][] vals;
    private Vector2i pixels;
    private Settings settings;
    public Fieldf(){
        settings = Settings.getInstance();
        pixels = settings.getPixels();
        vals = new float[pixels.getX()][pixels.getY()];
    }


    @Override
    public Fieldf add(Float a) {
        for(int i = 0; i < pixels.x; i++){for(int j = 0; j < pixels.y; j++){
            vals[i][j] += a;
        }}
        return this;
    }

    @Override
    public Fieldf add(Fieldf other) {
        for(int i = 0; i < pixels.x; i++){for(int j = 0; j < pixels.y; j++){
            vals[i][j] += other.vals[i][j];
        }}
        return this;
    }

    @Override
    public Fieldf sub(Float a) {
        for(int i = 0; i < pixels.x; i++){for(int j = 0; j < pixels.y; j++){
            vals[i][j] -= a;
        }}
        return this;
    }

    @Override
    public Fieldf sub(Fieldf other) {
        for(int i = 0; i < pixels.x; i++){for(int j = 0; j < pixels.y; j++){
            vals[i][j] -= other.vals[i][j];
        }}
        return this;
    }

    @Override
    public Fieldf mul(Float a) {
        for(int i = 0; i < pixels.x; i++){for(int j = 0; j < pixels.y; j++){
            vals[i][j] *= a;
        }}
        return this;
    }

    @Override
    public Fieldf mul(Fieldf other) {
        for(int i = 0; i < pixels.x; i++){for(int j = 0; j < pixels.y; j++){
            vals[i][j] *= other.vals[i][j];
        }}
        return this;
    }

    @Override
    public Float integrate(Fieldf mask) {
        Fieldf maskedValues= mask.clone().mul(this);
        float sum = 0;
        float da = settings.resolution * settings.resolution;
        for(int i = 0; i < pixels.getX(); i++){ for(int j = 0; j < pixels.getY(); j++){
            sum+=maskedValues.vals[i][j];
        }}
        sum*=da;
        return sum;
    }

    @Override
    public Fieldf clone() {
        return null;
    }
}
