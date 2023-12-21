package org.example.controller;

import org.example.dto.OrderDto;
import org.example.dto.assembler.OrderDtoAssembler;
import org.example.model.Food;
import org.example.model.UserOrder;
import org.example.service.FoodService;
import org.example.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class UserOrderController {

    private UserOrderService userOrderService;

    private FoodService foodService;

    private OrderDtoAssembler orderDtoAssembler;

    @Autowired
    public void setUserOrderService(UserOrderService userOrderService) {
        this.userOrderService = userOrderService;
    }

    @Autowired
    public void setFoodService(FoodService foodService) {
        this.foodService = foodService;
    }

    @Autowired
    public void setOrderDtoAssembler(OrderDtoAssembler orderDtoAssembler) {
        this.orderDtoAssembler = orderDtoAssembler;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserOrder> getOrder(@PathVariable Integer id){
        UserOrder user = userOrderService.get(id);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<UserOrder>> getUsers(){
        List<UserOrder> users = userOrderService.list();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> addOrder(@Valid @RequestBody OrderDto orderDto, BindingResult bindingResult){

        if (bindingResult.hasErrors() || orderDto.getEmail() == null ){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if ( !foodService.setList().contains( orderDto.getFood().getId() ) ){
            return new ResponseEntity<>("No product found with this id",HttpStatus.BAD_REQUEST);
        }

        UserOrder userOrder = orderDtoAssembler.convertFromDto(orderDto);
        UserOrder savedOrder = userOrderService.save(userOrder);

        return new ResponseEntity<>(savedOrder,HttpStatus.CREATED);
    }
}
