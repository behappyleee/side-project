package com.canbe.board.repository

import com.canbe.board.dto.CreatePostDto
import com.canbe.board.dto.PostDto
import com.canbe.board.dto.UpdatePostDto
import com.canbe.board.entity.PostEntity
import kotlinx.datetime.toKotlinLocalDateTime
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.update
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional(value = "exposedTransactionManager")
class PostExposedRepository {
    fun createPosts(posts: List<CreatePostDto>) {
        posts.forEach { post ->
            PostEntity.Posts.insert {
                it[title] = post.title
                it[content] = post.content
                it[writer] = post.writer
            }
        }
    }

    // TODO - Transactional 어노테이션 공부 필요 ... !
    // 해당 어노테이션 붙이니 exposed transaction { 문법이 필요 없어졌음 ... !
    fun findAllPosts(): List<PostDto> {
        val posts = PostEntity.Posts.selectAll().toList()
        return PostDto.resultRowToTest(resultRows = posts)
        // PostEntity.Posts.selectAll().map { post -> post. }
        // return PostEntity.Post.all().map { PostDto.postEntityToPostDto(it) }
    }

    // TODO - !! 보다 더 좋은 방법이 있지 않을까 ... ?!
    fun findByPostId(postId: Int): PostDto {
        return PostDto.postEntityToPostDto(
            post = PostEntity.Post.findById(postId) ?: throw IllegalArgumentException("No Post !"),
        )
    }

    // TODO - Posts 사용과 Post 를 그냥 바로 사용에는 어떤 차이점이 있을까  ... ?!
    fun updatePostByPostId(
        postId: Int,
        post: UpdatePostDto,
    ) {
        // POST Update 를 진행 시켜줄 시 어떻게 진행하는게 좋을까 .. ?!
        PostEntity.Posts.update(
            {
                PostEntity.Posts.id eq postId
            },
        ) {
            it[title] = post.title
            it[content] = post.content
            it[writer] = post.writer
            it[updatedAt] = post.updatedAt.toKotlinLocalDateTime()
        }
    }

    fun deletePostByPostId(postId: Int) {
        PostEntity.Posts.deleteWhere {
            PostEntity.Posts.id eq postId
        }
    }

    companion object {
        private val logger = LoggerFactory.getLogger(PostExposedRepository::class.java)
    }

}
