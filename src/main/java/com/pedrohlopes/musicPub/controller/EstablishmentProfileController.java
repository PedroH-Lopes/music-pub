package com.pedrohlopes.musicPub.controller;

import com.pedrohlopes.musicPub.dto.EstablishmentProfileDTO;
import com.pedrohlopes.musicPub.service.EstablishmentProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/establishment-profile")
@RequiredArgsConstructor
@Validated
public class EstablishmentProfileController {

    private final EstablishmentProfileService establishmentProfileService;

    @PostMapping
    public ResponseEntity<Void> createEstablishmentProfile(@Valid @RequestBody EstablishmentProfileDTO establishmentProfileDTO) {
        establishmentProfileService.createEstablishmentProfile(establishmentProfileDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
