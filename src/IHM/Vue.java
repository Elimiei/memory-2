package IHM;

import Plateau.Grille;
import Plateau.IGrille;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Vue extends JFrame {

    Container partie;
    JPanel cartes = new JPanel();
    JPanel joueurs = new JPanel();
    JLabel texteHaut = new JLabel("Bienvenue ! Au tour de J1");
    JButton buttonScores = new JButton("Sauvegarder");
    JButton buttonRejouer = new JButton("Rejouer");
    JButton reinitialiserScore = new JButton("Supprimer sauvegarde");
    List<CarteBouton> carteBoutonList;
    IGrille plateau = new Grille();

    public Vue() {

        this.carteBoutonList = new ArrayList<>(Grille.NB_CARTES);
        constructionFenetre();
        this.setCartes();
        partie = this.getContentPane();
        partie.add(joueurs, BorderLayout.NORTH);
        partie.add(new JSeparator(), BorderLayout.CENTER);
        partie.add(cartes);
        setContentPane(partie);
        this.setVisible(true);
    }

    public void constructionFenetre() {
        joueurs.setLayout(new GridLayout(1, 3));
        cartes.setLayout(new GridLayout(4, 4));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 800);
    }

    public void setCartes() {
        ActionController actionController = new ActionController(this, ((Grille) plateau));
        joueurs.add(texteHaut);
        buttonScores.setText("Sauvegarder score");
        joueurs.add(buttonScores);
        joueurs.add(buttonRejouer);
        joueurs.add(reinitialiserScore);
        buttonScores.addActionListener(actionController);
        buttonRejouer.addActionListener(actionController);
        reinitialiserScore.addActionListener(actionController);
        for (int i = 0; i < Grille.NB_CARTES; i++) {
            CarteBouton bouton = new CarteBouton(plateau.get(i));
            cartes.add(bouton);
            carteBoutonList.add(bouton);
            bouton.addActionListener(actionController);
        }
    }

    public void ActualiserBouton(int i) {
        carteBoutonList.get(i).changerImage();
    }

    public void DisplayBouton(int i) {
        carteBoutonList.get(i).actualiserImage();
    }


}
