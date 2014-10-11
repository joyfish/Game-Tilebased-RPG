package Gamestates.Intro;

import Main.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by crashh on 30-09-2014.
 */
public class Background {
    private BufferedImage image;

    private double x;
    private double y;
    private double dx;
    private double dy;

    private double moveScale;

    public Background(String s, double ms){
        try {
            moveScale = ms;
            image = ImageIO.read(getClass().getResourceAsStream(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setPosition(double x, double y){
        this.x = (x * moveScale) % Game.getWIDTH();
        this.y = (y * moveScale) % Game.getHEIGHT();
    }

    public void setVector(double dx, double dy){
        this.dx = dx;
        this.dy = dy;
    }

    public void tick(){
        x += dx * moveScale;
        y += dy * moveScale;
    }

    public void draw(Graphics g){
        g.drawImage(image, (int)x, (int)y, null);
    }

}
