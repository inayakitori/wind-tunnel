package com.gmail.inayakitorikhurram.windtunnel.math.fields;

public class IntegerNumber implements FieldElement<IntegerNumber>, UnwrappableField<Integer, IntegerNumber>{

    private int v;

    public IntegerNumber(int v){
        this.v = v;
    }

    @Override
    public IntegerNumber uadd(Integer other) {
        v += other;
        return this;
    }

    @Override
    public IntegerNumber usub(Integer other) {
        v -= other;
        return this;
    }

    @Override
    public IntegerNumber umul(Integer other) {
        v *= other;
        return this;
    }

    @Override
    public IntegerNumber udiv(Integer other) {
        v /= other;
        return this;
    }

    @Override
    public Integer unwrap() {
        return v;
    }

    @Override
    public IntegerNumber add(IntegerNumber other) {
        v += other.v;
        return this;
    }

    @Override
    public IntegerNumber sub(IntegerNumber other) {
        v -= other.v;
        return this;
    }

    @Override
    public IntegerNumber div(IntegerNumber other) {
        v /= other.v;
        return this;
    }

    @Override
    public IntegerNumber mul(IntegerNumber other) {
        v *= other.v;
        return this;
    }

    @Override
    public IntegerNumber copyFrom(IntegerNumber other) {
        v = other.v;
        return this;
    }

    @Override
    public IntegerNumber clone() {
        return this;
    }

    @Override
    public IntegerNumber get(int i) {
        return this;
    }

    @Override
    public Integer uget(int i) {
        return v;
    }
}
