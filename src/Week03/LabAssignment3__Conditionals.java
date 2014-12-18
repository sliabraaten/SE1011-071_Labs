package Week03;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


/**
 * 1011-071_Labs, Purpose: to take user input and return a tax rate that they belong to
 * Class: 1011 071  Lab:3
 * FHT VERSION: 1.1 9/17/2014
 *
 * @version 1.0 Created on 9/24/2014 at 3:11 PM.
 * @author: Seth
 */
public class LabAssignment3__Conditionals
{
    static double bracketList [][] = new double [3][7];
    static int length =  bracketList.length;
    static int height = bracketList[0].length;
    static ArrayList<String> inputChoicesList = new ArrayList<String>(){{add("SEL");add("STDIN");add("STDOT");}};

    public static void main(String[] args)
    {
        //initialize array
        initArr();
        double income = 0;
        boolean inputBool, ex, married, exit;
        inputBool = ex = exit = false;
        String error = "";
        //ask user for gui or console
        try
        {
            String[] choices = {"GUI", "Console"};
            String inputMethod = (String) JOptionPane.showInputDialog(null, "Select Your input method", "Make Selection", JOptionPane.PLAIN_MESSAGE, null, choices, "GUI");
            System.out.println("Input method: \"" + inputMethod + "\" has been chosen");

            if (inputMethod.equalsIgnoreCase("GUI"))
                inputBool = true;
        } catch (NullPointerException e) {
            System.err.println("Caught NullPointerException: " + e.getMessage() + "  At: " + e.getCause() + " ||  possible terminated input, returning to default console program selection");
        }

        System.out.println("input boolean: " + inputBool);

        //ask for filer status of filer
        ex = married = false;
        while (!ex && !exit)
        {
            System.out.println("entered married loop");
            try
            {
                String[] filerStatus = {"Married", "Single"};
                String maritalStatus = output(inputBool, error + " Input the status of the filer (Married or not)", "SEL", filerStatus);
                if (maritalStatus.equalsIgnoreCase("married"))
                {
                    married = true;
                    ex = true;
                }
                else if (maritalStatus.equalsIgnoreCase("single"))
                {
                    married = false;
                    ex = true;
                }

            } catch (NullPointerException e)
            {
                System.err.println("Caught NullPointerException: " + e.getMessage() + "\nExiting...");
                exit = true;
                exitProgram(inputBool);
            }

        }
        System.out.println("Left married loop");
        //ask for users expected income for the year
        ex = false;
        error = "";
        while (!ex && !exit)
        {
            System.out.println("entered income loop");
            try
            {
                income = Double.parseDouble(output(inputBool, error + "Enter your expected income for the year of 2014", "STDIN", null));
                ex = true;
            } catch (NumberFormatException e) {
                System.err.println("Caught NumberFormatException: " + e.getMessage() + " Trying user entry again ");
                error = "invalid input try again\n";
            } catch (NullPointerException e)
            {
                System.err.println("Caught NullPointerException: " + e.getMessage() + "\nExiting...");
                exit = true;
                exitProgram(inputBool);
            }
        }
        System.out.println("Left output loop");
        //output rate of their taxes
        if (!exit)
        {
            int incomeBracket = getIncomeBracket(income, married);
            double taxRate = bracketList[0][incomeBracket];
            double taxes = getTaxes(income, married);
            output(inputBool, "the tax rate for $" + income + " per year is: " + taxRate * 100 + "%\nTaxes to pay are: $" + taxes, "STDOT", null);
        }
    }

    private static int getIncomeBracket(double incomeInput, boolean married)
    {
        //method for checking the income bracket location
        int output = 0;
        int filer = 1;
        //check marital status
        if (married)
            filer = 2;
        //check income location in array
        System.out.println("Entered comparison loop:\n" + incomeInput + " as income\n" + married + " as filer marital status\n" + filer);
        for (int i = 0; incomeInput >= bracketList[filer][i]; i++)
        {
            System.out.println("in loop: " + i);
            output = i + 1;
        }
        //return percent income bracket
        return output;
    }

    private static double getTaxes(double income, boolean married)
    {
        //calculates what needs to be paid in taxes given a bracket and income
        double remainingIncome = income;
        double taxes = 0, previous = 0;
        int status = 1, i;
        if (married)
            status = 2;
        for (i = 0; remainingIncome >= bracketList[status][i]-previous; i++)
        {
            taxes += (bracketList[status][i] - previous) * bracketList [0][i];
            remainingIncome -= bracketList [status][i] - previous;
            previous = bracketList [status][i];
            System.out.println("taxes: " + taxes + "remaining income: " + remainingIncome);
        }
        taxes += remainingIncome*bracketList[0][i];
        System.out.println("Final taxes: " + taxes);
        return taxes;
    }

    private static String output (boolean gui,String text, String type, String[] choices)
    {
        System.out.println("boolean value in output: " + gui);
        //sets input method for the program (GUI or Console)\
        String choice;
        if(gui)
        {
            System.out.println("Outputting to GUI");
            //outputting to a gui window
            switch (inputChoicesList.indexOf(type))
            {
                case 0:
                    //select
                    choice = (String) JOptionPane.showInputDialog(null, text, null, JOptionPane.PLAIN_MESSAGE, null, choices, null);
                    System.out.println("Input chosen: " + choice);
                    return choice;
                case 1:
                    //standard input
                    choice = (String) JOptionPane.showInputDialog(null, text, null, JOptionPane.PLAIN_MESSAGE);
                    System.out.println("user input: " + choice);
                    return choice;
                case 2:
                    //standard output
                    JOptionPane.showMessageDialog(null, text, null, JOptionPane.PLAIN_MESSAGE);
                    return null;
                default:
                    JOptionPane.showMessageDialog(null, "invalid input");
            }
        }
        else if(!gui)
        {
            System.out.println("Outputting to Console\n\n\n\n\n\n\n");
            //outputting to the console
            Scanner userInput;
            switch (inputChoicesList.indexOf(type))
            {
                case 0:
                    //select
                    System.out.println(text + " Entry Choices:\n" + Arrays.toString(choices));
                    userInput = new Scanner(System.in);
                    choice =  userInput.next();
                    System.out.println("Input chosen: " + choice);
                    return choice;
                case 1:
                    //standard input
                    System.out.println(text);
                    userInput = new Scanner(System.in);
                    choice = userInput.next();
                    System.out.println("user input: " + choice);
                    return choice;
                case 2:
                    //standard output
                    System.out.println(text);
                    return null;
                default:
                    System.out.println("invalid input");
            }
        }
        else
            System.out.println("invalid input error");

        return "";
    }

    private static void initArr ()
    {
        //create array
        bracketList[0][0] = 0.10;
        bracketList[0][1] = 0.15;
        bracketList[0][2] = 0.25;
        bracketList[0][3] = 0.28;
        bracketList[0][4] = 0.33;
        bracketList[0][5] = 0.35;
        bracketList[0][6] = 0.396;

        bracketList[1][0] = 9075.0;
        bracketList[1][1] = 36900.0;
        bracketList[1][2] = 89350.0;
        bracketList[1][3] = 186350.0;
        bracketList[1][4] = 405100.0;
        bracketList[1][5] = 406750.0;
        bracketList[1][6] = Double.MAX_VALUE;

        bracketList[2][0] = 18150.0;
        bracketList[2][1] = 73800.0;
        bracketList[2][2] = 148850.0;
        bracketList[2][3] = 226650.0;
        bracketList[2][4] = 405100.0;
        bracketList[2][5] = 457600.0;
        bracketList[2][6] = Double.MAX_VALUE;

        System.out.println("Array Initialized: ");
        for (int i = 0; i < height; i++)
        {
            for (int ii = 0; ii < length; ii++)
            {
                System.out.print(bracketList[ii][i] + " | ");
            }
            System.out.println("\n-----------------------------------------");
        }
        System.out.println(bracketList.length + "  " + bracketList[0].length);

    }

    private static void exitProgram(boolean inputBool)
    {
        output(inputBool,"Program has exit","STDOT",null);
    }
}
