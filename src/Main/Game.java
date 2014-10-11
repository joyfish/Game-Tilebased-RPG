package Main;

import Gamestates.GameStateHandler;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by crashh on 03-10-2014.
 */

public class Game extends Canvas implements Runnable {

    public static final int SCALE = 1; //3 //2 //1
    public static final int WIDTH = 1366/SCALE;
    public static final int HEIGHT = 768/SCALE;
    public static final int TILESIZE = 64; //16 //32 //64
    private static Dimension dim;

    public static boolean running;

    public Thread gameThread;
    static GameStateHandler gsm;

    public void init() {
        gsm = new GameStateHandler();

        InputHandler controls = new InputHandler(gsm);
        addKeyListener(controls);
        addMouseMotionListener(controls);
        addMouseListener(controls);
    }

    public synchronized void start() {
        if (!running) {
            Thread thread = new Thread(this);
            thread.start();
            running = true;
            requestFocus();
        }
    }

    public synchronized void stop() {
        running = false;
    }

    public void run() {
        init();

        //Used to limit FPS:
        double FPS = 60.0;
        double nsPrTick = 1000000000.0 / FPS;
        double nsPassed = 0;

        boolean shouldRender;


        int ticks = 0;
        int frames = 0;

        long start;
        long prevStart = System.currentTimeMillis();
        long lastTime = System.nanoTime();

        init();

        while (running) {
            start = System.nanoTime();
            nsPassed += (start - lastTime) / nsPrTick;
            lastTime = start;

            //set to true for performance test:
            shouldRender = true;

            while (nsPassed >= 1){
                ticks++;
                tick();
                nsPassed -= 1;
                shouldRender = true;
            }

            //Temp:
            try{
                Thread.sleep(2);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            if (shouldRender) {
                frames++;
                //Draw canvas to screen.
                render();
            }

            if (System.currentTimeMillis() - prevStart >= 1000){
                prevStart += 1000;
                System.out.println(ticks + ",  " + frames);
                frames = 0;
                ticks = 0;
            }
        }

        this.stop();
    }

    public void tick() {
        gsm.tick();
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(2);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        //RENDER HERE
        gsm.render(g);

        //END RENDER
        g.dispose();
        bs.show();
    }

    public static void main(String[] args) {
        Game game = new Game();
        dim = new Dimension(WIDTH*SCALE, HEIGHT*SCALE);
        game.setPreferredSize(dim);
        game.setMinimumSize(dim);
        game.setMaximumSize(dim);

        JFrame frame = new JFrame("Tile RPG");
        frame.setSize(WIDTH * SCALE, HEIGHT * SCALE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(game);
        frame.setVisible(true);
        frame.setFocusable(true);

        game.start();
    }

    //Setters and

    public static GameStateHandler getGameStateHandler(){
        return gsm;   }

    public static int getWIDTH() {
        return WIDTH * SCALE;
    }

    public static int getHEIGHT() {
        return HEIGHT * SCALE;
    }
}

