package Tiles;

import Main.Game;
import Graphics.ImageManager;

import java.awt.Graphics;
public class StoneTile extends Tile{

	public StoneTile(ImageManager im) {
		super(im);
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(imageManager.stoneTile, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
	}
	
}
