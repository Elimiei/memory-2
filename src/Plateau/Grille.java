package Plateau;

import Cartes.Carte;
import Cartes.ICarte;
import Cartes.Symbole;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Grille implements IGrille<Carte> {

    public static final int LARGEUR = 4;
    public static final int LONGUEUR = 4;
    public static final int NB_CARTES = LARGEUR*LONGUEUR;
    public List<Carte> carteList = new ArrayList<>(NB_CARTES);

    public Grille() {
        for (int i = 0; i < NB_CARTES; i++){
            carteList.add(new Carte(Symbole.getSymbole(i/2)));
        }
        Collections.shuffle(carteList);
        this.set(carteList);
    }

    @Override
    public Carte get(int i) {
        return carteList.get(i);
    }

    @Override
    public void pick(int i) {
        carteList.get(i-1).activate();
        this.set(carteList);
        List<ICarte> iCarteList= carteList.stream().filter(carte -> ((Carte) carte).isActivated).collect(Collectors.toList());
        if (iCarteList.size() == 2){
            boolean isCompatible = iCarteList.get(0).isCompatible((Carte) iCarteList.get(1));
            if (isCompatible){
                del(iCarteList.get(0), iCarteList.get(1));
            } else {
                move(iCarteList.get(0), iCarteList.get(1));
            }
        }
    }

    @Override
    public void del(ICarte carte1, ICarte carte2) {
        ((Carte) carte1).setVide(true);
        ((Carte) carte2).setVide(true);
    }

    @Override
    public List<Carte> set(List carteList) {
          this.carteList = carteList;
          return this.carteList;
    }

    @Override
    public void move(ICarte carte1, ICarte carte2) {
        carte1.sleep();
        carte2.sleep();
    }

    @Override
    public String toString() {
        return "Grille{" +
                "carteList=" + carteList +
                '}';
    }
}
