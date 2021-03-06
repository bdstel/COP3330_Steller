import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class TaskList
{
    Scanner input = new Scanner(System.in);

    List<TaskItem> tasks;

    public TaskList()
    {
        this.tasks = new ArrayList<>();
    }

    public void createTaskItem()
    {
        TaskItem task;

        while(true)
        {
            try
            {
                String title = getTaskTitle();
                String desc = getTaskDesc();
                String dueDate = getTaskDueDate();

                task = new TaskItem(title, desc, dueDate);

                add(task);

                break;
            }
            catch (InvalidTitleException ex)
            {
                System.out.println("Invalid Title, please double check and try again");
            }
            catch (InvalidDueDateException ex)
            {
                System.out.println("Invalid Due Date, please double check and try again");
            }
        }
    }

    public String getTaskTitle()
    {
        System.out.print("Task Title: ");
        return input.nextLine();
    }

    public String getTaskDesc()
    {
        System.out.print("Task Description: ");
        return input.nextLine();
    }

    public String getTaskDueDate()
    {
        System.out.print("Task Due Date: ");
        return input.nextLine();
    }

    public TaskItem get(int i)
    {
        if (i < 0 || i >= tasks.size())
        {
            throw new IllegalArgumentException("Index must be within 0 and the list size");
        }

        return tasks.get(i);
    }

    public void add(TaskItem task)
    {
        tasks.add(task);
    }

    public int size()
    {
        return tasks.size();
    }

    public void delete(TaskItem task)
    {
        tasks.remove(task);
    }

    public void read(String filename)
    {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filename)))
        {
            String line = bufferedReader.readLine();

            while(line != null)
            {
                int titleEnd = line.indexOf(';');
                int descEnd = line.lastIndexOf(';');

                String title = line.substring(0, titleEnd);
                String desc = line.substring(titleEnd+1, descEnd);
                String dueDate = line.substring(descEnd+1);

                TaskItem task = new TaskItem(title, desc, dueDate);

                tasks.add(task);

                line = bufferedReader.readLine();
            }
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Unable to find file.");
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public void write(String filename)
    {
        try(Formatter output = new Formatter(filename))
        {
            for (TaskItem task : tasks)
            {
                output.format("%s;%s;%s%n", task.getTitle(), task.getDesc(), task.getDueDate());
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void printList()
    {
        for (int i = 0; i < tasks.size(); i++)
        {
            TaskItem task = tasks.get(i);

            if (task.isComplete())
            {
                System.out.printf("%d) *** [%s] %s: %s%n", i, task.getDueDate(), task.getTitle(), task.getDesc());
            }
            else
            {
                System.out.printf("%d) [%s] %s: %s%n", i, task.getDueDate(), task.getTitle(), task.getDesc());
            }
        }
    }

    public void printCompleted()
    {
        for (int i = 0; i < tasks.size(); i++)
        {
            TaskItem task = tasks.get(i);
            if(task.isComplete()) {
                System.out.printf("%d) [%s] %s: %s%n", i, task.getDueDate(), task.getTitle(), task.getDesc());
            }
        }
    }

    public void printUncompleted()
    {
        for (int i = 0; i < tasks.size(); i++)
        {
            TaskItem task = tasks.get(i);
            if (!task.isComplete()) {
                System.out.printf("%d) [%s] %s: %s%n", i, task.getDueDate(), task.getTitle(), task.getDesc());
            }
        }
    }
}
