package com.canbe.board.controller

import com.canbe.board.dto.CreatePostDto
import com.canbe.board.dto.PostDto
import com.canbe.board.dto.UpdatePostDto
import com.canbe.board.service.PostExposedService
import com.canbe.board.util.ApiVersion
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(ApiVersion.EXPOSED_FIRST_VERSION_API_PATH + "/posts")
class PostExposedController(
    private val postExposedService: PostExposedService,
) {
    @PostMapping
    fun createPosts(
        @RequestBody posts: List<CreatePostDto>,
    ): ResponseEntity<Unit> {
        postExposedService.createPosts(posts = posts)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @GetMapping
    fun getPosts(): List<PostDto> {
        return postExposedService.getPosts()
    }

    @GetMapping("/{postId}")
    fun getPostById(
        @PathVariable(name = "postId") postId: Int,
    ): PostDto {
        return postExposedService.getPostById(postId = postId)
    }

    @PatchMapping("/{postId}")
    fun updatePostByPostId(
        @PathVariable(name = "postId") postId: Int,
        @RequestBody post: UpdatePostDto,
    ): ResponseEntity<Unit> {
        postExposedService.updatePostByPostId(postId = postId, postDto = post)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @DeleteMapping("/{postId}")
    fun deletePostByPostId(
        @PathVariable(name = "postId") postId: Int,
    ): ResponseEntity<Unit> {
        postExposedService.deletePostByPostId(postId = postId)
        return ResponseEntity(HttpStatus.ACCEPTED)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(PostExposedController::class.java)
    }
}
