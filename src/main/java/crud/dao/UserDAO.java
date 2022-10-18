package crud.dao;

import crud.model.User;

import java.util.List;

public interface UserDAO {

    User getUser(long id);

    void saveUser(User user);

    void removeUserById(long id);

    void updateUser(User user);
    List<User> getAllUsers();
}
