package com.miniproject.unislo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig{

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().disable()
                .authorizeRequests(request -> request
                        .antMatchers("/admin/**").hasRole("ADMIN") // /admin/** 경로에 대한 인증 필요
                        .antMatchers("/user/info/**").authenticated() // /user/info/**" 경로에 들어가면 로그인 요청
                        .anyRequest().permitAll() // 그 외의 요청은 모두 허용
                )
                .formLogin(login -> login
                        .loginPage("/user/login")	// [A] 커스텀 로그인 페이지 지정
                        .loginProcessingUrl("/login-proc")	// [B] submit 받을 url
                        .usernameParameter("userId")	// [C] submit할 아이디
                        .passwordParameter("UserPw")	// [D] submit할 비밀번호
                        .defaultSuccessUrl("/", true)
                        .failureUrl("/user/login/error")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout") // 로그아웃 URL 설정
                        .invalidateHttpSession(true) // 세션 무효화
                        .deleteCookies("JSESSIONID") // 쿠키 삭제 (필요에 따라 추가적인 쿠키도 지정 가능)
                        .logoutSuccessUrl("/login") // 로그아웃 후 리디렉션될 URL
                );

        return http.build();
    }

    @Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}