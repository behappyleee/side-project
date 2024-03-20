package com.canbe.board.controller

import com.canbe.board.dto.JpaPostDto
import com.canbe.board.service.PostJpaService
import com.canbe.board.util.ApiVersion
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(ApiVersion.JPA_FIRST_VERSION_API_PATH + "/posts")
class PostJpaController(
    private val service: PostJpaService,
) {
    @GetMapping
    fun findAllPosts(): List<JpaPostDto> {
        return service.findAllPosts()
    }

    @GetMapping("/{postId}")
    fun findPostById(
        @PathVariable(name = "postId") postId: Int,
    ): JpaPostDto {
        return service.findPostByPostId(postId = postId)
    }
}
