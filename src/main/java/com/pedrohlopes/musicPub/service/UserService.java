package com.pedrohlopes.musicPub.service;

import com.pedrohlopes.musicPub.model.user.UserEntity;
import com.pedrohlopes.musicPub.repository.IUserRepository;
import com.pedrohlopes.musicPub.model.user.Roles;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final IUserRepository userRepository;

    public UserEntity registerUser(String name, String email, String password, Roles role) {

        return userRepository.save(UserEntity.builder()
                    .name(name)
                    .email(email)
                    .password(password)
                    .role(role)
                .build());
    }
}
