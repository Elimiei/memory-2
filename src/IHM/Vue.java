package IHM;

import Cartes.Carte;
import Cartes.ICarte;
import Plateau.Grille;
import Plateau.IGrille;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Vue extends JFrame {

    JPanel jpanel = new JPanel();
    long compteurVide = 0;
    IGrille plateau = new Grille();

    public Vue() {

        constructionFenetre();

        //boucle pour afficher les cartes
        for (int i = 0; i < Grille.NB_CARTES; i++) {
            String symbole = ((Grille) plateau).carteList.get(i).toString();
            jpanel.add(new JButton(symbole));
        }


        /*while (((Grille) plateau).carteList.size() != compteurVide) {

            Scanner Sc1 = new Scanner(System.in);
            System.out.println("Saisir position carte 1 : ");
            int pos = Sc1.nextInt();
            System.out.println(pos);
            plateau.pick(pos);

            compteurVide = ((Grille) plateau).carteList.stream().filter(carte -> ((Carte) carte).isVide).count();
        }*/

        setContentPane(jpanel);
        this.setVisible(true);
    }

    public void constructionFenetre() {

        jpanel.setLayout(new GridLayout(Grille.LARGEUR, Grille.LONGUEUR));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 1000);
    }

}
