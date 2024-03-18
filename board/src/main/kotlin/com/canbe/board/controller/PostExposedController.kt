package com.canbe.board.controller

import com.canbe.board.dto.PostDto
import com.canbe.board.service.PostService
import com.canbe.board.util.ApiVersion
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(ApiVersion.FIRST_VERSION_API_PATH)
class PostExposedController(
    private val postService: PostService,
) {
    @GetMapping("/posts")
    fun getPosts(): List<PostDto> {
        return postService.getPosts()
    }

    @GetMapping("/posts/{postId}")
    fun getPostById(
        @PathVariable(name = "postId") postId: Int,
    ): PostDto? {
        return postService.getPostById(postId = postId)
    }

}
