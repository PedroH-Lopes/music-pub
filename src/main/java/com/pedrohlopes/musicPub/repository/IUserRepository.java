package com.pedrohlopes.musicPub.repository;

import com.pedrohlopes.musicPub.model.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserEntity, Integer> {
}
