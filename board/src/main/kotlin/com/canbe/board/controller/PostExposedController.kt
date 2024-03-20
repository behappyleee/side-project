package com.canbe.board.controller

import com.canbe.board.dto.CreatePostDto
import com.canbe.board.dto.PostDto
import com.canbe.board.dto.UpdatePostDto
import com.canbe.board.service.PostService
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
@RequestMapping(ApiVersion.EXPOSED_FIRST_VERSION_API_PATH)
class PostExposedController(
    private val postService: PostService,
) {
    @PostMapping("/posts")
    fun createPosts(
        @RequestBody posts: List<CreatePostDto>,
    ): ResponseEntity<Unit> {
        postService.createPosts(posts = posts)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @GetMapping("/posts")
    fun getPosts(): List<PostDto> {
        return postService.getPosts()
    }

    @GetMapping("/posts/{postId}")
    fun getPostById(
        @PathVariable(name = "postId") postId: Int,
    ): PostDto {
        return postService.getPostById(postId = postId)
    }

    @PatchMapping("/posts/{postId}")
    fun updatePostByPostId(
        @PathVariable(name = "postId") postId: Int,
        @RequestBody post: UpdatePostDto,
    ): ResponseEntity<Unit> {
        postService.updatePostByPostId(postId = postId, postDto = post)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @DeleteMapping("/posts/{postId}")
    fun deletePostByPostId(
        @PathVariable(name = "postId") postId: Int,
    ): ResponseEntity<Unit> {
        postService.deletePostByPostId(postId = postId)
        return ResponseEntity(HttpStatus.ACCEPTED)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(PostExposedController::class.java)
    }
}
