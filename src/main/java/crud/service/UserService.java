package crud.service;

import crud.model.User;

import java.util.List;

public interface UserService {
    User getUser(long id);

    void saveUser(User user);

    void removeUserById(long id);

    void updateUser(User user);

    List<User> getAllUsers();
}
