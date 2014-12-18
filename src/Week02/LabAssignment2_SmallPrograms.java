package Week02;

import javax.swing.*;
import java.util.ArrayList;

/**
 * 1011-071_Labs, Purpose: to cycle through mini-programs for the user to test different aspects of java understanding
 * Class: 1011 071   Lab: 2
 * FHT VERSION: 1 9/17/2014
 * @version 1.0 Created on 9/17/2014 at 3:27 PM.
 * @author Seth
 */
public class LabAssignment2_SmallPrograms
{
    public static void main(String[] args)
    {
        // prompts user to choose program take note of what has been used and not
        ArrayList<String> inputOptions = new ArrayList<String>(){{add("Negate");add("How Many Pennies?"); add("Last Half"); add("Make Initialization"); add("Fraction");}};
        System.out.println("Created options arrayList...\n\ninputOptions size: " + inputOptions.size() + " " + inputOptions);
        boolean negate, howManyPennies, lastHalf, makeInitilzation, fraction;
        negate = howManyPennies = lastHalf = makeInitilzation = fraction = false;
        System.out.println("created boolean values: " + negate + howManyPennies + lastHalf + makeInitilzation + fraction);
        String[] inputOptionsArr = new String[inputOptions.size()];
        inputOptions.toArray(inputOptionsArr);
        System.out.print("Created options array...\n\ninputOptionsArr: ");
        for(String i : inputOptionsArr)
            System.out.print(i + ", ");
        int continueProgramProgress = JOptionPane.NO_OPTION;
        // continue to prompt user util they have done all programs
        // give user choice to leave the loop
        while (continueProgramProgress == JOptionPane.NO_OPTION)
        {
            String userChoice = (String) JOptionPane.showInputDialog(null, "Choose the program you wish to use", "Program Chooser", JOptionPane.PLAIN_MESSAGE, null, inputOptionsArr, "Negate");
            System.out.println("\ncase input: " + userChoice + "\nindex in inputOptions: " + inputOptions.indexOf(userChoice));
            switch (inputOptions.indexOf(userChoice))
            {
                case -1:
                    //no match
                    System.out.println("entered case -1...");
                    System.out.println("no such input exists");
                    System.out.println("breaking connection");
                    continueProgramProgress = JOptionPane.YES_OPTION;
                    break;
                case 0:
                    //Negate
                    System.out.println("entered case 0...");
                    int negateCon = JOptionPane.YES_OPTION;
                    System.out.println("negateCon = " + negateCon + " negate = " + negate);
                    if (negate == true)
                    {
                        negateCon = JOptionPane.showConfirmDialog(null, "Are you sure?\nyou have already completed this program", null, JOptionPane.YES_NO_OPTION);
                        System.out.println("user selected: " + negateCon == JOptionPane.YES_OPTION + " for continuing with this program again");
                    }
                    if (negateCon == JOptionPane.YES_OPTION)
                    {
                       negate = NegateProg();
                       System.out.println("negate = " + negate);
                    }
                    continueProgramProgress = JOptionPane.showConfirmDialog(null, "Are you done testing programs?",null,JOptionPane.YES_NO_CANCEL_OPTION);
                    break;
                case 1:
                    //How many pennies
                    System.out.println("entered case 1...");
                    int hMPCon = JOptionPane.YES_OPTION;
                    System.out.println("hMPCon = " + hMPCon + " howManyPennies = " + howManyPennies);
                    if (howManyPennies == true)
                    {
                        hMPCon = JOptionPane.showConfirmDialog(null, "Are you sure?\nyou have already completed this program", null, JOptionPane.YES_NO_OPTION);
                        System.out.println("user selected: " + hMPCon == JOptionPane.YES_OPTION + " for continuing with this program again");
                    }
                    if (hMPCon == JOptionPane.YES_OPTION)
                    {
                        howManyPennies = HowManyPennies();
                        System.out.println("how many pennies = " + howManyPennies);
                    }
                    continueProgramProgress = JOptionPane.showConfirmDialog(null, "Are you done testing programs?",null,JOptionPane.YES_NO_CANCEL_OPTION);
                    break;
                case 2:
                    //Last Half
                    System.out.println("entered case 2...");
                    int lastHalfCon = JOptionPane.YES_OPTION;
                    System.out.println("lastHalfCon = " + lastHalfCon + " lastHalf = " + lastHalf);
                    if (lastHalf == true)
                    {
                        lastHalfCon = JOptionPane.showConfirmDialog(null, "Are you sure?\nyou have already completed this program", null, JOptionPane.YES_NO_OPTION);
                        System.out.println("user selected: " + lastHalfCon == JOptionPane.YES_OPTION + " for continuing with this program again");
                    }
                    if (lastHalfCon == JOptionPane.YES_OPTION)
                    {
                        lastHalf = TakeLastHalf();
                        System.out.println("lastHalf = " + lastHalf);
                    }
                    continueProgramProgress = JOptionPane.showConfirmDialog(null, "Are you done testing programs?",null,JOptionPane.YES_NO_CANCEL_OPTION);
                    break;
                case 3:
                    //Make Initialization
                    System.out.println("entered case 3...");
                    int initCon = JOptionPane.YES_OPTION;
                    System.out.println("initcon = " + initCon + " makeInitilzation = " + makeInitilzation);
                    if (makeInitilzation == true)
                    {
                        initCon = JOptionPane.showConfirmDialog(null, "Are you sure?\nyou have already completed this program", null, JOptionPane.YES_NO_OPTION);
                        System.out.println("user selected: " + initCon == JOptionPane.YES_OPTION + " for continuing with this program again");
                    }
                    if (initCon == JOptionPane.YES_OPTION)
                    {
                        makeInitilzation = InitiateVar();
                        System.out.println("makeInitilization = " + makeInitilzation);
                    }
                    continueProgramProgress = JOptionPane.showConfirmDialog(null, "Are you done testing programs?",null,JOptionPane.YES_NO_CANCEL_OPTION);
                    break;
                case 4:
                    //Fraction
                    System.out.println("entered case 4...");
                    int fracCon = JOptionPane.YES_OPTION;
                    System.out.println("fracCon = " + fracCon + " Fraction = " + fraction);
                    if (fraction == true)
                    {
                        fracCon = JOptionPane.showConfirmDialog(null, "Are you sure?\nyou have already completed this program", null, JOptionPane.YES_NO_OPTION);
                        System.out.println("user selected: " + fracCon == JOptionPane.YES_OPTION + " for continuing with this program again");
                    }
                    if (fracCon == JOptionPane.YES_OPTION)
                    {
                        fraction = FractionValue();
                        System.out.println("fraction = " + fraction);
                    }
                    continueProgramProgress = JOptionPane.showConfirmDialog(null, "Are you done testing programs?",null,JOptionPane.YES_NO_CANCEL_OPTION);
                    break;
            }
        }
        System.out.println("\n\n\n\nuser has exited testing program loop");
        JOptionPane.showMessageDialog(null,"Thanks for using this program\nOk to Exit?");



    }

    private static boolean NegateProg()
    {
        //negate
        // to return an opposite of the input number
        System.out.println("\n\n---entered NegateProg---");
        //prompt user for input of number
        boolean i = true;
        while ( i == true)
        {
            String userInput = (String)JOptionPane.showInputDialog(null,"Welcome to Negate\nEnter the number that you want inverted","Negate", JOptionPane.QUESTION_MESSAGE,null,null,"Enter Number Here");
            System.out.println("user input: " + userInput);
            double numberInput = Double.parseDouble(userInput);
            System.out.println("parsed into double: " + numberInput);
            //flip sign
            double numberOutput = -numberInput;
            System.out.println("numberInput: " + numberInput + " negated to: " + numberOutput);
            //output number
            JOptionPane.showMessageDialog(null, "Your Number Negated is: \n" + numberOutput, "Negate", JOptionPane.PLAIN_MESSAGE, null);
            int option = JOptionPane.showConfirmDialog(null,"Do you wish to execute this program again?", "Negate",JOptionPane.YES_NO_OPTION);
            if(option == JOptionPane.NO_OPTION)
                i = false;
            System.out.println("user input: " + i + " to continuation");
        }
        System.out.println("left questioning loop\n---leaving NegateProg---\n\n");
        //send main a used notification
        return true;
    }

    private static boolean HowManyPennies()
    {
        //how many pennies
          //take input of dollars and output it in cents
        System.out.println("\n\n---entered HowManyPennies");
        //prompt input of number in dollars
        boolean i = true;
        while (i == true)
        {
            String userInput = (String) JOptionPane.showInputDialog(null, "Welcome to How Many Pennies?\nEnter the number in dollars that you wish to convert into pennies", "How Many Pennies?", JOptionPane.QUESTION_MESSAGE, null, null, "enter dollars here");
            System.out.println("user input: " + userInput);
            double numberInput = Double.parseDouble(userInput);
            System.out.println("parsed into double " + numberInput);
            //multiply by 100
            double numberOutput = numberInput * 100.0;
            numberOutput = Math.round(numberOutput);
            System.out.println("rounded to: " + numberOutput);
            System.out.println("numberInput " + numberInput + "converted to " + numberOutput);
            //output number
            JOptionPane.showMessageDialog(null, "your number of pennies is: \n" + numberOutput, "How Many Pennies", JOptionPane.PLAIN_MESSAGE, null);
            int option = JOptionPane.showConfirmDialog(null, "Do you wish to execute this program again?", "How Many Pennies", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.NO_OPTION)
                i = false;
            System.out.println("user input: " + i + " to continuation");
        }
        System.out.println("left questioning loop\n---leaving HowManyPennies---");
        //send main a used notification
        return true;
    }

    private static boolean TakeLastHalf ()
    {
        //last half
           //return the last half of a string
        System.out.println("\n\n---entered TakeLastHalf---");
                //prompt user for string to input
        boolean i = true;
        while (i == true)
        {
            String userInput = (String)JOptionPane.showInputDialog(null,"Welcome to Last Half\nEnter the String that you would like bifurcated","Last Half",JOptionPane.QUESTION_MESSAGE, null,null,"String Goes here");
            int stringLength = userInput.length();
            System.out.println("input string length is " + stringLength);
            //cut string in half
            String stringOutput = userInput.substring(stringLength/2);
            System.out.println("substring is: " + stringOutput);
            // return back half of string
            JOptionPane.showMessageDialog(null,"The last half of " + userInput + " is:\n" + stringOutput, "Last Half",JOptionPane.PLAIN_MESSAGE);
            int option = JOptionPane.showConfirmDialog(null, "Do you wish to execute this program again?", "Last Half", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.NO_OPTION)
                i = false;
            System.out.println("user input: " + i + " to continuation");
        }
        System.out.println("left questioning loop\n---leaving TakeLastHalf---");
                //send main a used notification
        return true;
    }

    private static boolean InitiateVar ()
    {
        //make initialization
          //take variable name and value and show a initialization of int
        System.out.println("\n\n---entered InitiateVar---");
            //prompt user for input variable name
        boolean i = true;
        while (i == true)
        {
            String variableName = (String)JOptionPane.showInputDialog(null,"Welcome to Initiate Variable\n Step 1:\nEnter the variable name that you would like entered","Initiate Variable",JOptionPane.QUESTION_MESSAGE, null,null,"Variable Goes here");
            System.out.println("input variable name is " + variableName);
            //prompt user for input of variable type
            String [] choices = new String[]{"int","double","String","char"};
            System.out.print("created choices array: ");
            for (String ii : choices)
                System.out.print(ii + " ,");
            String variableType = (String) JOptionPane.showInputDialog(null, "Step 2:\nenter the type of variable you would like initialized", "Initiate Variable", JOptionPane.PLAIN_MESSAGE, null, choices, "int");
            System.out.println("user input: " + variableType + "for variable type");
            //prompt user for input of value
            String variableValue = (String)JOptionPane.showInputDialog(null,"Step 3:\nEnter the value of the variable you just entered","Initiate Variable",JOptionPane.QUESTION_MESSAGE, null,null,"Variable Goes here");
            System.out.println("input variable value is " + variableValue);
            //output variables in the correct format
            if(variableType.equalsIgnoreCase("String"))
                JOptionPane.showMessageDialog(null,"Your variable initialized looks like\n"+ variableType + " " + variableName + " = \"" + variableValue + "\";");
            else if(variableType.equalsIgnoreCase("char"))
            {
                if (variableValue.length() == 1)
                    JOptionPane.showMessageDialog(null, "Your variable initialized looks like\n" + variableType + " " + variableName + " = \'" + variableValue + "\';");
                else
                    JOptionPane.showMessageDialog(null, "you must have entered a variable incorrectly for its type try again");
            }
            else if(variableType.equalsIgnoreCase("int")||variableType.equalsIgnoreCase("Double"))
            {
                if(IsNumeric(variableValue))
                    JOptionPane.showMessageDialog(null,"Your variable initialized looks like\n"+ variableType + " " + variableName + " = " + variableValue + ";");
                else
                    JOptionPane.showMessageDialog(null,"you must have entered a variable incorrectly for its type try again");
            }


            int option = JOptionPane.showConfirmDialog(null, "Do you wish to execute this program again?", "Initiate Variable", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.NO_OPTION)
                i = false;
            System.out.println("user input: " + i + " to continuation");
        }
        System.out.println("left questioning loop\n---leaving InitiateVar---");
            //send main a used notification
        return true;
    }

    private static boolean FractionValue ()
    {
        //fraction
            //extract a decimal number from a fraction
        System.out.println("\n\n---entered FractionValue---");
        boolean i = true;
        while (i == true)
        {
            //take user input of numerator
            String userInput = (String)JOptionPane.showInputDialog(null,"Welcome to Fraction\n Step 1:\nEnter the numerator of the fraction you wish to be evaluated","Fraction",JOptionPane.QUESTION_MESSAGE, null,null,"Numerator");
            System.out.println("input numerator is " + userInput);
            float numerator = Float.parseFloat(userInput);
            System.out.println(userInput + "parsed to double: " + numerator);
            //take user input of denominator
            userInput = (String)JOptionPane.showInputDialog(null,"Step two:\nEnter the denominator","Fraction",JOptionPane.QUESTION_MESSAGE, null,null,"Denominator");
            System.out.println("input variable value is " + userInput);
            float denominator = Float.parseFloat(userInput);
            System.out.println(userInput + "parsed into double: " + denominator);
            double output = numerator/denominator;
            int num = Math.round(numerator);
            int den = Math.round(denominator);
            System.out.println("divided" + numerator + " " + denominator + "to get: " + output);
            //output the decimal to user
            JOptionPane.showMessageDialog(null, num + "/" + den + "  as decimal is: " + output);
            int option = JOptionPane.showConfirmDialog(null, "Do you wish to execute this program again?", "Fraction", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.NO_OPTION)
                i = false;
            System.out.println("user input: " + i + " to continuation");
        }
        System.out.println("left questioning loop\n---leaving FractionValue---");
                //send main a used notification
        return true;
    }
    private static boolean IsNumeric (String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }


 }
