/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author boedam
 */
public class Pion extends JPanel {

    private Color color;
    private String couleur;

    public Pion(Color color) {
        this.color = color;
        //   this.x = x;
        // this.y = y;
        setBackground(Color.white);
        setDoubleBuffered(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.black);
        g.drawOval(0, 0, 10, 10);
        g.setColor(color);
        g.fillOval(0, 0, 10, 10);

    }

    public Color getColor() {
        return color;
    }

    public String getCouleur() {
        if (this.getColor() == Color.BLUE) {
            couleur = "Bleu";
        } else if (this.getColor() == Color.RED) {
            couleur = "Rouge";
        } else if (this.getColor() == Color.CYAN) {
            couleur = "Cyan";
        } else if (this.getColor() == Color.ORANGE) {
            couleur = "Orange";
        } else if (this.getColor() == Color.GREEN) {
            couleur = "Vert";
        } else if (this.getColor() == Color.PINK) {
            couleur = "Rose";
        }
        return couleur;
    }

}
