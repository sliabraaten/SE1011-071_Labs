package Week08.LiaBraatens;

import java.math.BigDecimal;

/**
 * 1011-071_Labs, Purpose: to track the cars that enter a parking lot
 * Class: SE-1011-071    Lab: 8
 * FHT VERSION: 1.1 9/17/2014
 *
 * @author Seth
 * @version 1.0 Created on 10/29/2014 at 10:55 AM.
 */
public class ParkingLot
{
    public static final double CLOSED_THRESHOLD = 80.0;
    public static final double PERCENT_CLOSED_THRESHOLD = CLOSED_THRESHOLD/100.0;
    protected String color, status;
    protected int capacity, vehicles, currentTime, closeTime, openTime, closedMinutes;
    protected boolean closed = false;

    /**
     * the constructor
     * @param color the name "color" of the parking lot, to help people remember where they parked
     * @param capacity the amount of cars that the parking lot holds
     */
    public ParkingLot(String color, int capacity)
    {
        this.color = color;
        this.capacity = capacity;
        vehicles = 0;
        currentTime = 0;
        closed = false;
    }

    /**
     * the other (lesser) constructor, color of the lot is defaulted to "test"
     * @param capacity the amount of cars that the parking lot holds
     */
    public ParkingLot(int capacity)
    {
        this("test", capacity);
    }

    /**
     *
     * @return the color (name) of the parking lot
     */
    public String getColor()
    {
        return this.color;
    }

    /**
     * to set the time of a vehicle entering the parking lot
     * @param time the time at which the vehicle enters
     */
    public void markVehicleEntry(int time)
    {
        if (time >= currentTime)
        {
            vehicles++;
            updateTime(time);
        }
    }

    /**
     * to set the time of a vehicle exiting the parking lot
     * @param time the time at which the vehicle exits
     */
    public void markVehicleExit(int time)
    {
        if (time >= currentTime)
        {
            vehicles--;
            updateTime(time);
        }

    }

    /**
     * gets the number of vehicles in the parking lot
     * @return the number of vehicles
     */
    public int vehiclesInLot()
    {
        return vehicles;
    }

    /**
     * to update the time of the lot closing or opening
     * @param time the current time
     */
    protected void updateTime(int time)
    {
        currentTime = time;
        if (isClosed()&& !closed)
        {
            closeTime = currentTime;
        }
        else if (!isClosed() && closed)
        {
            openTime = currentTime;
        }
        closed = isClosed();
        if (openTime != 0 && closeTime != 0)
        {
            closedMinutes += openTime - closeTime;
            closeTime = openTime = 0;
        }


    }

    /**
     * to check if the lot is closed (filled greater than its threshold )or not
     * @return true if the lot is closed, false if it is not
     */
    public boolean isClosed()
    {
        return  ((double) capacity * PERCENT_CLOSED_THRESHOLD) <= vehicles;
    }

    /**
     *
     * @return the number of minutes that the lot is closed
     */
    public int closedMinutes()
    {
        return closedMinutes;
    }

    /**
     * display the current status of the parking lot
     * it's name and percent full (or closed)
     */
    public void displayStatus()
    {
        this.updateStatus();
        System.out.println(status);
    }

    /**
     * to update the status to the most current percent filled
     */
    protected void updateStatus()
    {
        if (this.isClosed())
        {
            status = this.getColor() + " is: CLOSED";
        }
        else
        {
            double percentCap = (((double)vehicles)/capacity)*100;
            BigDecimal percentUsed = new BigDecimal(percentCap);
            status = this.getColor() + " is: " + percentUsed.setScale(1, BigDecimal.ROUND_HALF_UP) + "% full";
        }
    }

    /**
     *
     * @return the color, capacity, its current contents and its status
     */
    @Override
    public String toString()
    {
        this.updateStatus();
        return color + " parking lot has a capacity of " + capacity + "\nit contains " + this.vehiclesInLot() + " vehicles therefore "  + status;
    }

    /**
     * a method to test the functionality of ParkingLot
     */
    public void test()
    {
        ParkingLot plot = new ParkingLot(5);
        System.out.println(plot);
        for (int i = 5; i <= 10; i++)
        {
            plot.markVehicleEntry(i);
            System.out.println("Vehicles in lot: " + plot.vehiclesInLot());
            plot.displayStatus();
            System.out.println("Closed?: " + plot.isClosed());
            System.out.println("Closed minutes: " + plot.closedMinutes() + " CURR MIN: " + i);

        }
        System.out.println("exiting vehicles");
        for (int i = 10; i <= 15; i++)
        {
            plot.markVehicleExit(i);
            System.out.println("Vehicles in lot: " + plot.vehiclesInLot());
            plot.displayStatus();
            System.out.println("Closed?: " + plot.isClosed());
            System.out.println("Closed minutes: " + plot.closedMinutes() + " CURR MIN: " + i);
        }
        System.out.println("Final closed min: " + plot.closedMinutes());
    }

    public static void main(String[] args)
    {
       ParkingLot test = new ParkingLot(6);
        test.test();
    }
}

