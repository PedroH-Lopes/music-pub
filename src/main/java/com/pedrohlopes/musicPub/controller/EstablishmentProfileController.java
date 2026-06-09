package com.pedrohlopes.musicPub.controller;

import com.pedrohlopes.musicPub.dto.establishment.EstablishmentProfileDTO;
import com.pedrohlopes.musicPub.dto.establishment.EstablishmentProfileResponseDTO;
import com.pedrohlopes.musicPub.dto.establishment.EstablishmentProfileUpdateDTO;
import com.pedrohlopes.musicPub.service.EstablishmentProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

@RestController
@RequestMapping("/v1/establishment-profile")
@RequiredArgsConstructor
@Validated
public class EstablishmentProfileController {

    private final EstablishmentProfileService establishmentProfileService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EstablishmentProfileResponseDTO> findAllEstablishments() {
        return establishmentProfileService.findAllEstablishments();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EstablishmentProfileResponseDTO findEstablishmentById(@PathVariable Long id) {
        return establishmentProfileService.findEstablishmentProfileById(id);
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateEstablishmentById(@PathVariable Long id, @RequestBody EstablishmentProfileUpdateDTO establishmentProfileUpdateDTO) {
        establishmentProfileService.updateEstablishmentById(id, establishmentProfileUpdateDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEstablishmentById(@PathVariable Long id) {
        establishmentProfileService.deleteEstablishmentById(id);
    }
}
