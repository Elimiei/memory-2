package Cartes;

import javax.swing.*;

public interface ICarte {

    public void activate();

    public void sleep();

    public boolean isCompatible(Carte c2);

    public void activateConsole();

    public void sleepConsole();

    public String toStringConsole();
}
