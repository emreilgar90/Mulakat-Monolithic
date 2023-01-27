package com.emreilgar.service;

import com.emreilgar.dto.request.LoginRequestDto;
import com.emreilgar.dto.request.RegisterRequestDto;
import com.emreilgar.mapper.IMapper;
import com.emreilgar.repository.IRepository;
import com.emreilgar.repository.entity.UserEntity;
import com.emreilgar.utility.JwtTokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MulakatService {
    private final IRepository repository;
    private final JwtTokenManager tokenManager;

    public String Register(RegisterRequestDto dto){

        Optional<UserEntity>userEntity = repository.findOptionalByEmail(dto.getEmail());
        if (userEntity.isPresent()){
            throw new RuntimeException();
        }
        UserEntity user= IMapper.INSTANCE.fromRegisterRequestDto(dto); //dto yu user entity e çevirdik
        Optional<String>token=tokenManager.createToken(user.getId());  //id yi al tokenManager ile token e çevir
        repository.save(user);
        return token.get();



    }

    public String Login(LoginRequestDto dto) {
        Optional<UserEntity>userEntity= repository.findOptionalByEmailAndPassword(dto.getEmail(),dto.getPassword()); // email e göre repo da var mı ?
        if (userEntity.isEmpty()) {
            throw new RuntimeException();
        }
        Optional<String>token=tokenManager.createToken(userEntity.get().getId());

        return token.get();


    }
}
