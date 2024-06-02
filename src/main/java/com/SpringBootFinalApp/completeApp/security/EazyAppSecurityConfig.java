package com.SpringBootFinalApp.completeApp.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
public class EazyAppSecurityConfig {
    
    // @Bean
    // public InMemoryUserDetailsManager inMemoryUserDetailsManager()
    // {
    //     UserDetails john = User.builder().username("JohnDoe")
    //             .password("11111").build();
    //     return new InMemoryUserDetailsManager(john);
    // }

    @Bean
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource)
    {
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        userDetailsManager.setUsersByUsernameQuery("SELECT email, pwd, 1 as enabled from customer c where email=?");
        userDetailsManager.setAuthoritiesByUsernameQuery("SELECT email, role from customer where email=?");
        return userDetailsManager;
        // return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
