/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Enum.TypeCarreau;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author hassanyo
 */
public class Propriete extends Terrain{
    private Hotel hotel;
    private ArrayList<Maison> maisons;
    
    public Propriete(int numCarreau, String nomCarreau, TypeCarreau type, int prix, Color couleur) {
        super(numCarreau, nomCarreau, type, prix, couleur);
        maisons = new ArrayList();
    }
    
    public void addMaison(Maison m){
        maisons.add(m);
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public ArrayList<Maison> getMaisons() {
        return maisons;
    }

    @Override
    public int getPrixMais() {
        Color coulCar = super.getCouleur();
        int prixMais = 0;
        if(null != coulCar){
            if(coulCar==Color.pink){
                prixMais = 50;
            } else if(coulCar==Color.cyan){
                prixMais = 50;
            } else if(coulCar==Color.magenta){
                prixMais = 100;
            } else if(coulCar==Color.orange){
                prixMais = 100;   
            } else if(coulCar==Color.red){
                prixMais = 150;    
            } else if(coulCar==Color.yellow){
                prixMais = 150;    
            } else if(coulCar==Color.green){
                prixMais = 200;
            } else if(coulCar==Color.blue){
                prixMais = 200;    
            }
            
        }
        return prixMais;
    }

    @Override
    public int getPrixHotel() {
        Color coulCar = super.getCouleur();
        int prixHotel = 0;
        if(null != coulCar){
            if(coulCar==Color.pink){
                prixHotel = 50;
            } else if(coulCar==Color.cyan){
                prixHotel = 50;
            } else if(coulCar==Color.magenta){
                prixHotel = 100;
            } else if(coulCar==Color.orange){
                prixHotel = 100;   
            } else if(coulCar==Color.red){
                prixHotel = 150;    
            } else if(coulCar==Color.yellow){
                prixHotel = 150;    
            } else if(coulCar==Color.green){
                prixHotel = 200;
            } else if(coulCar==Color.blue){
                prixHotel = 200;    
            }
            
        }
        return prixHotel;
    }

    @Override
    public Propriete getPropriete() {
        return this;
    }
    
}
