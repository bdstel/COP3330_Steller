public class BodyMassIndex
{
    double score;
    String category;

    public BodyMassIndex(double height, double weight)
    {
        score = score(height, weight);
        category = category(height, weight);
    }

    public static double score(double height, double weight)
    {
        return Math.round(((703 * weight) / (height * height)) * 10) / 10.0;
    }

    public static String category(double height, double weight)
    {
        double BMIscore = (703 * weight) / (height * height);

        if (BMIscore < 18.5)
        {
            return "Underweight";
        }
        else if (BMIscore < 25)
        {
            return "Normal weight";
        }
        else if (BMIscore < 30)
        {
            return "Overweight";
        }
        else
        {
            return "Obesity";
        }
    }
}
