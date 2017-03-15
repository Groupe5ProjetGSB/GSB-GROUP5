/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modele.metier.Labo;
import modele.metier.Secteur;

/**
 *
 * @author Dimitri
 */
public class DaoSecteur {

    public static List<Secteur> selectAll() throws SQLException {
        List<Secteur> lesSecteur = new ArrayList<Secteur>();
        Secteur unSecteur = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();

        //Requête
        String requete = "SELECT * FROM SECTEUR";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            String codeSecteur = rs.getString("SEC_CODE");
            String libelleSecteur = rs.getString("SEC_LIBELLE");
            unSecteur = new Secteur(codeSecteur, libelleSecteur);
            lesSecteur.add(unSecteur);
        }
        return lesSecteur;
    }

    public static Secteur selectOne(String codeSecteur) throws SQLException {
        Secteur unSecteur = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM SECTEUR WHERE SEC_CODE= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, codeSecteur);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            String leSecteur = rs.getString("SEC_CODE");
            unSecteur = new Secteur(leSecteur);
        }
        return unSecteur;

    }
}
