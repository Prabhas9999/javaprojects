import java.util.Scanner;

public class AddressBookView {
    private Scanner scanner;

    public AddressBookView() {
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("1. Add a contact");
        System.out.println("2. Update a contact");
        System.out.println("3. Delete a contact");
        System.out.println("4. Search contacts");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    public Contact getContactDetails() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter email address: ");
        String emailAddress = scanner.nextLine();
        return new Contact(name, phoneNumber, emailAddress);
    }

    public String getSearchCriteria() {
        System.out.print("Enter search criteria: ");
        return scanner.nextLine();
    }

    public void displayContact(Contact contact) {
        System.out.println("Name: " + contact.getName());
        System.out.println("Phone Number: " + contact.getPhoneNumber());
        System.out.println("Email Address: " + contact.getEmailAddress());
        System.out.println();
    }

    public void displayErrorMessage(String message) {
        System.out.println("Error: " + message);
    }
}
