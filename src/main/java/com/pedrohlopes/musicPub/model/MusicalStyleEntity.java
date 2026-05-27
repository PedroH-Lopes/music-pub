package com.pedrohlopes.musicPub.model;

import com.pedrohlopes.musicPub.model.artist.ArtistProfileEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "musical_styles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MusicalStyleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @ManyToMany(mappedBy = "musicalStyles")
    private Set<ArtistProfileEntity> artists = new HashSet<>();
}
