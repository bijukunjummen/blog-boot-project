package com.pivotalservices.sample.domain

import javax.persistence.*
import javax.validation.Valid
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size
import javax.xml.bind.annotation.XmlTransient

@Entity
@NamedQueries(
        NamedQuery(name = "comment.list", query = "select c from Comment c"), 
        NamedQuery(name = "comment.for.post", query = "select c from Comment c where c.post.id=:postId"))
class Comment : Model() {

    @field:NotNull
    @field:Size(min = 1)
    var author: String? = null
    
    @field:NotNull
    @field:Size(min = 1)
    @field:Lob
    var content: String? = null
    
    @field:ManyToOne
    @field:JoinColumn(name = "post_id")
    @field:Valid
    @field:XmlTransient
    var post: Post? = null
}
