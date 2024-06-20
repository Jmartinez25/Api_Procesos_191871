package com.api1.crudtienda.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
@Slf4j
public class JWTService {
    private static final String SECRET_KEY = "Y2xhdmUgc2VjcmV0YSBtdXkgcGVybyBtdXkgc2VndXJh";
    private static final long accessTokenValidity = 60*60*1000;//1 hour 36000 ms

    public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
        if (token != null) {
            // parse the token
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody();

            String user = claims.getSubject();

            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
            }
            return null;
        }
        return null;
    }
}
