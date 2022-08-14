package com.gmail.inayakitorikhurram.windtunnel;

import com.gmail.inayakitorikhurram.windtunnel.math.*;
import com.gmail.inayakitorikhurram.windtunnel.math.fields.RealNumber;
import com.gmail.inayakitorikhurram.windtunnel.math.fields.Vector2f;
import com.gmail.inayakitorikhurram.windtunnel.rendering.Renderer;
import com.gmail.inayakitorikhurram.windtunnel.simulating.Simulator;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Settings settings = Settings.getInstance();

        settings.resolution = 0.005f;
        settings.bounds = new Rectf(-1f, -1f, 1f, 1f);
        settings.backgroundColor = new Color(0.99f, 0.5f, 0.5f, 0.5f);
        settings.msPerFrame = 16;
        settings.msPerTick = 16;

        settings.airfoil = AerofoilDatabase.BOEING737;
        settings.initFlow = new Vector2f(1f, 0.0f); // m/s
        settings.initPressure = new RealNumber(100000f);

        settings.simulator = new Simulator();
        settings.renderer = new Renderer();


    }
}