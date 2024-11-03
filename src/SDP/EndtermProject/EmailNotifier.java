package SDP.EndtermProject;

import java.util.ArrayList;
import java.util.List;

public class EmailNotifier implements Observer {
    private List<String> observers = new ArrayList<>();

    public void addObserver(String email) {
        observers.add(email);
    }

    @Override
    public void update(String taskTitle) {
        for (String observer : observers) {
            System.out.println("Sending email to " + observer + ": Task '" + taskTitle + "' is due soon!");
        }
    }
}


