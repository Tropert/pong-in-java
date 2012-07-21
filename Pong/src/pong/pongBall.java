/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

/**
 *
 * @author matt
 */
public class pongBall {
    private double xPos, yPos, radius;
    pongBall()
    {
        super();
        xPos = 0;
        yPos = 0;
        radius = 10;
    }
    pongBall(double xPos, double yPos, double radius)
    {
        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = radius;
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
}
