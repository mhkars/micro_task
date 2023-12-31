//package com.halit.config.security;
//
//
//import com.halit.repository.entity.Auth;
//import com.halit.service.AuthService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class JwtUserDetails implements UserDetailsService {
//    @Autowired
//    private AuthService authService;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return null;
//    }
//
//    public UserDetails loadUserById(Long id) throws UsernameNotFoundException {
//        Optional<Auth> auth = (authService.findById(id));
//
//        List<GrantedAuthority> authorityList = new ArrayList<>();
//        authorityList.add(new SimpleGrantedAuthority(auth.get().getRole().toString()));
//
//        if (auth.isPresent()) {
//
//            return User.builder().username(String.valueOf(auth.get().getId())).password("")
//                    .accountExpired(false)
//                    .accountLocked(false)
//                    .authorities(authorityList)
//                    .build();
//
//        }
//        return null;
//    }
//
//}