package com.yousufibrahim28.TaskPlanner.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

    // Usualy LDAP or Database should be used to maintain user info
    // for the time being we can use in memory managemnet
    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {
        UserDetails userDetails1 = createNewUser("yousuf28", "dummy");
        UserDetails userDetails2 = createNewUser("yousuf", "dummydummy");
        return new InMemoryUserDetailsManager(userDetails1,userDetails2);
    }

    private UserDetails createNewUser(String username, String password) {
        Function<String, String> passwordEncoder 
                        = input -> passwordEncoder().encode(input);
        UserDetails userDetails = User.builder()
        .passwordEncoder(passwordEncoder)
        .username(username)
        .password(password)
        .roles("USER","ADMIN")
        .build();
        return userDetails;
    }

    // Custom password encoder, to encrypt the password.
    // BCryptPasswordEncoder provides a strong encryption algorithm
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // All URLs are protected
    // A login form is shown for unauthorized requests
    // CSRF disable for accessing h2 console
    // Frames should be enabled, by default spring security blocks frames

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
        httpSecurity.formLogin(Customizer.withDefaults());
        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();

        return httpSecurity.build();
    }
}
