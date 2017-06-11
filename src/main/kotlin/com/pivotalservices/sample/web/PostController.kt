package com.pivotalservices.sample.web

import com.pivotalservices.sample.domain.Post
import com.pivotalservices.sample.repository.PostRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/posts")
class PostController(private val postRepository: PostRepository) {
    
    @GetMapping
    fun getPosts(pageable: Pageable): Page<Post> {
        return this.postRepository.findAll(pageable)
    }
}