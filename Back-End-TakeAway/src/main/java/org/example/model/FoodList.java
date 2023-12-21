package org.example.model;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import java.util.HashMap;
import java.util.Map;

@Component
public class FoodList {
    private Map<String, Double> foodMap = new HashMap<>();


    public FoodList(){
        foodMap.put("Triple Krusty Chesse", 14.0);
        foodMap.put("Double Krusty Chesse", 8.0);
        foodMap.put("Single Krusty Chesse", 5.0);
        foodMap.put("Krusty Bacon", 6.0);
        foodMap.put("Krusty Royal", 10.0);
    }

    public Map<String, Double> getFoodMap() {
        return foodMap;
    }

    public void setFoodMap(Map<String, Double> foodMap) {
        this.foodMap = foodMap;
    }
}
