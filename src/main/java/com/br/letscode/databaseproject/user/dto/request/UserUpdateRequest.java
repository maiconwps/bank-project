package com.br.letscode.databaseproject.user.dto.request;

import com.br.letscode.databaseproject.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
public class UserUpdateRequest {
    @NotNull
    @NotEmpty
    @Size(min = 11, max = 11, message = "O cpf deve ser composto de 11 digítos." )
    @Pattern(regexp = "^[0-9]+$", message = "O cpf deve ser composto apenas de digítos.")
    private String cpf;

    @NotNull @NotEmpty @Size(min=5, max=255)
    private String name;

    @NotNull @NotEmpty @Email
    private String email;

    public User toUser(){
        var user = new User();
        BeanUtils.copyProperties(this, user);
        return user;
    }
}
