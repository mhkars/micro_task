package com.halit.service;

import com.halit.repository.IAuthRepository;
import com.halit.repository.entity.Auth;
import com.halit.utiliy.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class AuthService extends ServiceManager<Auth,Long> {
    private final IAuthRepository authRepository;

    public AuthService(IAuthRepository authRepository){
        super(authRepository);
        this.authRepository=authRepository;
    }
}
