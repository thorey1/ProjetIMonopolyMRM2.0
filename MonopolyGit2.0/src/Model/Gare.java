/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Enum.TypeCarreau;
import java.awt.Color;



/**
 *
 * @author hassanyo
 */
public class Gare extends Terrain{
    
    private int loyer;
    public Gare(int numCarreau, String nomCarreau, TypeCarreau type, int prix, Color couleur) {
        super(numCarreau, nomCarreau, type, prix, couleur);       
    }
    
    public int getLoyer() {
      return super.getProprietaire().getNbProp(this)*25;

    }
    
    
    //overrides inutilisés mais requis
    @Override
    public int getPrixMais() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getPrixHotel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Propriete getPropriete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getLoyer(int de1, int de2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
