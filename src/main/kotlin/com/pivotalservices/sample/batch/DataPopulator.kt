package com.pivotalservices.sample.batch

import com.pivotalservices.sample.domain.User
import com.pivotalservices.sample.repository.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DataPopulator(private val userRepository: UserRepository):CommandLineRunner {
    override fun run(vararg args: String?) {
        userRepository.save(User(fullName = "User 1", password = "pwd1", email = "user1@gmail.com"))
        userRepository.save(User(fullName = "User 2", password = "pwd1", email = "user2@gmail.com"))
        userRepository.save(User(fullName = "User 3", password = "pwd1", email = "user3@gmail.com"))
        userRepository.save(User(fullName = "User 4", password = "pwd1", email = "user4@gmail.com"))
        userRepository.save(User(fullName = "User 5", password = "pwd1", email = "user5@gmail.com"))
        userRepository.save(User(fullName = "User 6", password = "pwd1", email = "user6@gmail.com"))
        userRepository.save(User(fullName = "User 7", password = "pwd1", email = "user7@gmail.com"))
        userRepository.save(User(fullName = "User 8", password = "pwd1", email = "user8@gmail.com"))
        userRepository.save(User(fullName = "User 9", password = "pwd1", email = "user9@gmail.com"))
        userRepository.save(User(fullName = "User 10", password = "pwd1", email = "user10@gmail.com"))
        userRepository.save(User(fullName = "User 11", password = "pwd1", email = "user11@gmail.com"))
    }
}