package com.gmail.inayakitorikhurram.windtunnel.math.fields;

public class Vector2i implements Vector<IntegerNumber, Vector2i>, UnwrappableVector<Integer, Vector2i> { //only need Vector2s
    public IntegerNumber x;
    public IntegerNumber y;

    public Vector2i(int x, int y){
        this.x = new IntegerNumber(x);
        this.y = new IntegerNumber(y);
    }
    
    public Vector2i(IntegerNumber x, IntegerNumber y){
        this.x = x.clone();
        this.y = y.clone();
    }

    public Vector2i(Vector2i other){
        x = other.x.clone();
        y = other.y.clone();
    }


    @Override
    public Vector2i eDiv(Vector2i other) {
        x.div(other.x);
        y.div(other.y);
        return this;
    }

    @Override
    public Vector2i eMul(Vector2i other) {
        x.mul(other.x);
        y.mul(other.y);
        return this;
    }


    @Override
    public Vector2i add(IntegerNumber element) {
        x.add(element);
        y.add(element);
        return this;
    }

    @Override
    public Vector2i add(Vector2i other) {
        x.add(other.x);
        y.add(other.y);
        return this;
    }

    @Override
    public Vector2i sub(IntegerNumber element) {
        x.sub(element);
        y.sub(element);
        return this;
    }

    @Override
    public Vector2i sub(Vector2i other) {
        x.sub(other.x);
        y.sub(other.y);
        return this;
    }

    @Override
    public Vector2i div(IntegerNumber element) {
        x.div(element);
        y.div(element);
        return this;
    }

    @Override
    public Vector2i mul(IntegerNumber element) {
        x.mul(element);
        y.mul(element);
        return this;
    }

    @Override
    public Vector2i copyFrom(Vector2i other) {
        x.copyFrom(other.x);
        y.copyFrom(other.y);
        return this;
    }

    @Override
    public Vector2i clone() {
        return new Vector2i(this);
    }

    @Override
    public IntegerNumber get(int i) {
        return switch (i) {
            case 0 -> x;
            case 1 -> y;
            default -> throw new IllegalArgumentException();
        };
    }

    @Override
    public IntegerNumber dot(Vector2i other) {
        return x.clone().mul(other.x).add(y.clone().mul(other.y));
    }



    @Override
    public Vector2i umul(Integer other) {
        x.umul(other);
        y.umul(other);
        return this;
    }

    @Override
    public Vector2i udiv(Integer other) {
        x.udiv(other);
        y.udiv(other);
        return this;
    }

    @Override
    public Integer uget(int i) {
        return switch (i) {
            case 0 -> x.unwrap();
            case 1 -> y.unwrap();
            default -> throw new IllegalArgumentException();
        };
    }
}
