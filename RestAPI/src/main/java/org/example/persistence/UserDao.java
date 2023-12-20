package org.example.persistence;

import org.example.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends GenericDao<User> {
    public UserDao() {
        super(User.class);
    }
}
