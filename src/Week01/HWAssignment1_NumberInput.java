package Week01;

import javax.swing.*;

/**
 * 1011-071_HW, Purpose:to take user input of a number and return it to the user via GUI
 *
 * @version 1.0 Created on 9/15/2014 at 11:21 AM.
 * @author: Seth
 */
public class HWAssignment1_NumberInput
{
    public static void main(String args[])
    {
        String guiInput = (String)JOptionPane.showInputDialog("Enter a Number","Number Here...");
        JOptionPane.showMessageDialog(null, "You Entered: " + guiInput, "Your Number Is Here", JOptionPane.PLAIN_MESSAGE);
    }


}
