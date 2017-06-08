package com.pivotalservices.sample.repository

import com.pivotalservices.sample.domain.User
import org.springframework.data.repository.PagingAndSortingRepository

interface UserRepository: PagingAndSortingRepository<User, Long>