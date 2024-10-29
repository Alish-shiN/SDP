package MVP.Part1;

public class Main {
    public static void main(String[] args) {
        // Initialize DataModel, ConsoleView, and DataPresenter
        DataModel model = new DataModel("Initial Data");
        ConsoleView view = new ConsoleView();
        DataPresenter presenter = new DataPresenter(model, view);

        // Perform operations through the Presenter
        presenter.updateData();
        presenter.performMoreOperations();
    }
}
