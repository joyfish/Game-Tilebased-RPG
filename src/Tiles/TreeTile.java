package Tiles;

import Main.Game;
import Graphics.ImageManager;

import java.awt.Graphics;
public class TreeTile extends Tile{

	public TreeTile(ImageManager im) {
		super(im);
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(imageManager.treeTile, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
	}
	
	public boolean isSolid(){
		return true;
	}
	
}
