package DAO;

import Cartes.Carte;
import Cartes.Symbole;
import Joueur.Joueur;
import Plateau.Grille;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JoueurDAO extends DAO<Joueur> {

    @Override
    public boolean create(Joueur obj) {
        boolean succes = false;
        PreparedStatement create = null;
        String nom = obj.getNom();
        int score = obj.getScore();
        String createString = "INSERT INTO Joueur(nom, score) VALUES(?,?);";
        try {
            create = Connexion.getInstance().prepareStatement(createString, Statement.RETURN_GENERATED_KEYS);
            create.setString(1, nom);
            create.setInt(2, score);
            System.out.println(create);
            create.executeUpdate();
            ResultSet rs = create.getGeneratedKeys();
            if (rs.next()) {
                obj.setId(rs.getInt(1));
            }
            succes = true;
        } catch (Exception e) {
            succes = false;
            System.out.println("Erreur lors de la création");
            e.printStackTrace();
        }
        return succes;
    }

    @Override
    public boolean delete(Joueur j) {
        boolean succes = false;
        PreparedStatement delete = null;
        try {
            String deleteString = "DELETE FROM Joueur WHERE Id = ?;";
            delete = Connexion.getInstance().prepareStatement(deleteString);
            delete.setInt(1, j.Id);
            System.out.println(delete);
            delete.executeUpdate();
            succes = true;
        } catch (Exception e) {
            succes = false;
            System.out.println("Erreur lors de la suppression");
            e.printStackTrace();
        }
        return succes;
    }

    @Override
    public boolean update(Joueur obj) {

        boolean succes = false;
        PreparedStatement update = null;
        String nom = obj.getNom();
        int score = obj.getScore();
        String updateString = "UPDATE Joueur SET nom = ?, score = ? WHERE Id = ?;";
        try {
            update = Connexion.getInstance().prepareStatement(updateString);
            update.setString(1, nom);
            update.setInt(2, score);
            update.setInt(3, obj.getId());
            System.out.println(update);
            update.executeUpdate();
            succes = true;
        } catch (Exception e) {
            succes = false;
            System.out.println("Erreur lors de la mise à jour");
            e.printStackTrace();
        }
        return succes;
    }

    @Override
    public List<Joueur> read() {

        List<Joueur> joueurList = new ArrayList<Joueur>(Grille.NB_CARTES);
        boolean succes = false;
        Joueur joueur = new Joueur();
        ResultSet rs=null;
        PreparedStatement find = null;
        String findString = "SELECT * FROM Joueur";
        try {
            find = Connexion.getInstance().prepareStatement(findString);
            rs = find.executeQuery();
            while (rs.next()){
                joueur.Id = rs.getInt("Id");
                joueur.nom = rs.getString("nom");
                joueur.score = rs.getInt("score");
                joueurList.add(joueur);
            }

        } catch (Exception e) {
            succes = false;
            System.out.println("Erreur lors de la recherche");
            e.printStackTrace();
        }
        return joueurList;
    }
}
