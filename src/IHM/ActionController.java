package IHM;

import Cartes.Carte;
import DAO.JoueurDAO;
import Jeu.Jeu;
import Plateau.Grille;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ActionController implements ActionListener {

    private Vue vue;
    Jeu jeu = new Jeu();
    private int NbreCartesVides = 0;
    Grille plateau;
    List<Carte> carteList;

    public ActionController(Vue vue, Grille plateau) {
        this.plateau = plateau;
        this.vue = vue;
        carteList = plateau.carteList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Boucle principale
        if (NbreCartesVides != Grille.NB_CARTES) {

            // Boutons pour sauvegarder
            for (int i = 0; i < jeu.joueurList.size(); i++) {
                if (e.getSource().equals(vue.buttonScores)) {
                    if (jeu.joueurList.get(i).getId() ==  -1) {
                        sauvegarderScores(i);
                    } else {
                        mettreAjourScores(i);
                    }
                }
            }

            // Bouton rejouer
            if (e.getSource().equals(vue.buttonRejouer)){
                vue.dispose();
                new Vue();
            }


            // Réinitialiser score
            if (e.getSource().equals(vue.reinitialiserScore)){
                jeu.joueurList.get(0).setScore(0);
                jeu.joueurList.get(1).setScore(0);
                mettreAjourScores(0);
                mettreAjourScores(1);
            }

            // Actualisation des boutons et du joueur à chaque tour
            for (int i = 0; i < Grille.NB_CARTES; i++) {
                vue.DisplayBouton(i);
                vue.texteHaut.setText("Au tour du Joueur " + (jeu.joueurActif + 1)+ " !");
            }

            // Au clic, retourner la carte cliquée et lui attribuer l'état activée
            for (int i = 0; i < Grille.NB_CARTES; i++) {
                if (e.getSource().equals(vue.carteBoutonList.get(i))) {
                    if (!carteList.get(i).isVide) {
                        jeu.joueurList.get(jeu.getJoueurActif()).pick(i);
                        vue.ActualiserBouton(i);
                    }
                    // mettre fin à la boucle
                    i = Grille.NB_CARTES;
                }
            }

            // Liste des cartes que possède le joueur actif
            List<Integer> indexCartesChoisiesList = jeu.joueurList.get(jeu.getJoueurActif()).getIndexCarteListByJoueur();

            // Si la liste contient deux cartes, comparer les cartes
            if (!indexCartesChoisiesList.isEmpty() && indexCartesChoisiesList.size() == 2) {

                // Si elles sont compatibles, attribuer des points et les mettre à vide, puis vider la liste de cartes actives
                if (carteList.get(indexCartesChoisiesList.get(0)).isCompatible(carteList.get(indexCartesChoisiesList.get(1))) && indexCartesChoisiesList.get(0) != indexCartesChoisiesList.get(1)) {
                    jeu.joueurList.get(jeu.getJoueurActif()).ajouterPoint();
                    plateau.del(carteList.get(indexCartesChoisiesList.get(0)), carteList.get(indexCartesChoisiesList.get(1)));
                    NbreCartesVides += 2;
                    vue.texteHaut.setText(jeu.joueurList.get(jeu.getJoueurActif()).getNom() + " : " + jeu.joueurList.get(jeu.getJoueurActif()).getScore());
                    jeu.joueurList.get(jeu.getJoueurActif()).clearIndexCarteListByJoueur(indexCartesChoisiesList);
                }
                // Au cas où la personne clique deux fois sur la même carte
                else if (indexCartesChoisiesList.get(0) == indexCartesChoisiesList.get(1)) {
                    jeu.joueurList.get(jeu.getJoueurActif()).clearIndexCarteListByJoueur(indexCartesChoisiesList);
                }
                // Si les cartes ne sont pas compatibles, les retourner et vider la liste de cartes actives, puis changer de joueur actif
                else {
                    plateau.move(carteList.get(indexCartesChoisiesList.get(0)), carteList.get(indexCartesChoisiesList.get(1)));
                    jeu.joueurList.get(jeu.getJoueurActif()).clearIndexCarteListByJoueur(indexCartesChoisiesList);
                    jeu.changerJoueurActif(jeu.joueurActif);
                }

            }
        }
        // Si toutes les cartes sont vides, déclarer gagnant
        else {
            for (int i = 0; i < Grille.NB_CARTES; i++) {
                vue.texteHaut.setText("Gagnant : Joueur " + (jeu.joueurActif + 1) + " ! ");
            }

            // Bouton rejouer
            if (e.getSource().equals(vue.buttonRejouer)){
                vue.dispose();
                new Vue();
            }
        }
    }

    public void sauvegarderScores(int i) {
        JoueurDAO joueurDAO = new JoueurDAO();
        joueurDAO.create(jeu.joueurList.get(i));
        vue.texteHaut.setText("Score sauvegardé !");
    }

    public void mettreAjourScores(int i) {
        JoueurDAO joueurDAO = new JoueurDAO();
        joueurDAO.update(jeu.joueurList.get(i));
        vue.texteHaut.setText("Score sauvegardé !");
    }
}


