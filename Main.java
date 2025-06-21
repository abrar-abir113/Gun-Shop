
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Gun Shop Management System");
        AuthService authService = new AuthService();
        authService.showLoginMenu();
    }
}
