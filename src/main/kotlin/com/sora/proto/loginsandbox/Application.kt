package com.sora.proto.loginsandbox;

import org.springframework.boot.Banner.Mode.OFF
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration

@Configuration
@SpringBootApplication
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args) {
        setBannerMode(OFF)
    }
}
