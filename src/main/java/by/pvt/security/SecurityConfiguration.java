package by.pvt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // enable in memory based authentication with a user named
        // "user" and "admin"
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles("USER").and()
                .withUser("admin").password("{noop}password").roles("USER", "ADMIN");
    }*/

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/add-product")
                .hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/add-product")
                .hasRole("ADMIN")
                .and()
                .formLogin()
                .and()
                .csrf().disable()
                .sessionManagement()
                .sessionFixation().none();
    }

    @Bean
    public UserDetailsService userDetailsService (){
        return new AuthenticationService ( );
    }

    @Autowired
    private UserDetailsService userDetailsService;


    private PasswordEncoder passwordEncoder;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

}
