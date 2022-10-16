package webclient.backend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//            .antMatchers("/login", "/register")
//            .permitAll()
//            .antMatchers("/account/**").access("hasRole('ADMIN')")
//            .and()
//            .formLogin(form -> form
//                .loginPage("/login")
//                .defaultSuccessUrl("/home")
//                .failureUrl("/login?error=true")
//            );
//    }
//
//        @Override
//    protected void configure(AuthenticationManagerBuilder auth)
//      throws Exception {
//        auth.inMemoryAuthentication()
//          .withUser("spring")
//          .password("{noop}secret")
//          .roles("USER");
//    }
//
//    @Override
//    public void configure(WebSecurity web) {
//        web.ignoring()
//            .antMatchers("/resources/**", "/static/**");
//    }
}