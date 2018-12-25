package com.aibyd.apps.core.util;

import java.util.Date;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTTokenUtil {

    private static InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("aibyd.jks");

    private static PrivateKey privateKey = null;

    private static PublicKey publicKey = null;

    public static final String keyStorePass = "1qazxcvbgt5@#$";

    public static final String keyParsePass = "1qazse4@#W";

    static {
        FileInputStream fin = null;
        try {
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(in, keyStorePass.toCharArray());
            privateKey = (PrivateKey) keyStore.getKey("aibyd", keyStorePass.toCharArray());
            publicKey = keyStore.getCertificate("aibyd").getPublicKey();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fin != null) {
                    fin.close();
                }
            } catch (Exception es) {
                es.printStackTrace();
            }
        }

    }

    public static String generateToken(String subject, int expirationSeconds, String salt) {
        return Jwts.builder().setClaims(null).setSubject(subject)
                .setExpiration(new Date(System.currentTimeMillis() + expirationSeconds * 1000))
                .signWith(SignatureAlgorithm.RS512, privateKey).compact();
    }

    public static String parseToken(String token, String salt) {
        String subject = null;
        try {
            Claims claims = Jwts.parser().setSigningKey(publicKey).parseClaimsJws(token).getBody();
            subject = claims.getSubject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return subject;
    }

}