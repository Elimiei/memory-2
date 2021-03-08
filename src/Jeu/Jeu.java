package Jeu;

import Cartes.Carte;
import DAO.JoueurDAO;
import Joueur.Joueur;
import Plateau.Grille;

import java.util.ArrayList;
import java.util.List;

public class Jeu {

    public List<Joueur> joueurList;
    public Grille grille;
    public int joueurActif;


    public Jeu(List<Joueur> joueurList, Grille grille, int joueurActif) {
        this.joueurList = joueurList;
        this.grille = grille;
        this.joueurActif = joueurActif;
    }

    public Jeu() {

        // Création des joueurs
        this.joueurList = new ArrayList<Joueur>();
        JoueurDAO joueurDAO = new JoueurDAO();
        joueurList = joueurDAO.read();

        if (joueurList.size() == 0){
            Joueur joueur1 = new Joueur("J1");
            Joueur joueur2 = new Joueur("J2");

            joueurList.add(joueur1);
            joueurList.add(joueur2);
        } else {
            for (int i = 0; i < joueurList.size(); i++){
                int Id = joueurList.get(i).Id;
                String nom = joueurList.get(i).nom;
                int score = joueurList.get(i).score;
                new Joueur(Id, nom, score);
            }
        }

        this.grille = new Grille();
        this.joueurActif = 0;
    }


    public List<Joueur> getJoueurList() {
        return joueurList;
    }

    public void setJoueurList(List<Joueur> joueurList) {
        this.joueurList = joueurList;
    }

    public Grille getGrille() {
        return grille;
    }

    public void setGrille(Grille grille) {
        this.grille = grille;
    }

    public int getJoueurActif() {
        return joueurActif;
    }

    public void setJoueurActif(int joueurActif) {
        this.joueurActif = joueurActif;
    }

    public void changerJoueurActif(int indexJoueur){
        if (indexJoueur == 0){
            this.joueurActif = 1;
        }
        else if (indexJoueur == 1){
            this.joueurActif = 0;
        }
    }
}
