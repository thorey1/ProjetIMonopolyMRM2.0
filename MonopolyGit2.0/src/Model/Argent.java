package Model;

import Enum.TypeCarreau;
import Enum.TypeCarte;






public class Argent extends Carte {

    public Argent(int numCarte, TypeCarte type, TypeCarreau car, String description) {
        super(numCarte, type, car, description);
    }
    
    /*
    @Override
    public void getActionCarte() {
        switch (this.getNumCarte()) {
            case 3:  //maison à voir
                     break;
            case 4:  getJoueur().setSolde(getJoueur().getSolde()-15);
                     break;
            case 5:  //maison à voir
                     break;
            case 6:  getJoueur().setSolde(getJoueur().getSolde()-20);
                     break;
            case 11: getJoueur().setSolde(getJoueur().getSolde()-150);
                     break;
            case 12: getJoueur().setSolde(getJoueur().getSolde()+100);
                     break;
            case 13: getJoueur().setSolde(getJoueur().getSolde()+50);
                     break;
            case 15: getJoueur().setSolde(getJoueur().getSolde()+150);
                     break;
            case 18: getJoueur().setSolde(getJoueur().getSolde()-10);
                     break;
            case 19: // à voir nombre de joueur controleur
                     break;
            case 20: getJoueur().setSolde(getJoueur().getSolde()+200);
                     break;
            case 22: getJoueur().setSolde(getJoueur().getSolde()-50);
                     break;
            case 23: getJoueur().setSolde(getJoueur().getSolde()+20);
                     break;         
            case 24: getJoueur().setSolde(getJoueur().getSolde()-100);
                     break;
            case 25: getJoueur().setSolde(getJoueur().getSolde()+100);
                     break;  
            case 27: getJoueur().setSolde(getJoueur().getSolde()-50);
                     break;         
            case 28: getJoueur().setSolde(getJoueur().getSolde()+50);
                     break;
            case 30: getJoueur().setSolde(getJoueur().getSolde()+25);
                     break;
            case 31: getJoueur().setSolde(getJoueur().getSolde()+100);
                     break; 
            case 32: getJoueur().setSolde(getJoueur().getSolde()+10);
                     break;         
            default: break;
        
        }
    }
    */
}

    
    
    
