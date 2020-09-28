import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    private static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {
        System.out.println("User count.: " + bmiData.size());
        System.out.println("Average BMI.: " + getBmiaverage(bmiData));
    }

    private static double getBmiaverage(ArrayList<BodyMassIndex> bmiData) {
        double bmisum = 0;
        for(int i = 0; i< bmiData.size(); i++){
            bmisum = bmisum + bmiData.get(i).getUserbmi();
        }
        return Double.parseDouble(new DecimalFormat("0.0").format( bmisum / bmiData.size()));
    }

    private static void displayBmiInfo(BodyMassIndex bmi) {
        System.out.printf("%nUser BMI.: " + bmi.getUserbmi() + "%n");
        System.out.printf("BMI category.: " + bmi.getUsercategory() + "%n%n");
    }

    private static double getUserWeight() {
        System.out.print("Please enter user weight(pounds): ");
        double weight = input.nextDouble();
        while (weight <= 0 )
        {
            System.out.print("Weight must be a positive value. Please enter user weight(pounds): ");
            weight = input.nextDouble();
        }
        input.nextLine();
        return weight;
    }

    private static double getUserHeight() {
        System.out.printf("%nPlease enter user height(inches): ");
        double height = input.nextDouble();
        while (height <= 0 )
        {
            System.out.print("Height must be a positive value. Please enter user height(inches): ");
            height = input.nextDouble();
        }
        input.nextLine();
        return height;
    }

    private static boolean moreInput() {
        System.out.print("Would you like to add a new user? (Y or N): ");
        String more = input.nextLine().toLowerCase();
        while(!more.equals("y") && !more.equals("n")) {
            System.out.printf("%nWould you like to add a new user? (Y or N): ");
            more = input.nextLine().toLowerCase();
        }
        return more.matches("y");
    }
}