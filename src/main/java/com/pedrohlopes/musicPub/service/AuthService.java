package com.pedrohlopes.musicPub.service;

import com.pedrohlopes.musicPub.config.TokenProvider;
import com.pedrohlopes.musicPub.dto.LoginProfileDTO;
import com.pedrohlopes.musicPub.dto.TokenResponseDTO;
import com.pedrohlopes.musicPub.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final TokenProvider tokenProvider;
    @Value("${JWT_EXPIRATION}")
    private Long expirationTime;

    public TokenResponseDTO login(LoginProfileDTO loginProfileDTO) throws Exception{
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginProfileDTO.email(), loginProfileDTO.password()));
            String token = tokenProvider.generateToken(authentication);

            return new TokenResponseDTO(token, expirationTime);
        } catch (BadCredentialsException badCredentialsException) {
            throw new BadRequestException("Credenciais Inválidas");
        } catch (Exception e) {
            throw e;
        }
    }
}
