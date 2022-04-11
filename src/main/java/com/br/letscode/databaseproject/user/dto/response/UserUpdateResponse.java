package com.br.letscode.databaseproject.user.dto.response;

import com.br.letscode.databaseproject.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UserUpdateResponse {
    private Integer id;
    private String cpf;
    private String name;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;

    public static UserUpdateResponse of (User user){
        var userUpdateResponse = new UserUpdateResponse();
        BeanUtils.copyProperties(user, userUpdateResponse);
        return userUpdateResponse;
    }
}
