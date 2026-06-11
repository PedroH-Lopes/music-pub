package com.pedrohlopes.musicPub.config.security;

import com.pedrohlopes.musicPub.model.user.UserEntity;
import com.pedrohlopes.musicPub.repository.IArtistProfileRepository;
import com.pedrohlopes.musicPub.repository.IEstablishmentProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component("profileSecurity")
@RequiredArgsConstructor
public class ProfileSecurity {

    private final IArtistProfileRepository artistProfileRepository;
    private final IEstablishmentProfileRepository establishmentProfileRepository;

    public boolean isArtistOwner(Long artistId,
                                 Authentication authentication) {

        UserEntity user =
                (UserEntity) authentication.getPrincipal();

        return artistProfileRepository.findById(artistId)
                .map(artist -> artist.getUser().getId() == user.getId())
                .orElse(false);
    }

    public boolean isEstablishmentOwner(Long establishmentId,
                                        Authentication authentication) {

        UserEntity user =
                (UserEntity) authentication.getPrincipal();

        return establishmentProfileRepository.findById(establishmentId)
                .map(establishment ->
                        establishment.getUser().getId() == user.getId())
                .orElse(false);
    }
}