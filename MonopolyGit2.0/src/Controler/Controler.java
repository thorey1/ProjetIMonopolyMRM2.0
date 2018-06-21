package Controler;

import java.awt.Color;

import Enum.TypeCarreau;
import static Enum.TypeCarreau.*;
import static Enum.TypeCarte.*;
import static Enum.TypesMessages.*;
import Model.*;
import View.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Controler implements Observateur {

    private HashMap<Integer, Joueur> joueurs;
    private VuePlateau vuePlateau;
    public VueJoueurEtudiant vueJoueur;
    private HashMap<Integer, Carte> cartes;
    private HashMap<Integer, Carreau> carreaux;
    private HashMap<Color, Maison> maisons;
    private HashMap<Color, Hotel> hotels;
    private HashMap<Color, Integer> couleurs;
    private VueMenu vueMenu;
    private VueRegle vueRegle;


    // POUR TEST JEU
    public Controler() {
        cartes = new HashMap();
        carreaux = new HashMap();
        joueurs = new HashMap();
        maisons = new HashMap();
        maisons = initialiserHashMapMaison();
        hotels = new HashMap();
        hotels = InitialiserHashMapHotel();

        for (int i = 1; i <= this.initialiserHashMapCarreaux().size(); i++) {
            carreaux.put(i, this.initialiserHashMapCarreaux().get(i - 1));
        }

        for (int i = 1; i <= this.initialiserHashMapCartes().size(); i++) {
            cartes.put(i, this.initialiserHashMapCartes().get(i - 1));
        }
       
        vueMenu = new VueMenu();
        vueMenu.addObservateur(this);
        
        
    }

    public HashMap<Integer, Joueur> getJoueurs() {
        return joueurs;
    }

    public HashMap<Integer, Carte> getCartes() {
        return cartes;
    }

    public HashMap<Integer, Carreau> getCarreaux() {
        return carreaux;
    }

    public HashMap<Color, Integer> getCouleurs() {
        return couleurs;
    }

    public void deplacement(Joueur j) {
        boolean ddouble = true;
        int compteur = 0;
        System.out.println("Au tour de " + j.getNomJoueur());

        if (j.getPrison()) {
            System.out.println("Tu dois faire un double pour sortir de prison ou payer 50€! \n Quel est ton choix?(payer/dé) ");
            Scanner scanner = new Scanner(System.in);
            String rep = scanner.nextLine();
            if ("dé".equals(rep)) {
                System.out.println("Presser entrée pour lancer le premier dé" + "\n");
                this.pause();
                int d1 = this.lancerDe();
                System.out.println("Voici le premier dé : " + d1 + "\n");
                System.out.println("Presser entrée pour lancer le deuxième dé" + "\n");
                this.pause();
                int d2 = this.lancerDe();
                System.out.println("Voici le deuxième dé : " + d2 + "\n");

                if (d1 == d2) {
                    System.out.println("Vous avez fait un double, vous sortez de prison !");
                    j.setPrison(false);
                    ddouble = false;
                    Carreau newCar = (carreaux.get(11 + d1 + d2));
                    j.setPosition(newCar);
                    String nomProp = newCar.getNomCarreau();
                    if (newCar.getTypeCarreau() == TypeCarreau.MALUS || newCar.getTypeCarreau() == TypeCarreau.CHANCE || newCar.getTypeCarreau() == TypeCarreau.COMMUNAUTE || newCar.getTypeCarreau() == TypeCarreau.DEPART || newCar.getTypeCarreau() == TypeCarreau.PRISON || newCar.getTypeCarreau() == TypeCarreau.PARC) {
                        System.out.println("Tu es sur la case " + nomProp);
                    } else {
                        Joueur proprio = newCar.getProprietaire();
                        if (proprio == null) {
                            System.out.println("Tu es sur la propriété " + nomProp + "\n");
                            System.out.println("Veux-tu acheter(o/n) " + nomProp);
                            scanner = new Scanner(System.in);
                            rep = scanner.nextLine();
                            if ("o".equals(rep)) {
                                int prixProp = newCar.getPrix();
                                j.payer(prixProp);
                                newCar.setProprietaire(j);
                                System.out.printf("Tu paies %d la propriété %s\n", prixProp, nomProp);
                                System.out.println("Il te reste " + j.getSolde());

                            }
                        } else if (proprio != null && proprio != j) {
                            System.out.println("Tu es sur la propriété " + nomProp + " qui appartient à " + proprio.getNomJoueur() + "\n");
                            j.payer(newCar.getLoyer());
                            proprio.gain(newCar.getLoyer());
                            System.out.println(j.getNomJoueur() + " perd " + newCar.getLoyer() + ", Il te reste " + j.getSolde());
                            System.out.println(proprio.getNomJoueur() + " gagne " + newCar.getLoyer() + "\n");
                        } else {
                            System.out.println("Tu es sur ta propriété! \n");
                        }
                    }
                } else {
                    ddouble = false;
                    System.out.println("Tu n'as pas fais de double \n Fin du tour \n");
                }
            } else if ("payer".equals(rep)) {
                j.payer(50);
                j.setPrison(false);
                System.out.println("Tu as payé 50€!");
                ddouble = true;
            }
        }

        while (ddouble) {
            ddouble = false;
            System.out.println("Presser entrée pour lancer le premier dé" + "\n");
            this.pause();
            int d1 = this.lancerDe();
            System.out.println("Voici le premier dé : " + d1 + "\n");
            System.out.println("Presser entrée pour lancer le deuxième dé" + "\n");
            this.pause();
            int d2 = this.lancerDe();
            System.out.println("Voici le deuxième dé : " + d2 + "\n");

            if (d1 == d2) {
                System.out.println("Vous avez fait un double !");
                ddouble = true;
                compteur = compteur + 1;
            }
            if (compteur == 3) {
                j.setPrison(true);
                j.setPosition(carreaux.get(11));
                System.out.println("Vous avez fais 3 double, vous allez directement en prison");
                System.out.println("Fin du tour");
                break;
            }

            int pos = j.getPosition().getNumCarreau();
            int newPos = pos + d1 + d2;
            Carreau newCar;

            if (j.getPosition().getNumCarreau() + d1 + d2 > carreaux.size()) {
                newCar = carreaux.get(newPos % carreaux.size());
                j.setPosition(newCar);
                System.out.println("Passage par la case départ, tu gagnes 200€!! \n \t Bilan solde : " + j.getSolde() + "\n");
                j.gain(200);
            } else {
                newCar = carreaux.get(newPos);
                j.setPosition(newCar);
            }

            String nomProp = newCar.getNomCarreau();
            if (newCar.getTypeCarreau() == TypeCarreau.MALUS || newCar.getTypeCarreau() == TypeCarreau.CHANCE || newCar.getTypeCarreau() == TypeCarreau.COMMUNAUTE || newCar.getTypeCarreau() == TypeCarreau.DEPART || newCar.getTypeCarreau() == TypeCarreau.PARC) {
                System.out.println("Tu es sur la case " + nomProp);
            } else if (newCar.getTypeCarreau() == TypeCarreau.PRISON) {
                j.setPrison(true);
                j.setPosition(carreaux.get(11));
                System.out.println("Tu es sur la case " + nomProp);
                System.out.println("Fin du tour \n");
                break;
            } else {
                Joueur proprio = newCar.getProprietaire();
                if (proprio == null) {
                    System.out.println("Tu es sur la propriété " + nomProp + "\n");
                    System.out.println("Veux-tu acheter(o/n) " + nomProp);
                    Scanner scanner = new Scanner(System.in);
                    String rep = scanner.nextLine();
                    if ("o".equals(rep)) {
                        int prixProp = newCar.getPrix();
                        j.payer(prixProp);
                        newCar.setProprietaire(j);

                        System.out.printf("Tu paies %d la propriété %s\n", prixProp, nomProp);
                        System.out.println("Il te reste " + j.getSolde());
                        //
                        Propriete prop = newCar.getPropriete();
                        //if ((j.getNbProp(prop) == getCouleurs().get(prop.getCouleur())) && (getCouleurs())) {
                        //Construction après vérification que le joueur possède tous les terrains de la couleur de la case qu'il possède
                        //this.construire(j, prop);
                        //}

                    }
                } else if (proprio != null && proprio != j) {
                    System.out.println("Tu es sur la propriété " + nomProp + " qui appartient à " + proprio.getNomJoueur() + "\n");
                    j.payer(newCar.getLoyer());
                    proprio.gain(newCar.getLoyer());
                    System.out.println(j.getNomJoueur() + " perd " + newCar.getLoyer() + ", Il te reste " + j.getSolde());
                    System.out.println(proprio.getNomJoueur() + " gagne " + newCar.getLoyer() + "\n");
                } else {
                    System.out.println("Tu es sur ta propriété! \n");
                }
            }
            System.out.println("Fin du tour \n");

        }
    }

    public Carte tirerCarte() {
        ArrayList pilecartes = this.getCartes(this.getJoueur().getPosition().getTypeCarreau());
        return this.getCarteAlea(pilecartes);
    }

    public Carreau getCarreau(int position) {
        return carreaux.get(position);
    }

    public Carte getCarteAlea(ArrayList<Carte> pileCartes) {
        int nbcartes = pileCartes.size();
        Carte carte = null;
        for (int i = 0; i < nbcartes; i++) {
            if (i == (int) (Math.random() * nbcartes)) {
                carte = pileCartes.get(i);
            }
        }
        return carte;
    }

    public Carte getCarte(int numCarte) {
        return cartes.get(numCarte);
    }

    public ArrayList<Carte> getCartes(TypeCarreau tc) {
        ArrayList pilecarte = new ArrayList();
        for (int i = 0; i < cartes.size(); i++) {
            if (cartes.get(i).getCar() == tc) {
                pilecarte.add(cartes.get(i));
            }
        }
        return pilecarte;
    }

    public Joueur getJoueur() {
        Joueur j = null;
        for (int i = 1; i < joueurs.size(); i++) {
            if (joueurs.get(i).getTour()) {
                j = joueurs.get(i);
            }
        }
        return j;
    }

    public int lancerDe() {
        return (int) ((Math.random() * 6) + 1);
    }

    public ArrayList<Carreau> initialiserHashMapCarreaux() {
        Special t1 = new Special(1, "Départ", DEPART);
        Terrain t2 = new Propriete(2, "Boulevard de Belleville", PROPRIETE, 60, Color.pink);
        Special t3 = new Special(3, "Caisse de communauté", COMMUNAUTE);
        Terrain t4 = new Propriete(4, "Rue Lecourbe", PROPRIETE, 60, Color.pink);
        Malus t5 = new Malus(5, "Impôts sur le revenu", MALUS, 200);
        Terrain t6 = new Propriete(6, "Gare Montparnasse", GARE, 200, null);
        Terrain t7 = new Propriete(7, "Rue de Vaugirard", PROPRIETE, 100, Color.cyan);
        Special t8 = new Special(8, "Chance", CHANCE);
        Terrain t9 = new Propriete(9, "Rue de Courcelles", PROPRIETE, 100, Color.cyan);
        Terrain t10 = new Propriete(10, "Avenue de la République", PROPRIETE, 120, Color.cyan);
        Special t11 = new Special(11, "En prison/Simple visite", PARC);
        Terrain t12 = new Propriete(12, "Boulevard de la Villette", PROPRIETE, 140, Color.magenta);
        Terrain t13 = new Propriete(13, "Compagnie de distribution d'électricité", COMPAGNIE, 150, Color.gray);
        Terrain t14 = new Propriete(14, "Avenue de Neuilly", PROPRIETE, 140, Color.magenta);
        Terrain t15 = new Propriete(15, "Rue de Paradis", PROPRIETE, 160, Color.magenta);
        Terrain t16 = new Propriete(16, "Gare de Lyon", GARE, 200, null);
        Terrain t17 = new Propriete(17, "Avenue Mozart", PROPRIETE, 180, Color.orange);
        Special t18 = new Special(18, "Caisse de communauté", COMMUNAUTE);
        Terrain t19 = new Propriete(19, "Boulevard Saint-Michel", PROPRIETE, 180, Color.orange);
        Terrain t20 = new Propriete(20, "Place Pigalle", PROPRIETE, 200, Color.orange);
        Special t21 = new Special(21, "Parc Gratuit", PARC);
        Terrain t22 = new Propriete(22, "Avenue Matignon", PROPRIETE, 220, Color.red);
        Special t23 = new Special(23, "Chance", CHANCE);
        Terrain t24 = new Propriete(24, "Boulevard Malesherbes", PROPRIETE, 220, Color.red);
        Terrain t25 = new Propriete(25, "Avenue Henri-Martin", PROPRIETE, 240, Color.red);
        Terrain t26 = new Propriete(26, "Gare du Nord", GARE, 200, null);
        Terrain t27 = new Propriete(27, "Faubourg Saint-Honoré", PROPRIETE, 260, Color.yellow);
        Terrain t28 = new Propriete(28, "Place de la Bourse", PROPRIETE, 260, Color.yellow);
        Terrain t29 = new Propriete(29, "Compagnie de distribution des eaux", COMPAGNIE, 150, Color.gray);
        Terrain t30 = new Propriete(30, "Rue de la Fayette", PROPRIETE, 280, Color.yellow);
        Special t31 = new Special(31, "Allez en Prison", PRISON);
        Terrain t32 = new Propriete(32, "Avenue de Breteuil", PROPRIETE, 300, Color.green);
        Terrain t33 = new Propriete(33, "Avenue Foch", PROPRIETE, 300, Color.green);
        Special t34 = new Special(34, "Caisse de communauté", COMMUNAUTE);
        Terrain t35 = new Propriete(35, "Boulevard des Capucines", PROPRIETE, 320, Color.green);
        Terrain t36 = new Propriete(36, "Gare Saint-Lazare", GARE, 200, null);
        Special t37 = new Special(37, "Chance", CHANCE);
        Terrain t38 = new Propriete(38, "Avenue des Champs-Elysées", PROPRIETE, 350, Color.blue);
        Malus t39 = new Malus(39, "Taxe de Luxe", MALUS, 200);
        Terrain t40 = new Propriete(40, "Rue de la Paix", PROPRIETE, 400, Color.blue);
        ArrayList<Carreau> casecar = new ArrayList();
        casecar.add(t1);
        casecar.add(t2);
        casecar.add(t3);
        casecar.add(t4);
        casecar.add(t5);
        casecar.add(t6);
        casecar.add(t7);
        casecar.add(t8);
        casecar.add(t9);
        casecar.add(t10);
        casecar.add(t11);
        casecar.add(t12);
        casecar.add(t13);
        casecar.add(t14);
        casecar.add(t15);
        casecar.add(t16);
        casecar.add(t17);
        casecar.add(t18);
        casecar.add(t19);
        casecar.add(t20);
        casecar.add(t21);
        casecar.add(t22);
        casecar.add(t23);
        casecar.add(t24);
        casecar.add(t25);
        casecar.add(t26);
        casecar.add(t27);
        casecar.add(t28);
        casecar.add(t29);
        casecar.add(t30);
        casecar.add(t31);
        casecar.add(t32);
        casecar.add(t33);
        casecar.add(t34);
        casecar.add(t35);
        casecar.add(t36);
        casecar.add(t37);
        casecar.add(t38);
        casecar.add(t39);
        casecar.add(t40);
        return casecar;
    }

    public HashMap<Color, Maison> initialiserHashMapMaison() {
        Maison m1 = new Maison(Color.pink, 50);
        Maison m2 = new Maison(Color.cyan, 50);
        Maison m3 = new Maison(Color.magenta, 100);
        Maison m4 = new Maison(Color.orange, 100);
        Maison m5 = new Maison(Color.red, 150);
        Maison m6 = new Maison(Color.yellow, 150);
        Maison m7 = new Maison(Color.green, 200);
        Maison m8 = new Maison(Color.blue, 200);

        HashMap<Color, Maison> maisons = new HashMap();

        maisons.put(Color.pink, m1);
        maisons.put(Color.cyan, m2);
        maisons.put(Color.magenta, m3);
        maisons.put(Color.orange, m4);
        maisons.put(Color.red, m5);
        maisons.put(Color.yellow, m6);
        maisons.put(Color.green, m7);
        maisons.put(Color.blue, m8);

        return maisons;
    }

    public HashMap<Color, Hotel> InitialiserHashMapHotel() {
        Hotel m1 = new Hotel(Color.pink, 50);
        Hotel m2 = new Hotel(Color.cyan, 50);
        Hotel m3 = new Hotel(Color.magenta, 100);
        Hotel m4 = new Hotel(Color.orange, 100);
        Hotel m5 = new Hotel(Color.red, 150);
        Hotel m6 = new Hotel(Color.yellow, 150);
        Hotel m7 = new Hotel(Color.green, 200);
        Hotel m8 = new Hotel(Color.blue, 200);

        HashMap<Color, Hotel> hotels = new HashMap();

        hotels.put(Color.pink, m1);
        hotels.put(Color.cyan, m2);
        hotels.put(Color.magenta, m3);
        hotels.put(Color.orange, m4);
        hotels.put(Color.red, m5);
        hotels.put(Color.yellow, m6);
        hotels.put(Color.green, m7);
        hotels.put(Color.blue, m8);

        return hotels;
    }

    public HashMap<Color, Integer> InitialiserHashMapCouleur() {
        HashMap<Color, Integer> couleurs = new HashMap();

        couleurs.put(Color.pink, 2);
        couleurs.put(Color.cyan, 3);
        couleurs.put(Color.magenta, 2);
        couleurs.put(Color.orange, 3);
        couleurs.put(Color.red, 3);
        couleurs.put(Color.yellow, 3);
        couleurs.put(Color.green, 3);
        couleurs.put(Color.blue, 2);

        return couleurs;
    }

    public void pause() {
        System.out.println("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public void commencerJeu() {
        Joueur j1 = new Joueur(1, "Malo", this.getCarreaux().get(1));
        Joueur j2 = new Joueur(2, "Youssef", this.getCarreaux().get(1));
        //Joueur j3 = new Joueur(3, "O'Neal", this.getCarreaux().get(1));
        //Joueur j4 = new Joueur(4, "Rémi", this.getCarreaux().get(1));
        //Joueur j5 = new Joueur(5, "Yann", this.getCarreaux().get(1));
        //Joueur j6 = new Joueur(6, "Quentin", this.getCarreaux().get(1));

        joueurs.put(1, j1);
        joueurs.put(2, j2);
        //joueurs.put(3, j3);
        //joueurs.put(4, j4);
        //joueurs.put(5, j5);
        //joueurs.put(6, j6);

        for (int j = 0; j < 50; j++) {
            for (int i = 1; i <= joueurs.size(); i++) {
                System.out.println("------------------------------------------------");
                deplacement(joueurs.get(i));
                System.out.println("------------------------------------------------");
            }
        }
    }

    public void construire(Joueur j, Propriete p) {
        Carreau carCourant = carreaux.get(p.getNumCarreau());
        Color coul = carCourant.getPropriete().getCouleur();

        if (p.getMaisons().isEmpty()) {
            Maison maison = maisons.get(coul);
            j.payer(maison.getPrix());
            carCourant.getPropriete().addMaison(maison);

        } else if (p.getMaisons().size() == 4) {
            p.getMaisons().clear();
            Hotel hotel = hotels.get(coul);
            carCourant.getPropriete().setHotel(hotel);
            j.payer(hotel.getPrix());
        }
    }

    public ArrayList<Carte> initialiserHashMapCartes() {
        Carte c1 = new Carte(1, ACTION, CHANCE, "Vous êtes libéré de prison. Cette carte peut être conservée jusqu'à ce qu'elle soit utilisée.");
        Carte c2 = new Carte(2, DEPLACEMENT, CHANCE, "Reculez de trois cases.");
        Carte c3 = new Carte(3, ARGENT, CHANCE, "Vous êtes imposés pour les réparations de voirie à raison de : 40 € par maison et 115€ par hôtel.");
        Carte c4 = new Carte(4, ARGENT, CHANCE, "Amende pour excès de vitesse : 15€.");
        Carte c5 = new Carte(5, ARGENT, CHANCE, "Faites des réparations dans toutes vos maisons : versez pour chaque maison 25€ et pour chaque hôtel 100€.");
        Carte c6 = new Carte(6, ARGENT, CHANCE, "Amende pour ivresse : 20€.");
        Carte c7 = new Carte(7, DEPLACEMENT, CHANCE, "Avancez jusqu'à la case Départ.");
        Carte c8 = new Carte(8, DEPLACEMENT, CHANCE, "Allez en prison. Avancez tout droit en prison. Ne passez pas par la case Départ. Ne recevez pas 200€.");
        Carte c9 = new Carte(9, DEPLACEMENT, CHANCE, "Rendez-vous à l'Avenue Henri-Martin. Si vous passez par la case Départ, recevez 200€.");
        Carte c10 = new Carte(10, DEPLACEMENT, CHANCE, "Allez à la gare de Lyon. Si vous passez par la case Départ, recevez 200€.");
        Carte c11 = new Carte(11, ARGENT, CHANCE, "Payez pour frais de scolarité : 150€.");
        Carte c12 = new Carte(12, ARGENT, CHANCE, "Vous avez gagné le prix de mots croisés. Recevez 100€.");
        Carte c13 = new Carte(13, ARGENT, CHANCE, "La Banque vous verse un dividende de 50€.");
        Carte c14 = new Carte(14, DEPLACEMENT, CHANCE, "Rendez-vous à la Rue de la Paix.");
        Carte c15 = new Carte(15, ARGENT, CHANCE, "Votre immeuble et votre prêt rapportent. Vous devez toucher 150€.");
        Carte c16 = new Carte(16, DEPLACEMENT, CHANCE, "Accédez au Boulevard de la Villette. Si vous passez par la case Départ, recevez 200€.");

        Carte c17 = new Carte(17, ACTION, COMMUNAUTE, "Vous êtes libéré de prison. Cette carte peut être conservée jusqu'à ce qu'elle soit utilisée.");
        Carte c18 = new Carte(18, ARGENT, COMMUNAUTE, "Payez une amende de 10€");
        Carte c19 = new Carte(19, ARGENT, COMMUNAUTE, "C'est votre anniversaire. Chaque joueur doit vous donner 10€");
        Carte c20 = new Carte(20, ARGENT, COMMUNAUTE, "Erreur de la banque en votre faveur. Recevez 200€");
        Carte c21 = new Carte(21, DEPLACEMENT, COMMUNAUTE, "Retournez à Belleville");
        Carte c22 = new Carte(22, ARGENT, COMMUNAUTE, "Payez la note du médecin : 50€");
        Carte c23 = new Carte(23, ARGENT, COMMUNAUTE, "Les contributions vous remboursent la somme de 20€");
        Carte c24 = new Carte(24, ARGENT, COMMUNAUTE, "Payez à l'hôpital 100€");
        Carte c25 = new Carte(25, ARGENT, COMMUNAUTE, "Vous héritez : 100€");
        Carte c26 = new Carte(26, DEPLACEMENT, COMMUNAUTE, "Allez en prison. Avancez tout droit en prison. Ne passez pas par la case Départ. Ne recevez pas 200€");
        Carte c27 = new Carte(27, ARGENT, COMMUNAUTE, "Payez votre Police d'Assurance : 50€");
        Carte c28 = new Carte(28, ARGENT, COMMUNAUTE, "La vente de votre stock vous rapporte : 50€");
        Carte c29 = new Carte(29, DEPLACEMENT, COMMUNAUTE, "Avancez jusqu'à la case Départ.");
        Carte c30 = new Carte(30, ARGENT, COMMUNAUTE, "Recevez votre intérêt sur l'emprunt à 7% : 25€");
        Carte c31 = new Carte(31, ARGENT, COMMUNAUTE, "Recevez votre revenu annuel : 100€");
        Carte c32 = new Carte(32, ARGENT, COMMUNAUTE, "Vous avez gagné le deuxième prix de beauté : recevez 10€");

        ArrayList<Carte> cartesComplet = new ArrayList();

        cartesComplet.add(c1);
        cartesComplet.add(c2);
        cartesComplet.add(c3);
        cartesComplet.add(c4);
        cartesComplet.add(c5);
        cartesComplet.add(c6);
        cartesComplet.add(c7);
        cartesComplet.add(c8);
        cartesComplet.add(c9);
        cartesComplet.add(c10);
        cartesComplet.add(c11);
        cartesComplet.add(c12);
        cartesComplet.add(c13);
        cartesComplet.add(c14);
        cartesComplet.add(c15);
        cartesComplet.add(c16);
        cartesComplet.add(c17);
        cartesComplet.add(c18);
        cartesComplet.add(c19);
        cartesComplet.add(c20);
        cartesComplet.add(c21);
        cartesComplet.add(c22);
        cartesComplet.add(c23);
        cartesComplet.add(c24);
        cartesComplet.add(c25);
        cartesComplet.add(c26);
        cartesComplet.add(c27);
        cartesComplet.add(c28);
        cartesComplet.add(c29);
        cartesComplet.add(c30);
        cartesComplet.add(c31);
        cartesComplet.add(c32);

        return cartesComplet;

    }

    public boolean passeParDepart(Joueur j, Carreau c) {
        if (c.getNumCarreau() > j.getPosition().getNumCarreau()) {
            return false;
        } else {
            return true;
        }

    }

    public void actionCarte(Joueur j, Carte c) {
        switch (c.getNumCarte()) {
            case 1:
                j.setCarteLibPrison(true);
                break;
            case 2:
                int pos = j.getPosition().getNumCarreau();
                switch (pos) {
                    case 3:
                        j.setPosition(getCarreau(40));
                        break;
                    case 2:
                        j.setPosition(getCarreau(39));
                        break;
                    case 1:
                        j.setPosition(getCarreau(38));
                        break;
                    default:
                        j.setPosition(getCarreau(pos - 3));
                        break;
                }
                if (j.getPosition() == getCarreau(11)) {
                    j.setPrison(true);
                }
                break;

            case 3:
                int houses = 0;
                int nbhot = 0;
                int prix;
                for (int i = 0; i < j.getProprietes().size(); i++) {
                    if (j.getProprietes().get(i).getHotel() != null) {
                        nbhot++;
                    }
                    houses = j.getProprietes().get(i).getPropriete().getMaisons().size() + houses;
                }
                prix = 40 * houses + 115 * nbhot;
                j.setSolde(j.getSolde() - prix);
                break;

            case 4:
                j.setSolde(j.getSolde() - 15);
                break;

            case 5:
                int mez = 0;
                int hots = 0;
                int cout;
                for (int i = 0; i < j.getProprietes().size(); i++) {
                    if (j.getProprietes().get(i).getHotel() != null) {
                        hots++;
                    }
                    mez = j.getProprietes().get(i).getPropriete().getMaisons().size() + mez;
                }
                cout = 40 * mez + 115 * hots;
                j.setSolde(j.getSolde() - cout);
                break;

            case 6:
                j.setSolde(j.getSolde() - 20);
                break;
            case 7:
                j.setPosition(getCarreau(1));
                break;
            case 8:
                j.setPosition(getCarreau(11));
                j.setPrison(true);
                break;
            case 9:
                if (passeParDepart(j, getCarreau(25))) {
                    j.setSolde(j.getSolde() + 200);
                }
                j.setPosition(getCarreau(25));
                break;
            case 10:
                if (passeParDepart(j, getCarreau(16))) {
                    j.setSolde(j.getSolde() + 200);
                }
                j.setPosition(getCarreau(16));
                break;

            case 11:
                j.setSolde(j.getSolde() - 150);
                break;
            case 12:
                j.setSolde(j.getSolde() + 100);
                break;
            case 13:
                j.setSolde(j.getSolde() + 50);
                break;
            case 14:
                if (passeParDepart(j, getCarreau(40))) {
                    j.setSolde(j.getSolde() + 200);
                }
                j.setPosition(getCarreau(40));
                break;
            case 15:
                j.setSolde(j.getSolde() + 150);
                break;
            case 16:
                if (passeParDepart(j, getCarreau(12))) {
                    j.setSolde(j.getSolde() + 200);
                }
                j.setPosition(getCarreau(12));
                break;
            case 17:
                j.setCarteLibPrison(true);
                break;

            case 18:
                j.setSolde(j.getSolde() - 10);
                break;
            case 19:
                j.setSolde(j.getSolde() + (this.getJoueurs().size() * 10));
                break;
            case 20:
                j.setSolde(j.getSolde() + 200);
                break;
            case 21:
                j.setPosition(getCarreau(2));
                break;
            case 22:
                j.setSolde(j.getSolde() - 50);
                break;
            case 23:
                j.setSolde(j.getSolde() + 20);
                break;
            case 24:
                j.setSolde(j.getSolde() - 100);
                break;
            case 25:
                j.setSolde(j.getSolde() + 100);
                break;
            case 26:
                j.setPosition(getCarreau(11));
                j.setPrison(true);
                break;
            case 27:
                j.setSolde(j.getSolde() - 50);
                break;
            case 28:
                j.setSolde(j.getSolde() + 50);
                break;
            case 29:
                j.setPosition(getCarreau(1));
                break;
            case 30:
                j.setSolde(j.getSolde() + 25);
                break;
            case 31:
                j.setSolde(j.getSolde() + 100);
                break;
            case 32:
                j.setSolde(j.getSolde() + 10);
                break;
            default:
                break;
        }

    }

    public boolean memeNbMaison(Terrain t, Joueur j) {
        boolean meme = false;
        Color coul = t.getPropriete().getCouleur();
        int nbMais = t.getPropriete().getMaisons().size();
        //a changer
        return false;

    }

    public int getNbMaisonsCouleur(Color c) {
        int nbMais = 0;
        ArrayList<Propriete> props = new ArrayList();
        for (int i = 0; i <= getCarreaux().size(); i++) {
            if (getCarreaux().get(i).getPropriete().getCouleur() == c) {
                props.add(getCarreaux().get(i).getPropriete());
            }
        }
        //a changer
        return 0;
    }

    @Override
    public void traiterMessage(Message m) {
        if (m.type == DEMARRER_PARTIE){
            commencerPartie(m);
        }else if (m.type == ARRETER){
            arreterPartie(m);
        }else if(m.type == RETOUR){
            retourMenu(m);
        }else if(m.type == REGLE){
            afficherRegles(m);
        }
    }

    

    public void setVuePlateau(VuePlateau vuePlateau) {
        this.vuePlateau = vuePlateau;
    }

    public void setVueMenu(VueMenu vueMenu) {
        this.vueMenu = vueMenu;
    }
    
    private void setVueRegle(VueRegle vueRegle) {
        this.vueRegle = vueRegle;
    }
    
    private void commencerPartie(Message m) {
        vueMenu.getFenetremenu().setVisible(false);
        this.setVuePlateau(new VuePlateau(m.noms));
        vuePlateau.addObservateur(this);
      /*  for(int i = 0; i<m.noms.size();i++){
            System.out.println(m.noms.get(i));
        }*/
    }
    
    private void arreterPartie(Message m) {
        vueMenu.getFenetremenu().setVisible(false);
        System.out.println("Jeu arrêté");
    }

    private void retourMenu(Message m) {
        vuePlateau.getFenetrePlateau().setVisible(false);
        this.setVueMenu(new VueMenu());
        vueMenu.addObservateur(this);
    }

    private void afficherRegles(Message m) {
        this.setVueRegle(new VueRegle());
    }

    
    
    

}
