package com.sora.proto.loginsandbox.controller

import com.sora.proto.loginsandbox.service.UserService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class LoginController(private val userService: UserService) {

    @GetMapping("/")
    fun root(): ModelAndView {
        return ModelAndView("/index")
    }

    @GetMapping("/index")
    fun index(): ModelAndView {
        return ModelAndView("/index")
    }

    @GetMapping("/login/success")
    fun users(): ModelAndView = ModelAndView("/login/success")
}
