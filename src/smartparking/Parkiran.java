/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartparking;

import java.util.ArrayList;

public class Parkiran {

    private static final int numberOfSlots = 10;

    private ArrayList<SlotParkir> listOfSlots = null;

    public Parkiran() {
        listOfSlots = new ArrayList<>();
    }

    /**
     * This method returns list of all the parking slots
     *
     * @return list of the slots in the parking lot
     */
    public ArrayList<SlotParkir> getParkingSlots() {
        for (int i = 1; i <= numberOfSlots; i++) {
            SlotParkir slot = new SlotParkir(i, true);
            listOfSlots.add(slot);
        }
        return listOfSlots;
    }

}
