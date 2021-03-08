package Test;

import Cartes.Carte;
import Plateau.Grille;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrilleTest {

    @Test
    void del() {
        Grille grille = new Grille();
        Carte carte1 = new Carte();
        Carte carte2 = new Carte();

        grille.del(carte1, carte2);
        assertTrue(carte1.isVide && carte2.isVide);
    }

    @Test
    void move() {
        Grille grille = new Grille();
        Carte carte1 = new Carte();
        Carte carte2 = new Carte();

        grille.move(carte1, carte2);
        assertTrue(!carte1.isActivated && !carte2.isActivated);

    }
}