package com.pivotalservices.sample

import com.pivotalservices.sample.domain.User
import com.pivotalservices.sample.repository.UserRepository
import com.pivotalservices.sample.web.UserController
import com.pivotalservices.sample.web.UserResourceAssembler
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Matchers
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.data.web.config.EnableSpringDataWebSupport
import org.springframework.http.MediaType
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@RunWith(SpringRunner::class)
@WebAppConfiguration
@ContextConfiguration
class UserControllerTests {

    lateinit var mockMvc: MockMvc

    @Autowired
    private val wac: WebApplicationContext? = null

    @Before
    fun setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build()
    }

    @Test
    fun testGetUsers() {
        this.mockMvc.perform(get("/users")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk)
    }

    @EnableSpringDataWebSupport
    @EnableWebMvc
    @Configuration
    class SpringConfig {

        @Bean
        fun userController(): UserController {
            return UserController(userRepository(), UserResourceAssembler())
        }

        @Bean
        fun userRepository(): UserRepository {
            val userRepository = Mockito.mock(UserRepository::class.java)
            given(userRepository.findAll(Matchers.any(Pageable::class.java)))
                    .willAnswer({ invocation ->
                        val pageable = invocation.arguments[0] as Pageable
                        PageImpl(
                                listOf(
                                        User(id = 1, fullName = "one", password = "one", email = "one@one.com"),
                                        User(id = 2, fullName = "two", password = "two", email = "two@two.com"))
                                , pageable, 10)
                    })
            return userRepository
        }
    }
}