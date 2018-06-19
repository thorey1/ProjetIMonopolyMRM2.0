package Model;


import Enum.TypeCarreau;
import Enum.TypeCarte;



public class Action extends Carte {
    
    

    public Action(int numCarte, TypeCarte type,TypeCarreau car, String description) {
        super(numCarte, type, car, description);
    }

    /*
    public void getActionCarte() {
        if (this.getNumCarte()==1 || this.getNumCarte()==17){
            getJoueur().getCartesPrison().add(this);
        }
    }
    */

   
}