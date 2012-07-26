/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 *
 * @author matt
 */
public class GUIPanel extends JPanel implements KeyListener{
    private pongBall ball;
    private Paddle player; //The paddle moveable by the player
    private Paddle computer;
    private int height = 500;
    private int width = 700;
    GUIPanel()
    {
        super();
        ball = new pongBall(Math.random()*2, 0, width/2, height/2, 10);
        player = new Paddle(0, 200, 0, 0, 50);
        computer = new Paddle(width - 15, 200, 0, 0, 50);
        this.addKeyListener(this);
        this.setOpaque(false);
        this.setVisible(true);
    }
    
    @Override
    protected void paintComponent(Graphics g)
    {
        //Clearing the screen
        g.setColor(Color.black);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        /////////////////////////
        g.setColor(Color.white);
        g.drawString(ball.getLeftScore() + "", getWidth()/2 - 50, 20);
        g.drawString(ball.getRightScore() + "", getWidth()/2 + 50, 20);
        g.drawLine(getWidth()/2, 0, getWidth()/2, getHeight());
        g.drawOval(getWidth()/2 - 25, getHeight()/2 - 25, 50, 50);
        //update and drawing
        computer.computerUpdate(ball, width, height);
        computer.draw(g);
        player.update(width, height, ball);
        player.draw(g);
        ball.update(width, height); //Updates the x and y position; and collisions in future
        ball.draw(g); //Draws the ball at the new position
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if(ke.getKeyCode() == KeyEvent.VK_UP)
        {
            player.setyVel(-1);
        }
        if(ke.getKeyCode() == KeyEvent.VK_DOWN)
        {
            player.setyVel(1);
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        player.setyVel(0);
    }
    
    public void setValues(int width, int height)
    {
        this.width = width;
        this.height = height;
    }
}