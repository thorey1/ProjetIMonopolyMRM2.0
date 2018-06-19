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
public class Maison {
    private int prix;
    private Propriete propriete;
    private Color couleur;
    
    public Maison(Color couleur, int prix){
        this.couleur = couleur;
        this.prix = prix;
    }

    public int getPrix() {
        return prix;
    }

    public Color getCouleur() {
        return couleur;
    }  

    public Propriete getPropriete() {
        return propriete;
    }      
    
}
