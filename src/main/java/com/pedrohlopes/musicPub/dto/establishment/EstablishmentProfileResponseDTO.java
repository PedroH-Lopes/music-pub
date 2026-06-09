package com.pedrohlopes.musicPub.dto.establishment;

import java.util.List;

public record EstablishmentProfileResponseDTO(

        String name,

        String email,

        String fantasyName,

        String description,

        String address,

        String city,

        String contactPhone,

        String socialMedia
) {}
