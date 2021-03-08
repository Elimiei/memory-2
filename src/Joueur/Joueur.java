package Joueur;

import Cartes.Carte;
import Plateau.Grille;

import java.util.ArrayList;
import java.util.List;

public class Joueur {
    public int Id = -1;
    public String nom;
    public int score;
    List<Integer> indexCarteListByJoueur = new ArrayList<>(Grille.NB_CARTES/2);

    public Joueur(String nom) {
        this.nom = nom;
        this.score = 0;
    }

    public Joueur(int Id, String nom, int score) {
        this.Id = Id;
        this.nom = nom;
        this.score = score;
    }

    public Joueur() {
    }

    public void pick(int i){
        indexCarteListByJoueur.add(i);
    }

    public List<Integer> getIndexCarteListByJoueur() {
        return indexCarteListByJoueur;
    }

    public void setIndexCarteListByJoueur(List<Integer> indexCarteListByJoueur) {
        this.indexCarteListByJoueur = indexCarteListByJoueur;
    }

    public void clearIndexCarteListByJoueur(List<Integer> indexCarteListByJoueur){
        this.indexCarteListByJoueur.clear();
    }

    public void ajouterPoint(){
        this.score++;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
