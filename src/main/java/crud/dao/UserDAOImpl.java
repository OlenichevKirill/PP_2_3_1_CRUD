package crud.dao;

import crud.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUser(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void removeUserById(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager
                .createQuery("select u from User u", User.class)
                .getResultList();
    }
}
