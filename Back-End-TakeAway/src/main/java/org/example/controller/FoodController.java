package org.example.controller;

import org.example.dto.FoodDto;
import org.example.dto.assembler.FoodDtoAssembler;
import org.example.model.Food;
import org.example.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/food")
public class FoodController {

    private FoodService foodService;

    private FoodDtoAssembler dtoAssembler;

    @Autowired
    public void setDtoAssembler(FoodDtoAssembler dtoAssembler) {
        this.dtoAssembler = dtoAssembler;
    }

    @Autowired
    public void setFoodService(FoodService foodService) {
        this.foodService = foodService;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<FoodDto>>getFoods(){
        return new ResponseEntity<>(dtoAssembler.convertToDto( foodService.list() ), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<FoodDto> createFood(@Valid @RequestBody FoodDto foodDto){
        Food food = dtoAssembler.convertFromDto(foodDto);
        Food savedFood = foodService.save(food);

        return new ResponseEntity<>(dtoAssembler.convertToDto(savedFood), HttpStatus.OK);
    }
}
