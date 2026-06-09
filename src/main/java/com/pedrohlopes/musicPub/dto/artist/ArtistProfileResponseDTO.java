package com.pedrohlopes.musicPub.dto.artist;

import java.util.List;

public record ArtistProfileResponseDTO(

        String name,

        String email,

        String artistName,

        String biography,

        String city,

        String socialMedia,

        List<String> musicalStyles
) {}
