package com.canbe.board.service

import com.canbe.board.dto.JpaPostDto
import com.canbe.board.repository.PostJpaRepository
import org.springframework.stereotype.Service

@Service
class PostJpaService(
    private val repository: PostJpaRepository,
) {
    fun findAllPosts(): List<JpaPostDto> {
        return repository.findAll()
    }

    fun findPostByPostId(postId: Int): JpaPostDto {
        return repository.findById(postId).orElseThrow()
    }

}
