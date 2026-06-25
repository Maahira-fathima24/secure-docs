package com.example.spring_security.config;


import com.example.spring_security.model.Role;
import com.example.spring_security.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.example.spring_security.model.User;

@Component
public class DataInitializer implements CommandLineRunner {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {

        if (userRepository.findByUsername("admin").isEmpty()) {
            userRepository.save(
                    new User(
                            "admin",
                            passwordEncoder.encode("admin123"),
                            Role.ADMIN
                    )
            );
        }

        if (userRepository.findByUsername("manager").isEmpty()) {
            userRepository.save(
                    new User(
                            "manager",
                            passwordEncoder.encode("manager123"),
                            Role.MANAGER
                    )
            );
        }

        if (userRepository.findByUsername("employee").isEmpty()) {
            userRepository.save(
                    new User(
                            "employee",
                            passwordEncoder.encode("employee123"),
                            Role.EMPLOYEE
                    )
            );
        }

        System.out.println("Sample users loaded successfully!");
    }
}
