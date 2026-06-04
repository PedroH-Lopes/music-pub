package com.pedrohlopes.musicPub.repository;

import com.pedrohlopes.musicPub.model.event.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEventRepository extends JpaRepository<EventEntity, Long> {
}
