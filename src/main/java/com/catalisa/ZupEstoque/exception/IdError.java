package com.catalisa.ZupEstoque.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

@Data
@RequiredArgsConstructor
public class IdError {
    private final HttpStatus httpStatus;
    private final String mensage;
}
