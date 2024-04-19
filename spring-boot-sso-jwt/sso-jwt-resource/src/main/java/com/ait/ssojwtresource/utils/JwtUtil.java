package com.ait.ssojwtresource.utils;
/*
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
*/
import io.jsonwebtoken.Jwts;
import javax.servlet.http.HttpServletRequest;
/**
 * Created by STS
 * Project : sso-jwt
 * @author aloke d.
 * @version 1.0
 * Email: alokebd@gmail.com
 */
public class JwtUtil {
	/*
    public static String generateToken(String signingKey, String subject) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        JwtBuilder builder = Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(now)
                .signWith(SignatureAlgorithm.HS256, signingKey);

        return builder.compact();
    }*/

    public static String getSubject(HttpServletRequest httpServletRequest, String jwtTokenCookieName, String signingKey){
        String token = CookieUtil.getValue(httpServletRequest, jwtTokenCookieName);
        if(token == null) return null;
        return Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token).getBody().getSubject();
    }
}
