package com.gmail.inayakitorikhurram.windtunnel.math.fields;

public class Matrix2x2f implements Matrix<RealNumber, Matrix2x2f>{
    RealNumber[][] vals;

    // [row][column]

    // 0 1
    // 2 3

    //a b
    //c d

    public Matrix2x2f(Matrix2x2f other){
        this(other.vals[0][0], other.vals[0][1], other.vals[1][0], other.vals[1][1]);
    }
    public Matrix2x2f(RealNumber a , RealNumber b, RealNumber c, RealNumber d){
        vals = new RealNumber[][]{
                {a.clone(), b.clone()},
                {c.clone(), d.clone()}
        };
    }

    public Matrix2x2f(Float a, Float b, Float c, Float d){
        vals = new RealNumber[][]{
            {new RealNumber(a), new RealNumber(b)},
            {new RealNumber(c), new RealNumber(d)}
        };
    }


    @Override
    public Matrix2x2f eDiv(Matrix2x2f other) {
        vals[0][0].div(other.vals[0][0]);
        return this;
    }

    @Override
    public Matrix2x2f eMul(Matrix2x2f other) {
        return this;
    }

    @Override
    public Matrix2x2f add(RealNumber element) {
        return this;
    }

    @Override
    public Matrix2x2f add(Matrix2x2f other) {
        return this;
    }

    @Override
    public Matrix2x2f sub(RealNumber element) {
        return this;
    }

    @Override
    public Matrix2x2f sub(Matrix2x2f other) {
        return this;
    }
    @Override
    public Matrix2x2f div(RealNumber element) {
        return this;
    }

    @Override
    public Matrix2x2f mul(RealNumber element) {
        return this;
    }

    @Override
    public Matrix2x2f copyFrom(Matrix2x2f other) {
        return this;
    }

    @Override
    public Matrix2x2f clone() {
        return new Matrix2x2f(this);
    }

    @Override
    public RealNumber get(int i) {
        return vals[i>>1][i&1];
    }

    @Override
    public RealNumber get(int row, int col) {
        return vals[row][col];
    }
}
