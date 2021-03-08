package IHM;

import Cartes.Carte;

import javax.swing.*;

public class CarteBouton extends JButton {

    Carte carte;


    public CarteBouton(Carte carte) {
        super(carte.getEtat());
        this.carte = carte;
    }

    public void changerImage(){
        if(carte.isActivated){
            carte.sleep();
            this.setIcon(new ImageIcon("src/content/sleep.png"));
        }
        else {
            carte.activate();
            this.setIcon(carte.getEtat());
        }
    }

    public void actualiserImage(){
        this.setIcon(carte.getEtat());
    }
}
