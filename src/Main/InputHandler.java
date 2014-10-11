package Main;

import Gamestates.GameStateHandler;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by crashh on 04-10-2014.
 */
public class InputHandler implements KeyListener, MouseListener, MouseMotionListener {

    private GameStateHandler gsm;

    /**
     * The constructor, gets the GameStateManager så key presses can be sent to the
     * active game state.
     *
     * @param gsm the GameStateManager which keeps track of states
     */
    public InputHandler(GameStateHandler gsm) {
        this.gsm = gsm;
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        gsm.keyInput(e, true);
    }

    public void keyReleased(KeyEvent e) {
        gsm.keyInput(e, false);
    }

    public void mouseDragged(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {
        gsm.mouseMovement(e);
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        gsm.mouseInput(e, true);
    }

    public void mouseReleased(MouseEvent e) {
        gsm.mouseInput(e, false);
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}
