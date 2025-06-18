package com.example.flightapi.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import com.example.flightapi.filter.JwtAuthenticationFilter;
import com.example.flightapi.service.impl.UserDetailsServiceImpl;
import com.example.flightapi.util.JwtTokenUtil;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
  @Autowired
  JwtTokenUtil jwtTokenUtil;

  // private final JwtAuthenticationFilter jwtAuthenticationFilter;
  private final PasswordEncoder passwordEncoder;
  private final UserDetailsService userDetailsService;

  public SecurityConfig(UserDetailsServiceImpl userDetailsService,
      // JwtAuthenticationFilter jwtAuthenticationFilter,
      PasswordEncoder passwordEncoder) {
    this.userDetailsService = userDetailsService;
    // this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    this.passwordEncoder = passwordEncoder;
  }

  @Bean
  public DaoAuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService);
    provider.setPasswordEncoder(passwordEncoder);
    return provider;
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.csrf(csrf -> csrf.disable())
        .cors(cors -> cors.configurationSource(request -> {
          CorsConfiguration config = new CorsConfiguration();
          config.setAllowedOriginPatterns(List.of("*"));
          config.setAllowedMethods(List.of("*"));
          config.setAllowedHeaders(List.of("*"));
          config.setAllowCredentials(true);
          return config;
        }))
        .authorizeHttpRequests(auth -> auth
            .requestMatchers(HttpMethod.GET, "/**").permitAll()
            .requestMatchers("/api/login/**").permitAll()
            .requestMatchers("/api/user/create").permitAll()
            .requestMatchers("/api/auth/**").permitAll()
            .requestMatchers("/api/flights/**").permitAll()
            .requestMatchers("/error").permitAll()
            .anyRequest().authenticated())
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        // .addFilterBefore(jwtAuthenticationFilter,
        .addFilterBefore(new JwtAuthenticationFilter(jwtTokenUtil,
            userDetailsService),
            UsernamePasswordAuthenticationFilter.class);

    return http.build();
  }
}
