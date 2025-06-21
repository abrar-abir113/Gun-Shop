public class Booking {

    private String username;
    String item;
    private double price;
    private String Item;

    public Booking(String username, String item, double price) {
        this.username = username;
        this.item = item;
        this.price = price;
    }

    public static Booking fromString(String line) {
        String[] parts = line.split(",");
        return new Booking(parts[0], parts[1], Double.parseDouble(parts[2]));
    }

    public String toFileString() {
        return username + "," + item + "," + price;
    }

    public String getUsername() {
        return username;
    }

    public double getPrice() {
        return price;
    }

    public String getItem() {
        return Item;
    }
}
