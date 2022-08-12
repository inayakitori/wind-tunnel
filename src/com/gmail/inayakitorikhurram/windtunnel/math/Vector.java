package com.gmail.inayakitorikhurram.windtunnel.math;

public interface Vector<E, V extends Vector> {
    V add(E element);
    V add(V other);
    V sub(E element);
    V sub(V other);
    V div(E element);
    V eDiv(V other);
    V mul(E element);
    V eMul(V other);
    E dot(V other);
    V clone();
    E get(int i);
}
