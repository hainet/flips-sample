package com.hainet.flips.sample;

import org.flips.describe.config.FlipWebContextConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(FlipWebContextConfiguration.class)
public class FlipsSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlipsSampleApplication.class, args);
    }
}
