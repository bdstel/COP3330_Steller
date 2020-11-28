import java.util.Date;

public class TaskItem
{
    protected String title;
    protected String desc;
    protected String dueDate;

    public TaskItem(String title, String desc, String dueDate)
    {
        this.title = title;
        this.desc = desc;
        this.dueDate = dueDate;
    }
}

class InvalidTitleException extends IllegalArgumentException
{
    public InvalidTitleException(String msg)
    {
        super(msg);
    }
}

class InvalidDueDateException extends IllegalArgumentException
{
    public InvalidDueDateException(String msg)
    {
        super(msg);
    }
}