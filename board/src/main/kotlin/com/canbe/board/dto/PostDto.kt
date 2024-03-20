package com.canbe.board.dto

import com.canbe.board.entity.PostEntity
import kotlinx.datetime.toJavaLocalDateTime
import org.jetbrains.exposed.sql.ResultRow
import java.time.LocalDateTime

data class PostDto(
    val id: Int,
    val title: String,
    val content: String,
    val writer: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
) {
    companion object {
        fun postEntityToPostDto(post: PostEntity.Post): PostDto {
            return PostDto(
                id = post.postId,
                title = post.title,
                writer = post.writer,
                content = post.content,
                // TODO - 왜 kotlinx 는 안될까 ... ?! 고민이 필요 !
                createdAt = post.createdAt.toJavaLocalDateTime(),
                updatedAt = post.updatedAt.toJavaLocalDateTime(),
            )
        }

        // TODO - Query 를 어떻게 객체로 변경할 수 있을 까 .... ?!?!?! 고민이 필요 ,.... !!
        fun resultRowToTest(resultRows: List<ResultRow>): List<PostDto> {
            return resultRows.map { resultRow ->
                PostDto(
                    id = resultRow[PostEntity.Posts.id].value,
                    title = resultRow[PostEntity.Posts.title],
                    content = resultRow[PostEntity.Posts.content],
                    writer = resultRow[PostEntity.Posts.writer],
                    createdAt = resultRow[PostEntity.Posts.createdAt].toJavaLocalDateTime(),
                    updatedAt = resultRow[PostEntity.Posts.updatedAt].toJavaLocalDateTime(),
                )
            }
        }
    }
}
