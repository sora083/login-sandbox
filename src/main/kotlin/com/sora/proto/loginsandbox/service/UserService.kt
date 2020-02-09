package com.sora.proto.loginsandbox.service

import com.sora.proto.loginsandbox.model.User
import com.sora.proto.loginsandbox.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * DBからのデータ取得と加工を行う.
 */
@Service
class UserService @Autowired constructor(private val userRepository: UserRepository) {

    /**
     * 全ユーザリストの取得
     * @return ユーザリスト
     */
    fun findAllUser(): MutableList<User> = userRepository.findAll()

    fun findByEmail(email: String): User = userRepository.findByEmail(email)
}
