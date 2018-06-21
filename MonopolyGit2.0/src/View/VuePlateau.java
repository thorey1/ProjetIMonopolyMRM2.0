package View;

import Controler.*;
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
public class VuePlateau extends Observe {

    private JFrame fenetre, fenetremenu, fenetreregles1, fenetreregles2;

    private Observateur o;
    private ArrayList<String> noms;
    

    public VuePlateau(ArrayList<String> noms) {
        this.noms = new ArrayList();
        this.noms=noms;
        fenetre = new JFrame();
        fenetre.setTitle("Monopoly");
        fenetre.setSize(1920, 1080);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         Border cadre = BorderFactory.createLineBorder(Color.black);

        JLabel nom = new JLabel("Nom du joueur :");
        JLabel nom2 = new JLabel("1");
        JLabel argent = new JLabel("Argent joueur :");
        JLabel argent2 = new JLabel("2");
        JLabel dé1 = new JLabel(new ImageIcon("Images/fleche.gif"));
        JLabel dé2 = new JLabel(new ImageIcon("Images/fleche.gif"));
        JButton lancer = new JButton("Lancer les dès");

        //Intanciation des boutons
        JButton acheter = new JButton("Acheter");
        JButton b3 = new JButton("Construire");
        JButton fin = new JButton("Fin du tour");
        JButton arreter = new JButton("Arrêter");
        JButton regles = new JButton("Règles");

        //A MODIFIER
        arreter.addActionListener((ActionEvent e) -> {
            Message m = new Message();
            m.type = TypesMessages.RETOUR;
            this.notifierObservateur(m);
        });
        
        regles.addActionListener((ActionEvent) -> {
            Message m = new Message();
            m.type = TypesMessages.REGLE;
            this.notifierObservateur(m);
        });
        
        //instanciation des propriétés
        JLabel p1 = new JLabel("1");
        JLabel p2 = new JLabel("1");
        JLabel p3 = new JLabel("1");
        JLabel p4 = new JLabel("1");
        JLabel p5 = new JLabel("1");
        JLabel p6 = new JLabel("1");
        JLabel p7 = new JLabel("1");
        JLabel p8 = new JLabel("1");
        JLabel p9 = new JLabel("1");
        JLabel p10 = new JLabel("1");
        JLabel p11= new JLabel("1");
        JLabel p12 = new JLabel("1");
        JLabel p13 = new JLabel("1");
        JLabel p14 = new JLabel("1");
        JLabel p15 = new JLabel("1");
        JLabel p16 = new JLabel("1");
        JLabel p17 = new JLabel("1");
        JLabel p18 = new JLabel("1");
        JLabel p19 = new JLabel("1");
        JLabel p20 = new JLabel("1");
        JLabel p21 = new JLabel("1");
        JLabel p22 = new JLabel("1");
        JLabel p23 = new JLabel("1");
        JLabel p24 = new JLabel("1");
        JLabel p25 = new JLabel("1");
        JLabel p26 = new JLabel("1");
        JLabel p27 = new JLabel("1");
        JLabel p28= new JLabel("1");
        
        
                
      

        //Création des panels de commande 
        JPanel information = new JPanel(new GridLayout(2, 2));
        JPanel dé = new JPanel(new GridLayout(0, 2));
        JPanel commande = new JPanel(new GridLayout(6, 0));
        JPanel commandeLayout = new JPanel(new BorderLayout());
        JPanel commandeScroll = new JPanel(new GridLayout(28, 0));
        JPanel pchoix = new JPanel(new GridLayout(0, 2));
        JScrollPane pane = new JScrollPane(commandeScroll);
        
        //ajout des différents composants 
        pchoix.add(arreter);
        pchoix.add(regles);
        dé.add(dé1);
        dé.add(dé2);
        information.add(nom);
        information.add(nom2);
        information.add(argent);
        information.add(argent2);
        commande.add(information);
        commande.add(dé);
        commande.add(lancer);
        commande.add(acheter);
        commande.add(b3);
        commande.add(fin);
        
        //ajout des propriété au menu déroulant
        commandeScroll.add(p1);
        commandeScroll.add(p2);
        commandeScroll.add(p3);
        commandeScroll.add(p4);
        commandeScroll.add(p5);
        commandeScroll.add(p6);
        commandeScroll.add(p7);
        commandeScroll.add(p8);
        commandeScroll.add(p9);
        commandeScroll.add(p10);
        commandeScroll.add(p11);
        commandeScroll.add(p12);
        commandeScroll.add(p13);
        commandeScroll.add(p14);
        commandeScroll.add(p15);
        commandeScroll.add(p16);
        commandeScroll.add(p17);
        commandeScroll.add(p18);
        commandeScroll.add(p19);
        commandeScroll.add(p20);
        commandeScroll.add(p21);
        commandeScroll.add(p22);
        commandeScroll.add(p23);
        commandeScroll.add(p24);
        commandeScroll.add(p25);
        commandeScroll.add(p26);
        commandeScroll.add(p27);
        commandeScroll.add(p28);
        
        //Mise en page de la zone de commande 
            //Mise en place des tailles et cadre
        commandeScroll.setPreferredSize(new Dimension(280, 1400));
        commande.setPreferredSize(new Dimension(300,500));
        

        Dimension dim = new Dimension(300, 1080 - arreter.getHeight());
        commandeLayout.setPreferredSize(dim);
        commandeLayout.setBorder(cadre);
        
            //Ajout des 3 panel au panel commandeLayout
        commandeLayout.add(commande, BorderLayout.NORTH);
        commandeLayout.add(pane, BorderLayout.CENTER);
        commandeLayout.add(pchoix, BorderLayout.SOUTH);
        
            //Ajout de commandeLayout et plateau à la frame
        fenetre.add(commandeLayout, BorderLayout.WEST);
        fenetre.add(afficherPlateau(), BorderLayout.CENTER);
        fenetre.setVisible(true);

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

    private JPanel afficherPlateau() {
        //Création du plateau de jeu
        JPanel plateau = new JPanel();
        plateau.setLayout(new GridLayout(11, 11));
        //Boucle d'ajout des différentes cases
        Border cadre = BorderFactory.createLineBorder(Color.black);
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
            Dimension dim2;
            Dimension dim3 = new Dimension(100, 100);

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
                    infos2.setFont(font6);
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
                    infos2.setFont(font6);
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
                    infos2.setFont(font6);
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
                    infos2.setFont(font6);
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
                    infos2.setFont(font6);
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
                    infos2.setFont(font6);
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
                    infos2.setFont(font6);
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
                    infos2.setFont(font6);
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
                    infos2.setFont(font6);
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
                    infos2.setFont(font6);
                    car.add(infos, BorderLayout.SOUTH);
                    car.add(infos2, BorderLayout.NORTH);
                    car.add(img, BorderLayout.CENTER);
                    car.setBorder(cadre);
                    plateau.add(car);
                    car.setBackground(Color.white);
                    break;

                case 33:
                    infos.setText("<html>Compagnie d'électricité</html>");
                    infos.setFont(new Font("Arial", Font.BOLD, 9));
                    infos2 = new JLabel("150€");
                    img = new JLabel(new ImageIcon("Images/elec.jpg"));
                    infos.setHorizontalAlignment(car.getWidth() / 2);
                    infos2.setHorizontalAlignment(car.getWidth() / 2);
                    infos2.setFont(font6);
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
                    infos2.setFont(font6);
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
                    infos2.setFont(font6);
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
                    infos2.setFont(font6);
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
                    infos2.setFont(font6);
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
                    infos2.setFont(font6);
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
                    infos2.setFont(font6);
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
                    infos2.setFont(font6);
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
                    infos2.setFont(font6);
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
                    infos2.setFont(font6);
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
                    infos2.setFont(font6);
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
                    infos2.setFont(font6);
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
                    infos2.setFont(font6);
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
                    infos2.setFont(font6);
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
                    infos2.setFont(font6);
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
                    infos2.setFont(font6);
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
                    infos2.setFont(font6);
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
                    infos2.setFont(font6);
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
                    infos2.setFont(font6);
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
                    infos2.setFont(font6);
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
        return plateau;
    }

    public JFrame getFenetrePlateau() {
        return fenetre;
    }
}
