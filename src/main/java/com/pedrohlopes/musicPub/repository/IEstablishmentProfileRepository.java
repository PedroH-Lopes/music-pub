package com.pedrohlopes.musicPub.repository;

import com.pedrohlopes.musicPub.model.establishment.EstablishmentProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEstablishmentProfileRepository extends JpaRepository<EstablishmentProfileEntity, Long> {
}
