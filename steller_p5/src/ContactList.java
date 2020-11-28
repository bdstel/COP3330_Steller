import java.util.ArrayList;
import java.util.List;

public class ContactList
{
    protected List contacts = new ArrayList<ContactItem>();
    protected int size;

    public ContactList()
    {
        this.contacts = null;
        this.size = 0;
    }
}
