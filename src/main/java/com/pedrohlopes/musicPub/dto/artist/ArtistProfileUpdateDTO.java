package com.pedrohlopes.musicPub.dto.artist;

import java.util.Set;

public record ArtistProfileUpdateDTO(
        String name,

        String artisticName,

        String biography,

        String city,

        String socialMedia,

        Set<Long> musicalStylesIds
) {}
