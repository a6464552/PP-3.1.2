package com.example.pp3_1_2.service;

import com.example.pp3_1_2.dao.UserDao;
import com.example.pp3_1_2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void add (User user) {
        userDao.add(user);
    }

    @Transactional
    @Override
    public void delete (long id) {
        userDao.delete(id);
    }

    @Transactional
    @Override
    public User change (User user) {
        return userDao.change(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers () {
        return userDao.listUsers();
    }

    @Transactional(readOnly = true)
    @Override
    public User findUserById (long id) {
        return userDao.findUserById(id);
    }
}
