package Jeu;

import Cartes.Carte;
import Plateau.Grille;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JeuConsole {
    int pos = -1;
    Grille grille = new Grille();
    int cartesVides = 0;
    List<Carte> cartesByJoueur = new ArrayList<>(Grille.NB_CARTES);


    public JeuConsole() {

        while (cartesVides != Grille.NB_CARTES) {
            setCartes();

            System.out.println("Choisir une position :");
            Scanner sc = new Scanner(System.in);
            pos = sc.nextInt() - 1;

            cartesByJoueur.add(grille.carteList.get(pos));
            grille.carteList.get(pos).activateConsole();

            if (cartesByJoueur.size() == 2) {
                if (cartesByJoueur.get(0).isCompatible(cartesByJoueur.get(1))) {
                    grille.del(cartesByJoueur.get(0), cartesByJoueur.get(1));
                    cartesByJoueur.clear();
                    cartesVides += 2;
                } else {
                    setCartes();
                    System.out.println("Pas de paire !");
                    System.out.println();
                    cartesByJoueur.get(0).sleepConsole();
                    cartesByJoueur.get(1).sleepConsole();
                    cartesByJoueur.clear();
                }
            }

        }

        System.out.println("Gagné !");


    }

    public void setCartes() {
        for (int i = 0; i < Grille.NB_CARTES; i++) {
            if (i % 4 == 0) {
                System.out.println();
                System.out.printf(grille.carteList.get(i).toString());
            } else {
                System.out.printf(grille.carteList.get(i).toString());
            }
        }
    }
}
