package com.pivotalservices.sample.domain

import java.util.*
import javax.persistence.MappedSuperclass
import javax.persistence.PrePersist

@MappedSuperclass
abstract class DatedModel: Model() {
    var created: Date? = null

    @PrePersist
    fun create() {
        created = Date()
    }
}
