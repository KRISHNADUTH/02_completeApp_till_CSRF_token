package com.SpringBootFinalApp.completeApp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class EazyAppSecurityConfig {
    
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager()
    {
        UserDetails john = User.builder().username("JohnDoe").password("{bcrypt}$2a$12$m.UWaEtURPNAE9TlAs8OLOtShWIQ8/tXjLw5jOgx6zywFpMQIAauy").build();
        return new InMemoryUserDetailsManager(john);
    }

}
