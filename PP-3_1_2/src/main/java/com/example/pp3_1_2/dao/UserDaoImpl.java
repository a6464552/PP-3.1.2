package com.example.pp3_1_2.dao;

import com.example.pp3_1_2.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;




import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(long id){
        entityManager.remove(findUserById(id));
    }

    @Override
    public User findUserById(long id){
        return entityManager.find(User.class, id);
    }

    @Override
    public User change(User user) {
        return entityManager.merge(user);
    }

    @Override
    public List<User> listUsers () {
        return entityManager.createQuery("from User", User.class).getResultList();


    }
}
