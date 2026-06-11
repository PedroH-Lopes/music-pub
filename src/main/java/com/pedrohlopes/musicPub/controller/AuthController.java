package com.pedrohlopes.musicPub.controller;

import com.pedrohlopes.musicPub.dto.artist.ArtistProfileDTO;
import com.pedrohlopes.musicPub.dto.LoginProfileDTO;
import com.pedrohlopes.musicPub.dto.TokenResponseDTO;
import com.pedrohlopes.musicPub.dto.establishment.EstablishmentProfileDTO;
import com.pedrohlopes.musicPub.service.ArtistProfileService;
import com.pedrohlopes.musicPub.service.AuthService;
import com.pedrohlopes.musicPub.service.EstablishmentProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
@Tag(name = "Autenticação", description = "Operações de cadastro e autenticação de usuários")
public class AuthController {


    private final ArtistProfileService artistProfileService;
    private final EstablishmentProfileService establishmentProfileService;
    private final AuthService authService;

    @Operation(
            summary = "Cadastrar artista",
            description = "Realiza o cadastro de um novo perfil de artista no sistema."
    )
    @PostMapping("/register/artist")
    public void registerArtist(@Valid @RequestBody ArtistProfileDTO artistProfileDTO) throws Exception {
        artistProfileService.createArtist(artistProfileDTO);
    }

    @Operation(
            summary = "Autenticar usuário",
            description = "Realiza a autenticação de um usuário e retorna um token JWT para acesso aos endpoints protegidos."
    )
    @PostMapping("/login")
    public TokenResponseDTO login(@RequestBody LoginProfileDTO loginProfileDTO) throws Exception {
        return authService.login(loginProfileDTO);
    }

    @Operation(
            summary = "Cadastrar estabelecimento",
            description = "Realiza o cadastro de um novo perfil de estabelecimento no sistema."
    )
    @PostMapping("/register/establishment")
    public void registerEstablishment(@Valid @RequestBody EstablishmentProfileDTO establishmentProfileDTO) throws Exception {
        establishmentProfileService.createEstablishmentProfile(establishmentProfileDTO);
    }
}
