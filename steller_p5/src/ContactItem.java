public class ContactItem
{
    protected String firstName;
    protected String lastName;
    protected int phoneNum;
    protected String email;

    public ContactItem(String first, String last, int phone, String email)
    {
        this.firstName = first;
        this.lastName = last;
        this.phoneNum = phone;
        this.email = email;
    }
}
