import java.util.Scanner;

public class App
{
    private static Scanner input = new Scanner(System.in);

    public void main(String[] args)
    {

    }

    public TaskItem createItem()
    {
        TaskItem task = null;

        while(true)
        {
            try {
                String title = getTaskTitle();
                String desc = getTaskDescription();
                String dueDate = getTaskDueDate();

                task = new TaskItem(title, desc, dueDate);

                break;
            } catch (InvalidTitleException ex) {
                System.out.println("Invalid Title, please double check and try again");
            } catch (InvalidDueDateException ex) {
                System.out.println("Invalid Due Date, please double check and try again");
            }
        }

        return task;
    }

    public String getTaskTitle()
    {
        System.out.print("Task Title: ");
        return input.nextLine();
    }

    public String getTaskDescription()
    {
        System.out.print("Task Description: ");
        return input.nextLine();
    }

    public String getTaskDueDate()
    {
        System.out.print("Task Due Date: ");
        return input.nextLine();
    }
}
