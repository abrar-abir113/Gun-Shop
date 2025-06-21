import java.util.Scanner;

public class AuthService {

    private final Scanner scanner = new Scanner(System.in);

    public void showLoginMenu() {
        while (true) {
            System.out.println("1. Customer Login");
            System.out.println("2. Admin Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" ->
                    customerMenu();
                case "2" ->
                    adminMenu();
                case "3" ->
                    System.exit(0);
                default ->
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void customerMenu() {
        System.out.println("1. Signup");
        System.out.println("2. Login");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1" ->
                FileManager.signupCustomer();
            case "2" -> {
                Customer c = FileManager.loginCustomer();
                if (c != null) {
                    CustomerPanel.show(c);
                }
            }
        }
    }

    private void adminMenu() {
        /*
        System.out.print("Enter Admin ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Password: ");
        String pass = scanner.nextLine();

        if (FileManager.loginAdmin(id, pass)) {
            AdminPanel.show();
        } else {
            System.out.println("Invalid admin credentials.");
        }
         */
        System.out.println("1. Admin Login");
        System.out.println("2. Admin Sign-Up");
        int choice = scanner.nextInt();

        if (choice == 1) {
            if (FileManager.loginAdmin()) {
                AdminPanel.show(); 
            }
        } else if (choice == 2) {
            FileManager.signupAdmin();
        }
    }
}
