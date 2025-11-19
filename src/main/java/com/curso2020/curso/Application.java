package com.curso2020.curso;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Ponto de entrada da aplicação Spring Boot.
 * novo
 */
@SpringBootApplication
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    protected Application() {
        // Impede instanciação
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.run(args);
        logger.info("Application started");
    }
}