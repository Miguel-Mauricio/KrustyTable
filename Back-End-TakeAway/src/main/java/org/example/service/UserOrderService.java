package org.example.service;

import org.example.model.Food;
import org.example.model.UserOrder;
import org.example.persistence.FoodDao;
import org.example.persistence.UserOrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserOrderService {

    private UserOrderDao userOrderDao;

    private FoodDao foodDao;

    @Autowired
    public void setUserOrderDao(UserOrderDao userOrderDao) {
        this.userOrderDao = userOrderDao;
    }

    @Autowired
    public void setOrderDao(UserOrderDao orderDao) {
        this.userOrderDao = orderDao;
    }

    @Autowired
    public void setFoodDao(FoodDao foodDao) {
        this.foodDao = foodDao;
    }

    public UserOrder get(Integer id) {
        return userOrderDao.findById(id);
    }

    @Transactional
    public UserOrder save(UserOrder order) {
        Food food = foodDao.findById( order.getFood().getId() );
        foodDao.saveOrUpdate( food );
        return userOrderDao.saveOrUpdate(order);
    }

    @Transactional
    public void delete(Integer id) {
        UserOrder customer = Optional.ofNullable(userOrderDao.findById(id))
                .orElseThrow(NoSuchFieldError::new);

        userOrderDao.delete(id);
    }

    public List<UserOrder> list() {
        return userOrderDao.findAll();
    }
}
