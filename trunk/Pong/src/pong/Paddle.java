/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.Graphics;

/**
 *
 * @author matt
 */
public class Paddle {

    private int xPos, yPos;
    private int xVel, yVel;
    private int length, width;

    Paddle() {
        xPos = 0;
        yPos = 0;
        xVel = 0;
        yVel = 0;
        length = 50;
        width = 10;
    }

    Paddle(int xPos, int yPos, int xVel, int yVel, int length) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.xVel = xVel;
        this.yVel = yVel;
        this.length = length;
        this.width = 10;
    }

    public void draw(Graphics g) {
        g.fillRect(xPos, yPos, width, length);
    }

    public void update(int width, int height, pongBall ball) {
        checkCollisions(ball, width, false);
        if (xPos <= 0 || xPos >= width - this.width) //The window width minus the paddle width
        {
            if (xPos <= 0 && xVel < 0) {
                xVel = 0;
            }
            if (xPos >= width - this.width && xVel > 0) {
                xVel = 0;
            }
        }
        if (yPos <= 0 || yPos >= height - this.length) //The window height minus the length of the paddle
        {
            if (yPos <= 0 && yVel < 0) {
                yVel = 0;
            }
            if (yPos >= height - this.length && yVel > 0) {
                yVel = 0;
            }
        }
        xPos += xVel;
        yPos += yVel;
    }

    public void computerUpdate(pongBall ball, int width, int height) {
        checkCollisions(ball, width, true);
        //Set velocities
        if (ball.getyPos() - (this.length / 2) > yPos) {
            yVel = 1;
        }
        if (ball.getyPos() - (this.length / 2) < yPos) {
            yVel = -1;
        }
        if (ball.getyPos() - (this.length / 2) == yPos) {
            yVel = 0;
        }
        //Check collisions with wall
        if (yPos >= height - this.length && yVel > 0) {
            yVel = 0;
        }
        if (yPos <= 0 && yVel < 0) {
            yVel = 0;
        }
        xPos += xVel;
        yPos += yVel;
        //yPos = (int)ball.getyPos() - (length/2);
    }
    //Check collisions with ball

    public void checkCollisions(pongBall ball, int width, boolean computer) {
        if (ball.getyPos() >= yPos && ball.getyPos() <= yPos + this.getLength()) {
            if (computer) {
                if (ball.getxPos() >= this.xPos) {
                    ball.setxVel(-(ball.getxVel()+Math.random()));
                    ball.setyVel(-(ball.getyVel()+Math.random()));
                }
            } else {
                if (ball.getxPos() <= this.xPos + 10) {
                    ball.setxVel(-(ball.getxVel()));
                    ball.setyVel(-(ball.getyVel()));
                }
            }
        }
    }

    /**
     * @return the xPos
     */
    public int getxPos() {
        return xPos;
    }

    /**
     * @param xPos the xPos to set
     */
    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    /**
     * @return the yPos
     */
    public int getyPos() {
        return yPos;
    }

    /**
     * @param yPos the yPos to set
     */
    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    /**
     * @return the xVel
     */
    public int getxVel() {
        return xVel;
    }

    /**
     * @param xVel the xVel to set
     */
    public void setxVel(int xVel) {
        this.xVel = xVel;
    }

    /**
     * @return the yVel
     */
    public int getyVel() {
        return yVel;
    }

    /**
     * @param yVel the yVel to set
     */
    public void setyVel(int yVel) {
        this.yVel = yVel;
    }

    /**
     * @return the length
     */
    public int getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }
}
