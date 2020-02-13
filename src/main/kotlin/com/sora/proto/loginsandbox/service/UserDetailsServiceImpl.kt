package com.sora.proto.loginsandbox.service

import com.sora.proto.loginsandbox.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component
import java.util.*

/**
 * UserDetailsServiceの実装クラス
 * Spring Securityでのユーザー認証に使用する
 */
@Component
class UserDetailsServiceImpl : UserDetailsService {

    @Autowired
    lateinit var userService: UserService

    companion object {
        val log = org.slf4j.LoggerFactory.getLogger(this::class.java.enclosingClass)!!
    }

    override fun loadUserByUsername(username: String): UserDetails {

        log.info("loadUserByUsername. username: $username")

        // 認証を行うユーザー情報を格納する
        val user: Optional<User> = userService.findByEmail(username)

        // ユーザー情報を取得できなかった場合
        if (!user.isPresent) {
            log.error("User not found for login id: $username")
            throw UsernameNotFoundException("User not found for login id: $username")
        }

        // ユーザー情報が取得できたらSpring Securityで認証できる形で戻す
        return LoginUser(user.get())
    }
}
