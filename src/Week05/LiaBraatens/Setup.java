package Week05.LiaBraatens;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.EventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.GridBagLayout;
import javax.swing.*;
import java.text.DecimalFormat;


/**
 * 1011-071_Labs, Purpose:
 * Class:    Lab:
 * FHT VERSION: 1.1 9/17/2014
 *
 * @version 1.0 Created on 10/14/2014 at 2:39 PM.
 * @author: Seth
 */

public class Setup
{

    UserDropdownSelection userDropdownSelection = new UserDropdownSelection();
    UserButtonExitClick userExitButtonClick = new UserButtonExitClick();
    UserButtonGenerateClick userButtonGenerateClick = new UserButtonGenerateClick();
    JPanel cards; //a panel that uses CardLayout
    final static String ENTER_POINTS = "Enter Points";
    final static String GET_DISTANCE = "Get Distance";
    final static String GET_BEARING = "Get Bearing";
    final static String WELCOME = "Welcome/Exit";
    String p1N = "Enter Point 1 North";
    String p1E = "Enter Point 1 East";
    String p2N = "Enter Point 2 North";
    String p2E = "Enter Point 2 East";
    double p1ND, p1ED, p2ND, p2ED;
    String currentMenuSelection;
    int currentMenuIndex;



    public void addComponentToPane(Container pane) {
        //Put the JComboBox in a JPanel to get a nicer look.
        JPanel comboBoxPane = new JPanel(); //use FlowLayout
        String inputOptions[] = { WELCOME, ENTER_POINTS, GET_DISTANCE, GET_BEARING };
        JComboBox cb = new JComboBox<String>(inputOptions);
        cb.setEditable(false);
        cb.addActionListener(userDropdownSelection);
        comboBoxPane.add(cb);

        //Create the "cards".
        JPanel welcome = new JPanel();
        welcome.add(new JLabel("Welcome to Surveyor's Assistant, Select an option from the dropdown menu"));
        JButton exit = new JButton("EXIT");
        exit.addActionListener(userExitButtonClick);
        welcome.add(exit);

        JPanel getDistance = new JPanel();
        JButton genDistance = new JButton("Get Distance");
        genDistance.addActionListener(userButtonGenerateClick);
        getDistance.add(genDistance);

        JPanel getBearing = new JPanel();
        JButton genBearing = new JButton("Get Bearing");
        genBearing.addActionListener(userButtonGenerateClick);
        getBearing.add(genBearing);

        JPanel enterPoint = new JPanel();
        //enterPoint.add(new JLabel("Enter Points (use negative numbers for south and west)"));
        JButton save = new JButton("Save");
        save.addActionListener(userButtonGenerateClick);
        /*JTextField point1N = new JTextField(p1N, 10);
        JTextField point1E = new JTextField(p1E, 10);
        JTextField point2N = new JTextField(p2N, 10);
        JTextField point2E = new JTextField(p2E, 10);

        enterPoint.add(point1N);
        enterPoint.add(point1E);
        enterPoint.add(point2N);
        enterPoint.add(point2E);
        enterPoint.add(save);*/

                 //Create the panel that contains the "cards".
                 cards = new JPanel(new CardLayout());
        cards.add(welcome, WELCOME);
        cards.add(getDistance, GET_DISTANCE);
        cards.add(enterPoint, ENTER_POINTS);
        cards.add(getBearing,GET_BEARING);

        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
    }

    public class UserDropdownSelection implements ActionListener
    {
        public void actionPerformed(ActionEvent evt)
        {
            System.out.println("event : " + ((JComboBox) evt.getSource()).getSelectedItem()+ " occurred");
            currentMenuSelection = (String)((JComboBox) evt.getSource()).getSelectedItem();
            currentMenuIndex = ((JComboBox) evt.getSource()).getSelectedIndex();
            System.out.println("set currentMenuSelection to: " + currentMenuSelection + " index" + currentMenuIndex);
        }
    }

    public class UserButtonExitClick implements ActionListener
    {
        public void actionPerformed(ActionEvent evt)
        {
            System.out.println("event : UserExitClick occurred");
            //System.out.println("closed window");
        }
    }

    public class UserButtonGenerateClick implements ActionListener
    {
        public void actionPerformed(ActionEvent evt)
        {
            System.out.println("event : UserButtonGenerateClick occurred");

           /* switch (currentMenuIndex)
            {
                case 0:
                    System.out.println("entered exit request of program case (0)");
                    break;
                case 1:
                    System.out.println("entered enter point case (1)");
                    /*p1ND = Double.parseDouble(point1N.getText());
                    p1ED = Double.parseDouble(point1E.getText());
                    p2ND = Double.parseDouble(point2N.getText());
                    p2ED = Double.parseDouble(point2E.getText());
                    System.out.println(p1ND + " " + p1ED + " " + p2ND + " " + p2ED);
                    break;
                case 2:
                    System.out.println("entered get distance case (2)");
                    //getDistance();
                    break;
                case 3:
                    System.out.println("entered get heading case (3)");
                    //getHeading();
                    break;
            }*/
        }
    }
    private static void createAndShowGUI() {
                  //Create and set up the window.
                  JFrame frame = new JFrame();
                  frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                  frame.setSize(500,500);
                  frame.setLocation(960,540);

                  //Create and set up the content pane.
                  Setup content = new Setup();
                  content.addComponentToPane(frame.getContentPane());

                  //Display the window.
                  frame.pack();
                  frame.setVisible(true);
              }

    public static void main(String[] args) {
             javax.swing.SwingUtilities.invokeLater(new Runnable() {
                 public void run() {
                     createAndShowGUI();
                 }
             });
         }

    /**
     * a method that returns the distance between two points on an xy coordinate grid
     * @param pointA the first point that is entered
     * @param pointB the second point that is entered
     * @return the distance between point A and B
     *//*
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
     *//*
    private double getHeading(double[] pointA, double[] pointB)
    {
        //return heading from point a
        System.out.println("---entered getHeading---");
        System.out.println((180/Math.PI)*(Math.atan2(0,1)));//-(Math.PI/2)));
        return Math.toDegrees(Math.atan2((pointB [0] - pointA[0]),(pointB [1] - pointA[1])))+180;
    }
*/


}




    /*String [] selectionOptions = {"Enter Point 1", "Enter Point 2", "Calculate Distance", "Calculate Heading"};

    JFrame frame = new JFrame("Surveyor's Assistant");

    JPanel mainMenu = new JPanel();
    JPanel enterPoint = new JPanel();
    JPanel getDistance = new JPanel();
    JPanel getHeading = new JPanel();
    JPanel selection = new JPanel();

    JComboBox mainMenuCB = new JComboBox<String>(selectionOptions);

    JButton okButton = new JButton("OK");
    JButton calculate = new JButton("Calculate");

    JTextField textEntry = new JTextField();



    public static void main(String[] args)
    {
        new Setup();
    }

    public Setup()
    {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 150);
        frame.setVisible(true);

        enterPoint.add(okButton);
        enterPoint.add(textEntry);

        getDistance.add(calculate);

        getHeading.add(calculate);

        mainMenu.add(enterPoint, selectionOptions[0]);
        mainMenu.add(getDistance, selectionOptions[2]);
        mainMenu.add(getHeading, selectionOptions[3]);
        //mainMenu.add();

        mainMenuCB.addItemListener(this);

        selection.add(mainMenuCB);

        frame.add(selection, BorderLayout.PAGE_START);
        frame.add(mainMenu, BorderLayout.CENTER);

    }
    public void changeChecker (ItemEvent event)
    {
        CardLayout std = (CardLayout)(mainMenu.getLayout());
        std.show(mainMenu, (String)event.getItem());
    }

    public void mainMenuFrame()
    {

    }

    public void enterPoint (int pointNumber)
    {

    }

    public void getDistance()
    {

    }

    public void getHeading()
    {

    }
}     */
