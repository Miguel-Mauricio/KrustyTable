package org.example.service;

import org.example.model.Food;
import org.example.persistence.FoodDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    private FoodDao foodDao;

    @Autowired
    public void setFoodDao(FoodDao foodDao) {
        this.foodDao = foodDao;
    }

    @Transactional
    public Food get(Integer id) {
        return foodDao.findById(id);
    }

    @Transactional
    public Food save(Food food) {
        return foodDao.saveOrUpdate(food);
    }

    @Transactional
    public void delete(Integer id) {
        Food customer = Optional.ofNullable(foodDao.findById(id))
                .orElseThrow(NoSuchFieldError::new);

        foodDao.delete(id);
    }

    @Transactional
    public List<Food> list() {
        return foodDao.findAll();
    }

}
