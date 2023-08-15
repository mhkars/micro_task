package com.halit.service;

import com.halit.config.security.JwtTokenManager;
import com.halit.dto.LoginRequestDto;
import com.halit.dto.LoginResponseDto;
import com.halit.exception.AuthManagerException;
import com.halit.exception.ErrorType;
import com.halit.mapper.IAuthMapper;
import com.halit.repository.IAuthRepository;
import com.halit.repository.entity.Auth;
import com.halit.repository.enums.Roles;
import com.halit.utiliy.CodeGenaretor;
import com.halit.utiliy.ServiceManager;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthService extends ServiceManager<Auth,Long> {
    private final IAuthRepository authRepository;
    private JwtTokenManager jwtTokenManager;


    public AuthService(IAuthRepository authRepository, JwtTokenManager jwtTokenManager){
        super(authRepository);
        this.authRepository=authRepository;
        this.jwtTokenManager = jwtTokenManager;

    }

    @Transactional
    public Auth register(Auth auth) {

 //        Auth auth = IAuthMapper.INSTANCE.toAuth(dto);

//        if (userIsExist(dto.getUsername())){
//            throw  new AuthManagerException(ErrorType.USERNAME_DUPLICATE);
//        }else {
//
//            if (dto.getAdminCode()!=null&& dto.getAdminCode().equals("admin"))  {
//                auth.setRole(Roles.ADMIN);
//            }
//            try {
//                return   save(auth);
//            }catch (Exception e){
//                throw  new AuthManagerException(ErrorType.USER_NOT_CREATED);
//            }
//
//        }
        if (auth.getRole() != null && auth.getRole().equals("admin")) {
            auth.setRole(Roles.CompanyAdmin);
        }
        try {
            auth.setActivatedCode(CodeGenaretor.generateCode(UUID.randomUUID().toString()));

            save(auth);
 //           cacheManager.getCache("findbyrole").evict(auth.getRole());
//            userManager.createUser(NewCreateUserDto.builder()
//                    .authid(auth.getId())
//                    .email(auth.getEmail())
//                    .username(auth.getUsername())
//                    .build());
//
//            procedure.sendActivatedCode(
//                    com.bilgeadam.rabbitmq.model.ActivateReguestDto.
//                            builder().email(auth.getEmail())
//                            .activatedCode(auth.getActivatedCode()).build());

            return auth;

        } catch (Exception e) {
//                 delete(auth);
            e.printStackTrace();
            throw new AuthManagerException(ErrorType.AUTH_NOT_CREATED);

        }


    }


    public Optional<LoginResponseDto> login(LoginRequestDto dto) {
        Optional<Auth> auth = authRepository.findOptionalByIdAndPassword(dto.getUserId(), dto.getPassword());

        if (auth.isPresent()) {
            LoginResponseDto loginResponseDto = IAuthMapper.INSTANCE.toLoginResponseDto(auth.get());
            String token = jwtTokenManager.createToken(loginResponseDto.getId());
            loginResponseDto.setToken(token);
            loginResponseDto.setCode(200L);
            return Optional.of(loginResponseDto);
        } else {
            throw new AuthManagerException(ErrorType.LOGIN_ERROR_WRONG);
        }
    }
}
