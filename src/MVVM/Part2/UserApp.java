package MVVM.Part2;


public class UserApp {
    private final UserView view;
    private final UserViewModel viewModel;

    public UserApp() {
        this.view = new UserView();
        this.viewModel = new UserViewModel();
    }

    public static void main(String[] args) {
        UserApp app = new UserApp();
        app.run();
    }

    public void run() {
        while (true) {
            int option = view.showMenu();

            switch (option) {
                case 1:
                    String name = view.getUserInput();
                    viewModel.addUser(name);
                    view.showMessage("User added!");
                    break;
                case 2:
                    view.displayUsers(viewModel.getUserNames());
                    break;
                case 3:
                    view.showMessage("Exiting...");
                    view.closeScanner();
                    return;
                default:
                    view.showMessage("Invalid option. Please try again.");
            }
        }
    }
}
