package Model;

import Enum.TypeCarreau;
import View.Pion;
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
        private boolean carteLibPrison;
        private Pion pion;

        public Joueur(int numJoueur, String nomJoueur, Carreau position, Pion pion) {
            this.numJoueur = numJoueur;
            this.nomJoueur = nomJoueur;
            this.solde = 1500;
            this.prisonnier = false;
            this.pion = pion;
            setPosition(position);
            proprietes = new HashMap();
            setCarteLibPrison(false);
        }

        public boolean isCarteLibPrison() {
            return carteLibPrison;
        }

        public void setCarteLibPrison(boolean carteLibPrison) {
            this.carteLibPrison = carteLibPrison;
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
            this.getProprietes().put(col, prop);
        }

        public boolean getTour() {
            return tour;
        }
        
        public int getNbProp(Terrain t){
            int nb = 0;
            Color c;
            TypeCarreau tc = t.getTypeCarreau();
            
            if(tc == TypeCarreau.GARE || tc == TypeCarreau.COMPAGNIE){              
                for(int i = 0; i<=getProprietes().size(); i++){             
                    if(getProprietes().get(i).getTypeCarreau() == tc){
                        nb++;
                    }
                }
            }
            else if(tc == TypeCarreau.PROPRIETE){
                c = t.getCouleur();
                for(int i = 0; i<=getProprietes().size(); i++){             
                    if(getProprietes().get(i).getCouleur()== c){
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

    /**
     * @return the proprietes
     */
    public HashMap<Color, Terrain> getProprietes() {
        return proprietes;
    }

    public Pion getPion() {
        return pion;
    }

    public void setPion(Pion pion) {
        this.pion = pion;
    }
        
}
