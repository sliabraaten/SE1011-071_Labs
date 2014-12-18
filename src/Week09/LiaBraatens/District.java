package Week09.LiaBraatens;

import java.util.ArrayList;
import java.util.List;

/**
 * 1011-071_Labs, Purpose: to hold a number of parking lots for easy access
 * Class: SE1101-071 Thomas Lab: 9
 * FHT VERSION: 1.1 9/17/2014
 *
 * @author Seth
 * @version 1.0 Created on 11/6/2014 at 9:41 AM.
 *
 * extends District to utilize the functions of List rather than arrayList
 */
public class District extends Week08.LiaBraatens.District
{
    public static final int MAX_LOTS = 20;
    protected List<Week09.LiaBraatens.ParkingLot> lots = new ArrayList<Week09.LiaBraatens.ParkingLot>();
    protected int numLots;

    /**
     * constructor
     */
    public District()
    {
        numLots = 0;
    }

    /**
     * a method to add a lot to the ArrayList of lots
     * @param color the color of the lot to be added
     * @param capacity the capacity of the lot to be added
     * @return the index of the lot that was just added, -1 indicates that the list has more than 20 items
     */
    public int add (String color, int capacity)
    {
        try
        {
            testLessThanMaxLots();
            lots.add(new Week09.LiaBraatens.ParkingLot(color, capacity));
            numLots = lots.size();
            return lots.size() - 1;
        }
        catch (OutsideMaxLotsException OMLE)
        {
            System.err.println(OMLE.getLocalizedMessage() + "\nreturning max value of the array");
            return MAX_LOTS - 1;
        }

    }

    /**
     *
     * @param index the index of the lot that is to be returned
     * @return the parking lot at index(index)
     */
    public ParkingLot getLot (int index)
    {
        try
        {
            return lots.get(index);
        }
        catch (IndexOutOfBoundsException AIOE)
        {
            System.err.println("the index that is trying to be referenced is outside the array, returning the largest index of the array");
        }
        return getLot(MAX_LOTS - 1);
    }

    /**
     *
     * @param lotNumber Number of lot, 0-19
     * @param time      Entry time in minutes since all lots were opened.
     *  only nameable change being its ability to use a List
     */
    @Override
    public void markVehicleEntry(int lotNumber, int time)
    {
        ParkingLot lot = getLot(lotNumber);
        lot.markVehicleEntry(time);
        currentTime = time;
        this.closedMinutes();
    }

    /**
     *
     * @param lotNumber Number of lot, 0-19
     * @param time      Entry time in minutes since all lots were opened.
     * only notable change being its utilization of a List
     */
    @Override
    public void markVehicleExit(int lotNumber, int time)
    {
        ParkingLot lot = getLot(lotNumber);
        lot.markVehicleExit(time);
        currentTime = time;
        this.closedMinutes();
    }

    /**
     *
     * @return the number of vehicles parked in the district
     */
    public int vehiclesParkedInDistrict()
    {
        int vehicles = 0;
        for (ParkingLot i : lots)
            vehicles += i.vehiclesInLot();
        return vehicles;
    }

    /**
     *
     * @return true if all of the lots are closed, false if otherwise
     */
    @Override
    public boolean isClosed()
    {
        boolean closed = true;
        for (ParkingLot i : lots)
            if (!i.isClosed())
                closed = false;

        return closed;
    }

    /**
     *
     * @return the statuses of all of the parking  lots in the ArrayList
     */
    @Override
    public String toString()
    {
        String output = "District status:";
        if (lots.size() > 0)
        {
            for (ParkingLot i : lots) {
                output += "\n" + i;
            }
        }
        else
            output = "No Lots have been entered";
        return output + "\n";
    }

    /**
     *
     * @return true if all the lots are closed
     */
    @Override
    protected boolean allClosed()
    {
        boolean closed = true;
        for (ParkingLot i : lots)
            if (!i.isClosed())
                closed = false;
        return closed;
    }

    /**
     * to test if the addition of another lot will exceed the maximum number of lots specified
     * @throws OutsideMaxLotsException if the attempted entry would put the lot number higher than the max lots
     */
    protected void testLessThanMaxLots () throws OutsideMaxLotsException
    {
        if (lots.size() >= MAX_LOTS)
            throw new OutsideMaxLotsException();
    }

    public static void main(String[] args)
    {

        District test = new District();
        test.add("GREEN", 1);
        test.add("ORANGE", 1);
        int t = test.add("BLUE", 1);
        System.out.println(t +  " should be 2");
        System.out.println(test + "\n___________________________________");
        test.markVehicleEntry(0, 5);
        System.out.println(test + "\n___________________________________");
        test.markVehicleEntry(1, 8);
        System.out.println(test + "\n___________________________________");
        test.markVehicleEntry(2, 9);
        System.out.println(test + "\n___________________________________");

        test = new District ();
        int n = 0;
        for (int i = 0; i < 25; i++) {
            n++;
            String lotNo = "Lot Number " + i;
            test.add(lotNo, 1 + i);
            test.markVehicleEntry(i, i + 5);

        }
        test.markVehicleEntry(21, 6);
        System.out.println(test);
        System.out.println(test.vehiclesParkedInDistrict());



    }
}
