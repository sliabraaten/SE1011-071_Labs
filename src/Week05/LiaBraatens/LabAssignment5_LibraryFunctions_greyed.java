package Week05.LiaBraatens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * 1011-071_Labs, Purpose: to take user input of points and return the distance and angle between two points
 * Class: 1101-071 Thomas  Lab: 5
 * FHT VERSION: 1.1 9/17/2014
 *
 * @version 1.0 Created on 10/8/2014 at 3:39 PM.
 * @author: Seth
 */
 class LabAssignment5_LibraryFunctions_greyed {
            private double [] point1 = new double [2];
            private double [] point2 = new double [2];
            private DefaultListSelectionModel model = new DefaultListSelectionModel();
            private GreyDisabledComboBoxRenderer renderer = new <GreyDisabledComboBoxRenderer> GreyDisabledComboBoxRenderer();
            private EnabledChecker enabledChecker = new EnabledChecker();
            private DisabledChecker disabledChecker = new DisabledChecker();
            private JComboBox menuBox;
            private boolean enteredPointA,enteredPointB;
            private static final int[] GREYED_CHOICE_INTERVAL = { 0, 1 };

            public static void main(String [] args)
            {
                new LabAssignment5_LibraryFunctions_greyed().run();
            }

            public void run()
            {

                DecimalFormat standardFormat = new DecimalFormat("#.#");
                ArrayList<String> optionsList  = intitializeOptionsList();
                System.out.println("Created options arrayList...\n\ninputOptions size: " + optionsList.size() + " " + optionsList);
                String [] optionsArray = new String[optionsList.size()];
                System.out.println("created array with length: " + optionsArray.length);
                optionsList.toArray(optionsArray);  //check swing docs for input of array list
                for (String i : optionsArray)
                    System.out.println(i);
                boolean cont = true;
                String userInput;
                do
                {
                    menuBox = intitializeDialogBox(optionsArray);
                    checkPointInput();
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
                            break;
                        case 1:
                            //user is inputting for point B (2) in meters
                            System.out.println("---entered case 1--\npoint B (2) input");
                            userInputN = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the north value for point 2\nUse negative numbers for south", "Point 2", JOptionPane.PLAIN_MESSAGE));
                            userInputE = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the north value for point 2\nUse negative numbers for south", "Point 2", JOptionPane.PLAIN_MESSAGE));
                            setPoint("pointB", userInputN, userInputE);
                            break;
                        case 2:
                            //user is requesting the distance between the two points
                            System.out.println("---entered case 2--\ngetDistance output");
                            double distance;
                            //if (user has inputted point a and b)
                            distance = getDistance(point1, point2);
                            JOptionPane.showMessageDialog(null,"the distance between " + outputPoint(point1) + " and " + outputPoint(point2) + " is: " + standardFormat.format(distance));
                            break;
                        case 3:
                            //user is requesting the heading from point a to point b
                            System.out.println("---entered case 3--\ngetHeading output");
                            double heading;
                            // if (user has inputted point a and b)
                            heading = getHeading(point1, point2);
                            JOptionPane.showMessageDialog(null,"The heading from point 1 to point 2 is " + standardFormat.format(heading) + "\u00b0");
                            break;


                    }

                }while (cont);

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
                    enteredPointA = true;
                    System.out.println("set point a to (" + point1[0] + "," + point1[1] + ")\nset point a entered to true");
                }
                else if (point.equalsIgnoreCase("pointB"))
                {
                    System.out.println("entered point b if statement");
                    point2[0] = pointValueN;
                    point2[1] = pointValueE;
                    enteredPointB = true;
                    System.out.println("set point b to (" + point2[0] + "," + point2[1] + ")\nset point b entered to true");
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
                System.out.println("---entered getHeading---");
                System.out.println((180/Math.PI)*(Math.atan2(0,1)));//-(Math.PI/2)));
                return Math.toDegrees(Math.atan2((pointB [0] - pointA[0]),(pointB [1] - pointA[1])))+180;
            }

            /**
             * a method than creates an arrayList of values
             * @return arraylist containing the options for the initial input of values
             */
            private ArrayList<String> intitializeOptionsList()
            {
                System.out.println("---entered initialize options list---");
                return new ArrayList<String>(){{add("Enter Point 1");add("Enter Point 2"); add("Calculate the Distance"); add("Calculate the Heading");}};
            }

            private String outputPoint (double [] point)
            {
                System.out.println("---entered outputPoint---");
                String output = "(";
                for (double i : point)
                {
                    System.out.println(i);
                    output += " " + i;
                    if (i > 0 && i < 2)
                        output += ",";
                }
                output += ")";
                return output;
            }

            /**
             * a method that creates a dialog box with all of the proper parameters
             */
            private JComboBox intitializeDialogBox(String [] options)
            {
                System.out.println("---entered initializeDialogBox---");
                JComboBox box = new JComboBox<String>(options);
                JFrame frame = new JFrame("Surveyor's Assistant");
                frame.setLayout(new GridBagLayout());
                JPanel mainMenu = new JPanel();
                JButton okButton = new JButton("OK");
                frame.add(mainMenu);
                mainMenu.add(okButton);
                mainMenu.add(box);

                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setSize(400, 150);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                model.addSelectionInterval(GREYED_CHOICE_INTERVAL[0],GREYED_CHOICE_INTERVAL[1]);
                renderer.setEnabledItems(model);
                box.setRenderer(renderer);
                return box;
            }

            private class EnabledChecker implements ActionListener
            {
                public void actionPerformed (ActionEvent event)
                {
                    System.out.println("---entered EnabledChecker---");
                    //resultant from regular choice selection
                    System.out.println(((JComboBox) event.getSource()).getSelectedItem() + " is selected" );
                }
            }

            private class DisabledChecker implements ActionListener
            {
                public void actionPerformed (ActionEvent event)
                {
                    System.out.println("---entered DisabledChecker---");
                    if (((JComboBox) event.getSource()).getSelectedIndex() != GREYED_CHOICE_INTERVAL[0] && ((JComboBox) event.getSource()).getSelectedIndex() != GREYED_CHOICE_INTERVAL[1] && (!enteredPointA && !enteredPointB))
                    {
                        //both point 1 and point 2 have not been entered
                        JOptionPane.showMessageDialog(null,"you have not entered all of the points", "ERROR",JOptionPane.ERROR_MESSAGE);
                    } else
                    {
                        //resultant from both points being properly entered
                        System.out.println(((JComboBox) event.getSource()).getSelectedItem());
                    }
                }
            }
            protected void disableItemsInComboBox()
            {
                System.out.println("---entered disableItemsInComboBox---");
                menuBox.removeActionListener(enabledChecker);
                menuBox.addActionListener(disabledChecker);
                model.setSelectionInterval(GREYED_CHOICE_INTERVAL[0],GREYED_CHOICE_INTERVAL[1]);
            }

            protected void enableItemsInComboBox()
            {
                System.out.println("---Entered enableItemsInComboBox---");
                menuBox.removeActionListener(disabledChecker);
                menuBox.addActionListener(enabledChecker);
                model.setSelectionInterval(GREYED_CHOICE_INTERVAL[0], menuBox.getModel().getSize() - 1);
            }

            private void checkPointInput ()
            {
                System.out.println("---entered checkPointInput---\nvalue of entered point a:"  + enteredPointA + " value of b: " + enteredPointB);
                if (enteredPointA && enteredPointB)
                {
                    System.out.println("no problems occurred ");
                    enableItemsInComboBox();
                }
                else if (enteredPointB || enteredPointA)
                {
                    System.out.println("one but not both variables are true");
                    disableItemsInComboBox();
                }
                else if (!enteredPointA && !enteredPointB)
                {
                    System.out.println("neither variable has been entered");
                    disableItemsInComboBox();
                }
            }

        }
//custom dialog box size, greying out options that are not availible
//create class for meter conversion



