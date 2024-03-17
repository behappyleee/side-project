package com.canbe.board.dto

import kotlinx.datetime.LocalDateTime

data class PostDto(
    val id: Int,
    val title: String,
    val content: String,
    val writer: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
) {
//    fun toPostDto(postEntity: PostEntity.Post): PostDto {
//        return PostDto(
//            id = postEntity.id,
//            title = postEntity.title,
//            writer = postEntity.writer,
//            content = postEntity.content,
//        )
//    }f
}
