package com.canbe.board.service

import com.canbe.board.dto.PostDto
import com.canbe.board.dto.UpdatePostDto
import com.canbe.board.repository.PostRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class PostService(
    val postRepository: PostRepository,
) {
    fun getPosts(): List<PostDto> {
        return postRepository.findAllPosts()
    }

    // TODO - 내부 로직 구현 하기 .... !
    fun getPostById(postId: Int): PostDto {
        return postRepository.findByPostId(postId = postId)
    }

    fun updatePostByPostId(
        postId: Int,
        postDto: UpdatePostDto,
    ) {
        postRepository.updatePostByPostId(postId = postId, post = postDto)
    }

    fun deletePostByPostId(postId: Int) {
        postRepository.deletePostByPostId(postId = postId)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(PostService::class.java)
    }
}
