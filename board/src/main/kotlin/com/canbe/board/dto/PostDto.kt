package com.canbe.board.dto

import com.canbe.board.entity.PostEntity
import kotlinx.datetime.toJavaLocalDateTime
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
    }
}
