package com.gmail.inayakitorikhurram.windtunnel;

import com.gmail.inayakitorikhurram.windtunnel.math.*;

public class Main {
    public static void main(String[] args) {
        Settings settings = Settings.getInstance();

        settings.resolution = 0.01f;
        settings.bounds = new Rectf(-1f, -1f, 2, 2);
    }
}