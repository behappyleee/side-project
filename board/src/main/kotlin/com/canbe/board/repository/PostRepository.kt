package com.canbe.board.repository

import com.canbe.board.entity.PostEntity
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
class PostRepository {
    // fun findAllPosts(): List<PostEntity.Post> {
    // fun findAllPosts(): List<Any>? {
    fun findAllPosts(): List<Any> {
        return PostEntity.Post.selectAll().toList()

///        logger.debug("POST DATA CHECK : {} ", PostEntity.Post.selectAll().firstOrNull())

//        val tess = PostEntity.Post.selectAll().firstOrNull()
//        println("GET TEST : " + tess)
//
//        val aa =
//            transaction {
//                val test = PostEntity.Post.selectAll().firstOrNull()
//                println("TEST : " + test)
//                logger.debug("[GET DAT TEST THFHF D] : {} ", test)
//            }
//
//        logger.debug("[GET DATA TEST CHECKCKC ] : {} ", aa)

//         return aa
        // return PostEntity.Post.select().where()
//        return PostEntity.Post.selectAll()
//            .toList() ?: null
//
    }
    companion object {
        private val logger = LoggerFactory.getLogger(PostRepository::class.java)
    }
}
