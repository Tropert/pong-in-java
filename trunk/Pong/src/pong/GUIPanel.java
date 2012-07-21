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
    GUIPanel()
    {
        super();
        ball = new pongBall(1, 1, 10, 10, 10);
    }
    
    @Override
    protected void paintComponent(Graphics g)
    {
        g.drawOval((int)ball.getxPos(), (int)ball.getyPos(), (int)ball.getRadius(), (int)ball.getRadius());
        ball.update(); //Updates the x and y position
    }
}
