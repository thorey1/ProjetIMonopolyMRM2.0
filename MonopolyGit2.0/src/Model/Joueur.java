package Model;

import Enum.TypeCarreau;
import java.awt.Color;
import java.util.HashMap;

public class Joueur {
	private int numJoueur;
	private String nomJoueur;
	private int solde;
	private boolean prisonnier;
	private Carreau position;
	private HashMap<Color, Terrain> proprietes;
        private boolean tour;

        public Joueur(int numJoueur, String nomJoueur, Carreau position) {
            this.numJoueur = numJoueur;
            this.nomJoueur = nomJoueur;
            this.solde = 5000;
            this.prisonnier = false;
            setPosition(position);
            proprietes = new HashMap();
        }
        

       
        
	public boolean getPrison() {
		return prisonnier;
	}
        
        public void setPrison(boolean prison) {
		prisonnier=prison;
                
	}

	public Carreau getPosition() {
		return this.position;
	}

	public void setPosition(Carreau position) {
		this.position=position;
	}
        
        
        

        /**
         * @return the numJoueur
         */
        public int getNumJoueur() {
            return numJoueur;
        }

        /**
         * @param numJoueur the numJoueur to set
         */
        public void setNumJoueur(int numJoueur) {
            this.numJoueur = numJoueur;
        }

        /**
         * @return the nomJoueur
         */
        public String getNomJoueur() {
            return nomJoueur;
        }

        /**
         * @param nomJoueur the nomJoueur to set
         */
        public void setNomJoueur(String nomJoueur) {
            this.nomJoueur = nomJoueur;
        }

        /**
         * @return the solde
         */
        public int getSolde() {
            return solde;
        }

        /**
         * @param solde the solde to set
         */
        public void setSolde(int solde) {
            this.solde = solde;
        }
        
        public void addProprietes (Color col, Terrain prop){
            this.proprietes.put(col, prop);
        }

        public boolean getTour() {
            return tour;
        }
        
        public int getNbProp(Terrain t){
            int nb = 0;
            Color c;
            TypeCarreau tc = t.getTypeCarreau();
            
            if(tc == TypeCarreau.GARE || tc == TypeCarreau.COMPAGNIE){              
                for(int i = 0; i<=proprietes.size(); i++){             
                    if(proprietes.get(i).getTypeCarreau() == tc){
                        nb++;
                    }
                }
            }
            else if(tc == TypeCarreau.PROPRIETE){
                c = t.getCouleur();
                for(int i = 0; i<=proprietes.size(); i++){             
                    if(proprietes.get(i).getCouleur()== c){
                        nb++;
                    }
                }
            }
            return nb;
        }
        
        public void payer(int prix){
            setSolde(solde-prix); 
        }
        
        public void gain(int prix){
            setSolde(solde+prix);
        }
        
}
