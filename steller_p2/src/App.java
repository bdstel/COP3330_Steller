import java.util.ArrayList;
import java.util.Scanner;

public class App
{
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

    private static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData)
    {
        double total = 0;

        for(int i = 0; i < bmiData.size(); i++)
        {
            total += bmiData.get(i).score;
        }

        System.out.println("Average BMI Score: " + (total / bmiData.size()));
    }

    private static void displayBmiInfo(BodyMassIndex bmi)
    {
        System.out.println("Score: " + bmi.score);
        System.out.println("Category: " + bmi.category);
    }

    private static double getUserWeight()
    {
        Scanner in = new Scanner(System.in);

        int weight = 0;

        boolean badInput = true;
        while (badInput) {
            System.out.println("Enter your weight in pounds");
            weight = in.nextInt();

            if (weight < 0) {
                System.out.println("Value must be positive.");
            } else {
                badInput = false;
            }
        }

        return weight;
    }

    private static double getUserHeight() {
        Scanner in = new Scanner(System.in);

        int height = 0;

        boolean badInput = true;
        while (badInput) {
            System.out.println("Enter your height in inches");
            height = in.nextInt();

            if (height < 0) {
                System.out.println("Value must be positive.");
            } else {
                badInput = false;
            }
        }

        return height;
    }

    private static boolean moreInput()
    {
        Scanner in = new Scanner(System.in);

        boolean YN = false;

        boolean badInput = true;
        while (badInput)
        {
            System.out.println("Is there more data to input? (Y/N)");
            String input = in.next();

            if (input.equals("Y") || input.equals("N"))
            {
                YN = input.equals("Y");
                badInput = false;
            }
            else
            {
                System.out.println("Value Must be Y or N");
            }
        }

        return YN;
    }
}
