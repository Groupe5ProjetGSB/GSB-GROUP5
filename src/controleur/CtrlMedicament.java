/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import vue.VueMedicament;

/**
 *
 * @author Dimitri
 */
public class CtrlMedicament implements ActionListener, WindowListener {

    VueMedicament vue;
    CtrlPrincipal ctrlPrincipal;

    public CtrlMedicament(VueMedicament vue, CtrlPrincipal controleurPrincipal) {
        this.vue = vue;
        this.ctrlPrincipal = controleurPrincipal;

        this.vue.addWindowListener(this);
        this.vue.getjButtonSuivantMedic().addActionListener(this);
        this.vue.getjButtonPrecedentMedic().addActionListener(this);
        this.vue.getjButtonFermerMedic().addActionListener(this);

    }

    private void quitter() {
        ctrlPrincipal.quitterApplication();
    }

    public VueMedicament getVue() {
        return vue;
    }

    public void setVue(VueMedicament vue) {
        this.vue = vue;
    }

    public CtrlPrincipal getControleurPrincipal() {
        return ctrlPrincipal;
    }

    public void setControleurPrincipal(CtrlPrincipal controleurPrincipal) {
        this.ctrlPrincipal = controleurPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        quitter();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        if (e.getSource().equals(this.vue.getjButtonSuivantMedic())) {
            //Dire ce qu'il faut faire

        } else if (e.getSource().equals(this.vue.getjButtonPrecedentMedic())) {
            //Dire ce qu'il faut faire
        } else if (e.getSource().equals(this.vue.getjButtonFermerMedic())) {
            //Dire ce qu'il faut faire

        }
    }

}
