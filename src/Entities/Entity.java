package Entities;

import java.awt.*;

public abstract class Entity {

    // Dimensions
    int width;
    int height;
    int scale;

    // Position
    double x;
    double y;
    double xdest;
    double ydest;
    double angle;

    // Movement
    public boolean moving;
    public boolean forwards;
    public boolean backwards;
    public boolean left;
    public boolean right;
    public int previous;

    // Attributes
    double moveSpeed;


    Entity() {

    }

    public void setPosition(int xpos, int ypos) {
        x = x+xpos-xpos;
        y = y+ypos-ypos;
    }

    public void setDestination(double xpos, double ypos){
        xdest = xpos;
        ydest = ypos;
    }

    void move(){
        // Get the vector between the player and the target
        int pathX = (int)(xdest - x);
        int pathY = (int)(ydest - y);

        // Calculate the unit vector of the path
        double distance = Math.sqrt(pathX * pathX + pathY * pathY);
        double directionX = pathX / distance;
        double directionY = pathY / distance;

        if (distance > 0) {

            // Calculate the actual walk amount
            double movementX = directionX * moveSpeed;
            double movementY = directionY * moveSpeed;

            x += movementX;
            y += movementY;
        }
    }

    public void intersects(Entity o) {
    }

    void tick() {
    }

    // Draws the entity.
    void render(Graphics2D g) {
        g.setColor(Color.GRAY);
        //debugLine(g);
    }

    private void debugLine(Graphics2D g){
        g.drawLine((int)this.x+15, (int)this.y+15, (int)xdest, (int)ydest);
    }

    public double getx() {
        return x;
    }
    public double gety() {
        return y;
    }
}
