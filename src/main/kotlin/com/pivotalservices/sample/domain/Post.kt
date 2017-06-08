package com.pivotalservices.sample.domain

import javax.persistence.*
import javax.validation.Valid
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Entity
@NamedQueries(NamedQuery(name = "post.list", query = "select p from Post p"))
class Post(
        @field:NotNull
        @field:Size(min = 1)
        var title: String?,

        @field:NotNull
        @field:Size(min = 1)
        @field:Lob
        var content: String?

) : DatedModel() {

    @field:ManyToOne
    @field:JoinColumn(name = "user_id")
    @field:Valid
    var user: User? = null
    
    constructor(): this(null, null)

}
