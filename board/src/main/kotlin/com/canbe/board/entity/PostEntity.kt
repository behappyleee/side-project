package com.canbe.board.entity

import kotlinx.datetime.LocalDateTime
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.kotlin.datetime.CurrentDateTime
import org.jetbrains.exposed.sql.kotlin.datetime.datetime

object PostEntity {

    // TODO - Study 필요 Entity 와 Class 가 내부 적으로 어떻게 동작 하는 지 ... Study 가 필요 ... !
    object Posts : IntIdTable(name = "post") {
        val title: Column<String> = varchar(name = "title", length = 50)
        val content: Column<String> = varchar(name = "content", length = 500)
        val writer: Column<String> = varchar(name = "writer", length = 20)

        val createdAt: Column<LocalDateTime> =
            datetime("created_at").defaultExpression(CurrentDateTime)

        val updatedAt: Column<LocalDateTime> =
            datetime("updated_at").defaultExpression(CurrentDateTime)
    }

    class Post(id: EntityID<Int>) : IntEntity(id) {
        companion object : IntEntityClass<Post>(Posts)

        val postId = id.value
        val title by Posts.title
        val content by Posts.content
        val writer by Posts.writer
        val createdAt by Posts.createdAt
        val updatedAt by Posts.updatedAt
    }
}
