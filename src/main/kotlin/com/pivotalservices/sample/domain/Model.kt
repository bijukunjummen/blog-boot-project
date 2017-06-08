package com.pivotalservices.sample.domain

import javax.persistence.*

@MappedSuperclass
@Access(AccessType.FIELD)
abstract class Model {
    @field:Id @field:GeneratedValue var id: Long? = null
}