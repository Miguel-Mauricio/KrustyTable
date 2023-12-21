package org.example.persistence;

import org.example.model.Food;
import org.springframework.stereotype.Repository;

@Repository
public class FoodDao extends GenericDao<Food> {


    public FoodDao() {
        super(Food.class);
    }
}
