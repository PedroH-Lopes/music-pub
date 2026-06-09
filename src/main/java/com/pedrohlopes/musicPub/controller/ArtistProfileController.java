package com.pedrohlopes.musicPub.controller;

import com.pedrohlopes.musicPub.dto.artist.ArtistProfileResponseDTO;
import com.pedrohlopes.musicPub.dto.artist.ArtistProfileUpdateDTO;
import com.pedrohlopes.musicPub.service.ArtistProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/artist-profile")
@RequiredArgsConstructor
@Validated
public class ArtistProfileController {

    private final ArtistProfileService artistProfileService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ArtistProfileResponseDTO> findAllArtists(){
        return artistProfileService.findAllArtists();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ArtistProfileResponseDTO findArtistById(@PathVariable Long id){
        return artistProfileService.findArtistById(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateArtistById(@PathVariable Long id, @RequestBody ArtistProfileUpdateDTO artistProfileUpdateDTO){
        artistProfileService.updateArtist(id, artistProfileUpdateDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArtistById(@PathVariable Long id){
        artistProfileService.deleteArtistById(id);
    }
}
