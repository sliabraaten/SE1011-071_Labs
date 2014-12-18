package Week10.LiaBraatens;

import Week09.LiaBraatens.ParkingLot;

import java.util.ArrayList;

/**
 * 1011-071_Labs, Purpose: to hold a number of parkinglot values in an arraylist
 * Class: SE1101-071 Thomas  Lab: 10
 * FHT VERSION: 1.1 9/17/2014
 *
 * @author Seth
 * @version 1.0 Created on 11/6/2014 at 1:32 PM.
 *
 * extends week9 district, the only change being from an List to an ArrayList
 */
public class District extends Week09.LiaBraatens.District
{
    protected ArrayList<Week09.LiaBraatens.ParkingLot> lots = new ArrayList<Week09.LiaBraatens.ParkingLot>();
}
