package com.halit.repository;

import com.halit.repository.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAuthRepository extends JpaRepository<Auth, Long> {
    Optional<Auth> findOptionalByIdAndPassword(Long userId, String password);
}
