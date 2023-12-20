package org.example.service;

import org.example.model.User;
import org.example.persistence.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public User get(Integer id) {
        return userDao.findById(id);
    }

    @Transactional
    public User save(User customer) {
        return userDao.saveOrUpdate(customer);
    }

    @Transactional
    public void delete(Integer id) {
        User customer = Optional.ofNullable(userDao.findById(id))
                .orElseThrow(NoSuchFieldError::new);

        userDao.delete(id);
    }

    public List<User> list() {
        return userDao.findAll();
    }

}
