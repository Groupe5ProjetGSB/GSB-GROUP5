/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

import java.util.logging.Logger;

/**
 *
 * @author Dimitri
 */
public class Inviter {

    private int ac_num;
    private int pra_num;
    private int specialisteon;


   
    public int getAc_num() {
        return ac_num;
    }

    public void setAc_num(int ac_num) {
        this.ac_num = ac_num;
    }

    public int getPra_num() {
        return pra_num;
    }

    public void setPra_num(int pra_num) {
        this.pra_num = pra_num;
    }
    
    public void setSpecialisteon(int specialisteon) {
        this.specialisteon = specialisteon;
    }

    public int getSpecialisteon() {
        return specialisteon;
    }

    public Inviter(int ac_num, int pra_num, int specialisteon) {
        this.ac_num = ac_num;
        this.pra_num = pra_num;
        this.specialisteon = specialisteon;
    }


}
