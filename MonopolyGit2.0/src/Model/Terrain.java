package Model;

import Enum.TypeCarreau;
import java.awt.Color;

public abstract class Terrain extends Carreau {
    private int prix;
    private Color couleur;
    private Joueur proprietaire ;
    private int loyer = 10; //standard pour l'instant;

    public Terrain(int numCarreau, String nomCarreau, TypeCarreau type,int prix, Color couleur) {
        super(numCarreau, nomCarreau, type);
        this.prix = prix;
        this.couleur = couleur;
        this.proprietaire = null;
    }
    
    

    @Override
    public void setProprietaire(Joueur proprietaire) {
        this.proprietaire = proprietaire;
    }
        

    @Override
    public int getPrix() {
        return prix;
    }

    public Color getCouleur() {
        return couleur;
    }

    @Override
    public Joueur getProprietaire() {
        return proprietaire;
    }

    @Override
    public int getLoyer(){
        return loyer;
    }

    @Override
    public abstract int getPrixMais();

    @Override
    public abstract int getPrixHotel();

    @Override
    public abstract Propriete getPropriete();

    public Object getHotel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
}
