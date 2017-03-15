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
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modele.dao.DaoLabo;
import modele.dao.DaoSecteur;
import modele.dao.DaoVisiteur;
import modele.metier.Labo;
import modele.metier.Secteur;
import modele.metier.Visiteur;
import vue.VueVisiteur;

/**
 *
 * @author Windows 8.1
 */
public class CtrlVisiteur implements WindowListener, ActionListener {

    private VueVisiteur vue;         // LA VUE
    private CtrlPrincipal ctrlPrincipal;

    public VueVisiteur getVue() {
        return vue;
    }

    public void setVue(VueVisiteur vue) {
        this.vue = vue;
    }

    public CtrlPrincipal getCtrlPrincipal() {
        return ctrlPrincipal;
    }

    public void setCtrlPrincipal(CtrlPrincipal ctrlPrincipal) {
        this.ctrlPrincipal = ctrlPrincipal;
    }

    // Controlleur de la classe
    public CtrlVisiteur(VueVisiteur vue, CtrlPrincipal ctrl) {
        this.vue = vue;
        this.ctrlPrincipal = ctrl;
        // le contrôleur écoute la vue
        this.vue.addWindowListener(this);
        this.vue.getjButtonChercherVisiteur().addActionListener(this);
        this.vue.getjButtonFermer().addActionListener(this);
        this.vue.getjButtonPrecedent().addActionListener(this);
        this.vue.getjButtonSuivant().addActionListener(this);
        // préparer l'état iniitial de la vue
        afficherLesVisiteur();
    }

    public final void afficherLesVisiteur() {
        List<Visiteur> lesVisiteur = null;
        List<Labo> lesLabo = null;
        List<Secteur> lesSecteur = null;
        try {
            lesVisiteur = DaoVisiteur.selectAll();
            lesSecteur = DaoSecteur.selectAll();
            lesLabo = DaoLabo.selectAll();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            for (Visiteur unVisiteur : lesVisiteur) {
                getVue().getjComboBoxChercher().addItem(unVisiteur);
            }
            for (Secteur unSecteur : lesSecteur) {
                getVue().getjComboBoxSecteur().addItem(unSecteur);
            }
            for (Labo unLabo : lesLabo) {
                getVue().getjComboBoxLabo().addItem(unLabo.getNomLabo());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(getVue(), "CtrlVisiteur - échec de sélection des Visiteur");
        }
    }

    /* public final void afficherLesLab(){
            List<Labo> lesLabo = null;
             try {
            lesLabo = DaoLabo.selectOne(codeLabo);
            for (Visiteur unVisiteur : lesVisiteur) {
                getVue().getjComboBoxChercher().addItem(unVisiteur);
            }
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(getVue(), "CtrlVisiteur - échec de sélection des Visiteur");
            }
    }*/
    public final void afficherVueVisiteur() throws SQLException {

        Visiteur unVisiteur = (Visiteur) vue.getjComboBoxChercher().getSelectedItem();

        getVue().getjTextFieldNom().setText(unVisiteur.getNomVisiteur());
        getVue().getjTextFieldPrenom().setText(unVisiteur.getPrenomVisiteur());
        getVue().getjTextFieldAdresse().setText(unVisiteur.getAdresseVisiteur());
        getVue().getjTextFieldCp().setText(unVisiteur.getCpVisiteur());
        getVue().getjTextFieldNomVille().setText(unVisiteur.getVilleVisiteur());
        getVue().getjComboBoxLabo().setSelectedItem(unVisiteur.getLabo().getNomLabo());

    }

    /*public final int indexLabo(Labo labo) throws SQLException {
        int indexLabo = 0;
        Labo nomLabo = DaoLabo.selectOne(labo.getCodeLabo());

        String nom = nomLabo.getNomLabo();
        switch (nom) {
            case "Bichat":
                indexLabo = 0;
                break;
            case "Gyverny":
                indexLabo = 1;
                break;
            case "Swiss Kane":
                indexLabo = 2;
                break;
        }

        return indexLabo;
    }*/
    private void quitter() {
        ctrlPrincipal.quitterApplication();
    }

    @Override
    public void windowOpened(WindowEvent we) {

    }

    @Override
    public void windowClosing(WindowEvent we) {
        quitter();
    }

    @Override
    public void windowClosed(WindowEvent we) {

    }

    @Override
    public void windowIconified(WindowEvent we) {

    }

    @Override
    public void windowDeiconified(WindowEvent we) {

    }

    @Override
    public void windowActivated(WindowEvent we) {

    }

    @Override
    public void windowDeactivated(WindowEvent we) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /* if (e.getSource().equals(vue.getjButtonVisiteur()) ){
                ctrlPrincipal.afficherLesVisiteur();
            }*/

        if (e.getSource().equals(vue.getjButtonChercherVisiteur())) {
            try {
                afficherVueVisiteur();
            } catch (SQLException ex) {
                Logger.getLogger(CtrlVisiteur.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource().equals(vue.getjButtonPrecedent())) {
            int i = vue.getjComboBoxChercher().getSelectedIndex();
            int z = i - 1;

            if (z > -1) {
                vue.getjComboBoxChercher().setSelectedIndex(z);
                try {
                    afficherVueVisiteur();
                } catch (SQLException ex) {
                    Logger.getLogger(CtrlVisiteur.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (e.getSource().equals(vue.getjButtonSuivant())) {

            int i = vue.getjComboBoxChercher().getSelectedIndex();
            int z = i + 1;

            if (z > i) {
                vue.getjComboBoxChercher().setSelectedIndex(z);
                try {
                    afficherVueVisiteur();
                } catch (SQLException ex) {
                    Logger.getLogger(CtrlVisiteur.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }
}
