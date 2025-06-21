
import java.io.*;
import java.util.*;

public class GunService {

    private static final String GUN_FILE = "S:\\GitHub\\Gunshop\\deta\\guns.txt";

    public static List<Gun> loadGuns() {
        List<Gun> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(GUN_FILE))) {
            while (scanner.hasNextLine()) {
                list.add(Gun.fromString(scanner.nextLine()));
            }
        } catch (IOException e) {
            System.out.println("Error reading gun file.");
        }
        return list;
    }

    public static void showAllGuns() {
        for (Gun gun : loadGuns()) {
            System.out.printf("%s (%s): $%.2f\n", gun.getName(), gun.getType(), gun.getPrice());
        }
    }

    public static void showShortGuns() {
        for (Gun gun : loadGuns()) {
            if (gun.getType().equalsIgnoreCase("short")) {
                System.out.printf("%s (%s): $%.2f\n", gun.getName(), gun.getType(), gun.getPrice());
            }
        }
    }

    public static void showAmmolation() {
        try (Scanner sc = new Scanner(new File("S:\\GitHub\\Gunshop\\deta\\ammo.txt"))) {
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Error reading ammo file.");
        }
    }

    public static List<String> loadAmmo() {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new FileReader("S:\\GitHub\\Gunshop\\deta\\ammo.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line.trim());
            }
        } catch (IOException e) {
            System.out.println("Error loading ammo.");
        }

        return list;
    }
}
