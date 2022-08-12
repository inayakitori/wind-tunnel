package com.gmail.inayakitorikhurram.windtunnel.rendering;

import com.gmail.inayakitorikhurram.windtunnel.Settings;
import com.gmail.inayakitorikhurram.windtunnel.math.Aerofoil;
import com.gmail.inayakitorikhurram.windtunnel.math.Vector2i;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;


//Half of this code is from one of my other project: https://github.com/inayakitori/boids
public class Renderer extends Canvas {
    private Settings settings;
    private JFrame frame;
    Vector2i pixels;
    private BufferStrategy bs;
    Graphics g = null;
    public Renderer() {
        super();
        settings = Settings.getInstance();
        pixels = settings.getPixels();
        setSize(pixels.x, pixels.y);



        setIgnoreRepaint(true);
        JFrame frame = new JFrame("Wind Tunnel");
        frame.setUndecorated(false);
        frame.setSize(pixels.x, pixels.y);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setIgnoreRepaint(true);
        frame.add(this);
        frame.pack();
        frame.setVisible(true);

        //BufferStrategy

        createBufferStrategy(3);
        bs = getBufferStrategy();

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
                                      @Override
                                      public void run() {
                                          render(bs.getDrawGraphics());
                                      }
                                  }
                , 0, settings.msPerFrame);

    }

    public void render(Graphics g){
        try {
            // clear back buffer...
            g = bs.getDrawGraphics();
            g.setColor( Color.BLACK );
            g.fillRect( 0, 0, getWidth(), getHeight() );


            Graphics2D g2d = (Graphics2D) g;

            g2d.setBackground(settings.backgroundColor);
            g2d.clearRect(0, 0, getWidth(), getHeight());

            BufferedImage img = new BufferedImage(pixels.x, pixels.y, BufferedImage.TYPE_INT_RGB);

            for(int i = 0; i < pixels.x; i++){ for(int j = 0; j < pixels.y; j++){
                if(settings.aerofoil.isInAeroFoil(new Vector2i(i,j))){
                    img.setRGB(i, j, 0xFFFF00FF);
                } else{
                    img.setRGB(i, j, 0xFF00FF00);
                }
            }}

            g2d.drawImage(img, 0, 0, new Color(0.99f, 0f, 0f, 0.5f), null);

            // blit the back buffer to the screen
            if(!bs.contentsLost()) {
                bs.show();
            }

            // Let the OS have a little time...
            Thread.yield();
        } finally {
            if( g != null )
                g.dispose();
        }
    }

}
