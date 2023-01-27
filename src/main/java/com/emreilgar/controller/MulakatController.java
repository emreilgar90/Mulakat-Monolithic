package com.emreilgar.controller;

import com.emreilgar.dto.request.LoginRequestDto;
import com.emreilgar.dto.request.RegisterRequestDto;
import com.emreilgar.service.MulakatService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controller")
@RequiredArgsConstructor
public class MulakatController {
    private final MulakatService service;
    @PostMapping("/register")
    @Operation(summary = "kullanıcı register eden metot")
    public ResponseEntity<String> register(RegisterRequestDto dto){
        return ResponseEntity.ok(service.Register(dto));
    }

    @PostMapping("/login")
    @Operation(summary = "kullanıcı login eden metot")
    public ResponseEntity<String> Login(LoginRequestDto dto){
        return ResponseEntity.ok(service.Login(dto));
    }
}
