package MVVM.Part2;

import java.util.ArrayList;
import java.util.List;

public class UserViewModel {
    private final List<UserModel> users = new ArrayList<>();


    public void addUser(String name) {
        users.add(new UserModel(name));
    }

    public List<String> getUserNames() {
        List<String> names = new ArrayList<>();
        for (UserModel user : users) {
            names.add(user.getName());
        }
        return names;
    }
}
