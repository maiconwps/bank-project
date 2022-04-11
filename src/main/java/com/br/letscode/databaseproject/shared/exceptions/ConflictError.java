package com.br.letscode.databaseproject.shared.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ConflictError extends Exception{
    private MessageError messageError;
}
