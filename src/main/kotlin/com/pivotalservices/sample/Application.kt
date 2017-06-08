package com.pivotalservices.sample

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.web.config.EnableSpringDataWebSupport

@SpringBootApplication
@EnableSpringDataWebSupport
class Application

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}
