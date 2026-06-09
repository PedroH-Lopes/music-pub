package com.pedrohlopes.musicPub.service;

import com.pedrohlopes.musicPub.dto.artist.ArtistProfileResponseDTO;
import com.pedrohlopes.musicPub.dto.establishment.EstablishmentProfileDTO;
import com.pedrohlopes.musicPub.dto.establishment.EstablishmentProfileResponseDTO;
import com.pedrohlopes.musicPub.dto.establishment.EstablishmentProfileUpdateDTO;
import com.pedrohlopes.musicPub.exception.ResourceNotFoundException;
import com.pedrohlopes.musicPub.model.MusicalStyleEntity;
import com.pedrohlopes.musicPub.model.artist.ArtistProfileEntity;
import com.pedrohlopes.musicPub.model.establishment.EstablishmentProfileEntity;
import com.pedrohlopes.musicPub.enums.Roles;
import com.pedrohlopes.musicPub.model.user.UserEntity;
import com.pedrohlopes.musicPub.repository.IArtistProfileRepository;
import com.pedrohlopes.musicPub.repository.IEstablishmentProfileRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EstablishmentProfileService {

    private final IEstablishmentProfileRepository establishmentProfileRepository;
    private final UserService userService;

    @Transactional
    public void createEstablishmentProfile(EstablishmentProfileDTO establishmentProfileDTO) {

        UserEntity user = userService.createUser(
                establishmentProfileDTO.name(),
                establishmentProfileDTO.email(),
                establishmentProfileDTO.password(),
                Roles.ROLE_ESTABLISHMENT);

        establishmentProfileRepository.save(EstablishmentProfileEntity.builder()
                        .fantasyName(establishmentProfileDTO.fantasyName())
                        .description(establishmentProfileDTO.description())
                        .address(establishmentProfileDTO.address())
                        .city(establishmentProfileDTO.city())
                        .contactPhone(establishmentProfileDTO.contactPhone())
                        .socialMedia(establishmentProfileDTO.socialMedia())
                        .user(user)
                .build());
    }

    public List<EstablishmentProfileResponseDTO> findAllEstablishments() {
        return establishmentProfileRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public EstablishmentProfileResponseDTO findEstablishmentProfileById(Long id) {
        return toDTO(establishmentProfileRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Estabelecimento não encontrado"))
        );
    }

    @Transactional
    public void updateEstablishmentById(Long id, EstablishmentProfileUpdateDTO establishmentProfileUpdateDTO) {
        EstablishmentProfileEntity establishment = establishmentProfileRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Estabelecimento não encontrado"));

        UserEntity user = establishment.getUser();

        if (establishmentProfileUpdateDTO.name() != null) {
            user.setName(establishmentProfileUpdateDTO.name());
        }

        if (establishmentProfileUpdateDTO.fantasyName() != null) {
            establishment.setFantasyName(establishmentProfileUpdateDTO.fantasyName());
        }

        if (establishmentProfileUpdateDTO.description() != null) {
            establishment.setDescription(establishmentProfileUpdateDTO.description());
        }

        if (establishmentProfileUpdateDTO.city() != null) {
            establishment.setCity(establishmentProfileUpdateDTO.city());
        }

        if (establishmentProfileUpdateDTO.address() != null) {
            establishment.setAddress(establishmentProfileUpdateDTO.address());
        }

        if (establishmentProfileUpdateDTO.contactPhone() != null) {
            establishment.setContactPhone(establishmentProfileUpdateDTO.contactPhone());
        }

        if (establishmentProfileUpdateDTO.socialMedia() != null) {
            establishment.setSocialMedia(establishmentProfileUpdateDTO.socialMedia());
        }
    }

    public void deleteEstablishmentById(Long id) {
        EstablishmentProfileEntity establishment = establishmentProfileRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Estabelecimento não encontrado"));

        userService.deleteUserEstablishment(establishment);
    }
    private EstablishmentProfileResponseDTO toDTO(EstablishmentProfileEntity establishmentProfileEntity) {
        return new EstablishmentProfileResponseDTO(
                establishmentProfileEntity.getUser().getName(),
                establishmentProfileEntity.getUser().getEmail(),

                establishmentProfileEntity.getFantasyName(),
                establishmentProfileEntity.getDescription(),
                establishmentProfileEntity.getAddress(),
                establishmentProfileEntity.getCity(),
                establishmentProfileEntity.getContactPhone(),
                establishmentProfileEntity.getSocialMedia()
        );
    }
}
