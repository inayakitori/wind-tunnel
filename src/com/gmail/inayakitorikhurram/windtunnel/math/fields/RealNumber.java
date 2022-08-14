package com.gmail.inayakitorikhurram.windtunnel.math.fields;

public class RealNumber implements UnwrappableField<Float, RealNumber> {

    private float v;


    public RealNumber(float v){
        this.v = v;
    }

    public RealNumber(IntegerNumber i) {
        v = i.unwrap();
    }

    @Override
    public RealNumber uadd(Float other) {
        v += other;
        return this;
    }

    @Override
    public RealNumber usub(Float other) {
        v -= other;
        return this;
    }

    @Override
    public RealNumber umul(Float other) {
        v *= other;
        return this;
    }

    @Override
    public RealNumber udiv(Float other) {
        v /= other;
        return this;
    }

    @Override
    public Float unwrap() {
        return v;
    }

    @Override
    public RealNumber add(RealNumber other) {
        v += other.v;
        return this;
    }

    @Override
    public RealNumber sub(RealNumber other) {
        v -= other.v;
        return this;
    }

    @Override
    public RealNumber div(RealNumber other) {
        v /= other.v;
        return this;
    }

    @Override
    public RealNumber mul(RealNumber other) {
        v *= other.v;
        return this;
    }

    @Override
    public RealNumber copyFrom(RealNumber other) {
        v = other.v;
        return this;
    }

    @Override
    public RealNumber clone() {
        return new RealNumber(v);
    }

    @Override
    public RealNumber eDiv(RealNumber other) {
        return div(other);
    }

    @Override
    public RealNumber eMul(RealNumber other) {
        return mul(other);
    }

    @Override
    public RealNumber get(int i) {
        return this;
    }

    public IntegerNumber floor(){
        return new IntegerNumber((int)Math.floor(v));
    }

    @Override
    public Float uget(int i) {
        return v;
    }
}
