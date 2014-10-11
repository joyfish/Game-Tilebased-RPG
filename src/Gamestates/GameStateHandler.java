package Gamestates;

import Gamestates.Intro.IntroState;
import Graphics.ImageManager;
import Graphics.SpriteSheet;
import Main.Game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Created by crashh on 9/30/14.
 */
public class GameStateHandler {

    //Setup spritesheet and imagehandler here, but change it in levelHandler.
    private ImageManager imageManager;

    //Handles different game states:
    private ArrayList<State> states;
    private int currentState;

    public GameStateHandler(){

        SpriteSheet ss = new SpriteSheet("/spritesheet"+ Game.TILESIZE+".png");
        imageManager = new ImageManager(ss);;

        states = new ArrayList<State>();
        states.add(new IntroState(this));
        states.add(new PlayState(this));
        states.add(new HelpState(this));
    }

    /**
     * Immediately sets current game state.
     * @param state
     */
    public void setState(int state){
        currentState = state;
        states.get(currentState);
    }

    /**
     * Returns current active game state.
     */
    public State getState(){
        return states.get(currentState);
    }
    public State getState(int state){
        return states.get(state);
    }

    /**
     * Handles all the logic calculations for current active state each frame.
     */
    public void tick(){
        states.get(currentState).tick();
    }

    /**
     * Draws everything from current active state to the canvas g.
     * @param g
     */
    public void render(Graphics g){
        states.get(currentState).render(g);
    }

    /**
     * Handles keyinout and sends it to current active state.
     * @param e the Keyevent.
     * @param press true if pressed, false else.
     */
    public void keyInput(KeyEvent e, boolean press){
        states.get(currentState).handleInput(e, press);
    }

    /**
     * Handle mouse movement, and sends it to current active state,
     * @param e the MouseEvent.
     */
    public void mouseMovement(MouseEvent e){
        states.get(currentState).handleMouseMovement(e);
    }

    /**
     * Handle mouse clicks, and sends it to current active state.
     * @param e
     * @param press
     */
    public void mouseInput(MouseEvent e, boolean press){
        states.get(currentState).handleMouseInput(e, press);

    }

    public ImageManager getImageManager(){
        return imageManager;
    }

}
