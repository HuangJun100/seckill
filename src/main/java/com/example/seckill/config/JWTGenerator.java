package com.example.seckill.config;

import com.example.seckill.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 功能：用户登录成功后生成JWT，采用HS256算法进行加密
 * 参数：
 * 作者：HuangJun
 * 时间：2021/3/16 15:06
 **/
@Component
public class JWTGenerator {
    //生成JWT的算法
    private final SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
    //    生成JWT的时间
    private Date generateDate;
    private static final String key = "hjkhkh";


    /**
     * 根据用户信息生成Jwt
     * @param user
     * @return
     */
    public String getJwt(User user) {

//        Jwt信息的主体
        Map<String, Object> claims = new HashMap<>();
        claims.put("userName", user.getNickname());
        claims.put("passWord", user.getPassword());
//        生成签名的密钥
//        String key = user.getPassword();
        //生成签发人
//        String subject = user.getNickname();
//          JWT生成的日期
        generateDate = new Date();

        JwtBuilder jwtBuilder = Jwts.builder()
                .setClaims(claims)
//                .setSubject(subject)
//                .setIssuedAt(generateDate)
                .signWith(signatureAlgorithm, key);
        return jwtBuilder.compact();
    }

    /**
     * JWT解密后校验
     * @param jwts
     * @return
     */

    public Claims isVerify(String jwts) {
        Claims body = Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(jwts).getBody();
        return body;
    }

}
