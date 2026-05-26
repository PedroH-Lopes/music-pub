package com.pedrohlopes.musicPub.controller;

import com.pedrohlopes.musicPub.dto.ArtistProfileDTO;
import com.pedrohlopes.musicPub.service.ArtistProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/artist-profile")
@RequiredArgsConstructor
@Validated
public class ArtistProfileController {

    private final ArtistProfileService artistProfileService;

    @PostMapping
    public ResponseEntity<Void> createArtistProfile(@Valid @RequestBody ArtistProfileDTO artistProfileDTO) {
        artistProfileService.createArtist(artistProfileDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
