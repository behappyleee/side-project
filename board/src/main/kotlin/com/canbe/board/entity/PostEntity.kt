package com.canbe.board.entity

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object PostEntity {

//    id  - int
//    title - varchar 50
//    content - varchar 500
//    writer - varchar 20
//    created_at - datetime
//    updated_at - datetime
    object Post : Table() {
        val id: Column<Int> = integer("id").autoIncrement()
        val title: Column<String> = varchar(name = "title", length = 50)
        val content: Column<String> = varchar(name = "content", length = 500)
        val writer: Column<String> = varchar(name = "writer", length = 20)

        override val primaryKey = PrimaryKey(id)
    }
}
