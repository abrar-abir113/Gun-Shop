import java.io.*;
import java.util.*;

public class BookingService {

    private static final String BOOKING_FILE = "S:\\GitHub\\Gunshop\\deta\\bookings.txt";
    private static final String CONFIRMED_FILE = "S:\\GitHub\\Gunshop\\deta\\confirmed_bookings.txt";
    private static final String BILL_DIR = "S:\\GitHub\\Gunshop\\deta\\customer_bills";

    public static void viewBookings(Customer customer) {
        try (Scanner scanner = new Scanner(new File(BOOKING_FILE))) {
            while (scanner.hasNextLine()) {
                Booking booking = Booking.fromString(scanner.nextLine());
                if (booking.getUsername().equals(customer.getUsername())) {
                    System.out.printf("Booked: %s \t\t\n", booking.item);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading booking file.");
        }
    }

    public static void addBooking(Customer customer) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What would you like to book?");
        System.out.println("1. Gun");
        System.out.println("2. Ammo");
        System.out.print("Enter choice: ");
        int choice = Integer.parseInt(scanner.nextLine());

        try (PrintWriter pw = new PrintWriter(new FileWriter("S:\\GitHub\\Gunshop\\deta\\bookings.txt", true))) {
            if (choice == 1) {
                List<Gun> guns = GunService.loadGuns();
                System.out.println("\n Available Guns:");
                for (int i = 0; i < guns.size(); i++) {
                    Gun g = guns.get(i);
                    System.out.printf("\t %d. %s (%s) - $ %.2f \t\n", i + 1, g.getName(), g.getType(),
                            g.getPrice());
                }
                System.out.print("Choose gun number: ");
                int index = Integer.parseInt(scanner.nextLine()) - 1;
                if (index >= 0 && index < guns.size()) {
                    Gun g = guns.get(index);
                    pw.println(customer.getUsername() + "," + g.getName() + ",1,gun," + g.getPrice());
                    System.out.println("Gun booked!");
                }
            } else if (choice == 2) {
                List<String> ammoList = GunService.loadAmmo();
                System.out.println("\nAvailable Ammo:");
                for (int i = 0; i < ammoList.size(); i++) {
                    System.out.println((i + 1) + ". " + ammoList.get(i));
                }
                System.out.print("Choose ammo number: ");
                int index = Integer.parseInt(scanner.nextLine()) - 1;
                if (index >= 0 && index < ammoList.size()) {
                    String[] parts = ammoList.get(index).split(" - \\$");
                    String name = parts[0];
                    double price = Double.parseDouble(parts[1]);
                    pw.println(customer.getUsername() + "," + name + ",1,ammo," + price);
                    System.out.println("Ammo booked!");
                }
            } else {
                System.out.println("Invalid choice.");
            }
        } catch (IOException e) {
            System.out.println("Error writing booking.");
        }
    }

    public static void calculateBill(Customer customer) {
        double total = 0;
        try (Scanner scanner = new Scanner(new File("S:\\GitHub\\Gunshop\\deta\\bookings.txt"))) {
            while (scanner.hasNextLine()) {
                Booking booking = Booking.fromString(scanner.nextLine());
                if (booking.getUsername().equals(customer.getUsername())) {
                    total += booking.getPrice();
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading bookings.");
        }
        System.out.printf("Total Bill: $ %.2f \n", total);
    }

    /*
     * public static void generateBill(Customer customer) {
     * List<Booking> customerBookings = new ArrayList<>();
     * double total = 0;
     * try (Scanner scanner = new Scanner(new
     * File("E:\\ProjectFinal\\src\\main\\java\\deta\\customer_bills"))) {
     * while (scanner.hasNextLine()) {
     * Booking b = Booking.fromString(scanner.nextLine());
     * if (b.getUsername().equals(customer.getUsername())) {
     * customerBookings.add(b);
     * total += b.getPrice();
     * }
     * }
     * } catch (IOException e) {
     * System.out.println("Error reading bookings.");
     * }
     * 
     * File billFile = new File(BILL_DIR + customer.getUsername() +
     * "E:\\ProjectFinal\\src\\main\\java\\deta\\customer_bills");
     * try (PrintWriter writer = new PrintWriter(billFile)) {
     * writer.println("===== Customer Bill =====");
     * for (Booking b : customerBookings) {
     * writer.printf("Item: %s | Price: $%.2f\n", b.item, b.getPrice());
     * }
     * writer.printf("TOTAL: $%.2f\n", total);
     * System.out.println("Bill generated at: " + billFile.getPath());
     * } catch (IOException e) {
     * System.out.println("Failed to generate bill.");
     * }
     * }
     */
    public static void generateBill(Customer customer) {

        System.out.println("Thanks for purchase.");
        System.out.println("Your bill was recoreded");
        System.out.println("Plese come with liencence to collect product");
    }
}
