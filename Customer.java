
public class Customer {

    private String username;
    private String password;

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String toFileString() {
        return username + "," + password;
    }

    public static Customer fromString(String line) {
        String[] parts = line.split(",");
        return new Customer(parts[0], parts[1]);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
