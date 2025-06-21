import java.io.*;
import java.util.*;

public class AdminPanel {

    private static final String BOOKING_FILE = "S:\\GitHub\\Gunshop\\deta\\bookings.txt";
    private static final String CONFIRMED_FILE = "S:\\GitHub\\Gunshop\\deta\\confirmed_bookings.txt";

    public static void show() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("""
                        1. View All Bookings
                        2. Confirm All Bookings
                        3. Add Gun
                        4. Add Ammo
                        5. Logout
                    """);
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" ->
                    viewAllBookings();
                case "2" ->
                    confirmBookings();
                case "3" ->
                    addGun();
                case "4" ->
                    addAmmo();
                case "5" -> {
                    return;
                }
            }
        }
    }

    /*
     * public static void addBooking() {
     * Scanner scanner = new Scanner(System.in);
     * System.out.print("Enter Customer Username: ");
     * String username = scanner.nextLine();
     * System.out.print("Enter Item Name: ");
     * String itemName = scanner.nextLine();
     * System.out.print("Enter Quantity: ");
     * int quantity = scanner.nextInt();
     * scanner.nextLine();
     * System.out.print("Enter Type (gun/ammo): ");
     * String type = scanner.nextLine();
     * System.out.print("Enter Price per unit: ");
     * double price = scanner.nextDouble();
     * scanner.nextLine();
     * 
     * try (BufferedWriter bw = new BufferedWriter(new
     * FileWriter("E:\\ProjectFinal\\src\\main\\java\\deta\\bookings.txt", true))) {
     * bw.write(username + "," + itemName + "," + quantity + "," + type + "," +
     * price);
     * bw.newLine();
     * System.out.println("Booking added.");
     * } catch (IOException e) {
     * System.out.println("Error writing to bookings.txt");
     * }
     * }
     */
    private static void viewAllBookings() {
        try (Scanner scanner = new Scanner(new File(BOOKING_FILE))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Error reading bookings.");
        }
    }

    private static void confirmBookings() {
        try (
                Scanner scanner = new Scanner(new File(BOOKING_FILE));
                PrintWriter writer = new PrintWriter(new FileWriter(CONFIRMED_FILE, true))) {
            while (scanner.hasNextLine()) {
                writer.println(scanner.nextLine());
            }
            new PrintWriter(BOOKING_FILE).close();
            System.out.println("All bookings confirmed.");
        } catch (IOException e) {
            System.out.println("Error confirming bookings.");
        }
    }

    public static void addGun() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Gun Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Gun Type (long/short): ");
        String type = sc.nextLine();
        System.out.print("Enter Price: ");
        double price = sc.nextDouble();
        sc.nextLine();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("S:\\GitHub\\Gunshop\\deta\\guns.txt", true))) {
            bw.write(name + "," + type + "," + price);
            bw.newLine();
            System.out.println("Gun added.");
        } catch (IOException e) {
            System.out.println("Error writing to guns.txt");
        }
    }

    public static void addAmmo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Ammo Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Price: ");
        double price = sc.nextDouble();
        sc.nextLine();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("S:\\GitHub\\Gunshop\\deta\\ammo.txt", true))) {
            bw.write(name + " - $" + price);
            bw.newLine();
            System.out.println("Ammo added.");
        } catch (IOException e) {
            System.out.println("Error writing to ammo.txt");
        }
    }
}
