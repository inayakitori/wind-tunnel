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
        vals[0][1].div(other.vals[0][1]);
        vals[1][0].div(other.vals[1][0]);
        vals[1][1].div(other.vals[1][1]);
        return this;
    }

    @Override
    public Matrix2x2f eMul(Matrix2x2f other) {
        vals[0][0].mul(other.vals[0][0]);
        vals[0][1].mul(other.vals[0][1]);
        vals[1][0].mul(other.vals[1][0]);
        vals[1][1].mul(other.vals[1][1]);
        return this;
    }

    @Override
    public Matrix2x2f add(RealNumber element) {
        vals[0][0].add(element);
        vals[0][1].add(element);
        vals[1][0].add(element);
        vals[1][1].add(element);
        return this;
    }

    @Override
    public Matrix2x2f add(Matrix2x2f other) {
        vals[0][0].add(other.vals[0][0]);
        vals[0][1].add(other.vals[0][1]);
        vals[1][0].add(other.vals[1][0]);
        vals[1][1].add(other.vals[1][1]);
        return this;
    }

    @Override
    public Matrix2x2f sub(RealNumber element) {
        vals[0][0].sub(element);
        vals[0][1].sub(element);
        vals[1][0].sub(element);
        vals[1][1].sub(element);
        return this;
    }

    @Override
    public Matrix2x2f sub(Matrix2x2f other) {
        vals[0][0].sub(other.vals[0][0]);
        vals[0][1].sub(other.vals[0][1]);
        vals[1][0].sub(other.vals[1][0]);
        vals[1][1].sub(other.vals[1][1]);
        return this;
    }
    @Override
    public Matrix2x2f div(RealNumber element) {
        vals[0][0].div(element);
        vals[0][1].div(element);
        vals[1][0].div(element);
        vals[1][1].div(element);
        return this;
    }

    @Override
    public Matrix2x2f mul(RealNumber element) {
        vals[0][0].mul(element);
        vals[0][1].mul(element);
        vals[1][0].mul(element);
        vals[1][1].mul(element);
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


    //a1 b1     a2  b2  = a1*a2 + b1*c2   a1*b2 + b1*d2
    //c1 d1  *  c2  d2  = c1*a2 + d1*c2   c1*b2 + d1*d2
    @Override
    public Matrix2x2f mul(Matrix2x2f other) {
        //TODO this
        vals[0][0].mul(other.get(0,0)).add(get(1,0).clone().mul(other));
        return null;
    }
}
