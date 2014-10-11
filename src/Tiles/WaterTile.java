package Tiles;

import Graphics.ImageManager;
import Main.Game;

import java.awt.*;

public class WaterTile extends Tile {

    int edge;

    public WaterTile(ImageManager im) {
        super(im);
    }

    public WaterTile(ImageManager imageManager, int edge){
        super(imageManager);
        this.edge = edge;
    }
	
	public void render(Graphics g, int x, int y){
        switch (edge){
            case 0:
                g.drawImage(imageManager.waterTile0, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
                break;
            case 1:
                g.drawImage(imageManager.waterTile1, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
                break;
            case 2:
                g.drawImage(imageManager.waterTile2, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
                break;
            case 3:
                g.drawImage(imageManager.waterTile3, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
                break;
            case 4:
                g.drawImage(imageManager.waterTile4, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
                break;
            case 5:
                g.drawImage(imageManager.waterTile5, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
                break;
            case 6:
                g.drawImage(imageManager.waterTile6, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
                break;
            case 7:
                g.drawImage(imageManager.waterTile7, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
                break;
            case 8:
                g.drawImage(imageManager.waterTile8, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
                break;
            case 9:
                g.drawImage(imageManager.waterTile9, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
                break;
            case 10:
                g.drawImage(imageManager.waterTile10, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
                break;
            case 11:
                g.drawImage(imageManager.waterTile11, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
                break;
            case 12:
                g.drawImage(imageManager.waterTile12, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
                break;
            default:
                g.drawImage(imageManager.waterTile0, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
                break;
        }
	}
	
	public boolean isSolid(){
		return true;
	}

}
