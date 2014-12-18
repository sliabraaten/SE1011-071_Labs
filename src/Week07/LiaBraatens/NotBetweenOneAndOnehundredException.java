package Week07.LiaBraatens;

/**
 * 1011-071_Labs, Purpose: to identify numbers that are outside of the range 1-100
 * Class:1011-071 Thomas  Lab: 4
 * FHT VERSION: 1.1 9/17/2014
 *
 * @version 1.0 Created on 10/5/2014 at 7:51 PM. REVISED: 10/20/14
 * @author Seth
 */
public class NotBetweenOneAndOnehundredException extends Exception
{
    private int userNumberInput;

    /**
     * the constructor
     * @param userNumberInput the number that is input by the user that is supposedly not between 1 and 100
     */
    public NotBetweenOneAndOnehundredException(int userNumberInput)
    {
        this.userNumberInput = userNumberInput;
    }

    /**
     *
     * @return the inappropriate number and the bounds of what it should be
     */
    @Override
    public String getLocalizedMessage()
    {
        return this.userNumberInput + ", the number entered is not between 1 and 100";
    }

    /**
     * 
     * @return getLocalizedMessage()
     */
    public String toString()
    {
        return this.getLocalizedMessage();
    }

    /**
     * gets the input number of the user
     * @return userNumberInput
     */
    public int getNumberInput ()
    {
        return userNumberInput;
    }

    /**
     * a method that returns the userNumberInput's relation to the bounds (1 - 100)
     * @return a String that shows the number is greater than or less than bounds
     */
    public String getRelatonToBounds ()
    {
        if (userNumberInput >= 100)
            return "above";
        else if (userNumberInput <= 1)
            return "below";
        return "err";
    }

}
