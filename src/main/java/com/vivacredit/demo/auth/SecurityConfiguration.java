package com.vivacredit.demo.auth;

import static com.vivacredit.demo.auth.jwt.util.JwtSecurityConstants.*;

import javax.ws.rs.HttpMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.vivacredit.demo.auth.jwt.config.JwtAuthenticationEntryPoint;
import com.vivacredit.demo.auth.jwt.config.JwtAuthenticationFilter;
import com.vivacredit.demo.auth.jwt.config.JwtAuthorizationFilter;
import com.vivacredit.demo.auth.jwt.util.JwtTokenUtil;

/**
 * SecurityConfiguration
 *
 * @author nandan.kelkar
 */

@Configuration
@EnableConfigurationProperties
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // configure AuthenticationManager so that it knows from where to load
        // user for matching credentials
        // Use BCryptPasswordEncoder
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Bean(name = "bCryptPasswordEncoder")
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // .antMatchers(HttpMethod.POST, SIGN_UP_URL)
        // .permitAll()
        http.cors().and().csrf().disable().exceptionHandling()
                .authenticationEntryPoint(unauthorizedHandler).and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
                .antMatchers(HttpMethod.POST, SIGN_UP_URL).permitAll().and().authorizeRequests()
                .antMatchers(HttpMethod.POST, LOGIN_URL).permitAll().and().authorizeRequests()
                .antMatchers(HttpMethod.POST, AUTHENTICATE_URL).permitAll().and()
                .authorizeRequests().anyRequest().authenticated().and()
                .addFilter(new JwtAuthenticationFilter(authenticationManager()))
                .addFilter(new JwtAuthorizationFilter(authenticationManager(), jwtTokenUtil,
                        userService));

    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

}