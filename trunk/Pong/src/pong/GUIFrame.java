/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author matt
 */
public class GUIFrame extends JFrame{
    GUIFrame()
    {
        super();
        this.setTitle("Pong");
        this.setSize(700,500);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        GUIPanel p = new GUIPanel();
        this.add(p, BorderLayout.CENTER);
        this.setVisible(true);
        p.setValues(p.getWidth(), p.getHeight());
        while(true)
        {
            pause(10); //Give the processor some time- also FPS
            p.repaint();
            p.requestFocus(); //Request focus for the KeyListener
        }
    }
    public void pause(long time)
    {
        try{
            Thread.sleep(time);
        }catch(Exception e){
            System.out.println("Error with pause: " + e);
        }
    }
}
