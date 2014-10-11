package Gamestates.Intro;

import Gamestates.GameStateHandler;
import Gamestates.State;
import Levels.LevelHandler;
import Main.Game;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by crashh on 9/30/14.
 */
public class IntroState extends State {

    private Background background;
    private GameStateHandler gsm;

    private int currentChoice = 0;
    private int nrOfOptions;
    private String[] options = {
            "Start",
            "Settings",
            "Help",
            "Quit"
    };

    private Color titleColor;
    private Font titleFont, headerFont;

    public IntroState(GameStateHandler gsm) {
        super(gsm);
        this.gsm = gsm;
        nrOfOptions = options.length;

        try {
            background = new Background("/Intro/background.gif", 2);
            background.setVector(-0.1, 0);

            titleColor = new Color(136, 2, 0);
            titleFont = new Font("Blackadder ITC", Font.PLAIN, 28);
            headerFont = new Font("Blackadder ITC", Font.BOLD, 74);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Draws the background.
     */
    @Override
    public void tick() {
        background.tick();
    }

    /**
     * Draws the intro state to the canvas.
     * @param g the canvas.
     */
    @Override
    public void render(Graphics g) {
        background.draw(g);

        g.setColor(titleColor);
        g.setFont(headerFont);
        g.drawString("Generic Game", (Game.getWIDTH()/2)-200, 70);

        g.setColor(Color.WHITE);
        g.fillRect(((Game.WIDTH*Game.SCALE)/2-30), (Game.HEIGHT*Game.SCALE)/2+10, 100, 200);
        g.setColor(Color.BLACK);
        g.drawRect(((Game.WIDTH*Game.SCALE)/2-30), (Game.HEIGHT*Game.SCALE)/2+10, 100, 200);
        g.setFont(new Font("Arial", Font.PLAIN, 18));
        g.drawString("Alpha 0.01", 10, (Game.HEIGHT*Game.SCALE)-60);
        g.drawString("Created by Crashh", 10, (Game.HEIGHT*Game.SCALE)-40);

        g.setFont(titleFont);
        g.setColor(titleColor);
        for(int i=0; i < options.length; i++){
            if (i == currentChoice){
                g.setColor(Color.BLACK);
            }else{
                g.setColor(Color.RED);
            }
            g.drawString(options[i], (Game.WIDTH/2)-20, (Game.HEIGHT/2)+60 + i * 30);
        }
    }

    public void handleInput(KeyEvent e, boolean press) {
        if (((e.getKeyCode() == KeyEvent.VK_DOWN) || (e.getKeyCode() == KeyEvent.VK_S)) && press){
            if(currentChoice < nrOfOptions - 1)
                currentChoice++;
        }
        if ((e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) && press){
            if(currentChoice > 0)
                currentChoice--;
        }
        if ((e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_SPACE) && press){
            pickMenuOption();
        }
    }

    public void handleMouseMovement(MouseEvent e) {
        //Hardcoded coordinates:
        System.out.println("x: " + e.getX() + "   y: " + e.getY());

        //Start entry:
        if((e.getX() > 660 && e.getX() < 750) && (e.getY() > 425 &&  e.getY() < 450)){
            currentChoice = 0;
        }

        //Settings entry:
        if((e.getX() > 660 && e.getX() < 750) && (e.getY() > 450 &&  e.getY() < 475)){
            currentChoice = 1;
        }

        //Help entry:
        if((e.getX() > 660 && e.getX() < 750) && (e.getY() > 475 &&  e.getY() < 500)){
            currentChoice = 2;
        }

        //Exit entry:
        if((e.getX() > 660 && e.getX() < 750) && (e.getY() > 500 &&  e.getY() < 525)){
            currentChoice = 3;
        }
    }

    public void handleMouseInput(MouseEvent e, boolean press) {
        //Hardcoded coordinates:
        //System.out.println("x: " + e.getX() + "   y: " + e.getY());

        //Start entry:
        if((e.getX() > 660 && e.getX() < 750) && (e.getY() > 425 &&  e.getY() < 450)){
            options[0] = "Resume";
            gsm.setState(1);
        }

        //Settings entry:
        if((e.getX() > 660 && e.getX() < 750) && (e.getY() > 450 &&  e.getY() < 475)){
            gsm.setState(2);
        }

        //Help entry:
        if((e.getX() > 660 && e.getX() < 750) && (e.getY() > 475 &&  e.getY() < 500)){
            gsm.setState(2);
        }

        //Exit entry:
        if((e.getX() > 660 && e.getX() < 750) && (e.getY() > 500 &&  e.getY() < 525)){
            System.exit(0);
        }
    }

    @Override
    public LevelHandler getLevel() {
        throw new NotImplementedException();
    }

    /**
     * Makes something happen when a menu item is chosen.
     */
    private void pickMenuOption() {
        if (currentChoice == 0){ //Play
            options[0] = "Resume";
            gsm.setState(1);
        }
        if (currentChoice == 2){ //Help
            gsm.setState(2);
        }
        if (currentChoice == nrOfOptions-1){ //Exit
            System.exit(0);
        }
    }
}
