package Cartes;

public enum Symbole {
    Souris, Vache, Cloche, Tomate, Poussin, Lion, Girafe, Chaton, Baleine, Vide;

    private static final Symbole[] SYMBOLES = Symbole.values();

    public static Symbole getSymbole(int indice){
        return SYMBOLES [indice];
    }

    public static int getNbSymboles() {
        return SYMBOLES.length;
    }

    public static Symbole get(int i){
        return SYMBOLES[i-1];
    }

    public static int getIndice(Symbole motif){
        int rep=1;
        while(Symbole.get(rep)!=motif && rep<=getNbSymboles()){
            rep++;
        }
        return rep;
    }
}
