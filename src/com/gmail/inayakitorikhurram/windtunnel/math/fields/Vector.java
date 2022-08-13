package com.gmail.inayakitorikhurram.windtunnel.math.fields;

public interface Vector<FIELD, SELF extends Matrix<FIELD, SELF>> extends Matrix<FIELD, SELF>{
    FIELD dot(SELF other);
}
