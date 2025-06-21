
public class Gun {

    private String name;
    private String type;
    private double price;

    public Gun(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public static Gun fromString(String line) {
        String[] parts = line.split(",");
        return new Gun(parts[0], parts[1], Double.parseDouble(parts[2]));
    }

    public String toFileString() {
        return name + "," + type + "," + price;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
}
