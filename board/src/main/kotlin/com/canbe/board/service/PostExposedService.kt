package com.canbe.board.service

import com.canbe.board.dto.CreatePostDto
import com.canbe.board.dto.PostDto
import com.canbe.board.dto.UpdatePostDto
import com.canbe.board.repository.PostExposedRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class PostExposedService(
    private val postExposedRepository: PostExposedRepository,
) {
    fun createPosts(posts: List<CreatePostDto>) {
        postExposedRepository.createPosts(posts = posts)
    }

    fun getPosts(): List<PostDto> {
        return postExposedRepository.findAllPosts()
    }

    // TODO - 내부 로직 구현 하기 .... !
    fun getPostById(postId: Int): PostDto {
        return postExposedRepository.findByPostId(postId = postId)
    }

    fun updatePostByPostId(
        postId: Int,
        postDto: UpdatePostDto,
    ) {
        postExposedRepository.updatePostByPostId(postId = postId, post = postDto)
    }

    fun deletePostByPostId(postId: Int) {
        postExposedRepository.deletePostByPostId(postId = postId)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(PostExposedService::class.java)
    }
}
