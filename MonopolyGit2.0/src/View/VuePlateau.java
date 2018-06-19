package View;

import Controler.*;

public class VuePlateau implements Observe{

        
    public void afficher(int d) {
		throw new UnsupportedOperationException();
    }
    
    private Observateur observateur;    
    @Override
    public void addObservateur(Observateur o) {
        this.observateur=o;
    }
    
    @Override
    public void notifierObservateur(Message message) {
        if (observateur != null) {
            observateur.traiterMessage(message);
        }
    }
}