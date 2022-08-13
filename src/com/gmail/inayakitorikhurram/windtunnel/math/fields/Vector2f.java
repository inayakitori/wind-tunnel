package com.gmail.inayakitorikhurram.windtunnel.math.fields;

public class Vector2f implements Vector<RealNumber, Vector2f>, UnwrappableVector<Float, Vector2f> { //only need Vector2s
    private RealNumber x;
    private RealNumber y;

    public Vector2f(float x, float y){
        this.x = new RealNumber(x);
        this.y = new RealNumber(y);
    }

    public Vector2f(RealNumber x, RealNumber y){
        this.x = x.clone();
        this.y = y.clone();
    }

    public Vector2f(Vector2f other){
        this.x = other.x.clone();
        this.y = other.y.clone();
    }

    public Vector2f(Vector2i other){
        this.x = new RealNumber(other.x);
        this.y = new RealNumber(other.y);
    }


    @Override
    public Vector2f eDiv(Vector2f other) {
        x.div(other.x);
        y.div(other.y);
        return this;
    }

    @Override
    public Vector2f eMul(Vector2f other) {
        x.mul(other.x);
        y.mul(other.y);
        return this;
    }


    @Override
    public Vector2f add(RealNumber element) {
        x.add(element);
        y.add(element);
        return this;
    }

    @Override
    public Vector2f add(Vector2f other) {
        x.add(other.x);
        y.add(other.y);
        return this;
    }

    @Override
    public Vector2f sub(RealNumber element) {
        x.sub(element);
        y.sub(element);
        return this;
    }

    @Override
    public Vector2f sub(Vector2f other) {
        x.sub(other.x);
        y.sub(other.y);
        return this;
    }

    @Override
    public Vector2f div(RealNumber element) {
        x.div(element);
        y.div(element);
        return this;
    }

    @Override
    public Vector2f mul(RealNumber element) {
        x.mul(element);
        y.mul(element);
        return this;
    }

    @Override
    public Vector2f copyFrom(Vector2f other) {
        x.copyFrom(other.x);
        y.copyFrom(other.y);
        return this;
    }

    @Override
    public Vector2f clone() {
        return new Vector2f(this);
    }

    @Override
    public RealNumber get(int i) {
        return switch (i) {
            case 0 -> x;
            case 1 -> y;
            default -> throw new IllegalArgumentException();
        };
    }

    @Override
    public RealNumber dot(Vector2f other) {
        return x.clone().mul(other.x).add(y.clone().mul(other.y));
    }


    public Vector2i getFloor() {
        return new Vector2i(
                x.floor(),
                y.floor()
        );
    }

    @Override
    public Vector2f umul(Float other) {
        x.umul(other);
        y.umul(other);
        return this;
    }

    @Override
    public Vector2f udiv(Float other) {
        x.udiv(other);
        y.udiv(other);
        return this;
    }

    @Override
    public Float uget(int i) {
        return switch (i) {
            case 0 -> x.unwrap();
            case 1 -> y.unwrap();
            default -> throw new IllegalArgumentException();
        };
    }
}
