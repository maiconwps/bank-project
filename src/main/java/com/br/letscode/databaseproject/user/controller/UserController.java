package com.br.letscode.databaseproject.user.controller;

import com.br.letscode.databaseproject.user.model.User;
import com.br.letscode.databaseproject.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public Page<User> findAllUsers(@RequestParam(required = false) String name,
                                     @RequestParam(required = false, defaultValue = "0") int page,
                                     @RequestParam(required = false, defaultValue = "3") int size){
        return userService.listAllUsers(name, page, size);
    }

}
