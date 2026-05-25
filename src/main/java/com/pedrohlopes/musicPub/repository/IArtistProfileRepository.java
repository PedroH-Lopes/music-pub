package com.pedrohlopes.musicPub.repository;

import com.pedrohlopes.musicPub.model.artist.ArtistProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IArtistProfileRepository extends JpaRepository<ArtistProfileEntity, Integer> {
}
