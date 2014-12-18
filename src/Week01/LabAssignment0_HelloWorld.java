package Week01;

import javax.swing.*;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 1011-071_Labs, Purpose: to output Hello World to, console, GUI and to take input 
 *
 * @version 1.0 Created on 9/11/2014 at 2:55 PM.
 *
 * @author: Seth
 */
public class LabAssignment0_HelloWorld
{
    public static void main (String args[])
    {

        String guiInput = (String)JOptionPane.showInputDialog( "Hello World\nEnter Something Below","Your Entry Here...");
        JOptionPane.showMessageDialog(null, "you entered: " + guiInput, "What You Entered", JOptionPane.PLAIN_MESSAGE);
        System.out.println("Hello World\n Enter something");
        Scanner userInput = new Scanner(System.in);
        String conInput = userInput.next();
        System.out.println("you entered: " + conInput);
    }
}
