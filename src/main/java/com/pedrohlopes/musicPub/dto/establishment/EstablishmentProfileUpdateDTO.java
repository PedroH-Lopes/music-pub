package com.pedrohlopes.musicPub.dto.establishment;

public record EstablishmentProfileUpdateDTO(

        String name,

        String fantasyName,

        String description,

        String address,

        String city,

        String contactPhone,

        String socialMedia
) {}
