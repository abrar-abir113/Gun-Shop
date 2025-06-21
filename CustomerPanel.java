
import java.util.Scanner;

public class CustomerPanel {

    public static void show(Customer customer) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("""
                        1. Show Guns
                        2. Show Short Guns
                        3. Show Ammolation
                        4. Add Booking
                        5. My Booking
                        6. Total Cart Bill
                        7. Generate Bill
                        8. Logout
                    """);
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" ->
                    GunService.showAllGuns();
                case "2" ->
                    GunService.showShortGuns();
                case "3" ->
                    GunService.showAmmolation();
                case "4" ->
                    BookingService.addBooking(customer);
                case "5" ->
                    BookingService.viewBookings(customer);
                case "6" ->
                    BookingService.calculateBill(customer);
                case "7" ->
                    BookingService.generateBill(customer);
                case "8" -> {
                    return;
                }
                default ->
                    System.out.println("Invalid option.");
            }
        }
    }
}
