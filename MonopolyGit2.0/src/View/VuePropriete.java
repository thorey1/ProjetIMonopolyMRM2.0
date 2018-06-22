/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controler.Message;
import Controler.Observateur;
import Enum.TypeCarreau;
import Enum.TypesMessages;
import static Enum.TypesMessages.*;
import static Enum.TypesMessages.DEMARRER_PARTIE;
import Model.Joueur;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author faurepeq
 */
public class VuePropriete extends Observe {

    private JFrame fenetrePrison, fenetreProp;
    private Observateur o;

    public VuePropriete(Joueur j, String nom, int prix, int loyer) {
        //Fenêtre propriété
        fenetreProp = new JFrame();
        fenetreProp.setTitle("Propriété");
        fenetreProp.setSize(700, 300);
        fenetreProp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetreProp.setLayout(new BorderLayout());
        fenetreProp.setVisible(true);
        JLabel titre = new JLabel("Propriété");
        titre.setHorizontalAlignment(JLabel.CENTER);

        JButton achat = new JButton("Acheter");
        JButton pasachat = new JButton("Ne pas acheter");
        JButton payer = new JButton("Payer loyer");
        JLabel infos = new JLabel();
        JLabel infos2 = new JLabel();
        JPanel panel, panel2;

        if (j != null) {
            infos.setText("Vous êtes sur la propriété : " + nom + ". Elle appartient à : " + j.getNomJoueur() + ". \n Vous lui devez " + loyer);
            fenetreProp.add(titre, BorderLayout.NORTH);
            fenetreProp.add(infos, BorderLayout.CENTER);
            fenetreProp.add(payer, BorderLayout.SOUTH);
        } else {
            infos.setText("Vous êtes sur la propriété : " + nom + ". Elle n'appartient à personne.");
            infos2.setText("Elle coûte " + prix + ". Souhaitez-vous l'acheter?");
            fenetreProp.add(titre, BorderLayout.NORTH);
            panel = new JPanel(new GridLayout(2, 0));
            panel.add(infos);
            panel.add(infos2);
            fenetreProp.add(panel, BorderLayout.CENTER);
            panel2 = new JPanel(new GridLayout(0, 2));
            panel2.add(achat);
            panel2.add(pasachat);
            fenetreProp.add(panel2, BorderLayout.SOUTH);
        }

        //Listener boutons
        achat.addActionListener((ActionEvent) -> {
            Message m = new Message();
            m.type = ACHAT;
            fenetreProp.setVisible(false);
            notifierObservateur(m);
        });

        pasachat.addActionListener((ActionEvent) -> {
            fenetreProp.setVisible(false);
        });

        payer.addActionListener((ActionEvent) -> {
            Message m = new Message();
            m.type = LOYER;
            fenetreProp.setVisible(false);
            notifierObservateur(m);
        });
    }

    private void vuePrison() {
        //Fenêtre de prison
        fenetrePrison = new JFrame();
        fenetrePrison.setTitle("Prison");
        fenetrePrison.setSize(400, 300);
        fenetrePrison.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetrePrison.setLayout(new BorderLayout());
        JLabel titre = new JLabel("PRISON");
        titre.setHorizontalAlignment(JLabel.CENTER);

        JButton payer = new JButton("PAYER 50€");
        JButton lancer = new JButton("Lancer les dés");
        JLabel infos = new JLabel("<html>Vous êtes en prison, pour sortir vous pouvez choisir entre payer 50€ ou lancer les dés afin de faire un DOUBLE.Une fois "
                + "libéré vous serez envoyer sur le coté de la case en 'Simple visite' et vous attendrez le prochain tour pour avancer.</html>");
        JPanel panelBouton = new JPanel(new GridLayout(0, 2));

        panelBouton.add(payer);
        panelBouton.add(lancer);

        fenetrePrison.add(infos, BorderLayout.CENTER);
        fenetrePrison.add(panelBouton, BorderLayout.SOUTH);
        fenetrePrison.add(titre, BorderLayout.NORTH);
        fenetrePrison.setVisible(true);

        //Listener menu
        payer.addActionListener((ActionEvent e) -> {
            Message m = new Message();
            m.type = TypesMessages.PAYER_50;
            this.notifierObservateur(m);

        });
        lancer.addActionListener((ActionEvent e) -> {
            Message m = new Message();
            m.type = TypesMessages.LANCER_DE;
            this.notifierObservateur(m);

        });
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

    public JFrame getFenetremenu() {
        return getFenetrePrison();
    }

    /**
     * @return the fenetrePrison
     */
    public JFrame getFenetrePrison() {
        return fenetrePrison;
    }
}
