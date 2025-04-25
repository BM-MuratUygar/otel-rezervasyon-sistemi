package com.oteller.apigateway.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtil {

    private final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(
            "bu-cooook-gizli-bir-key-32-karakter!".getBytes(StandardCharsets.UTF_8)
    );

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 saat
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    // Token’dan kullanıcı adı çıkarma
    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    // Token geçerli mi diye kontrol etme
    public boolean validateToken(String token) {
        return !extractClaims(token).getExpiration().before(new Date()); // Expiry date kontrolü
    }

    // Claims (JWT içeriği) çıkarmak
    private Claims extractClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY) // Secret key ayarları
                .build()
                .parseClaimsJws(token) // Token doğrulama
                .getBody(); // Claims kısmı
    }
}