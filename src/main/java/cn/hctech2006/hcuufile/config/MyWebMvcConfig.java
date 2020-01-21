package cn.hctech2006.hcuufile.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //对所有URL生效
        registry.addMapping("/**")

                //所有的头信息
                .allowedHeaders("*")
                //所有的方法
                .allowedMethods("GET","POST","OPTIONS","PUT","DELETE")
                .maxAge(3600)
                //允许携带cookie参数
                .allowCredentials(true)
                //所有的域
                .allowedOrigins("47.112.132.177:8092")
        .allowedOrigins("localhost:8080")
        .allowedOrigins("localhost:8092")
        .allowedOrigins("47.112.132.177:8092");

    }
}









