import java.util.ArrayList;

public class TaskList
{
    protected int size;
    protected ArrayList<TaskList> items;

    public TaskList()
    {

    }

    public TaskList createList()
    {
        TaskList list = new TaskList();

        list.size = 0;
        list.items = null;

        return list;
    }
}
