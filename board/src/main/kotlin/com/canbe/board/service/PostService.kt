package com.canbe.board.service

import com.canbe.board.dto.PostDto
import com.canbe.board.repository.PostRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@Service
class PostService(
    val postRepository: PostRepository,
) {

    // TODO - 내부 로직 구현 하기 !
    fun getPosts(): List<PostDto>? {
        val test = postRepository.findAllPosts()


        println(test.toString())
        logger.debug("[GET LOGGER DATA TEST CHECK ] : " + postRepository.findAllPosts())

        return null
    }

    fun getPostById(postId: Int): PostDto? {
        return null
    }

    companion object {
        private val logger = LoggerFactory.getLogger(PostService::class.java)
    }
}
