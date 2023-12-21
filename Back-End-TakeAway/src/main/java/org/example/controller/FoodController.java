package org.example.controller;

import org.example.model.Food;
import org.example.model.FoodList;
import org.example.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/food")
public class FoodController {

    private FoodService foodService;

    private FoodList foodList;

    @Autowired
    public void setFoodList(FoodList foodList) {
        this.foodList = foodList;
    }

    @Autowired
    public void setFoodService(FoodService foodService) {
        this.foodService = foodService;
    }

    @RequestMapping(value = "/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Map<String, Double>>getFoods(){
        return new ResponseEntity<>(foodList.getFoodMap(), HttpStatus.OK);
    }


    @RequestMapping(value = "/add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Food> createFood(@RequestBody Food food){
        Food savedFood = foodService.save(food);

        return new ResponseEntity<>(savedFood, HttpStatus.OK);
    }
}
