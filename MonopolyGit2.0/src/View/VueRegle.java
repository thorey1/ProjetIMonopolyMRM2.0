/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controler.Message;
import Controler.Observateur;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author boedam
 */
public class VueRegle extends Observe{
    
    JFrame fenetreregles1, fenetreregles2;
    private Observateur o;
    
    

    public VueRegle() {
        //fenetre regles1
        fenetreregles1 = new JFrame();
        fenetreregles1.setTitle("Règles Monopoly");
        fenetreregles1.setSize(600, 950);
        fenetreregles1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetreregles1.setVisible(true);

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
    
    
    

    
    

