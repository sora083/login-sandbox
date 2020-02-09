package com.sora.proto.loginsandbox.config

import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.AuthenticationFailureHandler
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Spring Securityの認証失敗時に呼ばれるハンドラクラス
 */
class AuthFailureHandler : AuthenticationFailureHandler {

    @Throws(IOException::class, ServletException::class)
    override fun onAuthenticationFailure(
            httpServletRequest: HttpServletRequest,
            httpServletResponse: HttpServletResponse,
            authenticationException: AuthenticationException) {

        var errorId = ""
        // ExceptionからエラーIDをセットする
        if (authenticationException is BadCredentialsException) {
            errorId = "ERR-0001"
        }

        // ログイン画面にリダイレクト
        httpServletResponse.sendRedirect(httpServletRequest.contextPath + "/index?error=" + errorId)
    }
}
