package Week04;

import javax.swing.*;

/**
 * 1011-071_Labs, Purpose: to get user input on a number and return how close it is to a given random number using loops
 * Class:SE1101-071 Thomas   Lab: 4
 * FHT VERSION: 1.1 9/17/2014
 *
 * @version 1.0 Created on 10/1/2014 at 3:08 PM.
 * @author: Seth
 */
public class LabAssignment4_Loops
{
    static int randomNumber;
    public static void main(String[] args)
    {
        boolean again = true;
        while (again)
        {
            //new random number is generated
            boolean rep = false;
            randomNumber = (int) Math.ceil(Math.random() * 99);
            System.out.println("Generated random number: " + randomNumber + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            do {
                rep = false;
                try
                {
                    //call guess a number
                    guessANumber();
                }
                catch (NumberFormatException nfe)
                {
                    System.err.println(nfe.getLocalizedMessage() + "Caught NumberFormatException" + nfe.getLocalizedMessage());
                    rep = true;
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    System.err.println(e.getLocalizedMessage());
                }
            }while (rep);
            double userInput = JOptionPane.showConfirmDialog(null,"Would you like to play again?",null,JOptionPane.YES_NO_OPTION);
            if (userInput == JOptionPane.NO_OPTION)
                again = false;
            //ask user to play again
        }
    }

     /**
      * a method that takes user input and checks that it is in the parameters of the entry
     */
    public static void guessANumber ()
    {
        System.out.println("---Entered guessANumber---");
        //user is prompted to enter a number repeatedly until they get it right
        int userNumber;
        String relation = "";
        boolean ex = false;
        do
        {
            //user is prompted to enter a number
            try
            {
                String userInput = JOptionPane.showInputDialog(null,"enter a number between 1 and 100");
                userNumber = Integer.parseInt(userInput);
                checkIfInRange(userNumber);
                relation = numberRelation(userNumber,randomNumber);
                JOptionPane.showMessageDialog(null,"your number is " + relation + " the random number",null, JOptionPane.PLAIN_MESSAGE);
            }
            catch (NotBetweenOneAndOnehundredException oAoe)
            {
                JOptionPane.showMessageDialog(null,"Thanks for trying",null,JOptionPane.ERROR_MESSAGE);
                System.err.println(oAoe.getLocalizedMessage());
                ex = true;
            }
            catch(NumberFormatException nfe)
            {
                //nfe.printStackTrace();
                System.err.println(nfe.getLocalizedMessage()+ "Caught NumberFormatException in guessANumber" + nfe.getLocalizedMessage());
                if(nfe.getLocalizedMessage().contains("string"))
                {
                    System.err.println("invalid input of string");
                    JOptionPane.showMessageDialog(null,"invalid input, please enter a number",null,JOptionPane.ERROR_MESSAGE);
                }
                else
                    throw new NumberFormatException();
            }

            //test relation to random number
        }while(!relation.equalsIgnoreCase("equal to") && !ex);
        if (!ex)
            JOptionPane.showMessageDialog(null,"Congratulations, you got the number correct",null,JOptionPane.PLAIN_MESSAGE);
            //return to main when complete
    }

    /**
     * a method that tests the relation of two input numbers and returns it
     * @param inputNumber
     * @param relationToInputNumber
     * @return
     */
    public static String numberRelation (int inputNumber, int relationToInputNumber)
    {
        System.out.println("---Entered numberRelation--");
        //class tests whether the input number is <,>,= a related number
            if(inputNumber > relationToInputNumber)
            {
                //test greater than
                System.out.println("input number is greater than relation number");
                return "greater than";
            }
            else if(inputNumber < relationToInputNumber)
            {
                //test less than
                System.out.println("input number is less than relation number");
                return "less than";
            }
            else if (inputNumber == relationToInputNumber)
            {
                //test equals
                System.out.println("input number is equal to relation number");
                return "equal to";
            }
        return null;
    }

    /**
     * a method that checks if input is between 1 and 100 and if not it throws an exception
     * @param input
     * @throws NotBetweenOneAndOnehundredException
     */
    public static void checkIfInRange(int input) throws NotBetweenOneAndOnehundredException
    {
        if (!(input < 100) || !(input > 0))
            throw new NotBetweenOneAndOnehundredException(input);
    }
}
