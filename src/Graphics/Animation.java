package Graphics;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by crashh on 04-10-2014.
 */
public class Animation {

    private BufferedImage[] images;
    private int interval, index;
    private long timer, now, prevTimer;

    public Animation(BufferedImage[] images, int interval){
        this.images = images;
        this.interval = interval;

        index = 0;
        timer = 0;
        now = 0;
        prevTimer = 0;
    }

    public void tick(){
        now = System.currentTimeMillis();
        timer += now-prevTimer;
        prevTimer = now;

        //Iff enough time has passed, swap image:
        if (timer >= interval){
            index++;
            timer = 0;

            //Making it loop between images:
            if (index >= 2){
                index = 0;
            }
        }
    }

    public void render(Graphics g, int x, int y, int width, int height){
        g.drawImage(images[index], x, y, width, height, null);
    }
}
