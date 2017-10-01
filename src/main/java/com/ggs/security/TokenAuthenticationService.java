package com.ggs.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClaims;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

class TokenAuthenticationService {
    static final long EXPIRATION_TIME = 864_000_000; // 10 days
    static final String SECRET = "ggssecrettoken";
    static final String TOKEN_PREFIX = "Bearer";
    static final String AUTHORIZATION_HEADER_NAME = "Authorization";
    static final String AUTHENTICATED_USER_NAME_HEADER_NAME = "AuthenticatedUser";
    static final ObjectMapper objectMapper = new ObjectMapper();

    static void addAuthentication(HttpServletResponse res, Authentication auth) {

        DefaultClaims defaultClaims = new DefaultClaims();
        defaultClaims.setSubject(auth.getName());
        defaultClaims.put("authorities", auth.getAuthorities());

        String JWT = Jwts.builder()
                .setSubject(auth.getName()).setClaims(defaultClaims)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        res.addHeader(AUTHORIZATION_HEADER_NAME, TOKEN_PREFIX + " " + JWT);
        res.addHeader(AUTHENTICATED_USER_NAME_HEADER_NAME, auth.getName());
    }

    static Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(AUTHORIZATION_HEADER_NAME);
        if (token != null) {

            Jws<Claims> claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX, ""));
            // parse the token.
            String user = claims.getBody().getSubject();
            List<Map<String, String>> authoritiesList = (List<Map<String, String>>) claims.getBody().get("authorities");
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            for (Map<String, String> authoritie : authoritiesList) {
                authorities.add(new SimpleGrantedAuthority(authoritie.get("authority")));
            }
            return user != null ?
                    new UsernamePasswordAuthenticationToken(user, null, authorities) :
                    null;
        }
        return null;
    }


}