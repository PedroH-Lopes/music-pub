package com.pedrohlopes.musicPub.repository;

import com.pedrohlopes.musicPub.model.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {

    @Query(
            value = """
                    SELECT EXISTS (
                        SELECT 1
                        FROM users u
                        WHERE u.email = :email
                    )
                    """,
            nativeQuery = true
    )
    boolean existsByEmail(@Param("email")  String email);

    Optional<UserEntity> findByEmail(String username);
}
