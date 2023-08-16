package com.halit.controller;

import com.halit.config.security.JwtTokenManager;
import com.halit.dto.LoginRequestDto;
import com.halit.dto.LoginResponseDto;
import com.halit.dto.RegisterRequestDto;
import com.halit.repository.entity.Auth;
import com.halit.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.halit.constants.ApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(AUTH)
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    private final JwtTokenManager jwtTokenManager;

    @PostMapping(REGISTER)
    public ResponseEntity<Auth> register(@RequestBody Auth dto) {
        return ResponseEntity.ok(authService.register(dto));
    }

    @PostMapping(LOGIN)
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto dto) {

        return ResponseEntity.ok(authService.login(dto).get());
    }
    @GetMapping(GETTOKEN)
    public String getToken(Long id) {

        return jwtTokenManager.createToken(id);
    }
    @GetMapping(GETIDBYTOKEN)
    public Long getId(String token) {

        return jwtTokenManager.getUserId(token).get();
    }
}
