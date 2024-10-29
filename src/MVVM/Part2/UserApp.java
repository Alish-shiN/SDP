package MVVM.Part2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserApp {
    private List<String> users;

    public UserApp() {
        users = new ArrayList<>();
    }

    public static void main(String[] args) {
        UserApp app = new UserApp();
        app.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add user");
            System.out.println("2. Display users");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter user name: ");
                    String name = scanner.nextLine();
                    addUser(name);
                    System.out.println("User added!");
                    break;
                case 2:
                    displayUsers();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private void addUser(String name) {
        users.add(name);
    }

    private void displayUsers() {
        System.out.println("User List:");
        for (String user : users) {
            System.out.println("- " + user);
        }
    }
}