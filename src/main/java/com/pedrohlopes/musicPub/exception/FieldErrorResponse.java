package com.pedrohlopes.musicPub.exception;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class FieldErrorResponse {

    private String field;
    private String message;
}
