package com.pedrohlopes.musicPub.model.user;

import com.pedrohlopes.musicPub.enums.Roles;
import com.pedrohlopes.musicPub.model.RolesEntity;
import com.pedrohlopes.musicPub.model.artist.ArtistProfileEntity;
import com.pedrohlopes.musicPub.model.establishment.EstablishmentProfileEntity;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class UserEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToOne(mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private ArtistProfileEntity artistProfile;

    @OneToOne(mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private EstablishmentProfileEntity establishmentProfile;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RolesEntity> roles = new HashSet<>();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public @Nullable String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
