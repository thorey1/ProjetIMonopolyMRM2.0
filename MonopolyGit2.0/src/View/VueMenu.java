/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controler.Message;
import Controler.Observateur;
import static Enum.TypesMessages.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author boedam
 */
public class VueMenu extends Observe {

    private JTextField j1t, j2t, j3t, j4t, j5t, j6t;
    private JLabel j1, j2, j3, j4, j5, j6;
    private JFrame fenetremenu;
    private JComboBox listeJoueurs;
    private Observateur o;
    public VueMenu() {
        //Fenêtre de menu principal
        fenetremenu = new JFrame();

        fenetremenu.setTitle(
                "Menu Monopoly");
        fenetremenu.setSize(
                400, 300);
        fenetremenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fenetremenu.setVisible(
                false);
        fenetremenu.setLayout(
                new BorderLayout());

        JLabel titre = new JLabel("Monopoly");

        fenetremenu.add(titre, BorderLayout.NORTH);

        titre.setHorizontalAlignment(JLabel.CENTER);

        JPanel panelCentre = new JPanel();

        panelCentre.setLayout(
                new GridLayout(9, 4));
        JLabel nbjoueurs = new JLabel("Joueurs : ");

        nbjoueurs.setHorizontalAlignment(JLabel.CENTER);
        listeJoueurs = new JComboBox();
        for (int i = 1;
                i < 6; i++) {
            listeJoueurs.addItem(i + 1);
        }

        //Listener sur la ComboBox pour afficher le nombre de joueurs 
        //à inscrire selon le nombre de joueurs choisi
        listeJoueurs.addActionListener(
                (ActionEvent e) -> {
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
                }
        );

        //Instanciation des JLabels et JTextfiels pour le nombre de joueurs ainsi 
        //que leur visibilité pour nombre de joueurs par défault=2
        j1 = new JLabel("Joueur 1 :");
        j2 = new JLabel("Joueur 2 :");
        j3 = new JLabel("Joueur 3 :");

        j3.setVisible(
                false);
        j4 = new JLabel("Joueur 4 :");

        j4.setVisible(
                false);
        j5 = new JLabel("Joueur 5 :");

        j5.setVisible(
                false);
        j6 = new JLabel("Joueur 6 :");

        j6.setVisible(
                false);

        j1t = new JTextField();
        j2t = new JTextField();
        j3t = new JTextField();

        j3t.setVisible(
                false);
        j4t = new JTextField();

        j4t.setVisible(
                false);
        j5t = new JTextField();

        j5t.setVisible(
                false);
        j6t = new JTextField();

        j6t.setVisible(
                false);

        //Ajout des joueurs dans le gridLayout
        for (int i = 0;
                i < 36; i++) {
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

        panelBas.setLayout(
                new GridLayout(0, 2));
        JButton commencer = new JButton("Commencer");
        JButton arreter = new JButton("Arrêter");

        panelBas.add(commencer);

        panelBas.add(arreter);

        fenetremenu.add(panelBas, BorderLayout.SOUTH);

        //Listener menu
        commencer.addActionListener(
                (ActionEvent e) -> {
                    fenetremenu.setVisible(false);
               //     fenetre.setVisible(true);
               //     fenetre.repaint();

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
                    m.type = DEMARRER_PARTIE;
                    this.notifierObservateur(m);
                }
        );

        arreter.addActionListener(
                (ActionEvent e) -> {
                    fenetremenu.setVisible(false);
                    fenetremenu.disable();
                }
        );
        
        
        fenetremenu.setVisible(true);
    }

    @Override
    public void addObservateur(Observateur o) {
        this.o=o;
    }

    @Override
    public void notifierObservateur(Message m) {
        if (o != null) {
            o.traiterMessage(m);
        }
    }

    public JFrame getFenetremenu() {
        return fenetremenu;
    }
    
    

}
