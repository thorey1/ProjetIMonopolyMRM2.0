package Model;

import Enum.TypeCarreau;
import java.awt.Color;

public abstract class Terrain extends Carreau {
    private int prix;
    private Color couleur;
    private Joueur proprio = null;
    
    
    public Terrain(int numCarreau, String nomCarreau, TypeCarreau type,int prix, Color couleur) {
        super(numCarreau, nomCarreau, type);
        this.prix = prix;
        this.couleur = couleur;
        this.proprio = null;
    }
    
    


    @Override
    public int getPrix() {
        return prix;
    }

    public Color getCouleur() {
        return couleur;
    }


    public Joueur getProprio(){
        return proprio;
    };
    
    public void setProprio(Joueur proprio){
        this.proprio = proprio;
    }

    @Override
    public abstract int getLoyer(int de1, int de2);
        
    public Terrain getTerrain(){
        return this;
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
