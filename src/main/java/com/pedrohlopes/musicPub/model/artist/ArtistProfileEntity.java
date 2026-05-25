package com.pedrohlopes.musicPub.model.artist;

import com.pedrohlopes.musicPub.model.user.UserEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "artists_profiles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ArtistProfileEntity {

    @Id
    private Long id;

    @Column(name = "artistic_name", nullable = false)
    private String artisticName;

    @Column(nullable = false)
    private String biography;

    @Column(nullable = false)
    private String city;

    private String instagram;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
