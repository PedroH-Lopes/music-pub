package com.pedrohlopes.musicPub.controller;

import com.pedrohlopes.musicPub.dto.establishment.EstablishmentProfileResponseDTO;
import com.pedrohlopes.musicPub.dto.establishment.EstablishmentProfileUpdateDTO;
import com.pedrohlopes.musicPub.service.EstablishmentProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/establishment-profile")
@RequiredArgsConstructor
@Validated
@Tag(name = "Perfis dos Estabelecimentos", description = "Gerencia perfis de estabelecimentos criados no sistema")
public class EstablishmentProfileController {

    private final EstablishmentProfileService establishmentProfileService;

    @Operation(summary = "Listar estabelecimentos", description = "Retorna uma lista com todos os perfis de estabelecimentos cadastrados.")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EstablishmentProfileResponseDTO> findAllEstablishments() {
        return establishmentProfileService.findAllEstablishments();
    }

    @Operation(
            summary = "Buscar estabelecimento por ID",
            description = "Retorna os dados de um estabelecimento a partir do seu identificador."
    )
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EstablishmentProfileResponseDTO findEstablishmentById(@PathVariable Long id) {
        return establishmentProfileService.findEstablishmentProfileById(id);
    }

    @Operation(
            summary = "Atualizar estabelecimento",
            description = "Atualiza parcialmente os dados de um estabelecimento. Apenas o proprietário ou um administrador pode realizar esta operação."
    )
    @SecurityRequirement(name = "bearerAuth")
    @PreAuthorize("@profileSecurity.isEstablishmentOwner(#id, authentication)" + "or hasRole('ADMIN')")
    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateEstablishmentById(@PathVariable Long id, @RequestBody EstablishmentProfileUpdateDTO establishmentProfileUpdateDTO) {
        establishmentProfileService.updateEstablishmentById(id, establishmentProfileUpdateDTO);
    }

    @Operation(
            summary = "Remover estabelecimento",
            description = "Remove um perfil de estabelecimento do sistema. Operação permitida apenas para administradores."
    )
    @SecurityRequirement(name = "bearerAuth")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEstablishmentById(@PathVariable Long id) {
        establishmentProfileService.deleteEstablishmentById(id);
    }
}
