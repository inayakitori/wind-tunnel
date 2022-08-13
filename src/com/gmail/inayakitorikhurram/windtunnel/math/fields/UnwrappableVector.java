package com.gmail.inayakitorikhurram.windtunnel.math.fields;

public interface UnwrappableVector<TYPE, SELF> {
    SELF umul(TYPE other);
    SELF udiv(TYPE other);
    TYPE uget(int i);
}
