package com.pedrohlopes.musicPub.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginProfileDTO(

        @Email(message = "Email inválido")
        @NotBlank(message = "Campo email não preenchido")
        String email,

        @NotBlank(message = "Campo senha não preenchido")
        String password
) {}
