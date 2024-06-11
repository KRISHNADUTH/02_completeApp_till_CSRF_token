package com.SpringBootFinalApp.completeApp.security;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import com.SpringBootFinalApp.completeApp.filter.CsrfTokenFilter;

import jakarta.servlet.http.HttpServletRequest;

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
        
        CsrfTokenRequestAttributeHandler requestHandler = new CsrfTokenRequestAttributeHandler();


        http.cors(cors ->{
            cors.configurationSource(new CorsConfigurationSource() {

                @Override
                public CorsConfiguration getCorsConfiguration(HttpServletRequest arg0) {
                    CorsConfiguration config = new CorsConfiguration();
                    config.setAllowCredentials(true);
                    config.setAllowedMethods(Collections.singletonList("*"));
                    config.setAllowedHeaders(Collections.singletonList("*"));
                    config.setAllowedOrigins(Collections.singletonList("*"));
                    config.setMaxAge(3600L);
                    return config;
                }
            });
        });
        
        // http.csrf(csrf -> csrf.disable());
        http.securityContext(context -> context.requireExplicitSave(false))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS));
        http.csrf(csrf -> csrf.csrfTokenRequestHandler(requestHandler)
                .ignoringRequestMatchers("/customer","/contact")
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
        ).addFilterAfter(new CsrfTokenFilter(), BasicAuthenticationFilter.class);   

        http.authorizeHttpRequests( request ->request
                // .requestMatchers("/myAccount").hasRole("ADMIN")
                .requestMatchers("/myAccount").hasAuthority("VIEW_ACCOUNT")
                .requestMatchers("/myBalance").hasAuthority("VIEW_TRANSACTION")
                .requestMatchers("/notices").hasAuthority("UPDATE_NOTICES")
                .anyRequest().permitAll()
        );
        
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
