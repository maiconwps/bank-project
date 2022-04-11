package com.br.letscode.databaseproject.shared.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class NotFoundError extends Exception{
    private MessageError messageError;

    public static NotFoundError notExistResourceByIdError(String resource, Integer id ){
        var message = String.format("Não existe %s com id = %d", resource, id);
        return new NotFoundError(new MessageError("id", message));
    }
}
