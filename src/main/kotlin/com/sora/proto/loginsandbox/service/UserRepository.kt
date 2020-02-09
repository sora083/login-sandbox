package com.sora.proto.loginsandbox.service

import com.sora.proto.loginsandbox.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * usersテーブルのRepository.
 */
@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun findByEmail(email: String): User
}
