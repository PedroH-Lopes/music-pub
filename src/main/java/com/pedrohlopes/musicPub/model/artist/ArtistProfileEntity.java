package com.pedrohlopes.musicPub.model.artist;

import com.pedrohlopes.musicPub.model.MusicalStyleEntity;
import com.pedrohlopes.musicPub.model.user.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "artists_profiles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ArtistProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "artistic_name", nullable = false)
    private String artisticName;

    @Column(nullable = false)
    private String biography;

    @Column(nullable = false)
    private String city;

    @Column(name = "social_media")
    private String socialMedia;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToMany
    @JoinTable(
            name = "artist_musical_styles",
            joinColumns = @JoinColumn(name = "artist_profile_id"),
            inverseJoinColumns = @JoinColumn(name = "musical_style_id")
    )
    private Set<MusicalStyleEntity> musicalStyles = new HashSet<>();
}
