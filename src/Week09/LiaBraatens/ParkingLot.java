package Week09.LiaBraatens;

import java.text.DecimalFormat;

/**
 * 1011-071_Labs, Purpose: to hold the attributes of a parkinglot
 * Class: SE 1101-071 Thomas Lab: 9
 * FHT VERSION: 1.1 9/17/2014
 *
 * @author Seth
 * @version 1.0 Created on 11/6/2014 at 11:20 AM.
 *
 * extending ParkingLot, with the most notable change being the reformatted toString
 */
public class ParkingLot extends Week08.LiaBraatens.ParkingLot
{
    /**
     * constructor, reiterates the superclasses constructor
     * @param color the color of the parkingLot
     * @param capacity the capacity of the parkingLot
     */
    public ParkingLot(String color, int capacity)
    {
        super(color,capacity);
    }

    /**
     * constructor, that sets a default name of "test"
     * @param capacity the capacity of the parkingLot
     */
    public ParkingLot(int capacity)
    {
        super(capacity);
    }

    /**
     * updates the status of the parking lot
     * the formatting change occurs from a switch over to DecimalFormat rather than BigDecimal
     */
    @Override
    protected void updateStatus()
    {
        if (this.isClosed())
        {
            status = "CLOSED";
        }
        else
        {
            double percentCap = (((double)vehicles)/capacity)*100;
            DecimalFormat format = new DecimalFormat("#.#");
            status = format.format(percentCap) + "%";
        }
    }

    /**
     * a toString that returns the important values of the parking lot,
     *
     * @return Status for $lotColor parking lot: $numVehicles vehicles ($status)
     * with $status being CLOSED or the percentage closed
     */
    @Override
    public String toString()
    {
        this.updateStatus();
        return "Status for " + color + " parking lot: " + this.vehiclesInLot() + " vehicles ("  + status + ")";
    }

    /**
     * test main
     * @param args unused parameter
     */
    public static void main(String[] args)
    {
        ParkingLot test = new ParkingLot("RED",3);
        test.markVehicleEntry(2);
        System.out.println(test);
        System.out.println("===========================");
        test.test();
    }
}
