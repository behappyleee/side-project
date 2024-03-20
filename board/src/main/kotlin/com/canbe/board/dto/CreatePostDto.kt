package com.canbe.board.dto

data class CreatePostDto(
    val title: String,
    val content: String,
    val writer: String
)
