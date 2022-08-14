package com.gmail.inayakitorikhurram.windtunnel.math.fields;

public interface Matrix<FIELD, SELF extends Matrix<FIELD, SELF>> extends VectorSpaceElement<FIELD, SELF> {
    FIELD get(int row, int col);
    SELF mul(SELF other);
}
