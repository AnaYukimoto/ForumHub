package forumhub.security;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/topicos/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin().permitAll()
                .and()
                .httpBasic();
    }
}
