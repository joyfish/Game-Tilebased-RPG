package Gamestates;

import Levels.LevelHandler;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by crashh on 9/30/14.
 */
public abstract class State {

    GameStateHandler gameStateManager;

    public State(GameStateHandler gsm){
        this.gameStateManager = gsm;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract void handleInput(KeyEvent e, boolean press);
    public abstract void handleMouseMovement(MouseEvent e);
    public abstract void handleMouseInput(MouseEvent e, boolean press);

    public abstract LevelHandler getLevel();
}
