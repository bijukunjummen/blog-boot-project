package com.pivotalservices.sample.web

import com.pivotalservices.sample.domain.User
import com.pivotalservices.sample.repository.UserRepository
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PagedResourcesAssembler
import org.springframework.hateoas.PagedResources
import org.springframework.hateoas.Resource
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
        private val userRepository: UserRepository,
        private val userResourceAssembler: UserResourceAssembler) {

    @GetMapping
    fun getUsers(pageable: Pageable, 
                 pagedResourcesAssembler: PagedResourcesAssembler<User>): PagedResources<Resource<User>> {
        val users = userRepository.findAll(pageable)
        return pagedResourcesAssembler.toResource(users, this.userResourceAssembler)
    }

    @GetMapping("/{id}")
    fun getUser(id: Long): Resource<User> {
        return Resource(userRepository.findOne(id))
    }
}