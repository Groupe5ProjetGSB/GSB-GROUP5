/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.modele.metier;

import modele.metier.ActiviteCompl;
/**
 *
 * @author btssio
 */
public class testActiviteCompl {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ActiviteCompl ActC, adr1, adr2;
        System.out.println("\nTest n°1 : instanciation et accesseurs");
        ActC = new ActiviteCompl(1, ,  );
        System.out.println(adr);
        System.out.println("\nTest n°2 : mutateurs");
        ActC.setRue("56 boulevard de la Prairie aux Ducs");
        ActC.setCp("44265");
        ActC.setVille("Nantes");
        System.out.println(ActC);
        adr1 = new ActiviteCompl(1,null, null, null);
        System.out.println(adr1.equals(adr));
        adr2 = new ActiviteCompl(2,null, null, null);
        System.out.println(adr1.equals(adr2));
    
    }
    
}
