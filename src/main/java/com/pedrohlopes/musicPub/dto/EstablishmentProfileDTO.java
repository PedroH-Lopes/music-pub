package com.pedrohlopes.musicPub.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record EstablishmentProfileDTO(

        @NotBlank(message = "Campo nome não preenchido")
        String name,

        @Email(message = "Email inválido")
        @NotBlank(message = "Campo email não preenchido")
        String email,

        @NotBlank(message = "Campo senha não preenchido")
        String password,

        @NotBlank(message = "Campo nome fantasia não preenchido")
        String fantasyName,

        @NotBlank(message = "Campo descrição não preenchido")
        String description,

        @NotBlank(message = "Campo endereço não preenchido")
        String address,

        @NotBlank(message = "Campo cidade não preenchido")
        String city,

        @NotBlank(message = "Campo telefone não preenchido")
        String contactPhone
) {}
