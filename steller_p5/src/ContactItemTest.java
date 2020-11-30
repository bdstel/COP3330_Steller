import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactItemTest
{
    @Test
    public void creationFailsWithAllBlankValues()
    {
        assertThrows(InvalidContactException.class, () -> new ContactItem("", "", "", ""));
    }

    @Test
    public void creationSucceedsWithBlankEmail()
    {
        assertDoesNotThrow(() -> new ContactItem("John", "Doe", "111-111-1111", ""));
    }

    @Test
    public void creationSucceedsWithBlankFirstName()
    {
        assertDoesNotThrow(() -> new ContactItem("", "Doe", "111-111-1111", "johndoe@email.com"));
    }

    @Test
    public void creationSucceedsWithBlankLastName()
    {
        assertDoesNotThrow(() -> new ContactItem("John", "", "111-111-1111", "johndoe@email.com"));
    }

    @Test
    public void creationSucceedsWithBlankPhone()
    {
        assertDoesNotThrow(() -> new ContactItem("John", "Doe", "", "johndoe@email.com"));
    }

    @Test
    public void creationSucceedsWithNonBlankValues()
    {
        assertDoesNotThrow(() -> new ContactItem("John", "Doe", "111-111-1111", "johndoe@email.com"));
    }

    @Test
    public void editingFailsWithAllBlankValues()
    {
        ContactItem contact = new ContactItem("John", "Doe", "111-111-1111", "johndoe@email.com");

        assertThrows(InvalidContactException.class, () -> {
            contact.setFirst("");
            contact.setLast("");
            contact.setPhone("");
            contact.setEmail("");
        });
    }

    @Test
    public void editingSucceedsWithBlankEmail()
    {
        ContactItem contact = new ContactItem("John", "Doe", "111-111-1111", "johndoe@email.com");

        assertDoesNotThrow(() -> {
            contact.setFirst("Joe");
            contact.setLast("Johnson");
            contact.setPhone("222-222-2222");
            contact.setEmail("");
        });
    }

    @Test
    public void editingSucceedsWithBlankFirstName()
    {
        ContactItem contact = new ContactItem("John", "Doe", "111-111-1111", "johndoe@email.com");

        assertDoesNotThrow(() -> {
            contact.setFirst("");
            contact.setLast("Johnson");
            contact.setPhone("222-222-2222");
            contact.setEmail("joejohnson@email.com");
        });
    }

    @Test
    public void editingSucceedsWithBlankLastName()
    {
        ContactItem contact = new ContactItem("John", "Doe", "111-111-1111", "johndoe@email.com");

        assertDoesNotThrow(() -> {
            contact.setFirst("Joe");
            contact.setLast("");
            contact.setPhone("222-222-2222");
            contact.setEmail("joejohnson@email.com");
        });
    }

    @Test
    public void editingSucceedsWithBlankPhone()
    {
        ContactItem contact = new ContactItem("John", "Doe", "111-111-1111", "johndoe@email.com");

        assertDoesNotThrow(() -> {
            contact.setFirst("Joe");
            contact.setLast("Johnson");
            contact.setPhone("");
            contact.setEmail("joejohnson@email.com");
        });
    }

    @Test
    public void editingSucceedsWithNonBlankValues()
    {
        ContactItem contact = new ContactItem("John", "Doe", "111-111-1111", "johndoe@email.com");

        assertDoesNotThrow(() -> {
            contact.setFirst("Joe");
            contact.setLast("Johnson");
            contact.setPhone("222-222-2222");
            contact.setEmail("joejohnson@email.com");
        });
    }

    @Test
    public void testToString()
    {

    }
}
