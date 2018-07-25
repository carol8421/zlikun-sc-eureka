package com.zlikun.sc.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 当启用 `Spring Security` 时，默认Spring会校验 `CSRF token` ，但Eureka的客户端并不会实现这一点，所以把注册服务的URL禁用这一特性
 * http://cloud.spring.io/spring-cloud-static/Finchley.RELEASE/multi/multi_spring-cloud-eureka-server.html#_securing_the_eureka_server
 *
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018/7/25 21:29
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/eureka/**");
        super.configure(http);
    }
}
