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
public class Labo {

    private String codeLabo;

    private String nomLabo;

    private String chefVenteLabo;

    public Labo(String codeLabo, String nomLabo, String chefVenteLabo) {
        this.codeLabo = codeLabo;
        this.nomLabo = nomLabo;
        this.chefVenteLabo = chefVenteLabo;
    }

    public Labo(String nomLabo, String chefVenteLabo) {
        this.nomLabo = nomLabo;
        this.chefVenteLabo = chefVenteLabo;
    }

    public Labo(String codeLabo) {
        this.codeLabo = codeLabo;
    }

    public String getCodeLabo() {
        return codeLabo;
    }

    public void setCodeLabo(String codeLabo) {
        this.codeLabo = codeLabo;
    }

    public String getNomLabo() {
        return nomLabo;
    }

    public void setNomLabo(String nomLabo) {
        this.nomLabo = nomLabo;
    }

    public String getChefVenteLabo() {
        return chefVenteLabo;
    }

    public void setChefVenteLabo(String chefVenteLabo) {
        this.chefVenteLabo = chefVenteLabo;
    }

    @Override
    public String toString() {
        return nomLabo;
    }

}
