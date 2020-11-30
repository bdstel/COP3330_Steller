import java.util.Scanner;

public class App
{
    private static Scanner input = new Scanner(System.in);

    public void printMenu()
    {
        while(true)
        {
            System.out.printf("%nSelect Your Application%n" +
                    "-----------------------%n%n" +
                    "1) Task List%n" +
                    "2) Contact List%n" +
                    "3) Quit%n%n");

            switch(input.nextInt())
            {
                case 1:
                    TaskApp t = new TaskApp();
                    t.printMenu();

                    break;
                case 2:
                    ContactApp c = new ContactApp();
                    c.printMenu();

                    break;
                case 3:
                    return;
                default:
                    System.out.println("Input must be between 1 and 3");
            }
        }
    }

    public static void main(String[] args)
    {
        App m = new App();
        m.printMenu();
    }
}
