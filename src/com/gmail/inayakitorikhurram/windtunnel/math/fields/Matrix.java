package com.gmail.inayakitorikhurram.windtunnel.math.fields;

public interface Matrix<FIELD, SELF extends Matrix<FIELD, SELF>> extends VectorSpaceElement<FIELD, SELF> {
    SELF eDiv(SELF other);
    SELF eMul(SELF other);
    FIELD get(int row, int col);
}
