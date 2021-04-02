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
public class TiketMobil extends Tiket{
    private String tipe, merek;
    
    public TiketMobil(int noSlot, long waktumasuk, Date date, String plat){
        super(noSlot,waktumasuk,date,plat);
    }
    
    public TiketMobil(int noSlot, long waktumasuk, Date date, String plat, String tipe, String merek){
        super(noSlot,waktumasuk,date,plat);
        this.tipe=tipe;
        this.merek=merek;
    }

    /**
     * @return the tipe
     */
    public String getTipe() {
        return tipe;
    }

    /**
     * @param tipe the tipe to set
     */
    public void setTipe(String tipe) {
        this.tipe = tipe;
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
