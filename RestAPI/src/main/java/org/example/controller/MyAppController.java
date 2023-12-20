package org.example.controller;

import org.example.dto.UserDto;
import org.example.dto.assembler.UserDtoAssembler;
import org.example.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class MyAppController {

    private UserService userService;

    private UserDtoAssembler userDtoAssembler;

    @Autowired
    public void setUserDtoAssembler(UserDtoAssembler userDtoAssembler) {
        this.userDtoAssembler = userDtoAssembler;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserDto> getUser(@PathVariable Integer id){
        User user = userService.get(id);

        return new ResponseEntity<>(userDtoAssembler.convertToDto(user), HttpStatus.OK);
    }

    @RequestMapping(value = "/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<UserDto>> getUsers(){

        List<User> users = userService.list();

        return new ResponseEntity<>(userDtoAssembler.convertToDto(users), HttpStatus.OK);
    }

    @RequestMapping(value = "/",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserDto> addUser(@Valid @RequestBody UserDto userDto, BindingResult bindingResult){

        if (bindingResult.hasErrors() || userDto.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        User user = userDtoAssembler.convertFromDto(userDto);
        User savedUser = userService.save(user);

        return new ResponseEntity<>(userDtoAssembler.convertToDto(savedUser),HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserDto> editUser(@PathVariable Integer id, @Valid @RequestBody UserDto userDto, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (userDto.getId() != null && !userDto.getId().equals(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (userService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        User user = userDtoAssembler.convertFromDto(userDto);

        user.setId(id);
        User savedUser =  userService.save(user);

        return new ResponseEntity<>(userDtoAssembler.convertToDto(savedUser), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<User> deleteUser(@PathVariable Integer id){
        userService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
