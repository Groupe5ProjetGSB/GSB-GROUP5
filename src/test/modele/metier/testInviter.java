/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.modele.metier;

import modele.metier.Inviter;

/**
 *
 * @author btssio
 */
public class testInviter {
    
        public static void main(String[] args) {
        Inviter inv, inv2, inv3;
        System.out.println("\nTest n°1 : instanciation et accesseurs");
        inv = new Inviter(1, 44230,2);
        System.out.println(inv);
        System.out.println("\nTest n°2 : mutateurs");
        inv.setAc_num(56);
        inv.setPra_num(5);
        inv.setSpecialisteon(5);
        System.out.println(inv);
        inv2 = new Inviter(1,0, 0);
        System.out.println(inv2.equals(inv2));
        inv3 = new Inviter(2,0, 0);
        System.out.println(inv3.equals(inv3));
    }
    
}
