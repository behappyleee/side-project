package com.canbe.board.repository

import com.canbe.board.dto.PostDto
import com.canbe.board.entity.PostEntity
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
class PostRepository {

    // TODO - Transactional 어노테이션 공부 필요 ... !
    // 해당 어노테이션 붙이니 exposed transaction { 문법이 필요 없어졌음 ... !
    fun findAllPosts(): List<PostDto> {
        return PostEntity.Post.all().map { PostDto.postEntityToPostDto(it) }
    }

    // TODO - !! 보다 더 좋은 방법이 있지 않을까 ... ?!
    fun findByPostId(postId: Int): PostDto {
        return PostDto.postEntityToPostDto(
            post = PostEntity.Post.findById(postId) ?:throw IllegalArgumentException("No Post !"),
        )
    }

    // TODO - Updade 구현하기 !
    fun updatePostByPostId(postId: Int) {


    }

    companion object {
        private val logger = LoggerFactory.getLogger(PostRepository::class.java)
    }

}
