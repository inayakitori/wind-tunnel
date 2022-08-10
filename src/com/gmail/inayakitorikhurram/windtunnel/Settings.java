package com.gmail.inayakitorikhurram.windtunnel;

import com.gmail.inayakitorikhurram.windtunnel.math.*;

public class Settings {

    private static Settings settings;

    public float resolution;
    public Rectf bounds;

    private Settings(){
    }

    public static Settings getInstance(){
        if(settings == null){
            settings = new Settings();
        }
        return settings;
    }

}
