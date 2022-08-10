package com.gmail.inayakitorikhurram.windtunnel.math;

public interface Field<E,F extends Field> {
    F add(E element);
    F add(F other);
    F sub(E element);
    F sub(F other);
    F mul(E element);
    F mul(F other);
    E integrate(F mask);
    F clone();
}
