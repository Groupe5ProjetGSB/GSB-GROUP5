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
import modele.metier.Visiteur;

/**
 *
 * @author Windows 8.1
 */
public class DaoVisiteur {
    
    
     /**
     * selectOne : lire un enregistrement dans la table CLIENT
     *
     * @param numClient : identifiant conceptuel du client recherché
     * @return une instance de la classe Adresse
     * @throws SQLException
     */
//    public static Client selectOne(String numClient) throws SQLException {
//        Client unClient = null;
//        ResultSet rs = null;
//        PreparedStatement pstmt;
//        Jdbc jdbc = Jdbc.getInstance();
//        // préparer la requête
//        String requete = "SELECT * FROM CLIENT WHERE NUMCLIENT= ?";
//        pstmt = jdbc.getConnexion().prepareStatement(requete);
//        pstmt.setString(1, numClient);
//        rs = pstmt.executeQuery();
//        if (rs.next()) {
//            unClient = DaoClient.clientFromResultSet(rs);
//        }
//        return unClient;
//    }

//    /**
//     * lire tous les enregistrements de la table CLIENT
//     *
//     * @return une collection d'instances de la classe Client
//     * @throws SQLException
//     */
//   /* public static List<Visiteur> selectAll() throws SQLException {
//        List<Visiteur> lesVisiteur = new ArrayList<Visiteur>();
//        Visiteur unVisiteur = null;
//        ResultSet rs;
//        PreparedStatement pstmt;
//        Jdbc jdbc = Jdbc.getInstance();
//         préparer la requête
//        String requete = "SELECT * FROM VISITEUR";
//        pstmt = jdbc.getConnexion().prepareStatement(requete);
//        rs = pstmt.executeQuery();
//        while (rs.next()) {
//            int id = rs.getInt("ID");
//            String rue = rs.getString("RUE");
//            String cdp = rs.getString("CDP");
//            String ville = rs.getString("VILLE");
//            unVisiteur = new Visiteur(id, rue, cdp, ville);
//            lesVisiteur.add(unVisiteur);
//        }
//        return lesVisiteur;
//    }

    /**
     * Extrait un enregistrement du "ResultSet" issu de la table CLIENT
     *
     * @param rs : ResultSet lu dans la table CLIENT
     * @return instance de Client, initialisée d'après le premier enregistrement
     * du ResultSet
     * @throws SQLException
     */
//    private static Client clientFromResultSet(ResultSet rs) throws SQLException {
//        Client clt = null;
//        String numClient = rs.getString("NUMCLIENT");
//        int idAdresse = rs.getInt("ID_ADRESSE");
//        String nom = rs.getString("NOM");
//        String prenom = rs.getString("PRENOM");
//        String login = rs.getString("LOGIN");
//        String mdp = rs.getString("MOTDEPASSE");
//        java.sql.Date ddn = rs.getDate("DATEDENAISSANCE");
//        clt = new Client(numClient, nom, prenom, login, DaoClient.toUtilDate(ddn));
//        clt.setMotDePasse(mdp);
//        Adresse adr = DaoAdresse.selectOne(idAdresse);
//        clt.setAdresse(adr);
//        return clt;
//    }

    /**
     * conversion de java.util.Date vers java.sql.Date
     *
     * @param uneDate java.util.Date
     * @return java.sql.Date
     */
    public static java.sql.Date toSqlDate(java.util.Date uneDate) {
        return new java.sql.Date(uneDate.getTime());
    }

    /**
     * conversion de java.sql.Date vers java.util.Date
     *
     * @param uneDate java.sql.Date
     * @return java.util.Date
     */
    public static java.util.Date toUtilDate(java.sql.Date uneDate) {
        return new java.util.Date(uneDate.getTime());
    }

    /**
     * insert : ajouter un enregistrement dans la table CLIENT
     *
     * @param unClient : instance de la classe Client à enregistrer dans la
     * table CLIENT
     * @param idAdresse : clef étrangère vers la table ADRESSE ; à déterminer
     * avant
     * @return : 1 si l'enregistrement a eu lieu ; en cas d'erreur, une
     * exception est émise
     * @throws SQLException
     */
//    public static int insert(Client unClient, int idAdresse) throws SQLException {
//        int nb;
//        Jdbc jdbc = Jdbc.getInstance();
//        String requete;
//        ResultSet rs;
//        PreparedStatement pstmt;
//        requete = "INSERT INTO CLIENT (ID, NUMCLIENT,ID_ADRESSE,NOM,PRENOM,LOGIN,MOTDEPASSE,DATEDENAISSANCE)";
//        requete += " VALUES (null, ?, ?, ?, ?, ?, ?, ?)";
//        pstmt = jdbc.getConnexion().prepareStatement(requete);
//        pstmt.setString(1, unClient.getNumClient());
//        pstmt.setInt(2, idAdresse);
//        pstmt.setString(3, unClient.getNom());
//        pstmt.setString(4, unClient.getPrenom());
//        pstmt.setString(5, unClient.getLogin());
//        pstmt.setString(6, unClient.getMotDePasse());
//        pstmt.setDate(7, DaoClient.toSqlDate(unClient.getDateNaissance()));
//        nb = pstmt.executeUpdate();
//        return nb;
//    }

    /**
     * update : modifier un enregistrement de la table CLIENT
     *
     * @param numClient : identifiant conceptuel du client à modifier
     * @param unClient : instance de la classe Client contenant les nouvelles
     * valeurs à enregistrer dans la table CLIENT sous le même identifiant
     * @param idAdresse : identifiant relationnel de la table Adresse (clef étrangère)
     * @return : 1 si l'enregistrement a eu lieu ; en cas d'erreur, une
     * exception est émise
     * @throws SQLException
     */
//    public static int update(String numClient, Client unClient, int idAdresse) throws SQLException {
//        int nb;
//        Jdbc jdbc = Jdbc.getInstance();
//        String requete;
//        ResultSet rs;
//        PreparedStatement pstmt;
//        requete = "UPDATE CLIENT SET ID_ADRESSE = ?,NOM = ?,PRENOM = ?,LOGIN = ?,MOTDEPASSE = ?,";
//        requete += " DATEDENAISSANCE= ? WHERE NUMCLIENT = ?";
//        pstmt = jdbc.getConnexion().prepareStatement(requete);
//        pstmt.setInt(1, idAdresse);
//        pstmt.setString(2, unClient.getNom());
//        pstmt.setString(3, unClient.getPrenom());
//        pstmt.setString(4, unClient.getLogin());
//        pstmt.setString(5, unClient.getMotDePasse());
//        pstmt.setDate(6, DaoClient.toSqlDate(unClient.getDateNaissance()));
//        pstmt.setString(7, numClient);
//        nb = pstmt.executeUpdate();
//        return nb;
//    }

    /**
     * delete : supprimer un enregistrement de la table CLIENT
     * @param numClient : identifiant conceptuel du client à supprimer
     * @return : 1 si la suppression a eu lieu ; en cas d'erreur, une exception est émise
     * @throws SQLException 
//     */
//    public static int delete(String numClient) throws SQLException {
//        int nb;
//        Jdbc jdbc = Jdbc.getInstance();
//        String requete;
//        ResultSet rs;
//        PreparedStatement pstmt;
//        requete = "DELETE  FROM CLIENT WHERE NUMCLIENT = ?";
//        pstmt = jdbc.getConnexion().prepareStatement(requete);
//        pstmt.setString(1, numClient);
//        nb = pstmt.executeUpdate();
//        return nb;
//    }    
    
}
