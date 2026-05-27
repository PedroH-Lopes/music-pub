package com.pedrohlopes.musicPub.service;

import com.pedrohlopes.musicPub.dto.EstablishmentProfileDTO;
import com.pedrohlopes.musicPub.model.establishment.EstablishmentProfileEntity;
import com.pedrohlopes.musicPub.model.user.Roles;
import com.pedrohlopes.musicPub.model.user.UserEntity;
import com.pedrohlopes.musicPub.repository.IEstablishmentProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EstablishmentProfileService {

    private final IEstablishmentProfileRepository establishmentProfileRepository;
    private final UserService userService;

    public void createEstablishmentProfile(EstablishmentProfileDTO establishmentProfileDTO) {

        UserEntity user = userService.registerUser(
                establishmentProfileDTO.name(),
                establishmentProfileDTO.email(),
                establishmentProfileDTO.password(),
                Roles.ESTABLISHMENT);

        establishmentProfileRepository.save(EstablishmentProfileEntity.builder()
                        .fantasyName(establishmentProfileDTO.fantasyName())
                        .description(establishmentProfileDTO.description())
                        .address(establishmentProfileDTO.address())
                        .city(establishmentProfileDTO.city())
                        .contactPhone(establishmentProfileDTO.contactPhone())
                        .user(user)
                .build());
    }
}
