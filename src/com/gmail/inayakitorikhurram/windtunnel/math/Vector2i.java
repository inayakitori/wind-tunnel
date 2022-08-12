package com.gmail.inayakitorikhurram.windtunnel.math;

public class Vector2i implements Vector<Integer, Vector2i>{ //only need Vector2s
    public int x;
    public int y;

    public Vector2i(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Vector2i(Vector2i other){
        x = other.x;
        y = other.y;
    }

    @Override
    public Vector2i add(Integer a) {
        x += a;
        y += a;
        return this;
    }

    public Vector2i add(Vector2i other){
        x += other.x;
        y += other.y;
        return this;
    }

    @Override
    public Vector2i sub(Integer a) {
        x -= a;
        y -= a;
        return this;
    }

    @Override
    public Vector2i sub(Vector2i other) {
        x -= other.x;
        y -= other.y;
        return this;
    }

    @Override
    public Vector2i div(Integer a) {
        x /= a;
        y /= a;
        return this;
    }

    @Override
    public Vector2i eDiv(Vector2i other) {
        x /= other.x;
        y /= other.y;
        return this;
    }

    @Override
    public Vector2i mul(Integer a) {
        x*=a;
        y*=a;
        return this;
    }

    @Override
    public Vector2i eMul(Vector2i other) {
        x *= other.x;
        y *= other.y;
        return this;
    }

    @Override
    public Integer dot(Vector2i other) {
        return x * other.x + y * other.y;
    }

    @Override
    public Vector2i clone() {
        return new Vector2i(this);
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public Integer get(int i){
        switch(i){
            case 0:
                return x;
            case 1:
                return y;
            default:
                throw new IllegalArgumentException(i + "is out of bounds");
        }
    }

    public static Vector2i zero() {
        return new Vector2i(0, 0);
    }
}
