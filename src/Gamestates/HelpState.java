package Gamestates;

import Levels.LevelHandler;
import Main.Game;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by crashh on 9/30/14.
 */
public class HelpState extends State {

    private String[] controls = {
            "Movement:",
            "UP:",
            "LEFT:",
            "RIGHT:",
            "DOWN:",
            "",
            "Other:",
            "BACK:"
    };

    private String[] controlsMap = {
            "",
            "{W, Up-arrow}",
            "{A, Left-arrow}",
            "{S, Down-arrow}",
            "{D, Right-arrow}",
            "",
            "",
            "{ESC}"
    };

    private Font titleFont;

    public HelpState(GameStateHandler gsm) {
        super(gsm);
        titleFont = new Font("Arial", Font.PLAIN, 24);
    }

    /**
     * Updates the background each frame.
     */
    @Override
    public void tick() {

    }

    /**
     * Draws the help info screen on top of the menu.
     * @param g
     */
    @Override
    public void render(Graphics g) {

        g.setColor(Color.WHITE);
        g.fillRect(Game.getWIDTH()/4, 300, Game.getWIDTH()/2, Game.getHEIGHT()-380);
        g.setColor(Color.BLACK);
        g.drawRect(Game.getWIDTH()/4, 300, Game.getWIDTH()/2, Game.getHEIGHT()-380);

        g.setFont(titleFont);
        for(int i=0; i < controls.length; i++){
            g.setColor(Color.BLACK);
            g.drawString(controls[i], (Game.getWIDTH()/3)+75, (Game.getHEIGHT()/2)+40 + i * 30);
        }
        for(int i=0; i < controlsMap.length; i++){
            g.setColor(Color.BLACK);
            g.drawString(controlsMap[i], (Game.getWIDTH()/3)+225, (Game.getHEIGHT()/2)+40 + i * 30);
        }
    }

    @Override
    public void handleInput(KeyEvent e, boolean press) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE && press){
            gameStateManager.setState(0);
        }

    }

    @Override
    public void handleMouseMovement(MouseEvent e) {

    }

    @Override
    public void handleMouseInput(MouseEvent e, boolean press) {
        if (press)
            gameStateManager.setState(0);
    }

    @Override
    public LevelHandler getLevel() {
        throw new NotImplementedException();
    }
}
