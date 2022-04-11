package com.br.letscode.databaseproject.user.controller;

import com.br.letscode.databaseproject.user.dto.request.UserCreateRequest;
import com.br.letscode.databaseproject.user.dto.response.UserCreateResponse;
import com.br.letscode.databaseproject.user.model.User;
import com.br.letscode.databaseproject.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public Page<User> findAllUsers(@RequestParam(required = false) String name,
                                     @RequestParam(required = false, defaultValue = "0") int page,
                                     @RequestParam(required = false, defaultValue = "3") int size){
        return userService.listAllUsers(name, page, size);
    }

    @PostMapping()
    public UserCreateResponse createUser(@RequestBody UserCreateRequest userCreateRequest){
        return userService.createUser(userCreateRequest);
    }

}
