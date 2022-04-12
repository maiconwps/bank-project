package com.br.letscode.databaseproject.shared.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SemanticError extends Exception{
    private MessageError messageError;

    public SemanticError(String field, String message) {
        this.messageError = new MessageError(field, message);
    }
}
