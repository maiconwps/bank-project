package com.br.letscode.databaseproject.user.service;

import com.br.letscode.databaseproject.shared.exceptions.ConflictError;
import com.br.letscode.databaseproject.shared.exceptions.MessageError;
import com.br.letscode.databaseproject.user.dto.request.UserCreateRequest;
import com.br.letscode.databaseproject.user.dto.response.UserCreateResponse;
import com.br.letscode.databaseproject.user.model.User;
import com.br.letscode.databaseproject.user.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Page<User> listAllUsers(String name, int page, int size){
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.DESC, "name");
        return userRepository.findAll(pageRequest);
    }

    public UserCreateResponse createUser(UserCreateRequest userCreateRequest) throws ConflictError {
        if(userRepository.existUserWithEmail(userCreateRequest.getEmail())){
            throw new ConflictError(new MessageError("email", "email já cadastrado"));
        }

        if(userRepository.existUserWithCpf(userCreateRequest.getCpf())){
            throw new ConflictError(new MessageError("cpf", "cpf já cadastrado"));
        }

        var user = userCreateRequest.toUser();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        var userFull = userRepository.save(userCreateRequest.toUser());
        return UserCreateResponse.of(userFull);
    }
}
