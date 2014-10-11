package Graphics;

import Main.Game;

import java.awt.image.BufferedImage;

/**
 * Created by crashh on 03-10-2014.
 */
public class SpriteSheet {

    private BufferedImage sheet;

    public SpriteSheet(String path){
        ImageLoader loader = new ImageLoader();
        sheet = loader.load("/spritesheet"+ Game.TILESIZE+".png");
    }

    public BufferedImage crop(int col, int row, int w, int h){
        return sheet.getSubimage(col * Game.TILESIZE, row * Game.TILESIZE, w, h);
    }
}
