package org.example.dto.assembler;

import org.example.dto.UserDto;
import org.example.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDtoAssembler implements GenericDtoAssembler<User, UserDto> {


    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDto convertToDto(User user) {

        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());

        return userDto;
    }

    @Override
    public User convertFromDto(UserDto userDto) {

        User user = (userDto.getId() != null ? userService.get(userDto.getId()) : new User());

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());

        return user;
    }
}
