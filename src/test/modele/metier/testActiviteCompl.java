/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.modele.metier;

import java.util.Calendar;
import modele.metier.ActiviteCompl;
import java.util.Date;
/**
 *
 * @author btssio
 */
public class testActiviteCompl {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Date dateAct = new Date(2017-11-1);
       
        ActiviteCompl ActC, ActC1, ActC2;
        System.out.println("\nTest n°1 : instanciation et accesseurs");
        ActC = new ActiviteCompl(1,dateAct, "lieu", "theme", "motif");
        System.out.println(ActC);
        System.out.println("\nTest n°2 : mutateurs");
        ActC.setAc_lieu("56 boulevard de la Prairie aux Ducs");
        ActC.setAc_motif("motif");
        ActC.setAc_theme("le theme ");
        System.out.println(ActC);
        ActC1 = new ActiviteCompl(1,null, null, null, "motif");
        System.out.println(ActC1.equals(ActC));
        ActC2 = new ActiviteCompl(2,null, null, null, "motif");
        System.out.println(ActC1.equals(ActC2));
    
    }
    
}
