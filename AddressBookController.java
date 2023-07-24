import java.util.ArrayList;
import java.util.List;

public class AddressBookController {
    private List<Contact> contacts;
    private AddressBookView view;

    public AddressBookController(AddressBookView view) {
        contacts = new ArrayList<>();
        this.view = view;
    }

    public void start() {
        int choice = 0;
        do {
            view.displayMenu();
            choice = Integer.parseInt(new java.util.Scanner(System.in).nextLine());
            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    updateContact();
                    break;
                case 3:
                    deleteContact();
                    break;
                case 4:
                    searchContacts();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 5);
    }

    private void addContact() {
        Contact contact = view.getContactDetails();
        contacts.add(contact);
        System.out.println("Contact added successfully.\n");
    }

    private void updateContact() {
        String searchCriteria = view.getSearchCriteria();
        Contact contact = searchContact(searchCriteria);
        if (contact != null) {
            Contact updatedContact = view.getContactDetails();
            contact.setName(updatedContact.getName());
            contact.setPhoneNumber(updatedContact.getPhoneNumber());
            contact.setEmailAddress(updatedContact.getEmailAddress());
            System.out.println("Contact updated successfully.\n");
        } else {
            view.displayErrorMessage("Contact not found.");
        }
    }

    private void deleteContact() {
        String searchCriteria = view.getSearchCriteria();
        Contact contact = searchContact(searchCriteria);
        if (contact != null) {
            contacts.remove(contact);
            System.out.println("Contact deleted successfully.\n");
        } else {
            view.displayErrorMessage("Contact not found.");
        }
    }

    private void searchContacts() {
        String searchCriteria = view.getSearchCriteria();
        List<Contact> searchResults = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getName().contains(searchCriteria) || contact.getPhoneNumber().contains(searchCriteria) ||
                    contact.getEmailAddress().contains(searchCriteria)) {
                searchResults.add(contact);
            }
        }
        if (!searchResults.isEmpty()) {
            for (Contact contact : searchResults) {
                view.displayContact(contact);
            }
        } else {
            view.displayErrorMessage("No contacts found.");
        }
    }

    private Contact searchContact(String searchCriteria) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(searchCriteria) || contact.getPhoneNumber().equals(searchCriteria) ||
                    contact.getEmailAddress().equalsIgnoreCase(searchCriteria)) {
                return contact;
            }
        }
        return null;
    }
}
