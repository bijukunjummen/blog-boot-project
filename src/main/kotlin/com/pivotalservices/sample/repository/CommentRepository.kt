package com.pivotalservices.sample.repository

import com.pivotalservices.sample.domain.Comment
import org.springframework.data.repository.CrudRepository

interface CommentRepository: CrudRepository<Comment, Long>