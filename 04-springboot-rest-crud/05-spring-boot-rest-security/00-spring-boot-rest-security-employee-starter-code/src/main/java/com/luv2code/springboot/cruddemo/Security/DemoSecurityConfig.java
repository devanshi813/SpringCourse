package com.luv2code.springboot.cruddemo.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    // add support for hdbc -  noo more hard corded users

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }


        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
            http.authorizeHttpRequests(configurer ->
                    configurer
                            .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("Employee")
                            .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("Employee")
                            .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("Manager")
                            .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("Manager")
                            .requestMatchers(HttpMethod.DELETE, "/api/employees").hasRole("Admin")
            );


            // use HTTP Basic authentication
            http.httpBasic(Customizer.withDefaults());

            // disable cross site request forgery (CSRF)
            // in general, not required for stateless Rest Api's that use Post, put, Delete and/or Patch

            http.csrf(csrf -> csrf.disable());
            return http.build();
    }

    /*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("Employee")
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("Employee", "Manager")
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("Employee", "Manager", "Admin")
                .build();

        return new InMemoryUserDetailsManager(john, mary, susan);
    }
    */
}
