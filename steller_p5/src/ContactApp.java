import java.util.Scanner;

public class ContactApp
{
    private static final Scanner input = new Scanner(System.in);

    public void printMenu()
    {
        while(true)
        {
            System.out.printf("%nMain Menu%n" +
                    "---------%n%n" +
                    "1) Create a new list%n" +
                    "2) Load an existing list%n" +
                    "3) Quit%n%n");

            switch(input.nextInt())
            {
                case 1: {
                    ContactList list = new ContactList();
                    System.out.println("New Contact List has been created");
                    printListMenu(list);

                    break;
                }
                case 2: {
                    System.out.print("Enter the file name to load: ");

                    ContactList list = new ContactList();
                    input.nextLine();
                    String filename = input.nextLine();
                    list.read(filename);

                    System.out.println("Contact List has been loaded");
                    printListMenu(list);

                    break;
                }
                case 3:
                    return;
                default:
                    System.out.println("Input must be between 1 and 3");
            }
        }
    }

    public void printListMenu(ContactList list)
    {
        while(true)
        {
            System.out.printf("%nList Operation Menu%n" +
                    "-------------------%n%n" +
                    "1) View the list%n" +
                    "2) Add an item%n" +
                    "3) Edit an item%n" +
                    "4) Remove an item%n" +
                    "5) Save the current contact list%n" +
                    "6) Quit to the main menu%n");

            switch(input.nextInt())
            {
                case 1:
                    list.printList();
                    break;
                case 2:
                    list.createContact();
                    break;
                case 3: {
                    list.printList();

                    System.out.print("Which contact will you edit? ");
                    int contactNum = input.nextInt();
                    input.nextLine();

                    if (contactNum < list.size() && contactNum >= 0) {
                        ContactItem contact = list.get(contactNum);

                        try {
                            System.out.print("First name: ");
                            contact.setFirst(input.nextLine());

                            System.out.print("Last name: ");
                            contact.setLast(input.nextLine());

                            System.out.print("Phone number (xxx-xxx-xxxx): ");
                            contact.setPhone(input.nextLine());

                            System.out.print("Email address (x@y.z): ");
                            contact.setEmail(input.nextLine());
                        } catch (InvalidContactException ex) {
                            System.out.println("Contact must have at least 1 non-blank field; Contact not created");
                        }
                    } else {
                        System.out.println("Contact number must be valid (within list size)");
                    }

                    break;
                }
                case 4: {
                    list.printList();

                    System.out.print("Which contact will you remove? ");
                    int contactNum = input.nextInt();

                    if (contactNum < list.size() && contactNum >= 0) {
                        ContactItem contact = list.get(contactNum);
                        list.delete(contact);
                    } else {
                        System.out.println("Contact number must be valid (within list size)");
                    }

                    break;
                }
                case 5:
                    System.out.print("Enter the file name to save the list as: ");
                    input.nextLine();
                    String filename = input.nextLine();
                    list.write(filename);

                    break;
                case 6:
                    return;
                default:
                    System.out.println("Input must be between 1 and 8");
            }
        }
    }
}
