import java.util.Scanner;

public class TaskApp
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
                case 1: {
                    TaskList list = new TaskList();
                    System.out.println("New Task List has been created");
                    printListMenu(list);

                    break;
                }
                case 2: {
                    System.out.print("Enter the file name to load: ");

                    TaskList list = new TaskList();
                    input.nextLine();
                    String filename = input.nextLine();
                    list.read(filename);

                    System.out.println("Task List has been loaded");
                    printListMenu(list);

                    break;
                }
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
                    "8) Quit to the main menu");

            switch(input.nextInt())
            {
                case 1:
                    list.printList();
                    break;
                case 2:
                    list.createTaskItem();
                    break;
                case 3: {
                    list.printList();

                    System.out.print("Which task will you edit? ");
                    int taskNum = input.nextInt();
                    input.nextLine();

                    if (taskNum < list.size() && taskNum >= 0) {
                        TaskItem task = list.get(taskNum);

                        try {
                            System.out.print("Task Title: ");
                            task.setTitle(input.nextLine());

                            System.out.print("Task Description: ");
                            task.setDesc(input.nextLine());

                            System.out.print("Task Due Date (YYYY-MM-DD): ");
                            task.setDueDate(input.nextLine());
                        } catch (InvalidTitleException ex) {
                            System.out.println("Title must be at least 1 character in length; Task not created");
                        } catch (InvalidDueDateException ex) {
                            System.out.println("Due Date must be in the form YYYY-MM-DD; Task not created");
                        }
                    } else {
                        System.out.println("Task number must be valid (within list size)");
                    }

                    break;
                }
                case 4: {
                    list.printList();

                    System.out.print("Which task will you remove? ");
                    int taskNum = input.nextInt();

                    if (taskNum < list.size() && taskNum >= 0) {
                        TaskItem task = list.get(taskNum);
                        list.delete(task);
                    } else {
                        System.out.println("Task number must be valid (within list size)");
                    }

                    break;
                }
                case 5: {
                    list.printUncompleted();

                    System.out.print("Which task will you mark as completed? ");
                    int taskNum = input.nextInt();

                    if (taskNum < list.size() && taskNum >= 0)
                    {
                        TaskItem task = list.get(taskNum);
                        task.markComplete();
                    }
                    else
                    {
                        System.out.println("Task number must be valid (within list size)");
                    }

                    break;
                }
                case 6: {
                    list.printCompleted();

                    System.out.print("Which task will you mark as uncompleted? ");
                    int taskNum = input.nextInt();

                    if (taskNum < list.size() && taskNum >= 0)
                    {
                        TaskItem task = list.get(taskNum);
                        task.markUncomplete();
                    }
                    else
                    {
                        System.out.println("Task number must be valid (within list size)");
                    }

                    break;
                }
                case 7:
                    System.out.print("Enter the file name to save the list as: ");
                    input.nextLine();
                    String filename = input.nextLine();
                    list.write(filename);

                    break;
                case 8:
                    return;
                default:
                    System.out.println("Input must be between 1 and 8");
            }
        }
    }
}
