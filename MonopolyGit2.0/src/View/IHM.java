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
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author tostonr
 */
public class IHM implements Observe{
    JFrame fenetre,fenetremenu,fenetreregles;
    private Observateur o;
    JComboBox listeJoueurs;
    
    
    IHM(){
        fenetre = new JFrame();
        fenetre.setTitle("Monopoly");
        fenetre.setSize(1920, 1080);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel nom = new JLabel("Nom du joueur :");
        JLabel argent = new JLabel("Argent joueur :");
        JButton lancer = new JButton("Lancer les dès");
        JPanel des1=new JPanel();
        //des1= new JPanel(new ImageIcon("/users/info/etu-s2/boedam/Downloads/dés.jpg"));
        JButton acheter = new JButton("Acheter");
        JButton b3 = new JButton("Bouton 3");
        JButton b4 = new JButton("Bouton 4");
        JButton fin = new JButton("Fin du tour");
        JTextField p1 = new JTextField("Propriété 1");
        JTextField p2 = new JTextField("Propriété 2");
        JTextField p3 = new JTextField("Propriété 3");
        JTextField p4 = new JTextField("Propriété 4");
        JTextField p5 = new JTextField("Propriété 5");
        JButton b5 = new JButton("Arrêter");
        JPanel commande = new JPanel();
        commande.setLayout(new GridLayout(13,0));
        commande.add(nom);
        commande.add(argent);
        commande.add(lancer);
        commande.add(acheter);
        commande.add(b3);
        commande.add(b4);
        commande.add(fin);
        commande.add(p1);
        commande.add(p2);
        commande.add(p3);
        commande.add(p4);
        commande.add(p5);
        commande.add(b5);
        
        b5.addActionListener((ActionEvent e) -> {
            fenetre.setVisible(false);
            fenetre.repaint();
            fenetremenu.setVisible(true);
            fenetremenu.repaint();
        });
        
        Dimension dim = new Dimension(300,1080);
        commande.setPreferredSize(dim);
        Border cadre = BorderFactory.createLineBorder(Color.black);
        commande.setBorder(cadre);
        fenetre.add(commande, BorderLayout.WEST);





        JPanel plateau = new JPanel();

        plateau.setLayout(new GridLayout(11,11));





        for( int i = 1; i <= 121;i++){
            JPanel car = new JPanel();
            JPanel carLab = new JPanel();
            JLabel infos = new JLabel();
            JLabel infos2 = new JLabel();
            JLabel lab = new JLabel();
            Dimension dim2;
            Dimension dim3;

            switch(i){
                case 1 : car.setLayout(new BorderLayout());
                          lab = new JLabel(new ImageIcon("/users/info/etu-s2/boedam/Downloads/index.jpeg"));
                          dim2 = new Dimension(100,100);
                          lab.setSize(dim2);
                          car.add(lab);
                          plateau.add(car);
                          break;   

                case 2 : car.setLayout(new BorderLayout());


                          infos.setText("<html>Boulevard <br>de Belleville</html>");
                          infos2 = new JLabel("60€");
                          infos2.setHorizontalAlignment(car.getWidth()/2);
                          infos.setHorizontalAlignment(car.getWidth()/2);
                          car.add(infos,BorderLayout.CENTER);
                          car.add(infos2,BorderLayout.NORTH);  
                          carLab.setBorder(cadre);
                          carLab.setBackground(Color.pink);
                          car.setBorder(cadre);
                          car.add(carLab, BorderLayout.SOUTH);
                          plateau.add(car);
                          break;

                case 3 : car.setLayout(new BorderLayout());

                          car.setBorder(cadre);
                          car.add(carLab, BorderLayout.SOUTH);
                          plateau.add(car);
                          break; 

                 case 4 : car.setLayout(new BorderLayout());
                          infos.setText("<html>Rue Lecourbe</html>");
                          infos2 = new JLabel("60€");
                          infos2.setHorizontalAlignment(car.getWidth()/2);
                          infos.setHorizontalAlignment(car.getWidth()/2);
                          car.add(infos,BorderLayout.CENTER);
                          car.add(infos2,BorderLayout.NORTH); 
                          carLab.setBorder(cadre);
                          carLab.setBackground(Color.pink);
                          car.setBorder(cadre);
                          car.add(carLab, BorderLayout.SOUTH);
                          plateau.add(car);
                          break;

                 case 5 : car.setLayout(new BorderLayout());

                          car.setBorder(cadre);
                          car.add(carLab, BorderLayout.SOUTH);
                          plateau.add(car);
                          break;
                 case 6 : car.setLayout(new BorderLayout());
                         infos.setText("<html>Gare Montparnasse</html>");
                          infos2 = new JLabel("200€");
                          infos2.setHorizontalAlignment(car.getWidth()/2);
                          infos.setHorizontalAlignment(car.getWidth()/2);
                          car.add(infos,BorderLayout.CENTER);
                          car.add(infos2,BorderLayout.NORTH);
                          car.setBorder(cadre);
                          car.add(carLab, BorderLayout.SOUTH);
                          plateau.add(car);
                          break;

                 case 7 : car.setLayout(new BorderLayout());
                         infos.setText("<html>Rue de Vaugirard</html>");
                          infos2 = new JLabel("100€");
                          infos2.setHorizontalAlignment(car.getWidth()/2);
                          infos.setHorizontalAlignment(car.getWidth()/2);
                          car.add(infos,BorderLayout.CENTER);
                          car.add(infos2,BorderLayout.NORTH);
                          carLab.setBorder(cadre);
                          carLab.setBackground(Color.CYAN);
                          car.setBorder(cadre);
                          car.add(carLab, BorderLayout.SOUTH);
                          plateau.add(car);
                          break;

                 case 8 : car.setLayout(new BorderLayout());
                          car.setBorder(cadre);
                          car.add(carLab, BorderLayout.SOUTH);
                          plateau.add(car);
                          break;

                 case 9 : car.setLayout(new BorderLayout());
                 infos.setText("<html>Rue de Courcelles</html>");
                          infos2 = new JLabel("100€");
                          infos2.setHorizontalAlignment(car.getWidth()/2);
                          infos.setHorizontalAlignment(car.getWidth()/2);
                          car.add(infos,BorderLayout.CENTER);
                          car.add(infos2,BorderLayout.NORTH);
                          carLab.setBorder(cadre);
                          carLab.setBackground(Color.CYAN);
                          car.setBorder(cadre);
                          car.add(carLab, BorderLayout.SOUTH);
                          plateau.add(car);
                          break;   

                 case 10 : car.setLayout(new BorderLayout());
                 infos.setText("<html>Avenue de la République</html>");
                          infos2 = new JLabel("120€");
                          infos2.setHorizontalAlignment(car.getWidth()/2);
                          infos.setHorizontalAlignment(car.getWidth()/2);
                          car.add(infos,BorderLayout.CENTER);
                          car.add(infos2,BorderLayout.NORTH);
                          carLab.setBorder(cadre);
                          carLab.setBackground(Color.CYAN);
                          car.setBorder(cadre);
                          car.add(carLab, BorderLayout.SOUTH);
                          plateau.add(car);
                          break;

                 case 11 : car.setLayout(new BorderLayout());

                          car.setBorder(cadre);
                          car.add(carLab, BorderLayout.SOUTH);
                          plateau.add(car);
                          break;

                 case 12 : car.setLayout(new BorderLayout());
                             infos.setText("<html>Rue de la Paix</html>");
                          infos2 = new JLabel("400€");
                          infos2.setHorizontalAlignment(car.getWidth()/2);
                          infos.setHorizontalAlignment(car.getWidth()/2);
                          car.add(infos,BorderLayout.CENTER);
                          car.add(infos2,BorderLayout.CENTER);
                          carLab.setBorder(cadre);
                          carLab.setBackground(Color.blue);
                          car.setBorder(cadre);
                          car.add(carLab, BorderLayout.EAST);
                          plateau.add(car);
                          break;
                 case 22 : car.setLayout(new BorderLayout());
                 infos.setText("<html>Boulevard de la Vilette</html>");
                          infos2 = new JLabel("140€");
                          infos2.setHorizontalAlignment(car.getWidth()/2);
                          infos.setHorizontalAlignment(car.getWidth()/2);
                          car.add(infos,BorderLayout.CENTER);
                          car.add(infos2,BorderLayout.NORTH);
                          carLab.setBorder(cadre);
                          carLab.setBackground(Color.MAGENTA);
                          car.setBorder(cadre);
                          car.add(carLab, BorderLayout.WEST);
                          plateau.add(car);
                          break;   

                case 23 : car.setLayout(new BorderLayout());

                          car.setBorder(cadre);
                          car.add(carLab, BorderLayout.EAST);
                          plateau.add(car);
                          break;
                case 33 : car.setLayout(new BorderLayout());

                          car.setBorder(cadre);
                          car.add(carLab, BorderLayout.WEST);
                          plateau.add(car);
                          break;   
                 case 34 : car.setLayout(new BorderLayout());
                 infos.setText("<html>Avenue des Champs-Elysées</html>");
                          infos2 = new JLabel("350€");
                          infos2.setHorizontalAlignment(car.getWidth()/2);
                          infos.setHorizontalAlignment(car.getWidth()/2);
                          car.add(infos,BorderLayout.CENTER);
                          car.add(infos2,BorderLayout.NORTH);
                          carLab.setBorder(cadre);
                          carLab.setBackground(Color.blue);
                          car.setBorder(cadre);
                          car.add(carLab, BorderLayout.EAST);
                          plateau.add(car);
                          break;

                 case 44 : car.setLayout(new BorderLayout());
                 infos.setText("<html>Avenue de Neuilly</html>");
                          infos2 = new JLabel("140€");
                          infos2.setHorizontalAlignment(car.getWidth()/2);
                          infos.setHorizontalAlignment(car.getWidth()/2);
                          car.add(infos,BorderLayout.CENTER);
                          car.add(infos2,BorderLayout.NORTH);
                          carLab.setBorder(cadre);
                          carLab.setBackground(Color.MAGENTA);
                          car.setBorder(cadre);
                          car.add(carLab, BorderLayout.WEST);
                          plateau.add(car);
                          break;

                 case 45 : car.setLayout(new BorderLayout());
                          car.setBorder(cadre);
                          car.add(carLab, BorderLayout.EAST);
                          plateau.add(car);
                          break;   
                 case 55 : car.setLayout(new BorderLayout());
                 infos.setText("<html>Rue de Paradis</html>");
                          infos2 = new JLabel("160€");
                          infos2.setHorizontalAlignment(car.getWidth()/2);
                          infos.setHorizontalAlignment(car.getWidth()/2);
                          car.add(infos,BorderLayout.CENTER);
                          car.add(infos2,BorderLayout.NORTH);
                          carLab.setBorder(cadre);
                          carLab.setBackground(Color.MAGENTA);
                          car.setBorder(cadre);
                          car.add(carLab, BorderLayout.WEST);
                          plateau.add(car);
                          break;

                 case 56 : car.setLayout(new BorderLayout());
                          infos.setText("<html>Gare Saint-Lazare</html>");
                          infos2 = new JLabel("200€");
                          infos2.setHorizontalAlignment(car.getWidth()/2);
                          infos.setHorizontalAlignment(car.getWidth()/2);
                          car.add(infos,BorderLayout.CENTER);
                          car.add(infos2,BorderLayout.NORTH);
                          car.setBorder(cadre);
                          car.add(carLab, BorderLayout.SOUTH);
                          plateau.add(car);
                          break;
                 case 66 : car.setLayout(new BorderLayout());
                         infos.setText("<html>Gare de Lyon</html>");
                          infos2 = new JLabel("200€");
                          infos2.setHorizontalAlignment(car.getWidth()/2);
                          infos.setHorizontalAlignment(car.getWidth()/2);
                          car.add(infos,BorderLayout.CENTER);
                          car.add(infos2,BorderLayout.NORTH);
                          car.setBorder(cadre);
                          car.add(carLab, BorderLayout.SOUTH);
                          plateau.add(car);
                          break;   
                 case 67 : car.setLayout(new BorderLayout());
                 infos.setText("<html>Boulevard des Capucines</html>");
                          infos2 = new JLabel("320€");
                          infos2.setHorizontalAlignment(car.getWidth()/2);
                          infos.setHorizontalAlignment(car.getWidth()/2);
                          car.add(infos,BorderLayout.CENTER);
                          car.add(infos2,BorderLayout.NORTH);
                          carLab.setBorder(cadre);
                          carLab.setBackground(Color.green);
                          car.setBorder(cadre);
                          car.add(carLab, BorderLayout.EAST);
                          plateau.add(car);
                          break;
                 case 61 :lab = new JLabel(new ImageIcon("/users/info/etu-s2/tostonr/Downloads/index.jpeg"));
                          dim2 = new Dimension(150,150);
                          dim3 = new Dimension(310,282);
                          car.setPreferredSize(dim3);
                          lab.setPreferredSize(dim2);
                          car.add(lab);
                          plateau.add(car);
                          break;         
                 case 77 : car.setLayout(new BorderLayout());
                 infos.setText("<html>Avenue Mozart</html>");
                          infos2 = new JLabel("180€");
                          infos2.setHorizontalAlignment(car.getWidth()/2);
                          infos.setHorizontalAlignment(car.getWidth()/2);
                          car.add(infos,BorderLayout.CENTER);
                          car.add(infos2,BorderLayout.NORTH);
                          carLab.setBorder(cadre);
                          carLab.setBackground(Color.orange);
                          car.setBorder(cadre);
                          car.add(carLab, BorderLayout.WEST);
                          plateau.add(car);
                          break;
                 case 78 : car.setLayout(new BorderLayout());

                          car.setBorder(cadre);
                          car.add(carLab, BorderLayout.EAST);
                          plateau.add(car);
                          break; 
                 case 88 : car.setLayout(new BorderLayout());

                          car.setBorder(cadre);
                          car.add(carLab, BorderLayout.WEST);
                          plateau.add(car);
                          break;

                  case 89 : car.setLayout(new BorderLayout());
                  infos.setText("<html>Avenue Foch</html>");
                          infos2 = new JLabel("300€");
                          infos2.setHorizontalAlignment(car.getWidth()/2);
                          infos.setHorizontalAlignment(car.getWidth()/2);
                          car.add(infos,BorderLayout.CENTER);
                          car.add(infos2,BorderLayout.NORTH);
                          carLab.setBorder(cadre);
                          carLab.setBackground(Color.green);
                          car.setBorder(cadre);
                          car.add(carLab, BorderLayout.EAST);
                          plateau.add(car);
                          break;
                 case 99 : car.setLayout(new BorderLayout());
                 infos.setText("<html>Boulevard Saint-Michel</html>");
                          infos2 = new JLabel("180€");
                          infos2.setHorizontalAlignment(car.getWidth()/2);
                          infos.setHorizontalAlignment(car.getWidth()/2);
                          car.add(infos,BorderLayout.CENTER);
                          car.add(infos2,BorderLayout.NORTH);
                           carLab.setBorder(cadre);
                          carLab.setBackground(Color.orange);
                          car.setBorder(cadre);
                          car.add(carLab, BorderLayout.WEST);
                          plateau.add(car);
                          break;
                 case 100 : car.setLayout(new BorderLayout());
                 infos.setText("<html>Avenue<br>de Breteuil</html>");
                          infos2 = new JLabel("300€");
                          infos2.setHorizontalAlignment(car.getWidth()/2);
                          infos.setHorizontalAlignment(car.getWidth()/2);
                          car.add(infos,BorderLayout.CENTER);
                          car.add(infos2,BorderLayout.NORTH);
                          carLab.setBorder(cadre);
                          carLab.setBackground(Color.green);
                          car.setBorder(cadre);
                          car.add(carLab, BorderLayout.EAST);
                          plateau.add(car);
                          break;

                 case 110 : car.setLayout(new BorderLayout());
                 infos.setText("<html>Place Pigalle</html>");
                          infos2 = new JLabel("200€");
                          infos2.setHorizontalAlignment(car.getWidth()/2);
                          infos.setHorizontalAlignment(car.getWidth()/2);
                          car.add(infos,BorderLayout.CENTER);
                          car.add(infos2,BorderLayout.NORTH);
                          carLab.setBorder(cadre);
                          carLab.setBackground(Color.orange);
                          car.setBorder(cadre);
                          car.add(carLab, BorderLayout.WEST);
                          plateau.add(car);
                          break;   
             //case bas gauche   
                case 111 : car.setLayout(new BorderLayout());

                          car.setBorder(cadre);
                          car.add(carLab, BorderLayout.NORTH);
                          plateau.add(car);
                          break;
                case 112 : car.setLayout(new BorderLayout());
                infos.setText("<html>Rue de la Fayette</html>");
                          infos2 = new JLabel("280€");
                          infos2.setHorizontalAlignment(car.getWidth()/2);
                          infos.setHorizontalAlignment(car.getWidth()/2);
                          car.add(infos,BorderLayout.CENTER);
                          car.add(infos2,BorderLayout.SOUTH);
                          carLab.setBorder(cadre);
                          carLab.setBackground(Color.yellow);
                          car.setBorder(cadre);
                          car.add(carLab, BorderLayout.NORTH);
                          plateau.add(car);
                          break;   
                 case 113 : car.setLayout(new BorderLayout());

                          car.setBorder(cadre);
                          car.add(carLab, BorderLayout.NORTH);
                          plateau.add(car);
                          break;

                 case 114: car.setLayout(new BorderLayout());
                 infos.setText("<html>Place de la Bourse</html>");
                          infos2 = new JLabel("260€");
                          infos2.setHorizontalAlignment(car.getWidth()/2);
                          infos.setHorizontalAlignment(car.getWidth()/2);
                          car.add(infos,BorderLayout.CENTER);
                          car.add(infos2,BorderLayout.SOUTH);
                          carLab.setBorder(cadre);
                          carLab.setBackground(Color.yellow);
                          car.setBorder(cadre);
                          car.add(carLab, BorderLayout.NORTH);
                          plateau.add(car);
                          break;
                 case 115 : car.setLayout(new BorderLayout());
                 infos.setText("<html>Faubourg Saint-Honoré</html>");
                          infos2 = new JLabel("260€");
                          infos2.setHorizontalAlignment(car.getWidth()/2);
                          infos.setHorizontalAlignment(car.getWidth()/2);
                          car.add(infos,BorderLayout.CENTER);
                          car.add(infos2,BorderLayout.SOUTH);
                         carLab.setBorder(cadre);
                          carLab.setBackground(Color.yellow);
                          car.setBorder(cadre);
                          car.add(carLab, BorderLayout.NORTH);
                          plateau.add(car);
                          break;

                 case 116 : car.setLayout(new BorderLayout());
                         infos.setText("<html>Gare du Nord</html>");
                          infos2 = new JLabel("200€");
                          infos2.setHorizontalAlignment(car.getWidth()/2);
                          infos.setHorizontalAlignment(car.getWidth()/2);
                          car.add(infos,BorderLayout.CENTER);
                          car.add(infos2,BorderLayout.SOUTH);
                          car.setBorder(cadre);
                          car.add(carLab, BorderLayout.NORTH);
                          plateau.add(car);
                          break;

                 case 117 : car.setLayout(new BorderLayout());
                 infos.setText("<html>Avenue Henri-Martin</html>");
                          infos2 = new JLabel("240€");
                          infos2.setHorizontalAlignment(car.getWidth()/2);
                          infos.setHorizontalAlignment(car.getWidth()/2);
                          car.add(infos,BorderLayout.CENTER);
                          car.add(infos2,BorderLayout.SOUTH);
                          carLab.setBorder(cadre);
                          carLab.setBackground(Color.red);
                          car.setBorder(cadre);
                          car.add(carLab, BorderLayout.NORTH);
                          plateau.add(car);
                          break;
                 case 118 : car.setLayout(new BorderLayout());
                 infos.setText("<html>Boulevard Malesherbes</html>");
                          infos2 = new JLabel("220€");
                          infos2.setHorizontalAlignment(car.getWidth()/2);
                          infos.setHorizontalAlignment(car.getWidth()/2);
                          car.add(infos,BorderLayout.CENTER);
                          car.add(infos2,BorderLayout.SOUTH);
                          carLab.setBorder(cadre);
                          carLab.setBackground(Color.red);
                          car.setBorder(cadre);
                          car.add(carLab, BorderLayout.NORTH);
                          plateau.add(car);
                          break;   
                 case 119 : car.setLayout(new BorderLayout());

                          car.setBorder(cadre);
                          car.add(carLab, BorderLayout.NORTH);
                          plateau.add(car);
                          break;  

                 case 120 : car.setLayout(new BorderLayout());
                 infos.setText("<html>Avenue Matignon</html>");
                          infos2 = new JLabel("220€");
                          infos2.setHorizontalAlignment(car.getWidth()/2);
                          infos.setHorizontalAlignment(car.getWidth()/2);
                          car.add(infos,BorderLayout.CENTER);
                          car.add(infos2,BorderLayout.SOUTH);
                           carLab.setBorder(cadre);
                          carLab.setBackground(Color.red);
                          car.setBorder(cadre);
                          car.add(carLab, BorderLayout.NORTH);
                          plateau.add(car);
                          break;   

                 case 121 : car.setLayout(new BorderLayout());

                          car.setBorder(cadre);
                          car.add(carLab, BorderLayout.EAST);
                          plateau.add(car);
                          break; 



                 default: plateau.add(new JPanel());
                          break;
            }

        }

        plateau.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });

        fenetre.add(plateau, BorderLayout.CENTER);
        fenetre.setVisible(false);
        
        //Fenêtre de menu principal
        
        fenetremenu = new JFrame();
        fenetremenu.setTitle("Menu Monopoly");
        fenetremenu.setSize(400, 200);
        fenetremenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetremenu.setVisible(false);
        fenetremenu.setLayout(new BorderLayout());
        
        JLabel titre = new JLabel("Monopoly");
        fenetremenu.add(titre,BorderLayout.NORTH);
        titre.setHorizontalAlignment(JLabel.CENTER);
        
        JPanel panelCentre = new JPanel();
        panelCentre.setLayout(new GridLayout(4,4));
        JLabel nbjoueurs = new JLabel("Joueurs : ");
        nbjoueurs.setHorizontalAlignment(JLabel.CENTER);
        listeJoueurs = new JComboBox();
        for (int i = 1; i<6;i++){
            listeJoueurs.addItem(i+1);
        }
        
        for (int i = 0; i<=15;i++){
            switch(i){
                case 6:
                    panelCentre.add(nbjoueurs);
                case 7:
                    panelCentre.add(listeJoueurs);
                default:
                    panelCentre.add(new JLabel());
            }
        
        }
       
        fenetremenu.add(panelCentre,BorderLayout.CENTER);
        
        JPanel panelBas = new JPanel();
        panelBas.setLayout(new GridLayout(0,3));
        JButton commencer = new JButton("Commencer");
        JButton arreter = new JButton("Arrêter");
        JButton regles = new JButton("Règles");
        panelBas.add(commencer);
        panelBas.add(regles);
        panelBas.add(arreter);
        
        fenetremenu.add(panelBas,BorderLayout.SOUTH);
        
        //Listener menu
        
        commencer.addActionListener((ActionEvent e) -> {
            fenetremenu.setVisible(false);
            fenetre.setVisible(true);
            fenetre.repaint();
        });
        
        arreter.addActionListener((ActionEvent e) -> {
            fenetremenu.setVisible(false);
        });
        
        regles.addActionListener((ActionEvent e) -> {
            fenetremenu.setVisible(false);
            fenetreregles.setVisible(true);
            fenetreregles.repaint();
        });
        
        
        //fenetre regles
        
        fenetreregles = new JFrame();
        fenetreregles.setTitle("Règles Monopoly");
        fenetreregles.setSize(400, 200);
        fenetreregles.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetreregles.setVisible(false);
        
        JLabel teteRegles = new JLabel("Règles du Monopoly");
        fenetreregles.add(teteRegles,BorderLayout.NORTH);
        teteRegles.setHorizontalAlignment(JLabel.CENTER);
        JButton retour = new JButton("Retour au menu");
        fenetreregles.add(retour,BorderLayout.SOUTH);
        
        //Listener regles
        
        retour.addActionListener((ActionEvent e) -> {
            fenetreregles.setVisible(false);
            fenetremenu.setVisible(true);
            fenetremenu.repaint();
        });
        
        
   }
    
   public void fenetrePlateau(){
       fenetre.setVisible(true);    
   } 
   
   public void fenetreMenu(){
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
    
}

