package com.alyjah.rps_loan_calculator.config;

import com.alyjah.rps_loan_calculator.domain.model.UserModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Configuration
public class ApplicationConfig {

    @Bean
    public UserDetailsService userDetailsService() {
         List<UserModel> users =  Arrays.asList(
                    new UserModel("johndoe@example.com", "{noop}password"),
                    new UserModel("marydoe@example.com", "{noop}password")
            );

        return username -> {
            Optional<UserModel> user = users.stream()
                    .filter(u -> u.username().equalsIgnoreCase(username))
                    .findFirst();

            if (user.isPresent()) {
                return User.withUsername(user.get().username())
                        .password(user.get().password())
                        .authorities("USER") // Assign roles or authorities as needed
                        .build();
            } else {
                throw new UsernameNotFoundException("User not found");
            }
        };
    }

//    @Bean
//    BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
//        authProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        return authProvider;
    }

}
