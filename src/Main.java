/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controleur.CtrlMedicament;
import controleur.CtrlMenuGeneral;
import controleur.CtrlPracticien;
import controleur.CtrlPrincipal;
import controleur.CtrlVisiteur;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import modele.dao.Jdbc;
import vue.VueMedicament;
import vue.VueMenuGeneral;
import vue.VuePracticien;
import vue.VueVisiteur;

/**
 *
 * @author btssio
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        // TODO code application logic here
        //DaoConnexion connexion = new DaoConnexion();

        // On test la connexion
        Jdbc.creer("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:", "@localhost:1521:XE", "", "GSB", "gsb");
        //Jdbc.creer("com.mysql.jdbc.Driver", "jdbc:mysql:", "//localhost/", "AGENCEB", "agenceb_util", "secret");
        try {
            Jdbc.getInstance().connecter();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Main - classe JDBC non trouvée");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Main - échec de connexion");
        }

        //Instantiation des vue et des controlleur.
        CtrlPrincipal leControleurPrincipal = new CtrlPrincipal();

        VueVisiteur laVueLesVisiteur = new VueVisiteur();
        CtrlVisiteur leControleurVisiteur = new CtrlVisiteur(laVueLesVisiteur, leControleurPrincipal);
        leControleurPrincipal.setCtrlVisiteur(leControleurVisiteur);

        VueMenuGeneral laVueLeMenuGeneral = new VueMenuGeneral();
        CtrlMenuGeneral leControleurMenuGeneral = new CtrlMenuGeneral(laVueLeMenuGeneral, leControleurPrincipal);
        leControleurPrincipal.setCtrlMenuGeneral(leControleurMenuGeneral);

        VueMedicament laVueMedicament = new VueMedicament();
        CtrlMedicament leControleurMedicament = new CtrlMedicament(laVueMedicament, leControleurPrincipal);
        leControleurPrincipal.setCtrlMedicament(leControleurMedicament);

        VuePracticien laVuePracticien = new VuePracticien();
        CtrlPracticien leControleurPracticien = new CtrlPracticien(laVuePracticien, leControleurPrincipal);
        leControleurPrincipal.setCtrlPracticien(leControleurPracticien);

        // afficher la vue
        laVueLeMenuGeneral.setVisible(true);

    }

}
