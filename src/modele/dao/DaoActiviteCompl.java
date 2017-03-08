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
import java.util.Date;
import java.util.List;
import modele.metier.ActiviteCompl;
/**
 *
 * @author btssio
 */
public class DaoActiviteCompl {
    
    
    public static ActiviteCompl selectOne(int Ac_num) throws SQLException {
    
        ActiviteCompl uneActiviteCompl = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM ActiviteCompl WHERE AC_NUM= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, Ac_num);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            int ac_num = rs.getInt("AC_NUM");
            Date ac_date = rs.getDate("AC_DATE");
            String ac_lieu = rs.getString("AC_LIEU");
            String ac_theme = rs.getString("AC_THEME");
            String ac_motif = rs.getString("AC_MOTIF");
            uneActiviteCompl = new ActiviteCompl(ac_num, ac_date, ac_lieu, ac_theme,ac_motif);
        }
        
        return uneActiviteCompl;
    }
    public static List<ActiviteCompl> selectAll() throws SQLException {
        List<ActiviteCompl> lesActiviteCompl = new ArrayList<>();
        ActiviteCompl uneActiviteCompl;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM ACTIVITECOMPL ";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            int ac_num = rs.getInt("AC_NUM");
            Date ac_date = rs.getDate("AC_DATE");
            String ac_lieu = rs.getString("AC_LIEU");
            String ac_theme = rs.getString("AC_THEME");
            String ac_motif = rs.getString("AC_MOTIF");
            uneActiviteCompl = new ActiviteCompl(ac_num, ac_date,ac_lieu, ac_theme, ac_motif);
            lesActiviteCompl.add(uneActiviteCompl);
        }
        return lesActiviteCompl;
    }
    
    public static int insert(int Ac_num, ActiviteCompl uneActiviteCompl) throws SQLException {
        int nb;
        Jdbc jdbc = Jdbc.getInstance();
        String requete;
        ResultSet rs;
        PreparedStatement pstmt;
        requete = "INSERT INTO ACTIVITECOMPL (Ac_num, Ac_date, Ac_lieu, Ac_theme, Ac_motif) VALUES (?, ?, ?, ?, ?)";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, Ac_num);
        pstmt.setDate(2, (java.sql.Date) uneActiviteCompl.getAc_date());
        pstmt.setString(3, uneActiviteCompl.getAc_lieu());
        pstmt.setString(4, uneActiviteCompl.getAc_theme());
        pstmt.setString(5, uneActiviteCompl.getAc_motif());
        nb = pstmt.executeUpdate();
        return nb;
    } 
    
    public static int delete(int Ac_num) throws SQLException {
        int nb;
        Jdbc jdbc = Jdbc.getInstance();
        String requete;
        ResultSet rs;
        PreparedStatement pstmt;
        requete = "DELETE FROM ACTIVITECOMPL WHERE Ac_num = ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, Ac_num);
        nb = pstmt.executeUpdate();
        return nb;
    } 
    
    
    
    
}
