import java.util.Scanner;

public class App
{
    private static final Scanner input = new Scanner(System.in);

    public void printMenu()
    {
        while(true)
        {
            System.out.printf("%nMain Menu%n" +
                    "---------%n%n" +
                    "1) Create a new list%n" +
                    "2) Load an existing list%n" +
                    "3) Quit%n%n");

            switch(input.nextInt())
            {
                case 1:
                    TaskList list = new TaskList();
                    System.out.println("Task List has been created");
                    printListMenu(list);

                    break;
                case 2:
                    System.out.print("Enter the file name to load: ");

                    TaskList listLoad = new TaskList();
                    input.nextLine();
                    String filename = input.nextLine();
                    listLoad.read(filename);

                    System.out.println("Task List has been loaded");
                    printListMenu(listLoad);

                    break;
                case 3:
                    return;
                default:
                    System.out.println("Input must be between 1 and 3");
            }
        }
    }

    public void printListMenu(TaskList list)
    {
        while(true)
        {
            System.out.printf("%nList Operation Menu%n" +
                    "-------------------%n%n" +
                    "1) View the list%n" +
                    "2) Add an item%n" +
                    "3) Edit an item%n" +
                    "4) Remove an item%n" +
                    "5) Mark an item as completed%n" +
                    "6) Unmark an item as completed%n" +
                    "7) Save the current task list%n" +
                    "8) Quit to the main menu%n%n");

            switch(input.nextInt())
            {
                case 1:
                    list.printList();

                    break;
                case 2:
                    list.createItem();

                    break;
                case 3:
                    list.printList();

                    System.out.print("Which task will you edit? ");
                    int taskNo = input.nextInt();
                    input.nextLine();

                    if (taskNo < list.size()) {
                        TaskItem task = list.get(taskNo);

                        try {
                            System.out.print("Task Title: ");
                            task.setTitle(input.nextLine());

                            System.out.print("Task Description: ");
                            task.setDesc(input.nextLine());

                            System.out.print("Task Due Date (YYYY-MM-DD): ");
                            task.setDueDate(input.nextLine());
                        } catch (InvalidTitleException ex) {
                            System.out.println("Title must be at least 1 character long; Task not created");
                        } catch (InvalidDueDateException ex) {
                            System.out.println("Due Date must be in the form YYYY-MM-DD; Task not created");
                        }
                    } else {
                        System.out.println("Task number must be valid (within list size)");
                    }

                    break;
                case 4:
                    list.printList();

                    System.out.print("Which task will you remove? ");
                    int num = input.nextInt();

                    if (num < list.size()) {
                        TaskItem item = list.get(num);
                        list.delete(item);
                    } else {
                        System.out.println("Task number must be valid (within list size)");
                    }

                    break;
                case 5:
                    list.printUncompleted();

                    System.out.print("Which task will you mark as completed? ");
                    int num2 = input.nextInt();

                    if (num2 < list.size()) {
                        TaskItem task2 = list.get(num2);
                        task2.markComplete();
                    } else {
                        System.out.println("Task number must be valid (within list size)");
                    }

                    break;
                case 6:
                    list.printCompleted();

                    System.out.print("Which task will you mark as uncompleted? ");
                    int taskNo2 = input.nextInt();

                    if (taskNo2 < list.size()) {
                        TaskItem item2 = list.get(taskNo2);
                        item2.markUncomplete();
                    } else {
                        System.out.println("Task number must be valid (within list size)");
                    }

                    break;
                case 7:
                    System.out.print("Enter the file name to save the list as: ");
                    input.nextLine();
                    String fileName = input.nextLine();
                    list.write(fileName);

                    break;
                case 8:
                    return;
                default:
                    System.out.println("Input must be between 1 and 8");
            }
        }
    }

    public static void main(String[] args)
    {
        App m = new App();

        m.printMenu();
    }
}
