package com.gmail.inayakitorikhurram.windtunnel;

import com.gmail.inayakitorikhurram.windtunnel.math.*;
import com.gmail.inayakitorikhurram.windtunnel.rendering.Renderer;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Settings settings = Settings.getInstance();

        settings.resolution = 0.0025f;
        settings.bounds = new Rectf(1f, 1f, -1f, -1f);
        settings.backgroundColor = new Color(0.99f, 0.5f, 0.5f, 0.5f);
        settings.msPerFrame = 16;
        settings.msPerTick = 16;

        settings.aerofoil = AerofoilDatabase.BOEING737;

        //settings.simulator = new Simulator();
        settings.renderer = new Renderer();


    }
}