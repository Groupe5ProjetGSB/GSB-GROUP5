/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import javax.swing.JOptionPane;

/**
 *
 * @author Windows 8.1
 */
public class CtrlPrincipal {

    CtrlVisiteur ctrlVisiteur;
    CtrlMenuGeneral ctrlMenuGeneral;
    CtrlMedicament ctrlMedicament;
    CtrlPracticien ctrlPracticien;

    public void afficherLesVisiteur() {
        this.ctrlVisiteur.getVue().setVisible(true);
        this.ctrlMenuGeneral.getVue().setVisible(false);
        this.ctrlMedicament.getVue().setVisible(false);
    }

    public void afficherMenuPrincipal() {
        this.ctrlVisiteur.getVue().setVisible(false);
        this.ctrlMenuGeneral.getVue().setVisible(true);
        this.ctrlMedicament.getVue().setVisible(false);
    }

    public void afficherMedicament() {
        this.ctrlVisiteur.getVue().setVisible(false);
        this.ctrlMenuGeneral.getVue().setVisible(false);
        this.ctrlMedicament.getVue().setVisible(true);
    }

    public void afficherPracticien() {
        this.ctrlVisiteur.getVue().setVisible(false);
        this.ctrlMenuGeneral.getVue().setVisible(false);
        this.ctrlMedicament.getVue().setVisible(false);
        this.ctrlPracticien.getVue().setVisible(true);
    }

    public void quitterApplication() {
        // Confirmer avant de quitter
        int rep = JOptionPane.showConfirmDialog(null, "Quitter l'application\nEtes-vous sûr(e) ?", "GSB", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (rep == JOptionPane.YES_OPTION) {
            // mettre fin à l'application
            System.exit(0);
        }

    }

    public CtrlPracticien getCtrlPracticien() {
        return ctrlPracticien;
    }

    public void setCtrlPracticien(CtrlPracticien ctrlPracticien) {
        this.ctrlPracticien = ctrlPracticien;
    }

    public CtrlVisiteur getCtrlVisiteur() {
        return ctrlVisiteur;
    }

    public void setCtrlVisiteur(CtrlVisiteur ctrlVisiteur) {
        this.ctrlVisiteur = ctrlVisiteur;
    }

    public CtrlMenuGeneral getCtrlMenuGeneral() {
        return ctrlMenuGeneral;
    }

    public void setCtrlMenuGeneral(CtrlMenuGeneral ctrlMenuGeneral) {
        this.ctrlMenuGeneral = ctrlMenuGeneral;
    }

    public CtrlMedicament getCtrlMedicament() {
        return ctrlMedicament;
    }

    public void setCtrlMedicament(CtrlMedicament ctrlMedicament) {
        this.ctrlMedicament = ctrlMedicament;
    }

}
