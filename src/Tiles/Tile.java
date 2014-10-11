package Tiles;

import Graphics.ImageManager;
import Main.Game;
import java.awt.*;

/**
 * Created by crashh on 04-10-2014.
 */
public abstract class Tile {

    /* This class is a living nightmare, but it will have to do for now. */

    protected static ImageManager imageManager = Game.getGameStateHandler().getImageManager();

    //Grass
    public static Tile grass0 = new GrassTile(imageManager, 0);
    public static Tile grass1 = new GrassTile(imageManager, 1);

    //Dirt:
    public static Tile dirt0 = new DirtTile(imageManager, 0);
    public static Tile dirt1 = new DirtTile(imageManager, 1);
    public static Tile dirt2 = new DirtTile(imageManager, 2);
    public static Tile dirt3 = new DirtTile(imageManager, 3);
    public static Tile dirt4 = new DirtTile(imageManager, 4);
    public static Tile dirt5 = new DirtTile(imageManager, 5);
    public static Tile dirt6 = new DirtTile(imageManager, 6);
    public static Tile dirt7 = new DirtTile(imageManager, 7);
    public static Tile dirt8 = new DirtTile(imageManager, 8);
    public static Tile dirt9 = new DirtTile(imageManager, 9);
    public static Tile dirt10 = new DirtTile(imageManager, 10);
    public static Tile dirt11 = new DirtTile(imageManager, 11);

    public static Tile rock = new RockTile(imageManager);
    public static Tile stone = new StoneTile(imageManager);
    public static Tile tree = new TreeTile(imageManager);
    public static Tile wall = new WallTile(imageManager);

    public static Tile water0 = new WaterTile(imageManager, 0);
    public static Tile water1 = new WaterTile(imageManager, 1);
    public static Tile water2 = new WaterTile(imageManager, 2);
    public static Tile water3 = new WaterTile(imageManager, 3);
    public static Tile water4 = new WaterTile(imageManager, 4);
    public static Tile water5 = new WaterTile(imageManager, 5);
    public static Tile water6 = new WaterTile(imageManager, 6);
    public static Tile water7 = new WaterTile(imageManager, 7);
    public static Tile water8 = new WaterTile(imageManager, 8);
    public static Tile water9 = new WaterTile(imageManager, 9);
    public static Tile water10 = new WaterTile(imageManager, 10);
    public static Tile water11 = new WaterTile(imageManager, 11);
    public static Tile water12 = new WaterTile(imageManager, 12);


    public Tile(ImageManager imageManager){
        this.imageManager = imageManager;
    }

    public abstract void render(Graphics g, int x, int y);

    public boolean isSolid(){
        return false;
    }
}
