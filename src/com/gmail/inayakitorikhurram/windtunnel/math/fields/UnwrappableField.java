package com.gmail.inayakitorikhurram.windtunnel.math.fields;

public interface UnwrappableField<TYPE,SELF extends FieldElement<SELF>> extends UnwrappableVector<TYPE, SELF>, FieldElement<SELF> {
    SELF uadd(TYPE other);
    SELF usub(TYPE other);
    TYPE unwrap();
}
