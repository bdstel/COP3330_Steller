import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactListTest
{
    @Test
    public void addingItemsIncreasesSize()
    {
        ContactList list = new ContactList();
        int prevSize = list.size();

        ContactItem contact = new ContactItem("John", "Doe", "111-111-1111", "johndoe@email.com");
        list.add(contact);

        assertEquals(prevSize + 1, list.size());
    }

    @Test
    public void editingItemsFailsWithAllBlankValues()
    {
        ContactList list = new ContactList();
        ContactItem contact = new ContactItem("John", "Doe", "111-111-1111", "johndoe@email.com");
        list.add(contact);

        assertThrows(InvalidContactException.class, () -> {
            list.get(0).setFirst("");
            list.get(0).setLast("");
            list.get(0).setPhone("");
            list.get(0).setEmail("");
        });
    }

    @Test
    public void editingItemsFailsWithInvalidIndex()
    {
        ContactList list = new ContactList();
        ContactItem contact = new ContactItem("John", "Doe", "111-111-1111", "johndoe@email.com");
        list.add(contact);

        assertThrows(IllegalArgumentException.class, () -> list.get(1).setFirst("joe"));
    }

    @Test
    public void editingSucceedsWithBlankFirstName()
    {
        ContactList list = new ContactList();
        ContactItem contact = new ContactItem("John", "Doe", "111-111-1111", "johndoe@email.com");
        list.add(contact);

        assertDoesNotThrow(() -> {
            list.get(0).setFirst("");
            list.get(0).setLast("johnson");
            list.get(0).setPhone("222-222-2222");
            list.get(0).setEmail("joejohnson@email.com");
        });
    }

    @Test
    public void editingSucceedsWithBlankLastName()
    {
        ContactList list = new ContactList();
        ContactItem contact = new ContactItem("John", "Doe", "111-111-1111", "johndoe@email.com");
        list.add(contact);

        assertDoesNotThrow(() -> {
            list.get(0).setFirst("joe");
            list.get(0).setLast("");
            list.get(0).setPhone("222-222-2222");
            list.get(0).setEmail("joejohnson@email.com");
        });
    }

    @Test
    public void editingSucceedsWithBlankPhone()
    {
        ContactList list = new ContactList();
        ContactItem contact = new ContactItem("John", "Doe", "111-111-1111", "johndoe@email.com");
        list.add(contact);

        assertDoesNotThrow(() -> {
            list.get(0).setFirst("joe");
            list.get(0).setLast("johnson");
            list.get(0).setPhone("");
            list.get(0).setEmail("joejohnson@email.com");
        });
    }

    @Test
    public void editingSucceedsWithBlankEmail()
    {
        ContactList list = new ContactList();
        ContactItem contact = new ContactItem("John", "Doe", "111-111-1111", "johndoe@email.com");
        list.add(contact);

        assertDoesNotThrow(() -> {
            list.get(0).setFirst("joe");
            list.get(0).setLast("johnson");
            list.get(0).setPhone("222-222-2222");
            list.get(0).setEmail("");
        });
    }

    @Test
    public void editingSucceedsWithNonBlankValues()
    {
        ContactList list = new ContactList();
        ContactItem contact = new ContactItem("John", "Doe", "111-111-1111", "johndoe@email.com");
        list.add(contact);

        assertDoesNotThrow(() -> {
            list.get(0).setFirst("joe");
            list.get(0).setLast("johnson");
            list.get(0).setPhone("222-222-2222");
            list.get(0).setEmail("joejohnson@email.com");
        });
    }

    @Test
    public void newListIsEmpty()
    {
        ContactList list = new ContactList();

        assertEquals(0, list.size());
    }

    @Test
    public void removingItemsDecreasesSize()
    {
        ContactList list = new ContactList();
        ContactItem contact = new ContactItem("John", "Doe", "111-111-1111", "johndoe@email.com");
        list.add(contact);

        int prevSize = list.size();
        list.delete(contact);

        assertEquals(prevSize - 1, list.size());
    }

    @Test
    public void removingItemsFailsWithInvalidIndex()
    {
        ContactList list = new ContactList();
        ContactItem contact = new ContactItem("John", "Doe", "111-111-1111", "johndoe@email.com");
        list.add(contact);

        assertThrows(IllegalArgumentException.class, () -> list.delete(list.get(1)));
    }

    @Test
    public void savedContactListCanBeLoaded()
    {
        ContactList list1 = new ContactList();
        ContactItem contact = new ContactItem("John", "Doe", "111-111-1111", "johndoe@email.com");
        list1.add(contact);

        list1.write("cList.txt");

        ContactList list2 = new ContactList();
        list2.read("cList.txt");

        assertEquals("John", list2.get(0).getFirst());
        assertEquals("Doe", list2.get(0).getLast());
        assertEquals("111-111-1111", list2.get(0).getPhone());
        assertEquals("johndoe@email.com", list2.get(0).getEmail());
        assertEquals(list1.size(), list2.size());
    }
}
