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
import modele.metier.ActiviteCompl;
import java.util.List;
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
    
    
}
