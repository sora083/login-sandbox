package com.sora.proto.loginsandbox

import org.junit.jupiter.api.Test
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class BcryptTest {

    companion object {
        val log = org.slf4j.LoggerFactory.getLogger(this::class.java.enclosingClass)!!
    }

    @Test
    fun generateTest() {
        val text = "password"
        val encoder = BCryptPasswordEncoder()
        val encodedPassword = encoder.encode(text)
        log.info("encodedPassword: $encodedPassword")
    }
}