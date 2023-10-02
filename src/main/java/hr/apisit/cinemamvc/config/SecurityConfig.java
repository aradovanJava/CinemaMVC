package hr.apisit.cinemamvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
        return new MvcRequestMatcher.Builder(introspector);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {

        /*
        MvcRequestMatcher.Builder requestMatcherBuilder =
                new MvcRequestMatcher.Builder(introspector);

        http.authorizeHttpRequests((requests) -> requests
                        .requestMatchers(requestMatcherBuilder.pattern("/login")).anonymous()
                .requestMatchers(requestMatcherBuilder.pattern("/home")).permitAll()

        )*/
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers(mvc(introspector).pattern("/login.html")).hasAnyAuthority("ROLE_ANONYMOUS")
                        .requestMatchers(mvc(introspector).pattern("/error")).hasAnyAuthority("ROLE_ANONYMOUS")
                        .requestMatchers(mvc(introspector).pattern("/home")).hasAnyAuthority("ROLE_ANONYMOUS")
                        .requestMatchers(mvc(introspector).pattern("/film")).hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                        .anyRequest().authenticated()
                )

        .formLogin((form) -> form
                .loginPage("/cinema/login.html")
                .defaultSuccessUrl("/film", true)
                .failureUrl("/login?error")
        ) .logout((logout) -> logout.permitAll());
        return http.build();

    }


}
