package com.kunwood.board.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * packageName : com.kunwood.board.security
 * fileName : TokenProvider
 * author : geonu
 * date : 2023/08/10
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023/08/10         geonu          최초 생성
 */
@Service
public class TokenProvider {
    // JWT 생성 및 검증을 위한 KEY 생성
    private static final String SECURITY_KEY = "jwtseckey!@";
    // JWT 생성 메서드
    public String create (String userEmail){
        // 만료날짜를 현재 날짜 + 1시간으로 설정
        Date exprTime = Date.from(Instant.now().plus(1, ChronoUnit.HOURS));

        // JWT를 생성
        return Jwts.builder()
                // 암호화에 사용될 알로리즘, 키
                .signWith(SignatureAlgorithm.HS512, SECURITY_KEY)
                // JWT의 제목, 생성일, 만료일
                .setSubject(userEmail).setIssuedAt(new Date()).setExpiration(exprTime)
                // 생성
                .compact();
    }
    // JWT 검증
    public String validate  (String token){
        // 매개변수로 받은 token을 키를 사용해서 복호화 (디코딩)
        Claims claims = Jwts.parser().setSigningKey(SECURITY_KEY).parseClaimsJws(token).getBody();
        // 복호화된 토큰의 payload에서 제목을 가져옴
        return claims.getSubject();
    }
}
