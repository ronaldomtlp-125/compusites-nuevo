package com.compusites.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Desactiva CSRF (importante para APIs)
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll() // Permitir todo por ahora
            )
            .httpBasic(Customizer.withDefaults()); // Evita que te pida auth básica

        return http.build();
    }
}
