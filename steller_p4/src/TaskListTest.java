import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskListTest
{
    @Test
    public void addingTaskItemsIncreasesSize()
    {
        TaskList list = new TaskList();
        int prevSize = list.size();

        TaskItem task = new TaskItem("Task 1", "desc", "2021-01-01");
        list.add(task);

        assertEquals(prevSize + 1, list.size());
    }

    @Test
    public void newTaskListIsEmpty()
    {
        TaskList list = new TaskList();

        assertEquals(0, list.size());
    }

    @Test
    public void removingTaskItemsDecreasesSize()
    {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Task 1", "desc", "2021-01-01");
        list.add(task);

        int prevSize = list.size();
        list.delete(task);

        assertEquals(prevSize - 1, list.size());
    }

    @Test
    public void savedTaskListCanBeLoaded()
    {
        TaskList list1 = new TaskList();
        TaskItem task = new TaskItem("Task 1", "desc", "2021-01-01");
        list1.add(task);

        list1.write("list1.txt");

        TaskList list2 = new TaskList();
        list2.read("list1.txt");

        assertEquals("Task 1", list2.get(0).getTitle());
        assertEquals("desc", list2.get(0).getDesc());
        assertEquals("2021-01-01", list2.get(0).getDueDate());
        assertEquals(list1.size(), list2.size());
    }
}
