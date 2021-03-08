package Test;

import Cartes.Carte;
import Cartes.Symbole;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarteTest {

    @Test
    void isCompatibleTrue() {
        boolean compatible = false;
        Carte carte1 = new Carte(Symbole.Chaton);
        Carte carte2 = new Carte(Symbole.Chaton);

        compatible = carte1.isCompatible(carte2);
        assertTrue(compatible);
    }

    @Test
    void isCompatibleFalse() {
        boolean compatible = false;
        Carte carte1 = new Carte(Symbole.Chaton);
        Carte carte2 = new Carte(Symbole.Baleine);

        compatible = carte1.isCompatible(carte2);
        assertFalse(compatible);
    }
}