import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskItemTest
{
    @Test
    public void creatingTaskItemFailsWithInvalidDueDate()
    {
        assertThrows(InvalidDueDateException.class, () -> new TaskItem("Task 1", "desc", "01-01-2021"));
    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitle()
    {
        assertThrows(InvalidTitleException.class, () -> new TaskItem("", "desc", "2021-01-01"));
    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate()
    {
        TaskItem task = new TaskItem("Task 1", "desc", "2021-01-01");

        assertEquals("2021-01-01", task.getDueDate());
    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle()
    {
        TaskItem task = new TaskItem("Task 1", "desc", "2021-01-01");

        assertEquals("Task 1", task.getTitle());
    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate()
    {
        TaskItem task = new TaskItem("Task 1", "desc", "2021-01-01");
        assertThrows(InvalidDueDateException.class, () -> task.setDueDate("01-01-2021"));
    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate()
    {
        TaskItem task = new TaskItem("Task 1", "desc", "2021-01-01");

        task.setDueDate("2021-05-01");
        assertEquals("2021-05-01", task.getDueDate());
    }

    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle()
    {
        TaskItem task = new TaskItem("Task 1", "desc", "2021-01-01");
        assertThrows(InvalidTitleException.class, () -> task.setTitle(""));
    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle()
    {
        TaskItem task = new TaskItem("Task 1", "desc", "2021-01-01");

        task.setTitle("New Task Title");
        assertEquals("New Task Title", task.getTitle());
    }

    @Test
    public void editingTaskItemDescriptionChangesValue()
    {
        TaskItem task = new TaskItem("Task 1", "desc", "2021-01-01");
        String description = task.getDesc();

        task.setDesc("new description");
        assertNotEquals(description, task.getDesc());
    }

    @Test
    public void editingTaskItemDueDateChangesValue()
    {
        TaskItem task = new TaskItem("Task 1", "desc", "2021-01-01");
        String dueDate = task.getDueDate();

        task.setDueDate("2021-05-05");
        assertNotEquals(dueDate, task.getDueDate());
    }

    @Test
    public void editingTaskItemTitleChangesValue()
    {
        TaskItem task = new TaskItem("Task 1", "desc", "2021-01-01");
        String title = task.getTitle();

        task.setTitle("New Title");
        assertNotEquals(title, task.getTitle());
    }

    @Test
    public void completingTaskItemChangesStatus()
    {
        TaskItem task = new TaskItem("Task 1", "desc", "2021-01-01");

        boolean status = task.isCompleted();
        task.markComplete();

        assertNotEquals(status, task.isCompleted());
    }

    @Test
    public void uncompletingTaskItemChangesStatus()
    {
        TaskItem task = new TaskItem("Task 1", "desc", "2021-01-01");
        task.markComplete();

        boolean status = task.isCompleted();
        task.markUncomplete();

        assertNotEquals(status, task.isCompleted());
    }
}
