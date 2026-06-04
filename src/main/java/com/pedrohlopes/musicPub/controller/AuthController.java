package com.pedrohlopes.musicPub.controller;

import com.pedrohlopes.musicPub.dto.ArtistProfileDTO;
import com.pedrohlopes.musicPub.dto.LoginProfileDTO;
import com.pedrohlopes.musicPub.dto.TokenResponseDTO;
import com.pedrohlopes.musicPub.service.ArtistProfileService;
import com.pedrohlopes.musicPub.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final ArtistProfileService artistProfileService;
    private final AuthService authService;

    @PostMapping("/register/artist")
    public void registerArtist(@Valid @RequestBody ArtistProfileDTO artistProfileDTO) throws Exception {
        artistProfileService.createArtist(artistProfileDTO);
    }

    @PostMapping("/login/artist")
    public TokenResponseDTO login(@RequestBody LoginProfileDTO loginProfileDTO) throws Exception {
        return authService.login(loginProfileDTO);
    }
}
