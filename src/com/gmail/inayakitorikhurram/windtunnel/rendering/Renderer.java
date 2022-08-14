package com.gmail.inayakitorikhurram.windtunnel.rendering;

import com.gmail.inayakitorikhurram.windtunnel.Settings;
import com.gmail.inayakitorikhurram.windtunnel.math.MyMath;
import com.gmail.inayakitorikhurram.windtunnel.math.fields.RealNumber;
import com.gmail.inayakitorikhurram.windtunnel.math.fields.Vector2f;
import com.gmail.inayakitorikhurram.windtunnel.math.fields.Vector2i;
import com.gmail.inayakitorikhurram.windtunnel.math.fields.VectorSpace;

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
    int count = 0;
    public Renderer() {
        super();
        settings = Settings.getInstance();
        pixels = settings.getPixels();
        setSize(pixels.uget(0), pixels.uget(1));



        setIgnoreRepaint(true);
        JFrame frame = new JFrame("Wind Tunnel");
        frame.setUndecorated(false);
        frame.setSize(pixels.uget(0), pixels.uget(1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setIgnoreRepaint(true);
        frame.add(this);
        frame.pack();
        frame.setVisible(true);

        //BufferStrategy

        createBufferStrategy(3);
        bs = getBufferStrategy();
/**
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
                                      @Override
                                      public void run() {
                                          settings.simulator.tick();
                                          render(bs.getDrawGraphics());
                                          System.out.println("frame " + count);
                                          count++;
                                      }
                                  }
                , 0, settings.msPerFrame);
**/
        while(true){
            settings.simulator.tick();
            render(bs.getDrawGraphics());
            System.out.println("frame " + count);
            count++;
        }
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

            BufferedImage img = new BufferedImage(pixels.uget(0), pixels.uget(1), BufferedImage.TYPE_INT_RGB);
            drawVectorSpace(img, settings.simulator.getFlow(), new RealNumber(-2), new RealNumber(2));

//            for(int i = 0; i < pixels.uget(0); i++){ for(int j = 0; j < pixels.uget(1); j++){
//                if(settings.airfoil.isInAeroFoil(new Vector2i(i,j))){
//                    img.setRGB(i, j, 0xFFFF00FF);
//                }
//            }}


            g2d.drawImage(img, 0, pixels.uget(1), pixels.uget(0), -pixels.uget(1), new Color(0.99f, 0f, 0f, 0.5f), null);
            //g2d.drawImage(img, 0, 0, pixels.uget(0), pixels.uget(1), new Color(0.99f, 0f, 0f, 0.5f), null);

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

    private void drawVectorSpace(BufferedImage img, VectorSpace<RealNumber, Vector2f> vs, RealNumber min, RealNumber max){
        for(int i = 0; i < pixels.uget(0); i++){ for(int j = 0; j < pixels.uget(1); j++){
            Vector2f val = vs.get(i, j);
            float x = MyMath.map(min.unwrap(), max.unwrap(), 0f, 1f, val.uget(0));
            float y = MyMath.map(min.unwrap(), max.unwrap(), 0f, 1f, val.uget(1));
            img.setRGB(i, j, new Color(MyMath.clamp(0, x, 1), MyMath.clamp(0, y, 1), 0.5f).getRGB());
        }}
    }

}
