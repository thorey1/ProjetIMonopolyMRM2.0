/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author boedam
 */
public class Pion extends JPanel {
    
    private Color color;
   // private int x;
    //private int y;
    
    public Pion(Color color){
        this.color = color;
     //   this.x = x;
       // this.y = y;
        setBackground(Color.white);
        setDoubleBuffered(true);  
    }
    
    @Override
    public void paintComponent(Graphics g){
        g.setColor(Color.black);
        g.drawOval(0,0,5,5);
        g.setColor(color);
        g.fillOval(0, 0, 5, 5);
        
    }
    
}
