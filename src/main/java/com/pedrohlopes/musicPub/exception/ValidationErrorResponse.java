package com.pedrohlopes.musicPub.exception;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ValidationErrorResponse {

    private Integer status;
    private String message;
    private List<FieldErrorResponse> errors;
}
