package com.gmail.inayakitorikhurram.windtunnel.math.fields;

public interface Vector<FIELD, SELF extends VectorSpaceElement<FIELD, SELF>> extends VectorSpaceElement<FIELD, SELF>{
    FIELD dot(SELF other);
}
