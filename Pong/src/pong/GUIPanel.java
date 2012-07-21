/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author matt
 */
public class GUIPanel extends JPanel{
    private pongBall ball;
    private int height = 500;
    private int width = 500;
    GUIPanel()
    {
        super();
        ball = new pongBall(2, 1, 10, 10, 10);
        this.setOpaque(false);
        this.setVisible(true);
    }
    
    @Override
    protected void paintComponent(Graphics g)
    {
        g.setColor(Color.black);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        ball.draw(g); //Draws the ball at the new position
        ball.update(width, height); //Updates the x and y position
    }
}
