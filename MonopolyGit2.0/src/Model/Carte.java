package Model;


import Controler.Message;
import Controler.UtilsMono.*;
import Enum.TypeCarreau;
import Enum.TypeCarte;

import Enum.TypesMessages;


public class Carte {
    private int numCarte;
    private String description;
    private TypeCarte type;
    private TypeCarreau car;

    Carte(int numCarte, TypeCarte type, TypeCarreau car, String description){
        this.numCarte=numCarte;
        this.type=type;
        this.description=description;
        this.car=car;

    }


    public int getNumCarte() {
        return numCarte;
    }

    public TypeCarreau getCar() {
        return car;
    }


    public String getDescription() {
        return description;
    }

    
    public TypeCarte getType() {
        return type;
    }
    
}
