package com.pivotalservices.sample.web

import com.pivotalservices.sample.domain.User
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.mock
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@RunWith(org.springframework.test.context.junit4.SpringRunner::class)
@WebMvcTest(com.pivotalservices.sample.web.UserController::class)
class UserControllerSliceTests {

    @org.springframework.beans.factory.annotation.Autowired
    lateinit var mockMvc: org.springframework.test.web.servlet.MockMvc

    @org.springframework.beans.factory.annotation.Autowired
    lateinit var userRepository: com.pivotalservices.sample.repository.UserRepository

    @org.junit.Test
    fun testGetUsers() {

        this.mockMvc.perform(get("/users").param("page", "0").param("size", "1")
                .accept(org.springframework.http.MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk)
    }

    @org.junit.Before
    fun setUp(): Unit {
        given(userRepository.findAll(org.mockito.Matchers.any(org.springframework.data.domain.Pageable::class.java)))
                .willAnswer({ invocation ->
                    val pageable = invocation.arguments[0] as org.springframework.data.domain.Pageable
                    org.springframework.data.domain.PageImpl(
                            listOf(
                                    User(id = 1, fullName = "one", password = "one", email = "one@one.com"),
                                    User(id = 2, fullName = "two", password = "two", email = "two@two.com"))
                            , pageable, 10)
                })
    }

    @org.springframework.boot.test.context.TestConfiguration
    class SpringConfig {

        
        @org.springframework.context.annotation.Bean
        fun userResourceAssembler(): com.pivotalservices.sample.web.UserResourceAssembler {
            return com.pivotalservices.sample.web.UserResourceAssembler()
        }

        @org.springframework.context.annotation.Bean
        fun userRepository(): com.pivotalservices.sample.repository.UserRepository {
            return mock(com.pivotalservices.sample.repository.UserRepository::class.java)
        }
    }

}