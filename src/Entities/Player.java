package Entities;

import Graphics.ImageManager;
import Graphics.Animation;
import Main.Game;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Created by crashh on 04-10-2014.
 */
public class Player extends Entity {

    private int x;
    private int y;
    private static int xo;
    private static int yo;
    private int xs;
    private int ys;
    private ImageManager imageManager;

    private Animation upAnimation, downAnimation, leftAnimation, rightAnimation;

    /**
     * Constructor sets all initial player stats. and loads in the
     * sprites.
     */
    public Player(int x, int y, ImageManager imageManager){
        this.x = x;
        this.y = y;
        this.xo = 0;
        this.yo = 0;
        this.xs = 0;
        this.ys = 0;
        this.imageManager = imageManager;

        moveSpeed = 3*Game.SCALE;
        previous = 3;

        width=(imageManager.playerF[0].getWidth()*Game.SCALE)-10;
        height=(imageManager.playerF[0].getHeight()*Game.SCALE)-3;

        int animationFreq = 300;
        upAnimation = new Animation(imageManager.playerF, animationFreq);
        downAnimation = new Animation(imageManager.playerB, animationFreq);
        leftAnimation = new Animation(imageManager.playerL, animationFreq);
        rightAnimation = new Animation(imageManager.playerR, animationFreq);
    }

    /**
     * Handles all the logic calculations each frame related to the Player..
     */
    public void tick() {
        if (!forwards && !backwards && !left && !right)
            moving = false;

        xs = 0;
        ys = 0;

        if (moving){
            if (forwards) {
                previous = 1;
                ys -= moveSpeed;
                upAnimation.tick();
            }
            else if (backwards){
                previous = 3;
                ys += moveSpeed;
                downAnimation.tick();
            }
            if (left){
                previous = 2;
                xs -= moveSpeed;
                leftAnimation.tick();
            }
            if (right){
                previous = 4;
                xs += moveSpeed;
                rightAnimation.tick();
            }
            move(xs, ys);
        }
    }

    /**
     * Used by render to render the player sprite itself.
     */
    private void drawPlayer(Graphics g) {
        if (forwards)
            upAnimation.render(g, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE);
        else if (backwards)
            downAnimation.render(g, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE);
        else if (left)
            leftAnimation.render(g, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE);
        else if (right)
            rightAnimation.render(g, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE);
        else if (previous == 1)
            g.drawImage(imageManager.playerF[0], x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
        else if (previous == 3)
            g.drawImage(imageManager.playerB[0], x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
        else if (previous == 2)
            g.drawImage(imageManager.playerL[0], x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
        else if (previous == 4)
            g.drawImage(imageManager.playerR[0], x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);

    }

    /**
     * Draws anything player related to screen.
     */
    public void render(Graphics g) {
        //Draw player last so it overlap rest.
        drawPlayer(g);
    }

    public void move(int xs, int ys){
        if (!collisionDetection(xs, 0) && !collisionDetection(xs+width, 0) && !collisionDetection(xs, 0+height) && !collisionDetection(xs+width, 0+height)){
            xo += xs;
        }
        if (!collisionDetection(0, ys) && !collisionDetection(0+width, ys) && !collisionDetection(0, ys+height) && !collisionDetection(0+width, ys+height)){
            yo += ys;
        }

    }

    private boolean collisionDetection(int xs, int ys){
        if((Game.getGameStateHandler().getState()).getLevel().getTile((xo + xs + x) / (Game.TILESIZE * Game.SCALE), (yo + ys + y) / (Game.TILESIZE * Game.SCALE)).isSolid()){
            return true;
        }
        return false;
    }

    public static int getXo(){
        return xo;
    }

    public static int getYo(){
        return yo;
    }
}