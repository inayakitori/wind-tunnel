package com.gmail.inayakitorikhurram.windtunnel.math.fields;

public interface FieldFunction<OUT extends VectorSpaceElement<?, OUT>>{
    OUT f(Vector2i x);
}
