package com.example.examenspboot;
import org.springframework.stereotype.Service;

@Service
public class security {
    public static Boolean validateToken(String token) {
        return (token.equals("t0k3n"));
    }
}
