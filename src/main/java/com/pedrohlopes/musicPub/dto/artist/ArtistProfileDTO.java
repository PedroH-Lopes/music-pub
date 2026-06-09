package com.pedrohlopes.musicPub.dto.artist;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record ArtistProfileDTO(

        @NotBlank(message = "Campo nome não preenchido")
        String name,

        @Email(message = "Email inválido")
        @NotBlank(message = "Campo email não preenchido")
        String email,

        @NotBlank(message = "Campo senha não preenchida")
        String password,

        @NotBlank(message = "Campo nome artístico não preenchido")
        String artisticName,

        String biography,

        @NotBlank(message = "Campo cidade não preenchido")
        String city,

        String socialMedia,

        @NotNull(message = "Selecione ao menos 1 estilo de musica")
        Set<Long> musicalStylesIds
) {}
