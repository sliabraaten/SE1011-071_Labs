package Week08.LiaBraatens;

import java.util.ArrayList;


/**
 * 1011-071_Labs, Purpose: to create a number of parking lots and collectively change them
 * Class: SE1011-071   Lab: 8
 * FHT VERSION: 1.1 9/17/2014
 *
 * @author Seth
 * @version 1.0 Created on 10/29/2014 at 10:55 AM.
 */
public class District
{
    protected ArrayList<ParkingLot> lotList;
    protected int totalTimeClosed, open, closed, currentTime;
    protected boolean closedBefore = false;

    /**
     * Set up a district with three parking lots.
     *
     * @param color1    Lot 1 identification color
     * @param capacity1 Maximum number of vehicles for lot 1
     * @param color2    Lot 2 identification color
     * @param capacity2 Maximum number of vehicles for lot 2
     * @param color3    Lot 3 identification color
     * @param capacity3 Maximum number of vehicles for lot 3
     */
    public District(final String color1, final int capacity1, String color2, int capacity2, String color3, int capacity3)
    {
        lotList = new ArrayList<ParkingLot>();
        lotList.add(new ParkingLot(color1, capacity1));
        lotList.add(new ParkingLot(color2, capacity2));
        lotList.add(new ParkingLot(color3, capacity3));
    }

    public District()
    {
        lotList = new ArrayList<ParkingLot>();
    }

    /**
     * Display status information for all three lots.
     * See ParkingLot.displayStatus for the format for each.
     */
    public void displayStatus()
    {
        for(ParkingLot i : lotList)
        {
            i.displayStatus();
        }

    }

    /**
     * Record a vehicle entering a given lot at a given time.
     *
     * @param lotNumber Number of lot, 1-3
     * @param time      Entry time in minutes since all lots were opened.
     *                  This calls ParkingLot.markVehicleEntry for the lot corresponding
     *                  to lotNumber (1 -> lot1, 2 -> lot2, 3 -> lot3).
     *                  If lotNumber is out of range, the behavior is unspecified.
     */
    public void markVehicleEntry(int lotNumber, int time)
    {
        lotList.get(lotNumber-1).markVehicleEntry(time);
        currentTime = time;
        this.closedMinutes();
    }

    /**
     * Record a vehicle exiting a given lot at a given time.
     *
     * @param lotNumber Number of lot, 1-3
     * @param time      Entry time in minutes since all lots were opened.
     *                  This calls ParkingLot.markVehicleExit for the lot corresponding
     *                  to lotNumber (1 -> lot1, 2 -> lot2, 3 -> lot3).
     *                  If lotNumber is out of range, the behavior is unspecified.
     */
    public void markVehicleExit(int lotNumber, int time)
    {
        lotList.get(lotNumber-1).markVehicleExit(time);
        currentTime = time;
        this.closedMinutes();
    }

    /**
     * Checks the status of all three lots in the district and
     * returns true if they are all closed and false otherwise.
     *
     * @return whether all lots are closed in the district
     */
    public boolean isClosed()
    {
        double closed = 0;

        for(ParkingLot i : lotList)
        {
            if (i.isClosed())
                closed++;
        }
        return closed == lotList.size();

    }

    /**
     * Computes the time all lots were reported as closed.
     *
     * @return number of minutes all three lots were closed
     */
    public int closedMinutes()
    {
        if (allClosed() && !closedBefore)
        {
            closed = currentTime;
        }
        else if (!allClosed() && closedBefore)
        {
            open = currentTime;
        }

        if (closed != 0 && open != 0)
        {
            totalTimeClosed += open - closed;
            closed = open = 0;
        }
        closedBefore = allClosed();
        return totalTimeClosed;
    }

    /**
     * tests to see if all of the parking lots in the arraylist are closed
     * @return true if all the lots are closed, false otherwise
     */
    protected boolean allClosed()
    {
        boolean closed = true;
        for (ParkingLot i : lotList)
            if (!i.isClosed())
                closed = false;
        return closed;
    }

    /**
     *
     * @return the status and the amount of lots in the district
     */
    public String toString()
    {
        this.displayStatus();
        return "total contents " + lotList.size();
    }

    /*protected boolean allClosed()
    {
        boolean closed = true;
        for (ParkingLot i : lotList)
            if (!i.isClosed())
                closed = false;
        return closed;
    }*/

    public static void main(String [] args)
    {
        District district = new District("1",2,"2",2,"3",2);
        district.markVehicleEntry(2,5);
        district.displayStatus();
    }
}
