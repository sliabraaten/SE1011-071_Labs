import Week06.LiaBraatens.HouseEstimator;

import java.util.Scanner;

/**
 * @author Dr. Chris Taylor
 * @version 2014.10.06a
 *
 * Makes use of the HomeEstimator class to estimate the
 * cost of building a house based on the user's desires.
 */
public class House {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HouseEstimator estimator = new HouseEstimator();

        System.out.println("This program will help you estimate the "
                + "cost of building a house.");

        System.out.println("For your desired house:");
        System.out.print("Enter the total number of square feet: ");
        int sqFeet = in.nextInt();
        estimator.setSquareFeet(sqFeet);

        System.out.print("Enter the number of full bathrooms: ");
        int numFullBaths = in.nextInt();
        estimator.setNumFullBaths(numFullBaths);

        System.out.print("Enter the number of half bathrooms: ");
        int numHalfBaths = in.nextInt();
        estimator.setNumHalfBaths(numHalfBaths);

        System.out.print("Enter the number of bedrooms: ");
        int numBeds = in.nextInt();
        estimator.setNumBedrooms(numBeds);

        System.out.print("Enter the number of windows: ");
        int numWindows = in.nextInt();
        estimator.setNumWindows(numWindows);

        System.out.print("Enter the number of garage spaces (e.g., 2.5): ");
        estimator.setNumGarages(in.nextDouble());

        // Display characteristics and cost of the house
        System.out.print("The cost of building this house with ");
        System.out.printf("%d full baths, %d half baths,\n",
                estimator.getNumFullBaths(),
                estimator.getNumHalfBaths());
        System.out.printf("%d bedrooms, %d windows,\n",
                estimator.getNumBedrooms(),
                estimator.getNumWindows());

        System.out.printf("with a %f car garage and taking ",
                estimator.getNumGarages());

        System.out.printf("up %d square feet\n",
                estimator.getSquareFeet());

        System.out.printf("will take $%.2f to build.",
                estimator.costToBuild());
    }
}