package Levels;

import Entities.Player;
import Gamestates.GameStateHandler;
import Main.Game;
import Tiles.Tile;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

/**
 * Created by crashh on 04-10-2014.
 */
public class LevelHandler {

    private int[][] tiles;
    private int w, h;

    public LevelHandler(BufferedImage levelImage){
        w = levelImage.getWidth();
        h = levelImage.getHeight();
        loadLevel(levelImage);
    }

    public void loadLevel(BufferedImage levelImage){
        //Sets our double-array to the size of the map:
        tiles = new int[levelImage.getWidth()][levelImage.getHeight()];

        //Sets int values on the double array to match the map colors:
        for(int y = 0;y < levelImage.getHeight();y++){
            for(int x = 0;x < levelImage.getWidth();x++){
                Color c = new Color(levelImage.getRGB(x, y));
                String h = String.format("%02x%02x%02x", c.getRed(), c.getGreen(), c.getBlue());

                switch (h){
                    case "00ff00": //GRASS
                        tiles[x][y] = 10;
                        break;
                    case "7aff7a": //GRASS2
                        tiles[x][y] = 11;
                        break;
                    case "500000": //DIRT
                        tiles[x][y] = 20;
                        break;
                    case "808080": //STONE
                        tiles[x][y] = 30;
                        break;
                    case "4a4a4a": //ROCK
                        tiles[x][y] = 40;
                        break;
                    case "005500": //TREE
                        tiles[x][y] = 50;
                        break;
                    case "780078": //WALL
                        tiles[x][y] = 60;
                        break;
                    case "35a7ff": //WATER
                        tiles[x][y] = 70;
                        break;
                    default:
                        tiles[x][y] = 10; //Defaults to grass
                        break;

                }
            }
        }
    }

    public void render(Graphics g){
        int xo = Player.getXo();
        int yo = Player.getYo();

        //Prevents rendering outside player  view:
        int x0 = Math.max(xo / (Game.TILESIZE * Game.SCALE), 0);
        int y0 = Math.max(yo / (Game.TILESIZE * Game.SCALE), 0);
        int x1 = Math.min((xo + Game.WIDTH * Game.SCALE) / (Game.TILESIZE * Game.SCALE) + 2, w);
        int y1 = Math.min((yo + Game.HEIGHT * Game.SCALE) / (Game.TILESIZE * Game.SCALE) + 2, h);

        //Loads in the tiles:
        for(int y = y0; y < y1; y++) {
            for (int x = x0; x < x1; x++) {
                getTile(x, y).render(g, x * Game.TILESIZE * Game.SCALE - xo, y * Game.TILESIZE * Game.SCALE - yo);
            }
        }
    }

    public Tile getTile(int x, int y){
        switch(tiles[x][y]){
            case 10: //GRASS
                return Tile.grass0;
            case 11: //GRASS2
                return Tile.grass1;
            case 20: //DIRT
                return dirtEdge(x, y);
            case 30: //STONE
                return Tile.stone;
            case 40: //ROCK
                return Tile.rock;
            case 50: //TREE
                return Tile.tree;
            case 60: //WALL
                return Tile.wall;
            case 70: //WATER
                return waterEdge(x, y);
            default:
                return Tile.grass1;
        }
    }

    /* Rotates given tile - UNUSED (but left for future use)*/
    private void rotateTile(Graphics g, Image tile, int degree, int x, int y){
        Graphics2D g2d = (Graphics2D)g;
        AffineTransform old = g2d.getTransform();
        g2d.rotate(Math.toRadians(degree));
        //Anything here will be rotated.
        g.drawImage(tile, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
        //End rotation.
        g2d.setTransform(old);
    }

    /* Sets the correct dirt tile */
    private Tile dirtEdge(int x, int y){
        //Grass present {RIGHT, LEFT, OVER}
        if (x>0 && y>0 && tiles[x + 1][y] != 20) {
            if (tiles[x - 1][y] != 20) {
                if (tiles[x][y - 1] != 20)
                    return Tile.dirt9;
            }
        }
        //Grass present {OVER, LEFT}
        if (x>0 && y>0 && tiles[x][y - 1] != 20) {
            if (tiles[x - 1][y] != 20)
                return Tile.dirt1;
        }
        //Grass present {OVER, RIGHT}
        if (y>0 && tiles[x][y - 1] != 20) {
            if (tiles[x + 1][y] != 20)
                return Tile.dirt2;
        }
        //Grass present {BELOW, LEFT}
        if (x>0 && tiles[x][y + 1] != 20) {
            if (tiles[x - 1][y] != 20)
                return Tile.dirt3;
        }
        //Grass present {BELOW, RIGHT}
        if (tiles[x][y + 1] != 20) {
            if (tiles[x + 1][y] != 20)
                return Tile.dirt8;
        }
        //Grass present {LEFT, RIGHT}
        if (x>0 && y>0 && tiles[x + 1][y] != 20) {
            if (tiles[x - 1][y] != 20)
                return Tile.dirt10;
        }
        //Grass present {BELOW, OVER}
        if (x>0 && y>0 && tiles[x][y + 1] != 20) {
            if (tiles[x][y - 1] != 20)
                return Tile.dirt11;
        }
        //Grass present LEFT
        if (x>0 && tiles[x-1][y] != 20)
            return Tile.dirt4;
        //Grass present BOTTOM
        if (tiles[x][y+1] != 20)
            return Tile.dirt5;
        //Grass present OVER
        if (y>0 && tiles[x][y-1] != 20)
            return Tile.dirt6;
        //Grass present RIGHT
        if (tiles[x+1][y] != 20)
            return Tile.dirt7;

        return Tile.dirt0;
    }

    /* Sets the correct water tile */
    private Tile waterEdge(int x, int y){
        //Grass present {LEFT-UP} water present, TOP, LEFT}
        if (x>0 && y>0 && tiles[x - 1][y - 1] != 70) {
            if (tiles[x - 1][y] == 70 && tiles[x][y - 1] == 70)
                return Tile.water5;
        }
        //Grass present {BELOW-LEFT}, water present {BELOW, LEFT}
        if (x>0 && y>0 && tiles[x - 1][y + 1] != 70) {
            if (tiles[x - 1][y] == 70 && tiles[x][y + 1] == 70)
                return Tile.water10;
        }
        //Grass present {ABOVE-RIGHT}, water present {ABOVE, RIGHT}
        if (x>0 && y>0 && tiles[x + 1][y - 1] != 70) {
            if (tiles[x + 1][y] == 70 && tiles[x][y - 1] == 70)
                return Tile.water11;
        }
        //Grass present {BELOW-RIGHT}, water present {BELOW, RIGHT}
        if (x>0 && y>0 && tiles[x + 1][y + 1] != 70) {
            if (tiles[x + 1][y] == 70 && tiles[x][y + 1] == 70)
                return Tile.water12;
        }
        //Grass present {OVER, LEFT}
        if (x>0 && y>0 && tiles[x][y - 1] != 70) {
            if (tiles[x - 1][y] != 70)
                return Tile.water9;
        }
        //Grass present {OVER, RIGHT}
        if (y>0 && tiles[x][y - 1] != 70) {
            if (tiles[x + 1][y] != 70)
                return Tile.water6;
        }
        //Grass present {BELOW, LEFT}
        if (x>0 && tiles[x][y + 1] != 70) {
            if (tiles[x - 1][y] != 70)
                return Tile.water8;
        }
        //Grass present {BELOW, LEFT}
        if (tiles[x][y + 1] != 70) {
            if (tiles[x + 1][y] != 70)
                return Tile.water7;
        }
        //Grass present {LEFT}
        if (x>0 && tiles[x-1][y] != 70)
            return Tile.water2;
        //Grass present {BELOW}
        if (tiles[x][y+1] != 70)
            return Tile.water1;
        //Grass present {ABOVE}
        if (y>0 && tiles[x][y-1] != 70)
            return Tile.water3;
        //Grass present {RIGHT}
        if (tiles[x+1][y] != 70)
            return Tile.water4;

        return Tile.water0;
    }

    public int getH() {
        return h;
    }

    public int getW() {
        return w;
    }
}
