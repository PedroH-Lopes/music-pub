package com.pedrohlopes.musicPub.repository;

import com.pedrohlopes.musicPub.model.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRolesRepository extends JpaRepository<RolesEntity, Long> {

    Optional<RolesEntity> findByName(String role);
}
