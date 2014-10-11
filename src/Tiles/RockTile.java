package Tiles;

import Main.Game;
import Graphics.ImageManager;

import java.awt.Graphics;

public class RockTile extends Tile {

	public RockTile(ImageManager im) {
		super(im);
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(imageManager.rockTile, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
	}
	
	public boolean isSolid(){
		return true;
	}

}
