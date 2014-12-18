package Week04;

/**
 * 1011-071_Labs, Purpose: to identify numbers that are outside of the range 1-100
 * Class:1011-071 Thomas  Lab: 4
 * FHT VERSION: 1.1 9/17/2014
 *
 * @version 1.0 Created on 10/5/2014 at 7:51 PM.
 * @author: Seth
 */
public class NotBetweenOneAndOnehundredException extends Exception
{
    private int userNumberInput;

    public NotBetweenOneAndOnehundredException(int userNumberInput)
    {
        this.userNumberInput = userNumberInput;
    }

    @Override
    public String getLocalizedMessage()
    {
        return "number entered is not between 1 and 100";
    }

    public String toString()
    {
        return userNumberInput + " is not between 1 and 100 please re-enter number";
    }

}
