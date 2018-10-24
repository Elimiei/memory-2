package Cartes;

public interface ICarte {

    public void activate();

    public void sleep();

    public Carte toDisplay();

    public boolean isCompatible(Carte c2);
}
