/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Color;



/**
 *
 * @author hassanyo
 */
public class Hotel {
    private int prix;
    private Propriete propriete;
    private Color couleur;
    
    public Hotel(Color couleur, int prix){
        this.prix = prix;
    }
    
    public int getPrix() {
        return prix;
    }

    public Propriete getPropriete() {
        return propriete;
    }

    public Color getCouleur() {
        return couleur;
    }
    
    
}
