import java.text.DecimalFormat;

public class BodyMassIndex {
    private double userbmi;
    private String usercategory;

    public BodyMassIndex(double height, double weight) {
        this.userbmi = calculateBmiScore(height, weight);
        this.usercategory = calculateBmiCategory(this.userbmi);
    }

    public static double calculateBmiScore(double height, double weight){
        return Double.parseDouble(new DecimalFormat("0.0").format(703 * (weight / height / height)));
    }

    public static String calculateBmiCategory(double bmi){
        String category = "";
        if(bmi < 18.5) {
            category = "Underweight";
        }
        else if(bmi >= 18.5 && bmi <= 24.9) {
            category = "Normal weight";
        }
        else if(bmi >= 25 && bmi <= 29.9) {
            category = "Overweight";
        }
        else if(bmi >= 30) {
            category = "Obesity";
        }
        return category;
    }

    public String getUsercategory() {
        return usercategory;
    }

     public Double getUserbmi() {
        return userbmi;
    }

}