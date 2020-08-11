package com.fabio.pontointeligente.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PontoInteligenteApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(PontoInteligenteApplication.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
