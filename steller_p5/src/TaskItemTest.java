import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskItemTest
{
    @Test
    public void constructorFailsWithInvalidDueDate()
    {
        assertThrows(InvalidDueDateException.class, () -> new TaskItem("Task 1", "Description", "01-01-2021"));
    }

    @Test
    public void constructorFailsWithInvalidTitle()
    {
        assertThrows(InvalidTitleException.class, () -> new TaskItem("", "description", "2021-01-01"));
    }

    @Test
    public void constructorSucceedsWithValidDueDate()
    {
        TaskItem task = new TaskItem("Task 1", "Description", "2021-01-01");

        assertEquals("2021-01-01", task.getDueDate());
    }

    @Test
    public void constructorSucceedsWithValidTitle()
    {
        TaskItem task = new TaskItem("Task 1", "Description", "2021-01-01");

        assertEquals("Task 1", task.getTitle());
    }

    @Test
    public void editingDescriptionSucceedsWithExpectedValue()
    {
        TaskItem task = new TaskItem("Task 1", "Description", "2021-01-01");
        task.setDesc("New Description");

        assertEquals("New Description", task.getDesc());
    }

    @Test
    public void editingDueDateFailsWithInvalidDateFormat()
    {
        TaskItem task = new TaskItem("Task 1", "Description", "2021-01-01");

        assertThrows(InvalidDueDateException.class, () -> task.setDueDate("01-01-2021"));
    }

    @Test
    public void editingDueDateFailsWithInvalidYYYYMMDD()
    {
        TaskItem task = new TaskItem("Task 1", "Description", "2021-01-01");

        assertThrows(InvalidDueDateException.class, () -> task.setDueDate("yyyy-mm-dd"));
    }

    @Test
    public void editingDueDateSucceedsWithExpectedValue()
    {
        TaskItem task = new TaskItem("Task 1", "Description", "2021-01-01");
        task.setDueDate("2021-05-04");

        assertEquals("2021-05-04", task.getDueDate());
    }

    @Test
    public void editingTitleFailsWithEmptyString()
    {
        TaskItem task = new TaskItem("Task 1", "Description", "2021-01-01");

        assertThrows(InvalidTitleException.class, () -> task.setTitle(""));
    }

    @Test
    public void editingTitleSucceedsWithExpectedValue()
    {
        TaskItem task = new TaskItem("Task 1", "Description", "2021-01-01");
        task.setTitle("New Task Title");

        assertEquals("New Task Title", task.getTitle());
    }
}
