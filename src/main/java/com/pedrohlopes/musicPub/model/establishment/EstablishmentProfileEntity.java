package com.pedrohlopes.musicPub.model.establishment;

import com.pedrohlopes.musicPub.model.user.UserEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "establishments_profiles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EstablishmentProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fantasy_name", nullable = false)
    private String fantasyName;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String contactPhone;

    @Column(nullable = false)
    private String socialMedia;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
