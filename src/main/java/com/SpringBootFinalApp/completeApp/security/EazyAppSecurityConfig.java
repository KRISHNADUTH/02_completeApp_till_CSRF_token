package com.SpringBootFinalApp.completeApp.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class EazyAppSecurityConfig {
    
    // @Bean
    // public InMemoryUserDetailsManager inMemoryUserDetailsManager()
    // {
    //     UserDetails john = User.builder().username("JohnDoe")
    //             .password("11111").build();
    //     return new InMemoryUserDetailsManager(john);
    // }

    // @Bean
    // public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource)
    // {
    //     JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
    //     userDetailsManager.setUsersByUsernameQuery("SELECT email, pwd, 1 as enabled from customer c where email=?");
    //     userDetailsManager.setAuthoritiesByUsernameQuery("SELECT email, role from customer where email=?");
    //     return userDetailsManager;
    //     // return new JdbcUserDetailsManager(dataSource);
    // }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        
        http.authorizeHttpRequests( request ->request
                .requestMatchers("/myAccount").hasRole("ADMIN")
                .anyRequest().permitAll()
        );

        http.csrf(csrf -> csrf.disable());

        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
        
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
