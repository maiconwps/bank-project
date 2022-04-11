package com.br.letscode.databaseproject.user.dto.request;

import com.br.letscode.databaseproject.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
public class UserCreateRequest {
    private String cpf;
    private String name;
    private String email;
    private String password;

    public User toUser(){
        var user = new User();
        BeanUtils.copyProperties(this, user);
        return user;
    }
}
