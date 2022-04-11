package com.br.letscode.databaseproject.shared.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MessageError {
    private String field;
    private String message;
}
