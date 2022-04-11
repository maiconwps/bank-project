package com.br.letscode.databaseproject.user.controller;

import com.br.letscode.databaseproject.shared.exceptions.ConflictError;
import com.br.letscode.databaseproject.shared.exceptions.NotFoundError;
import com.br.letscode.databaseproject.user.dto.request.UserCreateRequest;
import com.br.letscode.databaseproject.user.dto.request.UserUpdateRequest;
import com.br.letscode.databaseproject.user.dto.response.UserCreateResponse;
import com.br.letscode.databaseproject.user.dto.response.UserUpdateResponse;
import com.br.letscode.databaseproject.user.model.User;
import com.br.letscode.databaseproject.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

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

    @GetMapping("/{userId}")
    public User findUserById(@PathVariable Integer userId) throws NotFoundError {
        return userService.findUserById(userId);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public UserCreateResponse createUser(@RequestBody @Valid UserCreateRequest userCreateRequest) throws ConflictError {
        return userService.createUser(userCreateRequest);
    }

    @PutMapping("/{userId}")
    public UserUpdateResponse updateUser(@RequestBody @Valid UserUpdateRequest userUpdateRequest,
                                         @PathVariable Integer userId) throws ConflictError, NotFoundError {
        return userService.updateUser(userUpdateRequest, userId);
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Integer userId) throws NotFoundError {
        userService.deleteUser(userId);
    }
}
