package com.example.DB_Connection.configuration;

import com.example.DB_Connection.entity.User;
import com.example.DB_Connection.enums.Role;
import com.example.DB_Connection.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ApplicationInitConfig {
    PasswordEncoder passwordEncoder;

    @Bean
    ApplicationRunner applicationRunner(UserRepository userRepository) {
        return args -> {
            if (userRepository.findUserByUsername("admin").isEmpty()) {

                HashSet<String> roles = new HashSet<>();
                roles.add(Role.ADMIN.name());
                User user = new User();
                user.setUsername("admin");
                user.setRoles(roles);
                user.setPassword(passwordEncoder.encode("admin"));

                userRepository.save(user);
                log.warn("Admin has been created");
            }
        };
    }
}
