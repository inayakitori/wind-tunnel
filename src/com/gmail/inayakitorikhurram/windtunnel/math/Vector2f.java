package com.gmail.inayakitorikhurram.windtunnel.math;

public class Vector2f implements Vector<Float, Vector2f>{ //only need Vector2s
    public float x;
    public float y;

    public Vector2f(float x, float y){
        this.x = x;
        this.y = y;
    }

    public Vector2f(Vector2f other){
        this.x = other.x;
        this.y = other.y;
    }

    @Override
    public Vector2f mul(Float s){
        x *= s;
        y *= s;
        return this;
    }

    @Override
    public Vector2f eMul(Vector2f other) {
        x *= other.x;
        y *= other.y;
        return this;
    }

    @Override
    public Float dot(Vector2f other) {
        return x*other.x + y*other.y;
    }
    @Override
    public Vector2f div(Float s){
        return mul(1/s);
    }

    @Override
    public Vector2f eDiv(Vector2f other) {
        x /= other.x;
        y /= other.y;
        return this;
    }

    @Override
    public Vector2f sub(Float a) {
        x -= a;
        y -= a;
        return this;
    }
    @Override
    public Vector2f sub(Vector2f other){
        x -= other.x;
        y -= other.y;
        return this;
    }

    @Override
    public Vector2f add(Float element) {
        return null;
    }

    @Override
    public Vector2f add(Vector2f other){
        x += other.x;
        y += other.y;
        return this;
    }


    public Vector2i getFloor(){
        return new Vector2i((int) Math.floor(x), (int) Math.floor(y));
    }

    public float getX(){
        return x;
    }

    public float getY(){
        return y;
    }

    public float get(int i){
        return switch (i) {
            case 0 -> x;
            case 1 -> y;
            default -> throw new IllegalArgumentException(i + " is out of bounds");
        };
    }

    public static Vector2f zero(){
        return new Vector2f(0, 0);
    }

    @Override
    public Vector2f clone() {
        return new Vector2f(this);
    }
}
