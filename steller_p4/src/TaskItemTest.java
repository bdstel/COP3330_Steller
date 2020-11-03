import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskItemTest
{
    @Test
    public void creatingTaskItemFailsWithInvalidDueDate()
    {
        TaskItem task = new TaskItem();
        task.dueDate = "12-01-2020"; // not YYYY-MM-DD
        // ???
    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitle()
    {
        TaskItem task = new TaskItem();
        task.title = ""; // < 1 char
        // ???
    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate()
    {
        TaskItem task = new TaskItem();
        task.dueDate = "2020-12-01";
        // ???
    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle()
    {
        TaskItem task = new TaskItem();
        task.title = "Title";
        // ???
    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate()
    {

    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate()
    {

    }

    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle()
    {

    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle()
    {

    }
}
