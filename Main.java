public class Main {
    public static void main(String[] args) {
        AddressBookView view = new AddressBookView();
        AddressBookController controller = new AddressBookController(view);
        controller.start();
    }
}
