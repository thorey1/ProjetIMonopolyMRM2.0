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
 * @author boedam
 */
public class Compagnie extends Terrain {

    public Compagnie(int numCarreau, String nomCarreau, TypeCarreau type, int prix, Color couleur) {
        super(numCarreau, nomCarreau, type, prix, couleur);
    }

    @Override
    public int getLoyer(int de1, int de2) {
        if (super.getProprio().getNbProp(this) == 1) {
            return  (de1 + de2) * 4;
        } else {
            return (de1 + de2) * 10;
        }
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
    public int getLoyer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
