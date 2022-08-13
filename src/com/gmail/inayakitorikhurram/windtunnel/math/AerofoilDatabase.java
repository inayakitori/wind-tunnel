package com.gmail.inayakitorikhurram.windtunnel.math;

import com.gmail.inayakitorikhurram.windtunnel.math.fields.Vector2f;

public class AerofoilDatabase {

public static final Aerofoil BOEING737 =
        new Aerofoil(
            new Curve(
                    new Vector2f[]{
                        new Vector2f(0.000000f, 0.008800f),
                        new Vector2f(0.002600f, 0.019800f),
                        new Vector2f(0.004700f, 0.023600f),
                        new Vector2f(0.007500f, 0.027500f),
                        new Vector2f(0.012900f, 0.033200f),
                        new Vector2f(0.022900f, 0.040800f),
                        new Vector2f(0.053000f, 0.055200f),
                        new Vector2f(0.073600f, 0.061300f),
                        new Vector2f(0.099600f, 0.066600f),
                        new Vector2f(0.151300f, 0.072800f),
                        new Vector2f(0.208000f, 0.075600f),
                        new Vector2f(0.250000f, 0.076100f),
                        new Vector2f(0.297200f, 0.075600f),
                        new Vector2f(0.360200f, 0.073400f),
                        new Vector2f(0.407500f, 0.070500f),
                        new Vector2f(0.454700f, 0.066700f),
                        new Vector2f(0.510100f, 0.061400f),
                        new Vector2f(0.552500f, 0.056700f),
                        new Vector2f(0.600100f, 0.051200f),
                        new Vector2f(0.700300f, 0.038800f),
                        new Vector2f(0.826600f, 0.023300f),
                        new Vector2f(0.902100f, 0.014200f),
                        new Vector2f(1.000000f, 0.000400f)}
            ),
        new Curve(
                new Vector2f[]{
                        new Vector2f(0.000000f,  0.008800f),
                        new Vector2f(0.002100f,  0.000400f),
                        new Vector2f(0.005100f, -0.003700f),
                        new Vector2f(0.007800f, -0.006200f),
                        new Vector2f(0.013900f, -0.010300f),
                        new Vector2f(0.023000f, -0.014700f),
                        new Vector2f(0.050900f, -0.024400f),
                        new Vector2f(0.072500f, -0.030100f),
                        new Vector2f(0.096100f, -0.035200f),
                        new Vector2f(0.151300f, -0.043200f),
                        new Vector2f(0.208000f, -0.047700f),
                        new Vector2f(0.250000f, -0.049300f),
                        new Vector2f(0.309500f, -0.050000f),
                        new Vector2f(0.344900f, -0.049800f),
                        new Vector2f(0.398100f, -0.048600f),
                        new Vector2f(0.451200f, -0.046300f),
                        new Vector2f(0.506600f, -0.042800f),
                        new Vector2f(0.549000f, -0.039700f),
                        new Vector2f(0.596600f, -0.035700f),
                        new Vector2f(0.688900f, -0.027500f),
                        new Vector2f(0.850500f, -0.013100f),
                        new Vector2f(0.931300f, -0.006000f),
                        new Vector2f(1.000000f, -0.000400f)
                }
                )
        );


}
