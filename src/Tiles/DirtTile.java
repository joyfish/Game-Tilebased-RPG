package Tiles;

import Main.Game;
import Graphics.ImageManager;

import java.awt.Graphics;

public class DirtTile extends Tile{

    int edge;

	public DirtTile(ImageManager im) {
		super(im);
	}

    public DirtTile(ImageManager imageManager, int edge){
        super(imageManager);
        this.edge = edge;
    }

    @Override
    public void render(Graphics g, int x, int y) {
        switch (edge){
            case 0:
                g.drawImage(imageManager.dirtTile0, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
                break;
            case 1:
                g.drawImage(imageManager.dirtTile1, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
                break;
            case 2:
                g.drawImage(imageManager.dirtTile2, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
                break;
            case 3:
                g.drawImage(imageManager.dirtTile3, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
                break;
            case 4:
                g.drawImage(imageManager.dirtTile4, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
                break;
            case 5:
                g.drawImage(imageManager.dirtTile5, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
                break;
            case 6:
                g.drawImage(imageManager.dirtTile6, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
                break;
            case 7:
                g.drawImage(imageManager.dirtTile7, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
                break;
            case 8:
                g.drawImage(imageManager.dirtTile8, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
                break;
            case 9:
                g.drawImage(imageManager.dirtTile9, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
                break;
            case 10:
                g.drawImage(imageManager.dirtTile10, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
                break;
            case 11:
                g.drawImage(imageManager.dirtTile11, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
                break;
            default:
                g.drawImage(imageManager.dirtTile0, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
                break;
        }
    }
	
}
