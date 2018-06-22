package Model;

import Controler.UtilsMono.*;
import Enum.TypeCarreau;
import static Enum.TypeCarreau.CHANCE;
import static Enum.TypeCarreau.COMMUNAUTE;

public class Tirage extends Carreau {

    public Tirage(int numCarreau, String nomCarreau, TypeCarreau type) {
        super(numCarreau, nomCarreau, type);
    }

    @Override
    public TypeCarreau getTypeCarreau() {
        if (super.getNumCarreau() == 3 || super.getNumCarreau() == 18 || super.getNumCarreau() == 34) {
            return COMMUNAUTE;
        } else if (super.getNumCarreau() == 8 || super.getNumCarreau() == 23 || super.getNumCarreau() == 37) {
            return CHANCE;
        }
        return null;
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
    public int getPrix() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setProprietaire(Joueur proprietaire) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Joueur getProprietaire() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getLoyer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getLoyer(int de1, int de2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
