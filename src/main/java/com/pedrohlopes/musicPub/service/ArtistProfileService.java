package com.pedrohlopes.musicPub.service;

import com.pedrohlopes.musicPub.dto.ArtistProfileDTO;
import com.pedrohlopes.musicPub.model.artist.ArtistProfileEntity;
import com.pedrohlopes.musicPub.model.user.Roles;
import com.pedrohlopes.musicPub.model.user.UserEntity;
import com.pedrohlopes.musicPub.repository.IArtistProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ArtistProfileService {

    private final IArtistProfileRepository artistProfileRepository;
    private final UserService userService;


    public void createArtist(ArtistProfileDTO artistProfileDTO) {

        UserEntity user = userService.registerUser(
                artistProfileDTO.name(),
                artistProfileDTO.email(),
                artistProfileDTO.password(),
                Roles.ARTIST);

        artistProfileRepository.save(ArtistProfileEntity.builder()
                        .artisticName(artistProfileDTO.artisticName())
                        .biography(artistProfileDTO.biography())
                        .city(artistProfileDTO.city())
                        .instagram(artistProfileDTO.instagram())
                        .user(user)
                .build());
    }
}
