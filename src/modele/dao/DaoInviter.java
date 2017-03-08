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
import modele.metier.Inviter;

/**
 *
 * @author btssio
 */
public class DaoInviter {
    
    
    /**
     * lire tous les enregistrements de la table CLIENT
     *
     * @return une collection d'instances de la classe Client
     * @throws SQLException
     */
    public static List<Inviter> selectAll() throws SQLException {
        List<Inviter> lesInviter = new ArrayList<Inviter>();
        Inviter unInviter = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
         //préparer la requêtel
        String requete = "SELECT * FROM INVITER";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            int Ac_num = rs.getInt("Ac_num");
            int Pra_num = rs.getInt("Pra_num");
            int Specialisteon = rs.getInt("Specialisteon");
            unInviter = new Inviter(Ac_num,Pra_num,Specialisteon);
            lesInviter.add(unInviter);
        }
        return lesInviter;
    }

//    
//        public static Inviter selectOne(int ac_num) throws SQLException {
//        Inviter unInviter = null;
//        ResultSet rs = null;
//        PreparedStatement pstmt;
//        Jdbc jdbc = Jdbc.getInstance();
//        // préparer la requête
//        String requete = "SELECT * FROM INVITER WHERE ac_num= ?";
//        pstmt = jdbc.getConnexion().prepareStatement(requete);
//        pstmt.setInt(1, ac_num);
//        rs = pstmt.executeQuery();
//        if (rs.next()) {
//            unInviter = DaoInviter.inviterFromResultSet(rs);
//        }
//        return unInviter;
//    }
//        private static Inviter inviterFromResultSet(ResultSet rs) throws SQLException {
//        Inviter Inv = null;
//        String numClient = rs.getString("NUMCLIENT");
//        int idAdresse = rs.getInt("ID_ADRESSE");
//        String nom = rs.getString("NOM");
//        String prenom = rs.getString("PRENOM");
//        String login = rs.getString("LOGIN");
//        String mdp = rs.getString("MOTDEPASSE");
//        java.sql.Date ddn = rs.getDate("DATEDENAISSANCE");
//        Inv = new Inviter(numClient, nom, prenom, login, DaoInviter.toUtilDate(ddn));
//        Inv.setMotDePasse(mdp);
//        Adresse adr = DaoAdresse.selectOne(idAdresse);
//        Inv.setAdresse(adr);
//        return Inv;
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
        
}
