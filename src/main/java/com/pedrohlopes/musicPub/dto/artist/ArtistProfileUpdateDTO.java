package com.pedrohlopes.musicPub.dto.artist;

import java.util.Set;

public record ArtistProfileUpdateDTO(
        String name,

        String artisticName,

        String biography,

        String city,

        String instagram,

        Set<Long> musicalStylesIds
) {}
