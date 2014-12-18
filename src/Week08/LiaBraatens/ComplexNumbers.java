package Week08.LiaBraatens;

/**
 * 1011-071_Labs, Purpose: to create a complex number
 * Class: SE1011-071    Lab: N/A
 * FHT VERSION: 1.1 9/17/2014
 *
 * @author Seth
 * @version 1.0 Created on 10/30/2014 at 2:09 PM.
 */
public class ComplexNumbers
{
    private double real, imaginary;

    public ComplexNumbers()
    {
        this(0.0,0.0);
    }

    public ComplexNumbers(double real, double imaginary)
    {
        this.real = real;
        this.imaginary = imaginary;
    }

    public String toString()
    {
        String real, imaginary, operator;
        if (this.real == 0)
            real = "";
        else
            real = this.real + "";

        if (this.imaginary == 0)
            imaginary = "";
        else
            imaginary = Math.abs(this.imaginary) + "i";

        double result =  (this.real/Math.abs(this.real)) + (this.imaginary/Math.abs(this.imaginary));
        if (result < 0)
            operator = " - ";
        else
            operator = " + ";

        return real + operator + imaginary;
    }

    public static void main(String[] args)
    {

        ComplexNumbers test1 = new ComplexNumbers(1, 3);
        ComplexNumbers test2 = new ComplexNumbers(1,-3);
        ComplexNumbers test3 = new ComplexNumbers(-1, 3);
        ComplexNumbers test4 = new ComplexNumbers(-1,-3);

        System.out.println(test1 + " | " + test2 + " | " + test3 + " | " + test4);
    }
}
