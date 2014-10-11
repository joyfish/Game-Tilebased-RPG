package Graphics;

import Main.Game;

import java.awt.image.BufferedImage;

/**
 * Created by crashh on 04-10-2014.
 */
public class ImageManager {

    public BufferedImage grassTile0, grassTile1;
    public BufferedImage dirtTile0, dirtTile1, dirtTile2, dirtTile3, dirtTile4, dirtTile5, dirtTile6, dirtTile7, dirtTile8, dirtTile9, dirtTile10, dirtTile11;
    public BufferedImage waterTile0, waterTile1, waterTile2, waterTile3, waterTile4, waterTile5, waterTile6, waterTile7, waterTile8, waterTile9, waterTile10, waterTile11, waterTile12;
    public BufferedImage stoneTile, treeTile, rockTile, wallTile;
    public BufferedImage[] playerF, playerB, playerL, playerR;
    
    int TILESIZE = Game.TILESIZE;

    public ImageManager(SpriteSheet ss){
        playerF = new BufferedImage[2];
        playerF[0] = ss.crop(0,0,TILESIZE,TILESIZE);
        playerF[1] = ss.crop(0,4,TILESIZE,TILESIZE);
        playerB = new BufferedImage[2];
        playerB[0] = ss.crop(0,2,TILESIZE,TILESIZE);
        playerB[1] = ss.crop(0,6,TILESIZE,TILESIZE);
        playerL = new BufferedImage[2];
        playerL[0] = ss.crop(0,1,TILESIZE,TILESIZE);
        playerL[1] = ss.crop(0,5,TILESIZE,TILESIZE);
        playerR = new BufferedImage[2];
        playerR[0] = ss.crop(0,3,TILESIZE,TILESIZE);
        playerR[1] = ss.crop(0,7,TILESIZE,TILESIZE);


        //Grass:
        grassTile0 = ss.crop(1, 0, TILESIZE, TILESIZE);
        grassTile1 = ss.crop(1, 1, TILESIZE, TILESIZE);

        //Stone
        stoneTile = ss.crop(2, 0, TILESIZE, TILESIZE);
        treeTile = ss.crop(3, 0, TILESIZE, TILESIZE);
        rockTile = ss.crop(4, 0, TILESIZE, TILESIZE);

        //Dirt:
        dirtTile0 = ss.crop(5, 0, TILESIZE, TILESIZE);
        dirtTile1 = ss.crop(5, 1, TILESIZE, TILESIZE);
        dirtTile2 = ss.crop(5, 2, TILESIZE, TILESIZE);
        dirtTile3 = ss.crop(5, 3, TILESIZE, TILESIZE);
        dirtTile4 = ss.crop(5, 4, TILESIZE, TILESIZE);
        dirtTile5 = ss.crop(5, 5, TILESIZE, TILESIZE);
        dirtTile6 = ss.crop(5, 6, TILESIZE, TILESIZE);
        dirtTile7 = ss.crop(5, 7, TILESIZE, TILESIZE);
        dirtTile8 = ss.crop(5, 8, TILESIZE, TILESIZE);
        dirtTile9 = ss.crop(5, 9, TILESIZE, TILESIZE);
        dirtTile10 = ss.crop(6, 0, TILESIZE, TILESIZE);
        dirtTile11 = ss.crop(6, 1, TILESIZE, TILESIZE);

        wallTile = ss.crop(8, 0, TILESIZE, TILESIZE);

        waterTile0 = ss.crop(9, 0, TILESIZE, TILESIZE);
        waterTile1 = ss.crop(9, 1, TILESIZE, TILESIZE);
        waterTile2 = ss.crop(9, 2, TILESIZE, TILESIZE);
        waterTile3 = ss.crop(9, 3, TILESIZE, TILESIZE);
        waterTile4 = ss.crop(9, 4, TILESIZE, TILESIZE);
        waterTile5 = ss.crop(9, 5, TILESIZE, TILESIZE);
        waterTile6 = ss.crop(9, 6, TILESIZE, TILESIZE);
        waterTile7 = ss.crop(9, 7, TILESIZE, TILESIZE);
        waterTile8 = ss.crop(9, 8, TILESIZE, TILESIZE);
        waterTile9 = ss.crop(9, 9, TILESIZE, TILESIZE);
        waterTile10 = ss.crop(8, 9, TILESIZE, TILESIZE);
        waterTile11 = ss.crop(8, 8, TILESIZE, TILESIZE);
        waterTile12 = ss.crop(8, 7, TILESIZE, TILESIZE);
    }
}
