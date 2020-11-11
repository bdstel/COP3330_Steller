public class TaskItem
{
    protected String title;
    protected String desc;
    protected String dueDate;

    public TaskItem(String title, String desc, String dueDate)
    {
        if(titleIsValid(title)) {
            this.title = title;
        } else {
            throw new InvalidTitleException("Invalid Title; must be at least 1 character long");
        }

        this.desc = desc;

        if(dueDateIsValid(dueDate)) {
            this.dueDate = dueDate;
        } else {
            throw new InvalidDueDateException("Invalid Due Date; must be in the format YYYY-MM-DD");
        }
    }

    public boolean titleIsValid(String title)
    {
        return title.length() > 0;
    }

    public boolean dueDateIsValid(String dueDate)
    {
        return dueDate.length() == 10 &&
                dueDate.toCharArray()[4] == '-' &&
                dueDate.toCharArray()[7] == '-';
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