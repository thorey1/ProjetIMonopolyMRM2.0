package Model;

import Controler.UtilsMono.*;
import Enum.TypeCarreau;

public class Special extends Carreau {

    public Special(int numCarreau, String nomCarreau, TypeCarreau type) {
        super(numCarreau, nomCarreau, type);
    }
    
    public int getActionCarreauSpecial(){
        if(super.getNumCarreau()==1){
            return 200;
        }
        return 0;
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


    
}
