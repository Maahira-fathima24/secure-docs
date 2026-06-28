package com.example.spring_security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/login", "/public/**").permitAll()

                        .requestMatchers("/admin/**")
                        .hasRole("ADMIN")

                        .requestMatchers("/manager/**")
                        .hasAnyRole("MANAGER", "ADMIN")

                        .requestMatchers("/employee/**")
                        .hasAnyRole("EMPLOYEE", "MANAGER", "ADMIN")

                        .anyRequest().authenticated()
                )

                // Default Spring Security Login Page
                //.formLogin(Customizer.withDefaults())

                .formLogin(form -> form
                        .defaultSuccessUrl("/dashboard", true)
                )

                //.logout(Customizer.withDefaults());
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .permitAll()
                );

        return http.build();
    }
}
