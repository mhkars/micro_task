package com.halit.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.halit.exception.AuthManagerException;
import com.halit.exception.ErrorType;

import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.Optional;

@Service
public class JwtTokenManager {

    String secretKey = "secretkey";
    public String createToken(Long id) {

        String token = null;

        try {
//        Algorithm algorithm=Algorithm.HMAC256(secretKey);
            token = JWT.create()
                    .withAudience("mobiliz")
                    .withIssuer("halit")
                    .withIssuedAt(new Date())
                    .withExpiresAt(new Date(System.currentTimeMillis() + (1000 * 60 * 5)))
                    .withClaim("id", id)
                    .sign(Algorithm.HMAC256(secretKey));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return token;
    }

    public Optional<Long> getUserId(String token) {

        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("halit")
                    .withAudience("mobiliz")
                    .build();
            DecodedJWT decodedJWT = verifier.verify(token);

            if (decodedJWT == null) {
                throw new AuthManagerException(ErrorType.INVALID_TOKEN);
            }
            Long id = decodedJWT.getClaim("id").asLong();
            return Optional.of(id);
        } catch (Exception e) {

            return Optional.empty();
        }

    }

}
