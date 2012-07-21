/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author matt
 */
public class pongBall {
    private double xPos, yPos, radius; //Basic properties
    private double xVel, yVel; //The velocity for the ball
    pongBall()
    {
        super();
        xPos = 0;
        yPos = 0;
        radius = 10;
        xVel = 1;
        yVel = 1;
    }
    pongBall(double xVel, double yVel, double xPos, double yPos, double radius)
    {
        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = radius;
        this.xVel = xVel;
        this.yVel = yVel;
    }
    
    public void update(int width, int height)
    {
        if(xPos >= width - 10 || xPos <= 0)
        {
            xVel = -(xVel);
        }
        if(yPos >= height - 10 || yPos <= 0)
        {
            yVel = -(yVel);
        }
        xPos += xVel;
        yPos += yVel;
    }
    
    public void draw(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.fillOval((int)xPos, (int)yPos, (int)radius, (int)radius);
    }
    /**
     * @return the xPos
     */
    public double getxPos() {
        return xPos;
    }

    /**
     * @param xPos the xPos to set
     */
    public void setxPos(double xPos) {
        this.xPos = xPos;
    }

    /**
     * @return the yPos
     */
    public double getyPos() {
        return yPos;
    }

    /**
     * @param yPos the yPos to set
     */
    public void setyPos(double yPos) {
        this.yPos = yPos;
    }

    /**
     * @return the radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * @param radius the radius to set
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * @return the xVel
     */
    public double getxVel() {
        return xVel;
    }

    /**
     * @param xVel the xVel to set
     */
    public void setxVel(double xVel) {
        this.xVel = xVel;
    }

    /**
     * @return the yVel
     */
    public double getyVel() {
        return yVel;
    }

    /**
     * @param yVel the yVel to set
     */
    public void setyVel(double yVel) {
        this.yVel = yVel;
    }
}
