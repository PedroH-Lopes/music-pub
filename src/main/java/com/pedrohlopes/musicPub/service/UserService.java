package com.pedrohlopes.musicPub.service;

import com.pedrohlopes.musicPub.enums.Roles;
import com.pedrohlopes.musicPub.exception.BusinessException;
import com.pedrohlopes.musicPub.model.RolesEntity;
import com.pedrohlopes.musicPub.model.user.UserEntity;
import com.pedrohlopes.musicPub.repository.IRolesRepository;
import com.pedrohlopes.musicPub.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@RequiredArgsConstructor
@Service
public class UserService {

    private final IUserRepository userRepository;
    private final IRolesRepository  rolesRepository;
    private final PasswordEncoder passwordEncoder;

    public UserEntity createUser(String name, String email, String password, Roles roleEnum) {

        validateEmail(email);

        RolesEntity role = rolesRepository.findByName(roleEnum.name())
                .orElseGet(() -> rolesRepository.save(RolesEntity.builder()
                        .name(roleEnum.name())
                        .build()));

        return userRepository.save(UserEntity.builder()
                .name(name)
                .email(email)
                .password(passwordEncoder.encode(password))
                .roles(Set.of(role))
                .build());
    }

    public void validateEmail(String email) {
        if (userRepository.existsByEmail(email)) {
            throw new BusinessException("Email já cadastrado");
        }
    }
}
