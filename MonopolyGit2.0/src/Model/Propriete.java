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
public class Propriete extends Terrain {

    private Hotel hotel = null;
    private ArrayList<Maison> maisons;
    private int loyer = 0;

    public Propriete(int numCarreau, String nomCarreau, TypeCarreau type, int prix, Color couleur) {
        super(numCarreau, nomCarreau, type, prix, couleur);
        maisons = new ArrayList();
    }

    public void addMaison(Maison m) {
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
        if (null != coulCar) {
            if (coulCar == Color.pink) {
                prixMais = 50;
            } else if (coulCar == Color.cyan) {
                prixMais = 50;
            } else if (coulCar == Color.magenta) {
                prixMais = 100;
            } else if (coulCar == Color.orange) {
                prixMais = 100;
            } else if (coulCar == Color.red) {
                prixMais = 150;
            } else if (coulCar == Color.yellow) {
                prixMais = 150;
            } else if (coulCar == Color.green) {
                prixMais = 200;
            } else if (coulCar == Color.blue) {
                prixMais = 200;
            }

        }
        return prixMais;
    }

    @Override
    public int getPrixHotel() {
        Color coulCar = super.getCouleur();
        int prixHotel = 0;
        if (null != coulCar) {
            if (coulCar == Color.pink) {
                prixHotel = 50;
            } else if (coulCar == Color.cyan) {
                prixHotel = 50;
            } else if (coulCar == Color.magenta) {
                prixHotel = 100;
            } else if (coulCar == Color.orange) {
                prixHotel = 100;
            } else if (coulCar == Color.red) {
                prixHotel = 150;
            } else if (coulCar == Color.yellow) {
                prixHotel = 150;
            } else if (coulCar == Color.green) {
                prixHotel = 200;
            } else if (coulCar == Color.blue) {
                prixHotel = 200;
            }

        }
        return prixHotel;
    }

    @Override
    public Propriete getPropriete() {
        return this;
    }

    @Override
    public int getLoyer() {
        if (this.getNumCarreau() == 2) {
            if (this.getMaisons().isEmpty() && hotel == null) {
                loyer = 2;
            } else if (this.getMaisons().size() == 1) {
                loyer = 10;
            } else if (this.getMaisons().size() == 2) {
                loyer = 30;
            } else if (this.getMaisons().size() == 3) {
                loyer = 90;
            } else if (this.getMaisons().size() == 4) {
                loyer = 160;
            } else {
                loyer = 250;
            }
        } else if (this.getNumCarreau() == 4) {
            if (this.getMaisons().isEmpty() && hotel == null) {
                loyer = 4;
            } else if (this.getMaisons().size() == 1) {
                loyer = 20;
            } else if (this.getMaisons().size() == 2) {
                loyer = 60;
            } else if (this.getMaisons().size() == 3) {
                loyer = 180;
            } else if (this.getMaisons().size() == 4) {
                loyer = 320;
            } else {
                loyer = 450;
            }
        } else if (this.getNumCarreau() == 7 || this.getNumCarreau() == 9) {
            if (this.getMaisons().isEmpty() && hotel == null) {
                loyer = 6;
            } else if (this.getMaisons().size() == 1) {
                loyer = 30;
            } else if (this.getMaisons().size() == 2) {
                loyer = 90;
            } else if (this.getMaisons().size() == 3) {
                loyer = 270;
            } else if (this.getMaisons().size() == 4) {
                loyer = 400;
            } else {
                loyer = 550;
            }
        } else if (this.getNumCarreau() == 10) {
            if (this.getMaisons().isEmpty() && hotel == null) {
                loyer = 8;
            } else if (this.getMaisons().size() == 1) {
                loyer = 40;
            } else if (this.getMaisons().size() == 2) {
                loyer = 100;
            } else if (this.getMaisons().size() == 3) {
                loyer = 300;
            } else if (this.getMaisons().size() == 4) {
                loyer = 450;
            } else {
                loyer = 600;
            }
        } else if (this.getNumCarreau() == 12 || this.getNumCarreau() == 14) {
            if (this.getMaisons().isEmpty() && hotel == null) {
                loyer = 10;
            } else if (this.getMaisons().size() == 1) {
                loyer = 50;
            } else if (this.getMaisons().size() == 2) {
                loyer = 150;
            } else if (this.getMaisons().size() == 3) {
                loyer = 450;
            } else if (this.getMaisons().size() == 4) {
                loyer = 625;
            } else {
                loyer = 750;
            }
        } else if (this.getNumCarreau() == 15) {
            if (this.getMaisons().isEmpty() && hotel == null) {
                loyer = 12;
            } else if (this.getMaisons().size() == 1) {
                loyer = 60;
            } else if (this.getMaisons().size() == 2) {
                loyer = 180;
            } else if (this.getMaisons().size() == 3) {
                loyer = 550;
            } else if (this.getMaisons().size() == 4) {
                loyer = 700;
            } else {
                loyer = 900;
            }
        } else if (this.getNumCarreau() == 17 || this.getNumCarreau() == 19) {
            if (this.getMaisons().isEmpty() && hotel == null) {
                loyer = 14;
            } else if (this.getMaisons().size() == 1) {
                loyer = 70;
            } else if (this.getMaisons().size() == 2) {
                loyer = 200;
            } else if (this.getMaisons().size() == 3) {
                loyer = 550;
            } else if (this.getMaisons().size() == 4) {
                loyer = 750;
            } else {
                loyer = 950;
            }
        } else if (this.getNumCarreau() == 20) {
            if (this.getMaisons().isEmpty() && hotel == null) {
                loyer = 16;
            } else if (this.getMaisons().size() == 1) {
                loyer = 80;
            } else if (this.getMaisons().size() == 2) {
                loyer = 220;
            } else if (this.getMaisons().size() == 3) {
                loyer = 600;
            } else if (this.getMaisons().size() == 4) {
                loyer = 800;
            } else {
                loyer = 1000;
            }
        } else if (this.getNumCarreau() == 22 || this.getNumCarreau() == 24) {
            if (this.getMaisons().isEmpty() && hotel == null) {
                loyer = 18;
            } else if (this.getMaisons().size() == 1) {
                loyer = 90;
            } else if (this.getMaisons().size() == 2) {
                loyer = 250;
            } else if (this.getMaisons().size() == 3) {
                loyer = 700;
            } else if (this.getMaisons().size() == 4) {
                loyer = 875;
            } else {
                loyer = 1050;
            }
        } else if (this.getNumCarreau() == 25) {
            if (this.getMaisons().isEmpty() && hotel == null) {
                loyer = 20;
            } else if (this.getMaisons().size() == 1) {
                loyer = 100;
            } else if (this.getMaisons().size() == 2) {
                loyer = 300;
            } else if (this.getMaisons().size() == 3) {
                loyer = 750;
            } else if (this.getMaisons().size() == 4) {
                loyer = 925;
            } else {
                loyer = 1100;
            }
        } else if (this.getNumCarreau() == 27 || this.getNumCarreau() == 28) {
            if (this.getMaisons().isEmpty() && hotel == null) {
                loyer = 22;
            } else if (this.getMaisons().size() == 1) {
                loyer = 110;
            } else if (this.getMaisons().size() == 2) {
                loyer = 330;
            } else if (this.getMaisons().size() == 3) {
                loyer = 800;
            } else if (this.getMaisons().size() == 4) {
                loyer = 975;
            } else {
                loyer = 1150;
            }
        } else if (this.getNumCarreau() == 30) {
            if (this.getMaisons().isEmpty() && hotel == null) {
                loyer = 50;
            } else if (this.getMaisons().size() == 1) {
                loyer = 200;
            } else if (this.getMaisons().size() == 2) {
                loyer = 600;
            } else if (this.getMaisons().size() == 3) {
                loyer = 1400;
            } else if (this.getMaisons().size() == 4) {
                loyer = 1700;
            } else {
                loyer = 2000;
            }
        } else if (this.getNumCarreau() == 32 || this.getNumCarreau() == 33) {
            if (this.getMaisons().isEmpty() && hotel == null) {
                loyer = 26;
            } else if (this.getMaisons().size() == 1) {
                loyer = 130;
            } else if (this.getMaisons().size() == 2) {
                loyer = 390;
            } else if (this.getMaisons().size() == 3) {
                loyer = 900;
            } else if (this.getMaisons().size() == 4) {
                loyer = 1100;
            } else {
                loyer = 1275;
            }
        } else if (this.getNumCarreau() == 35) {
            if (this.getMaisons().isEmpty() && hotel == null) {
                loyer = 28;
            } else if (this.getMaisons().size() == 1) {
                loyer = 150;
            } else if (this.getMaisons().size() == 2) {
                loyer = 450;
            } else if (this.getMaisons().size() == 3) {
                loyer = 1000;
            } else if (this.getMaisons().size() == 4) {
                loyer = 1200;
            } else {
                loyer = 1400;
            }
        } else if (this.getNumCarreau() == 38) {
            if (this.getMaisons().isEmpty() && hotel == null) {
                loyer = 35;
            } else if (this.getMaisons().size() == 1) {
                loyer = 175;
            } else if (this.getMaisons().size() == 2) {
                loyer = 500;
            } else if (this.getMaisons().size() == 3) {
                loyer = 1100;
            } else if (this.getMaisons().size() == 4) {
                loyer = 1300;
            } else {
                loyer = 1500;
            }
        } else if (this.getNumCarreau() == 40) {
            if (this.getMaisons().isEmpty() && hotel == null) {
                loyer = 50;
            } else if (this.getMaisons().size() == 1) {
                loyer = 200;
            } else if (this.getMaisons().size() == 2) {
                loyer = 600;
            } else if (this.getMaisons().size() == 3) {
                loyer = 1400;
            } else if (this.getMaisons().size() == 4) {
                loyer = 1700;
            } else {
                loyer = 2000;
            }
        }
        return loyer;
    }

    //overrides inutilisés mais requis
    @Override
    public int getLoyer(int de1, int de2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
