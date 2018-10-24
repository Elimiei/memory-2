package Cartes;

public class Carte implements ICarte {

    public Symbole motif;
    public boolean isActivated;
    public boolean isVide;

    public Carte(Symbole motif) {
        super();
        this.motif = motif;
    }

    @Override
    public void activate() {
        this.isActivated = true;
    }

    @Override
    public void sleep() {
        this.isActivated = false;
    }

    @Override
    public Carte toDisplay() {
        return null;
    }

    @Override
    public boolean isCompatible(Carte c2) {
        return (this.motif == c2.motif);
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

    @Override
    public String toString() {
        return isActivated || isVide ? motif.toString() : "[----------]";
    }

    public boolean isVide() {
        return isVide;
    }

    public void setVide(boolean vide) {
        isVide = vide;
        if (vide){
            this.motif = Symbole.Vide;
            this.isActivated = false;
        }
    }
}
