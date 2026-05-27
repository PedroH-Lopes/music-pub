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

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
