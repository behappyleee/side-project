package com.canbe.board.dto

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Column
import java.time.LocalDateTime

@Entity(name = "post")
data class JpaPostDto(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    @Column(name = "title")
    val title: String,
    @Column(name = "content")
    val content: String,
    @Column(name = "writer")
    val writer: String,
    @Column(name = "created_at")
    val createdAt: LocalDateTime,
    @Column(name = "updated_at")
    val updatedAt: LocalDateTime
) {
//    constructor() : this() {
//
//    }
}
