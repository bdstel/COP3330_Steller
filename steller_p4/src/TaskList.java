import java.util.ArrayList;

public class TaskList
{
    protected int size;
    protected ArrayList<TaskItem> items;

    public TaskList(int size, ArrayList<TaskItem> items)
    {
        this.size = size;
        this.items = items;
    }

    public TaskList createList()
    {
        int size = 0;
        ArrayList<TaskItem> items = new ArrayList<>();

        return new TaskList(size, items);
    }
}
