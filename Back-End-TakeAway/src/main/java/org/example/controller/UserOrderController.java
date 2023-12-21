package org.example.controller;

import org.example.model.Food;
import org.example.model.FoodList;
import org.example.model.UserOrder;
import org.example.service.FoodService;
import org.example.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class UserOrderController {

    private UserOrderService userOrderService;

    private FoodService foodService;

    private FoodList foodList;

    @Autowired
    public void setUserOrderService(UserOrderService userOrderService) {
        this.userOrderService = userOrderService;
    }

    @Autowired
    public void setFoodService(FoodService foodService) {
        this.foodService = foodService;
    }

    @Autowired
    public void setFoodList(FoodList foodList) {
        this.foodList = foodList;
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserOrder> getOrder(@PathVariable Integer id){
        UserOrder user = userOrderService.get(id);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<UserOrder>> getUsers(){
        List<UserOrder> users = userOrderService.list();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> addOrder(@RequestBody UserOrder user, BindingResult bindingResult){

        if (bindingResult.hasErrors() || user.getEmail() == null ){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        for(Food food : user.getFoods()){
            if( !foodList.getFoodMap().containsKey( food.getName())){
                return new ResponseEntity<>("This product name is not allowed",HttpStatus.BAD_REQUEST);
            }
        }


        UserOrder userOrder = userOrderService.save(user, user.getFoods());

        return new ResponseEntity<>(userOrder,HttpStatus.CREATED);
    }
}
