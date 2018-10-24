package Cartes;

public enum Symbole {
    Tasse, Souris, Vache, Cloche, Tomate, Poussin, Lion, Girafe, Kiwi, Chaton, Ours, Baleine, Léopard, Oursin, Vide;

    private static final Symbole[] SYMBOLES = Symbole.values();

    public static Symbole getSymbole(int indice){
        return SYMBOLES [indice];
    }

}
