package org.example.dto.assembler;

import org.example.dto.OrderDto;
import org.example.model.UserOrder;
import org.springframework.stereotype.Component;

@Component
public class OrderDtoAssembler implements GenericDtoAssembler<UserOrder, OrderDto> {


    @Override
    public OrderDto convertToDto(UserOrder modelObj) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId( modelObj.getId() );
        orderDto.setEmail( modelObj.getEmail() );
        orderDto.setFirstName(modelObj.getFirstName());
        orderDto.setLastName(modelObj.getLastName());
        orderDto.setPhone(modelObj.getPhone());
        orderDto.setStatus(modelObj.getStatus());
        orderDto.setFood( modelObj.getFood() );
        return orderDto;
    }

    @Override
    public UserOrder convertFromDto(OrderDto modelObj) {
        UserOrder orderDto = new UserOrder();
        orderDto.setId( modelObj.getId() );
        orderDto.setEmail( modelObj.getEmail() );
        orderDto.setFirstName(modelObj.getFirstName());
        orderDto.setLastName(modelObj.getLastName());
        orderDto.setPhone(modelObj.getPhone());
        orderDto.setStatus(modelObj.getStatus());
        orderDto.setFood(modelObj.getFood());
        return orderDto;
    }
}
