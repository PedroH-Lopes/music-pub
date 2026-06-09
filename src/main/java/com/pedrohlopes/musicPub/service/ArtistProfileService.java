package com.pedrohlopes.musicPub.service;

import com.pedrohlopes.musicPub.dto.artist.ArtistProfileDTO;
import com.pedrohlopes.musicPub.dto.artist.ArtistProfileResponseDTO;
import com.pedrohlopes.musicPub.dto.artist.ArtistProfileUpdateDTO;
import com.pedrohlopes.musicPub.exception.ResourceNotFoundException;
import com.pedrohlopes.musicPub.model.MusicalStyleEntity;
import com.pedrohlopes.musicPub.model.artist.ArtistProfileEntity;
import com.pedrohlopes.musicPub.enums.Roles;
import com.pedrohlopes.musicPub.model.user.UserEntity;
import com.pedrohlopes.musicPub.repository.IArtistProfileRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class ArtistProfileService {

    private final IArtistProfileRepository artistProfileRepository;
    private final UserService userService;
    private final MusicalStyleService musicalStyleService;

    @Transactional
    public void createArtist(ArtistProfileDTO artistProfileDTO) {

        UserEntity user = userService.createUser(
                artistProfileDTO.name(),
                artistProfileDTO.email(),
                artistProfileDTO.password(),
                Roles.ROLE_ARTIST);

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

    public List<ArtistProfileResponseDTO> findAllArtists() {
        return artistProfileRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public ArtistProfileResponseDTO findArtistById(Long id) {
        return toDTO(artistProfileRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Artista não encontrado"))
        );
    }

    @Transactional
    public void updateArtist(Long id, ArtistProfileUpdateDTO artistProfileUpdateDTO) {
        ArtistProfileEntity artist =  artistProfileRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Artista não encontrado"));

        if (artistProfileUpdateDTO.name() != null) {
            UserEntity user = artist.getUser();
            user.setName(artistProfileUpdateDTO.name());
        }

        if (artistProfileUpdateDTO.artisticName() != null) {
            artist.setArtisticName(artistProfileUpdateDTO.artisticName());
        }

        if (artistProfileUpdateDTO.biography() != null) {
            artist.setBiography(artistProfileUpdateDTO.biography());
        }

        if (artistProfileUpdateDTO.city() != null) {
            artist.setCity(artistProfileUpdateDTO.city());
        }

        if (artistProfileUpdateDTO.instagram() != null) {
            artist.setInstagram(artistProfileUpdateDTO.instagram());
        }

        if (artistProfileUpdateDTO.musicalStylesIds() != null) {
            Set<MusicalStyleEntity> styles = musicalStyleService.findMusicalStylesById(artistProfileUpdateDTO.musicalStylesIds());
            artist.setMusicalStyles(styles);
        }
    }

    @Transactional
    public void deleteArtistById(Long id) {
        ArtistProfileEntity artistProfileEntity = artistProfileRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Artista não encontrado"));


        userService.deleteUser(artistProfileEntity);
    }

    private ArtistProfileResponseDTO toDTO(ArtistProfileEntity artistProfileEntity) {
        return new ArtistProfileResponseDTO(
                artistProfileEntity.getUser().getName(),
                artistProfileEntity.getUser().getEmail(),

                artistProfileEntity.getArtisticName(),
                artistProfileEntity.getBiography(),
                artistProfileEntity.getCity(),
                artistProfileEntity.getInstagram(),

                artistProfileEntity.getMusicalStyles()
                        .stream()
                        .map(MusicalStyleEntity::getName)
                        .toList()
        );
    }
}
