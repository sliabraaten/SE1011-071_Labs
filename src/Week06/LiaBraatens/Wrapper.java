package Week06.LiaBraatens;

/**
 * 1011-071_Labs, Purpose: to test the use of a Double wrapper class
 * Class: 1011-071 Thomas   Lab: N/A
 * FHT VERSION: 1.1 9/17/2014
 *
 * @version 1.0 Created on 10/18/2014 at 2:01 PM.
 * @author Seth
 */
public class Wrapper
{
    public static void main(String[] args)
    {
        double x = 44.5;
        double y = 44.5;
        Double xW = new Double(x);
        Double yW = new Double(y);

        System.out.println(xW == yW);
        System.out.println(xW.doubleValue() == yW.doubleValue());
        System.out.println(xW.equals(yW));
        System.out.println(xW.compareTo(yW));
        yW = new Double(y + 3.);
        System.out.println(xW.compareTo(yW));
        yW = new Double(Double.NEGATIVE_INFINITY);
        System.out.println(yW.isInfinite());
    }
}
