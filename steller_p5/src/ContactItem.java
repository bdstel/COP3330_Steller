public class ContactItem
{
    protected String first;
    protected String last;
    protected String phone;
    protected String email;

    public ContactItem(String first, String last, String phone, String email)
    {
        if (contactIsValid(first, last, phone, email))
        {
            this.first = first;
            this.last = last;
            this.phone = phone;
            this.email = email;
        }
        else
        {
            throw new InvalidContactException("Invalid contact; must have at least 1 non-blank field");
        }
    }

    public boolean contactIsValid(String first, String last, String phone, String email)
    {
        return !(first.isBlank() && last.isBlank() && phone.isBlank() && email.isBlank());
    }

    public boolean phoneIsValid(String phone)
    {
        int numValid = 0;

        for (int i = 0; i < phone.length(); i++)
        {
            if (phone.toCharArray()[i] >= '0' && phone.toCharArray()[i] <= '9')
            {
                numValid++;
            }
        }

        return phone.length() == 12 &&
                phone.toCharArray()[3] == '-' &&
                phone.toCharArray()[7] == '-' &&
                numValid == 10;
    }

    public boolean emailIsValid(String email)
    {
        return email.contains("@") && email.contains(".") && (email.indexOf('.') > email.indexOf('@'));
    }

    public String getFirst()
    {
        return this.first;
    }

    public String getLast()
    {
        return this.last;
    }

    public String getPhone()
    {
        return this.phone;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setFirst(String first)
    {
        if (contactIsValid(first, this.last, this.phone, this.email))
        {
            this.first = first;
        }
        else
        {
            throw new InvalidContactException("Invalid contact; must have at least 1 non-blank field");
        }
    }

    public void setLast(String last)
    {
        if (contactIsValid(this.first, last, this.phone, this.email))
        {
            this.last = last;
        }
        else
        {
            throw new InvalidContactException("Invalid contact; must have at least 1 non-blank field");
        }
    }

    public void setPhone(String phone)
    {
        if (contactIsValid(this.first, this.last, phone, this.email))
        {
            this.phone = phone;
        }
        else
        {
            throw new InvalidContactException("Invalid contact; must have at least 1 non-blank field");
        }
    }

    public void setEmail(String email)
    {
        if (contactIsValid(this.first, this.last, this.phone, email))
        {
            this.email = email;
        }
        else
        {
            throw new InvalidContactException("Invalid contact; must have at least 1 non-blank field");
        }
    }
}

class InvalidContactException extends IllegalArgumentException
{
    public InvalidContactException(String msg)
    {
        super(msg);
    }
}