package com.pedrohlopes.musicPub.service;

import com.pedrohlopes.musicPub.dto.EstablishmentProfileDTO;
import com.pedrohlopes.musicPub.model.establishment.EstablishmentProfileEntity;
import com.pedrohlopes.musicPub.enums.Roles;
import com.pedrohlopes.musicPub.model.user.UserEntity;
import com.pedrohlopes.musicPub.repository.IEstablishmentProfileRepository;
import com.pedrohlopes.musicPub.repository.IRolesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EstablishmentProfileService {

    private final IEstablishmentProfileRepository establishmentProfileRepository;
    private final IRolesRepository rolesRepository;
    private final UserService userService;

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
                        .user(user)
                .build());
    }
}
