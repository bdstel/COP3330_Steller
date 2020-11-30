import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class ContactList
{
    Scanner input = new Scanner(System.in);

    protected List<ContactItem> contacts;

    public ContactList()
    {
        this.contacts = new ArrayList<>();
    }

    public void createContact()
    {
        ContactItem contact;

        while(true)
        {
            try
            {
                String first = getContactFirst();
                String last = getContactLast();
                String phone = getContactPhone();
                String email = getContactEmail();

                contact = new ContactItem(first, last, phone, email);

                add(contact);

                break;
            }
            catch (InvalidContactException ex)
            {
                System.out.println("Invalid Contact; please double check and try again");
            }
        }
    }

    public String getContactFirst()
    {
        System.out.print("First name: ");
        return input.nextLine();
    }

    public String getContactLast()
    {
        System.out.print("Last name: ");
        return input.nextLine();
    }

    public String getContactPhone()
    {
        System.out.print("Phone number (xxx-xxx-xxxx): ");
        return input.nextLine();
    }

    public String getContactEmail()
    {
        System.out.print("Email address (x@y.z): ");
        return input.nextLine();
    }

    public ContactItem get(int i)
    {
        if (i < 0 || i >= contacts.size())
        {
            throw new IllegalArgumentException("Index must be within 0 and the list size");
        }

        return contacts.get(i);
    }

    public void add(ContactItem contact)
    {
        contacts.add(contact);
    }

    public int size()
    {
        return contacts.size();
    }

    public void delete(ContactItem contact)
    {
        contacts.remove(contact);
    }

    public void read(String filename)
    {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filename)))
        {
            String line = bufferedReader.readLine();

            while(line != null)
            {
                int firstEnd = line.indexOf(';');
                int lastEnd = line.indexOf(';', firstEnd+1);
                int phoneEnd = line.lastIndexOf(';');

                String first = line.substring(0, firstEnd);
                String last = line.substring(firstEnd+1, lastEnd);
                String phone = line.substring(lastEnd+1, phoneEnd);
                String email = line.substring(phoneEnd+1);

                ContactItem contact = new ContactItem(first, last, phone, email);

                contacts.add(contact);

                line = bufferedReader.readLine();
            }
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Unable to find file.");
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public void write(String filename)
    {
        try(Formatter output = new Formatter(filename))
        {
            for(ContactItem contact : contacts)
            {
                output.format("%s;%s;%s;%s%n", contact.getFirst(), contact.getLast(), contact.getPhone(), contact.getEmail());
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void printList()
    {
        for (int i = 0; i < contacts.size(); i++)
        {
            ContactItem contact = contacts.get(i);

            System.out.printf("%d) Name: %s %s%nPhone: %s%nEmail: %s%n", i, contact.getFirst(), contact.getLast(), contact.getPhone(), contact.getEmail());
        }
    }
}
