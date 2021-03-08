package DAO;

import Cartes.Carte;
import Cartes.Symbole;
import Plateau.Grille;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarteDAO extends DAO<Carte> {


    @Override
    public boolean create(Carte obj) {
        boolean succes = false;
        PreparedStatement create = null;
        int motif = Symbole.getIndice(obj.motif);
        int activated = obj.getIntActivated();
        String createString = "INSERT INTO Carte(motif, etat) VALUES(?,?);";
        try {
            create = Connexion.getInstance().prepareStatement(createString, Statement.RETURN_GENERATED_KEYS);
            create.setInt(1, motif);
            create.setInt(2, activated);
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
    public boolean delete(Carte obj) {
        boolean succes = false;
        PreparedStatement delete = null;
        try {
            String deleteString = "DELETE FROM Carte WHERE Id = ?;";
            delete = Connexion.getInstance().prepareStatement(deleteString);
            delete.setInt(1, obj.getId());
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
    public boolean update(Carte obj) {

        boolean succes = false;
        PreparedStatement update = null;
        int motif = Symbole.getIndice(obj.motif);
        int activated = obj.getIntActivated();
        String updateString = "UPDATE Carte SET motif = ?, activated = ? WHERE Id = ?;";
        try {
            update = Connexion.getInstance().prepareStatement(updateString);
            update.setInt(1, motif);
            update.setInt(2, activated);
            update.setInt(3, obj.getId());
            System.out.println(update);
            update.executeUpdate();
            succes = true;
        } catch (Exception e) {
            succes = false;
            System.out.println("Erreur lors de la suppression");
            e.printStackTrace();
        }
        return succes;
    }

    @Override
    public List<Carte> read() {
        boolean succes = false;
        List<Carte> carteList = new ArrayList<>(Grille.NB_CARTES);
        Carte carte = new Carte();
        ResultSet rs=null;
        PreparedStatement find = null;
        String findString = "SELECT * FROM Carte WHERE Id = ? ;";
        try {
            find = Connexion.getInstance().prepareStatement(findString);
            rs = find.executeQuery();
            while (rs.next()){
                carte.motif = Symbole.get(rs.getInt("motif"));
                carte.isActivated = carte.setActivatedwithint(rs.getInt("motif"));
            }

        } catch (Exception e) {
            succes = false;
            System.out.println("Erreur lors de la recherche");
            e.printStackTrace();
        }
        return carteList;
    }
}

