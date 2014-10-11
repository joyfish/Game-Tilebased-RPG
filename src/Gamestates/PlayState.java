package Gamestates;

import Graphics.ImageLoader;
import Entities.Player;
import Levels.LevelHandler;
import Main.Game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 * Created by crashh on 9/30/14.
 */
public class PlayState extends State {

    Player player;
    private LevelHandler l1; //todo: test

    public PlayState(GameStateHandler gsm){
        super(gsm);
        init();
    }

    private void init() {
        player = new Player((Game.WIDTH*Game.SCALE/2)-Game.TILESIZE/2,(Game.HEIGHT*Game.SCALE/2)-Game.TILESIZE/2, gameStateManager.getImageManager());

        ImageLoader loader = new ImageLoader(); //todo: test
        BufferedImage l_image = loader.load("/level1.png"); //todo: test
        l1 = new LevelHandler(l_image); //todo: test
    }

    /* This is what needs to be updated each frame. */
    @Override
    public void tick() {
        player.tick();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Game.WIDTH*Game.SCALE, Game.HEIGHT*Game.SCALE);
        l1.render(g); //todo: test
        player.render(g);
    }

    @Override
    public void handleInput(KeyEvent e, boolean press) {
        if (press) {
            player.moving = true;
            if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
                player.forwards = true;
            }
            else if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
                player.backwards = true;
            }
            else if (e.getKeyCode() == KeyEvent.VK_A ||e.getKeyCode() == KeyEvent.VK_LEFT ){
                player.left = true;
            }
            else if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT){
                player.right = true;
            }
            else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                player.moving = false;
                gameStateManager.setState(0);
            }
        }
        else {
            if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
                player.forwards = false;
            }
            else if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
                player.backwards = false;
            }
            else if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
                player.left = false;
            }
            else if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
                player.right = false;
            }
        }
    }

    @Override
    public void handleMouseMovement(MouseEvent e) {
        player.setDestination(e.getX(), e.getY());
    }

    @Override
    public void handleMouseInput(MouseEvent e, boolean press) {

    }

    public Player getPlayer(){
        return player;
    }

    public LevelHandler getLevel(){
        return l1;
    }
}
