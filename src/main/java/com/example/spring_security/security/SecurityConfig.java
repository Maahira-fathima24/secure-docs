package com.example.spring_security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    /*
     * ==========================
     * HTTP BASIC
     * ==========================
     */
    @Bean
    @Order(1)
    public SecurityFilterChain basicSecurity(HttpSecurity http) throws Exception {

        http

                .securityMatcher("/basic/**")

                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth

                        .requestMatchers("/basic/login")
                        .permitAll()
                        .anyRequest().authenticated()
                )

                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    /*
     * ==========================
     * SESSION LOGIN
     * ==========================
     */

    @Bean
    @Order(2)
    public SecurityFilterChain sessionSecurity(HttpSecurity http) throws Exception {

        http

                .securityMatcher("/session/**")

                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/session/login"
                        ).permitAll()

                        .anyRequest().authenticated()
                )

                .formLogin(form -> form

                        .loginPage("/session/login")

                        .defaultSuccessUrl("/session/demo", true)

                        .permitAll()
                )

                .logout(logout -> logout
                        .logoutSuccessUrl("/")
                );

        return http.build();
    }

    /*
     * ==========================
     * JWT
     * ==========================
     */

    @Bean
    @Order(3)
    public SecurityFilterChain jwtSecurity(HttpSecurity http) throws Exception {

        http

                .securityMatcher("/jwt/**")

                .csrf(csrf -> csrf.disable())

                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )

                .authorizeHttpRequests(auth -> auth

                        .requestMatchers("/jwt/login",
                                "/jwt/page")
                        .permitAll()

                        .anyRequest().authenticated()

                )

                .addFilterBefore(
                        jwtAuthenticationFilter,
                        UsernamePasswordAuthenticationFilter.class
                );

        return http.build();
    }

    /*
     * ==========================
     * PUBLIC WEBSITE
     * ==========================
     */

    @Bean
    @Order(4)
    public SecurityFilterChain publicSecurity(HttpSecurity http) throws Exception {

        http

                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth

                        .requestMatchers(
                                "/",
                                "/about",
                                "/auth-choice",
                                "/dashboard",
                                "/documents",
                                "/profile",
                                "/css/**",
                                "/js/**",
                                "/images/**"
                        ).permitAll()

                        .anyRequest().denyAll()

                );

        return http.build();
    }

}