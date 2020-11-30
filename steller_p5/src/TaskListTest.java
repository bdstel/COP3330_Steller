import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskListTest
{
    @Test
    public void addingItemsIncreasesSize()
    {
        TaskList list = new TaskList();
        int prevSize = list.size();

        TaskItem task = new TaskItem("Task 1", "desc", "2021-01-01");
        list.add(task);

        assertEquals(prevSize + 1, list.size());
    }

    @Test
    public void completingTaskItemChangesStatus()
    {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Task 1", "desc", "2021-01-01");
        list.add(task);

        boolean prevStatus = list.get(0).isComplete();
        list.get(0).markComplete();

        assertNotEquals(prevStatus, list.get(0).isComplete());
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex()
    {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Task 1", "desc", "2021-01-01");
        list.add(task);

        assertThrows(IllegalArgumentException.class, () -> list.get(1).markComplete());
    }

    @Test
    public void editingItemDescriptionFailsWithInvalidIndex()
    {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Task 1", "desc", "2021-01-01");
        list.add(task);

        assertThrows(IllegalArgumentException.class, () -> list.get(1).setDesc("description"));
    }

    @Test
    public void editingItemDescriptionSucceedsWithExpectedValue()
    {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Task 1", "desc", "2021-01-01");
        list.add(task);

        list.get(0).setDesc("new description");

        assertEquals("new description", list.get(0).getDesc());
    }

    @Test
    public void editingItemDueDateSucceedsWithExpectedValue()
    {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Task 1", "desc", "2021-01-01");
        list.add(task);

        list.get(0).setDueDate("2021-05-04");

        assertEquals("2021-05-04", list.get(0).getDueDate());
    }

    @Test
    public void editingItemTitleFailsWithEmptyString()
    {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Task 1", "desc", "2021-01-01");
        list.add(task);

        assertThrows(InvalidTitleException.class, () -> list.get(0).setTitle(""));
    }

    @Test
    public void editingItemTitleFailsWithInvalidIndex()
    {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Task 1", "desc", "2021-01-01");
        list.add(task);

        assertThrows(IllegalArgumentException.class, () -> list.get(1).setTitle("New title"));
    }

    @Test
    public void editingItemTitleSucceedsWithExpectedValue()
    {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Task 1", "desc", "2021-01-01");
        list.add(task);

        list.get(0).setTitle("New Title");

        assertEquals("New Title", list.get(0).getTitle());
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidDateFormat()
    {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Task 1", "desc", "2021-01-01");
        list.add(task);

        assertThrows(InvalidDueDateException.class, () -> list.get(0).setDueDate("05-04-2021"));
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex()
    {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Task 1", "desc", "2021-01-01");
        list.add(task);

        assertThrows(IllegalArgumentException.class, () -> list.get(1).setDueDate("2021-05-04"));
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidYYYYMMDD()
    {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Task 1", "desc", "2021-01-01");
        list.add(task);

        assertThrows(InvalidDueDateException.class, () -> list.get(0).setDueDate("yyyy-mm-dd"));
    }

    @Test
    public void gettingItemDescriptionFailsWithInvalidIndex()
    {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Task 1", "desc", "2021-01-01");
        list.add(task);

        assertThrows(IllegalArgumentException.class, () -> list.get(1).getDesc());
    }

    @Test
    public void gettingItemDescriptionSucceedsWithValidIndex()
    {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Task 1", "desc", "2021-01-01");
        list.add(task);

        assertEquals("desc", list.get(0).getDesc());
    }

    @Test
    public void gettingItemDueDateFailsWithInvalidIndex()
    {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Task 1", "desc", "2021-01-01");
        list.add(task);

        assertThrows(IllegalArgumentException.class, () -> list.get(1).getDueDate());
    }

    @Test
    public void gettingItemDueDateSucceedsWithValidIndex()
    {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Task 1", "desc", "2021-01-01");
        list.add(task);

        assertEquals("2021-01-01", list.get(0).getDueDate());
    }

    @Test
    public void gettingItemTitleFailsWithInvalidIndex()
    {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Task 1", "desc", "2021-01-01");
        list.add(task);

        assertThrows(IllegalArgumentException.class, () -> list.get(1).getTitle());
    }

    @Test
    public void gettingItemTitleSucceedsWithValidIndex()
    {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Task 1", "desc", "2021-01-01");
        list.add(task);

        assertEquals("Task 1", list.get(0).getTitle());
    }

    @Test
    public void newListIsEmpty()
    {
        TaskList list = new TaskList();

        assertEquals(0, list.size());
    }

    @Test
    public void removingItemsDecreasesSize()
    {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Task 1", "desc", "2021-01-01");
        list.add(task);

        int prevSize = list.size();
        list.delete(task);

        assertEquals(prevSize - 1, list.size());
    }

    @Test
    public void removingItemsFailsWithInvalidIndex()
    {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Task 1", "desc", "2021-01-01");
        list.add(task);

        assertThrows(IllegalArgumentException.class, () -> list.delete(list.get(1)));
    }

    @Test
    public void savedTaskListCanBeLoaded()
    {
        TaskList list1 = new TaskList();
        TaskItem task = new TaskItem("Task 1", "desc", "2021-01-01");
        list1.add(task);

        list1.write("tList.txt");

        TaskList list2 = new TaskList();
        list2.read("tList.txt");

        assertEquals("Task 1", list2.get(0).getTitle());
        assertEquals("desc", list2.get(0).getDesc());
        assertEquals("2021-01-01", list2.get(0).getDueDate());
        assertEquals(list1.size(), list2.size());
    }

    @Test
    public void uncompletingTaskItemChangesStatus()
    {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Task 1", "desc", "2021-01-01");
        list.add(task);
        list.get(0).markComplete();

        boolean prevStatus = list.get(0).isComplete();
        list.get(0).markUncomplete();

        assertNotEquals(prevStatus, list.get(0).isComplete());
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex()
    {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Task 1", "desc", "2021-01-01");
        list.add(task);
        list.get(0).markComplete();

        assertThrows(IllegalArgumentException.class, () -> list.get(1).markUncomplete());
    }
}
