/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartparking;

import java.sql.Date;

/**
 *
 * @author irzar
 */
public class TiketMotor extends Tiket{
    private int mesin;
    private String merek;
    
    public TiketMotor(int noSlot, long waktumasuk, Date date, String plat){
        super(noSlot,waktumasuk,date,plat);
    }
    
    public TiketMotor(int noSlot, long waktumasuk, Date date, String plat, int mesin, String merek){
        super(noSlot,waktumasuk,date,plat);
        this.mesin=mesin;
        this.merek=merek;
    }

    /**
     * @return the mesin
     */
    public int getMesin() {
        return mesin;
    }

    /**
     * @param mesin the mesin to set
     */
    public void setMesin(int mesin) {
        this.mesin = mesin;
    }

    /**
     * @return the merek
     */
    public String getMerek() {
        return merek;
    }

    /**
     * @param merek the merek to set
     */
    public void setMerek(String merek) {
        this.merek = merek;
    }
    
}
