package com.pedrohlopes.musicPub.controller;

import com.pedrohlopes.musicPub.dto.artist.ArtistProfileResponseDTO;
import com.pedrohlopes.musicPub.dto.artist.ArtistProfileUpdateDTO;
import com.pedrohlopes.musicPub.service.ArtistProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/artist-profile")
@RequiredArgsConstructor
@Validated
@Tag(name = "Perfis dos Artistas", description = "Gerencia perfis de artistas criados no sistema")
public class ArtistProfileController {

    private final ArtistProfileService artistProfileService;

    @Operation(
            summary = "Listar artistas",
            description = "Retorna uma lista com todos os perfis de artistas cadastrados."
    )
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ArtistProfileResponseDTO> findAllArtists(){
        return artistProfileService.findAllArtists();
    }

    @Operation(
            summary = "Buscar artista por ID",
            description = "Retorna os dados de um artista a partir do seu identificador."
    )
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ArtistProfileResponseDTO findArtistById(@PathVariable Long id){
        return artistProfileService.findArtistById(id);
    }

    @Operation(
            summary = "Atualizar artista",
            description = "Atualiza parcialmente os dados de um artista. Apenas o proprietário do perfil ou um administrador pode realizar esta operação."
    )
    @SecurityRequirement(name = "bearerAuth")
    @PreAuthorize("@profileSecurity.isArtistOwner(#id, authentication)" + "or hasRole('ADMIN')")
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateArtistById(@PathVariable Long id, @RequestBody ArtistProfileUpdateDTO artistProfileUpdateDTO){
        artistProfileService.updateArtistById(id, artistProfileUpdateDTO);
    }

    @Operation(
            summary = "Remover artista",
            description = "Remove um perfil de artista do sistema. Operação permitida apenas para administradores."
    )
    @SecurityRequirement(name = "bearerAuth")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArtistById(@PathVariable Long id){
        artistProfileService.deleteArtistById(id);
    }
}
