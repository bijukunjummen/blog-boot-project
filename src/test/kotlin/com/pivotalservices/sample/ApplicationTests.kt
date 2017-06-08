package com.pivotalservices.sample

import com.pivotalservices.sample.domain.Post
import com.pivotalservices.sample.domain.User
import com.pivotalservices.sample.repository.PostRepository
import com.pivotalservices.sample.repository.UserRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Configuration
import org.springframework.test.context.junit4.SpringRunner


@RunWith(SpringRunner::class)
@SpringBootTest
class ApplicationTests {

    @Autowired
    lateinit var userRepo: UserRepository
    
    @Autowired
    lateinit var postRepo: PostRepository

    @Test
    fun testPopulateModelsAndQuery() {
        val user1 = userRepo.save(User(fullName = "test1", password = "test123", email = "test@test.com"))
        userRepo.save(User(fullName = "test2", password = "test123", email = "test@test.com"))

        
        userRepo.findAll()

        assertThat(userRepo.count()).isEqualTo(2)
        
        val post = Post("title", "Some content")
        post.user = user1
        
        postRepo.save(post)
        
        val posts = postRepo.findByUser(user1)
        
        assertThat(posts.size).isEqualTo(1)
        
        assertThat(posts.get(0).content).isEqualTo("Some content")
        
        assertThat(posts.get(0).user?.fullName).isEqualTo("test1")
    }

    @Configuration
    @EnableAutoConfiguration
    class SpringConfig
}
