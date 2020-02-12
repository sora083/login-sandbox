package com.sora.proto.loginsandbox.service

import com.sora.proto.loginsandbox.model.User
import org.springframework.security.core.authority.AuthorityUtils;

/**
 * 認証ユーザーの情報を格納するクラス
 */
class LoginUser(user: User) : org.springframework.security.core.userdetails.User(user.email, user.encrypted_password,
        AuthorityUtils.createAuthorityList("ROLE_USER")) {

    /**
     * ログインユーザー
     */
    var loginUser: User? = null

    init {
        // スーパークラスのユーザーID、パスワードに値をセットする
        // 実際の認証はスーパークラスのユーザーID、パスワードで行われる
        this.loginUser = user
    }

}
