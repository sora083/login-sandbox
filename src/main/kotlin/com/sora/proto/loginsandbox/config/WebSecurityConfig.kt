package com.sora.proto.loginsandbox.config

import com.sora.proto.loginsandbox.service.UserDetailsServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.util.matcher.AntPathRequestMatcher

@Configuration
@EnableWebSecurity
class WebSecurityConfig : WebSecurityConfigurerAdapter() {

    companion object {
        val log = org.slf4j.LoggerFactory.getLogger(this::class.java.enclosingClass)!!
    }

    override fun configure(web: WebSecurity) {
        // ここに設定したものはセキュリティ設定を無視
        web.ignoring().antMatchers(
                "/**/favicon.ico",
                "/images/**",
                "/css/**",
                "/javascript/**",
                "/webjars/**")
    }

    override fun configure(http: HttpSecurity) {
        // 認可の設定
        http.authorizeRequests()
                .antMatchers("/", "/index").permitAll() // indexは全ユーザーアクセス許可
                .anyRequest().authenticated()  // それ以外は全て認証無しの場合アクセス不許可

        // ログイン設定
        http.formLogin()
                .loginProcessingUrl("/users/login")   // 認証処理のパス
                .loginPage("/index")            // ログインフォームのパス
                .failureHandler(AuthFailureHandler())       // 認証失敗時に呼ばれるハンドラクラス
                .defaultSuccessUrl("/login/success")     // 認証成功時の遷移先
                .usernameParameter("email") // ユーザー名のパラメータ名
                .passwordParameter("encrypted_password")  // パスワードのパラメータ名

        // ログアウト
        http.logout()
                .logoutRequestMatcher(AntPathRequestMatcher("/logout**"))
                .logoutSuccessUrl("/index")

    }

    @Configuration
    class AuthenticationConfiguration : GlobalAuthenticationConfigurerAdapter() {

        @Autowired
        var userDetailsService: UserDetailsServiceImpl = UserDetailsServiceImpl();

        override fun init(auth: AuthenticationManagerBuilder) {
            // 認証するユーザーの設定
            auth.userDetailsService(userDetailsService)
        }

        @Bean
        fun passwordEncoder(): PasswordEncoder? {
            return NoOpPasswordEncoder.getInstance()
        }
    }
}
