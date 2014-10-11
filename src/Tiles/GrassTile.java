package Tiles;

import Graphics.ImageManager;
import Main.Game;

import java.awt.*;

/**
 * Created by crashh on 04-10-2014.
 */
public class GrassTile extends Tile {

    int edge;

    public GrassTile(ImageManager imageManager) {
        super(imageManager);
    }

    public GrassTile(ImageManager imageManager, int edge){
        super(imageManager);
        this.edge = edge;
    }

    @Override
    public void render(Graphics g, int x, int y) {
        switch (edge){
            case 0:
                g.drawImage(imageManager.grassTile0, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
                break;
            case 1:
                g.drawImage(imageManager.grassTile1, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
                break;
            default:
                g.drawImage(imageManager.grassTile0, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
                break;
        }
    }
}
