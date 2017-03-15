/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

/**
 *
 * @author Dimitri
 */
public class Secteur {

    private String codeSecteur;
    private String libelleSecteur;

    public Secteur() {
        this.codeSecteur = codeSecteur;
        this.libelleSecteur = libelleSecteur;
    }

    public Secteur(String sec_code) {
        this.codeSecteur = sec_code;
    }

    public String getSec_code() {
        return codeSecteur;
    }

    public void setSec_code(String sec_code) {
        this.codeSecteur = sec_code;
    }

    public String getSec_libelle() {
        return libelleSecteur;
    }

    public void setSec_libelle(String sec_libelle) {
        this.libelleSecteur = sec_libelle;
    }

    public Secteur(String sec_code, String sec_libelle) {
        this.codeSecteur = sec_code;
        this.libelleSecteur = sec_libelle;
    }

    @Override
    public String toString() {
        return libelleSecteur;
    }

}
