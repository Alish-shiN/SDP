package MVVM.Part2;

import java.util.List;
import java.util.Scanner;

public class UserView {
    private final Scanner scanner = new Scanner(System.in);

    public int showMenu() {
        System.out.println("1. Add user");
        System.out.println("2. Display users");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
        return scanner.nextInt();
    }

    public String getUserInput() {
        scanner.nextLine(); // Consume newline
        System.out.print("Enter user name: ");
        return scanner.nextLine();
    }

    public void displayUsers(List<String> users) {
        System.out.println("User List:");
        for (String user : users) {
            System.out.println("- " + user);
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void closeScanner() {
        scanner.close();
    }
}
