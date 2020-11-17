public class TaskItem
{
    private String title;
    private String desc;
    private String dueDate;
    private boolean completed;

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

        this.completed = false;
    }

    public boolean titleIsValid(String title)
    {
        return title.length() > 0;
    }

    public boolean dueDateIsValid(String dueDate)
    {
        boolean yearIsValid = false;
        int validChars = 0;
        for (int i = 0; i < 4; i++)
        {
            if (dueDate.toCharArray()[i] >= '0' && dueDate.toCharArray()[i] <= '9')
            {
                validChars++;
            }
        }
        if (validChars == 4)
        {
            yearIsValid = true;
        }

        boolean monthIsValid = false;
        for (int i = 5; i < 7; i++)
        {
            if (dueDate.toCharArray()[i] >= '0' && dueDate.toCharArray()[i] <= '9')
            {
                validChars++;
            }
        }
        if (validChars == 6)
        {
            monthIsValid = true;
        }

        boolean dayIsValid = false;
        for (int i = 8; i < dueDate.length(); i++)
        {
            if (dueDate.toCharArray()[i] >= '0' && dueDate.toCharArray()[i] <= '9')
            {
                validChars++;
            }
        }
        if (validChars == 8)
        {
            dayIsValid = true;
        }

        return dueDate.length() == 10 &&
                dueDate.toCharArray()[4] == '-' &&
                dueDate.toCharArray()[7] == '-' &&
                yearIsValid &&
                monthIsValid &&
                dayIsValid;
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

    public boolean isCompleted()
    {
        return completed;
    }

    public void setTitle(String title)
    {
        if (titleIsValid(title)) {
            this.title = title;
        } else {
            throw new InvalidTitleException("Invalid Title; must be at least 1 character long");
        }
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
    }

    public void setDueDate(String dueDate)
    {
        if(dueDateIsValid(dueDate)) {
            this.dueDate = dueDate;
        } else {
            throw new InvalidDueDateException("Invalid Due Date; must be in the format YYYY-MM-DD");
        }
    }

    public void markComplete()
    {
        this.completed = true;
    }

    public void markUncomplete()
    {
        this.completed = false;
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