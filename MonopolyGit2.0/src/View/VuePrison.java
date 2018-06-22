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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author faurepeq
 */
public class VuePrison extends Observe{
    private JFrame fenetrePrison;
    private Observateur o;
    
    public VuePrison(){
        //Fenêtre de prison
        fenetrePrison = new JFrame();
        fenetrePrison.setTitle( "Prison");
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
        
        fenetrePrison.add(infos,BorderLayout.CENTER);
        fenetrePrison.add(panelBouton,BorderLayout.SOUTH);
        fenetrePrison.add(titre, BorderLayout.NORTH);
        fenetrePrison.setVisible(true);
        
        
        //Listener menu
        payer.addActionListener((ActionEvent e) -> {

                    Message m = new Message();
                    m.type = TypesMessages.PAYER_50;
                    this.notifierObservateur(m);
        
        } );
                lancer.addActionListener((ActionEvent e) -> {

                    Message m = new Message();
                    m.type = TypesMessages.LANCER_DE;
                    this.notifierObservateur(m);
        
        } );
    
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
