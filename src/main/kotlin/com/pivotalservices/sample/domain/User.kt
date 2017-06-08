package com.pivotalservices.sample.domain

import javax.persistence.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

@Entity
@NamedQueries(NamedQuery(name = "user.list", query = "select u from User u"))
data class User(
        @field:Id
        @field:GeneratedValue
        var id: Long? = null,

        @field:NotNull
        @field:Size(min = 3, max = 15)
        var fullName: String?,

        @field:NotNull
        @field:Size(min = 3, max = 15)
        var password: String?,

        @field:NotNull
        @field:Pattern(regexp = ".+@.+\\.[a-z]+")
        var email: String?
) {
    constructor() : this(null, null, null, null)
}