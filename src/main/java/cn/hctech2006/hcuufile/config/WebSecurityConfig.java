package cn.hctech2006.hcuufile.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("123456").roles("ADMIN");
        auth.inMemoryAuthentication()
                .withUser("root").password("123456").roles("ADMIN");
        auth.inMemoryAuthentication()
                .withUser("user").password("123456").roles("ADMIN");
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/static/**","/js/**","/font/**","/favicon.ico");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()

//                .antMatchers("/form/**")
//                .hasRole("ADMIN")
//                .antMatchers("/file/**")
//                .hasRole("ADMIN")
                .antMatchers("/**")
                .hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
               // .loginPage("/login")
                .permitAll()
                .loginProcessingUrl("/login")
                .permitAll()
                .usernameParameter("username")
                .passwordParameter("password")
//                .successHandler(new AuthenticationSuccessHandler() {
//                    @Override
//                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
//                        Object principal = authentication.getPrincipal();
//                        httpServletResponse.setContentType("application/json;charset=utf-8");
//                        Map<String, Object> map = new HashMap<>();
//                        map.put("status", 200);
//                        map.put("msg", principal);
//                        ObjectMapper om = new ObjectMapper();
//                        PrintWriter out = httpServletResponse.getWriter();
//                        RespBean respBean  = RespBean.ok("成功", map);
//                        out.write(om.writeValueAsString(respBean));
//                        out.flush();
//                        out.close();
//                    }
//                })
//                .failureHandler(new AuthenticationFailureHandler() {
//                    @Override
//                    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
//                        httpServletResponse.setContentType("application/json;charset=utf-8");
//                        Map<String, Object> map = new HashMap<>();
//                        ObjectMapper om = new ObjectMapper();
//                        PrintWriter out = httpServletResponse.getWriter();
//                        RespBean respBean  = RespBean.ok("登陆失败");
//                        out.write(om.writeValueAsString(respBean));
//                        out.flush();
//                        out.close();
//                    }
//                })
//                .permitAll()
                .and()
        .csrf()
        .disable()

        ;
    }
}
