package org.example.persistence;

import org.example.model.UserOrder;
import org.springframework.stereotype.Repository;

@Repository
public class UserOrderDao extends GenericDao<UserOrder> {
    public UserOrderDao() {
        super(UserOrder.class);
    }
}
