package com.pedrohlopes.musicPub.service;

import com.pedrohlopes.musicPub.exception.BusinessException;
import com.pedrohlopes.musicPub.model.MusicalStyleEntity;
import com.pedrohlopes.musicPub.repository.IMusicalStyleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MusicalStyleService {

    private final IMusicalStyleRepository musicalStyleRepository;

    public Set<MusicalStyleEntity> findMusicalStylesById (Set<Long> musicalStylesIds) {

        Set<MusicalStyleEntity> musicalStyles = new HashSet<>();

        if (musicalStylesIds != null && !musicalStylesIds.isEmpty()) {
           musicalStyles = new HashSet<>(
                   musicalStyleRepository.findByIdIn(musicalStylesIds)
           );

           if (musicalStyles.size() != musicalStylesIds.size()) {
               throw new BusinessException("Um ou mais estilos musicais não encontrados");
           }
        }

        return musicalStyles;
    }
}
