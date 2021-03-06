/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controler.Message;
import Controler.Observateur;
import Enum.TypesMessages;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author tostonr
 */
public class IHM extends Observe {

    JFrame fenetre, fenetremenu, fenetreregles1, fenetreregles2;
    JTextField j1t, j2t, j3t, j4t, j5t, j6t;
    JLabel j1, j2, j3, j4, j5, j6;
    private Observateur o;
    JComboBox listeJoueurs;

    IHM() {
        fenetre = new JFrame();
        fenetre.setTitle("Monopoly");
        fenetre.setSize(1920, 1080);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel nom = new JLabel("Nom du joueur :");
        JLabel argent = new JLabel("Argent joueur :");
        JButton lancer = new JButton("Lancer les dès");
        JPanel des1 = new JPanel();
        //des1= new JPanel(new ImageIcon("/users/info/etu-s2/boedam/Downloads/dés.jpg"));

        //Intanciation des boutons
        JButton acheter = new JButton("Acheter");
        JButton b3 = new JButton("Construire");
        JButton b4 = new JButton("Bouton 4");
        JButton fin = new JButton("Fin du tour");
        JButton b5 = new JButton("Arrêter");
        JButton b6 = new JButton("Règles");

        b5.addActionListener((ActionEvent e) -> {
            fenetre.setVisible(false);
            fenetre.repaint();
            fenetremenu.setVisible(true);
            fenetremenu.repaint();
        });
        b6.addActionListener((ActionEvent) -> {
            fenetreregles1.setVisible(true);
        });
        JPanel pchoix = new JPanel(new GridLayout(0, 2));
        pchoix.add(b5);
        pchoix.add(b6);

        //instanciation des propriétés
        JTextField p1 = new JTextField("1");
        JTextField p2 = new JTextField("2");
        JTextField p3 = new JTextField("3");
        JTextField p4 = new JTextField("4");
        JTextField p5 = new JTextField("5");

        //Création du panel commande et ajout des différents composants 
        JPanel commande = new JPanel();
        JPanel commandeLayout = new JPanel();
        JPanel commandeScroll = new JPanel();
        JScrollPane pane = new JScrollPane(commandeScroll);

        commandeScroll.setLayout(new GridLayout(28, 0));
        commandeScroll.setPreferredSize(new Dimension(280, 1400));
        commande.setLayout(new GridLayout(6, 0));
        commande.setPreferredSize(new Dimension(300,500));
        commandeLayout.setLayout(new BorderLayout());
        commande.add(nom);
        commande.add(argent);
        commande.add(lancer);
        commande.add(acheter);
        commande.add(b3);
        //commande.add(b4);
        commande.add(fin);
        //ajout des propriété au menu déroulant
        commandeScroll.add(p1);
        commandeScroll.add(p2);
        commandeScroll.add(p3);
        commandeScroll.add(p4);
        commandeScroll.add(p5);
        //Mise en pages de la zone de commande 

        Dimension dim = new Dimension(300, 1080 - b5.getHeight());
        commandeLayout.setPreferredSize(dim);
        Border cadre = BorderFactory.createLineBorder(Color.black);
        commandeLayout.setBorder(cadre);
        commandeLayout.add(commande, BorderLayout.NORTH);
        commandeLayout.add(pane, BorderLayout.CENTER);
        commandeLayout.add(pchoix, BorderLayout.SOUTH);
        fenetre.add(commandeLayout, BorderLayout.WEST);

        //Création du plateau de jeu
        JPanel plateau = new JPanel();
        plateau.setLayout(new GridLayout(11, 11));
        //Boucle d'ajout des différentes cases
        for (int i = 1; i <= 121; i++) {
            JPanel car = new JPanel();
            car.setLayout(new BorderLayout());
            JPanel carLab = new JPanel();
            JPanel panelCase = new JPanel();
            panelCase.setLayout(new BorderLayout());
            JLabel infos = new JLabel();
            JLabel infos2 = new JLabel();
            JLabel lab = new JLabel();
            JLabel img = new JLabel();
            Font font1 = new Font("Arial", Font.BOLD, 22);
            Font font2 = new Font("Arial", Font.BOLD, 17);
            Font font3 = new Font("Arial", Font.BOLD, 28);
            Font font4 = new Font("Arial", Font.ITALIC, 10);
            Font font5 = new Font("Arial", Font.BOLD, 12);
            Font font6 = new Font("Arial", Font.BOLD, 14);
            Font font7 = new Font("Arial", Font.BOLD, 9);
            Font font8 = new Font("Arial", Font.BOLD, 46);
            Font fontcaisse = new Font("Arial", Font.BOLD, 14);
            Font fontchance = new Font("Arial", Font.BOLD, 20);

            switch (i) {
                //case chance et caisse de communauté
                case 81:
                    lab = new JLabel("Chance");
                    lab.setHorizontalAlignment(car.getWidth() / 2);
                    lab.setForeground(Color.black);
                    lab.setFont(font1);
                    car.add(lab);
                    plateau.add(car);
                    car.setBackground(Color.RED);
                    car.setBorder(cadre);
                    break;

                case 85:
                    lab = new JLabel("<html>Caisse de<br>communauté</html>");
                    lab.setHorizontalAlignment(car.getWidth() / 2);
                    lab.setForeground(Color.white);
                    lab.setFont(font2);
                    car.add(lab);
                    plateau.add(car);
                    car.setBackground(Color.BLUE);
                    car.setBorder(cadre);
                    break;

                //début du tour
                case 1:
                    img = new JLabel(new ImageIcon("Images/fleche.gif"));
                    lab = new JLabel("DEPART");
                    lab.setHorizontalAlignment(car.getWidth() / 2);
                    infos.setText("<html>+200€ à chaque<br> passage</html>");
                    infos.setFont(font4);
                    lab.setFont(font1);
                    car.add(lab, BorderLayout.NORTH);
                    car.add(infos, BorderLayout.CENTER);
                    car.add(img, BorderLayout.SOUTH);
                    plateau.add(car);
                    car.setBackground(Color.white);

                    break;

                case 2:
                    infos.setText("<html>Boulevard <br>de Belleville</html>");
                    infos2 = new JLabel("60€");
                    infos2.setHorizontalAlignment(car.getWidth() / 2);
                    infos.setHorizontalAlignment(car.getWidth() / 2);
                    car.add(infos, BorderLayout.CENTER);
                    car.add(infos2, BorderLayout.NORTH);
                    carLab.setBorder(cadre);
                    carLab.setBackground(Color.pink);
                    car.setBorder(cadre);
                    car.add(carLab, BorderLayout.SOUTH);
                    plateau.add(car);
                    car.setBackground(Color.white);
                    break;

                case 3:
                    infos.setText("<html>Caisse de Communauté</html>");
                    infos.setFont(fontcaisse);
                    infos.setForeground(Color.blue);
                    img = new JLabel(new ImageIcon("Images/caisse.jpg"));
                    car.add(infos, BorderLayout.NORTH);
                    car.add(img, BorderLayout.CENTER);
                    car.setBorder(cadre);
                    plateau.add(car);
                    car.setBackground(Color.white);
                    break;

                case 4:
                    infos.setText("<html>Rue Lecourbe</html>");
                    infos2 = new JLabel("60€");
                    infos2.setHorizontalAlignment(car.getWidth() / 2);
                    infos.setHorizontalAlignment(car.getWidth() / 2);
                    car.add(infos, BorderLayout.CENTER);
                    car.add(infos2, BorderLayout.NORTH);
                    carLab.setBorder(cadre);
                    carLab.setBackground(Color.pink);
                    car.setBorder(cadre);
                    car.add(carLab, BorderLayout.SOUTH);
                    plateau.add(car);
                    car.setBackground(Color.white);
                    break;

                case 5:
                    infos.setText("<html>IMPOTS SUR<br>LE REVENU</html>");
                    infos.setFont(font7);
                    infos2 = new JLabel("200€");
                    img = new JLabel(new ImageIcon("Images/impot.jpg"));
                    infos2.setHorizontalAlignment(car.getWidth() / 2);
                    infos.setHorizontalAlignment(car.getWidth() / 2);
                    car.add(infos, BorderLayout.SOUTH);
                    car.add(infos2, BorderLayout.NORTH);
                    car.add(img, BorderLayout.CENTER);
                    car.setBorder(cadre);
                    plateau.add(car);
                    car.setBackground(Color.white);
                    break;

                case 6:
                    infos.setText("<html>Gare Montparnasse</html>");
                    infos2 = new JLabel("200€");
                    img = new JLabel(new ImageIcon("Images/train.png"));
                    infos2.setHorizontalAlignment(car.getWidth() / 2);
                    infos.setHorizontalAlignment(car.getWidth() / 2);
                    car.add(infos, BorderLayout.SOUTH);
                    car.add(infos2, BorderLayout.NORTH);
                    car.add(img, BorderLayout.CENTER);
                    car.setBorder(cadre);
                    plateau.add(car);
                    car.setBackground(Color.white);
                    break;

                case 7:
                    infos.setText("<html>Rue de Vaugirard</html>");
                    infos2 = new JLabel("100€");
                    infos2.setHorizontalAlignment(car.getWidth() / 2);
                    infos.setHorizontalAlignment(car.getWidth() / 2);
                    car.add(infos, BorderLayout.CENTER);
                    car.add(infos2, BorderLayout.NORTH);
                    carLab.setBorder(cadre);
                    carLab.setBackground(Color.CYAN);
                    car.setBorder(cadre);
                    car.add(carLab, BorderLayout.SOUTH);
                    plateau.add(car);
                    car.setBackground(Color.white);
                    break;

                case 8:
                    infos.setText("<html>Chance</html>");
                    infos.setHorizontalAlignment(car.getWidth() / 2);
                    infos.setFont(fontchance);
                    infos.setForeground(Color.red);
                    img = new JLabel(new ImageIcon("Images/chance.jpeg"));
                    car.add(infos, BorderLayout.NORTH);
                    car.add(img, BorderLayout.CENTER);
                    car.setBorder(cadre);
                    plateau.add(car);
                    car.setBackground(Color.white);
                    break;

                case 9:
                    infos.setText("<html>Rue de Courcelles</html>");
                    infos2 = new JLabel("100€");
                    infos2.setHorizontalAlignment(car.getWidth() / 2);
                    infos.setHorizontalAlignment(car.getWidth() / 2);
                    car.add(infos, BorderLayout.CENTER);
                    car.add(infos2, BorderLayout.NORTH);
                    carLab.setBorder(cadre);
                    carLab.setBackground(Color.CYAN);
                    car.setBorder(cadre);
                    car.add(carLab, BorderLayout.SOUTH);
                    plateau.add(car);
                    car.setBackground(Color.white);
                    break;

                case 10:
                    infos.setText("<html>Avenue de la République</html>");
                    infos2 = new JLabel("120€");
                    infos2.setHorizontalAlignment(car.getWidth() / 2);
                    infos.setHorizontalAlignment(car.getWidth() / 2);
                    car.add(infos, BorderLayout.CENTER);
                    car.add(infos2, BorderLayout.NORTH);
                    carLab.setBorder(cadre);
                    carLab.setBackground(Color.CYAN);
                    car.setBorder(cadre);
                    car.add(carLab, BorderLayout.SOUTH);
                    plateau.add(car);
                    car.setBackground(Color.white);
                    break;

                case 11:
                    infos.setText("<html>SIMPLE VISITE</html>");
                    infos.setFont(font6);
                    infos2.setText("<html>PRISON</html>");
                    infos2.setFont(font5);
                    lab.setText("     ");
                    infos.setBorder(cadre);
                    lab.setBorder(cadre);
                    infos.setHorizontalAlignment(car.getWidth() / 2);
                    infos2.setHorizontalAlignment(car.getWidth() / 2);
                    img = new JLabel(new ImageIcon("Images/prison.jpg"));
                    img.setHorizontalAlignment(0);
                    car.setBorder(cadre);
                    car.add(lab, BorderLayout.EAST);
                    car.add(infos, BorderLayout.NORTH);
                    panelCase.add(img, BorderLayout.CENTER);
                    panelCase.add(infos2, BorderLayout.SOUTH);
                    panelCase.setBackground(Color.ORANGE);
                    car.add(panelCase, BorderLayout.CENTER);
                    car.setBorder(cadre);
                    plateau.add(car);
                    car.setBackground(Color.white);
                    break;

                case 12:
                    infos.setText("<html>Rue de la Paix</html>");
                    infos2 = new JLabel("400€");
                    infos2.setHorizontalAlignment(car.getWidth() / 2);
                    infos.setHorizontalAlignment(car.getWidth() / 2);
                    panelCase.add(infos, BorderLayout.CENTER);
                    panelCase.add(infos2, BorderLayout.NORTH);
                    carLab.setBorder(cadre);
                    carLab.setBackground(Color.blue);
                    car.setBorder(cadre);
                    car.add(carLab, BorderLayout.EAST);
                    car.add(panelCase, BorderLayout.CENTER);
                    plateau.add(car);
                    panelCase.setBackground(Color.white);
                    break;

                case 22:
                    infos.setText("<html>Boulevard de la Vilette</html>");
                    infos2 = new JLabel("140€");
                    infos2.setHorizontalAlignment(car.getWidth() / 2);
                    infos.setHorizontalAlignment(car.getWidth() / 2);
                    panelCase.add(infos, BorderLayout.CENTER);
                    panelCase.add(infos2, BorderLayout.NORTH);
                    carLab.setBorder(cadre);
                    carLab.setBackground(Color.MAGENTA);
                    car.setBorder(cadre);
                    car.add(carLab, BorderLayout.WEST);
                    car.add(panelCase, BorderLayout.CENTER);
                    plateau.add(car);
                    panelCase.setBackground(Color.white);
                    break;

                case 23:
                    infos.setText("<html>Taxe de luxe</html>");
                    infos2 = new JLabel("150€");
                    img = new JLabel(new ImageIcon("Images/luxe.jpg"));
                    infos.setHorizontalAlignment(car.getWidth() / 2);
                    infos2.setHorizontalAlignment(car.getWidth() / 2);
                    car.add(infos, BorderLayout.SOUTH);
                    car.add(infos2, BorderLayout.NORTH);
                    car.add(img, BorderLayout.CENTER);
                    car.setBorder(cadre);
                    plateau.add(car);
                    car.setBackground(Color.white);
                    break;

                case 33:
                    infos.setText("<html>Compagnie de distibution d'électricité</html>");
                    infos.setFont(font7);
                    infos2 = new JLabel("150€");
                    img = new JLabel(new ImageIcon("Images/elec.jpg"));
                    infos.setHorizontalAlignment(car.getWidth() / 2);
                    infos2.setHorizontalAlignment(car.getWidth() / 2);
                    car.add(infos, BorderLayout.SOUTH);
                    car.add(infos2, BorderLayout.NORTH);
                    car.add(img, BorderLayout.CENTER);
                    car.setBorder(cadre);
                    plateau.add(car);
                    car.setBackground(Color.white);
                    break;

                case 34:
                    infos.setText("<html>Avenue des Champs-<br>Elysées</html>");
                    infos2 = new JLabel("350€");
                    infos2.setHorizontalAlignment(car.getWidth() / 2);
                    infos.setHorizontalAlignment(car.getWidth() / 2);
                    panelCase.add(infos, BorderLayout.CENTER);
                    panelCase.add(infos2, BorderLayout.NORTH);
                    carLab.setBorder(cadre);
                    carLab.setBackground(Color.blue);
                    car.setBorder(cadre);
                    car.add(carLab, BorderLayout.EAST);
                    car.add(panelCase, BorderLayout.CENTER);
                    plateau.add(car);
                    panelCase.setBackground(Color.white);
                    break;

                case 39:
                    img = new JLabel(new ImageIcon("Images/monop.png"));
                    car.add(img, BorderLayout.SOUTH);
                    plateau.add(car);
                    break;
                case 44:
                    infos.setText("<html>Avenue de Neuilly</html>");
                    infos2 = new JLabel("140€");
                    infos2.setHorizontalAlignment(car.getWidth() / 2);
                    infos.setHorizontalAlignment(car.getWidth() / 2);
                    panelCase.add(infos, BorderLayout.CENTER);
                    panelCase.add(infos2, BorderLayout.NORTH);
                    carLab.setBorder(cadre);
                    carLab.setBackground(Color.MAGENTA);
                    car.setBorder(cadre);
                    car.add(carLab, BorderLayout.WEST);
                    car.add(panelCase, BorderLayout.CENTER);
                    plateau.add(car);
                    panelCase.setBackground(Color.white);
                    break;

                case 45:
                    infos.setText("<html>Chance</html>");
                    infos.setHorizontalAlignment(car.getWidth() / 2);
                    infos.setFont(fontchance);
                    infos.setForeground(Color.red);
                    img = new JLabel(new ImageIcon("Images/chance.jpeg"));
                    car.add(infos, BorderLayout.NORTH);
                    car.add(img, BorderLayout.CENTER);
                    car.setBorder(cadre);
                    plateau.add(car);
                    car.setBackground(Color.white);
                    break;
                    
                         //case centre
                case 49:
                    lab = new JLabel("IU");
                    lab.setFont(new Font("Arial",Font.BOLD,52));
                    lab.setForeground(Color.white);
                    car.setBackground(Color.red);
                    car.add(carLab,BorderLayout.CENTER);
                    car.add(lab,BorderLayout.EAST);
                    plateau.add(car);
                    break;
                    
                case 50:
                    lab = new JLabel("TPO");
                    lab.setFont(new Font("Arial",Font.BOLD,54));
                    lab.setForeground(Color.white);
                    car.setBackground(Color.red);
                    car.add(lab);
                    plateau.add(car);
                    break;
                    
                case 51:
                    lab = new JLabel("LY");
                    lab.setFont(new Font("Arial",Font.BOLD,52));
                    lab.setForeground(Color.white);
                    car.setBackground(Color.red);
                    car.add(carLab,BorderLayout.CENTER);
                    car.add(lab,BorderLayout.WEST);
                    plateau.add(car);
                    break;
               
                case 55:
                    infos.setText("<html>Rue de Paradis</html>");
                    infos2 = new JLabel("160€");
                    infos2.setHorizontalAlignment(car.getWidth() / 2);
                    infos.setHorizontalAlignment(car.getWidth() / 2);
                    panelCase.add(infos, BorderLayout.CENTER);
                    panelCase.add(infos2, BorderLayout.NORTH);
                    carLab.setBorder(cadre);
                    carLab.setBackground(Color.MAGENTA);
                    car.setBorder(cadre);
                    car.add(carLab, BorderLayout.WEST);
                    car.add(panelCase, BorderLayout.CENTER);
                    plateau.add(car);
                    panelCase.setBackground(Color.white);
                    break;

                case 56:
                    infos.setText("<html>Gare Saint-Lazare</html>");
                    infos2 = new JLabel("200€");
                    img = new JLabel(new ImageIcon("Images/train.png"));
                    infos2.setHorizontalAlignment(car.getWidth() / 2);
                    infos.setHorizontalAlignment(car.getWidth() / 2);
                    car.add(infos, BorderLayout.SOUTH);
                    car.add(infos2, BorderLayout.NORTH);
                    car.add(img, BorderLayout.CENTER);
                    car.setBorder(cadre);
                    plateau.add(car);
                    car.setBackground(Color.white);
                    break;

                case 66:
                    infos.setText("<html>Gare de Lyon</html>");
                    infos2 = new JLabel("200€");
                    img = new JLabel(new ImageIcon("Images/train.png"));
                    infos2.setHorizontalAlignment(car.getWidth() / 2);
                    infos.setHorizontalAlignment(car.getWidth() / 2);
                    car.add(infos, BorderLayout.SOUTH);
                    car.add(infos2, BorderLayout.NORTH);
                    car.add(img, BorderLayout.CENTER);
                    car.setBorder(cadre);
                    plateau.add(car);
                    car.setBackground(Color.white);
                    break;

                case 67:
                    infos.setText("<html>Boulevard des Capucines</html>");
                    infos2 = new JLabel("320€");
                    infos2.setHorizontalAlignment(car.getWidth() / 2);
                    infos.setHorizontalAlignment(car.getWidth() / 2);
                    panelCase.add(infos, BorderLayout.CENTER);
                    panelCase.add(infos2, BorderLayout.NORTH);
                    carLab.setBorder(cadre);
                    carLab.setBackground(Color.green);
                    car.setBorder(cadre);
                    car.add(carLab, BorderLayout.EAST);
                    car.add(panelCase, BorderLayout.CENTER);
                    plateau.add(car);
                    panelCase.setBackground(Color.white);
                    break;

                case 77:
                    infos.setText("<html>Avenue Mozart</html>");
                    infos2 = new JLabel("180€");
                    infos2.setHorizontalAlignment(car.getWidth() / 2);
                    infos.setHorizontalAlignment(car.getWidth() / 2);
                    panelCase.add(infos, BorderLayout.CENTER);
                    panelCase.add(infos2, BorderLayout.NORTH);
                    carLab.setBorder(cadre);
                    carLab.setBackground(Color.orange);
                    car.setBorder(cadre);
                    car.add(carLab, BorderLayout.WEST);
                    car.add(panelCase, BorderLayout.CENTER);
                    plateau.add(car);
                    panelCase.setBackground(Color.white);
                    break;

                case 78:
                    infos.setText("<html>Caisse de Communauté</html>");
                    infos.setFont(fontcaisse);
                    infos.setForeground(Color.blue);
                    img = new JLabel(new ImageIcon("Images/caisse.jpg"));
                    car.add(infos, BorderLayout.NORTH);
                    car.add(img, BorderLayout.CENTER);
                    car.setBorder(cadre);
                    plateau.add(car);
                    car.setBackground(Color.white);
                    break;

                case 88:
                    infos.setText("<html>Caisse de Communauté</html>");
                    infos.setFont(fontcaisse);
                    infos.setForeground(Color.blue);
                    img = new JLabel(new ImageIcon("Images/caisse.jpg"));
                    car.add(infos, BorderLayout.NORTH);
                    car.add(img, BorderLayout.CENTER);
                    car.setBorder(cadre);
                    plateau.add(car);
                    car.setBackground(Color.white);
                    break;

                case 89:
                    infos.setText("<html>Avenue Foch</html>");
                    infos2 = new JLabel("300€");
                    infos2.setHorizontalAlignment(car.getWidth() / 2);
                    infos.setHorizontalAlignment(car.getWidth() / 2);
                    panelCase.add(infos, BorderLayout.CENTER);
                    panelCase.add(infos2, BorderLayout.NORTH);
                    carLab.setBorder(cadre);
                    carLab.setBackground(Color.green);
                    car.setBorder(cadre);
                    car.add(carLab, BorderLayout.EAST);
                    car.add(panelCase, BorderLayout.CENTER);
                    plateau.add(car);
                    panelCase.setBackground(Color.white);
                    break;

                case 99:
                    infos.setText("<html>Boulevard Saint-Michel</html>");
                    infos2 = new JLabel("180€");
                    infos2.setHorizontalAlignment(car.getWidth() / 2);
                    infos.setHorizontalAlignment(car.getWidth() / 2);
                    panelCase.add(infos, BorderLayout.CENTER);
                    panelCase.add(infos2, BorderLayout.NORTH);
                    carLab.setBorder(cadre);
                    carLab.setBackground(Color.orange);
                    car.setBorder(cadre);
                    car.add(carLab, BorderLayout.WEST);
                    car.add(panelCase, BorderLayout.CENTER);
                    plateau.add(car);
                    panelCase.setBackground(Color.white);
                    break;

                case 100:
                    infos.setText("<html>Avenue<br>de Breteuil</html>");
                    infos2 = new JLabel("300€");
                    infos2.setHorizontalAlignment(car.getWidth() / 2);
                    infos.setHorizontalAlignment(car.getWidth() / 2);
                    panelCase.add(infos, BorderLayout.CENTER);
                    panelCase.add(infos2, BorderLayout.NORTH);
                    carLab.setBorder(cadre);
                    carLab.setBackground(Color.green);
                    car.setBorder(cadre);
                    car.add(carLab, BorderLayout.EAST);
                    car.add(panelCase, BorderLayout.CENTER);
                    plateau.add(car);
                    panelCase.setBackground(Color.white);
                    break;

                case 110:
                    infos.setText("<html>Place Pigalle</html>");
                    infos2 = new JLabel("200€");
                    infos2.setHorizontalAlignment(car.getWidth() / 2);
                    infos.setHorizontalAlignment(car.getWidth() / 2);
                    panelCase.add(infos, BorderLayout.CENTER);
                    panelCase.add(infos2, BorderLayout.NORTH);
                    carLab.setBorder(cadre);
                    carLab.setBackground(Color.orange);
                    car.setBorder(cadre);
                    car.add(carLab, BorderLayout.WEST);
                    car.add(panelCase, BorderLayout.CENTER);
                    plateau.add(car);
                    panelCase.setBackground(Color.white);
                    break;

                //case bas gauche   
                case 111:
                    infos.setText("<html>ALLER EN</html>");
                    infos2.setText("<html>PRISON</html>");
                    infos.setHorizontalAlignment(car.getWidth() / 2);
                    infos2.setHorizontalAlignment(car.getWidth() / 2);
                    img = new JLabel(new ImageIcon("Images/police.jpg"));
                    car.setBorder(cadre);
                    car.add(infos, BorderLayout.NORTH);
                    car.add(img, BorderLayout.CENTER);
                    car.add(infos2, BorderLayout.SOUTH);
                    car.setBorder(cadre);
                    plateau.add(car);
                    car.setBackground(Color.white);
                    break;

                case 112:
                    infos.setText("<html>Rue de la Fayette</html>");
                    infos2 = new JLabel("280€");
                    infos2.setHorizontalAlignment(car.getWidth() / 2);
                    infos.setHorizontalAlignment(car.getWidth() / 2);
                    car.add(infos, BorderLayout.CENTER);
                    car.add(infos2, BorderLayout.SOUTH);
                    carLab.setBorder(cadre);
                    carLab.setBackground(Color.yellow);
                    car.setBorder(cadre);
                    car.add(carLab, BorderLayout.NORTH);
                    plateau.add(car);
                    car.setBackground(Color.white);
                    break;

                case 113:
                    infos.setText("<html>Compagnie de distibution d'eau</html>");
                    infos2 = new JLabel("150€");
                    img = new JLabel(new ImageIcon("Images/eau.jpg"));
                    infos.setHorizontalAlignment(car.getWidth() / 2);
                    infos2.setHorizontalAlignment(car.getWidth() / 2);
                    car.add(infos, BorderLayout.NORTH);
                    car.add(infos2, BorderLayout.SOUTH);
                    car.add(img, BorderLayout.CENTER);
                    car.setBorder(cadre);
                    plateau.add(car);
                    car.setBackground(Color.white);
                    break;

                case 114:
                    infos.setText("<html>Place de la Bourse</html>");
                    infos2 = new JLabel("260€");
                    infos2.setHorizontalAlignment(car.getWidth() / 2);
                    infos.setHorizontalAlignment(car.getWidth() / 2);
                    car.add(infos, BorderLayout.CENTER);
                    car.add(infos2, BorderLayout.SOUTH);
                    carLab.setBorder(cadre);
                    carLab.setBackground(Color.yellow);
                    car.setBorder(cadre);
                    car.add(carLab, BorderLayout.NORTH);
                    plateau.add(car);
                    car.setBackground(Color.white);
                    break;

                case 115:
                    infos.setText("<html>Faubourg Saint-Honoré</html>");
                    infos2 = new JLabel("260€");
                    infos2.setHorizontalAlignment(car.getWidth() / 2);
                    infos.setHorizontalAlignment(car.getWidth() / 2);
                    car.add(infos, BorderLayout.CENTER);
                    car.add(infos2, BorderLayout.SOUTH);
                    carLab.setBorder(cadre);
                    carLab.setBackground(Color.yellow);
                    car.setBorder(cadre);
                    car.add(carLab, BorderLayout.NORTH);
                    plateau.add(car);
                    car.setBackground(Color.white);
                    break;

                case 116:
                    infos.setText("<html>Gare du Nord</html>");
                    infos2 = new JLabel("200€");
                    img = new JLabel(new ImageIcon("Images/train.png"));
                    infos2.setHorizontalAlignment(car.getWidth() / 2);
                    infos.setHorizontalAlignment(car.getWidth() / 2);
                    car.add(infos, BorderLayout.NORTH);
                    car.add(infos2, BorderLayout.SOUTH);
                    car.add(img, BorderLayout.CENTER);
                    car.setBorder(cadre);
                    plateau.add(car);
                    car.setBackground(Color.white);
                    break;

                case 117:
                    infos.setText("<html>Avenue Henri-Martin</html>");
                    infos2 = new JLabel("240€");
                    infos2.setHorizontalAlignment(car.getWidth() / 2);
                    infos.setHorizontalAlignment(car.getWidth() / 2);
                    car.add(infos, BorderLayout.CENTER);
                    car.add(infos2, BorderLayout.SOUTH);
                    carLab.setBorder(cadre);
                    carLab.setBackground(Color.red);
                    car.setBorder(cadre);
                    car.add(carLab, BorderLayout.NORTH);
                    plateau.add(car);
                    car.setBackground(Color.white);
                    break;

                case 118:
                    infos.setText("<html>Boulevard Malesherbes</html>");
                    infos2 = new JLabel("220€");
                    infos2.setHorizontalAlignment(car.getWidth() / 2);
                    infos.setHorizontalAlignment(car.getWidth() / 2);
                    car.add(infos, BorderLayout.CENTER);
                    car.add(infos2, BorderLayout.SOUTH);
                    carLab.setBorder(cadre);
                    carLab.setBackground(Color.red);
                    car.setBorder(cadre);
                    car.add(carLab, BorderLayout.NORTH);
                    plateau.add(car);
                    car.setBackground(Color.white);
                    break;

                case 119:
                    infos.setText("<html>Chance</html>");
                    infos.setHorizontalAlignment(car.getWidth() / 2);
                    infos.setFont(fontchance);
                    infos.setForeground(Color.red);
                    img = new JLabel(new ImageIcon("Images/chance.jpeg"));
                    car.add(infos, BorderLayout.NORTH);
                    car.add(img, BorderLayout.CENTER);
                    car.setBorder(cadre);
                    plateau.add(car);
                    car.setBackground(Color.white);
                    break;

                case 120:
                    infos.setText("<html>Avenue Matignon</html>");
                    infos2 = new JLabel("220€");
                    infos2.setHorizontalAlignment(car.getWidth() / 2);
                    infos.setHorizontalAlignment(car.getWidth() / 2);
                    car.add(infos, BorderLayout.CENTER);
                    car.add(infos2, BorderLayout.SOUTH);
                    carLab.setBorder(cadre);
                    carLab.setBackground(Color.red);
                    car.setBorder(cadre);
                    car.add(carLab, BorderLayout.NORTH);
                    plateau.add(car);
                    car.setBackground(Color.white);
                    break;

                case 121:
                    infos.setText("<html>PARC</html>");
                    infos2.setText("<html>GRATUIT</html>");
                    infos.setHorizontalAlignment(car.getWidth() / 2);
                    infos2.setHorizontalAlignment(car.getWidth() / 2);
                    img = new JLabel(new ImageIcon("Images/parc.htm"));
                    car.setBorder(cadre);
                    car.add(infos, BorderLayout.NORTH);
                    car.add(img, BorderLayout.CENTER);
                    car.add(infos2, BorderLayout.SOUTH);
                    plateau.add(car);
                    car.setBackground(Color.white);
                    break;

                default:
                    plateau.add(new JPanel());
                    break;
            }

        }

        plateau.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        fenetre.add(plateau, BorderLayout.CENTER);
        fenetre.setVisible(false);

        //Fenêtre de menu principal
        fenetremenu = new JFrame();
        fenetremenu.setTitle("Menu Monopoly");
        fenetremenu.setSize(400, 300);
        fenetremenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetremenu.setVisible(false);
        fenetremenu.setLayout(new BorderLayout());

        JLabel titre = new JLabel("Monopoly");
        fenetremenu.add(titre, BorderLayout.NORTH);
        titre.setHorizontalAlignment(JLabel.CENTER);

        JPanel panelCentre = new JPanel();
        panelCentre.setLayout(new GridLayout(9, 4));
        JLabel nbjoueurs = new JLabel("Joueurs : ");
        nbjoueurs.setHorizontalAlignment(JLabel.CENTER);
        listeJoueurs = new JComboBox();
        for (int i = 1; i < 6; i++) {
            listeJoueurs.addItem(i + 1);
        }

        //Listener sur la ComboBox pour afficher le nombre de joueurs 
        //à inscrire selon le nombre de joueurs choisi
        listeJoueurs.addActionListener((ActionEvent e) -> {
            if ("2".equals(listeJoueurs.getSelectedItem().toString())) {
                j3.setVisible(false);
                j4.setVisible(false);
                j5.setVisible(false);
                j6.setVisible(false);
                j3t.setVisible(false);
                j4t.setVisible(false);
                j5t.setVisible(false);
                j6t.setVisible(false);
            } else if ("3".equals(listeJoueurs.getSelectedItem().toString())) {
                j3.setVisible(true);
                j4.setVisible(false);
                j5.setVisible(false);
                j6.setVisible(false);
                j3t.setVisible(true);
                j4t.setVisible(false);
                j5t.setVisible(false);
                j6t.setVisible(false);
            } else if ("4".equals(listeJoueurs.getSelectedItem().toString())) {
                j3.setVisible(true);
                j4.setVisible(true);
                j5.setVisible(false);
                j6.setVisible(false);
                j3t.setVisible(true);
                j4t.setVisible(true);
                j5t.setVisible(false);
                j6t.setVisible(false);
            } else if ("5".equals(listeJoueurs.getSelectedItem().toString())) {
                j3.setVisible(true);
                j4.setVisible(true);
                j5.setVisible(true);
                j6.setVisible(false);
                j3t.setVisible(true);
                j4t.setVisible(true);
                j5t.setVisible(true);
                j6t.setVisible(false);
            } else {
                j3.setVisible(true);
                j4.setVisible(true);
                j5.setVisible(true);
                j6.setVisible(true);
                j3t.setVisible(true);
                j4t.setVisible(true);
                j5t.setVisible(true);
                j6t.setVisible(true);
            }
        });

        //Instanciation des JLabels et JTextfiels pour le nombre de joueurs ainsi 
        //que leur visibilité pour nombre de joueurs par défault=2
        j1 = new JLabel("Joueur 1 :");
        j2 = new JLabel("Joueur 2 :");
        j3 = new JLabel("Joueur 3 :");
        j3.setVisible(false);
        j4 = new JLabel("Joueur 4 :");
        j4.setVisible(false);
        j5 = new JLabel("Joueur 5 :");
        j5.setVisible(false);
        j6 = new JLabel("Joueur 6 :");
        j6.setVisible(false);

        j1t = new JTextField();
        j2t = new JTextField();
        j3t = new JTextField();
        j3t.setVisible(false);
        j4t = new JTextField();
        j4t.setVisible(false);
        j5t = new JTextField();
        j5t.setVisible(false);
        j6t = new JTextField();
        j6t.setVisible(false);

        //Ajout des joueurs dans le gridLayout
        for (int i = 0; i < 36; i++) {
            switch (i) {
                case 5:
                    panelCentre.add(nbjoueurs);
                    break;
                case 6:
                    panelCentre.add(listeJoueurs);
                    break;
                case 9:
                    panelCentre.add(j1);
                    break;
                case 10:
                    panelCentre.add(j1t);
                    break;
                case 13:
                    panelCentre.add(j2);
                    break;
                case 14:
                    panelCentre.add(j2t);
                    break;
                case 17:
                    panelCentre.add(j3);
                    break;
                case 18:
                    panelCentre.add(j3t);
                    break;
                case 21:
                    panelCentre.add(j4);
                    break;
                case 22:
                    panelCentre.add(j4t);
                    break;
                case 25:
                    panelCentre.add(j5);
                    break;
                case 26:
                    panelCentre.add(j5t);
                    break;
                case 29:
                    panelCentre.add(j6);
                    break;
                case 30:
                    panelCentre.add(j6t);
                    break;
                default:
                    panelCentre.add(new JLabel());
                    break;
            }
        }

        fenetremenu.add(panelCentre, BorderLayout.CENTER);

        JPanel panelBas = new JPanel();
        panelBas.setLayout(new GridLayout(0, 2));
        JButton commencer = new JButton("Commencer");
        JButton arreter = new JButton("Arrêter");
        panelBas.add(commencer);
        panelBas.add(arreter);

        fenetremenu.add(panelBas, BorderLayout.SOUTH);

        //Listener menu
        commencer.addActionListener((ActionEvent e) -> {
            fenetremenu.setVisible(false);
            fenetre.setVisible(true);
            fenetre.repaint();

            Message m = new Message();
            
            ArrayList<String> noms = new ArrayList<>();
            noms.add(j1t.getText());
            noms.add(j2t.getText());
            if (j3t.getText() != null) {
                noms.add(j3t.getText());
            }
            if (j4t.getText() != null) {
                noms.add(j4t.getText());
            }
            if (j5t.getText() != null) {
                noms.add(j5t.getText());
            }
            if (j6t.getText() != null) {
                noms.add(j6t.getText());
            }
            m.noms = noms;
            m.type = TypesMessages.DEMARRER_PARTIE;
            this.notifierObservateur(m);
        });

        arreter.addActionListener((ActionEvent e) -> {
            fenetremenu.setVisible(false);
            fenetremenu.disable();
        });

        //fenetre regles1
        fenetreregles1 = new JFrame();
        fenetreregles1.setTitle("Règles Monopoly");
        fenetreregles1.setSize(600, 950);
        fenetreregles1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetreregles1.setVisible(false);

        JLabel teteRegles = new JLabel("Règles du Monopoly");
        fenetreregles1.add(teteRegles, BorderLayout.NORTH);
        teteRegles.setHorizontalAlignment(JLabel.CENTER);

        JLabel regle1 = new JLabel("<html> <h2>I.Préparation</h2> "
                + "<p>1. Chaque joueur choisit un pion et le place sur la case numéro 1. </p> <br>"
                + "<p>2. Le  Banquier  remet  à  chaque  joueur  une  somme  de 1500  euros. La  banque  possède  les Titres de  Propriété ."
                + "La  Banque  encaisse  l'argent de  la  vente  des  titres  de  propriété. La  Banque  ne peut jamais faire faillite(on supposera"
                + "qu'elle détient une quantité infinie d'argent)</p> <br>"
                + "<p>3. Les joueurs jouent dans l'ordre de leur placement.</p> <br>"
                + "<h2>II.Déroulement d'un tour de jeu</h2>"
                + "<p>Quand arrive votre tour de jeu, lancez les 2 dés puis avancez votre pion sur le plateau de jeu, d'autant de cases que l'indique"
                + "le total des dés, et dans le sens indiqué par la flèche. La case sur laquelle vous vous arrêtez vous indique ce que vous devez ou pouvez"
                + "faire. Deux pions ou plus peuvent se trouver sur la même case a même moment. Suivant la nature de la case sur laquelle vous êtes arrivé, "
                + "vous pouvez effectuer l'une des opérations suivantes : <br>"
                + "<b>. acheter un terrain ou une autre propriété <br>"
                + ". payer un loyer (si la propriété appartient à un autre joueur)</b><br>"
                + "Lorsque vous avez terminé votre tour, ce sera au joueur situé à votre gauche de joueur.</p>"
                + "<h4>1. Les doubles</h4>"
                + "<p>Si  vous  obtenez  un  double  avec  les  dés, déplacez vous  normalement.  Effectuez  l'opération  de votre case d'arrivée, puis "
                + "relancez les dés et déplacez vous à nouveau. Vous effectuerez alors une nouvelle opération. </p> <br>"
                + "<h4>2. Arrêt sur une propriété à vendre</h4>"
                + "<p>Si vous vous arrêtez sur une propriété qui n'appartient à personne (c'est à dire une propriété dont aucun  joueur  ne  possède  le"
                + "titre  de propriété),  vous  pouvez  décider  de  l'acheter.  Dans  ce cas, payez à la Banque le prix indiqué sur le plateau."
                + " La Banque vous donnera alors, en échange, le titre de propriété correspondant.</p> <br>"
                + "<h4>3. Posséder une propriété</h4>"
                + "<p>Posséder une propriété vous donne le droit de percevoir un loyer de la part des joueurs qui vont s'arrêter sur cette propriété.</p><br>"
                + "<h4>4. Arrêt sur une propriété privée</h4>"
                + "<p>Quand  vous  vous  arrêtez  sur  une  Propriété  qui  a  été  achetée  par  un  autre  joueur, vous devez payer  un  loyer  au "
                + "propriétair.  Le  montant  du  loyer  figure  sur  le titre  de propriété.  Si  un  joueur possède tous les terrains d'une même"
                + " couleur, la valeur du loyer du terrain nu est alors multipliée par deux. </p> <br>"
                + "<h4>5. Arrêt sur les cases COMPAGNIE DE DISTRIBUTION</h4>"
                + "<p>Quand  vous  vous  arrêtez  sur  une  de  ces  cases,  vous  pouvez  l'acheter  si  cette  Compagnie  de Distribution  n'appartient"
                + "  à  personne.  Comme  pour  les  Propriétés,  payez  à  la  Banque  le  prix indiqué  sur  le  plateau.  Si  la  Compagnie  de "
                + " Distribution  appartient  déjà  à  l'un  des  joueurs, vous devez payer un loyer, qui est fonction des points indiqués par"
                + " vos dés :</p> <br></html>");
        fenetreregles1.add(regle1, BorderLayout.CENTER);

        JButton retour = new JButton("Retour au jeu");
        JButton nextpage = new JButton("Page Suivante");
        JPanel pbas = new JPanel(new GridLayout(0, 2));
        pbas.add(retour);
        pbas.add(nextpage);
        fenetreregles1.add(pbas, BorderLayout.SOUTH);

        //fenetre regles2
        fenetreregles2 = new JFrame();
        fenetreregles2.setTitle("Règles Monopoly (suite)");
        fenetreregles2.setSize(600, 500);
        fenetreregles2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetreregles2.setVisible(false);

        JLabel teteRegles2 = new JLabel("Règles du Monopoly (suite)");
        fenetreregles2.add(teteRegles2, BorderLayout.NORTH);
        teteRegles2.setHorizontalAlignment(JLabel.CENTER);

        JLabel regle2 = new JLabel("<html><p>Si ce propriétaire possède une Compagnie de Distribution, le loyer sera égal à quatre fois"
                + " la valeur de vos dés</p> <br>"
                + "<p>S'il possède les deux Compagnies de Distribution, le loyer s'élèvera alors à dix fois la valeur indiquée par les dés.</p> <br>"
                + "<h4>6. Arrêt sur une gare</h4>"
                + "<p>Si vous êtes le premier joueur à vous arrêter sur une case Gare, vous pouvez décider de l'acheter. Si  la gare a  déjà  "
                + "été  achetée,  vous devez  payer au propriétaire  le montant  indiqué  sur  le titre  de propriété. Le loyer varie en "
                + "fonction du nombre total de Gares possédées par ce joueur.</p>< <br>"
                + "<h4>7. Faillite</h4>"
                + "<p>Si vous ne possédez plus d'argent, vous êtes en faillite et vous devez alors vous retirer du jeu. Tous vos  biens "
                + " (argent,  titres de propriété)  sont  remis à la  banque.  Les  titres  de  propriété  sont  à nouveau disponibles dans"
                + " les conditions initiales du jeu.</p> <br>"
                + "<h4>8. Le vainqueur</h4>"
                + "<p>Le dernier joueur restant en jeu est le vainqueur.</p></html>");
        fenetreregles2.add(regle2, BorderLayout.CENTER);

        JButton retour2 = new JButton("Retour au jeu");
        JButton retourpage = new JButton("Page précédente");
        JPanel pbas2 = new JPanel(new GridLayout(0, 2));
        pbas2.add(retourpage);
        pbas2.add(retour2);
        fenetreregles2.add(pbas2, BorderLayout.SOUTH);

        //Listener regles
        retour.addActionListener((ActionEvent e) -> {
            fenetreregles1.setVisible(false);
            fenetreregles2.setVisible(false);
        });
        retour2.addActionListener((ActionEvent e) -> {
            fenetreregles1.setVisible(false);
            fenetreregles2.setVisible(false);
        });
        nextpage.addActionListener((ActionEvent e) -> {
            fenetreregles1.setVisible(false);
            fenetreregles2.setVisible(true);
        });
        retourpage.addActionListener((ActionEvent e) -> {
            fenetreregles2.setVisible(false);
            fenetreregles1.setVisible(true);
        });
    }

    public void fenetrePlateau() {
        fenetre.setVisible(true);
    }

    public void fenetreMenu() {
        fenetremenu.setVisible(true);
    }

    @Override
    public void addObservateur(Observateur o) {
        this.o = o;
    }

    @Override
    public void notifierObservateur(Message m) {
        if (o != null) {
            o.traiterMessage(m);
        }
    }

}
