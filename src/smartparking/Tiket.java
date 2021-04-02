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
public class Tiket {
    private int slotNumber;
    private long startTime;
    private Date date;
    private String plat;

    public Tiket(int slotNumber, long startTime, Date date, String plat) {
        this.slotNumber = slotNumber;
        this.startTime = startTime;
        this.date = date;
        this.plat = plat;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public long getStartTime() {
        return startTime;
    }

    public Date getDate() {
        return date;
    }

    /**
     * @return the plat
     */
    public String getPlat() {
        return plat;
    }

    /**
     * @param plat the plat to set
     */
    public void setPlat(String plat) {
        this.plat = plat;
    }
}
