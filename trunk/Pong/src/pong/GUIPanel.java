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
    private int width = 500;
    GUIPanel()
    {
        super();
        ball = new pongBall(1.5, 1.5, 10, 10, 10);
        player = new Paddle(20, 250, 0, 0, 50);
        computer = new Paddle(this.width - 20, 250, 0, 0, 50);
        this.addKeyListener(this);
        this.setOpaque(false);
        this.setVisible(true);
    }
    
    @Override
    protected void paintComponent(Graphics g)
    {
        g.setColor(Color.black);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.red);
        computer.draw(g);
        computer.computerUpdate(ball);
        player.draw(g);
        player.update(getWidth(),getHeight());
        ball.draw(g); //Draws the ball at the new position
        ball.update(width, height); //Updates the x and y position; and collisions in future
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
}