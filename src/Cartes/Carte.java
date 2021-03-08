package Cartes;

import javax.swing.*;
import java.awt.*;

public class Carte implements ICarte {

    public Symbole motif;
    public boolean isActivated;
    public boolean isVide;
    public int Id;
    public ImageIcon etat = new ImageIcon("src/content/sleep.png");

    public Carte(Symbole motif) {
        super();
        this.motif = motif;
    }

    public Carte() {
    }

    // Mettre l'image à activée et lui attribuer une image
    @Override
    public void activate() {
        this.isActivated = true;
        etat = new ImageIcon("src/content/" + motif.name() + ".png");
    }

    // Fonction activate() pour le mode console
    @Override
    public void activateConsole() {
        this.isActivated = true;
    }

    // Désactiver la carte et lui attribuer l'image face cachée
    @Override
    public void sleep() {
        this.isActivated = false;
        etat = new ImageIcon("src/content/sleep.png");
    }

    // fonction sleep() pour le mode console
    @Override
    public void sleepConsole() {
        this.isActivated = false;
    }

    // Méthode pour comparer les cartes
    @Override
    public boolean isCompatible(Carte c2) {
        return (this.motif == c2.motif);
    }

    // Méthode toString pour récupérer les images
    @Override
    public String toString() {
        return isActivated || isVide ? motif.toString() : "sleep.png";
    }

    // Méthode toString pour le mode console
    @Override
    public String toStringConsole() {
        return isActivated || isVide ? motif.toString() : "[------]";
    }

    public Symbole getMotif() {
        return motif;
    }

    public void setMotif(Symbole motif) {
        this.motif = motif;
    }

    public boolean isActivated() {
        return isActivated;
    }

    public void setActivated(boolean activated) {
        isActivated = activated;
    }

    public boolean setActivatedwithint(int activated) {
        return (activated == 1 ? true : false);
    }

    public boolean isVide() {
        return isVide;
    }

    // Mettre la carte à Vide
    public void setVide(boolean vide) {
        isVide = vide;
        if (vide){
            this.motif = Symbole.Vide;
            this.isActivated = false;
        }
    }

    public ImageIcon getEtat() {
        return etat;
    }

    public int getIntActivated(){
        return (isActivated? 1 : 0);
    }

    public void setEtat(ImageIcon etat) {
        this.etat = etat;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
