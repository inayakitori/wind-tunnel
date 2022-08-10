package com.gmail.inayakitorikhurram.windtunnel.math;

public class Vector2i implements Vector<Integer, Vector2i>{ //only need Vector2s
    public int x;
    public int y;

    public Vector2i(int x, int y){
        this.x = x;
        this.y = y;
    }


    public Vector2i add(Vector2i other){
        x += other.x;
        y += other.y;
        return this;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int get(int i){
        switch(i){
            case 0:
                return x;
            case 1:
                return y;
            default:
                throw new IllegalArgumentException(i + "is out of bounds");
        }
    }

    public static Vector2f zero() {
        return new Vector2f(0, 0);
    }
}
