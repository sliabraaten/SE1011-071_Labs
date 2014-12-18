package Week05.LiaBraatens;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * 1011-071_Labs, Purpose: to take user input of points and return the distance and angle between two points
 * Class: 1101-071 Thomas  Lab: 5
 * FHT VERSION: 1.1 9/17/2014
 *
 * @version 1.0 Created on 10/8/2014 at 3:39 PM.
 * @author : Seth
 */

public class LabAssignment5_LibraryFunctions
{
    private double [] point1 = new double [2];
    private double [] point2 = new double [2];
    private String enterPoint1 = "Enter Point 1";
    private String enterPoint2 = "Enter Point 2";
    private static boolean enteredA, enteredB;

    public static void main(String [] args)
    {
       LabAssignment5_LibraryFunctions run = new LabAssignment5_LibraryFunctions();
        boolean cont;
        enteredA = enteredB = false;
        do
        {
            try
            {
                cont = run.run();
            } catch (NumberFormatException e)
            {
                System.err.println("invalid input");
                cont = true;
            } catch (NullPointerException e)
            {
                System.err.println("exited current menu");
                cont = true;
            }

        }while(cont);
    }

    public boolean run()
    {

        DecimalFormat standardFormat = new DecimalFormat("#.#");
        boolean cont = true;
        String userInput;
        ArrayList<String> optionsList  = intitializeOptionsList();
        System.out.println("Created options arrayList...\n\ninputOptions size: " + optionsList.size() + " " + optionsList);
        String [] optionsArray = new String[optionsList.size()];
        System.out.println("created array with length: " + optionsArray.length);
        optionsList.toArray(optionsArray);  //check swing docs for input of array list
        for (String i : optionsArray)
            System.out.println(i);

        userInput = (String)JOptionPane.showInputDialog(null, "Welcome to Surveyor's Assistant","Main Menu",JOptionPane.PLAIN_MESSAGE,null,optionsArray,null); //"enter first point, enter second point, calculate distance(show point values), calculate heading(show point values)");
        double userInputN, userInputE;
        switch (optionsList.indexOf(userInput))
        {
            case -1:
                System.err.println("entered case -1");
                cont = false;
                break;
            case 0:
                //user is inputting for point A (1) in meters (add custom button for conversion)
                System.out.println("---entered case 0--\npoint A (1) input");
                userInputN = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the north value for point 1\nUse negative numbers for south", "Point 1", JOptionPane.PLAIN_MESSAGE));
                userInputE = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the east value for point 1\nUse negative numbers for west", "Point 1", JOptionPane.PLAIN_MESSAGE));
                setPoint("pointA", userInputN, userInputE);
                enteredA = true;
                break;
            case 1:
                //user is inputting for point B (2) in meters
                System.out.println("---entered case 1--\npoint B (2) input");
                userInputN = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the north value for point 2\nUse negative numbers for south", "Point 2", JOptionPane.PLAIN_MESSAGE));
                userInputE = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the east value for point 2\nUse negative numbers for west", "Point 2", JOptionPane.PLAIN_MESSAGE));
                setPoint("pointB", userInputN, userInputE);
                enteredB = true;
                break;
            case 2:
                //user is requesting the distance between the two points
                System.out.println("---entered case 2--\ngetDistance output");
                double distance;
                if (enteredA && enteredB)
                {
                    distance = getDistance(point1, point2);
                    JOptionPane.showMessageDialog(null, "the distance between " + outputPoint(point1) + " and " + outputPoint(point2) + " is: " + standardFormat.format(distance));
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Please enter both points before using calculations", "Data Entry Missing",JOptionPane.ERROR_MESSAGE);
                }
                break;
            case 3:
                //user is requesting the heading from point a to point b
                System.out.println("---entered case 3--\ngetHeading output");
                double heading;
                if (enteredA && enteredB)
                {
                    heading = getHeading(point1, point2);
                    String outputHeading = standardFormat.format(heading) + "\u00b0";
                    if(heading == -1)
                        outputHeading = "not determinable as both points are the same";
                    JOptionPane.showMessageDialog(null,"The heading from " + enterPoint1 + " to " + enterPoint2 + " is " + outputHeading);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please enter both points before using calculations", "Data Entry Missing", JOptionPane.ERROR_MESSAGE);
                }
                break;
        }
        return cont;
    }

    /**
     * a method that assigns point values to an array for those point values, it takes input to select which point is to be assigned the values
     * @param point a string input that is used to select whether the value is assigned to point 1 or 2
     * @param pointValueN north value in meters to be assigned to the north (x) coordinate of the array
     * @param pointValueE east value in meters to be assigned to the east (y) coordinate of the array
     */
    private void setPoint(String point, double pointValueN, double pointValueE)
    {
        System.out.println("---entered setPoint---");
        if (point.equalsIgnoreCase("pointA"))
        {
            System.out.println("entered point a if statement");
            point1[0] = pointValueN;
            point1[1] = pointValueE;
            enterPoint1 = outputPoint(point1);
            //enterPoint1 = "(" + point1[0] + "," + point1[1] + ")";
            System.out.println("set point a to " + enterPoint1 + "\nset point a entered to true");
        }
        else if (point.equalsIgnoreCase("pointB"))
        {
            System.out.println("entered point b if statement");
            point2[0] = pointValueN;
            point2[1] = pointValueE;
            enterPoint2 = outputPoint(point2);
            //enterPoint2 = "(" + point2[0] + "," + point2[1] + ")";
            System.out.println("set point b to " + enterPoint2 + "\nset point b entered to true");
        }
    }

    /**
     * a method that returns the distance between two points on an xy coordinate grid
     * @param pointA the first point that is entered
     * @param pointB the second point that is entered
     * @return the distance between point A and B
     */
    private double getDistance(double[] pointA,double[] pointB)
    {
        System.out.println("---entered getDistance---");
        return Math.sqrt(Math.pow((pointA [0] - pointB [0]),2) + Math.pow((pointA [1] - pointB [1]),2));
    }

    /**
     * a method that returns the heading in degrees from a given point (point A)
     * @param pointA origin point for heading
     * @param pointB point that derives the heading
     * @return heading in degrees from north
     */
    private double getHeading(double[] pointA, double[] pointB)
    {
        //return heading from point a
        if(pointA[0] == pointA[1] && pointB[0] == pointB[1] && pointA[0] == pointB[0])
            return -1;
        System.out.println("---entered getHeading---");
        System.out.println((180/Math.PI)*(Math.atan2(0,1)));//-(Math.PI/2)));
        double degrees = (Math.toDegrees(Math.atan2((pointB [0] - pointA[0]),(- pointB [1] - -pointA[1])))-90);
        if (degrees < 0)
        {
            System.out.println("equals less than 0");
            degrees = 360 + degrees;
        }
        return Math.abs(degrees);
    }

    /**
     * a method than creates an arrayList of values
     * @return arraylist containing the options for the initial input of values
     */
    private ArrayList<String> intitializeOptionsList()
    {
        System.out.println("---entered initialize options list---");
        return new ArrayList<String>(){{add(enterPoint1);add(enterPoint2); add("Calculate the Distance"); add("Calculate the Heading");}};
    }

    /**
     * a method that returns a point array neatly for output to a user
     * @param point array that contains the two coordinates of the point
     * @return a String of the cleaned point
     */
    private String outputPoint (double [] point)
    {
        System.out.println("---entered outputPoint---");
        String output = "(";
        int ii= 0;
        for (double i : point)
        {
            System.out.println(i);
            output += i;
            if (ii == 0)
                output += " N , ";
            ii++;
        }
        output += " E )";
        return output;
    }

}
