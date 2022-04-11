package com.br.letscode.databaseproject.user.dto.response;
import com.br.letscode.databaseproject.user.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UserCreateResponse {
    private Integer id;
    private String cpf;
    private String name;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;

    public static UserCreateResponse of (User user){
        var userCreateResponse = new UserCreateResponse();
        BeanUtils.copyProperties(user, userCreateResponse);
        return userCreateResponse;
    }
}
