/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartparking;

import com.sun.tracing.dtrace.DependencyClass;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author irzar
 */
public class SistemParkir {

    static Display_mobil mainFrame1;
    static Display_motor mainFrame2;

    private ArrayList<SlotParkir> slots = null;
    ArrayList<TiketMobil> ticketListMobil = null;
    ArrayList<TiketMotor> ticketListMotor = null;
    SlotParkir slot = null;

    private long startTimeMilliseconds;
    private long startTime = 0;
    private long endTimeMilliseconds;
    private String durationParked;
    private Date date;

    private static final double feeMobil = 2000;
    private static final double feeMotor = 500;
    private static final int minimumTime = 60;
    int timeInMinutes = 0;
    private double totalFeeMobil = 0;
    private double totalFeeMotor = 0;

    public SistemParkir() {
        Parkiran lot = new Parkiran();
        slots = lot.getParkingSlots();

        ticketListMobil = new ArrayList<>(); // to save tickets
        ticketListMotor = new ArrayList<>();
    }

    public TiketMobil parkMobil(String plat, String tipe, String merek) {
        SlotParkir slot = checkAvailability(); // check for available slots

        if (slot != null) {
            startTimeMilliseconds = System.currentTimeMillis();

            TiketMobil ticket = new TiketMobil(slot.getSlotNumber(), startTimeMilliseconds, date, plat, tipe, merek);
            ticketListMobil.add(ticket); // save the ticket in ticketList

            slot.setAvailability(false); // this slot is no more available
            return ticket;
        }
        return null;
    }
    
    public String getPlatMobil(int list){
        return ticketListMobil.get(list - 1).getPlat();
    }
    
    public String getTipeMobil(int list){
        return ticketListMobil.get(list - 1).getTipe();
    }
    
     public String getMerekMobil(int list){
        return ticketListMobil.get(list - 1).getMerek();
    }

    public TiketMotor parkMotor(String plat, int mesin, String merek) {
        SlotParkir slot = checkAvailability(); // check for available slots

        if (slot != null) {
            startTimeMilliseconds = System.currentTimeMillis();

            TiketMotor ticket = new TiketMotor(slot.getSlotNumber(), startTimeMilliseconds, date, plat, mesin, merek);
            ticketListMotor.add(ticket); // save the ticket in ticketList

            slot.setAvailability(false); // this slot is no more available
            return ticket;
        }
        return null;
    }
    
    public String getPlatMotor(int list){
        return ticketListMotor.get(list - 1).getPlat();
    }
    
    public int getMesinMotor(int list){
        return ticketListMotor.get(list - 1).getMesin();
    }
    
     public String getMerekMotor(int list){
        return ticketListMotor.get(list - 1).getMerek();
    }

    public SlotParkir checkAvailability() {
        for (int i = 0; i < slots.size(); i++) {
            slot = slots.get(i);

            // check availability
            if (slot.getAvailability() == true) {
                return slot;
            }
        }
        return null;
    }

    /**
     * This method saves the end time
     */
    public void captureEndTime() {
        // capture end time
        endTimeMilliseconds = System.currentTimeMillis();
    }

    /**
     * This method validates the ticket number entered by the user when exiting
     * the parking lot
     *
     * @param ticketNumEntered entered by the user when exiting from the parking
     * lot
     *
     * @return true if valid slot number is entered else returns false
     */
    public boolean validateTicketNumberMobil(int ticketNumEntered) {
        boolean isValid = false;

        for (int i = 0; i < ticketListMobil.size(); i++) {
            int slotNumber = ticketListMobil.get(i).getSlotNumber();

            if (ticketNumEntered == slotNumber) {
                isValid = true;
                startTime = ticketListMobil.get(i).getStartTime();
                break;
            }
        }
        return isValid;
    }

    public boolean validateTicketNumberMotor(int ticketNumEntered) {
        boolean isValid = false;

        for (int i = 0; i < ticketListMotor.size(); i++) {
            int slotNumber = ticketListMotor.get(i).getSlotNumber();

            if (ticketNumEntered == slotNumber) {
                isValid = true;
                startTime = ticketListMotor.get(i).getStartTime();
                break;
            }
        }
        return isValid;
    }

    /**
     * This method calculates the total time (in minutes) the car was parked in
     * the parking lot
     */
    public void calculateTotalMinutes() {
        long durationMilliSeconds = endTimeMilliseconds - startTime; // total time the card was parked in the slot
        durationParked = convertTimeFormat(durationMilliSeconds);
        String[] time = durationParked.split(":");
        int hours = Integer.parseInt(time[0]);
        int minutes = Integer.parseInt(time[1]);
        int seconds = Integer.parseInt(time[2]);
        timeInMinutes = (hours * 60) + minutes + (seconds / 60);
    }

    /**
     * This method calculate the total fee due payment for the duration the car
     * was parked in the parking lot
     *
     * @return total fee calculated
     */
    public double getTotalFeeMobil() {
        if (totalFeeMobil == 0) {
            if (timeInMinutes < 60) {
                totalFeeMobil = 2000;
            } else {
                totalFeeMobil = (timeInMinutes / minimumTime) * feeMobil;
            }
        }

        return totalFeeMobil;
    }

    public double getTotalFeeMotor() {
        if (totalFeeMotor == 0) {
            if (timeInMinutes < 60) {
                totalFeeMotor = 500;
            } else {
                totalFeeMotor = (timeInMinutes / minimumTime) * feeMotor;
            }
        }

        return totalFeeMotor;
    }
    
    /**
     * This method sets the slot to available once the user choses to exit the
     * parking lot
     *
     * @param ticketNumber slot number where the car was parked
     */
    public void makeSlotAvailable(int ticketNumber) {
        for (int i = 0; i < slots.size(); i++) {
            int slotNumber = slots.get(i).getSlotNumber();

            if (ticketNumber == slotNumber) {
                slot = slots.get(i);
                slot.setAvailability(true);
            }
        }
    }
    
    public String convertTimeFormat(long milliSeconds) {
        // Obtain the total seconds since midnight, Jan 1, 1970
        long totalSeconds = milliSeconds / 1000;
        // Compute the current second in the minute in the hour
        long currentSecond = totalSeconds % 60;
        // Obtain the total minutes
        long totalMinutes = totalSeconds / 60;
        // Compute the current minute in the hour
        long currentMinute = totalMinutes % 60;
        // Obtain the total hours
        long totalHours = totalMinutes / 60;
        // Compute the current hour
        long currentHour = totalHours % 24;

        return currentHour + ":" + currentMinute + ":" + currentSecond;

    }
}
