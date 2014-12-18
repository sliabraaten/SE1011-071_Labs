package Week06.LiaBraatens;

import java.text.DecimalFormat;

/**
 * 1011-071_Labs, Purpose: to estimate the cost of a house
 * Class: 1101-071 Thomas Lab: 6
 * FHT VERSION: 1.1 9/17/2014
 *
 * @version 1.0 Created on 10/15/2014 at 3:21 PM.
 * @author Seth
 */
public class HouseEstimator
{
    DecimalFormat format = new DecimalFormat("#.#");
    private double cost, garages;
    private int fullBaths, halfBaths, bedrooms, windows, squareFeet;

    /**
     * to set the square footage of the house
     * @param squareFeet the square footage of the house
     */
    public void setSquareFeet (int squareFeet)
    {
        this.squareFeet = squareFeet;
    }

    /**
     * to set the number of half bathrooms in the house
     * @param numFullBaths the total number of full bathrooms in the house
     */
    public void setNumFullBaths (int numFullBaths)
    {
        this.fullBaths = numFullBaths;
    }

    /**
     * to set the number of half bathrooms in the house
     * @param numHalfBaths the total number of half bathrooms in the house
     */
    public void setNumHalfBaths (int numHalfBaths)
    {
        this.halfBaths = numHalfBaths;
    }

    /**
     * to set the number of bedrooms in the house
     * @param numBedrooms the total number of bedrooms in the house
     */
    public void setNumBedrooms (int numBedrooms)
    {
        this.bedrooms = numBedrooms;
    }

    /**
     * to set the number of windows in the house
     * @param numWindows the number of windows in the house
     */
    public void setNumWindows (int numWindows)
    {
        this.windows = numWindows;
    }

    /**
     * to set the number of garages the house has
     * @param numGarages the number of garages the house has
     */
    public void setNumGarages (double numGarages)
    {
        this.garages = numGarages;
    }

    /**
     * to return the cost the house is to build, after all of the parameters are entered
     * COST BREAKDOWN:
     * $100 per square foot
     * $10,000 per bathroom
     * $7,000 per half bathroom
     * $5,000 per bedroom
     * $500 per window
     * $5,000 per garage stall
     *
     * @return total cost to build
     */
    public double costToBuild()
    {
        cost += squareFeet*100;
        cost += fullBaths*10000;
        cost += halfBaths*7000;
        cost += bedrooms*5000;
        cost += windows*500;
        cost += garages*5000;
        return cost;
    }

    /**
     * to return the number of bathrooms in the house
     * @return the number of full bathrooms in the house
     */
    public int getNumFullBaths ()
    {
        return fullBaths;
    }

    /**
     * to return the number of half bathrooms in the house
     * @return the number of half bathrooms
     */
    public int getNumHalfBaths ()
    {
        return halfBaths;
    }

    /**
     * to return the number of windows the house has
     * @return the number of windows in the house
     */
    public int getNumWindows ()
    {
        return windows;
    }

    /**
     * to return the number of bedrooms in the house
     * @return the number of bedrooms in the house
     */
    public int getNumBedrooms()
    {
        return bedrooms;
    }

    /**
     * to return the number of garages in the house
     * @return the number of garages in the house
     */
    public double getNumGarages ()
    {
        return Double.parseDouble(format.format(garages));
    }

    /**
     * to return the number of square feet in the house
     * @return the number of square feet in the house
     */
    public int getSquareFeet()
    {
        return squareFeet;
    }

}
