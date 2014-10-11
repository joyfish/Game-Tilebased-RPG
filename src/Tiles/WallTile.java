package Tiles;

import Main.Game;
import Graphics.ImageManager;

import java.awt.Graphics;
public class WallTile extends Tile{

	public WallTile(ImageManager im) {
		super(im);
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(imageManager.wallTile, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
	}
	
	public boolean isSolid(){
		return true;
	}
	
}
