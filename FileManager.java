
import java.io.*;
import java.util.*;

public class FileManager {

    static final String CUSTOMER_FILE = "S:\\GitHub\\Gunshop\\deta\\customers.txt";
    static final String ADMIN_FILE = "S:\\GitHub\\Gunshop\\deta\\admins.txt";

    public static void signupCustomer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        try (PrintWriter out = new PrintWriter(new FileWriter(CUSTOMER_FILE, true))) {
            out.println(username + "," + password);
            System.out.println("Signup successful.");
        } catch (IOException e) {
            System.out.println("Error writing file.");
        }
    }

    public static Customer loginCustomer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        try (Scanner file = new Scanner(new File(CUSTOMER_FILE))) {
            while (file.hasNextLine()) {
                Customer c = Customer.fromString(file.nextLine());
                if (c.getUsername().equals(username) && c.getPassword().equals(password)) {
                    System.out.println("Login successful.");
                    return c;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
        System.out.println("Login failed.");
        return null;
    }

    /*
     * public static boolean loginAdmin(String id, String pass) {
     * try (Scanner file = new Scanner(new File(ADMIN_FILE))) {
     * while (file.hasNextLine()) {
     * String[] parts = file.nextLine().split(",");
     * if (parts[0].equals(id) && parts[1].equals(pass)) {
     * return true;
     * }
     * }
     * } catch (IOException e) {
     * System.out.println("Error reading admin file.");
     * }
     * return false;
     * }
     */
    public static void signupAdmin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter new Admin Username: ");
        String username = sc.nextLine().trim();

        if (isUserExists(username)) {
            System.out.println("Username already exists. Try logging in.");
            return;
        }

        System.out.print("Enter Password: ");
        String password = sc.nextLine().trim();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ADMIN_FILE, true))) {
            bw.write(username + "," + password);
            bw.newLine();
            System.out.println("Admin account created successfully.");
        } catch (IOException e) {
            System.out.println("Error creating admin account.");
        }
    }

    public static boolean loginAdmin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Admin Username: ");
        String username = sc.nextLine().trim();
        System.out.print("Enter Password: ");
        String password = sc.nextLine().trim();

        try (BufferedReader br = new BufferedReader(new FileReader(ADMIN_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] creds = line.split(",");
                if (creds.length == 2 && creds[0].equals(username) && creds[1].equals(password)) {
                    System.out.println("Login successful.");
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading admin data.");
        }

        System.out.println("Invalid credentials.");
        return false;
    }

    private static boolean isUserExists(String username) {
        try (BufferedReader br = new BufferedReader(new FileReader(ADMIN_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] creds = line.split(",");
                if (creds.length >= 1 && creds[0].equals(username)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error checking existing users.");
        }
        return false;
    }

}
