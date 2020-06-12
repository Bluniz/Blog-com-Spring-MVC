package com.bluniz.codeblog.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //Lista estática de URI para setar no spring
    private static final String[] AUTH_LIST = {
            "/",
            "/posts",
            "/posts/{id}"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        //desabilitando o spring secutiry nos caminhos que setamos no vetor estatico feito anteriormente
        http.csrf().disable().authorizeRequests()
                .antMatchers(AUTH_LIST).permitAll()
                .anyRequest().authenticated()
                .and().formLogin().permitAll() //Utiliza uma pag pronta do spring security(um form de login) porém da pra fazer um personalizado e por no lugar
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }

    //Função para setar o login e senha
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("lucas").password("{noop}123").roles("ADMIN");
    }


    /*Configuração caso fosse utilizar pastas estáticas, por ex baixar os arquivos do bootstrap, está função
    não está sendo usada porém ela está indicando o caminho até a pasta*/

    @Override
    public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers("/bootstrap/**");
//        web.ignoring().antMatchers("/bootstrap/**", "/style/**");
    }
}


