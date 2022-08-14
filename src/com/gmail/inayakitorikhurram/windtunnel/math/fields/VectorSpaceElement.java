package com.gmail.inayakitorikhurram.windtunnel.math.fields;

public interface VectorSpaceElement<FIELD, SELF extends VectorSpaceElement<FIELD, SELF>>{

    SELF add(FIELD element);
    SELF add(SELF other);
    SELF sub(FIELD element);
    SELF sub(SELF other);
    SELF div(FIELD element);
    SELF mul(FIELD element);
    SELF copyFrom(SELF other); //redundant but
    SELF clone();
    SELF eDiv(SELF other);
    SELF eMul(SELF other);

    FIELD get(int i);

}
