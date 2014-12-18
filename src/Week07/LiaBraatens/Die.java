package Week07.LiaBraatens;


/**
 * 1011-071_Labs, Purpose: to hold the attributes of a die, including ability to be rolled
 * Class: 1011-071 Thomas  Lab: 7
 * FHT VERSION: 1.1 9/17/2014
 *
 * @author Seth
 * @version 1.0 Created on 10/20/2014 at 1:08 PM.
 */
public class Die
{
    private int numberOfSides;

     /**
     * the default constructor of Die, it creates a 6 sided die
     */
    public Die ()
    {
        this.numberOfSides = 6;
    }

    /**
     * an additional overload constructor for Die that allows for input of the number of sides on the die
     * @param sides the number of sides on the die that is created
     */
    public Die (int sides)
    {
        try
        {
            checkValueRange(sides);
            this.numberOfSides = sides;

        }catch (Week07.LiaBraatens.NotBetweenOneAndOnehundredException e)
        {
            System.out.println();
            if(e.getRelatonToBounds().equalsIgnoreCase("above"))
            {
                //JOptionPane.showMessageDialog(null,e.getLocalizedMessage() + "converting value to 99, the highest possible value","Invalid Input", JOptionPane.ERROR_MESSAGE);
                System.err.println("invalid input detected\n" + e.getLocalizedMessage() + " converting value to 99, the highest possible value");
                this.numberOfSides = 99;
            }
            else if (e.getRelatonToBounds().equalsIgnoreCase("below"))
            {
                System.err.println("invalid input detected\n" + e.getLocalizedMessage() + " converting value to 1, the lowest possible value");
                //JOptionPane.showMessageDialog(null,e.getLocalizedMessage() + "converting value to 1, the lowest possible value","Invalid Input", JOptionPane.ERROR_MESSAGE);
                this.numberOfSides = 0;
            }
        }

    }

    /**
     * creates a random number between 0 and the number of sides of the die (for a six sided die 1-6)
     * @return the number that is rolled
     */
    public int roll ()
    {
        System.out.println("---entered roll()---");
        int ranNum = (int)(Math.random()*numberOfSides);
        System.out.println("created random number: " + ranNum + " returning: " + (ranNum + 1));
        return ranNum + 1;
    }

    /**
     * rolls the die a specific number of times
     * @param times the number of times the die is rolled
     * @return an array of the rolled results
     */
    public int [] roll (int times)
    {
        System.out.println("---entered roll(int)---");
        int [] result = new int[times];
        System.out.println("rolling the " + numberOfSides + " sided die " + times + " times" );
        for (int i = 1; i <= times; i++)
        {
            result [i-1] = this.roll();
            System.out.println("roll number " + i + " of " + times + " is " + result [i-1]);
        }
        return result;
    }

    /**
     * ensures that a input die value is between 1 and 100
     * @param input number of die sides
     * @throws Week07.LiaBraatens.NotBetweenOneAndOnehundredException
     */
    private void checkValueRange(int input) throws Week07.LiaBraatens.NotBetweenOneAndOnehundredException
    {
        if(input < 1 || input > 100)
        {
            throw new Week07.LiaBraatens.NotBetweenOneAndOnehundredException(input);
        }
    }

    /**
     * a class to test the functionality of the Die class
     */
    private void test()
    {
        Die twelveSided = new Die(12);
        System.out.println("trying to initialize the two out of bounds dice, 101 sided first, 0 sided second");
        Die tooBig = new Die(101);
        Die tooSmall = new Die(0);
        Die def = new Die();
        System.out.println("rolling twelveSided" );
        twelveSided.roll();
        System.out.println("\n\nrolling twelveSided 10 times" );
        twelveSided.roll(10);
        System.out.println("\n\nrolling def" );
        def.roll();
        System.out.println("\n\nrolling def 10 times" );
        def.roll(10);

    }

    public static void main(String[] args)
    {
        Die run = new Die();
        try
        {
            run.test();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
