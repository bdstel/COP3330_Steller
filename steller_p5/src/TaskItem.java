public class TaskItem
{
    protected String title;
    protected String desc;
    protected String dueDate;
    protected boolean complete;

    public TaskItem(String title, String desc, String dueDate)
    {
        if (titleIsValid(title))
        {
            this.title = title;
        }
        else
        {
            throw new InvalidTitleException("Invalid Title; must be at least 1 character in length");
        }

        this.desc = desc;

        if (dueDateIsValid(dueDate))
        {
            this.dueDate = dueDate;
        }
        else
        {
            throw new InvalidDueDateException("Invalid Due Date; must be in the format YYYY-MM-DD");
        }

        this.complete = false;
    }

    public boolean titleIsValid(String title)
    {
        return title.length() > 0;
    }

    public boolean dueDateIsValid(String dueDate)
    {
        int numValid = 0;

        for(int i = 0; i < dueDate.length(); i++)
        {
            if (dueDate.toCharArray()[i] >= '0' && dueDate.toCharArray()[i] <= '9')
            {
                numValid++;
            }
        }

        return dueDate.length() == 10 &&
                dueDate.toCharArray()[4] == '-' &&
                dueDate.toCharArray()[7] == '-' &&
                numValid == 8;
    }

    public String getTitle()
    {
        return this.title;
    }

    public String getDesc()
    {
        return this.desc;
    }

    public String getDueDate()
    {
        return this.dueDate;
    }

    public boolean isComplete()
    {
        return this.complete;
    }

    public void setTitle(String title)
    {
        if (titleIsValid(title))
        {
            this.title = title;
        }
        else
        {
            throw new InvalidTitleException("Invalid Title; must be at least 1 character long");
        }
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
    }

    public void setDueDate(String dueDate)
    {
        if (dueDateIsValid(dueDate))
        {
            this.dueDate = dueDate;
        }
        else
        {
            throw new InvalidDueDateException("Invalid Due Date; must be in the format YYYY-MM-DD");
        }
    }

    public void markComplete()
    {
        this.complete = true;
    }

    public void markUncomplete()
    {
        this.complete = false;
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