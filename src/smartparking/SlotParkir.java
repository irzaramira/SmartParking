/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartparking;

/**
 *
 * @author irzar
 */
public class SlotParkir {

    private int slotNumber;
    private boolean availability;

    public SlotParkir(int slotNumber, boolean availability) {
        this.slotNumber = slotNumber;
        this.availability = availability;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public boolean getAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
