package com.canbe.board.dto

import java.time.LocalDateTime

data class UpdatePostDto(
    val title: String,
    val content: String,
    val writer: String,
    val updatedAt: LocalDateTime = LocalDateTime.now()
)
