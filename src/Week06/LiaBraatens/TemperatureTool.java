package Week06.LiaBraatens;

/**
 * 1011-071_Labs, Purpose: to learn arrays
 * Class: 1101-071 Thomas Lab: N/A
 * FHT VERSION: 1.1 9/17/2014
 *
 * @version 1.0 Created on 10/17/2014 at 3:44 PM.
 * @author Seth
 */
public class TemperatureTool
{
    public static void main(String[] args)
    {
        double [] temperature = new double [24];

        for (int i = 0; i < temperature.length; i++)
        {
            temperature[i] = 1.2*i;
        }

        int k = 0;
        for (double i : temperature)
        {
            System.out.println("temp hour for " + k + " is " + i);
            k++;
        }

    }
}
