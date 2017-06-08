package com.pivotalservices.sample.web

import com.pivotalservices.sample.domain.User
import org.springframework.hateoas.Resource
import org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo
import org.springframework.hateoas.mvc.ResourceAssemblerSupport
import org.springframework.stereotype.Component

@Component
class UserResourceAssembler: ResourceAssemblerSupport<User?, Resource<User>> {
    
    override fun toResource(entity: User?): Resource<User> {
        val selflink = linkTo(UserController::class.java).slash(entity?.id).withSelfRel();
        return Resource(entity!!, selflink) 
    }

    constructor(): super(UserController::class.java, Resource::class.java as Class<Resource<User>>)
    
}