import java.util.Scanner;

public class TaskItem
{
    protected String title;
    protected String desc;
    protected String dueDate;

    public TaskItem()
    {

    }

    public TaskItem createItem()
    {
        TaskItem task = new TaskItem();
        Scanner scan = new Scanner(System.in);

        System.out.print("Task Title: ");
        task.title = scan.nextLine();

        System.out.print("Task description: ");
        task.desc = scan.nextLine();

        System.out.print("Task due date (YYYY-MM-DD): ");
        task.dueDate = scan.nextLine();

        return task;
    }
}
