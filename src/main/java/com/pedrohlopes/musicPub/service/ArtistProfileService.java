package com.pedrohlopes.musicPub.service;

import com.pedrohlopes.musicPub.dto.ArtistProfileDTO;
import com.pedrohlopes.musicPub.model.MusicalStyleEntity;
import com.pedrohlopes.musicPub.model.artist.ArtistProfileEntity;
import com.pedrohlopes.musicPub.model.user.Roles;
import com.pedrohlopes.musicPub.model.user.UserEntity;
import com.pedrohlopes.musicPub.repository.IArtistProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@RequiredArgsConstructor
@Service
public class ArtistProfileService {

    private final IArtistProfileRepository artistProfileRepository;
    private final UserService userService;
    private final MusicalStyleService musicalStyleService;


    public void createArtist(ArtistProfileDTO artistProfileDTO) {

        UserEntity user = userService.registerUser(
                artistProfileDTO.name(),
                artistProfileDTO.email(),
                artistProfileDTO.password(),
                Roles.ARTIST);

        Set<MusicalStyleEntity> styles =
                musicalStyleService.findMusicalStylesById(artistProfileDTO.musicalStylesIds());

        artistProfileRepository.save(ArtistProfileEntity.builder()
                        .artisticName(artistProfileDTO.artisticName())
                        .biography(artistProfileDTO.biography())
                        .city(artistProfileDTO.city())
                        .instagram(artistProfileDTO.instagram())
                        .musicalStyles(styles)
                        .user(user)
                .build());
    }
}
