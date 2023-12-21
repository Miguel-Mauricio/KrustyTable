package org.example.dto.assembler;

import org.example.dto.FoodDto;
import org.example.model.Food;
import org.springframework.stereotype.Component;

@Component
public class FoodDtoAssembler implements GenericDtoAssembler<Food, FoodDto> {
    @Override
    public FoodDto convertToDto(Food modelObj) {
        FoodDto food = new FoodDto();
        food.setName( modelObj.getName() );
        food.setPrice( modelObj.getPrice() );
        food.setUserOrder(modelObj.getUserOrder() );
        food.setId(modelObj.getId() );
        return food;
    }

    @Override
    public Food convertFromDto(FoodDto modelObj) {
        Food food = new Food();
        food.setName( modelObj.getName() );
        food.setPrice( modelObj.getPrice() );
        food.setUserOrder(modelObj.getUserOrder() );
        food.setId(modelObj.getId() );
        return food;
    }
}
