package com.pedrohlopes.musicPub.repository;

import com.pedrohlopes.musicPub.model.MusicalStyleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface IMusicalStyleRepository extends JpaRepository<MusicalStyleEntity, Long> {

    List<MusicalStyleEntity> findByIdIn(Set<Long> ids);
}
